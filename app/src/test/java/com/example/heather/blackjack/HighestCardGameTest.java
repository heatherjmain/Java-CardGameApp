package com.example.heather.blackjack;

import com.example.heather.blackjack.Cards.Card;
import com.example.heather.blackjack.Cards.Suit;
import com.example.heather.blackjack.Cards.Value;
import com.example.heather.blackjack.Dealers.Dealer;
import com.example.heather.blackjack.Dealers.TestDealer;
import com.example.heather.blackjack.Games.BlackJackGame;
import com.example.heather.blackjack.Games.HighestCardGame;
import com.example.heather.blackjack.Players.BlackJackPlayer;
import com.example.heather.blackjack.Players.HighestCardPlayer;
import com.example.heather.blackjack.Players.Playable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by heather on 26/09/2017.
 */
public class HighestCardGameTest {


    HighestCardGame highestCardGame;
    Playable player1;
    Playable player2;
    Dealer testDealer;

    @Before
    public void before() {
        testDealer = new TestDealer();
        highestCardGame = new HighestCardGame(testDealer);
        player1 = new HighestCardPlayer("Tom");
        player2 = new HighestCardPlayer("Sue");
    }


    @Test
    public void dealCard() {
        testDealer.createDeck();
        highestCardGame.dealCard(player1);
        assertEquals( 51, testDealer.getDeckOfCards().size() );
        assertEquals( 1, player1.getHand().size() );
    }

    @Test
    public void findWinner() {
        testDealer.createDeck();
        highestCardGame.addPlayer(player1);
        highestCardGame.addPlayer(player2);
        highestCardGame.dealCard(player1);
        highestCardGame.dealCard(player2);

        assertEquals( "SUE WINS", highestCardGame.findWinner() );
        assertEquals( Value.ACE, player1.getHand().get(0).getValue() );
        assertEquals( Value.TWO, player2.getHand().get(0).getValue() );
    }
}