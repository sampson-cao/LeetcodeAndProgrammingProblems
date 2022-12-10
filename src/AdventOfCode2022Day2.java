

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdventOfCode2022Day2 {
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

		int score = 0;

		while (sc.hasNext()) {
			String in = sc.nextLine();
			System.out.println(in);

			String p1 = in.substring(0, 1);
			String p2 = in.substring(2, 3);

			// 1st part
//			if (p2.equals("X")) {
//				score += 1;
//
//				if (p1.equals("A")) {
//					score += 3;
//				} else if (p1.equals("C")) {
//					score += 6;
//				}
//
//			} else if (p2.equals("Y")) {
//				score += 2;
//
//				if (p1.equals("B")) {
//					score += 3;
//				} else if (p1.equals("A")) {
//					score += 6;
//				}
//
//			} else if (p2.equals("Z")) {
//				score += 3;
//
//				if (p1.equals("C")) {
//					score += 3;
//				} else if (p1.equals("B")) {
//					score += 6;
//				}
//
//			}

			// second part
			if (p2.equals("X")) {

				if (p1.equals("A")) {
					score += 3;
				} else if (p1.equals("B")) {
					score += 1;
				} else if (p1.equals("C")) {
					score += 2;
				}

			} else if (p2.equals("Y")) {
				score += 3;

				if (p1.equals("A")) {
					score += 1;
				} else if (p1.equals("B")) {
					score += 2;
				} else if (p1.equals("C")) {
					score += 3;
				}

			} else if (p2.equals("Z")) {
				score += 6;

				if (p1.equals("A")) {
					score += 2;
				} else if (p1.equals("B")) {
					score += 3;
				} else if (p1.equals("C")) {
					score += 1;
				}

			}

		}

		System.out.println(score);

	}
}
