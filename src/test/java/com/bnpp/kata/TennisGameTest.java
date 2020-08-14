package com.bnpp.kata;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TennisGameTest
{
    @Test
    public void testNewGameShouldNotReturnNullObject() {

        TennisGame tennisGame=new TennisGame("Serena Williams", "Maria Sharapova");

        assertNotNull(tennisGame);
    }

    @Test
    public void testNewGameShouldReturnPlayerNames()
    {
        TennisGame tennisGame=new TennisGame("Serena Williams","Maria Sharapova");

        assertEquals( "Serena Williams", tennisGame.getPlayerOne() );
        assertEquals( "Maria Sharapova",tennisGame.getPlayerTwo() );
    }
}
