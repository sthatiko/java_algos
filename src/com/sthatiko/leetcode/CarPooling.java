package com.sthatiko.leetcode;

//https://leetcode.com/problems/car-pooling/

import java.util.TreeMap;

class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        TreeMap<Integer,Integer> locations = new TreeMap<>();
        int n = trips.length;
        for(int i=0; i<n;i++){
            int[] t = trips[i];
            locations.put(t[1],locations.getOrDefault(t[1],0) + t[0]);
            locations.put(t[2],locations.getOrDefault(t[2],0) - t[0]);
        }
        for(Integer passengers: locations.values()){
            capacity -= passengers;
            if(capacity < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        CarPooling c = new CarPooling();
        int[][] trips = new int[][]{new int[]{4,5,6},new int[] {6,4,7}, new int[]{4,3,5}, new int[]{2,3,5}};
        System.out.println(c.carPooling(trips, 13));
    }
}