package com.mycompany.mavenproject;

public class Game {
    private dataGame dati;
    
    public Game() {
        dataGame temp = dataGame.caricaDaFile("salvataggio.txt");
        this.dati = temp;
    }
    
    public Game(dataGame datiCaricati) {
        this.dati = datiCaricati;
    }
    
    public dataGame getDataGame() {
        return dati;
    }

}
