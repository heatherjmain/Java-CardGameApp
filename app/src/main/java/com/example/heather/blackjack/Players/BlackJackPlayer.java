package com.example.heather.blackjack.Players;

import com.example.heather.blackjack.Cards.Card;
import com.example.heather.blackjack.Cards.Value;

import java.util.ArrayList;

/**
 * Created by heather on 22/09/2017.
 */

public class BlackJackPlayer implements Playable {
    private String name;
    private ArrayList<Card> hand;
    
    public BlackJackPlayer(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public ArrayList<Card> getHand() {
        return hand;
    }


    
    public void receiveCard(Card card) {
        hand.add(card);
    }



    public int getAcesLowScore() {
        int counter = 0;

        for ( Card card : hand ) {

//            if (counter > 21 && (card.getValue() == Value.ACE)) {
//                counter -= 10;
//            }

            counter += card.cardValueForGame();
        }
        return counter;
    }



//
    public int getScore() {
        int score = getAcesLowScore();

        int aceCount = 0;
        for (Card card : getHand()) {
            if (card.getValue() == Value.ACE) {
                aceCount++;
            }
        }




        if (score <= 11 && aceCount > 0) {
            score += 10;
        }
        return score;
    }


}
