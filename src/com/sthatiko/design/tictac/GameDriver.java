package com.sthatiko.design.tictac;

import java.util.Scanner;

public class GameDriver {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Name of Player 1:");
        String playerName1 = s.next();
        System.out.println("Piece you want to play for player 1. Char X or O");
        Piece player1Piece = new Piece(s.next().charAt(0));
        System.out.println("Name of Player 2:");
        String playerName2 = s.next();
        System.out.println("Piece you want to play for player 1. ");
        Piece player2Piece = new Piece(s.next().charAt(0));
        System.out.println("Size of board:");
        int size = s.nextInt();
        Player p1 = new Player(playerName1, player1Piece);
        Player p2 = new Player(playerName2, player2Piece);
        Game g = new Game(p1,p2,size);
        g.startGame();
    }
}
