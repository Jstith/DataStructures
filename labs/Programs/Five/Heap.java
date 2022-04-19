// Joram Stith
// Data Structures
// Dr. Parker
// 18 April 2022

public class Heap {

	// Class level varaibles used in the heap
	private Node[] arr_heap;
	private int n;

	// Constructor
	public Heap() {
		arr_heap = new Node[128];
		n = 0;
	}

	public boolean isEmptyHeap() {
		return n == 0;
	}

	// Insert method. Moves highest value nodes to top of tree
	public void insert(Node inp_node) {
		arr_heap[n] = inp_node;
		int parent = -1;
		int current_check = n;

		// Recirsively moves node up the tree
		while(parent != 0) {
			// Insert it first, then update the appropriate values
			if(current_check != 0) {
				if(current_check % 2 != 0) {
					// left
					parent = (((current_check + 1) / 2) - 1);
				}
				else {
					// right
					parent = ((current_check / 2) -1);
				}
				if(arr_heap[parent].getPriority() < arr_heap[current_check].getPriority()) {
					// Needs to be swapped
					Node temp = arr_heap[parent];
					arr_heap[parent] = arr_heap[current_check];
					arr_heap[current_check] = temp;
					current_check = parent;
				}
			}
			else {
				// Node is in correct place
				break;
			}
		}

		// Increment pointer to next insertion location
		n++;

	}

	// O[1] find max value
	public Node findMax() {
		return arr_heap[0];
	}


	// Second implementation of the delete function
	public void deleteMax() {
		n--;
		//System.out.println("n is: " + Integer.toString(n));
		// Swap last and first
		Node placeholder = arr_heap[0];
		arr_heap[0] = arr_heap[n];
		arr_heap[n] = placeholder;

		// Preps for loop
		int current_eval_index = 0;
		int left_child, right_child;
		boolean l_tried, r_tried;

		l_tried = false;
		r_tried = false;

		// Loops down the tree from top to bottom
		while(true) {
			left_child = 2 * current_eval_index + 1;
			right_child = 2 * current_eval_index + 2;
			//System.out.println("left: " + Integer.toString(left_child));
			//System.out.println("right: " + Integer.toString(right_child));
			if(left_child < n) {
				// Recursive check to break loop
				// Adds one repition to loop, maintains O[lg(n)] since O[lg(n)] + 1 = O[lg(n)]
				if(l_tried) {
					break;
				}
				if(arr_heap[current_eval_index].getPriority() < arr_heap[left_child].getPriority()) {
					// Swap with left child
					placeholder = arr_heap[current_eval_index];
					arr_heap[current_eval_index] = arr_heap[left_child];
					arr_heap[left_child] = placeholder;
					current_eval_index = left_child;
					l_tried = false;
					r_tried = false;
				}
				l_tried = true;
			}
			else if(right_child < n) {
				// Recursive check to break loop
				// Adds one repition to loop, maintains O[lg(n)] since O[lg(n)] + 1 = O[lg(n)]
				if(r_tried) {
					break;
				}
				if(arr_heap[current_eval_index].getPriority() < arr_heap[right_child].getPriority()) {
					// Swap with right child
					placeholder = arr_heap[current_eval_index];
					arr_heap[current_eval_index] = arr_heap[right_child];
					arr_heap[right_child] = placeholder;
					current_eval_index = right_child;
					l_tried = false;
					r_tried = false;
				}
				r_tried = true;
			}
			else {
				// At bottom of tree, break
				break;
			}
		}
	}

	// Prints all priorities stored in the array
	public void printArr() {
		if(isEmptyHeap()) {
			System.out.println("Empty heap");
			return;
		}
		for(int x = 0; x < n; x++) {
			if(arr_heap[x] != null) {
				System.out.print(arr_heap[x].getPriority() + " ");
			}
		}
		System.out.println();
	}
}
