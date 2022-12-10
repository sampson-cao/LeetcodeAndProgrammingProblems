
public class PalindromeNumber {
	public static boolean isPalindrome(int x) {
		String str = x + "";

		int mid = str.length() / 2;
		mid--;

		System.out.println(str);
		System.out.println(mid);

		for (int i = mid; i >= 0; i--) {
			System.out.print(str.charAt(i) + " ");
			System.out.println(str.charAt(str.length() - i - 1));
			if (str.charAt(i) == str.charAt(str.length() - i - 1)) {
				continue;
			} else {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome(-12321));
	}

	/*
	 * Optimized solution if(x < 0 || (x % 10 == 0 && x != 0)) { return false; }
	 * 
	 * int revertedNumber = 0; while(x > revertedNumber) { revertedNumber =
	 * revertedNumber * 10 + x % 10; x /= 10; }
	 * 
	 * return x == revertedNumber || x == revertedNumber/10;
	 * 
	 */
}
