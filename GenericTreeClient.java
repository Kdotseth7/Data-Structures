
public class GenericTreeClient {

	public static void main(String[] args) {
		// 10 3 20 2 50 0 60 0 30 2 70 1 100 0 80 0 40 1 90 0
		GenericTree gt = new GenericTree();
		System.out.println("DISPLAY:--->");
		gt.display();
		System.out.println(gt.max());
		System.out.println(gt.height());
		System.out.println(gt.size2());
		System.out.println(gt.find(100));
		System.out.println(gt.find(1000));
		gt.PrintAtLevel(2);
		System.out.println(gt.JustLarger(75));
		System.out.println(gt.JustLarger(105));
		System.out.println(gt.kthSmallest(3));
		System.out.println(gt.maxSONC());
		System.out.println("************************************************");
		System.out.println(gt.maxSONCBtr());
		System.out.println("Preorder-->");
		gt.Preorder();
		System.out.println("Postorder-->");
		gt.Postorder();
		System.out.println("Preorder Iterative-->");
		gt.PreorderIterative();
		System.out.println("Level Order-->");
		gt.LevelOrder();
	}
}
