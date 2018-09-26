package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {
	public static void saveFile(List<Integer> sorted, long sum, long negSumAbs, String fileName) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(fileName);

		for (Integer number : sorted) {
			writer.print(number + " ");
		}
		writer.println();
		writer.println("Suma liczb dodatnich = " + sum + ". Bezwzglêdna suma liczb ujemnych = " + negSumAbs + ".");
		if(sum > negSumAbs) {
			writer.println("Bezwzglêdna suma liczb ujemnych jest mniejsza ni¿ suma liczb dodatnich.");
		} else if (sum == negSumAbs) {
			writer.println("Bezwzglêdna suma liczb ujemnych jest równa sumie liczb dodatnich.");
		} else {
			writer.println("Bezwzglêdna suma liczb ujemnych jest wiêksza ni¿ suma liczb dodatnich.");
		}
		writer.close();
	}

	public static int[] readFile(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
		Scanner scanner = new Scanner(file);

		try {
			List<Integer> numbers = new ArrayList<Integer>();
			while (scanner.hasNextInt()) {
				numbers.add(scanner.nextInt());
			}
			int[] result = new int[numbers.size()];
			for (int i = 0; i < numbers.size(); i++) {
				result[i] = numbers.get(i);
			}

			return result;
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}
}
