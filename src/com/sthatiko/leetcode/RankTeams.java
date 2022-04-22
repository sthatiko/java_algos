package com.sthatiko.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

//https://leetcode.com/problems/rank-teams-by-votes/
public class RankTeams {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] votes = new String[]{"ZMNAGUEDSJYLBOPHRQICWFXTVK"};
        System.out.println(sol.rankTeams(votes));
        
    }

    static class Solution {

        class Team implements Comparable<Team>{
            Character name;
            int[] ranks;

            public Team(Character name, int numOfTeams){
                this.name = name;
                ranks = new int[numOfTeams];
            }

            public int[] getRanks() {
                return ranks;
            }

            @Override
            public int compareTo(Team o) {
                int[] oRanks = o.getRanks();
                for(int i=0;i< ranks.length; i++){
                    if(ranks[i]!= oRanks[i]){
                        return oRanks[i]-ranks[i];
                    }
                }
                return name.compareTo(o.name);
            }
        }
        public String rankTeams(String[] votes) {// constructs an array by ranks
            // 
            int voters = votes.length;
            int numOfTeams = votes[0].length();
            Map<Character, Team> teams = new HashMap<>();
            for(String vote : votes) {
                for(int i=0;i<numOfTeams;i++){
                    Character teamName = vote.charAt(i);
                    Team team = teams.getOrDefault(teamName, new Team(teamName, numOfTeams));
                    team.getRanks()[i] += 1;
                    teams.put(teamName, team);
                }
            }
            List<Team> list = new ArrayList<>(teams.values());
            Collections.sort(list);
            StringBuilder sb = new StringBuilder();
            for(Team t: list){
                sb.append(t.name);
            }
            return sb.toString();
        }

    
    }
    
}
