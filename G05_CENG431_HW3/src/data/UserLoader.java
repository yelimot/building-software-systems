package data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import model.models.playlist.Playlist;
import model.models.song.Song;
import model.models.user.User;
import model.utils.IRepository;

public class UserLoader implements IDataLoader<User> {
	private final File file;
	private final IRepository<Song> songRepository;

	public UserLoader(String pathname, IRepository<Song> songRepository) {
		this(new File(pathname), songRepository);
	}

	public UserLoader(File file, IRepository<Song> songRepository) {
		this.file = file;
		this.songRepository = songRepository;
	}

	@Override
	public List<User> load() {
		List<User> users = new ArrayList<User>();
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document document = builder.parse(file);

			document.getDocumentElement().normalize();

			Element root = document.getDocumentElement();

			NodeList userList = root.getElementsByTagName("user");

			for (int i = 0; i < userList.getLength(); ++i) {
				Node node = userList.item(i);
				Element eElement = (Element) node;
				String username = eElement.getElementsByTagName("username").item(0).getTextContent();
				String password = eElement.getElementsByTagName("password").item(0).getTextContent();

				User tempUser = new User(username, password);

				NodeList playlistList = eElement.getElementsByTagName("playlist");

				Element firstElement = (Element) playlistList.item(0);
				
				if (firstElement != null && firstElement.hasChildNodes()) {
					for (int j = 0; j < playlistList.getLength(); ++j) {
						Node playlistNode = playlistList.item(j);
						Element pElement = (Element) playlistNode;
						String name = pElement.getElementsByTagName("name").item(0).getTextContent();

						Playlist tempPlaylist = new Playlist(name);

						NodeList songList = pElement.getElementsByTagName("id");
						for (int k = 0; k < songList.getLength(); ++k) {
							String songId = songList.item(k).getTextContent();
							tempPlaylist.add(songRepository.get(Integer.valueOf(songId)).get());
						}
						tempUser.addPlaylist(tempPlaylist);
					}
				}
				users.add(tempUser);
			}

			for (int i = 0; i < userList.getLength(); ++i) {
				Node node = userList.item(i);
				Element eElement = (Element) node;

				Node followed = eElement.getElementsByTagName("followedUsers").item(0);
				NodeList followedList = ((Element) followed).getElementsByTagName("id");
				for (int j = 0; j < followedList.getLength(); ++j) {
					String userId = followedList.item(j).getTextContent();
					User followedUser = users.stream().filter(u -> userId.equals(u.getUsername())).findFirst().get();
					users.get(i).follow(followedUser);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return users;
	}

}
