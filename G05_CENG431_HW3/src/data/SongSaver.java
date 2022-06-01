
package data;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import model.models.song.Song;

public class SongSaver implements IDataSaver<Song> {
	private final File file;

	public SongSaver(String pathname) {
		this.file = new File(pathname);
	}

	@Override
	public void save(List<Song> data) {
		try {
			PrintWriter myFile = new PrintWriter(file);
			for (Song song : data) {
				myFile.println(song.toString());
			}
			myFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
