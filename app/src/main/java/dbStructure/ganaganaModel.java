package dbStructure;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Created by Fabian Moreno on 21/05/2016.
 */
public class ganaganaModel {

    public static final String TABLE_NAME = "tb_gana_gana_special_date";
    public static final String STRING_TYPE = "text";
    public static final String INT_TYPE = "integer";

    //Campos de la tabla Quotes
    public static class ColumnSpecialDates {
        //public static final String FIELD_GANA_GANA_ID = "item_gana_gana_id";
        public static final String FIELD_GANA_GANA_ID = BaseColumns._ID;
        public static final String FIELD_GANA_GANA_DAY = "item_gana_gana_day";
        public static final String FIELD_GANA_GANA_MONTH = "item_gana_gana_month";
        public static final String FIELD_GANA_GANA_YEAR = "item_gana_gana_year";
        public static final String FIELD_GANA_GANA_DATE = "item_gana_gana_date";
    }

        //Script de Creación de la tabla Quotes
        public static final String CREATE_SPECIAL_DATE_SCRIPT =
                "create table "+TABLE_NAME+"(" +
                        ColumnSpecialDates.FIELD_GANA_GANA_ID + " " + INT_TYPE + " primary key autoincrement," +
                        ColumnSpecialDates.FIELD_GANA_GANA_DAY + " " + STRING_TYPE + " not null," +
                        ColumnSpecialDates.FIELD_GANA_GANA_MONTH + " " + STRING_TYPE + " not null," +
                        ColumnSpecialDates.FIELD_GANA_GANA_YEAR + " " + STRING_TYPE + " not null," +
                        ColumnSpecialDates.FIELD_GANA_GANA_DATE + " " + STRING_TYPE + " not null)";

    private dbGanaGana openHelper;
    private SQLiteDatabase database;

    public ganaganaModel(Context context) {
        //Creando una instancia hacia la base de datos
        openHelper = new dbGanaGana(context);
        database = openHelper.getWritableDatabase();
    }



}
