package com.hyvee;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BowlingGameTests {
    private Game game;

    @Before
    public void beforeEach() {
        game = new Game();
    }

    @Test
    public void TestOneStrike() {
        game.Bowl(new Frame(10));
        game.Bowl(new Frame(4,5));
        Assert.assertEquals(28, game.GetScore());
    }

    @Test
    public void TestOneSpare(){
        game.Bowl(new Frame(8,2));
        game.Bowl(new Frame(7,2));
        Assert.assertEquals(26, game.GetScore());
    }

    @Test
    public void TestOneSpareStrikeCombo(){
        game.Bowl(new Frame(8,2));
        game.Bowl(new Frame(10));
        game.Bowl(new Frame(7,2));
        Assert.assertEquals(48, game.GetScore());
    }

    @Test
    public void TestGame(){
        game.Bowl(new Frame(1,3));
        game.Bowl(new Frame(7,3));
        game.Bowl(new Frame(10));
        game.Bowl(new Frame(1,7));
        game.Bowl(new Frame(5,2));
        game.Bowl(new Frame(5,3));
        game.Bowl(new Frame(8,2));
        game.Bowl(new Frame(8,2));
        game.Bowl(new Frame(10));
        game.Bowl(new Frame(9,0));
        Assert.assertEquals(131, game.GetScore());
    }

    @Test
    public void TestGameWithSpareInTheTenth(){
        game.Bowl(new Frame(1,3));
        game.Bowl(new Frame(7,3));
        game.Bowl(new Frame(10));
        game.Bowl(new Frame(1,7));
        game.Bowl(new Frame(5,2));
        game.Bowl(new Frame(5,3));
        game.Bowl(new Frame(8,2));
        game.Bowl(new Frame(8,2));
        game.Bowl(new Frame(10));
        game.Bowl(new Frame(9,1,10));
        Assert.assertEquals(143, game.GetScore());
    }

    @Test
    public void TestGameWithStrikesInTheTenth(){
        game.Bowl(new Frame(1,3));
        game.Bowl(new Frame(7,3));
        game.Bowl(new Frame(10));
        game.Bowl(new Frame(1,7));
        game.Bowl(new Frame(5,2));
        game.Bowl(new Frame(5,3));
        game.Bowl(new Frame(8,2));
        game.Bowl(new Frame(8,2));
        game.Bowl(new Frame(10));
        game.Bowl(new Frame(10,10,10));
        Assert.assertEquals(163, game.GetScore());
    }
}
