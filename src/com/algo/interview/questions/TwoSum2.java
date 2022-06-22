package com.algo.interview.questions;

import java.util.Arrays;

/**
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number.
 *  Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 *  Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
 *  The tests are generated such that there is exactly one solution. You may not use the same element twice
 * @author Kaushik_Chakraborty
 *
 */
public class TwoSum2 {

	public static void main(String[] args) {
		int[] input = new int[] {2,7,11,15};
		int[] twoSum = twoSum(input, 9);
		System.out.println(Arrays.toString(twoSum));
	}
	
	public static int[] twoSum(int[] input, int target) {
		int start = 0, end = input.length-1;
		while(start<end) {
			int sum = input[start] + input[end];
			if(sum == target) {
				return new int[] {start+1, end + 1};
			}
			else if(sum < target) {
				start++;
			}
			else {
				end--;
			}
		}
		return new int[] {0,0};
	}

}
