// Joram Stith
// Data Structures
// Dr. Parker
// 29MAR2022

public class StackLL {

	// Class level variables
	private Node head;
	private int count;

	// Constructor
	public StackLL() {
		head = null;
		count = 0;
	}

	// Checks if the head pointer is pointing to a node or not
	public boolean isEmpty() {
		return head == null;
	}

	// Adds a value to the top of the stack
	public void push(Node inp_node) {
		
		// Sets input node's pointer to the current head and updates head
		inp_node.setNext(head);
		head = inp_node;
		count++;
	}

	// Returns the top value in the stack
	public Node top() {
		return head;
	}

	// Returns and removes the top value in the stack
	public Node pop() {
		if(isEmpty()) {
			return null;
		}
		// It's okay if this is null
		Node temp = head;
		head = head.getNext();
		count--;
		return temp;
	}

	// printStack method from class website
	// FROM https://oak.conncoll.edu/parker/com212/progs/printStack.txt
    public void printStack() {
        System.out.println(count);
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.getKey());
            temp = temp.getNext();
        }
    }
}