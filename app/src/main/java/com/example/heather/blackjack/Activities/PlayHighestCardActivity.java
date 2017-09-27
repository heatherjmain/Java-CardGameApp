package com.example.heather.blackjack.Activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.heather.blackjack.Dealers.Dealer;
import com.example.heather.blackjack.Dealers.TestDealer;
import com.example.heather.blackjack.Games.HighestCardGame;
import com.example.heather.blackjack.Players.HighestCardPlayer;
import com.example.heather.blackjack.R;


public class PlayHighestCardActivity extends AppCompatActivity {

    Button playerDealCard;
    Button playAgainButton;
    Button chooseAnotherGameButton;
    TextView playerCardText;
    TextView player2CardText;
    TextView playerNameText;
    TextView player2NameText;
    TextView informationText;

    HighestCardPlayer player;
    HighestCardPlayer player2;
    Dealer highestCardDealer;
    HighestCardGame highestCardGame;

    Handler setDelay;
    Runnable startDelay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_highest_card);

        playerDealCard = (Button) findViewById(R.id.player1_deal_card);
        playAgainButton = (Button) findViewById(R.id.play_again_button);
        chooseAnotherGameButton = (Button) findViewById(R.id.choose_another_game_button);
        playerCardText = (TextView) findViewById(R.id.player1_card);
        player2CardText = (TextView) findViewById(R.id.player2_card);
        informationText = (TextView) findViewById(R.id.information_text);
        playerNameText = (TextView) findViewById(R.id.player1_name);
        player2NameText = (TextView) findViewById(R.id.player2_name);

        highestCardDealer = new TestDealer();
        highestCardGame = new HighestCardGame(highestCardDealer);



        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        String playerName = extras.getString("playerName");
        String setPlayerName = playerName;

        String player2Name = "DEALER";
        String setPlayer2Name = player2Name;

        playerNameText.setText(setPlayerName);
        player2NameText.setText(setPlayer2Name);

        player = new HighestCardPlayer(setPlayerName);
        player2 = new HighestCardPlayer(setPlayer2Name);


        highestCardDealer.createDeck();
        highestCardDealer.shuffleDeck();

        highestCardGame.addPlayer(player);
        highestCardGame.addPlayer(player2);

    }

    public void onPlayer1DealCardButtonClicked(View view) {

        setDelay = new Handler();

        highestCardGame.dealCard(player);
        playerCardText.setText(player.getHand().get(0).getShortName());

        startDelay = new Runnable() {
            @Override
            public void run() {
                highestCardGame.dealCard(player2);
                player2CardText.setText(player2.getHand().get(0).getShortName());
            }

        };
        setDelay.postDelayed(startDelay, 1000);

        startDelay = new Runnable() {
            @Override
            public void run() {
                informationText.setText(highestCardGame.findWinner());
            }
        };
        setDelay.postDelayed(startDelay, 2000);

    }

    public void onPlayAgainButtonClicked(View view) {
        Intent intent = new Intent(this, PlayerNameHighestCardActivity.class);
        startActivity(intent);
    }

    public void onChooseAnotherGameButtonClicked(View view) {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }

}
