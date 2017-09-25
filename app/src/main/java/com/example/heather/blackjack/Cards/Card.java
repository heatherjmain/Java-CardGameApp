package com.example.heather.blackjack.Cards;

/**
 * Created by heather on 22/09/2017.
 */

public class Card {
    private Suit suit;
    private Value value;

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

    public int cardValueForGame() {

        if (value.ordinal() + 1 > 10) {
            return 10;
        }
        return value.ordinal() + 1;

    }
}
