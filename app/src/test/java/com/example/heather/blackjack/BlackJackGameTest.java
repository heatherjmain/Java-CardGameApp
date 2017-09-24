package com.example.heather.blackjack;

import com.example.heather.blackjack.Cards.Card;
import com.example.heather.blackjack.Cards.Suit;
import com.example.heather.blackjack.Cards.Value;
import com.example.heather.blackjack.Dealers.Dealer;
import com.example.heather.blackjack.Dealers.TestDealer;
import com.example.heather.blackjack.Games.BlackJackGame;
import com.example.heather.blackjack.Players.BlackJackPlayer;
import com.example.heather.blackjack.Players.Playable;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by heather on 22/09/2017.
 */

public class BlackJackGameTest {
    BlackJackGame blackJackGame;
    Playable player1;
    Playable player2;
    Dealer testDealer;

    @Before
    public void before() {
        testDealer = new TestDealer();
        blackJackGame = new BlackJackGame(testDealer);
        player1 = new BlackJackPlayer("Tom");
        player2 = new BlackJackPlayer("Sue");

    }

    @Test
    public void canGetDealer() {
        assertEquals( testDealer, blackJackGame.getDealer() );
    }

    @Test
    public void startsWithNoPlayers() {
        assertEquals( 0, blackJackGame.getPlayers().size() );
    }

    @Test
    public void canAddPlayers() {

//        act
        blackJackGame.addPlayer(player1);
        blackJackGame.addPlayer(player2);

//        assert
        assertEquals( 2, blackJackGame.getPlayers().size() );
    }

    @Test
    public void canDealHands() {
//        arrange
        blackJackGame.addPlayer(player1);
        blackJackGame.addPlayer(player2);

        testDealer.createDeck();

//        act
        blackJackGame.dealHands();

//        assert
        assertEquals( 48, testDealer.getDeckOfCards().size() );

        assertEquals( 2, player1.getHand().size() );
        assertEquals( Suit.HEARTS, player1.getHand().get(0).getSuit() );
        assertEquals( Suit.HEARTS, player1.getHand().get(1).getSuit() );
        assertEquals( Value.ACE, player1.getHand().get(0).getValue() );
        assertEquals( Value.THREE, player1.getHand().get(1).getValue() );


        assertEquals( 2, player2.getHand().size() );
        assertEquals( Suit.HEARTS, player2.getHand().get(0).getSuit() );
        assertEquals( Suit.HEARTS, player2.getHand().get(1).getSuit() );
        assertEquals( Value.TWO, player2.getHand().get(0).getValue() );
        assertEquals( Value.FOUR, player2.getHand().get(1).getValue() );
    }

    @Test
    public void canFindWinner() {
//        arrange
        blackJackGame.addPlayer(player1);
        blackJackGame.addPlayer(player2);

        testDealer.createDeck();

        blackJackGame.dealHands();

//        act
        Playable winner = blackJackGame.findWinner();

//        assert
        assertEquals( player2, winner );
    }

    @Test
    public void canHaveBlackJack() {
        blackJackGame.addPlayer(player1);
        Card card1 = new Card(Suit.DIAMONDS, Value.ACE);
        Card card2 = new Card(Suit.DIAMONDS, Value.KING);

        player1.receiveCard(card1);
        player1.receiveCard(card2);

        assertTrue(blackJackGame.hasBlackJack(player1));

    }

    @Test
    public void canNotHaveBlackJack() {
        blackJackGame.addPlayer(player1);
        Card card1 = new Card(Suit.DIAMONDS, Value.THREE);
        Card card2 = new Card(Suit.DIAMONDS, Value.TWO);

        player1.receiveCard(card1);
        player1.receiveCard(card2);

        assertFalse(blackJackGame.hasBlackJack(player1));

    }

    @Test
    public void canFindWinnerWhenBlackJackPresent() {
        blackJackGame.addPlayer(player1);
        Card card1 = new Card(Suit.DIAMONDS, Value.THREE);
        Card card2 = new Card(Suit.DIAMONDS, Value.TWO);
        player1.receiveCard(card1);
        player1.receiveCard(card2);

        blackJackGame.addPlayer(player2);
        Card card3 = new Card(Suit.HEARTS, Value.ACE);
        Card card4 = new Card(Suit.SPADES, Value.KING);
        player2.receiveCard(card3);
        player2.receiveCard(card4);

        assertEquals(player2, blackJackGame.findWinner());
    }

    @Test
    public void canFindWinnerWhenBlackJackNotPresent() {
        blackJackGame.addPlayer(player1);
        Card card1 = new Card(Suit.DIAMONDS, Value.THREE);
        Card card2 = new Card(Suit.DIAMONDS, Value.TWO);
        player1.receiveCard(card1);
        player1.receiveCard(card2);

        blackJackGame.addPlayer(player2);
        Card card3 = new Card(Suit.HEARTS, Value.SEVEN);
        Card card4 = new Card(Suit.SPADES, Value.SEVEN);
        player2.receiveCard(card3);
        player2.receiveCard(card4);

        assertEquals(player2, blackJackGame.findWinner());
    }
}
