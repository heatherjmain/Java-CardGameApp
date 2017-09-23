package com.example.heather.blackjack;

import java.util.ArrayList;

/**
 * Created by heather on 22/09/2017.
 */

public interface Dealer {

    public ArrayList<Card> getDeckOfCards();

    public void createDeck();

    public Card dealCard(int index);

    void shuffleDeck();
}
