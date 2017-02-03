
public class QueueUsingArrays {

	private int[] data;
	private int front;
	private int size;
	public static final int def_cap = 10;

	public QueueUsingArrays() throws Exception {
		this(def_cap);

	}

	public QueueUsingArrays(int cap) throws Exception {
		if (cap < 1) {
			throw new Exception("Invalid Capacity");
		}
		this.data = new int[cap];
		this.front = 0;
		this.size = 0;

	}

	public int size() {
		int retval = this.size;
		return retval;

	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public int front() throws Exception {
		if (this.isEmpty()) {

			throw new Exception("Queue is Empty");
		}
		int retval = this.data[this.front];
		return retval;
	}

	public void enqueue(int item) throws Exception {
		if (this.size() == this.data.length) {
			throw new Exception("Queue is Full"); // Overflow Condition
		}

		int ai = (front + size) % (data.length);
		this.data[ai] = item;
		this.size++;
	}

	public int dequeue() throws Exception {
		if (this.isEmpty()) {

			throw new Exception("Queue is Empty");
		}

		int retval = this.data[this.front];
		this.data[this.front] = 0;
		this.front = (this.front + 1) % this.data.length;
		this.size--;
		return retval;

	}

	public void display() {

		for (int i = 0; i < this.size; i++) {

			int ai = (front + i) % this.data.length;
			System.out.print(this.data[ai] + "<= ");
		}
		System.out.println("END");
	}
}
