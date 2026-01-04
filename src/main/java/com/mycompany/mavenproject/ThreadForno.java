package com.mycompany.mavenproject;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author onryo_tsumi
 */
public class ThreadForno extends Thread {
    private boolean running = true;
    private dataGame dati;
    private int fiamme=0;
    private int forni;
    public ThreadForno(dataGame dati, int forni) {
        this.dati = dati;
        this.forni=forni;
    }
    public void setForni(int a){
        forni=a;
    }
    // Ferma definitivamente il thread
    public void stopThread() {
        running = false;
    }
    
    public void run() {
        while (running) {
            try {
                String velocità=dati.getVelocità();
                if(dati.getLegno()>=3 && forni>0){
                    dati.spendiLegnoTemperatura();
                    fiamme = forni*2;
                    dati.aggiungiFiamma(fiamme);
                if(velocità.equals("normale")){
                        Thread.sleep(1000);
                    }
                }else if(velocità.equals("2")){
                        Thread.sleep(500); 
                    }
                else{
                        Thread.sleep(125);
                    }
               
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}

