public class Heap {

	private Node[] arr_heap;
	private int n;

	public Heap() {
		arr_heap = new Node[128];
		n = 0;
	}


	public boolean isEmptyHeap() {
		return n == 0;
	}

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
					parent = ((index + 1) / 2) - 1;
				}
				else {
					// right
					parent = (index / 2) -1;
				}
			}
			if(arr_heap[parent].getKey() < arr_heap[current_check].getKey()) {
				// Needs to be swapped
				Node temp = arr_heap[parent];
				arr_heap[parent] = arr_heap[current_check];
				arr_heap[current_check] = temp;
				current_check = parent;
			}
			else {
				// Node is in correct place
				break;
			}
		}

		// Increment pointer to next insertion location
		n++;
		
	}

	public Node findMin() {
		return arr_heap[0];
	}

	// TODO: Delete min
	// TODO: Traverse
}