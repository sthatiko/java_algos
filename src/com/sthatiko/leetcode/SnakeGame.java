package com.sthatiko.leetcode;

//https://leetcode.com/problems/design-snake-game/

import java.util.AbstractMap;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

class SnakeGame {
    Deque<AbstractMap.SimpleEntry<Integer,Integer>> snake;
    HashSet<AbstractMap.SimpleEntry<Integer,Integer>> snakeCells;
    int width, height;
    int[][] food;
    AbstractMap.SimpleEntry<Integer,Integer> head;
    int currentFoodIndex =0;
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        snake = new LinkedList<>();
        head = new AbstractMap.SimpleEntry<>(0,0);
        snake.add(head);
        snakeCells = new HashSet<>();
        snakeCells.add(head);

    }

    public int move(String direction) {
        if(isValidMove(direction)){
            head = getNewHead(direction);
            //remove tail first
            if(!hasFood(head.getKey(), head.getValue())){
                AbstractMap.SimpleEntry<Integer, Integer> tail = snake.removeLast();
                snakeCells.remove(tail);
            }else{
                currentFoodIndex +=1;
            }
            // add head
            snake.addFirst(head);
            snakeCells.add(head);
            return snake.size()-1;
        }else return -1;
    }

    private boolean isValidMove(String direction){

        switch(direction) {
            case "U":
                if(head.getKey() == 0) return false;
                break;
            case "D":
                if(head.getKey() == height-1) return false;
                break;
            case "L":
                if(head.getValue() == 0) return false;
                break;
            case "R":
                if(head.getValue() == width-1) return false;
                break;
        }
        if(snakeCells.contains(getNewHead(direction))){
            return snake.getLast().equals(getNewHead(direction));
        }else return true;
    }

    private AbstractMap.SimpleEntry<Integer, Integer> getNewHead(String direction){
        switch(direction) {
            case "U":
                return new AbstractMap.SimpleEntry<>(head.getKey() -1, head.getValue());
            case "D":
                return new AbstractMap.SimpleEntry<>(head.getKey() + 1, head.getValue());
            case "L":
                return new AbstractMap.SimpleEntry<>(head.getKey(), head.getValue() -1);
            case "R":
                return new AbstractMap.SimpleEntry<>(head.getKey(), head.getValue() +1);
            default:
                return null;
        }
    }

    private boolean hasFood(int row, int col){
        if(currentFoodIndex >= food.length) return  false;
        return food[currentFoodIndex][0] == row && food[currentFoodIndex][1] == col;
    }

    public static void main(String[] args) {
        SnakeGame game = new SnakeGame(3,3, new int[][]{{0,1},{0,2},{1,2},{2,2},{2,1},{2,0},{1,0}});
        System.out.println(game.move("R"));
        System.out.println(game.move("R"));
        System.out.println(game.move("D"));
        System.out.println(game.move("D"));
        System.out.println(game.move("L"));
        System.out.println(game.move("L"));
        System.out.println(game.move("U"));
        System.out.println(game.move("U"));
        System.out.println(game.move("R"));
        System.out.println(game.move("R"));
        System.out.println(game.move("D"));
        System.out.println(game.move("D"));
        System.out.println(game.move("L"));
        System.out.println(game.move("L"));
        System.out.println(game.move("U"));
        System.out.println(game.move("R"));
        System.out.println(game.move("U"));
        System.out.println(game.move("L"));
        System.out.println(game.move("D"));
    }
}
