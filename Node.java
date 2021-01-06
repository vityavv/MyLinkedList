public class Node {
	private String data;
	private Node next, prev;

	public Node(String newData) {data = newData;}

	public Node getNext() {return next;}
	public Node getPrev() {return prev;}
	public void setNext(Node newNext) {next = newNext;}
	public void setPrev(Node newPrev) {prev = newPrev;}
	public String getData() {return data;}
	public void setData(String newData) {data = newData;}
}
