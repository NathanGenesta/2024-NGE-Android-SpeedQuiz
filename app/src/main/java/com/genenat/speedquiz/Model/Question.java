package com.genenat.speedquiz.Model;

public class Question {
    private String intitule;
    private boolean reponse;

    /**
     * Construit une question avec un intitulé et une réponse
     * @param intitule  Intitulé de la question
     * @param reponse   Réponse à la question
     */
    public Question(String intitule, boolean reponse) {
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
    public boolean getReponse () {
        return reponse;
    }
}
