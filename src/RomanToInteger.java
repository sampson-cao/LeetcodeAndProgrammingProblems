
public class RomanToInteger {
	public static int romanToInt(String s) {

		int num = 0;
		char ch;

		for (int i = 0; i < s.length(); i++) {
			ch = s.charAt(i);

			if (i > 0) {
				if (ch == 'V' || ch == 'X') {
					if (s.charAt(i - 1) == 'I') {
						num -= 1;
						if (ch == 'V')
							num += 4;
						if (ch == 'X')
							num += 9;

						continue;
					}

				}

				if (ch == 'L' || ch == 'C') {
					if (s.charAt(i - 1) == 'X') {
						num -= 10;
						if (ch == 'L')
							num += 40;
						if (ch == 'C')
							num += 90;

						continue;
					}
				}

				if (ch == 'D' || ch == 'M') {
					if (s.charAt(i - 1) == 'C') {
						num -= 100;
						if (ch == 'D')
							num += 400;
						if (ch == 'M')
							num += 900;

						continue;
					}
				}

			}

			switch (ch) {
			case 'I':
				num++;
				break;
			case 'V':
				num += 5;
				break;
			case 'X':
				num += 10;
				break;
			case 'L':
				num += 50;
				break;
			case 'C':
				num += 100;
				break;
			case 'D':
				num += 500;
				break;
			case 'M':
				num += 1000;
				break;

			}

		}
		return num;
	}

	public static void main(String[] args) {
		String num = "MCMXCIV";

		System.out.println(romanToInt(num));

	}
}
