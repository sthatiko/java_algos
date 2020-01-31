package com.sthatiko.leetcode;

import java.util.LinkedList;
import java.util.Queue;

class MinDepth {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int minDepth(MinDepth.TreeNode root) {
        int result = 0 ;
        if (root == null ) return result;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        int s = q.size();
        while(s > 0){
            result++;
            for(; s>0;s--){
                root = q.removeFirst();
                if (root.left == null && root.right == null) return result;
                if(root.left != null)q.addLast(root.left);
                if(root.right != null)q.addLast(root.right);
            }
            s = q.size();
        }
        return result;
    }

    public static void main(String[] args) {
        MinDepth s = new MinDepth();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(s.minDepth(root));
    }
}