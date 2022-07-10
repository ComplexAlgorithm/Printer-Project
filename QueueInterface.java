

public interface QueueInterface<T> {
	
	/**
	 * Adds an item to the rear of the queue if there is room,
	 * otherwise throws QueueFullException
	 * @param item will be added to the rear of the queue if there is room in the queue
	 * @throws QueueFullException is thrown when there isn't room for any more items in the queue
	 */
	public void enqueue(T item);
	
	/**
	 * Removes the item at the front of the queue if there is one and returns it,
	 * otherwise throws QueueEmptyException
	 * @return item at the front of the queue which has been removed will be returned
	 * @throws QueueEmptyException is thrown when the queue is empty
	 */
	public T dequeue() throws QueueEmptyException;
	
	/**
	 * Returns a String representation of the item at the front of the queue
	 * if there is one, otherwise it returns the String "Queue is Empty!"
	 * @return String representation of the item at the front of the queue or "Queue is Empty!" if the queue is empty
	 */
	public String look();
}


