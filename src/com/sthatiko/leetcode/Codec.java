package com.sthatiko.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Codec {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left =  new TreeNode(2);
        root.right =  new TreeNode(3);
        root.right.left =  new TreeNode(-4);
        root.right.right =  new TreeNode(5);
        root.right.left.left =  new TreeNode(6);
        root.right.left.right =  new TreeNode(7);
        Codec codec = new Codec();
        System.out.println(codec.serialize(root));
        codec.deserialize(codec.serialize(root));
    }

    // Encodes a tree to a single string.
    StringBuilder s = new StringBuilder();
    public String serialize(TreeNode root) {
        serializeHelper(root);
        return s.toString().trim();
    }

    public void serializeHelper(TreeNode root) {
        if(root == null) s.append(" #");
        else{
            s.append(" ").append(root.val);
            serializeHelper(root.left);
            serializeHelper(root.right);
        }
    }


    // Decodes your encoded data to tree.
    String[] sdata;
    public TreeNode deserialize(String data) {
        sdata = data.split(" ");
        return deserializeHelper();
    }

    public TreeNode deserializeHelper() {
        String c = next();
        if("#".equals(c) ) return null;
        TreeNode root = new TreeNode(Integer.parseInt(c));
        root.left = deserializeHelper();
        root.right = deserializeHelper();
        return root;
    }
    int i =0;
    private String next(){
        if(i>=sdata.length) return null;
        return sdata[i++];
    }


}