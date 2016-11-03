package com.example.android.ganagana;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by ludycom on 07/07/2016.
 */
public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker

        TextView d = (TextView) getActivity().findViewById(R.id.day1);
        TextView m = (TextView) getActivity().findViewById(R.id.month1);
        TextView a = (TextView) getActivity().findViewById(R.id.year1);

       /* if(!d.getText().toString().equals("0") || !d.getText().toString().equals("Dia")
                && !m.getText().toString().equals("0") || !m.getText().toString().equals("Mes")
                && !a.getText().toString().equals("0") || !a.getText().toString().equals("Año")){*/
        if (!d.getText().toString().equals("00")
            && !m.getText().toString().equals("00")
            && !a.getText().toString().equals("0000")) {
            int _a = Integer.parseInt(a.getText().toString());
            int _m = Integer.parseInt(m.getText().toString());
            int _d = Integer.parseInt(d.getText().toString());
            return new DatePickerDialog(getActivity(), this, _a, _m - 1, _d);
        } else {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);

        }


    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        //TextView tv1= (TextView) getActivity().findViewById(R.id.textview1);
        TextView d = (TextView) getActivity().findViewById(R.id.day1);
        TextView m = (TextView) getActivity().findViewById(R.id.month1);
        TextView a = (TextView) getActivity().findViewById(R.id.year1);

        int _m = (int) view.getMonth() + 1;

        d.setText("" + view.getDayOfMonth());
        m.setText("" + _m);
        a.setText("" + view.getYear());
        //tv1.setText("Año: "+view.getYear()+" Mes: "+view.getMonth()+" Dias: "+view.getDayOfMonth());

    }


}
