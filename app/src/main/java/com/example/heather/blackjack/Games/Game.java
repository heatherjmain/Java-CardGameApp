package com.example.heather.blackjack.Games;

import com.example.heather.blackjack.Dealers.Dealer;
import com.example.heather.blackjack.Players.Playable;

import java.util.ArrayList;

/**
 * Created by heather on 22/09/2017.
 */

public abstract class Game {
    Dealer dealer;
    ArrayList<Playable> players;

    public Game(Dealer dealer) {
        this.dealer = dealer;
        this.players = new ArrayList<>();
    }

    public Dealer getDealer() {
        return dealer;
    }

    public ArrayList<Playable> getPlayers() {
        return players;
    }

    public void addPlayer(Playable player) {
        players.add(player);
    }
}
