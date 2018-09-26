package utils;

public class SortUtils {
	public enum SortType {
		ASC,
		DESC
	}
	public static void sort(int[] array, SortType type) {
		if(SortType.DESC.equals(type)) {
			bubbleSortDesc(array);
		} else {
			bubbleSortAsc(array);
		}
	}

	private static void bubbleSortAsc(int[] array) {
		for (int startIndex = 1; startIndex < array.length; startIndex++) {
			for (int i = startIndex; i < array.length; i++) {
				if (array[startIndex - 1] > array[i]) {
					int tmp = array[startIndex - 1];
					array[startIndex - 1] = array[i];
					array[i] = tmp;
				}
			}
		}
	}
	private static void bubbleSortDesc(int[] array) {
		for (int startIndex = 1; startIndex < array.length; startIndex++) {
			for (int i = startIndex; i < array.length; i++) {
				if (array[startIndex - 1] < array[i]) {
					int tmp = array[startIndex - 1];
					array[startIndex - 1] = array[i];
					array[i] = tmp;
				}
			}
		}
	}
}
