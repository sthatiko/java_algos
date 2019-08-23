package com.sthatiko.ds;

import java.util.HashMap;
// Also known as prefix tree
class Trie {

    private TrieNode root;

    static class TrieNode{
        boolean end;
        char c;
        HashMap<Character,TrieNode> nodes = new HashMap<>();
    }

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = this.root;
        for(char c: word.toCharArray()){
            TrieNode t = cur.nodes.getOrDefault(c,null);
            if(t == null){
                t = new TrieNode();
                t.c=c;
                cur.nodes.put(c,t);
            }
            cur = t;
        }
        cur.end=true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = this.root;
        for(char c: word.toCharArray()){
            TrieNode t = cur.nodes.getOrDefault(c,null);
            if(t == null){
               return false;
            }
            cur = t;
        }
        return cur.end;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = this.root;
        for(char c: prefix.toCharArray()){
            TrieNode t = cur.nodes.getOrDefault(c,null);
            if(t == null){
                return false;
            }
            cur = t;
        }
        return true;
    }

    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("sthatiko");
        boolean param_2 = obj.startsWith("sthatiko");
        System.out.println(param_2);
    }
}