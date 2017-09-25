package com.example.heather.blackjack.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.heather.blackjack.Dealers.Dealer;
import com.example.heather.blackjack.Dealers.TestDealer;
import com.example.heather.blackjack.Games.BlackJackGame;
import com.example.heather.blackjack.Players.BlackJackPlayer;
import com.example.heather.blackjack.Players.Playable;
import com.example.heather.blackjack.R;

public class PlayBlackJackActivity extends AppCompatActivity {

    TextView player1NameText;
    TextView player2NameText;
    TextView player1Card1;
    TextView player1Card2;
    TextView player2Card1;
    TextView player2Card2;
    TextView declareWinner;

    Dealer blackJackDealer;
    BlackJackGame blackJackGame;
    Playable player1;
    Playable player2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_black_jack);

        player1NameText = (TextView) findViewById(R.id.player1_name);
        player2NameText = (TextView) findViewById(R.id.player2_name);
        player1Card1 = (TextView) findViewById(R.id.player1_card1);
        player1Card2 = (TextView) findViewById(R.id.player1_card2);
        player2Card1 = (TextView) findViewById(R.id.player2_card1);
        player2Card2 = (TextView) findViewById(R.id.player2_card2);
        declareWinner = (TextView) findViewById(R.id.decalre_winner);

        blackJackDealer = new TestDealer();
        blackJackGame = new BlackJackGame(blackJackDealer);
//        player1 = new BlackJackPlayer(null);
//        player2 = new BlackJackPlayer(null);




//sets players names
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        String player1Name = extras.getString("player1Name");
        String setPlayer1Name = player1Name;

        String player2Name = extras.getString("player2Name");
        String setPlayer2Name = player2Name;

        player1NameText.setText(setPlayer1Name);
        player2NameText.setText(setPlayer2Name);

        player1 = new BlackJackPlayer(setPlayer1Name);
        player2 = new BlackJackPlayer(setPlayer2Name);


        blackJackDealer.createDeck();
        blackJackDealer.shuffleDeck();

        blackJackGame.addPlayer(player1);
        blackJackGame.addPlayer(player2);

        blackJackGame.dealHands();
        player1Card1.setText("Card 1: " + player1.getHand().get(0).getShortName());
        player1Card2.setText("Card 2: " + player1.getHand().get(1).getShortName());
        player2Card1.setText("Card 1: " + player2.getHand().get(0).getShortName());
        player2Card2.setText("Card 2: " + player2.getHand().get(1).getShortName());


        player1.getScore();
        player2.getScore();


        if ( blackJackGame.hasBlackJack(player1) ) {
            declareWinner.setText(blackJackGame.findWinner());
        } else if ( blackJackGame.hasBlackJack(player2) ) {
            declareWinner.setText(blackJackGame.findWinner());
        } else {
            declareWinner.setText(blackJackGame.findWinner());
        }




    }


}
