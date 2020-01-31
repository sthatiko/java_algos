package com.sthatiko.adhoc;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class TreeNode{
    int val;
    TreeNode left, right;
    TreeNode(int val){
        this.val = val;
    }
    public boolean hasLeft(){
        return left != null;
    }

    public boolean hasRight(){
        return right != null;
    }

    public boolean isLeaf(){
        return left==null && right==null;
    }

}

public class BinaryTree {

    private void preOrder(TreeNode node){
        if(node==null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()) {
            node = stack.pop();
            System.out.print(node.val);
            if(node.hasRight()) stack.push(node.right);
            if(node.hasLeft()) stack.push(node.left);
        }
        HashMap m = new HashMap();
        int[] a = new int[node.val];
    }

    private void postOrder(TreeNode node){
        if(node==null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()) {
            node = stack.peek();
            if(node.isLeaf()){
                System.out.println(node);
                stack.pop();
            }
            if(node.hasRight()) stack.push(node.right);
            if(node.hasLeft()) stack.push(node.left);
        }
    }




    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(2);
        BinaryTree tree = new BinaryTree();
        tree.preOrder(root);
        tree.postOrder(root);
    }
}
