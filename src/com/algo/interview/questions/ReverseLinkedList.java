package com.algo.interview.questions;

import com.datastructure.leetcode.ListNode;

public class ReverseLinkedList {

	public static void main(String[] args) {
		ListNode head = ListNode.insert(null, 1);
		head = ListNode.insert(head, 2);
		head = ListNode.insert(head, 3);
		head = ListNode.insert(head, 4);
		head = ListNode.insert(head, 5);
		ListNode.printList(head);
		head = reverseListRec(head);
		ListNode.printList(head);
	}
	
	public static ListNode reverseList(ListNode head) {
        if(head==null  || head.getNext()== null) return head;
        ListNode prevNode = null, nextNode, currentNode;
        currentNode = head;
        while(currentNode.getNext()!=null) {
        	nextNode = currentNode.getNext();
        	currentNode.setNext(prevNode);
        	prevNode = currentNode;
        	currentNode = nextNode;
        	head = currentNode;
        }
        head.setNext(prevNode);
        return head;
    }
	
	public static ListNode reverseListOpt(ListNode head) {
        if(head==null  || head.getNext()== null) return head;
        ListNode prevNode = null, nextNode;
        ListNode currentNode = head;
        while(currentNode!=null) {
        	nextNode = currentNode.getNext();
        	currentNode.setNext(prevNode);
        	prevNode = currentNode;
        	currentNode = nextNode;
        }
        return prevNode;
    }
	
	public static ListNode reverseListRec(ListNode head) {
		if(head==null  || head.getNext()== null) return head;
		ListNode next = head.getNext();
		ListNode newHead = reverseListRec(next);
		// The newHead points to the first node in the reversed linkedList
		head.getNext().setNext(head);
		head.setNext(null);
		return newHead;
	}

}
