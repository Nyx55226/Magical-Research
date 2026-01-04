package com.mycompany.mavenproject;

public class ThreadManaIncantesimo extends Thread {
    private dataGame dati; 
    private FarmingMana farmingManaThread;
    
    public ThreadManaIncantesimo(dataGame dati, FarmingMana farmingManaThread) {
        this.dati = dati;
        this.farmingManaThread = farmingManaThread;
    }
    public void run() {
        try {
            String velocità=dati.getVelocità();
            if (farmingManaThread != null && farmingManaThread.isAlive()) {
                farmingManaThread.pauseThread();
            }
            for (int i = 0; i < 30; i++) {
                double incantesimoMana = dati.getCalcoloMana() * 2 + dati.getGeyser()*2 + dati.getCristallo()*2+ dati.getRamo()*2;
                dati.aggiungiMana((int) incantesimoMana);
            if(velocità.equals("normale")){
                Thread.sleep(1000);
            }else if(velocità.equals("2")){
                Thread.sleep(500);   
            }else{
                Thread.sleep(125);
            }
            }
           
            if (farmingManaThread != null && farmingManaThread.isAlive()) {
                farmingManaThread.resumeThread();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
