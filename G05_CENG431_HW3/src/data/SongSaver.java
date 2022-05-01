
package data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import model.models.song.Song;

public class SongSaver implements IDataSaver<Song> {
	private final File file;

	public SongSaver(String pathname) {
		this.file = new File(pathname);
	}

	@Override
	public void save(List<Song> data) {
//		JSONArray list = new JSONArray();
//
//		JSONObject songJson;
//		for (Song song : data) {
//			songJson = new JSONObject();
//
//			songJson.put("song_id", song.getId());
//
//			songJson.put("name", song.getName());
//			songJson.put("brand_name", song.getBrandName());
//			songJson.put("gender", song.getGender());
//			songJson.put("type", song.getType());
//			songJson.put("color", song.getColor());
//			songJson.put("available_sizes", song.getSizes());
//			songJson.put("occasion", song.getOccasion());
//			songJson.put("comments", song.getComments());
//			songJson.put("liked_users", song.getLikedUserIds());
//			songJson.put("disliked_users", song.getDislikedUserIds());
//
//			list.put(songJson);
//		}

		try {
			PrintWriter myFile = new PrintWriter(file);
			for (Song song : data) {
				myFile.println(song.toString());
			}
//			myFile.write(list.toString(2));
			myFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
