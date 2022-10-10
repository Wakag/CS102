package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.*;


public class Customisation extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customisation_new1);
    }

    /*public void XButtonClick(View view) {
        Intent intent = new Intent(this, GameBoard.class);
        startActivity(intent);

    }

    public void OButtonClick(View view) {
        Intent intent = new Intent(this, GameBoard.class);
        startActivity(intent);

    }
    public void HButtonClick(View view) {
        Intent intent = new Intent(this, GameBoard.class);
        startActivity(intent);

    }
    public void SButtonClick(View view) {
        Intent intent = new Intent(this, GameBoard.class);
        startActivity(intent);



    }
*/
    public void SubmitButtonClick(View view) {
        Intent intent = new Intent(this, GameBoard.class);
        startActivity(intent);
    }
    @Override
    public void onClick(View view) {

    }
}
