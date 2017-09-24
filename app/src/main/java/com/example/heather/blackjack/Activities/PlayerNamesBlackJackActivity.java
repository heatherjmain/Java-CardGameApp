package com.example.heather.blackjack.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.heather.blackjack.Activities.PlayBlackJackActivity;
import com.example.heather.blackjack.R;

public class PlayerNamesBlackJackActivity extends AppCompatActivity {

    EditText player1NameEditText;
    EditText player2NameEditText;
    Button dealCardsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_names_black_jack);

        player1NameEditText = (EditText) findViewById(R.id.enter_player1_name);
        player2NameEditText = (EditText) findViewById(R.id.enter_player2_name);
        dealCardsButton = (Button) findViewById(R.id.deal_cards_button);

    }


    public void onDealCardsButtonClicked(View button) {
        Intent intent = new Intent(this, PlayBlackJackActivity.class);

        String player1Name = player1NameEditText.getText().toString();
        intent.putExtra( "player1Name", player1Name );

        String player2Name = player2NameEditText.getText().toString();
        intent.putExtra( "player2Name", player2Name );

        startActivity(intent);
    }
}
