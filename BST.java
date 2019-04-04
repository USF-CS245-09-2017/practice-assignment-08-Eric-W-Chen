public class BST<String> {

	private BSTNode root;

	public BST() {
		this.root = null;
	}
	// public BSTNode node;

	public void delete(Comparable value) {
		root = delete(this.root, value);
	} 

	public BSTNode delete(BSTNode node, Comparable value){
		if(node==null){
			return node;
		}
		if(value.compareTo(node.data) == -1){
			node.left = delete(node.left, value);
		}
		else if(value.compareTo(node.data) == 1){
			node.right = delete(node.right, value);
		}
		else{
			if(node.left == null){
				return node.right;
			}
			else if (node.right == null){
				return node.left;
			}
			node.data = findSmallest(node);
			node.right = delete(node.right, value);
		}
		return node;
	}
		
	public Comparable findSmallest(BSTNode node){
		BSTNode smallest = node;
		while(smallest.left != null){
			smallest = smallest.left;
		}
		return smallest.data;
	}

	public void print() {
		print(this.root);
	}

	public void print(BSTNode node){
		if(node != null){
			print(node.left);
			System.out.println(node.data);
			print(node.right);
		}
	}

	private BSTNode insert(BSTNode node, Comparable value){
		if(node == null){
			BSTNode n = new BSTNode(value);
			return n;
		}
		else if (node.compareTo(value)>0){
			node.right=insert(node.right, value);
		}
		else{
			node.left = insert(node.left, value);
		}
		return node;
	}

	public void insert(Comparable value){
		this.root = insert(this.root, value);
	}

	public boolean find(Comparable value){
		return find(this.root, value);
	}

	public boolean find(BSTNode node, Comparable value){
		if(node==null){
			return false;
		}
		if(node.compareTo(value)==0){
			return true;
		}
		else if(node.compareTo(value)>0){
			return find(node.right, value);
		}
		else{
			return find(node.left, value);
		}
	}
}