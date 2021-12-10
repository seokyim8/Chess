package com.example.android82;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.android82.databinding.ViewGameBinding;

import java.io.File;
import java.io.IOException;

public class ViewGame extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ViewGameBinding binding;

    private ChessRecord record;

    private TextView game_record_description;
    private ListView game_record_moves;
    private Button replay_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_game);

        //tool bar stuff
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        this.game_record_description = findViewById(R.id.game_record_description);
        this.game_record_moves = findViewById(R.id.game_record_moves);
        this.replay_button = findViewById(R.id.replay_button);

        Bundle bundle = getIntent().getExtras();
        int position = bundle.getInt("position");

        try {
            ChessRecordGroup crg = ChessRecordGroup.readApp(this.getFilesDir()+ File.separator+"ChessRecord.dat");
            this.record = crg.chessRecords.get(position);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        this.game_record_description.setText(this.record.toString());
        this.game_record_moves.setAdapter(new ArrayAdapter<>(this,R.layout.item,this.record.moves));

        this.replay_button.setOnClickListener(e->replay_button_click());
    }
    private void replay_button_click(){
        //TODO:
    }
}