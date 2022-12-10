

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
 * Basically solved this by implementing a custom linux OS file management system + command line parser
 * then solving for what the problem wanted with the generated file structure
 */
public class AdventOfCode2022Day7 {
	public static void main(String[] args) {

		File file = new File("src/Sandbox/input");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Directory main = new Directory("/");

		Directory current = main;

		while (sc.hasNext()) {
			String in = sc.nextLine();
			System.out.println(in);

			String[] param;

			if (in.contains("$ cd")) {
				param = in.split(" ");
				if (param[2].equals("/")) {
					System.out.println("goto main dir");
					current = main;
				}
				else if (param[2].equals("..")) {
					System.out.println("goto up 1 dir");
					current = current.getPrev();
				}
				else if (param[2].matches("\\w+")) {
					System.out.println("goto dir " + param[2]);
					if (current.getDirectories().stream().anyMatch(d -> d.getName().equals(param[2]))) {
						Directory temp = current;
						current = current.getDirectory(param[2]);
						current.setPrev(temp);
					}
				}
			}
			else if (in.equals("$ ls")) {
				System.out.println("Directory contents: ");
//				current.getDirectories().forEach(d -> System.out.println(d.getName() + " (dir)"));
//				current.getFiles().forEach(f -> System.out.println(f.getName() + " " + f.getSize() + " (file)"));
			}
			else if (in.contains("dir")) {
				param = in.split(" ");
				System.out.println("create directory " + param[1]);
				current.addDirectory(new Directory(param[1]));
			}
			else if (in.split(" ")[0].matches("\\d+")) {
				param = in.split(" ");
				System.out.println("create file " + param[1] + " size: " + param[0]);
				current.addFile(new file(Integer.parseInt(param[0]), param[1]));
			}
			else {
				System.out.println("invalid command: " + in);
			}

		}

		// print entire file structure
		System.out.println("file structure: ");
		print(main, 0);

		Map<String, Integer> fileNameToSize = new HashMap<>();

		getFileSizes(main, fileNameToSize);

		System.out.println(fileNameToSize);

		long ans = 0;

		List<Integer> smolDirectories = fileNameToSize.values().stream().filter(e -> e <= 100000)
				.collect(Collectors.toList());

		for (Integer smol : smolDirectories) {
			ans += smol;
		}

		System.out.println(ans);

		// part 2
		long availSize = 70000000;
		long requiredSpace = 30000000;

		long usedSpace = fileNameToSize.get("/");

		long sizeLimit = availSize - requiredSpace;

		List<Integer> possibleDirsToRemove = new ArrayList<>();

		for (Integer size : fileNameToSize.values()) {
			if (usedSpace - size <= sizeLimit) {
				possibleDirsToRemove.add(size);
			}
		}

		Collections.sort(possibleDirsToRemove);

		System.out.println(possibleDirsToRemove.get(0));

	}

	public static int getFileSizes(Directory directory, Map<String, Integer> fileSizes) {
		int totalSize = 0;

		for (Directory d : directory.getDirectories()) {
			totalSize += getFileSizes(d, fileSizes);
		}

		for (file f : directory.getFiles()) {
			totalSize += f.getSize();
		}

		if (fileSizes.containsKey(directory.getName())) {
			fileSizes.put(directory.getName() + totalSize, totalSize);
		}
		else {
			fileSizes.put(directory.getName(), totalSize);
		}

		return totalSize;

	}

	public static void print(Directory directory, int tab) {
		System.out.println(new String(new char[tab]).replace("\0", " ") + directory.getName() + " (dir)");
		for (Directory d : directory.getDirectories()) {
			int newTab = tab + 4;
			print(d, newTab);
		}
		for (file f : directory.getFiles()) {
			System.out.println(
					new String(new char[tab + 4]).replace("\0", " ") + f.getName() + " " + f.getSize() + " (file)");
		}
	}

}

class Directory {
	private String name;
	private Directory prev;
	private List<Directory> directories = new ArrayList<>();;
	private List<file> files = new ArrayList<>();

	public Directory(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void addDirectory(Directory directory) {
		directories.add(directory);
	}

	public void addFile(file file) {
		files.add(file);
	}

	public List<Directory> getDirectories() {
		return directories;
	}

	public Directory getDirectory(String name) {
		return directories.stream().filter(d -> d.getName().equals(name)).collect(Collectors.toList()).get(0);
	}

	public List<file> getFiles() {
		return files;
	}

	public void setPrev(Directory directory) {
		prev = directory;
	}

	public Directory getPrev() {
		return prev;
	}
}

class file {
	int size;
	String name;

	public file(int size, String name) {
		this.size = size;
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public String getName() {
		return name;
	}
}
