package data;

import java.util.stream.Stream;


public class OutfitMonitoredSaver implements IDataMonitoredSaver<Outfit, OutfitEvent> {
	private final IRepository<Outfit> userRepo;
	
	public OutfitMonitoredSaver(IRepository<Outfit> userRepo) {
		this.userRepo = userRepo;
		
		userRepo.getAll().forEach(this::subscribeToAllEvents);
	}

	@Override
	public void update(OutfitEvent event) {
		userRepo.save();
	}

	private void subscribeToAllEvents(Outfit outfit) {
		Stream.of(OutfitEvent.values()).forEach(e -> outfit.subscribe(e, this));
	}
}
