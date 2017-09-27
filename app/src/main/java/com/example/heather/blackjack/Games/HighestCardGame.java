package com.example.heather.blackjack.Games;

import com.example.heather.blackjack.Cards.Card;
import com.example.heather.blackjack.Dealers.Dealer;
import com.example.heather.blackjack.Players.BlackJackPlayer;
import com.example.heather.blackjack.Players.HighestCardPlayer;
import com.example.heather.blackjack.Players.Playable;


/**
 * Created by heather on 26/09/2017.
 */

public class HighestCardGame extends Game {

    public HighestCardGame(Dealer dealer) {
        super(dealer);
    }


    public void dealCard(Playable player) {
        Card card = dealer.dealCard(0);
        player.receiveCard(card);
    }

    public String findWinner() {
        Playable currentWinner = getPlayers().get(0);

        for (Playable player : players) {
            if ((currentWinner.getScore() == player.getScore()) && (player != currentWinner)) {
                return "IT'S A DRAW - TRY AGAIN";

            } else if (player.getScore() > currentWinner.getScore()) {
                currentWinner = player;
            }
        }
        HighestCardPlayer winner = (HighestCardPlayer) currentWinner;
        return winner.getName().toUpperCase() + " WINS";

    }
}
