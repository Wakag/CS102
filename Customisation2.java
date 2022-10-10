package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.*;


public class Customisation2 extends AppCompatActivity implements View.OnClickListener {
    private String Icon1,Icon2;
    private Button xbutton,clubbutton,obutton,spadebutton;
    private boolean clicked1,clicked2,clicked3,clicked4;
    public Customisation2(){
        this.Icon1=".";
        this.Icon2=".";
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customisation_new2p);
        xbutton=(Button) findViewById(R.id.x_button);

    clubbutton=(Button) findViewById(R.id.club_button);
        obutton=(Button) findViewById(R.id.o_button);
        spadebutton=(Button) findViewById(R.id.spade_button);
        xbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                clicked1=true;
            }
        });
        clubbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                clicked2=true;
            }
        });
        obutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                clicked3=true;
            }
        });
        spadebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                clicked4=true;
            }
        });






    }
    public String getIcon1(){
        CheckClick(clicked1,clicked2,clicked3,clicked4);
        return this.Icon1;
    }
    public String getIcon2(){
        CheckClick(clicked1,clicked2,clicked3,clicked4);
        return this.Icon2;
    }




    /*public void OButtonClick(View view) {
        Intent intent = new Intent(this, GameBoard2p.class);
        startActivity(intent);

    }
    public void HButtonClick(View view) {
        Intent intent = new Intent(this, GameBoard2p.class);
        startActivity(intent);

    }
    public void SButtonClick(View view) {
        Intent intent = new Intent(this, GameBoard2p.class);
        startActivity(intent);
*/

    public void CheckClick(boolean A,boolean B,boolean C,boolean D){
        if(A){
            this.Icon1="X";
        }
        else if(!B){
            this.Icon1="♣";
        }
        if(C){
            this.Icon2="O";
        }
        else if(!D){
            this.Icon2="♠";
        }

    }

    public void SubmitButtonClick(View view) {
        Intent intent = new Intent(this, GameBoard2p.class);
        startActivity(intent);
    }
    @Override
    public void onClick(View view) {












    }
}
