package com.mycompany.mavenproject;

public class FarmingLegnoIncantesimo extends Thread {
    private dataGame dati; 
    private FarmingLegno farmingLegnoThread;
    
    public FarmingLegnoIncantesimo(dataGame dati, FarmingLegno farmingLegnoThread) {
        this.dati = dati;
        this.farmingLegnoThread = farmingLegnoThread;
    }
    
    public void run() {
        try {
            String velocità=dati.getVelocità();
            if (farmingLegnoThread != null && farmingLegnoThread.isAlive()) {
                farmingLegnoThread.pauseThread();
            }
            for (int i = 0; i < 30; i++) {
                int incantesimoLegno = dati.getDepositoLegno() * 2;
                dati.aggiungiLegno(incantesimoLegno);
                if(velocità.equals("normale")){
                    Thread.sleep(1000);
                }else if(velocità.equals("2")){
                    Thread.sleep(500);
                }else{
                    Thread.sleep(125);
                }
            }
            
            if (farmingLegnoThread != null && farmingLegnoThread.isAlive()) {
                farmingLegnoThread.resumeThread();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
