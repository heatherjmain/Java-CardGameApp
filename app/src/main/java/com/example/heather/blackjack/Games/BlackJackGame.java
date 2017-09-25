package com.example.heather.blackjack.Games;


import com.example.heather.blackjack.Cards.Card;
import com.example.heather.blackjack.Dealers.Dealer;
import com.example.heather.blackjack.Players.BlackJackPlayer;
import com.example.heather.blackjack.Players.Playable;
import com.example.heather.blackjack.Cards.Value;

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
        for (Card card : player.getHand()) {
            if (card.getValue().equals(Value.ACE)) {
                hasAce = true;
            }
            if (card.cardValueForGame() > 9) {
                hasNumberGreaterThan9 = true;
            }
        }
        if (hasAce.equals(true) && hasNumberGreaterThan9.equals(true)) {
            return true;
        } else {
            return false;
        }
    }

    public String findWinner() {
        Playable currentWinner = players.get(0);


        for (Playable player : players) {


            if (hasBlackJack(player)) {
                BlackJackPlayer hasBlackjack = (BlackJackPlayer) player;
                return hasBlackjack.getName() + " has BlackJack and wins!!!";
            } else {
                int winningScore = currentWinner.getScore();
                int challengerScore = player.getScore();

                if ((challengerScore == winningScore) && (player != currentWinner)) {
                    return "It's a draw - Try again";

                } else if (challengerScore > winningScore) {
                    currentWinner = player;
                }
            }


        }
        BlackJackPlayer winner = (BlackJackPlayer) currentWinner;
        return winner.getName() + " wins!!!";


    }

}
