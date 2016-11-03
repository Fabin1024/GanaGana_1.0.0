package com.example.android.ganagana;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.android.ganagana.Baloto.Automatico;

import org.json.JSONException;

import java.io.IOException;
import java.util.Calendar;


/**
 * Created by ludycom on 05/07/2016.
 */
public class Configuration extends AppCompatActivity {

    ImageView mImageAdd;
    ImageView mImageSave;
    ImageView mImageFecha;
    ImageView mImageBorrar;



    private int pYear;
    private int pMonth;
    private int pDay;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datepicker);

        configurationModel.cargarConfig();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mImageFecha = (ImageView) findViewById(R.id.addFecha);
        mImageFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(v);//configurationModel.saveConfigJson();
            }
        });

        mImageAdd = (ImageView) findViewById(R.id.addConfig);
        mImageAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView d = (TextView) findViewById(R.id.day1);
                TextView m = (TextView) findViewById(R.id.month1);
                TextView a = (TextView) findViewById(R.id.year1);
                if(d.getText().toString().equals("00") &&
                        m.getText().toString().equals("00") &&
                        a.getText().toString().equals("0000")) {
                    Context context = getApplicationContext();
                    CharSequence text = "Debe ingresar una fecha valida";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }else {
                    configurationModel.addConfigJson(d.getText().toString(), m.getText().toString(), a.getText().toString());
                }
                d.setText("00");
                m.setText("00");
                a.setText("0000");
            }
        });

        mImageSave = (ImageView) findViewById(R.id.saveConfig);
        mImageSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Context context = getApplicationContext();
                    CharSequence text = "Gana Gana";

                    if(configurationModel.saveConfigJson()){
                      text = "Fechas guardadas";
                    }else{
                       text = "Debe ingresar por lo menos 5 fechas";
                    }
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        mImageBorrar = (ImageView) findViewById(R.id.BorrarConfig);
        mImageBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    configurationModel.deleteTotal();
                    Context context = getApplicationContext();
                    CharSequence text = "Configuracion Borrada";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(intent, 0);
        //startActivity(intent);
        finish();
        super.onBackPressed();
    }
}




