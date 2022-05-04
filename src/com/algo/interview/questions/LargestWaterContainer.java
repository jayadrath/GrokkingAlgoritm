package com.algo.interview.questions;

public class LargestWaterContainer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxArea(int[] height) {
		int maxArea = 0;
		for(int i=0; i< height.length; i++) {
			for(int j = i+1; j<height.length; j++) {
				int length = Math.min(height[i],  height[j]);
				int width = j-i;
				int currArr = length * width;
				maxArea = Math.max(maxArea, currArr);
			}
		}
		return maxArea;
	}
	
	public int maxAreaOpt(int[] height) {
		int maxArea =0;
		int i = 0, j=height.length-1;
		while(i<j) {
			int left = height[i];
			int right = height[j];
			int width = j - i;
			int length = Math.min(left, right);
			int currArea = width*length;
			maxArea = Math.max(maxArea, currArea);
			if(length == left) {
				i++;
			}
			else {
				j--;
			}
		}
		return maxArea;
	}

}
