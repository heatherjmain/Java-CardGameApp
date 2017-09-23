package com.example.heather.blackjack;


import java.util.ArrayList;

/**
 * Created by heather on 22/09/2017.
 */

public class BlackJackGame extends Game {

    public BlackJackGame(Dealer dealer) {
        super(dealer);
    }

    public void dealHands() {
        for (Playable player : players) {
            Card card = dealer.dealCard(0);
            player.receiveCard(card);
        }
        for (Playable player : players) {
            Card card = dealer.dealCard(0);
            player.receiveCard(card);
        }
    }

    public Boolean hasBlackJack(Playable player) {
        Boolean hasAce = false;
        Boolean hasNumberGreaterThan9 = false;
        for (Card card: player.getHand()) {
            if (card.getValue().equals(Value.ACE)  ) {
                hasAce = true;
            }
            if (card.cardValueForGame() >= 10) {
                hasNumberGreaterThan9 = true;
            }
        }
        if (hasAce.equals(true) && hasNumberGreaterThan9.equals(true)) {
            return true;
        } else {
            return false;
        }
    }

    public Playable findWinner() {
        Playable currentWinner = players.get(0);


        for (Playable player : players) {

            if (hasBlackJack(player)) {
                return player;
            } else {

                int winningScore = currentWinner.getScore();
                int challengerScore = player.getScore();

                if (challengerScore > winningScore) {
                    currentWinner = player;
                }
            }
        }
        return currentWinner;

    }


}
