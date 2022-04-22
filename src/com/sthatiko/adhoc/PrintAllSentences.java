package com.sthatiko.adhoc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PrintAllSentences {
    public static void main(String[] args) {
        String [][]arr  = {{"you", "we"},
                {"have", "are"},
                {"sleep", "eat", "drink"}};
        dfs(arr, 0).forEach(System.out::println);
    }

    public static List<String> dfs(String[][] arr, int index){
        if(index>=arr.length) return Collections.singletonList("");
        List<String> res = new ArrayList<>();
        for(String word: arr[index]){
            for(String word1: dfs(arr,index+1)){
                res.add(word+" "+word1);
            }
        }
        return res;
    }
}
