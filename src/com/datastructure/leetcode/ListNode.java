package com.datastructure.leetcode;

public class ListNode {
	 private int val;
	 private ListNode next;
	 public ListNode() {}
	 public ListNode(int val) { this.val = val; }
	 public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public ListNode getNext() {
		return next;
	}
	public void setNext(ListNode next) {
		this.next = next;
	}
	
	public static ListNode insert(ListNode head, int data) {
		if (head == null) {
			head = new ListNode(data);
		}else {
			ListNode currentNode = head;
			while(currentNode.getNext()!=null) {
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(new ListNode(data));
			
		}
		return head;
	}
	
	public static void printList(ListNode head) {
		ListNode currentNode = head;
		while(currentNode!=null)
		{
			System.out.print(" "+currentNode.getVal() +  " ");
			currentNode = currentNode.getNext();
		}
		System.out.print("\n");
	}
	
}
