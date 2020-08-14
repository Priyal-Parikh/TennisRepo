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
}
