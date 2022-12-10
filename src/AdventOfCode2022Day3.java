

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdventOfCode2022Day3 {
	public static void main(String[] args) {

		File file = new File("src/Sandbox/input");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<Integer> elves = new ArrayList<>();

		int sum = 0;

		while (sc.hasNext()) {
			String in = sc.nextLine();
			System.out.println(in);

			// part 1
//			String p1 = in.substring(0, in.length() / 2);
//			String p2 = in.substring(in.length() / 2, in.length());
//			char match = 0;
//
//			for (int i = 0; i < p1.length(); i++) {
//				if (p2.contains(p1.substring(i, i + 1))) {
//					match = p1.charAt(i);
//				}
//			}
//
//			if (Character.isLowerCase(match)) {
//				match = (char) (match - 96);
//			} else if (Character.isUpperCase(match)) {
//				match = (char) (match - 38);
//			}
//
//			sum += match;
//			match = 0;

			String in2 = sc.nextLine();
			String in3 = sc.nextLine();

			for (int i = 0; i < in.length(); i++) {
				if (in2.contains(in.substring(i, i + 1))) {
					if (in3.contains(in.substring(i, i + 1))) {
						char found = in.charAt(i);
						System.out.println(found);
						if (Character.isUpperCase(found)) {
							sum += found - 38;
							break;
						} else if (Character.isLowerCase(found)) {
							sum += found - 96;
							break;
						}
					}
				}
			}

		}

		System.out.println(sum);

	}
}
