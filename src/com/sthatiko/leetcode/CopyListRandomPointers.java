package com.sthatiko.leetcode;

public class CopyListRandomPointers {

    public static void main(String[] args) {
        Solution sol = new Solution();
        Node head = new Node(7);
        head.next =  new Node(13);
        head.next.random = head;
        head.next.next =  new Node(11);
        head.next.next.random = head.next;

        sol.copyRandomList(head);
    }
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    static class Solution {
        public Node copyRandomList(Node head) {
            Node orig = head;
            Node copyHead = new Node(0);
            Node current = copyHead;
            Node temp;
            while(orig!=null){
                current.next = new Node(orig.val);
                current=current.next;
                orig=orig.next;
            }
            copyHead = copyHead.next;
            current=copyHead;
            orig=head;
            while(current!=null){
                current.random=orig;
                current=current.next;
                orig=orig.next;
            }
            current=copyHead;
            orig=head;
            while(orig!=null){
                temp = orig.next;
                orig.next=current;
                current = current.next;
                orig=temp;
            }
            current=copyHead;
            orig=head;
            while(current!=null){
                if(current.random.random!=null){
                    current.random=current.random.random.next;
                }else{
                    current.random = null;
                }
                current = current.next;
            }
            StringBuilder b = new StringBuilder("aa");
            return copyHead;
        }
    }
}
