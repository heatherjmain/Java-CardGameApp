package com.example.heather.blackjack;

import com.example.heather.blackjack.Cards.Card;
import com.example.heather.blackjack.Cards.Suit;
import com.example.heather.blackjack.Cards.Value;
import com.example.heather.blackjack.Players.BlackJackPlayer;
import com.example.heather.blackjack.Players.HighestCardPlayer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by heather on 26/09/2017.
 */
public class HighestCardPlayerTest {
    HighestCardPlayer highestCardPlayer;
    Card card1;


    @Before
    public void before(){
        highestCardPlayer = new HighestCardPlayer("Heather");
        card1 = new Card(Suit.DIAMONDS, Value.EIGHT);
    }


    @Test
    public void getName() {
        assertEquals( "Heather", highestCardPlayer.getName() );
    }

    @Test
    public void getHand() {
        assertEquals( 0, highestCardPlayer.getHand().size() );
    }

    @Test
    public void receiveCard() {
        highestCardPlayer.receiveCard(card1);
        assertEquals( 1, highestCardPlayer.getHand().size() );
    }

    @Test
    public void getScore() {
        highestCardPlayer.receiveCard(card1);
        assertEquals( 8, highestCardPlayer.getScore() );
    }

}