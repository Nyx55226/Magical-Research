
package com.mycompany.mavenproject;

public class FarmingMana extends Thread {
    private boolean running = true;
    private boolean paused = false;
    private dataGame dati;
    private final double calculatorSilos = 0.5;
    private double accumulatedMana = 0.0;  

    public FarmingMana(dataGame dati) {
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
                accumulatedMana += (dati.getCalcoloMana() + dati.getGeyser()*2 + dati.getCristallo()*2 + dati.getRamo()*2);
                int addMana = (int) accumulatedMana;
                dati.aggiungiMana(addMana);
                accumulatedMana -= addMana;
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
