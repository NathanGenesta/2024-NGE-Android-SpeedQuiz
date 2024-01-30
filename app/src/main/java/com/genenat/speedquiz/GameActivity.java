package com.genenat.speedquiz;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.genenat.speedquiz.Control.GameManager;
import com.genenat.speedquiz.Model.Question;
import com.genenat.speedquiz.Model.QuestionData;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {
    private MaterialButton BT_player1;
    private MaterialButton BT_player2;
    private MaterialButton BT_replay;
    private MaterialButton BT_menu;
    private TextView TV_namePlayer1;
    private TextView TV_namePlayer2;
    private TextView TV_scorePlayer1;
    private TextView TV_scorePlayer2;
    private TextView TV_questionPlayer1;
    private TextView TV_questionPlayer2;
    private GameManager gameManager = new GameManager();

    /**
     * @return le bouton replay.
     */
    public MaterialButton getButtonReplay() {
        return BT_replay;
    }

    /**
     * @return le bouton menu.
     */
    public MaterialButton getButtonMenu() {
        return BT_menu;
    }

    /**
     * @return le bouton du joueur 1.
     */
    public MaterialButton getButtonPlayer1() {
        return BT_player1;
    }

    /**
     * @return le bouton du joueur 2.
     */
    public MaterialButton getButtonPlayer2() {
        return BT_player2;
    }

    /**
     * @return la texte view des questions du joueur 1.
     */
    public TextView getTextViewPlayer1() {
        return TV_questionPlayer1;
    }

    /**
     * @return la texte view des questions du joueur 2.
     */
    public TextView getTextViewPlayer2() {
        return TV_questionPlayer2;
    }

    /**
     * @return la texte view des scores du joueur 1.
     */
    public TextView getTextViewScorePlayer1() {
        return TV_scorePlayer1;
    }

    /**
     * @return la texte view des scores du joueur 2.
     */
    public TextView getTextViewScorePlayer2() {
        return TV_scorePlayer2;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        gameManager.gameActivity = this;
        gameManager.questionData = new QuestionData(this);

        BT_player1 = findViewById(R.id.button_player1);
        BT_player2 = findViewById(R.id.button_player2);
        BT_replay = findViewById(R.id.button_replay);
        BT_menu = findViewById(R.id.button_menu);

        TV_namePlayer1 = findViewById(R.id.textView_namePlayer1);
        TV_namePlayer2 = findViewById(R.id.textView_namePlayer2);
        TV_scorePlayer1 = findViewById(R.id.textView_scorePlayer1);
        TV_scorePlayer2 = findViewById(R.id.textView_scorePlayer2);
        TV_questionPlayer1 = findViewById(R.id.textView_questionPlayer1);
        TV_questionPlayer2 = findViewById(R.id.textView_questionPlayer2);

        //Récupère les noms des joueurs saisis dans l'activity_main
        Intent gameActivity = getIntent();
        String namePlayer1 = String.valueOf(gameActivity.getStringExtra("namePlayer1"));
        String namePlayer2 = String.valueOf(gameActivity.getStringExtra("namePlayer2"));

        //Affiche les noms des joueurs dans les Text View
        TV_namePlayer1.setText(namePlayer1);
        TV_namePlayer2.setText(namePlayer2);
    }

    @Override
    protected void onStart() {
        super.onStart();

        //Lance le jeu
        gameManager.startGame();

        /**
         * Lorsqu'on clique sur le bouton "Replay", ça relance
         * l'activity_game
         */
        BT_replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
            }
        });

        /**
         * Lorsqu'on clique sur le bouton "Menu", ça retourne
         * dans l'activity_main
         */
        BT_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        /**
         * Lorsque le joueur 1 clique sur son bouton, ça affiche la
         * question suivante et ça met à jour son score.
         */
        BT_player1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTextViewScorePlayer1().setText(String.valueOf(gameManager.setScore(1)));
            }
        });

        /**
         * Lorsque le joueur 2 clique sur son bouton, ça affiche la
         * question suivante et ça met à jour son score.
         */
        BT_player2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTextViewScorePlayer2().setText(String.valueOf(gameManager.setScore(2)));
            }
        });
    }
}