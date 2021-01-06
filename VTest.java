import java.util.Random;
import java.util.ArrayList;

public class VTest {
	private static int NUMBER_OF_TESTS = 100;
	private static int NUMBER_OF_GET_CHECKS = 100; //you can set this to MAX_LIST_LENGTH but it is helpful to have it lower for DEBUG mode
	private static int MAX_LIST_LENGTH = 10000;
	private static boolean DEBUG;

	public static void main(String[] args) {
		System.out.println("Configure VTest by editing the top of the file, where you'll find several private variables!");
		System.out.println("Run with anything in the 1st argument to turn on DEBUG mode!");
		dp("If you're seeing this, DEBUG mode is on!");
		if (args.length > 0) DEBUG = true;
		else DEBUG = false;
		Random rng = new Random();
		for (int ii = 0; ii < NUMBER_OF_TESTS; ii++) {
			MyLinkedList l = new MyLinkedList();
			ArrayList<String> al = new ArrayList<String>();

			int finalSize = Math.abs(rng.nextInt() % MAX_LIST_LENGTH);
			dp("Testing boolean add(String value)");
			for (int i = 0; i < finalSize / 2; i++) {
				int ri = rng.nextInt();
				l.add(Integer.toString(ri));
				al.add(Integer.toString(ri));
			}

			dp("Testing void add(int index, String value)");
			for (int i = 0; i < finalSize / 2; i++) {
				int ri = rng.nextInt();
				int rind = Math.abs(rng.nextInt() % (finalSize / 2));
				l.add(rind, Integer.toString(ri));
				al.add(rind, Integer.toString(ri));
			}

			dp("Testing size()");
			if (l.size() != al.size()) System.out.println("Size check failed!");

			dp("Testing get(int index)");
			int gcp = 0;
			for (int i = 0; i < NUMBER_OF_GET_CHECKS; i++) { //sure, let's reuse that, why not
				int rind = Math.abs(rng.nextInt() % al.size());
				if (!l.get(rind).equals(al.get(rind))) System.out.println("Get check failed!");
				else gcp++;
			}
			dp(""+gcp + " get checks passed");

			dp("Testing toString(), which also tests everything up to this point");
			if (l.toString().equals(al.toString())) System.out.println("toString check failed! This might be because of toString, but might also be because of your add or set methods.");

			dp("Testing set(int index, String value)");
			for (int i = 0; i < rng.nextInt() % al.size(); i++) {
				int ri = rng.nextInt();
				int rind = Math.abs(rng.nextInt() % al.size());
				al.set(rind, Integer.toString(ri));
				l.set(rind, Integer.toString(ri));
			}

			dp("Testing toString(), which also tests everything up to this point");
			if (l.toString().equals(al.toString())) System.out.println("toString check failed! This might be because of toString, but might also be because of your add or set methods.");
		}
	}
	public static void dp(Object msg) {
		if (DEBUG) System.out.println(msg);
	}
}
