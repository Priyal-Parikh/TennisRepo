package com.bnpp.kata;

import com.bnpp.kata.exception.TennisException;

public class TennisGame
{

    public static final int NO_BALL_SCORED = 0;
    public static final int ONE_BALL_SCORED = 1;
    public static final int TWO_BALLS_SCORED = 2;
    public static final int THREE_BALLS_SCORED = 3;
    public static final int FOUR = 4;
    public static final int TWO = 2;
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
        if(!validScore()) {
            throw new TennisException("Incorrect Score");
        }

        if (hasWinner()) {
            return playerWithHigherScore()+" wins";
        }

        if(isDeuce()) return "Deuce";

        if (hasAdvantage())  return "Advantage " + playerWithHigherScore();


        if(playerOneScore==playerTwoScore){
            return convertToReadableScore(playerOneScore)+" All";
        }

        return convertToReadableScore(playerOneScore)+","+convertToReadableScore(playerTwoScore);
    }

    private String playerWithHigherScore() {
        if(playerOneScore>playerTwoScore)
        {
            return playerOne;
        }
        else
        {
            return playerTwo;
        }
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
                throw new TennisException("Incorrect Score");
        }
    }

    public void playerOneScores() {
        this.playerOneScore++;
    }

    public void playerTwoScores() {
        this.playerTwoScore++;
    }

    private boolean hasWinner() {
        if(playerTwoScore >= FOUR && playerTwoScore >= playerOneScore + TWO)
            return true;
        else return playerOneScore >= FOUR && playerOneScore >= playerTwoScore + TWO;
    }

    private boolean validScore() {
        if(playerOneScore < NO_BALL_SCORED || playerTwoScore<NO_BALL_SCORED) {
            return false;
        }
        return playerTwoScore < FOUR || playerOneScore < FOUR || playerTwoScore - playerOneScore <= 1;
    }

    private boolean isDeuce() {
        return playerOneScore >= THREE_BALLS_SCORED && playerTwoScore == playerOneScore;
    }

    private boolean hasAdvantage() {
        if (playerTwoScore >= FOUR && playerTwoScore == playerOneScore + ONE_BALL_SCORED)
            return true;
        return playerOneScore >= FOUR && playerOneScore == playerTwoScore + ONE_BALL_SCORED;
    }

    /* getters */

    public String getPlayerOne() {
        return playerOne;
    }

    public String getPlayerTwo() {
        return playerTwo;
    }

}
