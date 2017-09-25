package com.example.heather.blackjack;

import com.example.heather.blackjack.Cards.Card;
import com.example.heather.blackjack.Cards.Suit;
import com.example.heather.blackjack.Cards.Value;
import com.example.heather.blackjack.Players.BlackJackPlayer;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by heather on 22/09/2017.
 */

public class BlackJackPlayerTest {
    BlackJackPlayer blackJackPlayer;
    Card card1;
    Card card2;
    Card card3;

    @Before
    public void before(){
        blackJackPlayer = new BlackJackPlayer("Heather");
        card1 = new Card(Suit.DIAMONDS, Value.EIGHT);
        card2 = new Card(Suit.HEARTS, Value.NINE);
        card3 = new Card(Suit.SPADES, Value.KING);
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
        blackJackPlayer.receiveCard(card1);
        assertEquals( 1, blackJackPlayer.getHand().size() );
        assertEquals( Suit.DIAMONDS, blackJackPlayer.getHand().get(0).getSuit() );
        assertEquals( Value.EIGHT, blackJackPlayer.getHand().get(0).getValue() );
    }

    @Test
    public void canCalculateScoreWithNoFaceCard() {
        blackJackPlayer.receiveCard(card1);
        blackJackPlayer.receiveCard(card2);

        assertEquals( 17, blackJackPlayer.getScore());
    }

    @Test
    public void canCalculateScoreWithFaceCard() {
        blackJackPlayer.receiveCard(card1);
        blackJackPlayer.receiveCard(card3);

        assertEquals( 18, blackJackPlayer.getScore());
    }


}
