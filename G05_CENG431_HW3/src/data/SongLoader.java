package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.json.*;

import model.models.song.Song;

public class SongLoader implements IDataLoader<Song> {
	private final String path;
	
	public SongLoader(String pathname) {
		this.path = pathname;
	}
	
	@Override
	public List<Song> load() {
		InputStream is = null;
		try {
			is = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		JSONTokener tokener = new JSONTokener(is);
        JSONArray object = new JSONArray(tokener);
        
		List<Song> songs = new ArrayList<>();

		for(Object obj: object) {
			JSONObject jsonField = (JSONObject) obj;
			
			int songId = jsonField.getInt("song_id");
			String name = jsonField.getString("name");
			String brandName = jsonField.getString("brand_name");

			SongGender gender = SongGender.valueOf(jsonField.getString("gender"));
			SongType type = SongType.valueOf(jsonField.getString("type"));
			SongOccasion occasion = SongOccasion.valueOf(jsonField.getString("occasion"));
			SongColor color = SongColor.valueOf(jsonField.getString("color"));
			
			JSONArray sizeJsonArray = jsonField.getJSONArray("available_sizes");
			List<SongSize> sizes = new LinkedList<>();
			for(Object size: sizeJsonArray) {
				sizes.add(SongSize.valueOf(size.toString()));
			}
			Song song = new Song(songId, name, brandName, gender, type, occasion, color, sizes.toArray(SongSize[]::new));

			JSONArray commentJsonArray = jsonField.getJSONArray("comments");
			for(Object commentObject: commentJsonArray) {
				JSONObject comment = (JSONObject) commentObject;
				String authorId = comment.getString("author");
				String message = comment.getString("text");
				song.addComment(new Comment(authorId, message));
			}
			
			JSONArray likedJsonArray = jsonField.getJSONArray("liked_users");
			for(Object user: likedJsonArray) {
				song.addLike(user.toString());
			}

			songs.add(song);
		}

		return songs;
	}
}
