package com.example.heather.blackjack;

import java.util.ArrayList;

/**
 * Created by heather on 22/09/2017.
 */

public class TestDealer implements Dealer {

    ArrayList<Card> deckOfCards;

    public TestDealer() {
        this.deckOfCards = new ArrayList<>();
    }



    public ArrayList<Card> getDeckOfCards() {
        return deckOfCards;
    }

    public void createDeck() {
        for (Suit suit : Suit.values()) {
            for (Value value : Value.values()) {
                deckOfCards.add(new Card(suit, value));
            }
        }
    }
    
    public Card deal() {
        return null;
    }


}
