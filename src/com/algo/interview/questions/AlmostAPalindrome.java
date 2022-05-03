package com.algo.interview.questions;

public class AlmostAPalindrome {

	public static void main(String[] args) {
		String str = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
		System.out.println(isAlmostAPalindrome(str));
	}
	
	/*
	 * Test cases
	 * 1. "race a car" - true
	 * 2. "abccdba" - True
	 * 3. "abcdefdba" - False
	 * 4. "" - true
	 * 5. "ab" - true
	 * 6. "a" - true
	 */
	public static boolean isAlmostAPalindrome(String s) {
		if(s==null) return false;
		//sanitize and replace to lower case
		s = s.replaceAll("[^\\w]", "").toLowerCase();
		if(s.length()<=2) return true;
		int ptr1 = 0, ptr2 = s.length()-1;
		while(ptr1 < ptr2) {
			if(s.charAt(ptr1) != s.charAt(ptr2)) {
				return isPalindrome(s, ptr1+1, ptr2) || isPalindrome(s, ptr1, ptr2-1);
			}
			ptr1++;
			ptr2--;
		}
		return true;
	}
	
	public static boolean isPalindrome(String s, int i, int j) {
		while(i<j) {
			if(s.charAt(i)!=s.charAt(j)) return false;
			i++;
			j--;
		}
		return true;
	}

}
