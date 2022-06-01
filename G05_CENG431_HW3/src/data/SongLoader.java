package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.enums.Genre;
import model.models.song.Song;

public class SongLoader implements IDataLoader<Song> {
	private final String path;
	
	public SongLoader(String pathname) {
		this.path = pathname;
	}
	
	@Override
	public List<Song> load() throws NumberFormatException, IOException {
        
		List<Song> songs = new ArrayList<>();		
		
		@SuppressWarnings("resource")
		BufferedReader txtReader = new BufferedReader(new FileReader(path));
	    String row;
	    while ((row = txtReader.readLine()) != null) {
	           String[] listOfAttributes = row.split(",");
	           Genre genre = null;
	           switch (listOfAttributes[0]) {
	                case "1":
	                    genre = Genre.Acoustic;
	                    break;
	                case "2":
	                    genre = Genre.Instrumental;
	                    break;
	                case "3":
	                    genre = Genre.Rock;
	                    break;
	                case "4":
	                    genre = Genre.Hiphop;
	                    break;
	                case "5":
	                    genre = Genre.Jazz;
	                    break;
	                case "6":
	                    genre = Genre.Pop;
	                    break;           
	                default:
	                    break;
	           }
	           int songId = Integer.valueOf(listOfAttributes[1]);
	           String songName = listOfAttributes[2];
	           String artistName = listOfAttributes[3];
	           int duration = Integer.valueOf(listOfAttributes[4]);
	           int popularity = Integer.valueOf(listOfAttributes[5]);
	           int numberOfLikes = Integer.valueOf(listOfAttributes[6]);

	           Song song = new Song(genre, songId, songName, artistName, duration, popularity, numberOfLikes);

			songs.add(song);
		}

		return songs;
	}
}
