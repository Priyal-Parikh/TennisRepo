package com.bnpp.kata;

public class TennisGame
{

    private final String playerOne;
    private final String playerTwo;
    private int playerOneScore;


    public TennisGame(String playerOneName, String playerTwoName) {
        this.playerOne=playerOneName;
        this.playerTwo=playerTwoName;
    }

    public String getScore()
    {
        return convertToReadableScore(0)+" All";
    }

    private String convertToReadableScore(int numericScore) {
        return "Love";
    }


    /* getters */

    public String getPlayerOne() {
        return playerOne;
    }

    public String getPlayerTwo() {
        return playerTwo;
    }

}
