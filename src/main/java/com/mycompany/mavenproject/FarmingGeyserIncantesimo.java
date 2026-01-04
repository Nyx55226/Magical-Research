package com.mycompany.mavenproject;

public class FarmingGeyserIncantesimo extends Thread {
    private dataGame dati; 
    private FarmingMana farmingManaThread;
    
    public FarmingGeyserIncantesimo(dataGame dati, FarmingMana farmingManaThread) {
        this.dati = dati;
        this.farmingManaThread = farmingManaThread;
    }
    @Override
    public void run() {
        try {
            String velocità=dati.getVelocità();
            if (farmingManaThread != null && farmingManaThread.isAlive()) {
                farmingManaThread.pauseThread();
            }
            for (int i = 0; i < 20; i++) {
                double incantesimoMana = dati.getGeyser() * 4 + dati.getCalcoloMana()+ dati.getCristallo()*2+ dati.getRamo()*2;
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
