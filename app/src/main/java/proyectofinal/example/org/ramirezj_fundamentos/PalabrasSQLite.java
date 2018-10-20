package proyectofinal.example.org.ramirezj_fundamentos;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Vector;

public class PalabrasSQLite extends SQLiteOpenHelper {
    public PalabrasSQLite(Context context) {
        super(context, "palabras", null, 4);
    }
    String sql="CREATE TABLE palabras (_id INTEGER PRIMARY KEY AUTOINCREMENT,clasePalabras INTEGER, nombreAleman TEXT, nombreEspanol TEXT)";
    //Métodos de SQLiteOpenHelper
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(sql);
    }

    @Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS palabras");
        db.execSQL(sql);
    }

    public void guardarPalabras() {

        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO palabras VALUES ( null, 1, 'xkylen','azul')");
        db.execSQL("INSERT INTO palabras VALUES ( null, 1, 'kyaq','rojo')");
        db.execSQL("INSERT INTO palabras VALUES ( null, 1, 'txax','verde')");
        db.execSQL("INSERT INTO palabras VALUES ( null, 1, 'qan','amarillo')");
        db.execSQL("INSERT INTO palabras VALUES ( null, 1, 'sjane','blanco')");
        db.execSQL("INSERT INTO palabras VALUES ( null, 1, 'spaj','gris')");
        db.execSQL("INSERT INTO palabras VALUES ( null, 1, 'marron','marron')");
        db.execSQL("INSERT INTO palabras VALUES ( null, 1, 'morado','morado')");
        db.execSQL("INSERT INTO palabras VALUES ( null, 1, 'naranja','naranja')");
        db.execSQL("INSERT INTO palabras VALUES ( null, 1, 'qaq','negro')");
        db.execSQL("INSERT INTO palabras VALUES ( null, 1, 'rosa','rosa')");

        db.execSQL("INSERT INTO palabras VALUES ( null, 2, 'Jun','uno')");
        db.execSQL("INSERT INTO palabras VALUES ( null, 2, 'Kabe','dos')");
        db.execSQL("INSERT INTO palabras VALUES ( null, 2, 'Oxe','tres')");
        db.execSQL("INSERT INTO palabras VALUES ( null, 2, 'Kyaje','cuatro')");
        db.execSQL("INSERT INTO palabras VALUES ( null, 2, 'Jwe','cinco')");
        db.execSQL("INSERT INTO palabras VALUES ( null, 2, 'Qaq','seis')");
        db.execSQL("INSERT INTO palabras VALUES ( null, 2, 'Wuq','siete')");
        db.execSQL("INSERT INTO palabras VALUES ( null, 2, 'Wajxaq','ocho')");
        db.execSQL("INSERT INTO palabras VALUES ( null, 2, 'Belaj','nueve')");
        db.execSQL("INSERT INTO palabras VALUES ( null, 2, 'Laj','diez')");
        db.close();
    }
    public Vector<String> listaPalabras(int cantidad,int clase) {
        Vector<String> result = new Vector<String>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT _id, clasePalabras, nombreAleman, nombreEspanol FROM palabras WHERE clasePalabras =("+ clase+") ORDER BY clasePalabras DESC LIMIT  "+cantidad, null);
        while (cursor.moveToNext()){
            result.add(cursor.getInt(0)+" "+cursor.getInt(1)+" "+cursor.getString(2)+" "+cursor.getString(3));
        }
        cursor.close();
        db.close();
        return result;
    }
}