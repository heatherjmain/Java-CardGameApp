package com.example.heather.blackjack.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.heather.blackjack.Activities.PlayerNamesBlackJackActivity;
import com.example.heather.blackjack.R;

public class WelcomeActivity extends AppCompatActivity {

    Button blackJackButton;
    Button highestCardButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        blackJackButton = (Button) findViewById(R.id.blackjack_button);
        highestCardButton = (Button) findViewById(R.id.highest_card_button);

    }


    public void onBlackJackButtonClicked(View button) {
        Intent intent = new Intent(this, PlayerNamesBlackJackActivity.class);
        startActivity(intent);
    }

    public void onHighestCardButtonClicked(View button) {
        Intent intent = new Intent(this, PlayerNameHighestCardActivity.class);
        startActivity(intent);
    }


}
