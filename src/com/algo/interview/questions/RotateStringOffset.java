package com.algo.interview.questions;

import java.util.Arrays;
import java.util.function.BiFunction;

public class RotateStringOffset {

	public static void main(String[] args) {
		String s = "abcde";
		int offset = 2;
		char[] charArr = rotateString(s.toCharArray(),offset, (a, b)-> a%b); //right rotation
		System.out.println(Arrays.toString(charArr));
		charArr = rotateString(s.toCharArray(),offset, (a, b)-> b - (a%b)); //left rotation
		System.out.println(Arrays.toString(charArr));
	}
	
	public static char[] rotateString(char[] charArr, int offset, BiFunction<Integer,Integer,Integer> getOffset ) {
		int length = charArr.length;
		if(charArr == null || length == 0 || length == offset || offset%length == 0) return charArr;
		offset = getOffset.apply(offset, length);
		charArr = rotate(charArr, 0, length-offset-1 );
		charArr = rotate(charArr, length - offset, length-1 );
		charArr = rotate(charArr, 0, length-1);
		return charArr;
	}

	public static char[] rotate(char[] charArr, int start, int end) {
		int left = start, right = end;
		while(left<right) {
			char temp = charArr[left];
			charArr[left] = charArr[right];
			charArr[right] = temp;
			left++;
			right--;
		}
		return charArr;
	}
	
}
