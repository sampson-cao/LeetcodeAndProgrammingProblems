

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AdventOfCode2022Day4 {
	public static void main(String[] args) {

		File file = new File("src/Sandbox/input");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int overlap = 0;

		while (sc.hasNext()) {
			String in = sc.nextLine();
			System.out.println(in);

			String[] tokens = in.split(",");

			String e1 = tokens[0];
			String e2 = tokens[1];

			String[] e1Tokens = e1.split("-");
			String[] e2Tokens = e2.split("-");

			int e1Start = Integer.parseInt(e1Tokens[0]);
			int e1End = Integer.parseInt(e1Tokens[1]);
			int e2Start = Integer.parseInt(e2Tokens[0]);
			int e2End = Integer.parseInt(e2Tokens[1]);

			if ((e1Start <= e2End && e1End >= e2Start) || (e2Start <= e1End && e2End >= e1Start)) {
				overlap++;
			}

		}

		System.out.println(overlap);

	}
}
