package com.sthatiko.design.tictac;

import java.util.UUID;


public class Player {
    private String name;
    private Piece piece;
    private String id;
    public Player(String name, Piece p){
        this.name = name;
        this.piece = p;
        this.id = UUID.randomUUID().toString();
    }

    public String getName(){
        return name;
    }

    public Piece getPiece(){
        return piece;
    }
}
