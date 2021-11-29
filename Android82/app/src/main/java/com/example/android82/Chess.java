package com.example.android82;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Chess extends AppCompatActivity {
    Button play_button;
    Button view_recorded_games_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play_button = findViewById(R.id.play_button);
        view_recorded_games_button = findViewById(R.id.view_recorded_games_button);

        play_button.setOnClickListener(v->playGame());
        view_recorded_games_button.setOnClickListener(v->viewRecordedGames());
    }
    private void playGame(){
        Bundle bundle = new Bundle();
        Intent intent = new Intent(this,PlayGame.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
    private void viewRecordedGames(){
        Bundle bundle = new Bundle();
        Intent intent = new Intent(this,ViewGames.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}