package com.datastructure;

public class LinkedList {
	Node head;
	
	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	static class Node {
		Node next;
		int data;
		
		Node(int data){
			this.data = data;
		}

		public Node() {
		}

		public Node(Node next, int data) {
			super();
			this.next = next;
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}
		
	}
	
	public static LinkedList insert(LinkedList list, int data) {
		Node node = new Node(data);
		if (list.getHead() == null) {
			list.setHead(node);
			
		}else {
			Node currentNode = list.getHead();
			while(currentNode.getNext()!=null) {
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(node);
			
		}
		return list;
	}
	
}
