

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdventOfCode2022Day1 {
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
			if (in.equals("\n") || in.equals("")) {
				elves.add(sum);
				sum = 0;
			} else {
				sum += Integer.parseInt(in);
			}
		}
		
		System.out.println(elves);

		int max = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		int max3 = Integer.MIN_VALUE;

		for (Integer i : elves) {
			if (i > max) {
				max3 = max2;
				max2 = max;
				max = i;
			} else if (i > max2) {
				max3 = max2;
				max2 = i;
			} else if (i > max3) {
				max3 = i;
			}
		}

		System.out.println(max);
		System.out.println(max2);
		System.out.println(max3);

		System.out.println(max + max2 + max3);

    }
}
