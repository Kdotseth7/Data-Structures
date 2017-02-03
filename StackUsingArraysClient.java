
public class StackUsingArraysClient {

	public static void main(String[] args) throws Exception {
		boolean exp = bracket("({(a+b)})");
		System.out.println(exp);
		// StackUsingArrays stack = new DynamicStack(5);
	}

	// for(int i = 0; i < 10; i++){
	// stack.push(i);
	// displayStackStats(stack);
	// }
	//
	// while(!stack.isEmpty()){
	// System.out.println(stack.top());
	// System.out.println(stack.pop());
	// displayStackStats(stack);
	// }
	//
	//// stack.pop();
	// }
	//
	// public static void displayStackStats(StackUsingArrays stack){
	// System.out.println("*****************************************");
	// stack.display();
	// System.out.println(stack.size());
	// System.out.println(stack.isEmpty());
	// System.out.println("*****************************************");
	// }
	//
	//

	/* Bracket Evaluation */

	public static boolean bracket(String a) throws Exception {
		StackUsingArrays stack = new DynamicStack(5);

		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == '[' || a.charAt(i) == '{' || a.charAt(i) == '(') {
				stack.push(a.charAt(i));
			} else if (a.charAt(i) == ']') {
				if (stack.isEmpty())
					return false;

				char tc = (char) stack.top();

				if (tc == '[') {
					stack.pop();
				} else {
					return false;
				}

			} else if (a.charAt(i) == '}') {
				if (stack.isEmpty())
					return false;

				char tc = (char) stack.top();

				if (tc == '{') {
					stack.pop();
				} else {
					return false;
				}
			}

			else if (a.charAt(i) == ')')

			{
				if (stack.isEmpty())
					return false;

				char tc = (char) stack.top();

				if (tc == '(') {
					stack.pop();
				} else {
					return false;
				}
			}
		}

		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

}
