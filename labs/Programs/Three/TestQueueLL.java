// Gary Parker
// Test for the Linked-List Queue

public class TestQueueLL {
    public static void main(String[] args){
	QueueLL a = new QueueLL();
	Node xNode = new Node("Jane", 123456789);
	Node yNode = new Node("Joe", 934567890);
	Node zNode = new Node("Jack", 223452234);
	Node kNode = new Node("Jill", 934567856);
	a.enqueue(xNode);
	a.enqueue(yNode);
	a.enqueue(zNode);
	a.enqueue(kNode);
	a.printQueue();
	System.out.println();
	System.out.println(a.front().getKey());
	System.out.println();
	a.printQueue();
	System.out.println();
	System.out.println(a.dequeue().getKey());
	System.out.println();
	a.printQueue();
	System.out.println();
	System.out.println(a.isEmpty());
	while(!a.isEmpty()) {
	    System.out.println(a.dequeue().getKey());
	    System.out.println();
	}
    	a.printQueue();
	System.out.println(a.isEmpty());
	System.out.println();
    }
}
