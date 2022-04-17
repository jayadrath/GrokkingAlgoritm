package com.datastructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class BinarySearchTree {
	class Node {
		private int val;
		private Node leftNode;
		private Node rightNode;
		
		public Node(int val, Node leftNode, Node rightNode) {
			this.setVal(val);
			this.setLeftNode(leftNode);
			this.setRightNode(rightNode);
		}

		public int getVal() {
			return val;
		}

		public void setVal(int val) {
			this.val = val;
		}

		public Node getLeftNode() {
			return leftNode;
		}

		public void setLeftNode(Node leftNode) {
			this.leftNode = leftNode;
		}

		public Node getRightNode() {
			return rightNode;
		}

		public void setRightNode(Node righNode) {
			this.rightNode = righNode;
		}
	}
	
	Node root = null;
	
	public void insert(int val) {
		if(root == null) {
			root = new Node(val, null, null);
		return;
		}
		Node currentNode = root;
		while(currentNode!=null) {
			if(currentNode.getVal()>= val) {
				if(currentNode.getLeftNode()==null) {
					currentNode.setLeftNode(new Node(val, null, null));
					return;
				}
				currentNode = currentNode.getLeftNode();
			}
			else {
				if(currentNode.getRightNode()==null) {
					currentNode.setRightNode(new Node(val, null, null));
					return;
				}
				currentNode = currentNode.getRightNode();
			}
		}
		currentNode = new Node(val, null, null);
	}
	
	public List<Integer> breadthFirstSearch() {
		if(root == null) {
			System.out.println("Tree is empty");
			return null;
		}
		List<Integer> traversalList = new ArrayList<Integer>();
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while(queue.size() > 0) {
			Node currentNode = queue.remove();
			traversalList.add(currentNode.getVal());
			if(currentNode.getLeftNode()!=null) {
				queue.add(currentNode.getLeftNode());
			}
			
			if(currentNode.getRightNode()!=null) {
				queue.add(currentNode.getRightNode());
			}
		}
		return traversalList;
	}
	public List<Integer> depthFirstSearchInOrder(){
		return traverseInOrder(root, new ArrayList<Integer>());
	}
	
	public List<Integer> depthFirstSearchPreOrder(){
		return traversePreOrder(root, new ArrayList<Integer>());
	}
	
	public List<Integer> depthFirstSearchPostOrder(){
		return traversePostOrder(root, new ArrayList<Integer>());
	}
	
	
	
	
	private List<Integer> traverseInOrder(Node currentNode, ArrayList<Integer> arrayList) {
		if(currentNode == null) {
			return arrayList;
		}
		if(currentNode.getLeftNode()!=null) {
			traverseInOrder(currentNode.getLeftNode(), arrayList);
		}
		arrayList.add(currentNode.getVal());
		if(currentNode.getRightNode()!=null) {
			traverseInOrder(currentNode.getRightNode(), arrayList);
		}
		return arrayList;
	}

	private List<Integer> traversePreOrder(Node currentNode, ArrayList<Integer> arrayList) {
		if(currentNode == null) {
			return arrayList;
		}
		arrayList.add(currentNode.getVal());
		if(currentNode.getLeftNode()!=null) {
			traversePreOrder(currentNode.getLeftNode(), arrayList);
		}
		if(currentNode.getRightNode()!=null) {
			traversePreOrder(currentNode.getRightNode(), arrayList);
		}
		return arrayList;
	}
	
	private List<Integer> traversePostOrder(Node currentNode, ArrayList<Integer> arrayList) {
		if(currentNode == null) {
			return arrayList;
		}
		if(currentNode.getLeftNode()!=null) {
			traversePostOrder(currentNode.getLeftNode(), arrayList);
		}
		if(currentNode.getRightNode()!=null) {
			traversePostOrder(currentNode.getRightNode(), arrayList);
		}
		arrayList.add(currentNode.getVal());
		return arrayList;
	}
	
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(9);
		tree.insert(6);
		tree.insert(11);
		tree.insert(4);
		tree.insert(8);
		tree.insert(10);
		tree.insert(12);
		/**
		 *  	   	9
		 * 	 	6     	11
		 *   4    8   10  12
		 */
//		List<Integer> list = tree.breadthFirstSearch();
		List<Integer> list = tree.depthFirstSearchInOrder();
		System.out.println(list.stream().map(String::valueOf).collect(Collectors.joining(" ,")));
		list = tree.depthFirstSearchPreOrder();
		System.out.println(list.stream().map(String::valueOf).collect(Collectors.joining(" ,")));
		list = tree.depthFirstSearchPostOrder();
		System.out.println(list.stream().map(String::valueOf).collect(Collectors.joining(" ,")));
	}
}
