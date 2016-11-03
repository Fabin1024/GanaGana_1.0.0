package com.example.android.ganagana;

import android.os.Environment;

import com.example.android.ganagana.Model.FechasEspecialesItems;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ludycom on 05/07/2016.
 */
public class configurationModel {

    public static List<FechasEspecialesItems> mFechasEspechalesList = new ArrayList<FechasEspecialesItems>();

    public static void addConfigJson(String day, String month, String year) {
        FechasEspecialesItems temp = new FechasEspecialesItems(day, month, year);
        temp.setDay(day);
        temp.setMonth(month);
        temp.setYear(year);
        mFechasEspechalesList.add(temp);
    }

    public static boolean saveConfigJson() throws JSONException, IOException {
        JSONObject json = new JSONObject();
        JSONArray fechas = new JSONArray();
        if(mFechasEspechalesList.size() > 4) {
            for (int i = 0; i < mFechasEspechalesList.size(); i++) {
                JSONObject fecha = new JSONObject();
                fecha.put("Day", mFechasEspechalesList.get(i).getDay());
                fecha.put("Month", mFechasEspechalesList.get(i).getMonth());
                fecha.put("Year", mFechasEspechalesList.get(i).getYear());

                fechas.put(fecha);
            }
            json.put("Config", fechas);
            saveConfig(json.toString());
            return true;
        }else{
            return false;
        }
    }

    public static void saveConfig(String jsonConfig) throws IOException {
        String path = Environment.getExternalStorageDirectory().getAbsolutePath();
        String Root = path + "/dataDate";
        String filename = "date.txt";
        File pathTemp = new File(Root);

        if (validFile(pathTemp, filename)) {
            if (pathTemp.mkdir()) {

                File filetemp = new File(pathTemp + "/" + filename);
                //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
                FileWriter escribir = new FileWriter(filetemp, true);
                //Escribimos en el archivo con el metodo write
                escribir.write(jsonConfig);
                //Cerramos la conexion
                escribir.close();
            }
            else{
                File filetemp = new File(pathTemp + "/" + filename);
                //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
                FileWriter escribir = new FileWriter(filetemp, true);
                //Escribimos en el archivo con el metodo write
                escribir.write(jsonConfig);
                //Cerramos la conexion
                escribir.close();
            }
        }
        else{
            File filedelete = new File(pathTemp + "/" + filename);

            filedelete.delete();

            File filetemp = new File(pathTemp + "/" + filename);
            //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
            FileWriter escribir = new FileWriter(filetemp, true);
            //Escribimos en el archivo con el metodo write
            escribir.write(jsonConfig);
            //Cerramos la conexion
            escribir.close();
        }

    }

    public static boolean validFile(File Path, String filename) {
        try {
            File filetemp = new File(Path + "/" + filename);
            if (filetemp.exists()) {
                return false;
            } else {
                return true;
            }
        } catch (Exception i) {
            return true;
        }
    }

    public static void cargarConfig() {
        try {
            String path = Environment.getExternalStorageDirectory().getAbsolutePath();
            String Root = path + "/dataDate";
            String filename = "date.txt";
            File pathTemp = new File(Root);

            if (validFile2(pathTemp, filename)) {
                File filetemp = new File(pathTemp + "/" + filename);
                StringBuilder text = new StringBuilder();
                try {
                    BufferedReader br = new BufferedReader(new FileReader(filetemp));
                    String line;

                    while ((line = br.readLine()) != null) {
                        text.append(line);
                    }
                    br.close();
                    cargarJson(text.toString());
                } catch (IOException e) {
                }
            }else{

            }


        } catch (Exception i) {

        }
    }

    public static boolean validFile2(File Path, String filename) {
        try {
            File filetemp = new File(Path + "/" + filename);
            if (filetemp.exists()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception i) {
            return false;
        }
    }
    public static void cargarJson(String text) throws JSONException {
        configurationModel.mFechasEspechalesList = new ArrayList<FechasEspecialesItems>();
        JSONObject object = new JSONObject(text);
        JSONArray json_Array = object.optJSONArray("Config");
        for (int j = 0; j < json_Array.length(); j++) {
            configurationModel.mFechasEspechalesList.add(new FechasEspecialesItems(json_Array.getJSONObject(j)));
        }
    }

    public static void deleteTotal(){
        String path = Environment.getExternalStorageDirectory().getAbsolutePath();
        String Root = path + "/dataDate";
        String filename = "date.txt";
        File pathTemp = new File(Root);

        if (validFile2(pathTemp, filename)) {
            File filetemp = new File(pathTemp + "/" + filename);
            filetemp.delete();
            mFechasEspechalesList.clear();
        }
    }
}
