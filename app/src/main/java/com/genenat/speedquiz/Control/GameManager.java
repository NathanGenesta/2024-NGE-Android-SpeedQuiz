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
    public GameActivity gameActivity;
    public int currentQuestion = 0;
    int scorePlayer1 = 0;
    int scorePlayer2 = 0;

    QuestionData questionData = new QuestionData();
    ArrayList<Question> questionArrayList = questionData.getListeQuestion();

    /**
     * Change le score du joueur en fonction de sa réponse.
     * @param player Joueur
     * @return le score du joueur en question.
     */
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

    /**
     * @return l'intitulé de la question en cours.
     */
    public String getIntituleQuestion() {
        if (currentQuestion < questionData.getListeQuestion().size()) {
            return questionArrayList.get(currentQuestion).getIntitule();
        }
        return null;
    }

    /**
     * Réinitialise toutes les texte view et désactive et
     * rend invisible les bouton replay et menu.
     */
    public void startGame() {
        gameActivity.getTextViewPlayer1().setText(getIntituleQuestion());
        gameActivity.getTextViewPlayer2().setText(getIntituleQuestion());
        gameActivity.getButtonReplay().setEnabled(false);
        gameActivity.getButtonMenu().setEnabled(false);
        scorePlayer1 = 0;
        scorePlayer2 = 0;

    }

    /**
     * Passe à la question suivante et si il n'y a plus de question
     * ça active et affiche les boutons replay et menu.
     */
    public void getNextQuestion() {
        currentQuestion++;
        gameActivity.getTextViewPlayer1().setText(getIntituleQuestion());
        gameActivity.getTextViewPlayer2().setText(getIntituleQuestion());
        //Si on est à la dernière question, ça active et affiche les boutons
        if (currentQuestion == questionData.getListeQuestion().size()) {
            gameActivity.getButtonReplay().setEnabled(true);
            gameActivity.getButtonMenu().setEnabled(true);
            gameActivity.getButtonReplay().setVisibility(View.VISIBLE);
            gameActivity.getButtonMenu().setVisibility(View.VISIBLE);
        }
    }
}
