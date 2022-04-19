public class Dictionary {
	
	private Node[][] dict_primary;
	private int n;

	public Dictionary() {
		dict_primary = new Node[7][7];
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

		int x = 0;
		while(true) {
			if(dict_primary[indexAddress][x++] == null) {
				dict_primary[indexAddress][x-1] = inp_node;
				break;
			}
		}

	}

	public Node lookUp(int inp_key) {
		int indexAddress = hash(inp_key);
		int x = 0;
		while(true) {
			if(dict_primary[indexAddress][x] != null) {
				if(dict_primary[indexAddress][x].getKey() == inp_key) {
					return dict_primary[indexAddress][x];
				}
			}
			x++;
			if(x == dict_primary[indexAddress].length) {
				return null;
			}
		}
	}

	public void delete(int inp_key) {
		int indexAddress = hash(inp_key);
		int x = 0;
		while(true) {
			if(dict_primary[indexAddress][x] != null) {
				if(dict_primary[indexAddress][x].getKey() == inp_key) {
					dict_primary[indexAddress][x] = null;
					return;
				}
			}
			x++;
		}
	}

	public void printDict() {
		System.out.println("Printing Dictionary:");
		for(int x = 0; x < 7; x++) {
			System.out.print(Integer.toString(x) + ": ");
			for(int y = 0; y < 7; y++) {
				if(dict_primary[x][y] != null) {
					System.out.print(dict_primary[x][y].getKey());
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

}