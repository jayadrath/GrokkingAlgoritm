package com.algo.interview.questions;

import com.datastructure.TreeNode;

public class ValidBstPreOrder {

	public static void main(String[] args) {
		TreeNode root = TreeNode.insert(new Integer[]{5,1,4,null,null,3,6});
		System.out.println(isValidBST(root));
		TreeNode root1 = TreeNode.insert(new Integer[]{2,1,3});
		System.out.println(isValidBST(root1));
	}
	
	public static boolean isValidBST(TreeNode root) {
         return preOrderTraversal(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }
    
    public static boolean preOrderTraversal(TreeNode node,  Double lowerBound, Double upperBound){
    	if(node==null) return true;
    	double val = Double.valueOf(node.val);
    	if(val<= lowerBound || val>=upperBound) {
        	return false;
        }
        
        return preOrderTraversal(node.left, lowerBound, val) && preOrderTraversal(node.right, val, upperBound);
   
    }

}
