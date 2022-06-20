package com.algo.interview.questions;

public class RotateStringOffset {

	public static void main(String[] args) {
		String s = "abcde";
		int offset = 3;
		System.out.println(rotateString(s,offset));
	}
	
	public static String rotateString(String str, int offset) {
		if(str == null || str.length() == 0 || str.length() == offset || offset%str.length() == 0) return str;
		int rem = offset%str.length();
		str = rotate(str, 0, str.length()-rem-1 );
		str = rotate(str, str.length() - rem, str.length()-1 );
		str = rotate(str, 0, str.length()-1);
		return str;
	}

	public static String rotate(String str, int start, int end) {
		int left = start, right = end;
		char[] charArr = str.toCharArray();
		while(left<right) {
			char temp = charArr[left];
			charArr[left] = charArr[right];
			charArr[right] = temp;
			left++;
			right--;
		}
		return new String(charArr);
	}
	
}
