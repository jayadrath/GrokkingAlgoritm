package com.algo.search;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BinarySearch {

	public static void main(String[] args) {
		int[] randomIntsArray = IntStream.generate(() -> new Random().nextInt(100)).limit(200).distinct().sorted().toArray();
		int itemToSearch = new Random().nextInt(100);
		String arrs = Arrays.stream(randomIntsArray).boxed().map(String::valueOf).collect(Collectors.joining(", "));
		System.out.println(
				"Index of " + itemToSearch  + " in { "+ arrs+ " } is \n" + binarySearch(randomIntsArray, itemToSearch));
	}

	public static int binarySearch(int[] intArr, int itemToSearch) {
		int low = 0;
		int high = intArr.length - 1;
		while (low < high) {
			int mid = (low + high) / 2;
			if (intArr[mid] == itemToSearch) {
				return mid;
			}
			if (intArr[mid] < itemToSearch) {
				low = mid + 1;
			}
			if (intArr[mid] > itemToSearch) {
				high = mid - 1;
			}
		}
		return -1;
	}

}
