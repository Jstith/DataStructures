// Gary Parker
// Test for the Array Queue

public class TestQueueA {
    public static void main(String[] args){
	QueueA a = new QueueA();
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
	a.enqueue(xNode);
	a.enqueue(yNode);
	a.enqueue(zNode);
	for (int i = 0; i < 65; i++) {
	    a.enqueue(xNode);
	    a.enqueue(yNode);
	    a.enqueue(zNode);
	    a.dequeue();
	    a.dequeue();
	    a.dequeue();
	}
	a.printQueue();
    }
}
