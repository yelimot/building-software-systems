package model.enums;

public enum Genre {
	Acoustic(1),
	Instrumental(2),
	Rock(3),
	Hiphop(4),
	Jazz(5),
	Pop(6);
	
	int id;
	Genre(int i) {
		id = i;
	}
	
	public int getId() {
		return id;
	}
}