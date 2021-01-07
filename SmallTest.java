public class SmallTest {
	public static void main(String[] args) {
		MyLinkedList l = new MyLinkedList();
		l.add("a"); l.add("b"); l.add("c");
		System.out.println(l.toString());
		l.remove(2);l.remove(1);l.remove(0);
		System.out.println(l.toString());
	}
}
