package hash;

public class MyClass1 {
	private int i, j, k;
	private String name;
		
	public MyClass1(int i, int j, int k, String name) {
		this.i = i;
		this.j = j;
		this.k = k;
		this.name = name;
	}

	String s;

	@Override
	// compresses the object to an int
	// if this.equal(other), then they have the same hashCode()
	// there is no guarantee if objects are not equal
	// but hopefully the collisions will be rare
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + i;
		result = prime * result + j;
		result = prime * result + k;
		// so far  result = ((31*1 + i) * 31 + j )* 31 + k;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyClass1 other = (MyClass1) obj;
		if (i != other.i)
			return false;
		if (j != other.j)
			return false;
		if (k != other.k)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
}
