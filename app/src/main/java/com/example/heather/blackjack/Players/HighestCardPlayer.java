package com.example.heather.blackjack.Players;

import com.example.heather.blackjack.Cards.Card;

import java.util.ArrayList;

/**
 * Created by heather on 26/09/2017.
 */

public class HighestCardPlayer implements Playable {
    String name;
    ArrayList<Card> hand;


    public HighestCardPlayer(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }


    public ArrayList<Card> getHand() {
        return hand;
    }


    public void receiveCard(Card card) {
        hand.add(card);
    }

    public int getScore() {
        int counter = 0;

        for ( Card card : hand ) {
            counter += card.cardValueForGame();
        }
        return counter;
    }

}
