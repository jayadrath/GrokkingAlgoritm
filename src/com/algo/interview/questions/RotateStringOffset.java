package com.algo.interview.questions;

import java.util.Arrays;

public class RotateStringOffset {

	public static void main(String[] args) {
		String s = "abcde";
		int offset = 3;
		char[] charArr = rotateString(s.toCharArray(),offset);
		System.out.println(Arrays.toString(charArr));
	}
	
	public static char[] rotateString(char[] charArr, int offset) {
		int length = charArr.length;
		if(charArr == null || length == 0 || length == offset || offset%length == 0) return charArr;
		int rem = offset%length;
		charArr = rotate(charArr, 0, length-rem-1 );
		charArr = rotate(charArr, length - rem, length-1 );
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
