package com.example.android.ganagana;

import android.content.res.AssetManager;
import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import android.content.res.AssetManager;
import android.util.Log;

import com.example.android.ganagana.Model.FechasEspecialesItems;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ludycom on 14/07/2016.
 */
public class predictivoModel {

    public static void cargarConfig() {
        try {
            String path = Environment.getExternalStorageDirectory().getAbsolutePath();
            String Root = path + "/dataDate";
            String filename = "date.txt";
            File pathTemp = new File(Root);

            if (validFile(pathTemp, filename)) {
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

    public static boolean validFile(File Path, String filename) {
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

}
