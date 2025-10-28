package graph;

public class Vertex<T> {
	
	private T name;

	// used for graph traversals only
	private boolean visited;
	private Vertex<T> parent;
	
	public Vertex(T name) {
		this.name = name;
	}

	public void setName(T name) {
		this.name = name;
	}
	
	public T getName() {
		return name;
	}

	public void setVisited(boolean flag) {
		visited = flag;
	}

	public boolean isVisited() {
		return visited;
	}
	
	public void setParent(Vertex<T> parent) {
		this.parent = parent;
	}
	
	public Vertex<T> getParent() {
		return parent;
	}
	
	@Override
	public boolean equals(Object other) {
		
		// skippping all these for sake of efficiency
		//if (other == null)
		//	return false;
		//if (!(other instanceof Vertex<?>))
		//	return false;
		
		if (this.hashCode() != other.hashCode())
			return false;
		
		T otherName = ((Vertex<T>) other).getName();
		return this.getName().equals(otherName);
	}

	
	@Override
	public int hashCode() {
		final int prime = 1733;
		return prime * ((name == null) ? 0 : name.hashCode());
		// May consider adding a field hash, compute it in the constructor,
		// and is hashCode() simply return it
		// useful if we compare objects often
	}

}
