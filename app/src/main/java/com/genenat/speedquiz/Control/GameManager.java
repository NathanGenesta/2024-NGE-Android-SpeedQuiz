package com.genenat.speedquiz.Control;

import android.widget.TextView;

import com.genenat.speedquiz.Model.Question;
import com.genenat.speedquiz.Model.QuestionData;
import com.genenat.speedquiz.R;

import java.util.ArrayList;

public class GameManager {
    public int currentQuestion = 0;
    int scorePlayer1 = 0;
    int scorePlayer2 = 0;
    private TextView TV_scorePlayer1;
    QuestionData questionData = new QuestionData();
    ArrayList<Question> questionArrayList = questionData.getListeQuestion();
    public int setScore(int player) {
        if (player == 1) {
            if (questionArrayList.get(currentQuestion-1).getReponse()) {
                scorePlayer1++;
            } else {
                scorePlayer1--;
            }
            return scorePlayer1;
        } else {
            if (questionArrayList.get(currentQuestion-1).getReponse()) {
                scorePlayer2++;
            } else {
                scorePlayer2--;
            }
            return scorePlayer2;
        }
    }

    public String getIntituleQuestion() {
        if (currentQuestion < questionData.getListeQuestion().size()) {
            return questionArrayList.get(currentQuestion).getIntitule();
        }
        return null;
    }
}
