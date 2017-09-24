package com.example.heather.blackjack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PlayBlackJackActivity extends AppCompatActivity {

    TextView player1Card1;
    TextView player1Card2;
    TextView player2Card1;
    TextView player2Card2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_black_jack);

        player1Card1 = (TextView) findViewById(R.id.player1_card1);
        player1Card2 = (TextView) findViewById(R.id.player1_card2);
        player2Card1 = (TextView) findViewById(R.id.player2_card1);
        player2Card2 = (TextView) findViewById(R.id.player2_card2);
    }


}
