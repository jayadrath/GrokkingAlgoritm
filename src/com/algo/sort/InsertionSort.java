package com.algo.sort;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = {15,2 ,6,4,34,9, 102, 17, 1, 100};
		sort(arr);
		for (int i : arr) {
			System.out.println(i);
		}
	}
	
	/*
	 *  #1 pass 2,15,6,4,34
	 * #2 pass 2, 6, 15, 4,34
	 * 
	 */
	
	public static void sort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i]; // = arr[3] = 4
			int j = i-1; //2
			//compare current key with all the 
			//previous values until it is no longer smaller
			while(j>=0 && arr[j]>key) { // = arr[1] = 4
				arr[j+1] = arr[j];
				arr[j] = key;// arr[2] = 6, arr[1] = 4, key = 4
				j--; // j= 1
			}
		}
	}

}
