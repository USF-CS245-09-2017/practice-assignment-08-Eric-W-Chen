public class BSTNode implements Comparable {
	public Comparable data;
	public BSTNode left;
	public BSTNode right;

	public BSTNode(Comparable data){
		this.data = data;
		left = null;
		right = null;
	}

	@Override
	public int compareTo(Object other){
		return this.data.compareTo(other);
	}
}