
public class LongestCommonPrefix {

	public static String longestCommonPrefix(String[] strs) {

		int idx = 0;

		String prefix = "";

		for (int i = 0; i < strs.length; i++) {
			if (strs[i].length() == 0) {
				return prefix;
			}
		}

		while (true) {
			for (int i = 0; i < strs.length; i++) {
				if (idx == strs[i].length()) {
					return prefix;
				}
			}
			prefix += strs[0].charAt(idx);
			for (int i = 0; i < strs.length; i++) {

				if (prefix.charAt(idx) == strs[i].charAt(idx)) {
					continue;
				} else {
					return prefix.substring(0, idx);
				}

			}

			idx++;
		}

	}

	public static void main(String[] args) {
		String[] strs = { "f" };

		System.out.println(longestCommonPrefix(strs));
	}

}
