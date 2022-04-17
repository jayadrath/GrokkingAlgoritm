package com.algo.sort;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = {15,2 ,6,4,34,9, 102, 17, 1, 100};
		bubbleSort(arr);
		Arrays.stream(arr).forEach(System.out::println);
 	}

	private static void bubbleSort(int[] arr) {
		int temp;
		int decLen = arr.length;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j< decLen-1; j++) {
				if(arr[j] > arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			// no need to visit the last element again since it is sorted
			decLen--;
		}
	}
	
	
}
