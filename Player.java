/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player;

/**
 *
 * @author lakshay
 */
public class Player {

    private char pawn;
    private String name;
    private boolean turn;
    public char getPawn() {
        return pawn;
    }

    public void setPawn(char pawn) {
        this.pawn = pawn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

}
