package com.datastructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;


//  Definition for a binary tree node.
  public class TreeNode {
      public int val;
      public TreeNode left;
      public TreeNode right;
      TreeNode() {}
      public TreeNode(int val) { this.val = val; }
      public TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
      
      public static TreeNode insert(Integer[] arr) {
    	  if(arr.length == 0 || arr[0] == null) return null;
    	  TreeNode root = new TreeNode(arr[0]);
    	  Queue<TreeNode> queue = new LinkedList<>();
    	  queue.add(root);
    	  boolean leftVisited = false, rightVisited = false;
    	  for(int i = 1; i< arr.length; i++) {
    		  TreeNode elem = queue.peek();
    		  if(elem.left==null && !leftVisited) {
    			  leftVisited = true;
    			  rightVisited = false;
    			  if(arr[i]!=null) {
    				  elem.left = new TreeNode(arr[i]);
    				  queue.add(elem.left);
    			  }
    		  }
    		  else if(elem.right==null && !rightVisited) {
    			  rightVisited = true;
    			  leftVisited = false;
    			  if(arr[i]!=null) {
    				  elem.right = new TreeNode(arr[i]);
    				  queue.add(elem.right);
    			  }
    			  queue.remove();
    		  }
    	  }
    	  return root;
      }
      
      public static List<Integer> breadthFirstSearch(TreeNode root) {
  		if(root == null) {
  			System.out.println("Tree is empty");
  			return null;
  		}
  		List<Integer> traversalList = new ArrayList<Integer>();
  		Queue<TreeNode> queue = new LinkedList<>();
  		queue.add(root);
  		while(queue.size() > 0) {
  			TreeNode currentNode = queue.remove();
  			traversalList.add(currentNode.val);
  			if(currentNode.left!=null) {
  				queue.add(currentNode.left);
  			}
  			
  			if(currentNode.right!=null) {
  				queue.add(currentNode.right);
  			}
  		}
  		return traversalList;
  	}
      
    public static void main(String[] args) {
		TreeNode root = insert(new Integer[]{1,2,3,4,5,6});
		List<Integer> list = breadthFirstSearch(root);
		System.out.println(list.stream().map(String::valueOf).collect(Collectors.joining(" ,")));
	}
      
  }
  
 
