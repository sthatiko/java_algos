package com.sthatiko.adhoc;

// https://leetcode.com/problems/find-median-from-data-stream/

import java.util.Comparator;
import java.util.PriorityQueue;

public class RunningMedian {
    private PriorityQueue<Integer> leftHeap;// max heap
    private PriorityQueue<Integer> rightHeap;// min heap

    private int count;

    public RunningMedian() {
        this.rightHeap = new PriorityQueue<>();// default pq implementation. min at top.
        this.leftHeap = new PriorityQueue<>(Comparator.reverseOrder());
        this.count = 0;
    }

    public void insertNumber(int n){
        if(rightHeap.size() == leftHeap.size()){
            if(n>=getMedian()){
                rightHeap.offer(n);
            }else{
                leftHeap.offer(n);
            }
        }
        else if(leftHeap.size() <= rightHeap.size()) {
            if(n<getMedian()){
                leftHeap.offer(n);
            }else{
              leftHeap.offer(rightHeap.poll());
              rightHeap.offer(n);
            }
        }
        else{
            if(n<getMedian()){
                rightHeap.offer(leftHeap.poll());
                leftHeap.offer(n);
            }else{
                rightHeap.offer(n);
            }
        }
        count++;
    }

    public double getMedian(){
        if(count == 0) return 0;
        if(rightHeap.size() == leftHeap.size()){
            return (rightHeap.peek() + leftHeap.peek()) +0d/2;
        }else if(rightHeap.size() > leftHeap.size()){
            return rightHeap.peek();
        }else{
            return leftHeap.peek();
        }
    }

    public static void main(String[] args) {
        RunningMedian rm = new RunningMedian();
        System.out.println(rm.getMedian());
        rm.insertNumber(1);
        System.out.println(rm.leftHeap);
        System.out.println(rm.rightHeap);
        System.out.println(rm.getMedian());
        rm.insertNumber(7);
        System.out.println(rm.leftHeap);
        System.out.println(rm.rightHeap);
        System.out.println(rm.getMedian());
        rm.insertNumber(3);
        System.out.println(rm.leftHeap);
        System.out.println(rm.rightHeap);
        System.out.println(rm.getMedian());
        rm.insertNumber(20);
        System.out.println(rm.leftHeap);
        System.out.println(rm.rightHeap);
        System.out.println(rm.getMedian());
        rm.insertNumber(9);
        System.out.println(rm.leftHeap);
        System.out.println(rm.rightHeap);
        System.out.println(rm.getMedian());
    }
}
