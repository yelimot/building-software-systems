package data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SongSaver implements IDataSaver<Song> {
	private final File file;
	
	public SongSaver(String pathname) {
		this.file = new File(pathname);
	}

	@Override
	public void save(List<Song> data) {
		JSONArray list = new JSONArray();
		
		JSONObject songJson;
		for (Song song: data) {
			songJson = new JSONObject();
			
			songJson.put("song_id", song.getId());
			songJson.put("name", song.getName());
			songJson.put("brand_name", song.getBrandName());
			songJson.put("gender", song.getGender());
			songJson.put("type", song.getType());
			songJson.put("color", song.getColor());
			songJson.put("available_sizes", song.getSizes());
			songJson.put("occasion", song.getOccasion());
			songJson.put("comments", song.getComments());
			songJson.put("liked_users", song.getLikedUserIds());
			songJson.put("disliked_users", song.getDislikedUserIds());
			
			list.put(songJson);
		}
				
		try {
			FileWriter myFile = new FileWriter(file);
			myFile.write(list.toString(2));
			myFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
