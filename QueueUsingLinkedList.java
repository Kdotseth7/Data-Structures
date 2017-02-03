
public class QueueUsingLinkedList {

	private LinkedList list;

	public QueueUsingLinkedList() {
		this.list = new LinkedList();

	}

	public int size() {
		return this.list.size();

	}

	public boolean isEmpty() {
		return this.list.isEmpty();
	}

	public void display() {
		this.list.display();
	}

	public void enqueue(int item) throws Exception {
		this.list.addLast(item);
	}

	public int dequeue() throws Exception {
		return this.list.removeFirst();
	}

	public int front() throws Exception {
		return this.list.getFirst();
	}

}
