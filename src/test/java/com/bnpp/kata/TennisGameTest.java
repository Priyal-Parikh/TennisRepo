package com.bnpp.kata;

import com.bnpp.kata.exception.TennisException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TennisGameTest
{
    public static final String firstPlayer = "Serena Williams";
    public static final String secondPlayer = "Maria Sharapova";
    TennisGame tennisGame;
    String score;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

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

    @Test
    public void testPlayerTwoSccheckoresAllFourBallsToWinGame(){

        createScore(0, 4);

        score = tennisGame.getScore();

        assertEquals(secondPlayer+" wins", score);
    }

    @Test
    public void testShouldRaiseExceptionIfScoreIsNotCorrect(){

        createScore(5, 8);

        exceptionRule.expect(TennisException.class);
        exceptionRule.expectMessage("Incorrect Score");

        score = tennisGame.getScore();
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
