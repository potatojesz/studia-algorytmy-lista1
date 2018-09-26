package lista1;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import utils.ArrayUtils;
import utils.FileUtils;
import utils.SortUtils;
import utils.SortUtils.SortType;

public class Application {
	// **********************
	// * Ustawienia
	// **********************
	private static final String RESOURCES_PATH = "src/main/resources/";
	private static final Set<String> FILE_NAMES = new LinkedHashSet<String>
		(Arrays.asList("sortowanie_1.txt", "sortowanie_2.txt", "sortowanie_3.txt"));
	private static final Set<String> FILES = new LinkedHashSet<String>(FILE_NAMES.size());

	public static void main(String[] args) throws Exception {
		initialize();
		for(String fileName : FILES) {
			execute(fileName);
		}
	}

	private static void initialize() throws FileNotFoundException {
		for(String file : FILE_NAMES) {
			FILES.add(RESOURCES_PATH + file);
		}
	}

	private static void execute(String fileName) throws FileNotFoundException {
		log("Wykonuje zadania dla pliku: " + fileName);
		int[] input = FileUtils.readFile(fileName);

		List<Integer> sorted = new ArrayList<Integer>(input.length);
		long sum = 0;
		long negSum = 0;

		log("Zadanie 1...");
		long start = System.nanoTime();
		int[] evenValues = ArrayUtils.evenValues(input);
		int[] oddValues = ArrayUtils.oddValues(input);
		SortUtils.sort(evenValues, SortType.ASC);
		SortUtils.sort(oddValues, SortType.DESC);
		for(int i : evenValues) {
			sorted.add(i);
		}
		for(int i : oddValues) {
			sorted.add(i);
		}
		long stop = System.nanoTime();
		log("Czas wykonania zad 1: " + (stop - start) + " [ns]\n");

		log("Zadanie 2...");
		start = System.nanoTime();
		for(Integer i : sorted) {
			if(i >= 0) {
				sum += i;
			} else {
				negSum += i;
			}
		}
		stop = System.nanoTime();
		log("Czas wykonania zad 2: " + (stop - start) + " [ns]");

		FileUtils.saveFile(sorted, sum, Math.abs(negSum), fileName.substring(0, fileName.length() - 4) + "_odp.txt");
	}

	private static void log(String message) {
		if(message != null && message.length() > 0) {
			System.out.println(message);
		}
	}
}
