package com.example.heather.blackjack;


import com.example.heather.blackjack.Cards.Card;
import com.example.heather.blackjack.Cards.Suit;
import com.example.heather.blackjack.Cards.Value;

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
    public void canGetSuitIcon() {
        assertEquals("♥", card.getSuitIcons(Suit.HEARTS));
        assertEquals("♠", card.getSuitIcons(Suit.SPADES));
        assertEquals("♦", card.getSuitIcons(Suit.DIAMONDS));
        assertEquals("♣", card.getSuitIcons(Suit.CLUBS));
    }

    @Test
    public void canGetValue() {
        assertEquals( Value.THREE, card.getValue() );
    }

    @Test
    public void canGetCardValueForGame() {
        assertEquals(3, card.cardValueForGame());
    }


    @Test
    public void canGetShortName() {
        assertEquals("THREE ♥", card.getShortName());
    }
}

