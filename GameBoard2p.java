package com.example.tic_tac_toe;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


    public class GameBoard2p extends AppCompatActivity implements View.OnClickListener {
        private TextView Player1,Player2,PlayerStatus;
        private Button[] buttons=new Button[9];
        private Button resetbutton,submit2;
        private int Player1Score,Player2Score, roundCnt;


        boolean activeplayer;
        Customisation2 icon=new Customisation2();



        int [] state={-1,-1,-1,-1,-1,-1,-1,-1,-1};


        int [] [] winpos={ {0,1,2},{3,4,5},{6,7,8},//rows
                {0,3,6},{1,4,7},{2,5,8},//columns
                {0,4,8},{2,4,6}//diagonals

        };
        String p1= icon.getIcon1();
        String p2= icon.getIcon2();
        //player1 = 0
        //player2 = 1
        //Empty = -1

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.two_player);
            Player1 = (TextView) findViewById(R.id.player1_score);
            Player2=(TextView) findViewById(R.id.player2_score);
            PlayerStatus=(TextView) findViewById(R.id.game_status);




            submit2=(Button) findViewById(R.id.submit_2);
            resetbutton = (Button) findViewById(R.id.reset_button);

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
            resetbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    ClearBoard();
                    Player1Score=0;
                    Player2Score=0;
                    Player1.setText(""+Player1Score);
                    Player2.setText(""+Player2Score);

                }
            });



        }

        @Override
        public void onClick(View v){

            if(!(((Button)v).getText().equals("")))
            {
                Toast.makeText(this,"Block has been filled",Toast.LENGTH_SHORT).show();
                return;
            }

            else if(activeplayer && roundCnt<9)
            {
                ((Button)v).setText(p1);
                //((Button)v).setText(R.id.x_button.getText());
                ((Button)v).setTextColor(Color.parseColor("#FFFFFF"));
                String buttonID = v.getResources().getResourceEntryName(v.getId());
                int Stateind = Integer.parseInt(buttonID.substring(buttonID.length() -1, buttonID.length()));
                state[Stateind] = 0;
                activeplayer=false;
                roundCnt+=1;
                if (checkWin()){
                    Toast.makeText(this,"player 1 has won",Toast.LENGTH_SHORT).show();
                    Player1Score++;
                    Player1.setText(""+Player1Score);
                    ClearBoard();

                }

            }
            else if(roundCnt<9)
            {
                ((Button)v).setText(p2);
                //((Button)v).setText(Icon2.getText());
                ((Button)v).setTextColor(Color.parseColor("#FFEC4F"));
                String buttonID = v.getResources().getResourceEntryName(v.getId());
                int Stateind = Integer.parseInt(buttonID.substring(buttonID.length() -1, buttonID.length()));
                state[Stateind] = 1;
                activeplayer=true;
                roundCnt+=1;
                if (checkWin()){
                    Toast.makeText(this,"player 2 has won",Toast.LENGTH_SHORT).show();
                    Player2Score++;
                    Player2.setText(""+Player2Score);
                    ClearBoard();
                    activeplayer=true;





                }




            }
            if(Player1Score==5){
                PlayerStatus.setText("Player 1 is the Grand Winner!!!");
                ClearBoard();
                Player1Score=0;
                Player1.setText(""+Player1Score);


            }
            else if(Player2Score==5){
                PlayerStatus.setText("Player 2 is the Grand Winner!!!");
                ClearBoard();
                Player2Score=0;
                Player2.setText(""+Player2Score);

            }
            if(roundCnt==9){
                Toast.makeText(this,"It's a draw!",Toast.LENGTH_SHORT).show();
                ClearBoard();
            }




        }
        public boolean checkWin() {
            boolean result = false;

            for (int[] pos : winpos) {
                if(state[pos[0]] == state[pos[1]] && state[pos[1]] == state[pos[2]] && state[pos[0]] != -1) {
                    result = true;
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
            PlayerStatus.setText("");

        }


    }

