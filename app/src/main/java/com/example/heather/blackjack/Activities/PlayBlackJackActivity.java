package com.example.heather.blackjack.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.heather.blackjack.R;

public class PlayBlackJackActivity extends AppCompatActivity {

    TextView player1NameText;
    TextView player2NameText;
    TextView player1Card1;
    TextView player1Card2;
    TextView player2Card1;
    TextView player2Card2;

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


        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        String player1Name = extras.getString("player1Name");
        String firstName = player1Name;

        String player2Name = extras.getString("player2Name");
        String secondName = player2Name;

        player1NameText.setText(firstName);
        player2NameText.setText(secondName);


    }


}
