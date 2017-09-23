package com.example.heather.blackjack;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by heather on 22/09/2017.
 */

public class CardTest {

    Card card;

    @Before
    public void before() {
        card = new Card(Suit.HEARTS, Value.THREE);
    }

    @Test
    public void canGetSuit() {
        assertEquals( Suit.HEARTS, card.getSuit() );
    }

    @Test
    public void canGetValue() {
        assertEquals( Value.THREE, card.getValue() );
    }

    @Test
    public void canGetCardValueForGame() {
        assertEquals(3, card.cardValueForGame());
    }

}

