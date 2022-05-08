package com.algo.interview.questions;

public class ReverseLinkedList2 {
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		ListNode head = ListNode.getHeadOfListArr(arr);
		ListNode reversed = reverseBetween(head, 2 , 4);
		ListNode.printList(reversed);
	}
	
	
	  //Definition for singly-linked list.
	  static class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

	      public static ListNode getHeadOfListArr(int[] arr) {
	    	  if(arr==null)return null;
	    	  ListNode head = null;
	    	  ListNode currentNode = null;
	    	  for (int i = 0; i < arr.length; i++) {
	    		  if(i==0) {
	    			  head = new ListNode(arr[i]);
	    			  currentNode = head;
	    		  }
	    		  else {
	    			  currentNode.next = new ListNode(arr[i]);
	    			  currentNode = currentNode.next;
	    		  }
	    	  }
	    	  return head;
	      }
	      
	      public static void printList(ListNode node) {
	    	  ListNode cn = node;
	    	  while(cn!=null) {
	    		  System.out.print(cn.val+" ");
	    		  cn = cn.next;
	    	  }
	      }
	  }
	 
	  public static ListNode reverseBetween(ListNode head, int left, int right) {
	        if(head == null || head.next == null || left == right) return head;
	        int numElem = right - left +1;
	                
	            if(left == 1 ){
	                head = reverse(head, numElem);
	                return head;
	            }
	        // traverse till left
	        ListNode currentNode = head;
	        for(int i=1; i<left-1; i++){
	            currentNode = currentNode.next;
	        }
	        currentNode.next = reverse(currentNode.next, numElem);
	        return head;
	    }
	    
	    public static ListNode reverse(ListNode nodeToSwap, int numElem){
	        ListNode prev = null, next = null, currentNode = nodeToSwap;
	        int count = 0;
	        while(count < numElem){
	            next = currentNode.next;
	            currentNode.next = prev;
	            prev = currentNode;
	            currentNode = next;
	            count++;
	        }
	        nodeToSwap.next = currentNode;
	        return prev;
	    }
}
