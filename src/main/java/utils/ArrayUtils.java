package utils;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtils {
	public static void printArray(int[] array) {
		if(array != null) {
			for(int i = 0; i < array.length; i++) {
				System.out.print(array[i] + " ");
			}
		} else {
			System.out.print("Pusta lista");
		}
	}

	public static int[] evenValues(int[] array) {
		if(array != null) {
			List<Integer> resultList = new ArrayList<Integer>();
			for(int i = 0; i < array.length; i++) {
				if(array[i] % 2 == 0) {
					resultList.add(array[i]);
				}
			}
			return listToArray(resultList);
		} else {
			return null;
		}
	}

	public static int[] oddValues(int[] array) {
		if(array != null) {
			List<Integer> resultList = new ArrayList<Integer>();
			for(int i = 0; i < array.length; i++) {
				if(array[i] % 2 != 0) {
					resultList.add(array[i]);
				}
			}
			return listToArray(resultList);
		} else {
			return null;
		}
	}

	private static int[] listToArray(List<Integer> list) {
		if(list != null) {
			int[] result = new int[list.size()];
			for(int i = 0; i < list.size(); i++) {
				result[i] = list.get(i);
			}
			return result;
		} else {
			return null;
		}
	}
}
