package com.sthatiko.design.tictac;

import java.util.Date;

public class Piece {
    private final char representation;

    public Piece(char c){
      this.representation = c;
    }

    public char getRepresentation(){
        return this.representation;
    }
}
