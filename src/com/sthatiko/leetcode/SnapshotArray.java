package com.sthatiko.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SnapshotArray {
    // record changes instead for each element of array
    List<int[]>[] history;
    int snapId;
    public SnapshotArray(int length) {
        this.history = new List[length];
        this.snapId = 0;
        // initialize
        for(int i = 0 ;i<length;i++){
            history[i] = new ArrayList<>();
            history[i].add(new int[]{this.snapId,0});
        }
    }

    public void set(int index, int val) {
        List<int[]> indexHistory = this.history[index];
        if(indexHistory.get(indexHistory.size() -1)[0] == snapId){
            // there was no new snapshot taken since the last update to this index
            indexHistory.get(indexHistory.size() -1)[1] = val;
        }else{
            indexHistory.add(new int[]{snapId, val});
        }
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snap_id) {
        List<int[]> indexHistory = this.history[index];
        int snapIndex = Collections.binarySearch(indexHistory, new int[]{snap_id,0}, (a,b) -> Integer.compare(a[0],b[0]));
        if(snapIndex<0){// it means that this index was not set a value for the given snapshot id]
            // read binarySearch documentation to understand below line
            snapIndex = -snapIndex -2;
        }
        return indexHistory.get(snapIndex)[1];
    }

    // MLE below implementation
    // if we can somehow return element value for given snapshot, it should suffice.
    // it doesn't necessarily mean we make a copy of it to achieve it.
    // Making a copy for each snapshot resulting in MLE
//     int[] dataStore ;
//     int snapId;
//     Map<Integer, int[]> snapShots;

//     public SnapshotArray(int length) {
//         this.dataStore = new int[length];
//         this.snapId = 0;
//         this.snapShots = new HashMap<>();
//     }

//     public void set(int index, int val) {
//         this.dataStore[index] = val;
//     }

//     public int snap() {
//         snapShots.put(snapId,Arrays.copyOf(dataStore, dataStore.length));
//         return snapId++;
//     }

//     public int get(int index, int snap_id) {
//         return snapShots.get(snap_id)[index];
//     }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
