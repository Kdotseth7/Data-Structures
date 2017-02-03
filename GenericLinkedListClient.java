
public class GenericLinkedListClient {

	public static void main(String[] args) throws Exception {
		GenericLinkedList<Student> lp = new GenericLinkedList<>();
		lp.addLast(new Student(50, "abc"));
		lp.addLast(new Student(100, "xyz"));
		lp.addLast(new Student(80, "sid"));
		lp.addLast(new Student(20, "kush"));
		lp.addLast(new Student(75, "notorious"));
		lp.display();
		lp.mergesort();
		lp.display();
	}

	static class Student implements Comparable<Student> {
		int marks;
		String name;

		public Student(int marks, String name) {
			this.marks = marks;
			this.name = name;
		}

		@Override
		public int compareTo(Student o) {

			return this.name.compareTo(o.name);
		}

		public String toString() {
			String retval = "";
			retval += "[Marks=" + this.marks;
			retval += "[Name=" + this.name + "]\n";
			return retval;

		}

	}
}
