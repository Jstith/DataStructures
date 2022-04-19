public class HeapTest {
  public static void main(String[] args) {
    System.out.println("Testing Heap Class (hold on to something).");

    System.out.println("********************");
    System.out.println("NOTE: I wrote this heap where high values are highest priority, opposite of how we did it in class. It just made more sense to me. Thus, some of the function names are slightly differnet than they were in the examples.");
    System.out.println("********************");

    // Create students with priorities
    Node studentA = new Node("Jane", 111111111, 1);
  	Node studentB = new Node("Joe", 222222222, 2);
  	Node studentC = new Node("Jack", 333333333, 3);
  	Node studentD = new Node("Jill", 444444444, 4);

    // Creates heap object
    Heap test_heap = new Heap();
    System.out.println("Is empty?\t" + test_heap.isEmptyHeap());

    // Inserts a few students
    test_heap.insert(studentA);
    System.out.println("Added " + Integer.toString(studentA.getPriority()));
    test_heap.printArr();

    test_heap.insert(studentC);
    System.out.println("Added " + Integer.toString(studentC.getPriority()));
    test_heap.printArr();

    // Pulls top value of heap
    System.out.println("Top value is:\t" + test_heap.findMax().getPriority());

    // Inserts another student
    test_heap.insert(studentB);
    System.out.println("Added " + Integer.toString(studentB.getPriority()));
    test_heap.printArr();

    // Tests deleting a student then adding students after
    test_heap.deleteMax();
    System.out.println("Removed top value");
    test_heap.printArr();

    // Inserts more students
    test_heap.insert(studentD);
    System.out.println("Added " + Integer.toString(studentD.getPriority()));
    test_heap.printArr();

    test_heap.insert(studentC);
    System.out.println("Added " + Integer.toString(studentC.getPriority()));
    test_heap.printArr();

    // Last check of adding before purging list
    System.out.println("Top value is:\t" + test_heap.findMax().getPriority());
    System.out.println("Is empty?\t" + test_heap.isEmptyHeap());
    System.out.println("Here goes nothing... removing top values");

    // Tests all use cases of deleteMin
    // Removes all students one at a time and prints heap each time
    test_heap.printArr();

    test_heap.deleteMax();
    System.out.println("Removed top value");
    test_heap.printArr();

    test_heap.deleteMax();
    System.out.println("Removed top value");
    test_heap.printArr();

    test_heap.deleteMax();
    System.out.println("Removed top value");
    test_heap.printArr();

    test_heap.deleteMax();
    System.out.println("Removed top value");
    test_heap.printArr();

    System.out.println("Is empty?\t" + test_heap.isEmptyHeap());
    System.out.println("OH MY GOSH IT ACTUALLY WORKED! TAKE THAT LAST 3 HOURS!");
  }
}
