package com.sthatiko.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class Twitter {
    public static void main(String[] args) {
        Twitter t = new Twitter();
        t.postTweet(1,5);
        System.out.println(t.getNewsFeed(1));
        t.follow(1,2);
        t.postTweet(2,6);
        System.out.println(t.getNewsFeed(1));

    }

    Map<Integer,Integer> feed = new LinkedHashMap<>();
    Map<Integer, Set<Integer>> followers = new HashMap<>();


    /** Initialize your data structure here. */
    public Twitter() {

    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        feed.put(tweetId, userId);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> userFollowers = new HashSet<>();
        if(followers.containsKey(userId)){
            userFollowers.addAll(followers.get(userId));
        }
        userFollowers.add(userId);
        List<Integer> list = new ArrayList<>(feed.keySet());
        ListIterator<Integer> li =list.listIterator(list.size());
        int count =0;
        while(li.hasPrevious()){
            Integer tid = li.previous();
            Integer uid = feed.get(tid);
            if(userFollowers.contains(uid)){
                result.add(tid);
                count++;
            }
            if(count == 10) break;
        }
        return result;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!followers.containsKey(followerId)){
            followers.put(followerId, new HashSet<>());
        }
        followers.get(followerId).add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followers.containsKey(followerId)){
            followers.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
