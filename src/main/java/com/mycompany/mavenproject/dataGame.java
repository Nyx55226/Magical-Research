package com.mycompany.mavenproject;

import java.io.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.Duration;

public class dataGame implements Serializable {
    private static final long serialVersionUID = 657L;
    private ObjectivesManager objectivesManager;
    // Variabili per le risorse di gioco
    private int fiamma;
    private int mana;
    private int silos;
    private int pietra;
    private int acqua;
    private int monete;
    private int legno;
    private double ferro;
    private String scuola;
    private String elemento;
    private Duration durata;
    private long secondi;
    private String velocità="normale";
    private int time;
    private LocalDateTime timeAttuale;
    private LocalDateTime timeApertura;
    private boolean runPietra=false;
    private boolean runAcqua=false;
    private boolean runRoccia=false;
    private boolean runIncantoMana=false;
    private boolean runAcquaII=false;
    private boolean runSpettacoloMagia=false;
    private  boolean runMineraleFerro=false;
    private boolean runMasso=false;
    private boolean runAcquaIII=false;
    private boolean runBarreFerro=false;
    private boolean runDepositiLegno=false;
    private boolean runGeyserIncanto=false;
    private boolean runSpettacoloVento=false;
    private boolean runSpettacoloBolle=false;
    private boolean runSpettacoloFuoco=false;
    private boolean pausa;
    
    // Item
    private ArrayList<String>inventario=new ArrayList<>();
    private String mano;
    private String corpo;
    private String accessorio;
    private String posizioneMano;
    private String posizioneCorpo;
    private String posizioneAccessorio;
    private int cassa;
    private int ramo;
    private int mazza;
    private int pugnale;
    private int spada;
    private int ascia;
    private int staffaFuoco;
    private int falce;
    private int armaturaMaglia;
    private int tunicaStregone;
    private int vestitoLadro;
    private int cristallo;
    private int sandaliLegno;
    private int mantello;
    private int scarpeStoffa;
    private int mantelloIncantato;
    private int stoffa;
    private int lana;
    private int fireSpeak;
    
    // Esperienze per incantesimi
    private int evocazioneExp; 
    private int incantoExp;    
    private int illusioneExp; 
    
    // Edifici
    private int manaShard;
    private int magazzino;
    private int depositoLegname;
    private int SerbatoioAcqua;
    private int Geyser;
    private int contoSilos = 0;
    private int caveau;
    private int StazioneDiLavoro;
    private int forno;
    private int fornoAttivo=0;
    
    // Gestione dei ricercatori e apprendisti
    // Ricercatore: numero totale di ricercatori posseduti
    private int Ricercatore;
    // CapacitàRicercatore: massimo numero di ricercatori che puoi avere
    private int CapacitàRicercatore;
    
    // Variabili per gestire i ricercatori assegnati alle scuole
    private int ricercatoriEvocazione;
    private int ricercatoriIncanto;
    private int ricercatoriIllusione;
    
    //Variabili per gestire gli apprendisti assegnati
    private int apprendistiPietra;
    private int apprendistiAcqua;
    private int apprendistiRoccia;
    private int apprendistiAcquaII;
    private int apprendistiMineraliFerro;
    private int apprendistiMasso;
    private int apprendistiAcquaIII;
    private int apprendistiSbarraFerro;
    private int apprendistiGettiMana;
    private int apprendistiDepositoLegno;
    private int apprendistiGeyserMana;
    private int apprendistiMagia;
    private int apprendistiFuoco;
    private int apprendistiBolle;
    private int apprendistiVento;
    
    // Variabili per i livelli attuali degli incantesimi
    private int livelloAttualeEvocazione;
    private int livelloAttualeIncanto;
    private int livelloAttualeIllusione;
    
    //Gestione degli apprendisti
    //apprendisti: numero totali di apprendisti posseduti
    private int apprendisti;
    
    // I thread non vengono serializzati
    private transient FarmingMana farmingManaThread;
    private transient FarmingLegno farmingLegnoThread;
    private transient ThreadManaIncantesimo threadManaIncantesimo;
    private transient FarmingLegnoIncantesimo farmingLegnoIncantesimo;
    private transient FarmingGeyserIncantesimo farmingGeyserIncantesimo;
    private transient ThreadEvocazione threadEvocazione;
    private transient ThreadIncantesimo threadIncantesimo;
    private transient ThreadIllusione threadIllusione;
    private transient ThreadForno threadForno;
    
    //Modalità scura o no
    private boolean modalitàScura=false;
    
    // Generazione numeri
    Random r = new Random();
    
    // Flag per la visibilità delle risorse
    private boolean legnoVisibile = false;
    private boolean ferroVisibile = false;
    private boolean moneteVisibile = false;
    private boolean acquaVisibile = false;
    private boolean pietraVisibile = false;
    private boolean manaVisibile = false;
    private boolean timeVisibile = false;
    private boolean expEvocazioneA=false;
    private boolean expIncantesimoA=false;
    private boolean expIllusioneA=false;
    private boolean fiammaVisibile=false;
    
    // Costruttore
    public dataGame() {
        
        // Inizializzazione dei ricercatori (totale e assegnati)
        this.Ricercatore = 0;
        this.CapacitàRicercatore = 1;
        this.ricercatoriEvocazione = 0;
        this.ricercatoriIncanto = 0;
        this.ricercatoriIllusione = 0;
        
        // Inizializzo i livelli degli incantesimi
        this.livelloAttualeEvocazione = 1;
        this.livelloAttualeIncanto = 1;
        this.livelloAttualeIllusione = 1;
        
        // inizializzo gli apprendisti (totali e assegnati)
        this.apprendisti=0;
        this.apprendistiPietra=0;
        this.apprendistiAcqua=0;
        this.apprendistiRoccia=0;
        this.apprendistiAcquaII=0;
        this.apprendistiMineraliFerro=0;
        this.apprendistiMasso=0;
        this.apprendistiAcquaIII=0;
        this.apprendistiSbarraFerro=0;
        this.apprendistiGettiMana=0;
        this.apprendistiDepositoLegno=0;
        this.apprendistiGeyserMana=0;
        this.apprendistiMagia=0;
        this.apprendistiFuoco=0;
        this.apprendistiBolle=0;
        this.apprendistiVento=0;
        
        // Altre risorse
        this.forno=0;
        this.fiamma=0;
        this.Geyser = 0;
        this.evocazioneExp = 0;
        this.incantoExp = 0;
        this.illusioneExp = 0;
        this.mana = 0;
        this.silos = 0;
        this.pietra = 0;
        this.acqua = 0;
        this.monete = 0;
        this.manaShard = 0;
        this.magazzino = 0;
        this.legno = 0;
        this.ferro = 0;
        this.scuola = "";
        this.elemento = "";
        this.depositoLegname = 0;
        this.SerbatoioAcqua = 0;
        this.caveau = 0;
        this.time = 0;
        this.pausa=false;
        this.StazioneDiLavoro=0;
        
        //Item
        for(int i=0;i<18;i++){
            inventario.add("");
        }
        this.posizioneAccessorio="";
        this.posizioneCorpo="";
        this.posizioneMano="";
        this.mano="";
        this.corpo="";
        this.accessorio="";
        this.cassa=0;
        this.ramo=0;
        this.mazza=0;
        this.pugnale=0;
        this.spada=0;
        this.ascia=0;
        this.staffaFuoco=0;
        this.falce=0;
        this.armaturaMaglia=0;
        this.tunicaStregone=0;
        this.vestitoLadro=0;
        this.cristallo=0;
        this.sandaliLegno=0;
        this.mantello=0;
        this.scarpeStoffa=0;
        this.mantelloIncantato=0;
        this.stoffa=0;
        this.lana=0;
        this.fireSpeak=0;
        
        this.objectivesManager = new ObjectivesManager();
    }
    public void aggiungiItemInventario(String id){
        System.out.println(id);
        for(int i=0;i<inventario.size();i++){
            if(inventario.get(i).equals("")){
                inventario.set(i, id);
                return;
            }
        }
    }
    public void rimuoviItemInventario(int b){
        inventario.set(b, "");
    }
    public List<String> getInventario(){
        return inventario;
    }
    public void aggiungiEquipaggiamento(String id,String b){
        if(id.equals("Ramo") || id.equals("Mazza") || id.equals("Pugnale") || id.equals("Spada") || id.equals("Ascia a una Mano") || id.equals("Staffa di Fuoco") || id.equals("Falce")){
            mano=id;
            posizioneMano=b;
        }else if(id.equals("Maglia di Ferro") || id.equals("Tunica del Mago") || id.equals("Tunica del Mago") || id.equals("Abito del Ladro") || id.equals("Mantello Incantato") || id.equals("Scarpe di Stoffa") || id.equals("Mantello") || id.equals("Sandali di Legno")){
            corpo=id;
            posizioneCorpo=b;
        }else{
            accessorio=id;
            posizioneAccessorio=b;
        }

    }
    public void temp(){
        time=30000;
        updateVisibilitaRisorse();
    }
    public ObjectivesManager getObjectivesManager() {
        return objectivesManager;
    }
    // --- Getter e setter per le risorse varie ---
    
