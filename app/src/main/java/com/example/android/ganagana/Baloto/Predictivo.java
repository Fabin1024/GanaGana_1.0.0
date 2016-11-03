package com.example.android.ganagana.Baloto;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.ganagana.MainActivity;
import com.example.android.ganagana.R;
import com.example.android.ganagana.configurationModel;
import com.example.android.ganagana.predictivoModel;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fmoreno on 17/06/2016.
 */
public class Predictivo extends AppCompatActivity {
    private static List<String> lNumeros = new ArrayList<String>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gana_gana_baloto_manual);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        //addListenerOnButton();
        predictivoModel.cargarConfig();
        final Button btnAuto = (Button)findViewById(R.id.btn_manual);


        btnAuto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //clicks++;
                //btnAuto.setText("Has pulsado el boton "+clicks+" veces");
                calcular();
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
        finish();
        super.onBackPressed();
    }
    public void calcular(){
        int b1 = 0;
        int b2 = 0;
        int b3 = 0;
        int b4 = 0;
        int b5 = 0;
        int b6 = 0;

        final TextView ball1 = (TextView)findViewById(R.id.ball1);
        final TextView ball2 = (TextView)findViewById(R.id.ball2);
        final TextView ball3 = (TextView)findViewById(R.id.ball3);
        final TextView ball4 = (TextView)findViewById(R.id.ball4);
        final TextView ball5 = (TextView)findViewById(R.id.ball5);
        final TextView ball6 = (TextView)findViewById(R.id.ball6);

        if(configurationModel.mFechasEspechalesList.size() > 5){
            for(int i = 0; i < configurationModel.mFechasEspechalesList.size(); i++){
                String Day = configurationModel.mFechasEspechalesList.get(i).mDay;
                String Month = configurationModel.mFechasEspechalesList.get(i).mMonth;
                String Year = configurationModel.mFechasEspechalesList.get(i).mYear;
                addNum(Day, Month, Year);
            }

            //String[] sArray = (String[]) lNumeros.toArray();
            boolean valid = true;

            while (valid) {
                for (int s = 0; s < lNumeros.size(); s++) {
                    int n1 = (int) (Math.random() * lNumeros.size());
                    b1 = Integer.parseInt(lNumeros.get(n1).toString());
                    int n2 = (int) (Math.random() * lNumeros.size());
                    b2 = Integer.parseInt(lNumeros.get(n2).toString());
                    int n3 = (int) (Math.random() * lNumeros.size());
                    b3 = Integer.parseInt(lNumeros.get(n3).toString());
                    int n4 = (int) (Math.random() * lNumeros.size());
                    b4 = Integer.parseInt(lNumeros.get(n4).toString());
                    int n5 = (int) (Math.random() * lNumeros.size());
                    b5 = Integer.parseInt(lNumeros.get(n5).toString());
                    int n6 = (int) (Math.random() * lNumeros.size());
                    b6 = Integer.parseInt(lNumeros.get(n6).toString());
                    break;
                }
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
    }

    public static void addNum(String day, String month, String year){
        String num1 = "";
        String num2 = "";
        String num3 = "";
        if(!lNumeros.contains(day)){
            if(!lNumeros.contains(month)){
                lNumeros.add(day);}}
        for(int j = 0; j < year.length(); j++){
            char numero0 = year.charAt(j);
            char numero1 = year.charAt(j + 1);
            char numero2 = year.charAt(j + 2);
            char numero3 = year.charAt(j + 3);
            num1 = "" + numero0 + numero1;
            num2 = "" + numero2 + numero3;
            num3 = "" + numero1 + numero2;
            break;
        }
        if(!lNumeros.contains(num1))
            lNumeros.add(num1);
        if(lNumeros.contains(num2))
            lNumeros.add(num2);
        if(lNumeros.contains(num3))
            lNumeros.add(num3);
    }


}

