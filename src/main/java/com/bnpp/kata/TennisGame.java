package com.bnpp.kata;

public class TennisGame
{

    public static final int NO_BALL_SCORED = 0;
    public static final int ONE_BALL_SCORED = 1;
    public static final int TWO_BALLS_SCORED = 2;
    public static final int THREE_BALLS_SCORED = 3;
    private final String playerOne;
    private final String playerTwo;
    private int playerTwoScore;
    private int playerOneScore;


    public TennisGame(String playerOneName, String playerTwoName) {
        this.playerOne=playerOneName;
        this.playerTwo=playerTwoName;

        this.playerOneScore= NO_BALL_SCORED;
        this.playerTwoScore= NO_BALL_SCORED;
    }

    public String getScore()
    {
        if (hasWinner()) {
            if(playerOneScore>playerTwoScore)
            {
                return playerOne+" wins";
            }
            else
            {
                return playerTwo+" wins";
            }
        }

        if(playerOneScore==playerTwoScore){
            return convertToReadableScore(playerOneScore)+" All";
        }

        return convertToReadableScore(playerOneScore)+","+convertToReadableScore(playerTwoScore);
    }

    private String convertToReadableScore(int numericScore) {
        switch(numericScore)
        {
            case NO_BALL_SCORED:
                return "Love";
            case ONE_BALL_SCORED:
                return "Fifteen";
            case TWO_BALLS_SCORED:
                return "Thirty";
            case THREE_BALLS_SCORED:
                return "Forty";
            default:
                throw new IllegalArgumentException("Incorrect score "+numericScore);
        }
    }

    public void playerOneScores() {
        this.playerOneScore++;
    }

    public void playerTwoScores() {
        this.playerTwoScore++;
    }

    private boolean hasWinner() {
        if(playerTwoScore >= 4 && playerTwoScore >= playerOneScore + 2 )
            return true;
        else return playerOneScore >= 4 && playerOneScore >= playerTwoScore + 2;
    }
    /* getters */

    public String getPlayerOne() {
        return playerOne;
    }

    public String getPlayerTwo() {
        return playerTwo;
    }

}
