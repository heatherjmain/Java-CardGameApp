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

    public void dealCard(Playable player) {
        Card card = dealer.dealCard(0);
        player.receiveCard(card);
    }

    public void dealRound() {
        for (Playable player : players) {
            dealCard(player);
        }
        for (Playable player : players) {
            dealCard(player);
        }
    }

    public Boolean hasBlackJack(Playable player) {
        Boolean hasAce = false;
        Boolean hasTenOrFace = false;
        for (Card card : player.getHand()) {
            if (card.getValue().equals(Value.ACE)) {
                hasAce = true;
            }
            if (card.cardValueForGame() == 10) {
                hasTenOrFace = true;
            }
        }
        if (hasAce.equals(true) && hasTenOrFace.equals(true)) {
            return true;
        } else {
            return false;
        }
    }

    public String declareWinnerWithBlackJack(Playable player) {
        if (hasBlackJack(player)) {
            BlackJackPlayer hasBlackjack = (BlackJackPlayer) player;
            return hasBlackjack.getName().toUpperCase() + " HAS BLACKJACK AND WINS!";
        }
        return " ";
    }

    public String findWinner() {
//        Playable currentWinner = players.get(0);
        Playable currentWinner = null;
        int winningScore = 0;

        for (Playable player : players) {


//            if (hasBlackJack(player)) {
//                BlackJackPlayer hasBlackjack = (BlackJackPlayer) player;
//                return hasBlackjack.getName() + " has BlackJack and wins!!!";
//            } else {
//                int winningScore = currentWinner.getScore();
                int challengerScore = player.getScore();

                if ((challengerScore == winningScore) && (player != currentWinner)) {
                    return "IT'S A DRAW! TRY AGAIN";

                } else if (challengerScore > winningScore && challengerScore <= 21) {
                    currentWinner = player;
                    winningScore = challengerScore;
                }
            }

        BlackJackPlayer winner = (BlackJackPlayer) currentWinner;
        return winner.getName().toUpperCase() + " WINS!";

    }

}
