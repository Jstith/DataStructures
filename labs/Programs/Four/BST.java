public class BST {
	
	private Node root;

	public BST() {
		root = null;
	}

	public boolean emptyTree() {
		return root == null;
	}

	public void insert(Node inp_node) {
		if(root == null) {
			root = inp_node;
		}
		else {
			insert2(root, inp_node);
		}
	}

	public void insert2(Node top, Node inp_node) {
		if(inp_node.getKey() < top.getKey()) {
			if(top.getLeft() == null) {
				top.setLeft(inp_node);
			}
			else {
				insert2(top.getLeft(), inp_node);
			}
		}
		else {
			if(top.getRight() == null) {
				top.setRight(inp_node);
			}
			else {
				insert2(top.getRight(), inp_node);
			}
		}
	}

	public Node search(int inp_key) {
		return searchr(root, inp_key);
	}

	private Node searchr(Node inp_node, int inp_key) {
		if(inp_node == null) {
			return null;
		}
		else if(inp_key == inp_node.getKey()) {
			return inp_node;
		}
		else if(inp_key < inp_node.getKey()) {
			return searchr(inp_node.getLeft(), inp_key);
		}
		else {
			return searchr(inp_node.getRight(), inp_key);
		}
	}

	public void delete(Node inp_node) {
		if(root != null) {
			if(inp_node == root) {
				root = deleteRoot(root);
			}
			else {
				delete2(root, inp_node);
			}
		}
	}

	private Node deleteRoot(Node top_node) {
		Node temp = top_node;
		// simplest outcome, it has no children
		if(top_node.getRight() == null && top_node.getLeft() == null) {
			return null;
		}
		else if(top_node.getRight() == null) {
			top_node = top_node.getLeft();
			temp.setLeft(null);
			return top_node;
		}
		else if(top_node.getLeft() == null) {
			top_node = top_node.getRight();
			temp.setRight(null);
			return top_node;
		}
		else {
			Node new_root = getSuccessor(top_node.getRight());
			delete(new_root);
			new_root.setLeft(top_node.getLeft());
			new_root.setRight(top_node.getRight());
			top_node.setLeft(null);
			top_node.setRight(null);
			return new_root;
		}
	}

	private void delete2(Node top_node, Node inp_node) {
		if(top_node.getLeft() != null && inp_node.getKey() < top_node.getKey()) {
			if(inp_node.getKey() == top_node.getLeft().getKey()) {
				top_node.setLeft(deleteRoot(top_node.getLeft()));
			}
			else {
				delete2(top_node.getLeft(), inp_node);
			}
		}
		else if(top_node.getRight() != null && inp_node.getKey() < top_node.getKey()) {
			if(inp_node.getKey() == top_node.getRight().getKey()) {
				top_node.setRight(deleteRoot(top_node.getRight()));
			}
			else {
				delete2(top_node.getRight(), inp_node);
			}
		}
	}

	public Node getSuccessor(Node inp_node) {

		if(inp_node.getRight() == null) {
			// might have to return null here not sure
			return inp_node;
		}
		else {
			inp_node = inp_node.getRight();
			while(inp_node.getLeft() != null) {
				inp_node = inp_node.getLeft();
			}
			return inp_node;
		}
	}

	// Dr. Parker's print tree code
	public void printTree() {
		printTree2(root);
		System.out.println();
    }

    // Also Dr. Parker's print tree code
    private void printTree2(Node tree) {
		if (tree != null) {
		    System.out.print(tree.getKey() + " ");
	            if (tree.getLeft() != null)
		        System.out.print("Left: " + tree.getLeft().getKey() + " ");
	            else
	                System.out.print("Left: null ");
	            if (tree.getRight() != null)
		        System.out.println("Right: " + tree.getRight().getKey() + " ");
	            else
	                System.out.println("Right: null ");
		    printTree2(tree.getLeft());
		    printTree2(tree.getRight());
		}
    }
}