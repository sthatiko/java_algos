package com.sthatiko.design.tictac;

public class Board {
    private int size;
    private int[][] board ;
    public Board(int size){
        this.size = size;
        this.board = new int[size][size];
    }
    public Board(){
        this.size = 3;
        this.board = new int[3][3];
    }

    public boolean isValidMove(int r, int c){
        return board[r][c] == 0;
    }

    public boolean set(int r, int c, char piece){
        this.board[r][c] = piece;
        print();
        return gameWon(r,c, piece);
    }

    public boolean gameWon(int r, int c, char piece){
        int rowCount =0 ,columnCount =0, diagCount = 0, reverseDiagCount = 0;

        for(int i =0; i< size; i++){
            if(board[r][i] == piece) rowCount++;
        }
        for(int i =0; i< size; i++){
            if(board[i][c] == piece) columnCount++;
        }
        if(r == c){
            for(int i =0; i< size; i++){
                if(board[i][i] == piece) diagCount++;
            }
        } else if ( r == size-1-c){
            for(int i =0; i< size; i++){
                if(board[i][size-i-1] == piece) reverseDiagCount++;
            }
        }
        return rowCount == size || columnCount == size || diagCount == size || reverseDiagCount == size;
    }

    public boolean isFull(){
        int emptyCount =0;
        for(int i =0; i< size; i++){
            for ( int j=0;j<size;j++)
                if(board[i][j] == 0) emptyCount++;
        }
        return emptyCount == 0;
    }

    public void print(){
        for(int i =0; i< size;i++){
            for(int j= 0; j< size; j++){
                if(board[i][j] == 0)
                    System.out.print(" - ");
                System.out.print(" " + (char)board[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
