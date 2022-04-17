package com.algo.sort;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = {17, 12, 1, 23, 1, 9};
		selectionSort(arr);
		for (int i : arr) {
			System.out.println(i);
		}
		
	}
	
	public static void selectionSort(int[] arr) {
		for(int i = 0; i<arr.length ; i++) {
			for(int j = i+1; j< arr.length; j++) {
				if(arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

}
