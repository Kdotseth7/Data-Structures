
public class QueueUsingLinkedListClient {

	public static void main(String[] args) throws Exception {

		QueueUsingLinkedList list = new QueueUsingLinkedList();

		for (int i = 0; i < 10; i++) {
			list.enqueue(i);
			displayQueueStats(list);
		}

		while (!list.isEmpty()) {
			System.out.println(list.front());
			System.out.println(list.dequeue());
			displayQueueStats(list);
		}

		// stack.pop();
	}

	public static void displayQueueStats(QueueUsingLinkedList list) {
		System.out.println("*****************************************");
		list.display();
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		System.out.println("*****************************************");
	}

}
