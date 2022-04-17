package com.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DollarCalcDynamicP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] denom = {100, 50, 20, 10, 5, 2, 1};
		int noOfWays = calcNoOfWaysToGetAmountDp(30, denom, new HashMap<String, Integer>());
		System.out.println(noOfWays);
	}

	public static int calcNoOfWaysToGetAmountDp(int amount, int[] denominationsSorted, Map<String, Integer> cache) {
		if(amount == 0 ) return 1;
		if(amount <0 || denominationsSorted.length==0)return 0;
		// if not in map calculate otherwise return value from map
		String key = denominationsSorted.length + "|" + amount;
		if(cache.get(key)==null){
			int[] subArray = Arrays.copyOfRange(denominationsSorted, 1, denominationsSorted.length);
			int val = calcNoOfWaysToGetAmountDp(amount, subArray, cache) + calcNoOfWaysToGetAmountDp(amount-denominationsSorted[0], denominationsSorted, cache);
			cache.put(key, val);
			System.out.println(" denom "+Arrays.toString(denominationsSorted) + " key: "+key+" value: "+cache.get(key));
		}
		
		return cache.get(key);
	}
	
}
