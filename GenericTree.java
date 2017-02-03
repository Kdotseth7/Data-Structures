import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class GenericTree {
	private class Node {
		int data;
		ArrayList<Node> children;

		Node(int data, ArrayList<Node> children) {
			this.data = data;
			this.children = children;

		}

	}

	private Node root;
	private int size;

	public GenericTree() {
		Scanner scn = new Scanner(System.in);
		this.root = this.takeInput(scn, null, -1);

	}

	public Node takeInput(Scanner scn, Node parent, int ithchild) {
		if (parent == null) {
			System.out.println("Enter data for root node:");

		} else {
			System.out.println("Enter data for " + ithchild + "th child of " + parent.data + ":");
		}
		int cData = scn.nextInt();
		System.out.println();
		System.out.println("Enter the no. of children for " + cData + ":");
		int numgc = scn.nextInt();
		Node child = new Node(cData, new ArrayList<>());
		this.size++;
		for (int i = 0; i < numgc; i++) {
			Node gc = this.takeInput(scn, child, i + 1);
			child.children.add(gc);

		}
		return child;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size() == 0;

	}

	public void display() {
		System.out.println(this);

	}

	@Override
	public String toString() {
		return this.toString(this.root);
	}

	private String toString(Node node) {
		String retval = "";
		retval += node.data + "=>";
		for (int i = 0; i < node.children.size(); i++) {
			retval += node.children.get(i).data + ", ";

		}
		retval += "END\n";
		for (int i = 0; i < node.children.size(); i++) {
			retval += this.toString(node.children.get(i));

		}
		return retval;
	}
	/* Questions start from here */

	// To find the maximum value in a Generic Tree
	public int max() {
		return this.max(root);
	}

	private int max(Node node) {

		int retval = node.data;

		for (int i = 0; i < node.children.size(); i++) {
			int cmax = this.max(node.children.get(i));
			if (cmax > retval) {
				retval = cmax;
			}

		}
		return retval;

	}

	// To find size without using upper size() function
	public int size2() {
		return this.size2(this.root);
	}

	private int size2(Node node) {
		int retval = 0;
		for (int i = 0; i < node.children.size(); i++) {
			retval += this.size2(node.children.get(i));

		}
		retval = retval + 1;
		return retval;
	}

	// To find an element in a Generic Tree
	public boolean find(int data) {
		return this.find(this.root, data);
	}

	private boolean find(Node node, int data) {
		if (node.data == data) {
			return true;
		}
		for (int i = 0; i < node.children.size(); i++) {
			boolean FoundInChild = this.find(node.children.get(i), data);

			if (FoundInChild) {
				return true;
			}
		}
		return false;
	}

	// To determine the height of the tree
	public int height() {
		return this.height(root);

	}

	private int height(Node node) {

		int retval = -1;

		for (int i = 0; i < node.children.size(); i++) {
			int cheight = this.height(node.children.get(i));
			if (cheight > retval) {
				retval = cheight;
			}

		}
		retval++;
		return retval;
	}

	public void PrintAtLevel(int k) {
		this.PrintAtLevel(this.root, k);
	}

	private void PrintAtLevel(Node node, int k) {
		if (k == 0) {
			System.out.print(node.data + ", ");
			return;
		}
		for (int i = 0; i < node.children.size(); i++) {
			this.PrintAtLevel(node.children.get(i), k - 1);

		}
	}

	public Integer JustLarger(int data) {

		if (this.JustLarger(this.root, data) == null) {
			return null;
		} else {
			return this.JustLarger(this.root, data).data;
		}
	}

	private Node JustLarger(Node node, int data) {
		Node retval = null;
		for (int i = 0; i < node.children.size(); i++) {
			Node childval = this.JustLarger(node.children.get(i), data);
			if (childval != null) {
				if (retval != null) {
					if (childval.data < retval.data) {
						retval = childval;
					}
				} else {
					retval = childval;
				}
			}
		}
		if (node.data > data) {
			if (retval != null) {
				if (node.data < retval.data) {
					retval = node;
				}
			} else {
				retval = node;
			}
		}
		return retval;

	}

	public int kthSmallest(int k) {
		int retval = Integer.MIN_VALUE;
		int counter = 0;
		while (counter < k) {
			retval = JustLarger(retval);
			counter++;
		}
		return retval;

	}

	public int maxSONC() {
		return this.maxSONC(this.root).data;
	}

	private Node maxSONC(Node node) {
		Node retval = node;
		for (int i = 0; i < node.children.size(); i++) {
			Node cmax = this.maxSONC(node.children.get(i));
			if (this.maxonscore(cmax) > this.maxonscore(retval)) {
				retval = cmax;
			}
		}
		return retval;
	}

	private int maxonscore(Node node) {
		System.out.println("Hi");
		int retval = node.data;
		for (int i = 0; i < node.children.size(); i++) {
			retval += node.children.get(i).data;
		}
		return retval;

	}

	public int maxSONCBtr() {
		return this.maxSONCBtr(this.root).node.data;
	}

	private SONCPair maxSONCBtr(Node node) {
		SONCPair retval = new SONCPair(node);
		for (int i = 0; i < node.children.size(); i++) {
			SONCPair cmax = this.maxSONCBtr(node.children.get(i));
			if (cmax.score > retval.score) {
				retval = cmax;
			}
		}
		return retval;
	}

	private class SONCPair {
		Node node;
		int score;

		SONCPair(Node node) {
			System.out.println("Hello");
			this.node = node;
			int retval = node.data;
			for (int i = 0; i < node.children.size(); i++) {
				retval += node.children.get(i).data;
				this.score = retval;
			}

		}
	}

	// Preorder Traversal by Recursion
	public void Preorder() {
		this.Preorder(this.root);
		System.out.println("END");
	}

	private void Preorder(Node node) {
		System.out.print(node.data + ", ");
		for (int i = 0; i < node.children.size(); i++) {
			Preorder(node.children.get(i));
		}
	}

	// Postorder Traversal by Recursion
	public void Postorder() {
		this.Postorder(this.root);
		System.out.println("END");
	}

	private void Postorder(Node node) {

		for (int i = 0; i < node.children.size(); i++) {
			Postorder(node.children.get(i));
		}
		System.out.print(node.data + ", ");
	}

	// Preorder Iterative
	public void PreorderIterative() {
		Stack<Node> stack = new Stack<>();
		stack.push(this.root);
		while (!stack.isEmpty()) {
			Node temp = stack.pop();
			System.out.print(temp.data + ", ");
			for (int i = temp.children.size() - 1; i >= 0; i--) {
				stack.push(temp.children.get(i));
			}
		}
		System.out.println("END");
	}

	// Level Order Traversal
	public void LevelOrder() {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(this.root);
		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			System.out.print(temp.data + ", ");
			for (int i = 0; i < temp.children.size(); i++) {
				queue.offer(temp.children.get(i));
			}

		}
		System.out.println("END");
	}
}
