package model.enums;

public enum Genre {
	Acoustic,
	Instrumental,
	Rock,
	Hiphop,
	Jazz,
	Pop;
	
    public static int fromGenre(Genre genre) {
        switch(genre) {
        case Acoustic:
            return 1;
        case Instrumental:
            return 2;
        case Rock:
            return 3;
        case Hiphop:
            return 4;
        case Jazz:
            return 5;
        case Pop:
            return 6;
        }
        return 0;
    }
}