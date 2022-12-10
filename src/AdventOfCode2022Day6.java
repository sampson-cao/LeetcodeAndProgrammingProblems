

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class AdventOfCode2022Day6 {
	public static void main(String[] args) {

		File file = new File("src/Sandbox/input");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while (sc.hasNext()) {
			String in = sc.nextLine();
			System.out.println(in);

			char[] inArr = in.toCharArray();

			int windowSize = 14;
			Stack<Character> window = new Stack<>();

			// initially populate window
			for (int i = 0; i < windowSize; i++) {
				window.add(inArr[i]);
			}
			System.out.println(window);


			for (int i = windowSize; i < inArr.length; i++) {
				if (window.size() >= 4) {
					window.remove(0);
				}
				window.add(inArr[i]);

				System.out.println(window);
				boolean repeating = false;
				for (int j = 0; j < windowSize - 1; j++) {
					if (window.get(j).equals(inArr[i])) {
						repeating = true;
						break;
					}

					for (int k = 0; k < windowSize; k++) {
						if (j == k) {
							continue;
						}

						if (window.get(j).equals(window.get(k))) {
							repeating = true;
						}
					}

				}

				if (repeating) {
					System.out.println("is repeating");
					continue;
				} else {
					System.out.println("is not repeating");
					System.out.println(i + 1);
					break;
				}

			}



		}

	}
}
