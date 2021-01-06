public class SmallTest {
	public static void main(String[] args) {
		MyLinkedList l = new MyLinkedList();
		l.add("a"); l.add("b"); l.add("c");
		System.out.println(l.get(0) + l.get(1) + l.get(2));
		System.out.println(l.toString());
	}
}
