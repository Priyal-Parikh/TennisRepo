package com.bnpp.kata;

public class TennisGame
{

    private final String playerOne;
    private final String playerTwo;

    public TennisGame(String playerOneName, String playerTwoName) {
        this.playerOne=playerOneName;
        this.playerTwo=playerTwoName;
    }

    public String getScore() {
        return "Love All";
    }

    /* getters */

    public String getPlayerOne() {
        return playerOne;
    }

    public String getPlayerTwo() {
        return playerTwo;
    }

}
