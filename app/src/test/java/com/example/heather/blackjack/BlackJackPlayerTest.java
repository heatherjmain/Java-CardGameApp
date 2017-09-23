package com.example.heather.blackjack;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by heather on 22/09/2017.
 */

public class BlackJackPlayerTest {
    BlackJackPlayer blackJackPlayer;
    Card card;

    @Before
    public void before(){
        blackJackPlayer = new BlackJackPlayer("Heather");
        card = new Card(Suit.DIAMONDS, Value.EIGHT);
    }


    @Test
    public void canGetName() {
        assertEquals( "Heather", blackJackPlayer.getName() );
    }

    @Test
    public void startsWithNoCards() {
        assertEquals( 0, blackJackPlayer.getHand().size() );
    }

    @Test
    public void canReceiveACard() {
        blackJackPlayer.receiveCard(card);
        assertEquals( 1, blackJackPlayer.getHand().size() );
        assertEquals( Suit.DIAMONDS, blackJackPlayer.getHand().get(0).getSuit() );
        assertEquals( Value.EIGHT, blackJackPlayer.getHand().get(0).getValue() );
    }
}
