// Joram Stith
// Data Structures
// Dr. Parker
// 29MAR2022

public class StackA {

	// Class level variables
	private Node[] stack_array;
	private int count;

	// Constructor
	public StackA() {
		stack_array = new Node[100];
		count = 0;
	}

	// Checks if the number of array indices curerntly in use is > 0
	public boolean isEmpty() {
		return count == 0;
	}

	// Adds a value to the top of the stack
	public void push(Node inp_node) {
		
		// Checks if the array is out of space
		if(count < 99) {
			stack_array[count] = inp_node;
			count += 1;
		}
		else {
			System.out.println("Maximum length of StackA reached.");
		}
	}

	// Returns the top value in the stack
	public Node top() {
		if(isEmpty()) {
			return null;
		}
		return stack_array[count-1];
	}

	// Returns and removes the top value in the stack
	public Node pop() {
		if(isEmpty()) {
			return null;
		}
		return stack_array[--count];
	}

	// printStack method from class website
	// FROM https://oak.conncoll.edu/parker/com212/progs/printStack.txt
	public void printStack() {
        System.out.println(count);
		for(int i = count-1; i >= 0; i--) {
            System.out.println(stack_array[i].getKey());
        }
    }
}