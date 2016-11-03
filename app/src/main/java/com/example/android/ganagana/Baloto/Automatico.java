package com.example.android.ganagana.Baloto;

/**
 * Created by Fmoreno on 17/06/2016.
 */

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.android.ganagana.MainActivity;
import com.example.android.ganagana.R;

import java.util.Random;

public class Automatico extends AppCompatActivity{
    int clicks = 0;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gana_gana_baloto_auto);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        //addListenerOnButton();

        final Button btnAuto = (Button)findViewById(R.id.btn_auto);


        btnAuto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //clicks++;
                //btnAuto.setText("Has pulsado el boton "+clicks+" veces");
                calculeAuto();
            }
        });

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(intent, 0);
        //startActivity(intent);
        finish();
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void calculeAuto(){
        final TextView ball1 = (TextView)findViewById(R.id.ball1);
        final TextView ball2 = (TextView)findViewById(R.id.ball2);
        final TextView ball3 = (TextView)findViewById(R.id.ball3);
        final TextView ball4 = (TextView)findViewById(R.id.ball4);
        final TextView ball5 = (TextView)findViewById(R.id.ball5);
        final TextView ball6 = (TextView)findViewById(R.id.ball6);
        Random rnd = new Random();
        int b1 = 0;
        int b2 = 0;
        int b3 = 0;
        int b4 = 0;
        int b5 = 0;
        int b6 = 0;

        boolean valid = true;

        while (valid){
            b1 = (int) (rnd.nextDouble() * 45 + 1);
            b2 = (int) (rnd.nextDouble() * 45 + 1);
            b3 = (int) (rnd.nextDouble() * 45 + 1);
            b4 = (int) (rnd.nextDouble() * 45 + 1);
            b5 = (int) (rnd.nextDouble() * 45 + 1);
            b6 = (int) (rnd.nextDouble() * 45 + 1);

            if(b1 != b2 && b1 != b3 && b1 != b4 && b1 != b5 && b1 != b6 &&
                    b2 != b3 && b2 != b4 && b2 != b5 && b2 != b6 && b3 != b4 &&
                    b3 != b5 && b3 != b6 && b4 != b5 && b4 != b6 && b5 != b6 ){
                valid = false;
            }

        }
        ball1.setText("" + b1);
        ball2.setText("" + b2);
        ball3.setText("" + b3);
        ball4.setText("" + b4);
        ball5.setText("" + b5);
        ball6.setText("" + b6);
    }
    /*public void addListenerOnButton() {

        imageButton = (ImageButton) findViewById(R.id.imageButton1);

        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Toast.makeText(Automatico.this,
                        "ImageButton is clicked!", Toast.LENGTH_SHORT).show();

            }

        });

    }*/
}
