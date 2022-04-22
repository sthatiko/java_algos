package com.sthatiko.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SnapshottableMap {

    public static void main(String[] args) {
        SnapshottableMap map = new SnapshottableMap();
        Snapshot s0 = map.createSnapshot();
        System.out.println(s0.get("name")); // null

        map.put("name", "John");
        map.put("country", "UK");
        Snapshot s1 = map.createSnapshot();

        System.out.println(s1.get("name")); // "John"
        System.out.println(s1.get("country")); // "UK"

        map.put("name", "Marta");
        Snapshot s2 = map.createSnapshot();

        System.out.println(s2.get("name")); // "Marta"
        System.out.println(s2.get("country")); // "UK"
        System.out.println(s1.get("name")); // "John"
        Snapshot s3 = map.createSnapshot();
        System.out.println(s3.get("country")); // "UK"
    }

    int snapId;
    List<Snapshot> snapShots;
    Map<String, Map<Integer, String>> elementsHistory ;

    public SnapshottableMap(){
        elementsHistory = new HashMap<>();
        snapShots = new ArrayList<>();
        snapId = 0;
    }
    public void put(String key, String value){
        if(elementsHistory.containsKey(key)){
            Map<Integer, String> elementHistory = elementsHistory.get(key);
            if(elementHistory.containsKey(snapId)){
                elementHistory.put(snapId,value);
            }else{
                elementHistory.put(snapId,value);
            }
        }else{
            Map<Integer,String> elementHistory = new LinkedHashMap<>();
            elementHistory.put(snapId, value);
            elementsHistory.put(key, elementHistory);
        }
    }
    public String get(String key){
        return elementsHistory.get(key).get(snapId);
    }
    public Snapshot createSnapshot(){
        Snapshot s = new Snapshot(snapId++, elementsHistory);
        snapShots.add(s);
        return s;
    }
    List<Snapshot> getSnapshots(){
        return snapShots;
    }

    static class Snapshot{
        int snapshotId;
        Map<String, Map<Integer, String>> elementsHistory ;
        public String get(String key){
            if(elementsHistory.containsKey(key)) {
                if(elementsHistory.get(key).containsKey(snapshotId))
                    return elementsHistory.get(key).get(snapshotId);
                else {
                    // this element was not modified in this snapshot
                    List<String> vals = new ArrayList<>(elementsHistory.get(key).values());
                    return vals.get(vals.size()-1);
                }
            } else return null;
        }

        public Snapshot(int snapshotId, Map<String, Map<Integer, String>> elementsHistory){
            this.snapshotId = snapshotId;
            this.elementsHistory = elementsHistory;
        }
    }
}
