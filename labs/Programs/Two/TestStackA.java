// Gary Parker
// Test for the Array Stack

public class TestStackA {
    public static void main(String[] args){
	StackA a = new StackA();
	Node xNode = new Node("Jane", 123456789);
	Node yNode = new Node("Joe", 934567890);
	Node zNode = new Node("Jack", 223452234);
	Node kNode = new Node("Jill", 934567856);
	a.push(xNode);
	a.push(yNode);
	a.push(zNode);
	a.push(kNode);
	a.printStack();
	System.out.println();
	System.out.println(a.top().getKey());
	System.out.println();
	a.printStack();
	System.out.println();
	System.out.println(a.pop().getKey());
	System.out.println();
	a.printStack();
	System.out.println();
	while(!a.isEmpty()) {
	    System.out.println(a.pop().getKey());
	    System.out.println();
	}
    	a.printStack();
	System.out.println();
    }
}

