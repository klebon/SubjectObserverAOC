package future;

import userProxy.Callable;

public interface ScheduledExecutorService {
	//https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ScheduledExecutorService.html
	public void schedule(Callable c, int duration);
}
