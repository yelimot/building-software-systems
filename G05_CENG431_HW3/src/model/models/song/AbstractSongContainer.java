package model.models.song;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import model.utils.AbstractObservable;
import model.utils.IEvent;
import model.utils.IRepository;

public abstract class AbstractSongContainer<T, K extends IEvent<T>>
	extends AbstractObservable<T, K> 
	implements IRepository<Song> 
{
	private final SortedSet<Song> songs;
	
	public AbstractSongContainer() {
		this.songs = new TreeSet<>();
	}

	@Override
	public Optional<Song> get(Object id) {
		return songs.stream().filter(u -> (Integer) u.getId() == id).findFirst();
	}

	@Override
	public Optional<Song> get(Predicate<Song> predicate) {
		return songs.stream().filter(predicate).findFirst();
	}

	@Override
	public List<Song> getAll() {
		return new ArrayList<>(songs);
	}

	@Override
	public List<Song> getAll(Predicate<Song> predicate) {
		return songs.stream().filter(predicate).collect(Collectors.toList());
	}
	
	public boolean add(Song song) {
		return songs.add(song);
	}
	
	public boolean remove(Song song) {
		return songs.remove(song);
	}
}
