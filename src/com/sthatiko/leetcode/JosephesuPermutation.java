package com.sthatiko.leetcode;

public class JosephesuPermutation {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findTheWinner(4,2));
    }
    static class DLLNode{
        DLLNode prev;
        DLLNode next;
        int val;
        public DLLNode(int val){
            this.val = val;
        }
    }
    static class Solution {
        public int findTheWinner(int n, int k) {
            DLLNode head=null,current=null;
            for(int i=1;i<=n;i++){
                if(head==null){
                    head = new DLLNode(i);
                    current = head;
                }else{
                    current.next = new DLLNode(i);
                    current.next.prev = current;
                    current = current.next;
                }
            }
            head.prev = current;
            current.next = head;
            int count = 1;
            while( head.next != head){
                if(count%k==0){
                    // remove head
                    head.prev.next = head.next;
                    head.next.prev = head.prev;
                    head = head.next;
                    count = 1;
                }else {
                    head = head.next;
                    count++;
                }
            }
            return head.val;
        }
    }
}
