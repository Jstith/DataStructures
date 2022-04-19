public class TestDict {
	public static void main(String[] args) {
		Dictionary dict = new Dictionary();
		Node studentA = new Node("Jane", 111111111);
  		Node studentB = new Node("Joe", 222222222);
  		Node studentC = new Node("Jack", 333333333);
  		Node studentD = new Node("Jill", 444444444);
  		Node studentE = new Node("Joram", 555555555);
  		Node studentF = new Node("James", 666666666);
  		Node studentG = new Node("Josh", 777777777);
  		Node studentH = new Node("Julia", 888888888);
		
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

		System.out.println("Adding " + studentH);
		dict.insert(studentH);
		dict.printDict();

		System.out.println();
		System.out.println("Searching for: 1111");
		System.out.println("Found: " + dict.lookUp(1111));

		System.out.println();
		System.out.println("Searching for: 8888");
		System.out.println("Found: " + dict.lookUp(8888));

		System.out.println();
		System.out.println("Deleting: 1111");
		dict.delete(1111);
		dict.printDict();

		System.out.println();
		System.out.println("Searching for: 1111");
		System.out.println("Found: " + dict.lookUp(1111));

		System.out.println("\nAdding " + studentA);
		dict.insert(studentA);

		System.out.println();
		System.out.println("Deleting: 8888");
		dict.delete(8888);

		System.out.println();
		System.out.println("Searching for: 8888");
		System.out.println("Found: " + dict.lookUp(8888));
		dict.printDict();

	}
}