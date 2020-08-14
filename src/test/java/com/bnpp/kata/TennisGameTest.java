package com.bnpp.kata;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TennisGameTest
{
    @Test
    public void testNewGameShouldNotReturnNullObject() {

        TennisGame tennisGame=new TennisGame();

        assertNotNull(tennisGame);
    }
}
