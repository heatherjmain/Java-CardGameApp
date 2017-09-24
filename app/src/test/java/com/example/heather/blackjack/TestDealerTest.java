package com.example.heather.blackjack;

import com.example.heather.blackjack.Dealers.TestDealer;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by heather on 22/09/2017.
 */

public class TestDealerTest {
    TestDealer testDealer;

    @Before
    public void before(){
        testDealer = new TestDealer();
    }

    @Test
    public void canStartsWithNoCards() {
        assertEquals( 0, testDealer.getDeckOfCards().size() );
    }

    @Test
    public void canCReateDeckOFCards() {

//        act
        testDealer.createDeck();

//        assert
        assertEquals( 52, testDealer.getDeckOfCards().size() );
    }

    @Test
    public void canRemoveCard() {

//        act
        testDealer.createDeck();
        testDealer.dealCard(1);

//        assert
        assertEquals( 51, testDealer.getDeckOfCards().size() );


    }
}