    public int getCaveau() {
        return caveau;
    }

    public void setMano(String mano) {
        this.mano = mano;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public void setAccessorio(String accessorio) {
        this.accessorio = accessorio;
    }
    
    public int getCassa() {
        return cassa;
    }

    public int getRamo() {
        return ramo;
    }

    public String getPosizioneMano() {
        return posizioneMano;
    }

    public String getPosizioneCorpo() {
        return posizioneCorpo;
    }
    
    public String getPosizioneAccessorio() {
        return posizioneAccessorio;
    }
    
    public int getMazza() {
        return mazza;
    }

    public String getMano() {
        return mano;
    }
    
    public String getCorpo() {
        return corpo;
    }

    public String getAccessorio() {
        return accessorio;
    }
    
    public int getPugnale() {
        return pugnale;
    }

    public int getSpada() {
        return spada;
    }

    public int getAscia() {
        return ascia;
    }

    public int getStaffaFuoco() {
        return staffaFuoco;
    }

    public int getFalce() {
        return falce;
    }

    public int getArmaturaMaglia() {
        return armaturaMaglia;
    }

    public int getLana() {
        return lana;
    }

    public int getFireSpeak() {
        return fireSpeak;
    }
    
    public int getTunicaStregone() {
        return tunicaStregone;
    }

    public int getVestitoLadro() {
        return vestitoLadro;
    }

    public int getCristallo() {
        return cristallo;
    }

    public int getSandaliLegno() {
        return sandaliLegno;
    }

    public int getMantello() {
        return mantello;
    }

    public int getScarpeStoffa() {
        return scarpeStoffa;
    }

    public int getMantelloIncantato() {
        return mantelloIncantato;
    }

    public int getStoffa() {
        return stoffa;
    }
    
    public int getTime() {
        return time;
    }
    
    public int getRicercatore() {
        return Ricercatore;
    }
    public int getApprendisti(){
        return apprendisti;
    }
    public void setVelocità(String a){
        this.velocità=a;
    }
    public String getVelocità(){
        return velocità;
    }
    public int getCapacitàRicercatore() {
        return CapacitàRicercatore;
    }
    public void setCapacitàRicercatore(int c) {
        this.CapacitàRicercatore = c;
    }
    public int getLivelloAttualeEvocazione() {
        return livelloAttualeEvocazione;
    }
    public int getLivelloAttualeIncanto() {
        return livelloAttualeIncanto;
    }
    public int getLivelloAttualeIllusione() {
        return livelloAttualeIllusione;
    }
    public boolean getModalitàScura(){
        return modalitàScura;
    }
    public void setModalitàScura(boolean a){
        modalitàScura=a;
    }
    public int getStazioneDiLavoro(){
        return StazioneDiLavoro;
    }
    public int getApprendistiPietra() {
        return apprendistiPietra;
    }

    public int getApprendistiAcqua() {
        return apprendistiAcqua;
    }

    public int getApprendistiRoccia() {
        return apprendistiRoccia;
    }
    public int getFornoAttivi(){
        return fornoAttivo;
    }
    public int getApprendistiAcquaII() {
        return apprendistiAcquaII;
    }

    public int getApprendistiMineraliFerro() {
        return apprendistiMineraliFerro;
    }

    public int getApprendistiMasso() {
        return apprendistiMasso;
    }

    public int getApprendistiAcquaIII() {
        return apprendistiAcquaIII;
    }

    public int getApprendistiSbarraFerro() {
        return apprendistiSbarraFerro;
    }

    public int getApprendistiGettiMana() {
        return apprendistiGettiMana;
    }

    public int getApprendistiDepositoLegno() {
        return apprendistiDepositoLegno;
    }

    public int getApprendistiGeyserMana() {
        return apprendistiGeyserMana;
    }

    public int getApprendistiMagia() {
        return apprendistiMagia;
    }

    public int getApprendistiFuoco() {
        return apprendistiFuoco;
    }

    public int getApprendistiBolle() {
        return apprendistiBolle;
    }

    public int getApprendistiVento() {
        return apprendistiVento;
    }
    public int getFiamma(){
        return fiamma;
    }
    public int getForno(){
        return forno;
    }
    public boolean getExpEvocazioneA(){
        return expEvocazioneA;
    }
    public boolean getExpIllusioneA(){
        return expIllusioneA;
    }
    public boolean getExpIncantesimoA(){
        return expIncantesimoA;
    }
    public void setExpIncantesimoA(boolean a){
        expIncantesimoA=a;
    }
    public void setExpIllusioneA(boolean a){
        expIllusioneA=a;
    }
    public void setExpEvocazioneA(boolean a){
        expEvocazioneA=a;
    }
    public int getDepositoLegno() {
        return depositoLegname;
    }
    public int getGeyser() {
        return Geyser;
    }
    public int getContoSilos() {
        return contoSilos;
    }
    public int getSerbatoioAcqua() {
        return SerbatoioAcqua;
    }
    public int getMagazzino() {
        return magazzino;
    }
    public String getScuola() {
        return scuola;
    }
    public void setScuola(String scuola) {
        this.scuola = scuola;
    }
    public String getElemento() {
        return elemento;
    }
    public void setElemento(String elemento) {
        this.elemento = elemento;
    }
    public int getMana() {
        return mana;
    }
    public int getSilos() {
        return silos;
    }
    public int getPietra() {
        return pietra;
    }
    public int getAcqua() {
        return acqua;
    }
    public int getMonete() {
        return monete;
    }
    public int getManaShard() {
        return manaShard;
    }
    public double getFerro() {
        return ferro;
    }
    public int getLegno() {
        return legno;
    }
    public int getEvocazioneExp() {
        return evocazioneExp;
    }
    public int getIncantoExp() {
        return incantoExp;
    }
    public int getIllusioneExp() {
        return illusioneExp;
    }
    public int getMaxevocazioneoExp() {
        if(livelloAttualeEvocazione==1){
            return livelloAttualeEvocazione*1000;
        }else{
            return (livelloAttualeEvocazione*500)*livelloAttualeEvocazione;
        }
        
    }
    public int getMaxIllusioneExp() { 
        if(livelloAttualeIllusione==1){
           return livelloAttualeIllusione*1000;
        }else{
             return (livelloAttualeIllusione*500)*livelloAttualeIllusione;
        }
       
    }
    public int getMaxIncantoExp() { 
        if(livelloAttualeIncanto==1){
            return livelloAttualeIncanto*1000;
        }else{
             return (livelloAttualeIncanto*500)*livelloAttualeIncanto;
        }
    }
    public int getMaxMana() {
        return 100 + manaShard * 100;
    }
    public int getMaxPietra() {
        return 50 + magazzino * 400; 
    }
    public int getMaxFiamma(){
        return 500+forno*500;
    }
    public int getMaxTime() {
        return 30000;
    }
    public int getMaxAcqua() {
        return 10 + SerbatoioAcqua * 250;
    }
    public int getMaxMonete() {
        return 1000 + caveau * 20000;
    }
    public double getMaxFerro() {
        return 20 + magazzino * 200;
    }
    public int getMaxLegno() {
        return 50 + magazzino * 400;
    }
    public double getCalcoloMana() {
        return 0.5 * silos;
    }
    public int getRisorsaNecesariaSilosPietra(){
        return 10+3*silos;
    }
    public int getRisorsaNecesariaSilosAcqua(){
        return 2+1*silos;
    }
    public int getRisorsaNecesariaFrammentoMana(){
        return 100+30*manaShard;
    }
    public int getRisorsaNecessariaMoneteRicercatore(){
        if(Ricercatore<1){
            return 200;
        }else if(Ricercatore<2){
            return 500;
        }else{
            return 500*Ricercatore;
        }
    }
    public int getRisorsaNecessariaMoneteMagazzino(){
        return 200+magazzino*60;
    }
    public int getRisorsaNecessariaPietraMagazzino(){
        return 30+magazzino*9;
    }
    public int getRisorsaNecessariaLegnoLegname(){
        return 25+depositoLegname*8;
    }
    public int getRisorsaNecessariaPietraLegname(){
        return 10+depositoLegname*3;
    }
    public int getRisorsaNecessariaMoneteCabinaR(){
        if(CapacitàRicercatore<=1){
            return 150;
        }else{
            return 150+CapacitàRicercatore*45;
        }  
    }
    public int getRisorsaNecessariaLegnoCabinaR(){
        if(CapacitàRicercatore<=1){
            return 320;
        }else{
            return 320+CapacitàRicercatore*96;
        }
    }
    public int getRisorsaNecessariaPietraCabinaR(){
        if(CapacitàRicercatore<=1){
            return 110;
        }else{
            return 110+CapacitàRicercatore*33;
        }
    }
    public int getRisorsaNecessariaMoneteApprendista(){
        return 300+apprendisti*150;
    }
    public int getRisorsaNecessariaLegnoApprendista(){
        return 480+apprendisti*240;
    }
    public int getRisorsanecessariaPietraApprendista(){
        return 240+apprendisti*120;
    }
    public int getRisorsaNecessariaMoneteSerbatoioAcqua(){
        return 350+SerbatoioAcqua*105;
    }
    public int getRisorsaNecessariaLegnoSerbatoioAcqua(){
        return 300+SerbatoioAcqua*90;
    }
    public int getRisorsaNecessariaPietraSerbatoioAcqua(){
        return 200+SerbatoioAcqua*60;
    }
    public int getRisorsaNecessariaMoneteVault(){
        return 500+caveau*150;
    }
    public int getRisorsaNecessariaPietraVault(){
        return 600+caveau*180;
    }
    public int getRisorsaNecessariaMoneteGeyser(){
        return 600+Geyser*180;
    }
    public int getRisorsaNecessariaAcquaGeyser(){
        return 150+Geyser*45;
    }
    public int getRisorsaNecessariaFerroGeyser(){
        return 30+Geyser*9;
    }
    public int getRisorsaNecessariaMoneteForno(){
        return 1500+forno*450;
    }
    public int getRisorsaNecessariaPietraForno(){
        return 3000+forno*900;
    }
    public int getRisorsaNecessariaFerroForno(){
        return 100+forno*30;
    }
    public int getCalcoloTempoPietra(){
        if(apprendistiPietra<=0){
            return 0;
        }else{
            return 60/apprendistiPietra;
        } 
    }
    public int getCalcoloTempoAcqua(){
        if(apprendistiAcqua<=0){
            return 0;
        }else{
            return 60/apprendistiAcqua;
        }
        
    }
    public int getCalcoloTempoRoccia(){
        if(apprendistiRoccia<=0){
            return 0;
        }else{
            return 60/apprendistiRoccia;
        }
        
    }
    public int getCalcoloTempoDepositiLegno(){
        if(apprendistiDepositoLegno<=0){
            return 0;
        }else{
            return 60/apprendistiDepositoLegno;
        }
    }
    public int getCalcoloTempoIncantiMana(){
        if(apprendistiGettiMana<=0){
            return 0;
        }else{
            return 60/apprendistiGettiMana;
        }
        
    }
    public int getCalcoloTempoGeyser(){
        if(apprendistiGeyserMana<=0){
            return 0;
        }else{
            return 60/apprendistiGeyserMana;
        }
    }
    public int getCalcoloTempoBarreFerro(){
        if(apprendistiSbarraFerro<=0){
            return 0;
        }else{
            return 60/apprendistiSbarraFerro;
        }
    }
    public int getCalcoloTempoMasso(){
        if(apprendistiMasso<=0){
            return 0;
        }else{
            return 60/apprendistiMasso;
        }
    }
    public int getCalcoloTempoAcquaIII(){
        if(apprendistiAcquaIII<=0){
            return 0;
        }else{
            return 60/apprendistiAcquaIII;
        }
    }
    public int getCalcoloTempoSpettacoloBolle(){
        if(apprendistiBolle<=0){
            return 0;
        }else{
            return 60/apprendistiBolle;
        }
    }
    public int getCalcoloTempoSpettacoloFuoco(){
        if(apprendistiFuoco<=0){
            return 0;
        }else{
            return 60/apprendistiFuoco;
        }
    }
    public int getCalcoloTempoAcquaII(){
        if(apprendistiAcquaII<=0){
            return 0;
        }else{
            return 60/apprendistiAcquaII;
        }
    }
    public int getCalcoloTempoSpettacoloVento(){
        if(apprendistiVento<=0){
            return 0;
        }else{
            return 60/apprendistiVento;
        }
    }
    public int getCalcoloTempoSpettacoloMagia(){
        if(apprendistiMagia<=0){
            return 0;
        }else{
            return 60/apprendistiMagia;
        }
    }
    public int getCalcoloTempoMineraliFerro(){
        if(apprendistiMineraliFerro<=0){
            return 0;
        }else{
            return 60/apprendistiMineraliFerro;
        }
    }
    // Metodo getSecondo: restituisce i secondi in base al tempo trascorso e al massimo consentito
    public long getSecondo() {
        return Math.min(secondi, getMaxTime());
    }
    public int forniDisponibili(){
        return forno-fornoAttivo;
    }
    public void rimuovereForno(){
        if(fornoAttivo>0){
            fornoAttivo--;
            threadForno.setForni(fornoAttivo);
        }
    }
    public void aggiungiForno(){
        if(forniDisponibili()>0){
            fornoAttivo++;
            threadForno.setForni(fornoAttivo);
        }
    }
    // --- Metodi per comprare risorse ---
    public void compraCassa(){
        if(mana>=750 && legno>=4500 && ferro>=10){
            mana-=750;
            legno-=4500;
            ferro-=10;
            cassa++;
        }
    }
    public void compraRamo(){
        if(legno>=300 && mana>=1000){
            legno-=300;
            mana-=1000;
            ramo++;
        }
    }
    public void compraMazza(){
        if(legno>=900){
            legno-=900;
            mazza++;
        }
        
    }
    public void compraPugnale(){
        if(ferro>=60 && legno>=40 && fiamma>=300){
            ferro-=60;
            legno-=40;
            fiamma-=300;
            pugnale++;
        }
    }
    public void compraSpada(){
        if(ferro>=120 && legno>=200 && fiamma>=600){
            ferro-=120;
            legno-=200;
            fiamma-=600;
             spada++;
        }
    }
    public void compraAscia(){
        if(ferro>=150 && legno>=300 && fiamma>=600){
            ferro-=150;
            legno-=300;
            fiamma-=600;
            ascia++;
        }
    }
    public void compraStaffaFuoco(){
        if(legno>=3000 && mana>=2500 && fireSpeak>=1){
            legno-=3000;
            mana-=2500;
            fireSpeak-=1;
            staffaFuoco++;
        }
        
    }
    public void compraFalce(){
        if(ferro>=1100 && legno>=3000 && fiamma>=1500){
            ferro-=1100;
            legno-=3000;
            fiamma-=1500;
            falce++;
        }
    }
    public void compraArmaturaMaglia(){
        if(ferro>=300 && fiamma>=1200){
            ferro-=300;
            fiamma-=1200;
            armaturaMaglia++;
        }
    }
    public void compraTunicaStregone(){
        if(mana>=1600 && stoffa>=12){
            mana-=1600;
            stoffa-=12;
            tunicaStregone++;
        }
    }
    public void compraVestitoLadro(){
        if(mana>=2000 && fiamma>=1500 && stoffa>=15){
            mana-=2000;
            fiamma-=1500;
            stoffa-=15;
            vestitoLadro++;
        }
    }
    public void compraCristallo(){
        if(mana>=1000){
            mana-=1000;
            cristallo++;
        }
    }
    
    public void compraSandaliLegno(){
        if(legno>=750){
            legno-=750;
            sandaliLegno++;
        }
    }
    
    public void compraMantello(){
        if(stoffa>=4){
            stoffa-=4;
            mantello++;
        }
    }
    
    public void compraScarpeStoffa(){
        if(stoffa>=8){
            stoffa-=8;
            scarpeStoffa++;
        }
    }
    
    public void compraMantelloIncantato(){
        if(mana>=2200 && mantello>=1 && stoffa>=4){
            mana-=2200;
            mantello-=1;
            stoffa-=4;
            mantelloIncantato++;
        }
        
    }
    public void compraStoffa(){
        if(lana>=4){
            lana-=4;
            stoffa++;
        }
        
    }
    public void rimuoviMagliFerro(){
        armaturaMaglia--;
    }
    public void rimuoviFalce(){
        falce--;
    }
    public void rimuoviStaffaFuoco(){
        staffaFuoco--;
    }
    public void rimuoviAscia(){
        ascia--;
    }
    public void rimuoviSpada(){
        spada--;
    }
    public void rimuoviPugnale(){
        pugnale--;
    }
    public void rimuoviMazza(){
        mazza--;
    }
    public void rimuoviRamo(){
        ramo--;
    }
    public void rimuoviMantelloIncantato(){
        mantelloIncantato--;
    }
    public void rimuoviScarpeStoffa(){
        scarpeStoffa--;
    }
    public void rimuoviMantello(){
        mantello--;
    }
    public void rimuoviSandali(){
        sandaliLegno--;
    }
    public void rimuoviAbitoLadro(){
        vestitoLadro--;
    }
    public void rimuoviTunicaStregone(){
        tunicaStregone--;
    }
    public void spendiLegnoTemperatura(){
        legno-=forno*3;
    }
    public void compraPietra() {
        if (mana >= 10) {
            mana -= 10;
            pietra = Math.min(pietra + 5, getMaxPietra());
            aggiungiEvocazioneoExp(15);
            updateVisibilitaRisorse();
        }
    }
    public void SpendiPezziTempo(){
        if(time>=3000){
            if(ricercatoriEvocazione>0){
                aggiungiEvocazioneoExp(1500);
                time-=3000;
            }
            if(ricercatoriIncanto>0){
                aggiungiincantoExp(1500);
                time-=3000;
            }
            if(ricercatoriIllusione>0){
                aggiungiIllusioneExp(1500);
                time-=3000;
            }
        }
    }
    public void saltoTemporaleTime(){
        if(time>=3000){
            time-=3000;
        }
    }
    // Metodo per comprare ricercatore: il limite massimo è dato da CapacitàRicercatore
    public void compraRicercatore() {
        if (monete >= getRisorsaNecessariaMoneteRicercatore()) {
            if (CapacitàRicercatore > Ricercatore) {
                monete -= getRisorsaNecessariaMoneteRicercatore();
                Ricercatore++;
            }
        }
    }
    // Metodo per comprare apprendisti
    public void compraApprendista(){
        if(monete>=getRisorsaNecessariaMoneteApprendista() && legno>=getRisorsaNecessariaLegnoApprendista() && pietra>=getRisorsanecessariaPietraApprendista()){
            monete-=getRisorsaNecessariaMoneteApprendista();
            legno-=getRisorsaNecessariaLegnoApprendista();
            pietra-=getRisorsanecessariaPietraApprendista();
            apprendisti++;
        }
        
    }
    public void compraCapacitàRicercatore(){
        if(monete>=getRisorsaNecessariaMoneteCabinaR() && legno>=getRisorsaNecessariaLegnoCabinaR() && pietra>=getRisorsaNecessariaPietraCabinaR()){
        monete-=getRisorsaNecessariaMoneteCabinaR();
        legno-=getRisorsaNecessariaLegnoCabinaR();
        pietra-=getRisorsaNecessariaPietraCabinaR();
        CapacitàRicercatore++;
        }
    }
    public void compraStazioneDiLavoro(){
        if(monete>=2000 && legno>=2000 && ferro>=100){
            monete-=2000;
            legno-=2000;
            ferro-=100;
            StazioneDiLavoro++;
        }
    }
    public void compraRoccia() {
        if (mana >= 40) {
            mana -= 40;
            pietra = Math.min(pietra + 90, getMaxPietra());
            updateVisibilitaRisorse();
        }
    }
    public void compraBarreFerro() {
        if (mana >= 320) {
            mana -= 320;
            ferro = Math.min(ferro + 80, getMaxFerro());
            updateVisibilitaRisorse();
        }
    }
    public void compraAcqua() {
        if (mana >= 20) {
            mana -= 20;
            acqua = Math.min(acqua + 2, getMaxAcqua());
            aggiungiEvocazioneoExp(15);
            updateVisibilitaRisorse();
        }
    }
    public void compraAcquaII() {
        if (mana >= 180) {
            mana -= 180;
            acqua = Math.min(acqua + 35, getMaxAcqua());
            updateVisibilitaRisorse();
        }
    }
    public void compraMonete() {
        if (mana >= 30) {
            mana -= 30;
            monete = Math.min(monete + r.nextInt(7) + 30, getMaxMonete());
            aggiungiIllusioneExp(15);
            updateVisibilitaRisorse();
        }
    }
    public void compraMoneteVento() {
        if (mana >= 70) {
            mana -= 70;
            monete = Math.min(monete + r.nextInt(51) + 100, getMaxMonete());
            updateVisibilitaRisorse();
        }
    }
    public void compraMoneteBolle() {
        if (mana >= 150) {
            mana -= 150;
            monete = Math.min(monete + r.nextInt(101) + 350, getMaxMonete());
            updateVisibilitaRisorse();
        }
    }
    public void compraMoneteFuoco() {
        if (mana >= 580) {
            mana -= 580;
            monete = Math.min(monete + r.nextInt(801) + 2000, getMaxMonete());
            updateVisibilitaRisorse();
        }
    }
    public void compraManaShard() {
        if (monete >= getRisorsaNecesariaFrammentoMana()) {
            monete -= getRisorsaNecesariaFrammentoMana();
            manaShard++;
            updateVisibilitaRisorse();
        }
    }
    public void compraMagazzino() {
        if (monete >= getRisorsaNecessariaMoneteMagazzino() && pietra >= getRisorsaNecessariaPietraMagazzino()) {
            monete -= getRisorsaNecessariaMoneteMagazzino();
            pietra -= getRisorsaNecessariaPietraMagazzino();
            magazzino++;
            updateVisibilitaRisorse();
        }
    }
    public void compraGeyser() {
        if (monete >= getRisorsaNecessariaMoneteGeyser() && acqua >= getRisorsaNecessariaAcquaGeyser() && ferro >= getRisorsaNecessariaFerroGeyser()) {
            monete -= getRisorsaNecessariaMoneteGeyser();
            acqua -= getRisorsaNecessariaAcquaGeyser();
            ferro -= getRisorsaNecessariaFerroGeyser();
            Geyser ++;
            if (silos != 0 || Geyser!=0) {
                avviaFarmingMana();
            }
            updateVisibilitaRisorse();
        }
    }
    public void compraCaveau() {
        if (monete >= getRisorsaNecessariaMoneteVault() && pietra >= getRisorsaNecessariaPietraVault()) {
            monete -= getRisorsaNecessariaMoneteVault();
            pietra -= getRisorsaNecessariaPietraVault();
            caveau++;
            updateVisibilitaRisorse();
        }
    }
    public void compraMineraliDiFerro() {
        if (mana >= 20) {
            mana -= 20;
            ferro = Math.min(ferro + 5.0, getMaxFerro());
            updateVisibilitaRisorse();
        }
    }
    public void compraMasso() {
        if (mana >= 440) {
            mana -= 440;
            pietra = Math.min(pietra + 1200, getMaxPietra());
            updateVisibilitaRisorse();
        }
    }
    public void compraAcquaIII() {
        if (mana >= 1060) {
            mana -= 1060;
            acqua = Math.min(acqua + 420, getMaxAcqua());
            updateVisibilitaRisorse();
        }
    }
    public void compraSerbatoioA() {
        if (monete >= getRisorsaNecessariaMoneteSerbatoioAcqua() && legno >= getRisorsaNecessariaLegnoSerbatoioAcqua() && pietra >= getRisorsaNecessariaPietraSerbatoioAcqua()) {
            monete -= getRisorsaNecessariaMoneteSerbatoioAcqua();
            legno -= getRisorsaNecessariaLegnoSerbatoioAcqua();
            pietra -= getRisorsaNecessariaPietraSerbatoioAcqua();
            SerbatoioAcqua++;
            updateVisibilitaRisorse();
        }
    }
    public void costruisciDepositoLegname() {
        if (mana >= 200 && pietra >= getRisorsaNecessariaPietraLegname() && legno >= getRisorsaNecessariaLegnoLegname()) {
            mana -= 200;
            pietra -= getRisorsaNecessariaPietraLegname();
            legno -= getRisorsaNecessariaLegnoLegname();
            depositoLegname++;
            updateVisibilitaRisorse();
        }
        if (depositoLegname != 0) {
            avviaFarmingLegno();
        }
    }
    public void costruisciSilos() {
        if (acqua >= getRisorsaNecesariaSilosAcqua() && pietra >= getRisorsaNecesariaSilosPietra()) {
            acqua -= getRisorsaNecesariaSilosAcqua();
            pietra -= getRisorsaNecesariaSilosPietra();
            silos++;
            contoSilos++;
            if (silos != 0) {
                avviaFarmingMana();
            }
            updateVisibilitaRisorse();
        }
    }
    public void compraForno(){
        if(monete>=getRisorsaNecessariaMoneteForno() && pietra>= getRisorsaNecessariaPietraForno() && ferro>= getRisorsaNecessariaFerroForno()){
            monete-=getRisorsaNecessariaMoneteForno();
            pietra-=getRisorsaNecessariaPietraForno();
            ferro-=getRisorsaNecessariaFerroForno();
            forno++;
            fornoAttivo++;
            if(forno>0){
                avviaThreadForno();
            }
            updateVisibilitaRisorse();
        }
    }
    // --- Metodi per comprare incantesimi ---
    
    public void IncantiDepositiLegname() {
        if (mana >= 80) {
            mana -= 80;
            avviaLegnoIncantesimo();
            updateVisibilitaRisorse();
        }
    }
    public void IncantiGettiManaAttiva() {
        if (mana >= 60) {
            mana -= 60;
            aggiungiincantoExp(15);
            avviManaIncantesimo();
            updateVisibilitaRisorse();
        }
    }
    public void IncantiGeyserAttiva() {
        if (mana >= 160) {
            mana -= 160;
            avviGeyserIncantesimo();
            updateVisibilitaRisorse();
        }
    }
    public void spendiTempo(){
        if(velocità.equals("normale")){
        }else if(velocità.equals("2")){
            if(time>=3){
                time-=3;
            }else{
                setVelocità("normale");
            }
        }else if(velocità.equals("8")){
            if(time>=4){
                time-=4;
            }else{
                setVelocità("normale");
            }
        }
    }
    // --- Metodi per la gestione dei thread ---
    
    private void avviaFarmingMana() {
        if (farmingManaThread == null || !farmingManaThread.isAlive()) {
            farmingManaThread = new FarmingMana(this);
            farmingManaThread.start();
        }
    }
    private void avviaLegnoIncantesimo() {
        if (farmingLegnoIncantesimo == null || !farmingLegnoIncantesimo.isAlive()) {
            farmingLegnoIncantesimo = new FarmingLegnoIncantesimo(this, farmingLegnoThread);
            farmingLegnoIncantesimo.start();
        }
    }
    private void avviGeyserIncantesimo() {
        if (farmingGeyserIncantesimo == null || !farmingGeyserIncantesimo.isAlive()) {
            farmingGeyserIncantesimo = new FarmingGeyserIncantesimo(this, farmingManaThread);
            farmingGeyserIncantesimo.start();
        }
    }
    private void avviManaIncantesimo() {
        if (threadManaIncantesimo == null || !threadManaIncantesimo.isAlive()) {
            threadManaIncantesimo = new ThreadManaIncantesimo(this, farmingManaThread);
            threadManaIncantesimo.start();
        }
    }
    private void avviaFarmingLegno() {
        if (farmingLegnoThread == null || !farmingLegnoThread.isAlive()) {
            farmingLegnoThread = new FarmingLegno(this);
            farmingLegnoThread.start();
        }
    }
    private void avviThreadEvocazione(){
        if (threadEvocazione == null || !threadEvocazione.isAlive()) {
            threadEvocazione = new ThreadEvocazione(this,ricercatoriEvocazione);
            threadEvocazione.start();
        }
        threadEvocazione.setRicercatore(ricercatoriEvocazione);
        
    }
    private void avviaThreadForno(){
        if (threadForno == null || !threadForno.isAlive()) {
            threadForno = new ThreadForno(this,fornoAttivo);
            threadForno.start();
        }  
    }
    
    private void avviThreadIncantesimo(){
        if(threadIncantesimo== null || !threadIncantesimo.isAlive()){
            threadIncantesimo= new ThreadIncantesimo(this,ricercatoriIncanto);
            threadIncantesimo.start();
        }
        threadIncantesimo.setRicercatore(ricercatoriIncanto);
    }
    private void avviThreadIllusione(){
        if(threadIllusione== null || !threadIllusione.isAlive()){
            threadIllusione= new ThreadIllusione(this,ricercatoriIllusione);
            threadIllusione.start();
        }
        threadIllusione.setRicercatore(ricercatoriIllusione);
    }
    
    public void restartProduction() {
        if ((silos > 0 || Geyser > 0) && (farmingManaThread == null || !farmingManaThread.isAlive())) {
            avviaFarmingMana();
        }
    }
    
    public void fermaFarmingMana() {
        if (farmingManaThread != null) {
            farmingManaThread.stopThread();
        }
    }
    public void fermaFarmingLegno() {
        if (farmingLegnoThread != null) {
            farmingLegnoThread.stopThread();
        }
    }
    public void fermaThreadEvocazione(){
        if(threadEvocazione!=null){
            threadEvocazione.StopRunning();
        }
    }
    public void fermaThreadIllusione(){
        if(threadIllusione!=null){
            threadIllusione.StopRunning();
        }
    }
    public void fermaThreadIncantesimo(){
        if(threadIncantesimo!=null){
            threadIncantesimo.StopRunning();
        }
    }
    public void restartProductionLegno() {
        if (depositoLegname > 0 && (farmingLegnoThread == null || !farmingLegnoThread.isAlive())) {
            avviaFarmingLegno();
        }
    }
    public void restartThreadEvocazione(){
        if(ricercatoriEvocazione>0){
            avviThreadEvocazione();
        }
    }
    public void restartThreadForno(){
        if(forno>0){
            avviaThreadForno();
        }
    }
    public void restartThreadIllusione(){
        if(ricercatoriIllusione>0){
            avviThreadIllusione();
        }
    }
    public void restartThreadIncantesimo(){
        if(ricercatoriIncanto>0){
            avviThreadIncantesimo();
        }
    }
    
    // --- Metodi per gestire il tempo ---
    
    public void orarioAttuale() {
        timeAttuale = LocalDateTime.now();
    }
    public void orarioApertura() {
        timeApertura = LocalDateTime.now();
    }
    
    // --- Salvataggio e caricamento ---
    
    public void salvaSuFile(String nomeFile) {
        orarioAttuale();
        pausa=false;
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeFile))) {
            out.writeObject(this);
            System.out.println("Salvato");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static dataGame caricaDaFile(String nomeFile) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeFile))) {
            dataGame gd = (dataGame) in.readObject();
            return gd;
        } catch (Exception e) {
            return new dataGame();
        }
    }
    
    public void cancellaSalvataggio(String nomeFile) {
        File file = new File(nomeFile);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("Dati di gioco cancellati con successo.");
            } else {
                System.out.println("Errore nella cancellazione dei dati.");
            }
        } else {
            System.out.println("Nessun dato di gioco trovato.");
        }
    }
    
    // --- Metodi per aggiornare la visibilità delle risorse ---
    
    private void updateVisibilitaRisorse() {
        if (legno > 0) {
            legnoVisibile = true;
        }
        if (ferro > 0) {
            ferroVisibile = true;
        }
        if (monete > 0) {
            moneteVisibile = true;
        }
        if (acqua > 0) {
            acquaVisibile = true;
        }
        if (pietra > 0) {
            pietraVisibile = true;
        }
        if (mana > 0) {
            manaVisibile = true;
        }
        if (time > 0) {
            timeVisibile = true;
        }
        if(forno>0){
            fiammaVisibile=true;
        }
    }
    
    // --- Metodi per raccogliere risorse ---
    
    public void aggiungiMana(int quantita) {
        mana = Math.min(mana + quantita, getMaxMana());
        updateVisibilitaRisorse();
    }
    public void aggiungiFiamma(int quantita){
        fiamma=Math.min(fiamma+quantita,getMaxFiamma());
    }
    public void aggiungiLegno(int quantita) {
        legno = Math.min(legno + quantita, getMaxLegno());
        updateVisibilitaRisorse();
    }
    public void aggiungiFerro(double quantita) {
        ferro = Math.min(ferro + quantita, getMaxFerro());
        updateVisibilitaRisorse();
    }
    public void aggiungiTime() {
        durata = Duration.between(timeAttuale, timeApertura);
        secondi = durata.getSeconds();
        time = Math.min(time + (int) secondi, getMaxTime());
        updateVisibilitaRisorse();
    }
    public void aggiungiEvocazioneoExp(int quantita) {
        evocazioneExp += quantita;
        while(evocazioneExp >= getMaxevocazioneoExp()){
            livelloAttualeEvocazione++;
            if(expEvocazioneA==false){
                expEvocazioneA=true;
            }
            
        }
    }
    public void aggiungiIllusioneExp(int quantita) {
        illusioneExp += quantita;
        while(illusioneExp>=getMaxIllusioneExp()){
            livelloAttualeIllusione++;
            if(expIllusioneA==false){
                expIllusioneA=true;
            }
        }
    }
    public void aggiungiincantoExp(int quantita) {
        incantoExp += quantita;
        while(incantoExp >= getMaxIncantoExp()){
            livelloAttualeIncanto++;
            if(expIncantesimoA==false){
                expIncantesimoA=true;
            }
        }
    }
    
    
    
    // --- Metodi per gestire i ricercatori assegnati alle diverse scuole ---
    
    // Getter per i ricercatori assegnati
    public int getRicercatoriEvocazione() {
        return ricercatoriEvocazione;
    }
    public int getRicercatoriIncanto() {
        return ricercatoriIncanto;
    }
    public int getRicercatoriIllusione() {
        return ricercatoriIllusione;
    }
    
    // Calcola quanti ricercatori sono liberi (non assegnati)
    public int getRicercatoriDisponibili() {
        return Ricercatore - (ricercatoriEvocazione + ricercatoriIncanto + ricercatoriIllusione);
    }
    public int getApprendistiDisponibili(){
        return apprendisti - (apprendistiPietra + apprendistiAcqua + apprendistiRoccia + apprendistiAcquaII+ apprendistiMineraliFerro + apprendistiMasso + apprendistiAcquaIII + apprendistiSbarraFerro + apprendistiGettiMana + apprendistiDepositoLegno + apprendistiGeyserMana + apprendistiMagia + apprendistiFuoco + apprendistiBolle + apprendistiVento);
    }
    
    // Metodi per aggiungere/rimuovere ricercatori nelle singole scuole
    public void aggiungiRicercatoreEvocazione() {
        if (getRicercatoriDisponibili() > 0) {
            ricercatoriEvocazione++;
            avviThreadEvocazione();
        }
    }
    public void rimuoviRicercatoreEvocazione() {
        if (ricercatoriEvocazione > 0) {
            ricercatoriEvocazione--;
            avviThreadEvocazione();
        }else{
            fermaThreadEvocazione();
        }
        
    }
    public void aggiungiRicercatoreIncanto() {
        if (getRicercatoriDisponibili() > 0) {
            ricercatoriIncanto++;
            avviThreadIncantesimo();
        }
    }
    public void rimuoviRicercatoreIncanto() {
        if (ricercatoriIncanto > 0) {
            ricercatoriIncanto--;
            avviThreadIncantesimo();
        }else{
            fermaThreadIncantesimo();
        }
    }
    public void aggiungiRicercatoreIllusione() {
        if (getRicercatoriDisponibili() > 0) {
            ricercatoriIllusione++;
            avviThreadIllusione();
        }
    }
    public void rimuoviRicercatoreIllusione() {
        if (ricercatoriIllusione > 0) {
            ricercatoriIllusione--;
            avviThreadIllusione();
        }else{
            fermaThreadIllusione();
            
        }
    }
    // Metodi per Aggiungere/rimuovere Apprendista
    public void aggiungereApprendistaPietra(){
        if(getApprendistiDisponibili()>0){
            apprendistiPietra++;
            if(runPietra!=true){
                runPietra=true;
                avviaPietra();
        }
    }
    }
    public void rimuovereApprendistaPietra(){
        if(apprendistiPietra>0){
            apprendistiPietra--;
            if(apprendistiPietra==0){
                runPietra=false;
            }
    }
    }
    public void aggiungereApprendistaAcqua(){
        if(getApprendistiDisponibili()>0){
            apprendistiAcqua++;
            if(runAcqua!=true){
            runAcqua=true;
            avviaAcqua();
        }
    }
    }
    public void rimuovereApprendistaAcqua(){
        if(apprendistiAcqua>0){
            apprendistiAcqua--;
            if(apprendistiAcqua==0){
                runAcqua=false;
            }
    }
    }
    public void aggiungereApprendistaRoccia(){
        if(getApprendistiDisponibili()>0){
            apprendistiRoccia++;
            if(runRoccia!=true){
                runRoccia=true;
                avviaRoccia();
        }
        }
    }
    public void rimuovereApprendistaRoccia(){
        if(apprendistiRoccia>0){
            apprendistiRoccia--;
            if(apprendistiRoccia==0){
                runRoccia=false;
            }
    }
    }
    public void aggiungereApprendistaIncantoMana(){
        if(getApprendistiDisponibili()>0){
            apprendistiGettiMana++;
            if(runIncantoMana!=true){
                runIncantoMana=true;
                AvviaIncantesimoMana();
            }
        }
    }
    public void rimuovereApprendistaIncantoMana(){
        if(apprendistiGettiMana>0){
            apprendistiGettiMana--;
            if(apprendistiGettiMana==0){
                runIncantoMana=false;
            }
        }
    }
    public void aggiungereApprendistaAcquaII(){
        if(getApprendistiDisponibili()>0){
            apprendistiAcquaII++;
            if(runAcquaII!=true){
                runAcquaII=true;
                AvviaAcquaII();
            }
        }
    }
    public void rimuovereApprendistaAcquaII(){
        if(apprendistiAcquaII>0){
            apprendistiAcquaII--;
            if(apprendistiAcquaII==0){
                runAcquaII=false;
            }
        }
    }
    public void aggiungereApprendistaSpettacoloMagia(){
        if(getApprendistiDisponibili()>0){
            apprendistiMagia++;
            if(runSpettacoloMagia!=true){
                runSpettacoloMagia=true;
                avviSpettacoloMagia();
            }
        }
    }
    public void rimuovereApprendistaSpettacoloMagia(){
        if(apprendistiMagia>0){
            apprendistiMagia--;
            if(apprendistiMagia==0){
                runSpettacoloMagia=false;
            }
        }
    }
    public void aggiungereApprendistaMineraleFerro(){
        if(getApprendistiDisponibili()>0){
            apprendistiMineraliFerro++;
            if(runMineraleFerro!=true){
                runMineraleFerro=true;
                avviMineraleFerro();
            }
        }
    }
    public void rimuovereApprendistaMineraleFerro(){
        if(apprendistiMineraliFerro>0){
            apprendistiMineraliFerro--;
            if(apprendistiMineraliFerro==0){
                runMineraleFerro=false;
            }
        }
    }
    public void aggiungereApprendistaMasso(){
        if(getApprendistiDisponibili()>0){
            apprendistiMasso++;
            if(runMasso!=true){
                runMasso=true;
                avviMasso();
            }
        }
    }
    public void rimuovereApprendistaMasso(){
        if(apprendistiMasso>0){
            apprendistiMasso--;
            if(apprendistiMasso==0){
                runMasso=false;
            }
        }
    }
    public void aggiungereApprendistaAcquaIII(){
        if(getApprendistiDisponibili()>0){
            apprendistiAcquaIII++;
            if(runAcquaIII!=true){
                runAcquaIII=true;
                avviAcquaIII();
            }
        }
    }
    public void rimuovereApprendistaAcquaIII(){
        if(apprendistiAcquaIII>0){
            apprendistiAcquaIII--;
            if(apprendistiAcquaIII==0){
                runAcquaIII=false;
            }
        }
    }
    public void aggiungereApprendistaSbarraFerro(){
        if(getApprendistiDisponibili()>0){
            apprendistiSbarraFerro++;
            if(runBarreFerro!=true){
                runBarreFerro=true;
                avviBarreFerro();
            }
        }
    }
    public void rimuovereApprendistaSbarraFerro(){
        if(apprendistiSbarraFerro>0){
            apprendistiSbarraFerro--;
            if(apprendistiSbarraFerro==0){
                runBarreFerro=false;
            }
        }
    }
    public void aggiungereApprendistaIncantoDepositi(){
        if(getApprendistiDisponibili()>0){
            apprendistiDepositoLegno++;
            if(runDepositiLegno!=true){
                runDepositiLegno=true;
                avviDepositiLegno();
            }
        }
    }
    public void rimuovereApprendistaIncantoDepositi(){
        if(apprendistiDepositoLegno>0){
            apprendistiDepositoLegno--;
            if(apprendistiDepositoLegno==0){
                runDepositiLegno=false;
            }
        }
    }
    public void aggiungereApprendistaGeyserIncanto(){
        if(getApprendistiDisponibili()>0){
            apprendistiGeyserMana++;
            if(runGeyserIncanto!=true){
                runGeyserIncanto=true;
                avviGeyserIncanto();
            }
        }
    }
    public void rimuovereApprendistaGeyserIncanto(){
        if(apprendistiGeyserMana>0){
            apprendistiGeyserMana--;
            if(apprendistiGeyserMana==0){
                runGeyserIncanto=false;
            }
        }
    }
    public void aggiungereApprendistaVento(){
        if(getApprendistiDisponibili()>0){
            apprendistiVento++;
            if(runSpettacoloVento!=true){
                runSpettacoloVento=true;
                avviSpettacoloVento();
            }
        }
    }
    public void rimuovereApprendistaVento(){
        if(apprendistiVento>0){
            apprendistiVento--;
            if(apprendistiVento==0){
                runSpettacoloVento=false;
            }
        }
    }
    public void aggiungereApprendistaBolle(){
        if(getApprendistiDisponibili()>0){
            apprendistiBolle++;
            if(runSpettacoloBolle!=true){
                runSpettacoloBolle=true;
                avviSpettacoloBolle();
            }
        }
    }
    public void rimuovereApprendistaBolle(){
        if(apprendistiBolle>0){
            apprendistiBolle--;
            if(apprendistiBolle==0){
                runSpettacoloBolle=false;
            }
        }
    }
    public void aggiungereApprendistaFuoco(){
        if(getApprendistiDisponibili()>0){
            apprendistiFuoco++;
            if(runSpettacoloFuoco!=true){
                runSpettacoloFuoco=true;
                avviSpettacoloFuoco();
            }
        }
    }
    public void rimuovereApprendistaFuoco(){
        if(apprendistiFuoco>0){
            apprendistiFuoco--;
            if(apprendistiFuoco==0){
                runSpettacoloFuoco=false;
            }
        }
    }
    // Casual building
    public void casualBuilding() {
        boolean run = true;
        while (run) {
            int v = r.nextInt(10); 
            switch (v) {
                case 0:
                    if (pietra >= getRisorsaNecesariaSilosPietra() && acqua >= getRisorsaNecesariaSilosAcqua() && silos > 0) {
                    costruisciSilos();
                    System.out.println("silos");
                    run = false;
                    }
                    break;
                case 1:
                    if (monete >= getRisorsaNecesariaFrammentoMana() && manaShard > 0) {
                    compraManaShard();
                    System.out.println("manaShard");
                    run = false;
                    }
                    break;
                case 2:
                    if (monete >= getRisorsaNecessariaMoneteGeyser() && acqua >= getRisorsaNecessariaAcquaGeyser() &&
                    ferro >= getRisorsaNecessariaFerroGeyser() && Geyser > 0) {
                    compraGeyser();
                    System.out.println("Geyser");
                    run = false;
                    }
                    break;
                case 3:
                    if (mana >= 200 && legno >= getRisorsaNecessariaLegnoLegname() &&
                    pietra >= getRisorsaNecessariaPietraLegname() && depositoLegname > 0) {
                    costruisciDepositoLegname();
                    System.out.println("Legname");
                    run = false;
                    }
                    break;
                case 4:
                    if (monete >= getRisorsaNecessariaMoneteForno() && pietra >= getRisorsaNecessariaPietraForno() &&
                    ferro >= getRisorsaNecessariaFerroForno() && forno > 0) {
                    compraForno();
                    System.out.println("Forno");
                    run = false;
                    }
                    break;
                case 5:
                    if (monete >= getRisorsaNecessariaMoneteMagazzino() && pietra >= getRisorsaNecessariaPietraMagazzino() &&
                    magazzino > 0) {
                    compraMagazzino();
                    System.out.println("Magazzino");
                    run = false;
                    }
                    break;
                case 6:
                    if (monete >= getRisorsaNecessariaMoneteSerbatoioAcqua() &&
                    legno >= getRisorsaNecessariaLegnoSerbatoioAcqua() &&
                    pietra >= getRisorsaNecessariaPietraSerbatoioAcqua() && SerbatoioAcqua > 0) {
                    compraSerbatoioA();
                    System.out.println("serbatoio");
                    run = false;
                    }
                    break;
            case 7:
                if (monete >= getRisorsaNecessariaMoneteVault() && pietra >= getRisorsaNecessariaPietraVault() &&
                    caveau > 0) {
                    compraCaveau();
                    System.out.println("caveau");
                    run = false;
                }
                break;
            case 8:
                if (monete >= getRisorsaNecessariaMoneteCabinaR() && legno >= getRisorsaNecessariaLegnoCabinaR() &&
                    pietra >= getRisorsaNecessariaPietraCabinaR() && CapacitàRicercatore > 0) {
                    compraCapacitàRicercatore();
                    System.out.println("ricercatore");
                    run = false;
                }
                break;
            case 9:
                if (monete >= getRisorsaNecessariaMoneteApprendista() && legno >= getRisorsaNecessariaLegnoApprendista() &&
                    pietra >= getRisorsanecessariaPietraApprendista() && apprendisti > 0) {
                    compraApprendista();
                    System.out.println("apprendista");
                    run = false;
                }
                break;
        }
    }
}

    // --- Getter per i flag di visibilità, per la GUI ---
    
    public boolean isTimeVisibile() {
        return timeVisibile;
    }
    public boolean isLegnoVisibile() {
        return legnoVisibile;
    }
    public boolean isFiammaVisibile(){
        return fiammaVisibile;
    }
    public boolean isFerroVisibile() {
        return ferroVisibile;
    }
    public boolean isMoneteVisibile() {
        return moneteVisibile;
    }
    public boolean isAcquaVisibile() {
        return acquaVisibile;
    }
    public boolean isPietraVisibile() {
        return pietraVisibile;
    }
    public boolean isManaVisibile() {
        return manaVisibile;
    }
    public void avviaPietra() {
        Thread threadPietra = new Thread(() -> {
            while (runPietra) {
                try {
                    long tempoAttesa = getCalcoloTempoPietra() * 1000L;
                    Thread.sleep(tempoAttesa);
                    if(mana>= (0.16 * apprendistiPietra) * getCalcoloTempoPietra()){
                        pietra = Math.min(pietra + 5, getMaxPietra());
                        mana-= (0.16 * apprendistiPietra) * getCalcoloTempoPietra();                       
                    }

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        threadPietra.start();
    }
     public void avviaAcqua() {
        Thread threadAcqua= new Thread(() -> {
            while (runAcqua) {
                try {
                    long tempoAttesa = getCalcoloTempoAcqua() * 1000L;
                    Thread.sleep(tempoAttesa);
                    if(mana>=(0.33*apprendistiAcqua)*getCalcoloTempoAcqua()){
                        acqua = Math.min(acqua + 2, getMaxAcqua());
                        mana-=(0.33*apprendistiAcqua)*getCalcoloTempoAcqua();                       
                    }

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        threadAcqua.start();
    }
      public void avviaRoccia() {
        Thread threadRoccia= new Thread(() -> {
            while (runRoccia) {
                try {
                    long tempoAttesa = getCalcoloTempoRoccia() * 1000L;
                    Thread.sleep(tempoAttesa);
                    if(mana>=(1.33*apprendistiRoccia)*getCalcoloTempoRoccia()){
                        pietra = Math.min(pietra + 90, getMaxPietra());
                        mana-=(1.33*apprendistiRoccia)*getCalcoloTempoRoccia();                      
                    }

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        threadRoccia.start();
    }
     public void AvviaIncantesimoMana() {
        Thread threadMana = new Thread(() -> {
            while (runIncantoMana) {
                try {
                    long tempoAttesa = getCalcoloTempoIncantiMana() * 1000L;
                    Thread.sleep(tempoAttesa);
                    if(mana>=(1.33*apprendistiGettiMana)*getCalcoloTempoIncantiMana()){
                       mana-=(1.33*apprendistiGettiMana)*getCalcoloTempoIncantiMana();
                        avviManaIncantesimo();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        threadMana.start();
    }
     public void AvviaAcquaII() {
        Thread AvviaAcquaII = new Thread(() -> {
            while (runAcquaII) {
                try {
                    long tempoAttesa = getCalcoloTempoAcquaII() * 1000L;
                    Thread.sleep(tempoAttesa);
                    if(mana>=(3*apprendistiAcquaII)*getCalcoloTempoAcquaII()){
                        mana-=(3*apprendistiAcquaII)*getCalcoloTempoAcquaII();
                        acqua = Math.min(acqua + 35, getMaxAcqua());
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        AvviaAcquaII.start();
    }
     public void avviSpettacoloMagia() {
        Thread avviSpettacoloMagia = new Thread(() -> {
            while (runSpettacoloMagia) {
                try {
                    long tempoAttesa = getCalcoloTempoSpettacoloMagia() * 1000L;
                    Thread.sleep(tempoAttesa);
                    if(mana>=(0.5*apprendistiMagia)*getCalcoloTempoSpettacoloMagia()){
                        mana-=(0.5*apprendistiMagia)*getCalcoloTempoSpettacoloMagia();
                        monete = Math.min(monete + r.nextInt(7) + 30, getMaxMonete());
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        avviSpettacoloMagia.start();
    }
     public void avviMineraleFerro() {
        Thread avviMineraleFerro = new Thread(() -> {
            while (runMineraleFerro) {
                try {
                    long tempoAttesa = getCalcoloTempoMineraliFerro() * 1000L;
                    Thread.sleep(tempoAttesa);
                    if(mana>=(0.66*apprendistiMineraliFerro)*getCalcoloTempoMineraliFerro()){
                        mana-=(0.66*apprendistiMineraliFerro)*getCalcoloTempoMineraliFerro();
                        ferro = Math.min(ferro + 5.0, getMaxFerro());
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        avviMineraleFerro.start();
    }
     public void avviMasso() {
        Thread avviMasso = new Thread(() -> {
            while (runMasso) {
                try {
                    long tempoAttesa = getCalcoloTempoMasso() * 1000L;
                    Thread.sleep(tempoAttesa);
                    if(mana>=(7.33*apprendistiMasso)*getCalcoloTempoMasso()){
                        mana-=(7.33*apprendistiMasso)*getCalcoloTempoMasso();
                        pietra = Math.min(pietra + 1200, getMaxPietra());
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        avviMasso.start();
    }
     public void avviAcquaIII() {
        Thread avviAcquaIII = new Thread(() -> {
            while (runAcquaIII) {
                try {
                    long tempoAttesa = getCalcoloTempoAcquaIII() * 1000L;
                    Thread.sleep(tempoAttesa);
                    if(mana>=(17.06*apprendistiAcquaIII)*getCalcoloTempoAcquaIII()){
                        mana-=(17.06*apprendistiAcquaIII)*getCalcoloTempoAcquaIII();
                        acqua = Math.min(acqua + 420, getMaxAcqua());
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        avviAcquaIII.start();
    }
     public void avviBarreFerro() {
        Thread avviBarreFerro = new Thread(() -> {
            while (runBarreFerro) {
                try {
                    long tempoAttesa = getCalcoloTempoBarreFerro() * 1000L;
                    Thread.sleep(tempoAttesa);
                    if(mana>=(5.33*apprendistiSbarraFerro)*getCalcoloTempoBarreFerro()){
                        mana-=(5.33*apprendistiSbarraFerro)*getCalcoloTempoBarreFerro();
                        ferro = Math.min(ferro + 80, getMaxFerro());
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        avviBarreFerro.start();
    }
     public void avviDepositiLegno() {
        Thread avviDepositiLegno = new Thread(() -> {
            while (runDepositiLegno) {
                try {
                    long tempoAttesa = getCalcoloTempoDepositiLegno() * 1000L;
                    Thread.sleep(tempoAttesa);
                    if(mana>=(1.33*apprendistiDepositoLegno)*getCalcoloTempoDepositiLegno()){
                        mana-=(1.33*apprendistiDepositoLegno)*getCalcoloTempoDepositiLegno();
                        IncantiDepositiLegname();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        avviDepositiLegno.start();
    }
     public void avviGeyserIncanto() {
        Thread avviGeyserIncanto = new Thread(() -> {
            while (runGeyserIncanto) {
                try {
                    long tempoAttesa = getCalcoloTempoGeyser() * 1000L;
                    Thread.sleep(tempoAttesa);
                    if(mana>=(2.66*apprendistiGeyserMana)*getCalcoloTempoGeyser()){
                        mana-=(2.66*apprendistiGeyserMana)*getCalcoloTempoGeyser();
                        IncantiGettiManaAttiva();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        avviGeyserIncanto.start();
    }
     public void avviSpettacoloVento() {
        Thread avviSpettacoloVento = new Thread(() -> {
            while (runSpettacoloVento) {
                try {
                    long tempoAttesa = getCalcoloTempoSpettacoloVento() * 1000L;
                    Thread.sleep(tempoAttesa);
                    if(mana>=(1.16*apprendistiVento)*getCalcoloTempoSpettacoloVento()){
                        mana-=(1.16*apprendistiVento)*getCalcoloTempoSpettacoloVento();
                         monete = Math.min(monete + r.nextInt(51) + 100, getMaxMonete());
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        avviSpettacoloVento.start();
    }
     public void avviSpettacoloBolle() {
        Thread avviSpettacoloBolle = new Thread(() -> {
            while (runSpettacoloBolle) {
                try {
                    long tempoAttesa = getCalcoloTempoSpettacoloBolle() * 1000L;
                    Thread.sleep(tempoAttesa);
                    if(mana>=(2.50*apprendistiBolle)*getCalcoloTempoSpettacoloBolle()){
                        mana-=(2.50*apprendistiBolle)*getCalcoloTempoSpettacoloBolle();
                        monete = Math.min(monete + r.nextInt(101) + 350, getMaxMonete());
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        avviSpettacoloBolle.start();
    }
     public void avviSpettacoloFuoco() {
        Thread avviSpettacoloFuoco = new Thread(() -> {
            while (runSpettacoloFuoco) {
                try {
                    long tempoAttesa = getCalcoloTempoSpettacoloFuoco() * 1000L;
                    Thread.sleep(tempoAttesa);
                    if(mana>=(2.50*apprendistiFuoco)*getCalcoloTempoSpettacoloFuoco()){
                        mana-=(2.50*apprendistiFuoco)*getCalcoloTempoSpettacoloFuoco();
                        monete = Math.min(monete + r.nextInt(801) + 2000, getMaxMonete());
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        avviSpettacoloFuoco.start();
    }
     
     
     
     
     
     
     
     
     
 private void readObject(java.io.ObjectInputStream in)
            throws java.io.IOException, ClassNotFoundException {
        in.defaultReadObject();

        if (this.objectivesManager == null) {
            // se non esiste (es. salvataggio molto vecchio)
            this.objectivesManager = new ObjectivesManager();
        } else {
            // conserva currentIndex salvato, ma ricarica la lista
            this.objectivesManager.setObjectives(
                ObjectiveFactory.createAllObjectives()
            );
        }
    }
}

