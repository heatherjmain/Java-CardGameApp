package com.example.heather.blackjack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {

    Button blackJackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        blackJackButton = (Button) findViewById(R.id.blackjack_button);

    }


    public void onBlackJackButtonClicked(View button) {

        Log.d( "BlackJack", "Click" );

        Intent intent = new Intent(this, PlayBlackJackActivity.class);
        startActivity(intent);
    }


}
