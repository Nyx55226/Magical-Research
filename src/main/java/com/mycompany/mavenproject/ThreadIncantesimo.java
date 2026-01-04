/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject;

/**
 *
 * @author onryo_tsumi
 */
public class ThreadIncantesimo extends Thread {
    private boolean running = true;
    private boolean paused = false;
    private dataGame dati;     
    private int RicercatoreLavoro=0;

    public ThreadIncantesimo(dataGame dati, int RicercatoreLavoro) {
        this.dati = dati;
        this.RicercatoreLavoro=RicercatoreLavoro;
    }
    public void StopRunning(){
        running=false;
    }
    public void setRicercatore(int a){
        RicercatoreLavoro=a;
    }
    public void run() {
        while (running) {
            try {
                String velocità=dati.getVelocità();
                dati.aggiungiincantoExp(RicercatoreLavoro);
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