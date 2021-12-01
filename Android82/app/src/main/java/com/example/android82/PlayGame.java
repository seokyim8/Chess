package com.example.android82;

import android.media.Image;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.android82.databinding.PlayGameBinding;

public class PlayGame extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private PlayGameBinding binding;
    private ImageView[] pieces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_game);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //do chess related stuff
        pieces = new ImageView[32];
        pieces[0] = findViewById(R.id.a8_piece);
        pieces[0].setOnClickListener(e->piece_click(pieces[0]));
    }

    private void piece_click(ImageView piece){
        if(piece.getDrawable() == null){
            piece.setImageDrawable(this.getResources().getDrawable(R.drawable.white_pawn,this.getTheme()));
        }
        piece.setImageDrawable(null);
        ImageView temp = findViewById(R.id.a6_piece);
        temp.setImageDrawable(this.getResources().getDrawable(R.drawable.white_pawn,this.getTheme()));
        ((RelativeLayout)temp.getParent()).setBackground(this.getResources().getDrawable(R.drawable.highlighted_tile,this.getTheme()));
    }

}