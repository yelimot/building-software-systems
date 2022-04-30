package data;

import model.utils.IEvent;
import model.utils.IObserver;

public interface IDataMonitoredSaver<T, K extends IEvent<T>> extends IObserver<T, K> {
	
}
