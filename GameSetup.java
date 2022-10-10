package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.*;


public class GameSetup extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_options);
    }

    public void SPButtonClick(View view) {
        Intent intent = new Intent(this, Customisation.class);
        startActivity(intent);

    }

    public void TPButtonClick(View view) {
        Intent intent = new Intent(this, Customisation2.class);
        startActivity(intent);

    }


    @Override
    public void onClick(View view) {

    }
}
