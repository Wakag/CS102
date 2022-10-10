package com.example.tic_tac_toe;
import java.util.Random;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import  java.util.ArrayList;

public class GameBoard extends AppCompatActivity implements View.OnClickListener {
    private TextView Player, Computer, PlayerStatus;
    private Button[] buttons = new Button[9];
    private Button resetbutton;
    private int PlayerScore, ComputerScore,roundCnt;
    private String p1Symbol,p2Symbol;
    private RadioButton p1Button,p2Button;
    boolean activeplayer;



    int[] state = {-1,-1,-1,-1,-1,-1,-1,-1,-1};

    int[][] winpos = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},//rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},//columns
            {0, 4, 8}, {2, 4, 6}//diagonals

    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player);
        Player = (TextView) findViewById(R.id.player1_score);
        Computer= (TextView) findViewById(R.id.player2_score);


        resetbutton = (Button) findViewById(R.id.reset_button);

        for(int i=0; i<buttons.length; i++){
            String buttonID = "b"+i;
            int resourceID = getResources().getIdentifier(buttonID, "id", getPackageName());
            buttons[i] = (Button) findViewById(resourceID);
            buttons[i].setOnClickListener(this);


        }
        roundCnt=0;
        PlayerScore=0;
        ComputerScore=0;
        activeplayer = true;
        resetbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                ClearBoard();
                PlayerScore=0;
                ComputerScore=0;
                Player.setText(""+PlayerScore);
                Computer.setText(""+ComputerScore);

            }
        });





    }


    @Override

    public void onClick(View v) {
        if (!(((Button) v).getText().equals(""))) {
            Toast.makeText(this, "Block has been filled", Toast.LENGTH_SHORT).show();
            return;
        } else if (roundCnt < 9) {
            ((Button) v).setText("X");
            //((Button)v).setText(R.id.x_button.getText());
            ((Button) v).setTextColor(Color.parseColor("#FFFFFF"));
            String buttonID = v.getResources().getResourceEntryName(v.getId());
            int Stateind = Integer.parseInt(buttonID.substring(buttonID.length() - 1, buttonID.length()));
            state[Stateind] = 0;
            activeplayer = false;
            roundCnt += 1;
            if(checkWin()){
                Toast.makeText(this,"You have won",Toast.LENGTH_SHORT).show();
                PlayerScore++;
                Player.setText(""+PlayerScore);
                ClearBoard();

            }

        } else if (roundCnt < 9) {
            compMove1();
            activeplayer = true;
            roundCnt += 1;
            if(checkWin()){
                Toast.makeText(this,"You have lost",Toast.LENGTH_SHORT).show();
                ComputerScore++;
                Computer.setText(""+ComputerScore);
                ClearBoard();

            }


        }



            //((Button)v).setText("O");
    }

    public boolean checkWin() {
        boolean result = false;

        for (int[] pos : winpos) {
            if(state[pos[0]] == state[pos[1]] && state[pos[1]] == state[pos[2]] && state[pos[0]] != -1) {
                result = true;
                //Toast.makeText(this,"player nton nton has won",Toast.LENGTH_SHORT).show();
            }
        }

        return result;

    }
    public void ClearBoard()
    {
        for(int i=0; i<buttons.length; i++)
        {
            buttons[i].setText("");
            state[i]=-1;

        }
        roundCnt=0;
        activeplayer=true;

    }

    public void compMove1(){
        Random rand = new Random();
        int a =rand.nextInt(9);

        while(!(state[a] ==-1)){
             a =rand.nextInt(9);


        }
        state[a]=1;
        buttons[a].setText("O");
        buttons[a].setTextColor(Color.parseColor("#FF0000"));
        //state[checkState().get(a)]= checkState().get(a);
        //buttons[checkState().get(a)].setText("O");
        //buttons[checkState().get(a)].setTextColor(Color.parseColor("#FF0000"));
        //checkState().remove(a);







    }
    /*public ArrayList <Integer>  checkState(){
       ArrayList <Integer>freeStates=new ArrayList<>();
        for(int i=0; i<buttons.length; i++)
        {
            if((state[i]==-1)){
                freeStates.add(i);
            }
            else{continue;}


        }
        return freeStates;
    }*/



}
