package com.genenat.speedquiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private MaterialButton BT_newPlayer;
    private EditText ET_player1;
    private EditText ET_player2;
    private TextInputLayout LayoutET_player1;
    private TextInputLayout LayoutET_player2;
    private MaterialButton BT_startGame;
    private LinearLayout layoutAbout;
    private MaterialButton BT_about_ok;
    private MenuItem about;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar mainToolbar = findViewById(R.id.topAppBar);
        setSupportActionBar(mainToolbar);

        BT_newPlayer = findViewById(R.id.button_newPlayer);
        LayoutET_player1 = findViewById(R.id.editTextLayout_player1);
        LayoutET_player2 = findViewById(R.id.editTextLayout_player2);
        ET_player1 = findViewById(R.id.editText_namePlayer1);
        ET_player2 = findViewById(R.id.editText_namePlayer2);
        BT_startGame = findViewById(R.id.button_startGame);
        layoutAbout = findViewById(R.id.layout_about);
        BT_about_ok = findViewById(R.id.button_about_ok);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();

        /**
         * Active le bouton "Play" si les 2 edits texts sont remplis.
         */
        ET_player1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                BT_startGame.setEnabled(!ET_player1.getText().toString().isEmpty() && !ET_player2.getText().toString().isEmpty());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        /**
         * Active le bouton "Play" si les 2 edits texts sont remplis.
         */
        ET_player2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                BT_startGame.setEnabled(!ET_player1.getText().toString().isEmpty() && !ET_player2.getText().toString().isEmpty());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        /**
         * Lorsqu'on clique sur le bouton "New player", ça affiche
         * le premier edit text et ensuite l'autre edit text et le
         * bouton "Play" désactivé.
         */
        BT_newPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (LayoutET_player1.getVisibility() == View.VISIBLE) {
                    LayoutET_player2.setVisibility(View.VISIBLE);
                    ET_player2.setEnabled(true);
                    BT_startGame.setVisibility(View.VISIBLE);
                } else {
                    LayoutET_player1.setVisibility(View.VISIBLE);
                    ET_player1.setEnabled(true);
                }
            }
        });

        /**
         * Lorsqu'on clique sur le bouton "Play", ça enregistre les noms des
         * joueurs et ça démarre l'activity_game.
         */
        BT_startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gameActivity = new Intent(MainActivity.this, GameActivity.class);

                // Enregistre les noms des joueurs dans des paramètres
                gameActivity.putExtra("namePlayer1", ET_player1.getText().toString());
                gameActivity.putExtra("namePlayer2", ET_player2.getText().toString());

                // Lance le jeu
                startActivity(gameActivity);
            }
        });

        /**
         * Lorsqu'on clique sur le bouton "OK" d'about, ça remet invisible le
         * layout "About"
         */
        BT_about_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutAbout.setVisibility(View.INVISIBLE);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        System.out.println("Bonjour");
        if (about.getItemId() == R.id.about) {
            layoutAbout.setVisibility(View.VISIBLE);
        }
           return super.onOptionsItemSelected(item);
    }
}