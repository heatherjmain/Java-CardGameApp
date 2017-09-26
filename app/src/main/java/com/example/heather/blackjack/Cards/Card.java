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

    public String getSuitIcons(Suit suit) {
        switch (suit) {
            case SPADES:
                char spades = 0x2660;
                return String.valueOf(spades);
            case CLUBS:
                char clubs = 0x2663;
                return String.valueOf(clubs);
            case DIAMONDS:
                char diamonds = 0x2666;
                return String.valueOf(diamonds);
            case HEARTS:
                char hearts = 0x2665;
                return String.valueOf(hearts);
            default:
                return " ";
        }
    }




//    public String getCardIcons(Suit suit, Value value) {
//        switch (suit) {
//            case SPADES:
//                switch (value) {
//                    case ACE:
//                        char spades = 0xD83C/0xDCA1;
//                        return String.valueOf(spades);
//                    default:
//                        return " ";
//
//                }
//            default:
//                return " ";
//        }
//
//
//    }

    public String getShortName() {
//        String spades = "\uD83C\uDCA1";
//        return String.valueOf(spades);
//        return spades;
        return getValue().toString() + " " + String.valueOf(getSuitIcons(this.suit));
    }




}
