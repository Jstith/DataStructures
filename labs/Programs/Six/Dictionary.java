public class Dictionary {

	private List[] dict_primary;
	private int n;

	public Dictionary() {
		dict_primary = new List[7];

		// For reasons unclear to me, instantiating the array doesn't do this
		for(int x = 0; x < 7; x++) {
			dict_primary[x] = new List();
		}
		n = 0;
	}

	public int getKey(Node inp_node) {
		// This is why we like python
		// str(inp_node.getKey())[-4:]
		return Integer.parseInt(Integer.toString(inp_node.getKey()).substring(Integer.toString(inp_node.getKey()).length() - 4));
	}

	public boolean isEmptyDict() {
		return n==0;
	}

	private int hash(int key) {
		int hash1 = key % 7;
		int hash2;

		for(hash2 = 0; key != 0; key /= 10) {
			hash2 += key % 10;
		}

		//System.out.println("First hash is: " + Integer.toString(hash1));
		//System.out.println("Second hash is: " + Integer.toString(hash2));

		int indexAddress = (hash1 + hash2) % 7;
		//System.out.println("indexing to: " + Integer.toString(indexAddress));
		return indexAddress;
	}

	public void insert(Node inp_node) {
		int key = getKey(inp_node);

		// Double hashes key
		int indexAddress = hash(key);
		dict_primary[indexAddress].insert(inp_node);
		n++;
	}

	public Node lookUp(int inp_key) {
		int indexAddress = hash(inp_key);
		Node response = dict_primary[indexAddress].searchReturn(inp_key);
		return response;
	}

	public void delete(int inp_key) {
		int indexAddress = hash(inp_key);
		Node result = dict_primary[indexAddress].searchRemove(inp_key);
		if(result != null) {
			n--;
		}
	}

	public void printDict() {
		System.out.println("Printing Dictionary:");
		for(int x = 0; x < 7; x++) {
			System.out.print(Integer.toString(x) + ": ");
			dict_primary[x].printList();
			System.out.println();
		}
	}
}
