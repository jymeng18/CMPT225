public class FindSmallHash {

	// goal: returns a string that starts with the given prefix
	// so that hashcode() of the returned string is as small as possible
	// challenge: make it less that 1000
	public static String suffixWithSmallHashCode(String prefix) {
		return prefix;
	}
	
	public static void main(String[] args) {
		String prefix = "abcd";
		System.out.println("str = " + prefix);
		System.out.println("str.hashCode() = " + prefix.hashCode());

		System.out.println("looking for a string that starts with \"" + prefix + "\" and has small hashCode");
		String ret = suffixWithSmallHashCode(prefix);
		if (!ret.startsWith(prefix)) {
			System.out.println("ERROR: " + prefix + " is not a prefix of " + ret);
			return;
		}
		System.out.println("new hashCode = " + ret.hashCode());
		if (ret.hashCode() < 1000)
			System.out.println("Well done!");
		else if (ret.hashCode() < 1000000)
			System.out.println("Very nice!");
	}
}
