package com.genenat.speedquiz.Control;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.genenat.speedquiz.GameActivity;
import com.genenat.speedquiz.Model.Question;
import com.genenat.speedquiz.Model.QuestionData;
import com.genenat.speedquiz.R;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class GameManager {
    GameActivity GameActivity = new GameActivity();
    public int currentQuestion = 0;
    int scorePlayer1 = 0;
    int scorePlayer2 = 0;

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
    public void startGame() {
        GameActivity.getTextViewPlayer1().setText(getIntituleQuestion());
        GameActivity.getTextViewPlayer2().setText(getIntituleQuestion());
        GameActivity.getButtonReplay().setEnabled(false);
        GameActivity.getButtonMenu().setEnabled(false);
        scorePlayer1 = 0;
        scorePlayer2 = 0;

    }

    public void getNextQuestion() {
        currentQuestion++;
        GameActivity.getTextViewPlayer1().setText(getIntituleQuestion());
        GameActivity.getTextViewPlayer2().setText(getIntituleQuestion());
        GameActivity.getTextViewScorePlayer1().setText(String.valueOf(setScore(1)));
        GameActivity.getTextViewScorePlayer2().setText(String.valueOf(setScore(2)));
        //Si on est à la dernière question, ça active et affiche les boutons
        if (currentQuestion == questionData.getListeQuestion().size()) {
            GameActivity.getButtonReplay().setEnabled(true);
            GameActivity.getButtonMenu().setEnabled(true);
            GameActivity.getButtonReplay().setVisibility(View.VISIBLE);
            GameActivity.getButtonMenu().setVisibility(View.VISIBLE);
        }
    }
}
