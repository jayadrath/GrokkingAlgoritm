package com.algo.sort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = {38, 27, 43, 3, 9, 82, 10};
		arr = sort(arr);
		for (int i : arr) {
			System.out.println(i);
		}

	}
	
	public static int[] sort(int[] arr) {
		int length = arr.length;
		if(length == 1) return arr;
		int mid = length/2;
		// divide and sort
		int[] lArr = Arrays.copyOfRange(arr, 0, mid);
		int[] rArr = Arrays.copyOfRange(arr, mid, length);
		int[] left = sort(lArr);
		int[] right = sort(rArr);
		// finally merge the left and right
		return merge(left, right);
	}
	
	public static int[] merge(int[] left, int[] right) {
		int i = 0, j=0, idxM = 0;
		int[] merged = new int[left.length + right.length];
		
		while(i < left.length && j <right.length) {
			if(left[i] < right[j]) {
				merged[idxM++] = left[i++];
			}
			else {
				merged[idxM++] = right[j++];
			}
		}
		// Add the remaining elements of the array with elements left
		while(i<left.length ) {
			merged[idxM++] = left[i++];
		}
		while(j<right.length) {
			merged[idxM++] = right[j++];
		}
		return merged;
	}


}
