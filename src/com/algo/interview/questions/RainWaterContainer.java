package com.algo.interview.questions;

public class RainWaterContainer {

	public static void main(String[] args) {
//		int[] heights = {0,1,0,2,1,0,3,1,0,1,2};//{0,3,0,2,1,0,3,1,0,1,2};
//		System.out.println("Total water = "+totalWater(heights) );
		int[] heights = {0,8,0,9,1,13,0,4, 8};
		System.out.println("Total water Opt = "+totalWaterOpt(heights) );
	}
	
	public static int totalWater(int[] heights) {
		if (heights.length == 0) return 0;
		int total = 0;
		for(int i=0; i<heights.length; i++) {
			int maxL = 0;
			int maxR =0;
			int leftP = i-1, rightP = i+1;
			while(leftP>=0 && rightP<heights.length) {
				maxL = Math.max(maxL, heights[leftP]);
				leftP--;
				maxR = Math.max(maxR, heights[rightP]);
				rightP++; 
			}
			
			while(leftP>=0) {
				maxL = Math.max(maxL, heights[leftP]);
				leftP--;
			}
			while (rightP<heights.length) {
				maxR = Math.max(maxR, heights[rightP]);
				rightP++; 
			}
			int cw = Math.min(maxL, maxR) - heights[i];
			if(cw > 0) {
				total += cw;
			}
		}
		return total;
	}
	
	public static int totalWaterOpt(int[] heights) {
		if (heights.length == 0) return 0;
		int total = 0, maxL = 0, maxR = 0, pLeft = 0, pRight = heights.length - 1; 
		while(pLeft < pRight) {
			int leftHeight = heights[pLeft];
			int rightHeight = heights[pRight];
			int cw = 0;
			if(leftHeight<=rightHeight) {
				if(maxL > leftHeight) {
					cw = maxL - leftHeight;
				}
				else {
					maxL = leftHeight;
				}
				pLeft++;
			}
			else {
				if(maxR > rightHeight) {
					cw = maxR - rightHeight;
				}
				else {
					maxR = rightHeight;
				}
				pRight--;
			}
			total += cw;
		}
			
		return total;
	}

}
