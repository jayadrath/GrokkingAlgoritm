package com.algo.sort;

import java.util.Arrays;

public class QuickSelect{
	
// A utility function to swap two elements
static void swap(int[] arr, int i, int j)
{
	int temp = arr[i];
	int tempj = arr[j];
	arr[i] = arr[j];
	arr[j] = temp;
	System.out.println(Arrays.toString(arr));
}

/* This function takes last element as pivot, places
the pivot element at its correct position in sorted
array, and places all smaller (smaller than pivot)
to left of pivot and all greater elements to right
of pivot */
static int partition(int[] arr, int low, int high)
{
	
	// pivot
	int pivot = arr[high];
	
	// Index of smaller element and
	// indicates the right position
	// of pivot found so far
	int i = low ;

	for(int j = low; j <= high - 1; j++)
	{
		int arrj = arr[j];
		// If current element is smaller
		// than the pivot
		if (arr[j] < pivot)
		{
			
			// Increment index of
			// smaller element
			swap(arr, i, j);
			i++;
		}
	}
	swap(arr, i, high);
	return (i);
}

/* The main function that implements QuickSort
		arr[] --> Array to be sorted,
		low --> Starting index,
		high --> Ending index
*/
static void quickSelect(int[] arr, int low, int high, int k)
{
	if (low < high)
	{
		
		// pi is partitioning index, arr[p]
		// is now at right place
		int indexOfK = arr.length - k;
		int pi = partition(arr, low, high);
		
		if(pi == indexOfK) {
			return;
		}
		else if(pi>indexOfK)quickSelect(arr, low, pi - 1, k);
		else quickSelect(arr, pi + 1, high, k);
	}
}

// Driver Code
public static void main(String[] args)
{
//	int[] arr = { 10, 7, 8, 9, 1, 5 };
	int[] arr = { 9, 1, 6, 7, 2, 5};
	int val = findKthLargest(arr, 2);
	System.out.printf("The %d largest element of the array is %d%n",2,val );
	System.out.println(Arrays.toString(arr));
	
}

private static int findKthLargest(int[] arr, int k) {
	int n = arr.length;
	
	quickSelect(arr, 0, n - 1,  k);
	return arr[arr.length-k];
}
}
