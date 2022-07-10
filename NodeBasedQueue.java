/**
 * The third step in the development process is to use take the NodeBasedQueue<T> class and add
a toString method that overrides the one from the Object class to show all the Print Jobs in the
queue. Your project will also need to include QueueInterface<T>,
UnboundedQueueInterface<T> and the QueueEmptyException without the need for any
changes. This project uses the node based version because this printer should have no limit on
the number of requests that it can receive.

 * @author Joshua
 *
 * @param <T>
 */

public class NodeBasedQueue<T> implements UnBoundedQueueInterface<T> {

	//instance variables
	private Node<T> front; //refer to the Node object at the front of the queue
	private Node<T> rear; //refer to the Node object at the rear of the queue
	private int numberOfItems; 
	
	public NodeBasedQueue() {
		super();
		front = null;
		rear = null;
		numberOfItems = 0;
	}

	@Override
	public T dequeue() throws QueueEmptyException {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			throw new QueueEmptyException("Dequeue attempted on an empty Queue!");
		}
		else {
			T frontItem = front.getData();
			front = front.getLink();  //have front refer to the next item in the queue
			if(front == null) {  
				rear = null;  
			}
			numberOfItems--;
			return frontItem;
		}
	}

	@Override
	public String look() {
		// TODO Auto-generated method stub
		String frontItem;
		if(isEmpty()) {
			frontItem = "Queue is Empty";
		}
		else {
			frontItem = front.getData().toString();
		}
		return frontItem;
	}

	@Override
	public void enqueue(T item) {
		// TODO Auto-generated method stub
		Node<T> currentNode = new Node<T>(item);
		if(isEmpty()) {
			front = currentNode;
			rear = currentNode;
			numberOfItems++;
		}
		else {
			rear.setLink(currentNode);
			rear = currentNode;
			numberOfItems++;
		}
		
		//rear = currentNode;
		//numberOfItems++; //refactoring is the process of changing the non-functional nature of a program/code
	}

	@Override
	public boolean isEmpty() {
		boolean empty = false;
		if(front == null && rear == null && numberOfItems == 0) {
			empty = true;
		}
		return empty;
	}
	
	public String toString() {
		String queueInfo = "Queue: " + "\n";
		Node<T> currentNode = front;
		while(currentNode != null) {
			queueInfo = queueInfo + "\n" + currentNode.getData();
			currentNode = currentNode.getLink();
		}
		return queueInfo;
	}

}
