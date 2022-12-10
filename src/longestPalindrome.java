public class longestPalindrome {
	public static String longestPalindrome(String s) {
		char[] str = s.toCharArray();
		String substring = "";

		// scan each character or pair of matching characters
		// (a or bb for example)
		// Then start scanning left and right of them to
		// see if they're palindromic or not
		for (int i = 1; i < str.length - 1; i++) {

		}

		return null;
	}

	public static void main(String[] args) {
		String s = "aacabdkacaa";

		System.out.println(longestPalindrome(s));
	}
}
