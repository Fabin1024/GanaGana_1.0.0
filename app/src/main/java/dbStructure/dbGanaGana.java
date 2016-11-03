package dbStructure;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.SQLClientInfoException;

/**
 * Created by Fabian Moreno on 21/05/2016.
 */
public class dbGanaGana extends SQLiteOpenHelper {
    private static final String DB_NAME = "db_database_gana_gana";
    private static final int DB_SCHEME_VERSION = 1;
    private SQLiteDatabase db;
    public dbGanaGana(Context context) {
        super(context, DB_NAME, null, DB_SCHEME_VERSION);
        db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Crear la tabla Quotes
        try{
        db.execSQL(ganaganaModel.CREATE_SPECIAL_DATE_SCRIPT);}
        catch (Exception ex){
            Log.d("SQLiteDatabase","Error al crear la base de datos");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
