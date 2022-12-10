
public class IsSubsequence {
	public static boolean isSubsequence(String s, String t) {

		char cur;
		int idx = 0;
		boolean found = false;
		int i;

		if (s.length() == 0)
			return true;

		if (t.length() == 0)
			return false;

		for (i = 0; i < s.length(); i++) {

			cur = s.charAt(i);

			for (int j = idx; j < t.length(); j++) {

				if (t.charAt(j) == cur) {
					idx = j + 1;
					found = true;
					break;
				}

			}

			if (found) {
				found = false;
				continue;
			} else {
				return false;
			}

		}

		System.out.println(i);
		if (i < s.length()) {
			return false;
		}
		return true;

	}

	public static void main(String[] args) {

		String s = "aaa";
		String t = "bba";

		System.out.println(isSubsequence(s, t));

	}
}
