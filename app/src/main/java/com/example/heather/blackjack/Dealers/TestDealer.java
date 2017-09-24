package com.example.heather.blackjack.Dealers;

import com.example.heather.blackjack.Cards.Card;
import com.example.heather.blackjack.Cards.Suit;
import com.example.heather.blackjack.Cards.Value;

import java.util.ArrayList;
import java.util.Collections;


/**
 * Created by heather on 22/09/2017.
 */

public class TestDealer implements Dealer {

    private ArrayList<Card> deckOfCards;

//    constructor
    public TestDealer() {
        this.deckOfCards = new ArrayList<>();
    }


//      getters
    public ArrayList<Card> getDeckOfCards() {
        return deckOfCards;
    }


//    methods
    public void createDeck() {
        for (Suit suit : Suit.values()) {
            for (Value value : Value.values()) {
                deckOfCards.add(new Card(suit, value));
            }
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(deckOfCards);
    }


    public Card dealCard(int index) {
        return deckOfCards.remove(index);
    }


}
