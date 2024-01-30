package com.genenat.speedquiz.Model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SpeedQuizSQLiteOpenHelper extends SQLiteOpenHelper {

    static String DB_NAME="SpeedQuiz.db";
    static int DB_VERSION=1;

    public SpeedQuizSQLiteOpenHelper(Context context)
    {
        super(context,DB_NAME,null,DB_VERSION);
    }

    /**
     * Ajoute une question à la base de donnée.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE quiz(idQuiz INTEGER PRIMARY KEY, question TEXT, reponse INTEGER);");
        db.execSQL("INSERT INTO quiz VALUES (null, \"La Terre tourne autour du Soleil.\", 1);");
        db.execSQL("INSERT INTO quiz VALUES (null, \"L'eau bout à 80 degrés Celsius.\", 0);");
        db.execSQL("INSERT INTO quiz VALUES (null, \"Le cheval est un ruminant.\", 0);");
        db.execSQL("INSERT INTO quiz VALUES (null, \"La Révolution française a commencé en 1789.\", 1);");
        db.execSQL("INSERT INTO quiz VALUES (null, \"La photosynthèse convertit la lumière en énergie pour les plantes.\", 1);");
        db.execSQL("INSERT INTO quiz VALUES (null, \"La gravité est plus forte sur la Lune que sur la Terre.\", 0);");
        db.execSQL("INSERT INTO quiz VALUES (null, \"Le diamant est la substance naturelle la plus dure sur Terre.\", 1);");
        db.execSQL("INSERT INTO quiz VALUES (null, \"La vitesse de la lumière est d'environ 300 000 km/h.\", 0);");
        db.execSQL("INSERT INTO quiz VALUES (null, \"Le système solaire comprend 10 planètes.\", 0);");
        db.execSQL("INSERT INTO quiz VALUES (null, \"La Suisse comprend 26 cantons.\", 1);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}
}