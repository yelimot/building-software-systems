package data;

import java.util.stream.Stream;

import model.enums.PlaylistEvent;
import model.enums.UserEvent;
import model.models.playlist.Playlist;
import model.models.user.User;
import model.utils.IRepository;



public class UserMonitoredSaver implements IDataMonitoredSaver<User, UserEvent> {
	private final IRepository<User> userRepo;
	
	public UserMonitoredSaver(IRepository<User> userRepo) {
		this.userRepo = userRepo;
		
		userRepo.getAll().forEach(u -> {
			subscribeToAllEvents(u);
			
			u.getCollections().forEach(this::subscribeToAllEvents);
		});
	}

	@Override
	public void update(UserEvent event) {
		switch (event) {
			case ADD_COLLECTION:
				event.getSubject().getCollections().forEach(this::subscribeToAllEvents);
			default:
				userRepo.save();
				break;
		}
	}

	private void subscribeToAllEvents(User user) {
		Stream.of(UserEvent.values()).forEach(e -> user.subscribe(e, this));
	}
	
	private void subscribeToAllEvents(Playlist playlist) {
		Stream.of(PlaylistEvent.values()).forEach(e -> playlist.subscribe(e, userCollectionMonitoredSaver));
	}
	
	private IDataMonitoredSaver<Playlist, PlaylistEvent> userCollectionMonitoredSaver = new IDataMonitoredSaver<>() {
		@Override
		public void update(PlaylistEvent event) {
			userRepo.save();
		}
	};
}
