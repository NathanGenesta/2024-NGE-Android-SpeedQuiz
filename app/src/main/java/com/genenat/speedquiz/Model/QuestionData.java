package com.genenat.speedquiz.Model;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class QuestionData {
    //Crée la liste de question
    private ArrayList<Question> listeQuestion = new ArrayList<>();

    public QuestionData(Context context) {
        this.listeQuestion = initQuestionList(context);
    }

    /**
     * Charge une liste de question depuis la DB.
     * @param context Le contexte de l'application pour passer la query
     * @return Une arraylist charger de Question
     */
    private ArrayList<Question> initQuestionList(Context context){
        ArrayList<Question> listQuestion = new ArrayList<>();
        SpeedQuizSQLiteOpenHelper helper = new SpeedQuizSQLiteOpenHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cursor = db.query(true,"quiz",new String[]{"idQuiz","question","reponse"},null,null,null,null,"idQuiz",null);

        while(cursor.moveToNext()){
            listQuestion.add(new Question(cursor));
        }
        cursor.close();
        db.close();

        //Mélange les questions
        Collections.shuffle(listQuestion);

        return listQuestion;
    }

    /**
     * @return la liste de question
     */
    public ArrayList<Question> getListeQuestion() {
        return listeQuestion;
    }
}
