package com.sthatiko.leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class LongestAbsoluteFilePath {
    public static void main(String[] args) {
        LongestAbsoluteFilePath driver = new LongestAbsoluteFilePath();
        int result = driver.lengthLongestPath("dir\\n\\tsubdir1\\n\\t\\tfile1.ext\\n\\t\\tsubsubdir1\\n\\tsubdir2\\n\\t\\tsubsubdir2\\n\\t\\t\\tfile2.ext");
        System.out.println(result);
    }
    public int lengthLongestPath(String input) {
        Stack<String> stack = new Stack<>();
        if(input == null || input.isEmpty()){
            return 0;
        }
        String[] names = input.split("\n\t");
        for(String name: names){
            stack.push(name);
        }
        ArrayList<String> files = new ArrayList<>();
        while(!stack.isEmpty()){
            String name = stack.pop();
            if(name.contains(".")) files.add(name);
            else{
                for(int i=0;i< files.size();i++){
                    files.add(i,name + "/"+files.get(i));
                }
            }
        }
        return files.stream().mapToInt(String::length).max().getAsInt();
    }
}
