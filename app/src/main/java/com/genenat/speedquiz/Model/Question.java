package com.genenat.speedquiz.Model;

import android.database.Cursor;

public class Question {
    private String intitule;
    private int reponse;

    public Question(Cursor cursor){
        intitule = cursor.getString(cursor.getColumnIndexOrThrow("question"));
        reponse = cursor.getInt(cursor.getColumnIndexOrThrow("reponse"));
    }

    /**
     * Construit une question avec un intitulé et une réponse
     * @param intitule  Intitulé de la question
     * @param reponse   Réponse à la question
     */
    public Question(String intitule, int reponse) {
        this.intitule = intitule;
        this.reponse = reponse;
    }

    /**
     * @return l'intitulé de la question
     */
    public String getIntitule () {
        return intitule;
    }

    /**
     * @return la réponse de la question
     */
    public int getReponse () {
        return reponse;
    }
}
