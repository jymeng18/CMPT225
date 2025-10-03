package tree;
import java.util.ArrayList;
import java.util.Collection;

public class Node<T> {
	private T data;
	private Collection<Node<T>> children;
	private Node<T> parent;
	
	public Node(T data) {
		this.data = data;
		children = new ArrayList<Node<T>>();
		parent = null;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public void setParent(Node<T> parent) {
		this.parent = parent;
	}
	
	public void addChild(Node<T> child) {
		this.children.add(child);
	}
	
	public T getData() {
		return data;
	}
	
	public Node<T> getParent() {
		return parent;
	}
	
	public Collection<Node<T>> getChildren() {
		return children;
	}
}
