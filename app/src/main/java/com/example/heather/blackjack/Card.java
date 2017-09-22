package com.example.heather.blackjack;

/**
 * Created by heather on 22/09/2017.
 */

public class Card {
    Suit suit;
    Value value;

    public  Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public Value getValue() {
        return value;
    }
}
