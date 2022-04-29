package com.algo.interview.questions;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubString {

	public static void main(String[] args) {
		String str1 = "bbbbb";
		System.out.println(longestSSOpt(str1));
	}

	public static int longestSubString(String str) {
		if(str.length() == 0) return 0;
		int longest =0;
		for(int i=0; i< str.length() ; i++) {
			HashSet<Character> charSet = new HashSet<>();
			int subStrLen = 0;
			for(int j=i; j<str.length(); j++) {
				if(charSet.contains(str.charAt(j))) {
					break;
				}
				else {
					charSet.add(str.charAt(j));
					subStrLen++;
				}
			}
			longest = Math.max(longest, subStrLen);
		}
		return longest;
	}
	
	
	public static int longestSSOpt(String str) {
		if(str.length() <= 1) return str.length();
		int length = 0, subStrLen = 0, p1 = 0, p2 =1;
		HashMap<Character, Integer> charIndexMap = new HashMap<>();
		charIndexMap.put(str.charAt(p1), p1);
		while(p2<str.length()) {
			char p2Char = str.charAt(p2);
			Integer idx1 = charIndexMap.get(p2Char);
			if(idx1!=null && idx1>=p1) { // repeated in substring
				//update map with new index, move the p1 pointer to idx+1
				p1 = idx1+1;
				//reset subStrLen
				
			}
			subStrLen=p2-p1 +1;
			
			
			charIndexMap.put(p2Char, p2);
			length = Math.max(length, subStrLen);
			p2++;
		}
		return length;
	}
	
	public static int longestSSLeetCode(String s) {
		int[] chars = new int[128];

        int left = 0;
        int right = 0;

        int res = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            chars[r]++;

            while (chars[r] > 1) {
                char l = s.charAt(left);
                chars[l]--;
                left++;
            }

            res = Math.max(res, right - left + 1);

            right++;
        }
        return res;

	}
	
}
