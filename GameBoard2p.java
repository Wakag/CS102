package com.example.tic_tac_toe;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


    public class GameBoard2p extends AppCompatActivity implements View.OnClickListener {
        private TextView Player1,Player2;
        private Button[] buttons=new Button[9];
        private Button resetbutton;
        private int Player1Score,Player2Score, roundCnt;
        private String p1Symbol,p2Symbol;
        private RadioButton p1Button,p2Button;
        boolean activeplayer;



        int [] state={-1,-1,-1,-1,-1,-1,-1,-1,-1};

        int [] [] winpos={ {0,1,2},{3,4,5},{6,7,8},//rows
                {0,3,6},{1,4,7},{2,5,8},//columns
                {0,4,8},{2,4,6}//diagonals

        };



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.two_player);
            Player1 = (TextView) findViewById(R.id.player1_score);
            Player2=(TextView) findViewById(R.id.player2_score);

            resetbutton = (Button) findViewById(R.id.reset_button);
            case R.id.

            for(int i=0; i<buttons.length; i++){
                String buttonID = "b"+i;
                int resourceID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i] = (Button) findViewById(resourceID);
                buttons[i].setOnClickListener(this);


            }
            roundCnt=0;
            Player1Score=0;
            Player2Score=0;
            activeplayer=true;



        }
        @Override
        public void onClick(View v){
        if(!((Button)v).getText().toString().equals("")){
            return;
        }
        String buttonID=v.getResources().getResourceEntryName(v.getId());
        int buttonNum=Integer.parseInt(buttonID.substring(buttonID.length()-1,buttonID.length()));
        

            if(activeplayer)
            {
                //((Button)v).setText("X");
                ((Button)v).setText(p1Button.getText());
                ((Button)v).setTextColor(Color.parseColor("#FFFFFF"));
            }
            else
            {
                //((Button)v).setText("O");
                ((Button)v).setText(p2Button.getText());
                ((Button)v).setTextColor(Color.parseColor("#FFFF00"));
            }

        }

    }

