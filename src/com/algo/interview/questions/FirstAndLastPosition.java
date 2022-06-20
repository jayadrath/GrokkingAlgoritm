package com.algo.interview.questions;

import java.util.Arrays;

public class FirstAndLastPosition {

	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,3,3,3};
		int[] range = searchRange(arr, 3);
		System.out.println(Arrays.toString(range));
	}

	public static int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length -1;
        int startPosition = binarySearch(nums, left, right, target);
        int endPosition = startPosition;
        int temp1 = -1, temp2 = -1;
        while(startPosition!=-1){
            temp1 = startPosition;
            startPosition = binarySearch(nums, 0, startPosition - 1, target);
        }
        
        while(endPosition!=-1){
            temp2 = endPosition;
            endPosition = binarySearch(nums,  endPosition + 1, right, target);
        }
        
        return new int[]{temp1, temp2};
    }
    
    public static int binarySearch(int[] nums, int left, int right, int target){
        if(nums.length == 0 ) return -1;
        while(left <= right){
            int mid = (left+right)/2;
            int foundVal = nums[mid];
            if(foundVal == target){
                return mid;
            }
            else if (foundVal < target ){
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }
	
}
