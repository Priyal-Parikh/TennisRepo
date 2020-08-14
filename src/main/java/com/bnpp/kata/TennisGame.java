package com.bnpp.kata;

public class TennisGame
{

    public static final int ZERO = 0;
    private final String playerOne;
    private final String playerTwo;
    private int playerTwoScore;
    private int playerOneScore;


    public TennisGame(String playerOneName, String playerTwoName) {
        this.playerOne=playerOneName;
        this.playerTwo=playerTwoName;

        this.playerOneScore=ZERO;
        this.playerTwoScore=ZERO;
    }

    public String getScore()
    {
        if(playerOneScore==playerTwoScore){
            return convertToReadableScore(playerOneScore)+" All";
        }

        return convertToReadableScore(playerOneScore)+","+convertToReadableScore(playerTwoScore);
    }

    private String convertToReadableScore(int numericScore) {
        switch(numericScore)
        {
            case ZERO:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                throw new IllegalArgumentException("Incorrect score "+numericScore);
        }
    }

    public void playerOneScores() {
        this.playerOneScore++;
    }

    /* getters */

    public String getPlayerOne() {
        return playerOne;
    }

    public String getPlayerTwo() {
        return playerTwo;
    }

}
