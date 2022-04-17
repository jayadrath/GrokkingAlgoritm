package com.dynamicprogramming;

import java.util.Arrays;

public class DollarCalcRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] denom = {100, 50, 20, 10, 5, 2, 1};
		int noOfWays = calcNoOfWaysToGetAmount(30, denom);
		System.out.println(noOfWays);
	}

	public static int calcNoOfWaysToGetAmount(int amount, int[] denominationsSorted) {
		if(amount == 0 ) return 1;
		if(amount <0 || denominationsSorted.length==0)return 0;
		System.out.println("amount "+amount + " denom "+Arrays.toString(denominationsSorted));
		int[] subArray = Arrays.copyOfRange(denominationsSorted, 1, denominationsSorted.length);
		return calcNoOfWaysToGetAmount(amount, subArray) + calcNoOfWaysToGetAmount(amount-denominationsSorted[0], denominationsSorted);
	}
	
}
