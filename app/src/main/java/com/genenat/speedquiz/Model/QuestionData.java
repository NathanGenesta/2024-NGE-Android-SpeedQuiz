package com.genenat.speedquiz.Model;
import java.util.ArrayList;

public class QuestionData {
    //Crée la liste de question
    private ArrayList<Question> listeQuestion = new ArrayList<>();

    /**
     * Ajoute une question à la liste de question.
     */
    public void setListeQuestion() {
        listeQuestion.add(new Question("La Terre tourne autour du Soleil.",true));
        listeQuestion.add(new Question("L'eau bout à 80 degrés Celsius.",false));
        listeQuestion.add(new Question("Le cheval est un ruminant.",false));
        listeQuestion.add(new Question("La Révolution française a commencé en 1789.",true));
        listeQuestion.add(new Question("La photosynthèse convertit la lumière en énergie pour les plantes.",true));
        listeQuestion.add(new Question("La gravité est plus forte sur la Lune que sur la Terre.",false));
        listeQuestion.add(new Question("Le diamant est la substance naturelle la plus dure sur Terre.",true));
        listeQuestion.add(new Question("La vitesse de la lumière est d'environ 300 000 km/h.",false));
        listeQuestion.add(new Question("Le système solaire comprend 10 planètes.",false));
        listeQuestion.add(new Question("La Suisse comprend 26 cantons.",true));
    }

    /**
     * @return la liste de question
     */
    public ArrayList<Question> getListeQuestion() {
        setListeQuestion();
        return listeQuestion;
    }
}
