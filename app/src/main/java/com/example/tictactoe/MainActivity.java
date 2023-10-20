package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int stop=1;
    int activePly = 1;
    int[] gameState = {0,0,0,0,0,0,0,0,0};

    int[][] winPosition = { {0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{2,5,8},
            {0,4,8},{2,4,6}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void Tap(View view) {
        if(stop!=1){
            ImageView img = (ImageView) view;
            int tappedImg = Integer.parseInt(img.getTag().toString());
            if ((gameState[tappedImg] == 0)) {
                gameState[tappedImg] = activePly;
                if (activePly == 1) {
                    img.setImageResource(R.drawable.x);
                    activePly = 2;
                    TextView status = findViewById(R.id.status);
                    status.setText("Player 2 turn ");
                } else {
                    img.setImageResource(R.drawable.o);
                    activePly = 1;
                    TextView status = findViewById(R.id.status);
                    status.setText("Player 1 turn ");
                }
            }

        }
        for(int[] win:winPosition){
            if((gameState[win[0]]== gameState[win[1]]) && (gameState[win[1]] == gameState[win[2]]) &&
            gameState[win[0]]!=0){
                String winner;
                stop=0;
                if(gameState[win[0]]==1){
                    winner="player 1 WON";
                    TextView status =findViewById(R.id.status);
                    status.setText(winner);

                }
                else{
                    winner="player 2 WON";
                    TextView status =findViewById(R.id.status);
                    status.setText(winner);

                }

            }

        }

    }

    public void replay(View view) {
        Button replay =findViewById(R.id.button);
        finish();
        startActivity(getIntent());

    }
    }
