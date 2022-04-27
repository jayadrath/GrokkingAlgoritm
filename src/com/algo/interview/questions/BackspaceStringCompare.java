package com.algo.interview.questions;

import java.util.ArrayDeque;
import java.util.Deque;

public class BackspaceStringCompare {

	public static void main(String[] args) {
		String s = "xywrrmp";//"a##c"; //"y#fo##f";
		String t = "xywrrmu#p";//"#a#c";//"y#f#o##f";
		System.out.println(compareString(s, t));
		System.out.println("Compare string opt "+compareStringOpt(s, t));
	}
	
	static boolean compareString(String s, String t) {
		if(s.length()<1 || t.length()>200) return false;
		String charListS = getFinalString(s);
		String charListT = getFinalString(t);
		return charListS.equals(charListT);
	}

	private static String getFinalString(String str) {
		Deque<Character> chars = new ArrayDeque<>(); 
		for (char ch : str.toCharArray()) {
			  	if(ch!='#') {
			  		chars.addFirst(ch);
			  		
			  		}else if(!chars.isEmpty()) {
			  			chars.removeFirst();
			  		}
			  	}
		return String.valueOf(chars);
	}
	
	
	/*
	 * 1. There will be 2 pointers, one for each string, ptr1, ptr2
	 * 2. ptr1,ptr2 = string.length
	 * 3. loop through char arr for string1 and string2 while they are greater than 0
	 * 4. if charAt ptr1 = '#' then add cnt1 += 1, similarly if charAt ptr2 = '#' cnt2 += 1, ptr1--, ptr2--
	 * 5. else if (cnt1> 0 || cnt2 >0 ) then if cnt1>0 ptr1-- cnt1--, if cnt2>0 ptr2-- cnt2--
	 * 6. else if(cnt1==0 && cnt2==0) then compare charAt ptr1 with charAt ptr2, if equal then ptr1--, ptr2-- continue or return false
	 * 7. finally after the loop we have to check that the left pointer and right pointer are equal to -1
	 */
	static boolean compareStringOpt(String s, String t) {
		if(s.length()<1 || t.length()>200) return false;
		int sPtr = s.length()-1, tPtr = t.length()-1, skip1 =0, skip2 = 0;
		while(sPtr >= 0 || tPtr >= 0) {
				while(sPtr>=0) {
					if( s.charAt(sPtr)=='#') {
						skip1++;
						sPtr--;
					}
					else if(skip1>0) {
						skip1--;
						sPtr--;
					}
					else break;
				}
				
				while(tPtr>=0) {
					if(t.charAt(tPtr) == '#') {
						skip2++;
						tPtr--;
					}
					else if(skip2>0) {
						skip2--;
						tPtr--;
					}
					else break;
				}
				
				if(sPtr>=0 && tPtr>=0 && s.charAt(sPtr)!= t.charAt(tPtr)) return false;
				
				if((sPtr>=0)!=(tPtr>=0)) return false;
				sPtr--;
				tPtr--;
		}
		return true;
		
	}
}
