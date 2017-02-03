
public class GenericLinkedList<T extends Comparable<T>> {
	private class Node {
		T data;
		Node next;

		Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node head;
	private Node tail;
	private int size;

	public GenericLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	private GenericLinkedList(Node head, Node tail, int size) {
		this.head = head;
		this.tail = tail;
		this.size = size;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void display() {
		Node node = this.head;

		while (node != null) {
			System.out.print(node.data + " => ");
			node = node.next;
		}

		System.out.println("END");
	}

	public T getFirst() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}

		return this.head.data;
	}

	public T getLast() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}

		return this.tail.data;
	}

	public T getAt(int idx) throws Exception {
		Node node = this.getNodeAt(idx);
		return node.data;
	}

	private Node getNodeAt(int idx) throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}

		if (idx < 0 || idx >= this.size()) {
			throw new Exception("Invalid arguments");
		}

		int counter = 0;
		Node retVal = this.head;
		while (counter < idx) {
			retVal = retVal.next;
			counter++;
		}

		return retVal;
	}

	public void addFirst(T item) {
		Node node = new Node(item, this.head);
		this.head = node;

		if (this.size() == 0) {
			this.tail = node;
		}

		this.size++;
	}

	public void addLast(T item) {
		Node node = new Node(item, null);

		if (this.size() == 0) {
			this.head = this.tail = node;
		} else {
			this.tail.next = node;
			this.tail = node;
		}

		this.size++;
	}

	public void addAt(int idx, T item) throws Exception {
		if (idx < 0 || idx > this.size()) {
			throw new Exception("Invalid arguments");
		}

		if (idx == 0) {
			this.addFirst(item);
		} else if (idx == this.size()) {
			this.addLast(item);
		} else {
			Node nm1 = this.getNodeAt(idx - 1);
			Node n = nm1.next;

			Node node = new Node(item, n);
			nm1.next = node;

			this.size++;
		}
	}

	public T removeFirst() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}

		T retVal = this.head.data;

		if (this.size() == 1) {
			this.head = this.tail = null;
		} else {
			this.head = this.head.next;
		}

		this.size--;

		return retVal;
	}

	public T removeLast() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}

		T retVal = this.tail.data;

		if (this.size() == 1) {
			this.head = this.tail = null;
		} else {
			Node sm2 = this.getNodeAt(this.size() - 2);

			sm2.next = null;
			this.tail = sm2;
		}

		this.size--;

		return retVal;
	}

	public T removeAt(int idx) throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}

		if (idx < 0 || idx >= this.size()) {
			throw new Exception("Invalid arguments");
		}

		if (idx == 0) {
			return this.removeFirst();
		} else if (idx == this.size() - 1) {
			return this.removeLast();
		} else {
			Node nm1 = this.getNodeAt(idx - 1);
			Node n = nm1.next;
			Node np1 = nm1.next.next;

			nm1.next = np1;
			this.size--;

			return n.data;
		}
	}

	/* Questions start form here */
	public void reverse_Iteratively_Data() throws Exception {
		int left = 0, right = this.size() - 1;

		while (left <= right) {
			Node leftNode = this.getNodeAt(left);
			Node rightNode = this.getNodeAt(right);

			T temp = leftNode.data;
			leftNode.data = rightNode.data;
			rightNode.data = temp;

			left++;
			right--;
		}
	}

	public void reverse_Iteratively_Pointers() {
		Node prev = this.head;
		Node curr = prev.next;

		while (curr.next != null) {
			Node tp = prev;
			Node tc = curr;

			prev = curr;
			curr = curr.next;

			tc.next = tp;
		}

		// Swap head and tail
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;

		// Resolve new tail
		this.tail.next = null;

		// Resolve new head
		this.head.next = prev;
	}

	public void reverse_Recursive_Data() {
		this.reverse_Recursive_Data(this.head, 0);

	}

	private Node reverse_Recursive_Data(Node node, int level) {

		if (node == null) {

			return this.head;

		}
		Node front = this.reverse_Recursive_Data(node.next, level + 1);
		if (level >= this.size() / 2) {
			T temp = front.data;
			front.data = node.data;
			node.data = temp;

		}
		return front.next;
	}

	public void reverse_Recursive_Pointers() {
		this.reverse_Recursive_Pointers(this.head);
		// resolve head and tail
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
		// resolve new tail
		this.tail.next = null;

	}

	private void reverse_Recursive_Pointers(Node node) {
		if (node == this.tail) {
			return;

		}
		this.reverse_Recursive_Pointers(node.next);
		node.next.next = node;

	}

	private class Encapsulator {
		Node left;

	}

	public void reverse_Recursion_Data_Another() {
		Encapsulator enc = new Encapsulator();
		enc.left = this.head;
		this.reverse_Recursion_Data_Another(enc, this.head, 0);
	}

	private void reverse_Recursion_Data_Another(Encapsulator enc, Node right, int level) {
		if (right == null) {
			return;
		}
		this.reverse_Recursion_Data_Another(enc, right.next, level + 1);
		if (level >= this.size() / 2) {
			T temp = enc.left.data;
			enc.left.data = right.data;
			right.data = temp;
			enc.left = enc.left.next;
		}
	}

	public T mid() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}
		return this.midNode(this.head, this.head).data;
	}

	private Node midNode(Node fast, Node slow) throws Exception {
		
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	public T kthItemFromEnd(int k) throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}
		if (k < 1 || k > this.size()) {
			throw new Exception("Invalid Arguements");
		}
		return this.kthNode(this.head, this.head, k);
	}

	private T kthNode(Node fast, Node slow, int k) throws Exception {
		for (int i = 1; i <= k; i++) {
			fast = fast.next;

		}
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow.data;
	}

	public GenericLinkedList<T> merge(GenericLinkedList<T> other) {
		GenericLinkedList<T> retval = new GenericLinkedList<>();
		Node thisTemp = this.head, otherTemp = other.head;
		while (thisTemp != null && otherTemp != null) {
			if ((thisTemp.data).compareTo(otherTemp.data) < 0) {
				retval.addLast(thisTemp.data);
				thisTemp = thisTemp.next;
			} else {
				retval.addLast(otherTemp.data);
				otherTemp = otherTemp.next;
			}
		}
		while (thisTemp != null) {
			retval.addLast(thisTemp.data);
			thisTemp = thisTemp.next;
		}
		while (otherTemp != null) {
			retval.addLast(otherTemp.data);
			otherTemp = otherTemp.next;
		}
		return retval;
	}

	public void mergesort() throws Exception {
		GenericLinkedList<T> sorted = this.mergesorthelper();
		this.head = sorted.head;
		this.tail = sorted.tail;
		this.size = sorted.size;
	}

	public GenericLinkedList<T> mergesorthelper() throws Exception {
		if (this.size() == 1) {
			return this;
		}
		Node mid = this.midNode(this.head, this.head);
		Node midNext = mid.next;
		mid.next = null;
		GenericLinkedList<T> fhalf = new GenericLinkedList<>(this.head, mid, (this.size + 1 )/2);
		GenericLinkedList<T> shalf = new GenericLinkedList<>(midNext, this.tail, this.size/2);
		fhalf = fhalf.mergesorthelper();
		shalf = shalf.mergesorthelper();
		GenericLinkedList<T> sorted = fhalf.merge(shalf);

		return sorted;
	}

}
