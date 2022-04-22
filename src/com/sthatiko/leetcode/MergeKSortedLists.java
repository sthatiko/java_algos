package com.sthatiko.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static void main(String[] args) {
        // [[1,4,5],[1,3,4],[2,6]]
        ListNode n3 = new ListNode(5);
        ListNode n2 = new ListNode(4, n3);
        ListNode n1 = new ListNode(1, n2);
        ListNode n6 = new ListNode(4);
        ListNode n5 = new ListNode(3, n6);
        ListNode n4 = new ListNode(1, n5);
        ListNode n8 = new ListNode(6);
        ListNode n7 = new ListNode(2, n8);
        Solution sol = new Solution();
        ListNode[] input = new ListNode[]{n1,n4,n7};
        ListNode result = sol.mergeKLists(input);
        while(result.next !=null){
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListIterator> pq = new PriorityQueue<>(Comparator.comparing( e -> e.head.val));
            for(ListNode node: lists){
                if(node !=null) {
                    pq.offer(new ListIterator(node));
                }
            }
            ListNode head = null, current=null;
            ListIterator itr = null;
            while(!pq.isEmpty()){
                itr = pq.poll();
                if(head == null){
                    head = itr.head;
                    current = head;
                }else {
                    current.next = itr.head;
                    current = current.next;
                }
                if(itr.advance()){
                    pq.offer(itr);
                }
            }
            return head;
        }
    }

    static class ListIterator{
        ListNode head;
        public ListIterator(ListNode node){
            this.head = node;
        }

        public boolean advance(){
            if(head !=null && head.next != null){
                head = head.next;
                return true;
            }
            return false;
        }

        public boolean hasNext(){
           return head.next != null;
        }
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
