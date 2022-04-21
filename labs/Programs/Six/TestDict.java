public class TestDict {
	public static void main(String[] args) {

		// Creates the dictionary object
		Dictionary dict = new Dictionary();

		// Creates all the nodes that get tested
		Node studentA = new Node("Jane", 111111111);
		Node studentB = new Node("Joe", 222222222);
		Node studentC = new Node("Jack", 333333333);
		Node studentD = new Node("Jill", 444444444);
		Node studentE = new Node("Joram", 555555555);
		Node studentF = new Node("James", 666666666);
		Node studentG = new Node("Josh", 777777777);
		Node studentH = new Node("Julia", 888888888);
		Node studentI = new Node("Jackie", 999999999);
		Node studentJ = new Node("Jamison", 123456789);
		Node studentK = new Node("Juliet", 987654321);
		Node studentL = new Node("Jackson", 123212321);

		// Add the first 7 nodes to fill up first list value in each array slot
		System.out.println("\nAdding " + studentA);
		dict.insert(studentA);

		System.out.println("Adding " + studentB);
		dict.insert(studentB);

		System.out.println("Adding " + studentC);
		dict.insert(studentC);

		System.out.println("Adding " + studentD);
		dict.insert(studentD);

		System.out.println("Adding " + studentE);
		dict.insert(studentE);

		System.out.println("Adding " + studentF);
		dict.insert(studentF);

		System.out.println("Adding " + studentG);
		dict.insert(studentG);


		// Prints dictionary contents after initial additions
		System.out.println();
		dict.printDict();

		// Adds more students, generating hash collisions that get resolved
		System.out.println();
		System.out.println("Adding " + studentH);
		dict.insert(studentH);

		System.out.println("Adding " + studentI);
		dict.insert(studentI);

		System.out.println("Adding " + studentJ);
		dict.insert(studentJ);

		System.out.println("Adding " + studentK);
		dict.insert(studentK);

		System.out.println("Adding " + studentL);
		dict.insert(studentL);

		// Prints dictionary after collisions added
		System.out.println();
		dict.printDict();

		// Demonstrates search function
		System.out.println();
		System.out.println("Searching for: 1111");
		System.out.println("Found: " + dict.lookUp(1111));

		System.out.println();
		System.out.println("Searching for: 8888");
		System.out.println("Found: " + dict.lookUp(8888));

		// Demonstrates delete function
		System.out.println();
		System.out.println("Deleting: 1111\n");
		dict.delete(1111);
		dict.printDict();

		System.out.println();
		System.out.println("Searching for: 1111");
		System.out.println("Found: " + dict.lookUp(1111));


		// Adds value back to show you can remove any value from the list (part 1)
		System.out.println("\nAdding " + studentA);
		dict.insert(studentA);

		System.out.println();
		dict.printDict();

		// Deletes value to show you can remove any value from the list (part 2)
		System.out.println();
		System.out.println("Deleting: 8888");
		dict.delete(8888);

		System.out.println();
		System.out.println("Searching for: 8888");
		System.out.println("Found: " + dict.lookUp(8888));

		System.out.println();
		dict.printDict();

		// Removes more values to show linked lists get properly updated
		System.out.println("\nRemoving a few other values...");

		System.out.println();
		System.out.println("Deleting: 5555");
		dict.delete(5555);

		System.out.println("Deleting: 3333");
		dict.delete(3333);

		System.out.println("Deleting: 6666");
		dict.delete(6666);

		System.out.println("Deleting: 2321");
		dict.delete(2321);

		System.out.println();
		dict.printDict();

		// As a former applied cryptography student, dictionaries are my best friend. This one was fun :)
		System.out.println("(way more fun than the heap.)");
	}
}
