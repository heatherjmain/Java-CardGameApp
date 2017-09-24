package com.example.heather.blackjack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PlayerNamesBlackJackActivity extends AppCompatActivity {

    Button dealCardsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_names_black_jack);

        dealCardsButton = (Button) findViewById(R.id.deal_cards_button);

    }


    public void onDealCardsButtonClicked(View button) {
        Intent intent = new Intent(this, PlayBlackJackActivity.class);
        startActivity(intent);
    }
}
