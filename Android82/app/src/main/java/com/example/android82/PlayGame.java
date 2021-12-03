package com.example.android82;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.android82.databinding.PlayGameBinding;

public class PlayGame extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private PlayGameBinding binding;
    private ImageView[][] pieces;
    private boolean[][] highlighted;
    private RelativeLayout[][] tiles;
    private boolean isOver = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_game);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //basic setup
        setup();


    }

//    private void piece_click(ImageView piece){//need to change
//        if(piece.getDrawable() == null){
//            piece.setImageDrawable(this.getResources().getDrawable(R.drawable.white_pawn,this.getTheme()));
//        }
//        piece.setImageDrawable(null);
//        ImageView temp = findViewById(R.id.a6_piece);
//        temp.setImageDrawable(this.getResources().getDrawable(R.drawable.white_pawn,this.getTheme()));
//        ((RelativeLayout)temp.getParent()).setBackground(this.getResources().getDrawable(R.drawable.highlighted_tile,this.getTheme()));
//
//        String tempString = ((TextView)((ViewGroup)piece.getParent()).getChildAt(0)).getText().toString();
//        System.out.println(tempString);
//
//    }
    private void setup(){
        pieces = new ImageView[8][8];
        highlighted = new boolean[8][8];
        tiles = new RelativeLayout[8][8];

        ConstraintLayout chessboard = findViewById(R.id.chessboard);
        //setting up the fields for PlayGame
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                tiles[i][j] = (RelativeLayout)chessboard.getChildAt(8*i + j);
                tiles[i][j].setOnClickListener(e->tile_click((RelativeLayout)e));
                pieces[i][j] = (ImageView)((ViewGroup)chessboard.getChildAt(8*i + j)).getChildAt(1);
                pieces[i][j].setOnClickListener(e->piece_click((ImageView)e));
                highlighted[i][j] = false;
            }
        }
    }
    private void piece_click(ImageView piece){
        if(isOver){
            return;
        }
        piece.setImageDrawable(null);
        piece.setVisibility(View.GONE);
        int row, col;
        RelativeLayout tile = (RelativeLayout)piece.getParent();
        String tile_number = ((TextView)tile.getChildAt(0)).getText().toString();
        int[] indices = convertTileNumberToIndices(tile_number);
        col = indices[0];
        row = indices[1];
        if((col+row) % 2 == 0){//white tile
            tile.setBackground(getResources().getDrawable(R.drawable.highlighted_white_tile,this.getTheme()));
        }
        else{//black tile
            tile.setBackground(getResources().getDrawable(R.drawable.highlighted_black_tile,this.getTheme()));
        }
    }
    private void tile_click(RelativeLayout tile){
        if(isOver){
            return;
        }
        int row, col;
        String tile_number = ((TextView)tile.getChildAt(0)).getText().toString();
        int[] indices = convertTileNumberToIndices(tile_number);
        col = indices[0];
        row = indices[1];

        if((col+row) % 2 == 0){//white tile
            tile.setBackground(getResources().getDrawable(R.drawable.white_tile,this.getTheme()));
        }
        else{//black tile
            tile.setBackground(getResources().getDrawable(R.drawable.black_tile,this.getTheme()));
        }
    }
    private int[] convertTileNumberToIndices(String tile_number){
        int[] indices = new int[2];
        indices[0] = tile_number.charAt(0) - 'a';
        indices[1] = 7 - (tile_number.charAt(1) - '1');
        return indices;
    }
}