package com.example.android.ganagana.Model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ludycom on 05/07/2016.
 */
public class FechasEspecialesItems {


    public String mDay;
    public String mMonth;
    public String mYear;


    public String getDay(){ return mDay;}
    public String getMonth(){ return mMonth;}
    public String getYear(){ return mYear;}

    public void setDay(String Day){ this.mDay = Day;}
    public void setMonth(String Month){ this.mMonth = Month;}
    public void setYear(String Ano){ this.mYear = Ano;}

    public FechasEspecialesItems(String day, String month, String year){
        this.mDay = day;
        this.mMonth = month;
        this.mYear = year;
    }

    public FechasEspecialesItems(JSONObject jsonTemp) throws JSONException {
        if(!jsonTemp.isNull("Day")){mDay = jsonTemp.getString("Day");}
        if(!jsonTemp.isNull("Month")){mMonth = jsonTemp.getString("Month");}
        if(!jsonTemp.isNull("Year")){mYear = jsonTemp.getString("Year");}
    }


}
