package com.algo.interview.questions;

public class Palindrome {

	public static void main(String[] args) {
		/*
		 * Test input 1 - A man, a plan, a canal: Panama - true 
		 *  2- abba - true
		 *  3 - acda - false
		 */
		String s = "A man, a plan, a canal: Panama";
		System.out.println(isPalindromeReversed(s));
	}
	
	public static boolean isPalindromeFromOutside(String s) {
		if(s==null) return false;
		//sanitize and replace to lower case
		s = s.replaceAll("[^\\w]", "").toLowerCase();
		if(s.length()<=1) return true;
		int ptr1 = 0, ptr2 = s.length()-1;
		while(ptr1 < ptr2) {
			if(s.charAt(ptr1) != s.charAt(ptr2)) return false;
			ptr1++;
			ptr2--;
		}
		return true;
	}
	
	//abcba
	public static boolean isPalindromeFromCentre(String s) {
		if(s==null) return false;
		//sanitize and replace to lower case
		s = s.replaceAll("[^\\w]", "").toLowerCase();
		if(s.length()<=1) return true;
		int ptr1, ptr2;
		ptr2= s.length()/2;
		if(s.length()%2==0) {
			ptr1 = ptr2-1;
		}else {
			ptr1 = ptr2;
		}
		while(ptr1>=0 && ptr2 < s.length()) {
			if(s.charAt(ptr1) != s.charAt(ptr2)) return false;
			ptr1--;
			ptr2++;
		}
	
	return true;
	}
	
	public static boolean isPalindromeReversed(String s) {
		if(s==null) return false;
		//sanitize and replace to lower case
		s = s.replaceAll("[^\\w]", "").toLowerCase();
		String reversed = new StringBuilder(s).reverse().toString();
		int ptr1 =0 , ptr2 =0 ;
		while(ptr1 < s.length()) {
			if(s.charAt(ptr1) != reversed.charAt(ptr2)) return false;
			ptr1++;
			ptr2++;
		}
		return true;
	}

}
