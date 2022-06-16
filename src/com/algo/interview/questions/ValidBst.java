package com.algo.interview.questions;

import java.util.Deque;
import java.util.LinkedList;

import com.datastructure.TreeNode;

public class ValidBst {

	public static void main(String[] args) {
		TreeNode root = TreeNode.insert(new Integer[]{5,1,4,null,null,3,6});
//		System.out.println(isValidBST(root));
		TreeNode root1 = TreeNode.insert(new Integer[]{2,1,3});
		System.out.println(isValidBST(root1));
	}
	
	public static boolean isValidBST(TreeNode root) {
		Deque<Integer> stack = new LinkedList<Integer>();
         inOrderTraversal(root, stack);
         if(!stack.isEmpty()) {
        	 stack.removeFirst();
         }
         return stack.isEmpty();
    }
    
    public static void inOrderTraversal(TreeNode node, Deque<Integer> stack){
        if(node==null) return;
        if(node.left != null){
            inOrderTraversal(node.left, stack);
        }
        
        Integer prev = null;
        if(!stack.isEmpty()) {
        	prev = stack.peekFirst();
        }
        if(prev!=null && prev < node.val) {
        	stack.removeFirst(); // remove the older value 
        }
        stack.addFirst(node.val);
        if(node.right != null){
            inOrderTraversal(node.right, stack);
        }
   
    }

}
