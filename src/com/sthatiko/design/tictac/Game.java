package com.sthatiko.design.tictac;

import java.util.Scanner;
import java.util.UUID;

public class Game {
    private String id;
    private Player player1,player2;
    private Board gameBoard;
    private boolean player1Turn = true;
    private Scanner s;
    public Game(Player p1, Player p2, int boardSize){
        this.player1 = p1; // -1 for player 1
        this.player2 = p2; // +1 for player 2
        this.gameBoard = new Board(boardSize);
        this.id = UUID.randomUUID().toString();
        this.s = new Scanner(System.in);
    }
    public boolean makeMove(Player player, int row, int col){
        return gameBoard.set(row,col,player.getPiece().getRepresentation());
    }

    public void startGame(){
        while(true) {
            if (player1Turn) {
                System.out.println(player1.getName() + "'s turn. Enter row and column position separated by space.");
                int row = s.nextInt();
                int col = s.nextInt();
                if(gameBoard.isValidMove(row,col)) {
                    if(makeMove(player1, row, col)){
                        System.out.println("Game Over. Winner is " + player1.getName() );
                        break;
                    }
                    player1Turn = !player1Turn;
                }else{
                    System.out.println("Invalid Move. Try again");
                }
            } else {
                System.out.println(player2.getName() + "'s turn. Enter row and column position separated by space.");
                int row = s.nextInt();
                int col = s.nextInt();
                if(gameBoard.isValidMove(row,col)) {
                    if(makeMove(player2, row, col)){
                        System.out.println("Game Over. Winner is " + player1.getName() );
                        break;
                    }
                    player1Turn = !player1Turn;
                }else{
                    System.out.println("Invalid Move. Try again");
                }
            }
            if (gameBoard.isFull()){
                System.out.println("Game Draw.");
                break;
            }
        }
    }


}
