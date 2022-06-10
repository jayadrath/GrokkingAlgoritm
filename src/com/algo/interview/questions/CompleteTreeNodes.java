package com.algo.interview.questions;

import com.datastructure.TreeNode;

public class CompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int treeHeight = getTreeHeight(root);
        if(treeHeight == 0) return 1;
        int upperCount = (1 << treeHeight) - 1;
        int left = 0, right = upperCount;
        int count = 0;
        while(left < right){
            int midIdx = (int) Math.ceil((double)(left+right)/2);
            if(nodeExists(root, midIdx, treeHeight)){
                left = midIdx;
            }
            else{
                right = midIdx -1;
            }
        }
        count = upperCount + left + 1;
        return count;
    }
    
    public int getTreeHeight(TreeNode node){
        int height = 0;
        while(node.left!=null){
            height++;
            node = node.left;
        }
        return height;
    }
    
    public boolean nodeExists(TreeNode node, int idxToFind, int height){
        int count = 0;
        int left = 0, right = (1 << height) - 1;
        while(count < height){
            int mid = (int) Math.ceil(((double)left + right)/2);
            if(idxToFind >= mid){
                node = node.right;
                left = mid;
            }
            else{
                node = node.left;
                right = mid -1;
            }
            count++;
        }
    return node!=null;    
    }
    
    public static void main(String[] args) {
    	CompleteTreeNodes treeNodes = new CompleteTreeNodes();
    	TreeNode root = TreeNode.insert(new Integer[]{1,2,3,4,5,6});
    	System.out.println(" Count of nodes in the tree "+ treeNodes.countNodes(root));
	}
}
