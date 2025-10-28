package hash;

public class MyClass2 {
	private int i, j, k;
	private String name;
	private int hash;
	
	
	
	public MyClass2(int i, int j, int k, String name) {
		this.i = i;
		this.j = j;
		this.k = k;
		this.name = name;
		hash = computeHash();
	}


	public int computeHash() {
		final int prime = 31;
		int result = 1;
		result = prime * result + i;
		result = prime * result + j;
		result = prime * result + k;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	@Override
	public int hashCode() {
		return hash;
	}
	
	@Override
	public boolean equals(Object obj) {

		// can drop these for efficiency
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		MyClass2 other = (MyClass2) obj;
		
		// compare hash first for efficiency
		if (hash != other.hash)
			return false;
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
