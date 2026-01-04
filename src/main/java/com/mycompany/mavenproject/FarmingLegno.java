package com.mycompany.mavenproject;

public class FarmingLegno extends Thread {
    private boolean running = true;
    private boolean paused = false;
    private dataGame dati;
    private int addLegno = 0;  

    public FarmingLegno(dataGame dati) {
        this.dati = dati;
    }

    public void stopThread() {
        running = false;
    }
    
    public void pauseThread() {
        paused = true;
    }
    
    public void resumeThread() {
        paused = false;
    }
    
    public void run() {
        while (running) {
            try {
                String velocità=dati.getVelocità();
                if (paused) {
                    Thread.sleep(125);
                    continue;
                }
                addLegno = dati.getDepositoLegno();
                dati.aggiungiLegno(addLegno);
                if(velocità.equals("normale")){ 
                    Thread.sleep(1000);
                }else if(velocità.equals("2")){
                    Thread.sleep(500);
                }else{
                    Thread.sleep(125);
                }
                
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
