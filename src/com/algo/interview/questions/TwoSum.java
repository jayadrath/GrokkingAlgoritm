package com.algo.interview.questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		/**
		 * Test cases 
		 * {7,6,5,2,1,3} target 11
		 * {7,9} target target 6
		 * {} target 10
		 * {7} target 7
		 */
		int[] arr = {7,6,5,2,1,3};
		int target = 11;
		int[] indices = findTwoSumOptimized(arr, target);
		System.out.println("Indices for array "+ Arrays.toString(arr) + " with target "+target +" is " +  Arrays.toString(indices));
		int[] arr1 = {7};
		int target1 = 6;
		int[] indices1 = findTwoSumOptimized(arr1, target1);
		System.out.println("Indices for array "+ Arrays.toString(arr1) + " with target "+target1 +" is " +  Arrays.toString(indices1));
		
	}
	
	public static int[] findTwoSum(int[] arr, int target) {
		if(target <= 0) return null;
		for (int i = 0; i < arr.length -1 ; i++) {
			int diff = target - arr[i];
			if(diff>=0) {
				for (int j = i+1; j < arr.length; j++) {
					if(diff == arr[j]) {
						return new int[]{i,j};
					}
				}
			}
		}
		return null;
	}
	
	public static int[] findTwoSumOptimized(int[] arr, int target) {
			Map<Integer, Integer> diffIndexMap = new HashMap<>();
			for(int i = 0; i< arr.length; i++) {
				Integer idx1 = diffIndexMap.get(arr[i]);
				if(idx1!=null) { //found
					return new int[]{idx1, i};
				}
				else {
					int diff = target - arr[i];
					diffIndexMap.put(diff, i);
				}
			}
		return null;
	}

}
