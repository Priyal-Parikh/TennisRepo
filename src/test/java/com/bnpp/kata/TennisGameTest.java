package com.bnpp.kata;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TennisGameTest
{
    public static final String firstPlayer = "Serena Williams";
    public static final String secondPlayer = "Maria Sharapova";
    TennisGame tennisGame;
    String score;

    @Before
    public void setUp() {
        tennisGame= new TennisGame(firstPlayer, secondPlayer);
    }


    @Test
    public void testNewGameShouldNotReturnNullObject()
    {

        assertNotNull(tennisGame);
    }

    @Test
    public void testNewGameShouldReturnPlayerNames()
    {
        assertEquals(firstPlayer, tennisGame.getPlayerOne() );
        assertEquals(secondPlayer,tennisGame.getPlayerTwo() );
    }

    @Test
    public void testNewGameShouldReturnLoveAll()
    {
        score = tennisGame.getScore();

        assertEquals("Love All", score);
    }

    @Test
    public void testPlayerOneScoresFirstBall()
    {
        tennisGame.playerOneScores();

        score = tennisGame.getScore();

        assertEquals("Fifteen,Love", score);
    }

    @Test
    public void testPlayerTwoScoresFirstBall()
    {
        tennisGame.playerTwoScores();

        score = tennisGame.getScore();

        assertEquals("Love,Fifteen", score);
    }

    @Test
    public void testBothPlayerScoresFirstBall(){

        tennisGame.playerOneScores();
        tennisGame.playerTwoScores();

        score = tennisGame.getScore();

        assertEquals("Fifteen All", score);
    }

    @Test
    public void testPlayerOneScoresFirstTwoBalls(){
        createScore(2,0);

        String score = tennisGame.getScore();

        assertEquals("Thirty,Love", score);
    }

    @Test
    public void testPlayerOneScoresFirstThreeBalls(){

        createScore(3, 0);

        score = tennisGame.getScore();

        assertEquals("Forty,Love", score);
    }

    private void createScore(int playerOneBalls, int playerTwoBalls) {
        for(int i=0; i<playerOneBalls; i++) {
            tennisGame.playerOneScores();
        }
        for(int i=0; i<playerTwoBalls; i++) {
            tennisGame.playerTwoScores();
        }
    }
}
