package com.sthatiko.leetcode;

class MinStack {

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(2);
        obj.push(3);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
    }

    Node head;

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int val) {
        if(head == null) {
            head = new Node(val);
            head.min = val;
        }else{
            Node temp = new Node(val);
            temp.next = head;
            temp.min=Math.min(val,head.min);
            head = temp;
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return  head.min;
    }

    class Node{
        Node next;
        int val;
        int min;

        public Node(int val){
            this.val = val;
        }
    }
}
