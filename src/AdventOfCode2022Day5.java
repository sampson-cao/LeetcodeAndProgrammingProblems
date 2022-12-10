

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class AdventOfCode2022Day5 {
	public static void main(String[] args) {

		File file = new File("src/input");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int numStacks = 9;

		List<Integer> stackMinVal = new ArrayList<>();

		List<Stack<String>> stacks = new ArrayList<>();
		for (int i = 0; i < numStacks; i++) {
			stackMinVal.add(0);
			stacks.add(new Stack<String>());
			stacks.get(i).add(i + " " + 0);
		}

		System.out.println("stack min val: " + stackMinVal);
		System.out.println("Stacks: " + stacks);

		String top = "";

		while (sc.hasNext()) {
			String in = sc.nextLine();
			System.out.println(in);

			in = in.replaceAll("\\D+", " ");
			in = in.trim();

			String[] inst = in.split(" ");

			int num = Integer.parseInt(inst[0]);
			int from = Integer.parseInt(inst[1]) - 1;
			int to = Integer.parseInt(inst[2]) - 1;

			List<String> temp = new ArrayList<>();
			for (int i = 0; i < num; i++) {
				if (stacks.get(from).isEmpty()) {
					stackMinVal.set(from, stackMinVal.get(from) - 1);
					stacks.get(from).add(from + " " + stackMinVal.get(from));
				}

				temp.add(stacks.get(from).pop());

			}

			for (int i = temp.size() - 1; i >= 0; i--) {
				stacks.get(to).add(temp.get(i));
			}

			System.out.println("stack min val: " + stackMinVal);
			System.out.println("Stacks: " + stacks);

		}

		List<String> topElems = new ArrayList<>();

		stacks.forEach(s -> topElems.add(s.lastElement()));

		System.out.println(topElems);
		// part 1 answer (1 at a time) QPJPLMNNR
		// part 2 answer (multiple crates at a time) BQDNWJPVJ
	}
}
