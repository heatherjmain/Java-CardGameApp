package com.example.heather.blackjack.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.heather.blackjack.R;

public class PlayerNameHighestCardActivity extends AppCompatActivity {
    EditText playerNameEditText;
    Button playGameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_name_highest_card);


        playerNameEditText = (EditText) findViewById(R.id.enter_player_name);
        playGameButton = (Button) findViewById(R.id.play_game_button);
    }


    public void onPlayGameButtonClicked(View button) {
        Intent intent = new Intent(this, PlayHighestCardActivity.class);

        String playerName = playerNameEditText.getText().toString();
        intent.putExtra( "playerName", playerName );

        startActivity(intent);
    }
}









