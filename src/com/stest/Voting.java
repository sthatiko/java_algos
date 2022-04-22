package com.stest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// A,B,C,D
// vote1 - A-1,B-2,C-3
// vote2 - A-3,B-2,C-0
// A - 4
// C- 5
// B - 3
// C, A, B
// A - [1,0,1]
// B - [1,1,0]
public class Voting {

    public static void main(String[] args) {
        Voting v = new Voting();
        List<Map<String, Integer>> votes = new ArrayList<>();
        Map<String,Integer> vote1 = new HashMap<>();
        Map<String,Integer> vote2 = new HashMap<>();
        Map<String,Integer> vote3 = new HashMap<>();

        vote1.put("A",1);
        vote1.put("B",2);
        vote1.put("C",3);

        vote2.put("A",3);
        vote2.put("B",2);
        vote2.put("C",1);

        vote3.put("A",2);
        vote3.put("B",2);
        vote3.put("C",3);

        votes.add(vote2);
        votes.add(vote1);
        votes.add(vote3);


        System.out.println(v.getWinners(votes));
    }

    public List<String> getWinners(List<Map<String, Integer>> votes) {
        Map<String, Integer> result = new HashMap<>();
        Map<String, int[]> ranks = new HashMap<>();
        for (Map<String,Integer> vote: votes) {
            int i =0;
            for(String candidate: vote.keySet()){
                System.out.println("can:" + candidate + " :" + vote.get(candidate));
                int[] candRanks = ranks.getOrDefault(candidate, new int[3]);
                candRanks[i] +=1;
                ranks.put(candidate, candRanks);
                result.put(candidate, result.getOrDefault(candidate,0) + vote.get(candidate));
                i++;
            }
        }
        List<Map.Entry<String,Integer>> sortedEntries = result.entrySet().stream().sorted((e1,e2)-> {
            if(e2.getValue().compareTo(e1.getValue()) == 0){
                int[] e1Ranks = ranks.get(e1.getKey());
                int[] e2Ranks = ranks.get(e2.getKey());

                for(int i=2;i>=0;i--){
                    if(e2Ranks[i] == e1Ranks[i]){
                        continue;
                    }
                    return e2Ranks[i] - e1Ranks[i];
                }
            }
           return e2.getValue().compareTo(e1.getValue());
        }).collect(Collectors.toList());
        List<String> res = new ArrayList<>();
        System.out.println(sortedEntries);
        for(Map.Entry<String,Integer> e : sortedEntries){
            res.add(e.getKey());
        }
        return res.subList(0,3);
    }

}
