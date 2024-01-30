package com.genenat.speedquiz.Control;

import android.os.Looper;
import android.view.View;
import com.genenat.speedquiz.GameActivity;
import com.genenat.speedquiz.Model.QuestionData;
import android.os.Handler;

public class GameManager {
    private int questionsSpeed = 5000;
    public GameActivity gameActivity;
    public int currentQuestion = 0;
    int scorePlayer1 = 0;
    int scorePlayer2 = 0;

    public QuestionData questionData;
    private Handler mainHandler = new Handler(Looper.getMainLooper());

    private Runnable nextQuestionRunnable = new Runnable() {
        @Override
        public void run() {
            getNextQuestion();
            //Affiche la question suivante une fois le temps écoulé
            mainHandler.postDelayed(this, questionsSpeed);
        }
    };

    /**
     * Change le score du joueur en fonction de sa réponse.
     * @param player Joueur
     * @return le score du joueur en question.
     */
    public int setScore(int player) {
        // Réinitialise le delay pour la question suivante
        mainHandler.removeCallbacks(nextQuestionRunnable);
        mainHandler.postDelayed(nextQuestionRunnable, questionsSpeed);

        //Passe à la question suivante
        getNextQuestion();
        if (player == 1) {
            if (questionData.getListeQuestion().get(currentQuestion-1).getReponse() == 1) {
                scorePlayer1++;
            } else {
                scorePlayer1--;
            }
            return scorePlayer1;
        } else {
            if (questionData.getListeQuestion().get(currentQuestion-1).getReponse() == 1) {
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
            return questionData.getListeQuestion().get(currentQuestion).getIntitule();
        }
        return null;
    }

    /**
     * Réinitialise toutes les texte view et désactive et
     * rend invisible les bouton replay et menu.
     */
    public void startGame() {
        mainHandler.postDelayed(nextQuestionRunnable, questionsSpeed);
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

        //Affiche l'intitulé de la question en cours
        gameActivity.getTextViewPlayer1().setText(getIntituleQuestion());
        gameActivity.getTextViewPlayer2().setText(getIntituleQuestion());

        //Si on est à la dernière question, ça active et affiche les boutons
        if (currentQuestion == questionData.getListeQuestion().size()) {
            //Active les boutons "Replay" et "Menu"
            gameActivity.getButtonReplay().setEnabled(true);
            gameActivity.getButtonMenu().setEnabled(true);

            //Affiche les boutons "Replay" et "Menu"
            gameActivity.getButtonReplay().setVisibility(View.VISIBLE);
            gameActivity.getButtonMenu().setVisibility(View.VISIBLE);

            //Désactive les boutons des deux joueurs
            gameActivity.getButtonPlayer1().setEnabled(false);
            gameActivity.getButtonPlayer2().setEnabled(false);
        }
    }
}
