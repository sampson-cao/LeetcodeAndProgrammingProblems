// Sliding window approach
public class LongestSubstringWithoutRepeatingCharacters {
	public static int lengthOfLongestSubstring(String s) {
		String buf = "";
		int max = 0;
		int count = 0;
		char curChar;

		for (int i = 0; i < s.length(); i++) {
			curChar = s.charAt(i);

			if (buf.contains(curChar + "")) {

				if (count > max) {
					max = count;
				}

				buf = buf.substring(buf.lastIndexOf(curChar));
				count = buf.length();

			} else {
				count++;
			}

			buf += s.charAt(i);

		}
		if (max < count) {
			max = count;
		}

		return max;
	}

	public static void main(String[] args) {
		String s = "aab";

		System.out.println(lengthOfLongestSubstring(s));
	}
}
