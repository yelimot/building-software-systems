package data;

public class Statistics implements IStatistics {
	private IMonitor<Outfit, OutfitEvent> mostLikedOutfitMonitor;
	private IMonitor<Outfit, OutfitEvent>  mostDislikedOutfitMonitor;
	private IMonitor<User, UserEvent>  mostFollowedUserMonitor;
	
	public Statistics(IRepository<User> usersRepo, IRepository<Outfit> outfitsRepo) {
		mostLikedOutfitMonitor = new MostLikedOutfitMonitor(outfitsRepo);
		mostDislikedOutfitMonitor = new MostDislikedOutfitMonitor(outfitsRepo);
		mostFollowedUserMonitor = new MostFollowedUserMonitor(usersRepo);
	}
	
	@Override
	public Outfit getMostLikedOutfit() {
		return mostLikedOutfitMonitor.get();
	}

	@Override
	public Outfit getMostDislikedOutfit() {
		return mostDislikedOutfitMonitor.get();
	}

	@Override
	public User getMostFollowedUser() {
		return mostFollowedUserMonitor.get();
	}
}
