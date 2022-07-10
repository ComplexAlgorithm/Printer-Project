
public interface UnBoundedQueueInterface<T> extends QueueInterface<T> {
	
	//override the push method from QueueInterface
	//add an item to the rear of the queue
	public void enqueue(T item);
	
	//add additional methods in a child interface
	//classes that implement this interface will need to include these additional methods
	//returns true if the queue is empty else returns false
	public boolean isEmpty();
}


