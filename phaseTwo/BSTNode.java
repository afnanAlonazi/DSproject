package projectCSC212;

public class BSTNode<T> {
	public String key;
	public T data;
	public BSTNode<T> left , right;
	public BSTNode(String key, T data) {
		this.key = key;
		this.data = data;
		right=left = null;
	}
	public BSTNode(String key, T data, BSTNode<T> left, BSTNode<T> right) {
		
		this.key = key;
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	
	
	
	
	
	

}
