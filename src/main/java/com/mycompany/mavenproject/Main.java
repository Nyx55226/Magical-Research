
package com.mycompany.mavenproject;
import com.github.weisj.darklaf.LafManager;
import com.github.weisj.darklaf.theme.*;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.plaf.basic.BasicProgressBarUI;




public class Main extends javax.swing.JFrame {
    private Game gioco = new Game();
    private boolean Swichcolormanual=false;
    private boolean incantesimoManaAttivo = false;
    private boolean incantesimoGeyserAttivo=false;
    private boolean incantesimoLegnoAttivo=false;
    private int incantesimoCounterLegno=0;
    private int incantesimoCounterMana = 0;
    private int incantesimoCountergeyser=0;
    private boolean VisibilitàNegozio=true;
    private boolean allExpand=false;
    private final java.util.Set<String> processedUnlocks = new java.util.HashSet<>();
    private String modeSelected;
    private int ciclo=0;
    private String itemSelected;
    private List<JButton>bottoniItem;
    private int bottoneSelected;
    private int OggettoSelezionatoCreazione;
    
    public void caricaEquipaggiamento(){
        if(!gioco.getDataGame().getMano().equals("")){
            Image image=costruisciPath(gioco.getDataGame().getMano()).getScaledInstance(72, 72, Image.SCALE_SMOOTH);
            jLabel249.setIcon(new ImageIcon(image));
            jLabel249.setName(gioco.getDataGame().getPosizioneMano());
            bottoniItem.get(Integer.parseInt(gioco.getDataGame().getPosizioneMano())-1).setEnabled(false);
            jLabel262.setText("Mano: "+gioco.getDataGame().getMano());
        }
        if(!gioco.getDataGame().getCorpo().equals("")){
            Image image=costruisciPath(gioco.getDataGame().getCorpo()).getScaledInstance(72, 72, Image.SCALE_SMOOTH);
            jLabel260.setIcon(new ImageIcon(image));
            jLabel260.setName(gioco.getDataGame().getPosizioneCorpo());
            bottoniItem.get(Integer.parseInt(gioco.getDataGame().getPosizioneCorpo())-1).setEnabled(false);
            jLabel263.setText("Corpo: "+gioco.getDataGame().getCorpo());
        }
        if(!gioco.getDataGame().getAccessorio().equals("")){
            Image image=costruisciPath(gioco.getDataGame().getAccessorio()).getScaledInstance(72, 72, Image.SCALE_SMOOTH);
            jLabel261.setIcon(new ImageIcon(image));
            jLabel261.setName(gioco.getDataGame().getPosizioneAccessorio());
            bottoniItem.get(Integer.parseInt(gioco.getDataGame().getPosizioneAccessorio())-1).setEnabled(false);
            jLabel264.setText("Accessorio: "+gioco.getDataGame().getAccessorio());
        }
    }
    public void caricaInventario(){
        List<String>oggetti=gioco.getDataGame().getInventario();
        for(int i=0;i<oggetti.size();i++){
            String id=oggetti.get(i);
            if(id!=""){
                Image image=costruisciPath(id);
                bottoniItem.get(i).setIcon(new ImageIcon(image));
                bottoniItem.get(i).setName(id);
            }
        }
        
    }
    public Image costruisciPath(String id){
        String path="/Img/"+id+".png";
        ImageIcon j=new ImageIcon(getClass().getResource(path));
        Image J=j.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
        return J;
    }
    

    ImageIcon ImmagineIcona=new ImageIcon(getClass().getResource("/Img/MagicalResearchIcona.png"));
    Image immagineIcona= ImmagineIcona.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
    //immagini
    ImageIcon iconaMana = new ImageIcon(getClass().getResource("/Img/mana.png"));
    Image iconamana=iconaMana.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
    ImageIcon iconaLegno = new ImageIcon(getClass().getResource("/Img/Wood.png"));
    Image iconalegno=iconaLegno.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
    ImageIcon iconaFerro = new ImageIcon(getClass().getResource("/Img/Ferro.png"));
    Image iconaferro=iconaFerro.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
    ImageIcon iconaPietra = new ImageIcon(getClass().getResource("/Img/Pietra.png"));
    Image iconapietra=iconaPietra.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
    ImageIcon iconaAcqua = new ImageIcon(getClass().getResource("/Img/Acqua2.png"));
    Image iconaacqua=iconaAcqua.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
    ImageIcon iconaMonete = new ImageIcon(getClass().getResource("/Img/Monete.png"));
    Image iconamonete=iconaMonete.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
    ImageIcon Temperatura= new ImageIcon(getClass().getResource("/Img/Temperatura.png"));
    Image temperatura= Temperatura.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
    ImageIcon Tempo=new ImageIcon(getClass().getResource("/Img/Time.png"));
    Image tempo=Tempo.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
    //Immagini item
    ImageIcon Chest= new ImageIcon(getClass().getResource("/Img/chest.jpg"));
    Image chest=Chest.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
    
    ImageIcon Branch= new ImageIcon(getClass().getResource("/Img/Ramo.png"));
    Image branch=Branch.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
    
    ImageIcon Cloak= new ImageIcon(getClass().getResource("/Img/Mantello.png"));
    Image cloak=Cloak.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
    Image cloakrisorsa=Cloak.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
    
    ImageIcon ClothIcon = new ImageIcon(getClass().getResource("/Img/Cloth.jpg"));
    Image cloth = ClothIcon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
    Image clothrisorsa = ClothIcon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);

    ImageIcon ClothShoesIcon = new ImageIcon(getClass().getResource("/Img/Scarpe di Stoffa.png"));
    Image clothShoes = ClothShoesIcon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);

    ImageIcon ClubIcon = new ImageIcon(getClass().getResource("/Img/Mazza.png"));
    Image club = ClubIcon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);

    ImageIcon CrystallizedManaIcon = new ImageIcon(getClass().getResource("/Img/CrystallizedMana.png"));
    Image crystallizedMana = CrystallizedManaIcon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);

    ImageIcon DaggerIcon = new ImageIcon(getClass().getResource("/Img/Pugnale.png"));
    Image dagger = DaggerIcon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);

    ImageIcon ElderWizardRobeIcon = new ImageIcon(getClass().getResource("/Img/Mantello Incantato.jpg"));
    Image elderWizardRobe = ElderWizardRobeIcon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);

    ImageIcon EnchantedCloakIcon = new ImageIcon(getClass().getResource("/Img/Tunica del Mago.png"));
    Image enchantedCloak = EnchantedCloakIcon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);

    ImageIcon HandAxeIcon = new ImageIcon(getClass().getResource("/Img/Ascia a una Mano.png"));
    Image handAxe = HandAxeIcon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);

    ImageIcon IronMailIcon = new ImageIcon(getClass().getResource("/Img/Maglia di Ferro.png"));
    Image ironMail = IronMailIcon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);

    ImageIcon SickleIcon = new ImageIcon(getClass().getResource("/Img/Falce.png"));
    Image sickle = SickleIcon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);

    ImageIcon SwordIcon = new ImageIcon(getClass().getResource("/Img/Spada.png"));
    Image sword = SwordIcon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);

    ImageIcon ThiefGarbIcon = new ImageIcon(getClass().getResource("/Img/Abito da Ladro.jpg"));
    Image thiefGarb = ThiefGarbIcon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);

    ImageIcon WoodenSandalsIcon = new ImageIcon(getClass().getResource("/Img/Sandali di Legno.png"));
    Image woodenSandals = WoodenSandalsIcon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);

    ImageIcon Firewand= new ImageIcon(getClass().getResource("/Img/Staffa di Fuoco.jpg"));
    Image firewand= Firewand.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
    
    ImageIcon Wool=new ImageIcon(getClass().getResource("/Img/wool.png"));
    Image wool=Wool.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
    
    ImageIcon FireSpeck= new ImageIcon(getClass().getResource("/Img/FireSpeck.jpg"));
    Image firespeck=FireSpeck.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
    
    //icone sezioni
    ImageIcon Campus=new ImageIcon(getClass().getResource("/Img/Campus.png"));
    Image campus=Campus.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    
    ImageIcon Apprendisti=new ImageIcon(getClass().getResource("/Img/Apprendisti.png"));
    Image apprendisti=Apprendisti.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    
    ImageIcon Aiuto=new ImageIcon(getClass().getResource("/Img/Aiuto.png"));
    Image aiuto=Aiuto.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    
    ImageIcon Informazioni=new ImageIcon(getClass().getResource("/Img/Informazioni.png"));
    Image informazioni=Informazioni.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    
    ImageIcon Impostazioni=new ImageIcon(getClass().getResource("/Img/Impostazioni.png"));
    Image impostazioni=Impostazioni.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    
    ImageIcon Penzione=new ImageIcon(getClass().getResource("/Img/Penzionamento.png"));
    Image penzione=Penzione.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    
    ImageIcon Ricerca=new ImageIcon(getClass().getResource("/Img/Ricerca.png"));
    Image ricerca=Ricerca.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    
    ImageIcon Inventario=new ImageIcon(getClass().getResource("/Img/Inventario.png"));
    Image inventario=Inventario.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    
    public Main() {
        initComponents();
        setLocationRelativeTo(null);
        applyLightTheme();
        updateGUI();
        HomePage.add(PanelloFisso,BorderLayout.SOUTH);
        setProgressBarTextColor(barra, Color.WHITE);
        bottoniItem = Arrays.asList(
                jButton136,jButton137,jButton138,jButton139,jButton140,jButton141,
                jButton142,jButton143,jButton144,jButton145,jButton146,jButton147,
                jButton148,jButton149,jButton151,jButton152,jButton153,jButton154
        );
        GameI();
    }
    private void LivelliUpdateGUI(){
        jButton18.setVisible(gioco.getDataGame().getSilos()>0);
        jButton19.setVisible(gioco.getDataGame().getSilos()>0);
        //Roccia
        jButton37.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=3);
        jButton39.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=3);
        jLabel61.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=3);
        jLabel110.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=3);
        jButton22.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=3);
        jButton63.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=3);
        //Acqua 2
        jLabel62.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=3);
        jLabel111.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=3);
        jButton23.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=3);
        jButton64.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=3);
        jButton40.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=3);
        jButton41.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=3);
        //Minerali di ferro
        RaccogliFerro.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=5);
        jButton99.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=5);
        jLabel104.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=5);
        jLabel112.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=5);
        jButton24.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=5);
        jButton65.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=5);
        jButton46.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=5);
        jButton47.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=5);
        //Masso
        jLabel105.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=6);
        jLabel120.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=6);
        jButton44.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=6);
        jButton84.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=6);
        jButton48.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=6);
        jButton49.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=6);
        //acqua 3
        jLabel106.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=6);
        jLabel121.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=6);
        jButton45.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=6);
        jButton85.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=6);
        jButton51.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=6);
        jButton50.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=6);
        //Barre Ferro
        jLabel107.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=7);
        jLabel122.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=7);
        jButton60.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=7);
        jButton86.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=7);
        jButton52.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=7);
        jButton53.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=7);
        //Deposito legno incantesimo
        jLabel125.setVisible(gioco.getDataGame().getLivelloAttualeIncanto()>=2 && gioco.getDataGame().getDepositoLegno()>0);
        jLabel128.setVisible(gioco.getDataGame().getLivelloAttualeIncanto()>=2 && gioco.getDataGame().getDepositoLegno()>0);
        jButton92.setVisible(gioco.getDataGame().getLivelloAttualeIncanto()>=2 && gioco.getDataGame().getDepositoLegno()>0);
        jButton96.setVisible(gioco.getDataGame().getLivelloAttualeIncanto()>=2 && gioco.getDataGame().getDepositoLegno()>0);
        jButton68.setVisible(gioco.getDataGame().getLivelloAttualeIncanto()>=2 && gioco.getDataGame().getDepositoLegno()>0);
        jButton67.setVisible(gioco.getDataGame().getLivelloAttualeIncanto()>=2 && gioco.getDataGame().getDepositoLegno()>0);
        //Geyser di mana Incantesimo
        jLabel126.setVisible(gioco.getDataGame().getLivelloAttualeIncanto()>=8 && gioco.getDataGame().getGeyser()>0);
        jLabel129.setVisible(gioco.getDataGame().getLivelloAttualeIncanto()>=8 && gioco.getDataGame().getGeyser()>0);
        jButton93.setVisible(gioco.getDataGame().getLivelloAttualeIncanto()>=8 && gioco.getDataGame().getGeyser()>0);
        jButton98.setVisible(gioco.getDataGame().getLivelloAttualeIncanto()>=8 && gioco.getDataGame().getGeyser()>0);
        jButton66.setVisible(gioco.getDataGame().getLivelloAttualeIncanto()>=8 && gioco.getDataGame().getGeyser()>0);
        jButton69.setVisible(gioco.getDataGame().getLivelloAttualeIncanto()>=8 && gioco.getDataGame().getGeyser()>0);
        //Spettacolo vento
        jLabel132.setVisible(gioco.getDataGame().getLivelloAttualeIllusione()>=4);
        jLabel136.setVisible(gioco.getDataGame().getLivelloAttualeIllusione()>=4);
        jButton101.setVisible(gioco.getDataGame().getLivelloAttualeIllusione()>=4);
        jButton107.setVisible(gioco.getDataGame().getLivelloAttualeIllusione()>=4);
        jButton54.setVisible(gioco.getDataGame().getLivelloAttualeIllusione()>=4);
        jButton55.setVisible(gioco.getDataGame().getLivelloAttualeIllusione()>=4);
        // spettacolo bolle
        jLabel133.setVisible(gioco.getDataGame().getLivelloAttualeIllusione()>=7);
        jLabel137.setVisible(gioco.getDataGame().getLivelloAttualeIllusione()>=7);
        jButton103.setVisible(gioco.getDataGame().getLivelloAttualeIllusione()>=7);
        jButton108.setVisible(gioco.getDataGame().getLivelloAttualeIllusione()>=7);
        jButton56.setVisible(gioco.getDataGame().getLivelloAttualeIllusione()>=7);
        jButton57.setVisible(gioco.getDataGame().getLivelloAttualeIllusione()>=7);
        //spettacolo fuoco
        jLabel134.setVisible(gioco.getDataGame().getLivelloAttualeIllusione()>=8);
        jLabel192.setVisible(gioco.getDataGame().getLivelloAttualeIllusione()>=8);
        jButton105.setVisible(gioco.getDataGame().getLivelloAttualeIllusione()>=8);
        jButton110.setVisible(gioco.getDataGame().getLivelloAttualeIllusione()>=8);
        jButton59.setVisible(gioco.getDataGame().getLivelloAttualeIllusione()>=8);
        jButton58.setVisible(gioco.getDataGame().getLivelloAttualeIllusione()>=8);
        // bottone Pensionamento
        jButton42.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=3 || gioco.getDataGame().getLivelloAttualeIllusione()>=3 || gioco.getDataGame().getLivelloAttualeIncanto()>=3);
        // bottone Serbatoio acqua
        BottoneSerbatoio.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=4);
        jButton114.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=4);
        // bottone Geyser
        jButton106.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=6);
        BottoneGeyser.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=6);
        // Edificio Casuali
        jButton122.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=9);
        jButton123.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=9);
    }
    private void updateGUI() {
    dataGame dg = gioco.getDataGame();
    ObjectivesManager om = dg.getObjectivesManager();
    Objective justCompleted = om.updateAndConsume(dg);

    // obiettivo 2
    boolean unlocked2 = om.isFunctionalityUnlocked("2");
    BottoneSilos.setVisible(unlocked2);
    jLabel200.setVisible(unlocked2);
    BottoneMana.setVisible(unlocked2);
    jButton102.setVisible(unlocked2);
    if (unlocked2 && !processedUnlocks.contains("2")) {
        processedUnlocks.add("2");
        jPanel71.setVisible(true);
    }

    // obiettivo 3
    boolean unlocked3 = om.isFunctionalityUnlocked("3");
    BottoneShard.setVisible(unlocked3);
    jButton104.setVisible(unlocked3);

    //obiettivo 4
    boolean unlocked4 = om.isFunctionalityUnlocked("4");
    BottoneRicercatore.setVisible(unlocked4);

    // obiettivo 5
    boolean unlocked5 = om.isFunctionalityUnlocked("5");
    jButton38.setVisible(unlocked5);
    jLabel243.setVisible(unlocked5);
    BottoneTempo.setVisible(unlocked5);
    jButton119.setVisible(unlocked5);
    if (unlocked5 && !processedUnlocks.contains("5")) {
        processedUnlocks.add("5");
        jPanel81.setVisible(true);
    }
    if (unlocked5) {
        BottoneRicercatore.setVisible(false);
    }

    //obiettivo 6
    boolean unlocked6 = om.isFunctionalityUnlocked("6");
    jLabel222.setVisible(unlocked6);
    BottoneMagazzinaggio.setVisible(unlocked6);
    BottoneMagazzino.setVisible(unlocked6);
    jButton112.setVisible(unlocked6);
    if (unlocked6 && !processedUnlocks.contains("6")) {
        processedUnlocks.add("6");
        jPanel77.setVisible(true);
    }
    //obiettivo 8
    boolean unlocked8 = om.isFunctionalityUnlocked("8");
    RaccogliLegno.setVisible(unlocked8);
    jButton97.setVisible(unlocked8);
    jButton1.setVisible(unlocked8);
    jLabel27.setVisible(unlocked8);
    jLabel33.setVisible(unlocked8);
    jButton2.setVisible(unlocked8);
    if(unlocked8 && !processedUnlocks.contains("8")){
        processedUnlocks.add("8");
        jPanel9.setVisible(true);
        jPanel11.setVisible(true);
    }

    // obiettivo 9
    boolean unlocked9 = om.isFunctionalityUnlocked("9");
    jLabel213.setVisible(unlocked9);
    BottoneProduzione.setVisible(unlocked9);
    jButton7.setVisible(unlocked9);
    jButton117.setVisible(unlocked9);
    jButton8.setVisible(unlocked9);
    jButton109.setVisible(unlocked9);
    if (unlocked9 && !processedUnlocks.contains("9")) {
        processedUnlocks.add("9");
        jPanel75.setVisible(true);
    }

    // obiettivo 10
    boolean unlocked10 = om.isFunctionalityUnlocked("10");
    jButton9.setVisible(unlocked10);
    
    // Obiettivo 11: 
    boolean unlocked11= om.isFunctionalityUnlocked("11");
    BottoneCaveau.setVisible(unlocked11);
    jButton116.setVisible(unlocked11);
    
    //obiettivo 12
    boolean unlocked12= om.isFunctionalityUnlocked("12");
    jButton121.setVisible(unlocked12);
    jButton113.setVisible(unlocked12);
    jButton120.setVisible(unlocked12);
    
    // obiettivo 13
    boolean unlocked13= om.isFunctionalityUnlocked("13");
    jButton124.setVisible(unlocked13);
    jButton125.setVisible(unlocked13);
    jButton126.setVisible(unlocked13);
    if(unlocked13){
        jButton121.setVisible(false);
    }
    
    // Aggiorna descrizione obiettivo corrente
    Objective current = om.getCurrentObjective();
    if (current != null) {
        jLabel152.setText("<html><p>" + current.getDescription() + "</p></html>");
    } else {
        jLabel152.setText("Tutti gli obiettivi sono stati completati!");
    }

    // Popup per obiettivo completato
    if (justCompleted != null && !justCompleted.getPopupMessage().isEmpty()) {
        JOptionPane.showMessageDialog(this, justCompleted.getPopupMessage());
        timerMana.stop();
        timerLegno.stop();
        timerFerro.stop();
    }
}



    private void Panelli(){
    jPanel63.setVisible(false);
    jPanel50.setVisible(false);
    jPanel41.setVisible(false);
    jPanel28.setVisible(false);
    jPanel18.setVisible(false);
    jPanel11.setVisible(processedUnlocks.contains("8"));
    jPanel9.setVisible(processedUnlocks.contains("8"));
    jPanel75.setVisible(processedUnlocks.contains("9"));
    jPanel81.setVisible(processedUnlocks.contains("5"));
    jPanel17.setVisible(false);
    jPanel14.setVisible(false);
    jPanel13.setVisible(false);
    jPanel10.setVisible(false);
    jPanel58.setVisible(false);
    jPanel60.setVisible(false);
    jPanel68.setVisible(false);
    jPanel69.setVisible(false);
    jPanel70.setVisible(false);
    jPanel72.setVisible(false);
    jPanel73.setVisible(false);
    jPanel74.setVisible(false);
    jPanel76.setVisible(false);
    jPanel78.setVisible(false);
    jPanel79.setVisible(false);
    jPanel80.setVisible(false);
    jPanel82.setVisible(false);
    jPanel29.setVisible(false);
    jPanel30.setVisible(false);
    jPanel31.setVisible(false);
    jPanel32.setVisible(false);
    jPanel33.setVisible(false);
    jPanel34.setVisible(false);
    jPanel35.setVisible(false);
    jPanel54.setVisible(false);
    jPanel55.setVisible(false);
    jPanel56.setVisible(false);
    jPanel36.setVisible(false);
    jPanel37.setVisible(false);
    jPanel38.setVisible(false);
    jPanel20.setVisible(false);
    jPanel21.setVisible(false);
    jPanel39.setVisible(false);
    jPanel40.setVisible(false);
    jPanel42.setVisible(false);
    jPanel43.setVisible(false);
    jPanel44.setVisible(false);
    jPanel45.setVisible(false);
    jPanel25.setVisible(false);
    jPanel52.setVisible(false);
    jPanel53.setVisible(false);
    jPanel26.setVisible(false);
    jPanel46.setVisible(false);
    jPanel47.setVisible(false);
    jPanel48.setVisible(false);
    jPanel24.setVisible(false);
    jPanel27.setVisible(false);
}
    public void aggiornoButtoneCreaItem(){
    switch (OggettoSelezionatoCreazione) {
    case 1:
        jButton131.setEnabled(gioco.getDataGame().getMana() >= 750 && gioco.getDataGame().getLegno() >= 4500 && gioco.getDataGame().getFerro() >= 10);
        break;
    case 2:
        jButton131.setEnabled(gioco.getDataGame().getLegno() >= 300 && gioco.getDataGame().getMana() >= 1000);
        break;
    case 3:
        jButton131.setEnabled(gioco.getDataGame().getLegno() >= 900);
        break;
    case 4:
        jButton131.setEnabled(gioco.getDataGame().getFerro() >= 60 && gioco.getDataGame().getLegno() >= 40 && gioco.getDataGame().getFiamma() >= 300);
        break;
    case 5:
        jButton131.setEnabled(gioco.getDataGame().getFerro() >= 120 && gioco.getDataGame().getLegno() >= 200 && gioco.getDataGame().getFiamma() >= 600);
        break;
    case 6:
        jButton131.setEnabled(gioco.getDataGame().getFerro() >= 150 && gioco.getDataGame().getLegno() >= 300 && gioco.getDataGame().getFiamma() >= 600);
        break;
    case 7:
        jButton131.setEnabled(gioco.getDataGame().getLegno() >= 3000 && gioco.getDataGame().getMana() >= 2500 && gioco.getDataGame().getFireSpeak() >= 1);
        break;
    case 8:
        jButton131.setEnabled(gioco.getDataGame().getFerro() >= 1100 && gioco.getDataGame().getLegno() >= 3000 && gioco.getDataGame().getFiamma() >= 1500);
        break;
    case 9:
        jButton131.setEnabled(gioco.getDataGame().getFerro() >= 300 && gioco.getDataGame().getFiamma() >= 1200);
        break;
    case 10:
        jButton131.setEnabled(gioco.getDataGame().getMana() >= 1600 && gioco.getDataGame().getStoffa() >= 12);
        break;
    case 11:
        jButton131.setEnabled(gioco.getDataGame().getMana() >= 2000 && gioco.getDataGame().getFiamma() >= 1500 && gioco.getDataGame().getStoffa() >= 15);
        break;
    case 12:
        jButton131.setEnabled(gioco.getDataGame().getMana()>=1000);
        break;
    case 13:
        jButton131.setEnabled(gioco.getDataGame().getMana() >= 1000);
        break;
    case 14:
        jButton131.setEnabled(gioco.getDataGame().getStoffa() >= 4);
        break;
    case 15:
        jButton131.setEnabled(gioco.getDataGame().getStoffa() >= 8);
        break;
    case 16:
        jButton131.setEnabled(gioco.getDataGame().getMana() >= 2200 && gioco.getDataGame().getMantello() >= 1 && gioco.getDataGame().getStoffa() >= 4);
        break;
    case 17:
        jButton131.setEnabled(gioco.getDataGame().getLana() >= 4);
        break;
}

    }
    public void aggionoLabelCreaItem(){
        switch(OggettoSelezionatoCreazione){
            case 1:
                labelItem();
                jLabel257.setText(formatta(gioco.getDataGame().getMana())+"/750");
                jLabel258.setText(formatta(gioco.getDataGame().getLegno())+"/4500");
                jLabel259.setText(formatta(gioco.getDataGame().getFerro())+"/10");
                break;
            case 2:
                labelItem();
                jLabel257.setText(formatta(gioco.getDataGame().getLegno())+"/300");
                jLabel258.setText(formatta(gioco.getDataGame().getMana())+"/1000");
                jLabel259.setVisible(false);
                break;
            case 3:
                labelItem();
                jLabel257.setText(formatta(gioco.getDataGame().getLegno())+"/900");
                jLabel258.setVisible(false);
                jLabel259.setVisible(false);
                break;
            case 4:
                labelItem();
                jLabel257.setText(formatta(gioco.getDataGame().getFerro())+"/60");
                jLabel258.setText(formatta(gioco.getDataGame().getLegno())+"/40");
                jLabel259.setText(formatta(gioco.getDataGame().getFiamma())+"/300");
                break;
            case 5:
                labelItem();
                jLabel257.setText(formatta(gioco.getDataGame().getFerro())+"/120");
                jLabel258.setText(formatta(gioco.getDataGame().getLegno())+"/200");
                jLabel259.setText(formatta(gioco.getDataGame().getFiamma())+"/600");
                break;
            case 6:
                labelItem();
                jLabel257.setText(formatta(gioco.getDataGame().getFerro())+"/150");
                jLabel258.setText(formatta(gioco.getDataGame().getLegno())+"/300");
                jLabel259.setText(formatta(gioco.getDataGame().getFiamma())+"/600");
                break;
            case 7:
                labelItem();
                jLabel257.setText(formatta(gioco.getDataGame().getLegno())+"/3000");
                jLabel258.setText(formatta(gioco.getDataGame().getMana())+"/2500");
                jLabel259.setText(formatta(gioco.getDataGame().getFireSpeak())+"/1");
                break;
            case 8:
                labelItem();
               jLabel257.setText(formatta(gioco.getDataGame().getFerro())+"/1100");
                jLabel258.setText(formatta(gioco.getDataGame().getLegno())+"/3000");
                jLabel259.setText(formatta(gioco.getDataGame().getFiamma())+"/1500");
                break;
            case 9:
                labelItem();
                jLabel257.setText(formatta(gioco.getDataGame().getFerro())+"/300");
                jLabel258.setText(formatta(gioco.getDataGame().getFiamma())+"/1200");
                jLabel259.setVisible(false);
                break;
            case 10:
                labelItem();
                jLabel257.setText(formatta(gioco.getDataGame().getMana())+"/1600");
                 jLabel258.setText(formatta(gioco.getDataGame().getStoffa())+"/12");
                jLabel259.setVisible(false);
                break;
            case 11:
                labelItem();
               jLabel257.setText(formatta(gioco.getDataGame().getMana())+"/2000");
                jLabel258.setText(formatta(gioco.getDataGame().getFiamma())+"/1500");
                jLabel259.setText(formatta(gioco.getDataGame().getStoffa())+"/15");
                break;
            case 12:
                labelItem();
                jLabel257.setText(formatta(gioco.getDataGame().getMana())+"/1000");
                jLabel258.setVisible(false);
                jLabel259.setVisible(false);
                break;
            case 13:
                labelItem();
                 jLabel257.setText(formatta(gioco.getDataGame().getLegno())+"/750");
                jLabel258.setVisible(false);
                jLabel259.setVisible(false);
                break;
            case 14:
                labelItem();
                jLabel257.setText(formatta(gioco.getDataGame().getStoffa())+"/4");
                jLabel258.setVisible(false);
                jLabel259.setVisible(false);
                break;
            case 15:
                labelItem();
                jLabel257.setText(formatta(gioco.getDataGame().getStoffa())+"/8");
                jLabel258.setVisible(false);
                jLabel259.setVisible(false);
                break;
            case 16:
                labelItem();
                jLabel257.setText(formatta(gioco.getDataGame().getMana())+"/2200");
            jLabel258.setText(formatta(gioco.getDataGame().getMantello())+"/1");
            jLabel259.setText(formatta(gioco.getDataGame().getStoffa())+"/4");
            break;
            case 17:
                labelItem();
                jLabel257.setText(formatta(gioco.getDataGame().getLana())+"/4");
            jLabel258.setVisible(false);
            jLabel259.setVisible(false);
            break;
        
    }
        
    }
    public void caricamento(){
        if(gioco.getDataGame().getFornoAttivi()>0){
            int fiamma=(gioco.getDataGame().getFornoAttivi()*2)*600;
            gioco.getDataGame().aggiungiFiamma(fiamma);
        }
        int mana=(gioco.getDataGame().getSilos()+gioco.getDataGame().getGeyser())*600;
        gioco.getDataGame().aggiungiMana(mana);
        int legno=gioco.getDataGame().getDepositoLegno()*600;
        gioco.getDataGame().aggiungiLegno(legno);
        if(gioco.getDataGame().getRicercatoriEvocazione()>0){
            int livelloEvocazione=gioco.getDataGame().getRicercatoriEvocazione()*600;
            gioco.getDataGame().aggiungiIllusioneExp(livelloEvocazione);
        }
        if(gioco.getDataGame().getRicercatoriIllusione()>0){
            int livelloIllusione=gioco.getDataGame().getRicercatoriIllusione()*600;
            gioco.getDataGame().aggiungiIllusioneExp(livelloIllusione);
        }
        if(gioco.getDataGame().getRicercatoriIncanto()>0){
            int livelloIncanto=gioco.getDataGame().getRicercatoriIncanto()*600;
            gioco.getDataGame().aggiungiincantoExp(livelloIncanto);
        }
        ((CardLayout)this.getContentPane().getLayout()).show(this.getContentPane(),"CardGioco");

    }
    public void AperturaFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleziona file di salvataggio");
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Salvataggi (*.txt)", "txt"));
        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            JOptionPane.showMessageDialog(this, "Hai selezionato: " + selectedFile.getAbsolutePath());
            // Copia il file selezionato in "salvataggio.txt"
            File dest = new File("salvataggio.txt");
            try {
                copyFile(selectedFile, dest);
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Errore nella copia del file di salvataggio.");
                return;
            }
            // Ricarica i dati dal file e aggiorna il gioco
            dataGame loadedGame = dataGame.caricaDaFile("salvataggio.txt");
            if (loadedGame != null) {
                gioco = new Game(loadedGame);
                PanelloFisso.setVisible(true);
                ((CardLayout)PanelloFisso.getLayout()).show(PanelloFisso, "card4");
                GameI();
                JOptionPane.showMessageDialog(this, "Dati caricati correttamente!");
            } else {
                JOptionPane.showMessageDialog(this, "Errore nel caricamento della partita.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selezione annullata.");
        }
    }
    public void GameI() {
        dataGame temp = dataGame.caricaDaFile("salvataggio.txt");
        if (temp.getScuola() == null || temp.getScuola().isEmpty()) {
            ((CardLayout) this.getContentPane().getLayout()).show(this.getContentPane(), "CardIntro");
            Setintro();
            SetGioco();
        } else {
            ((CardLayout) this.getContentPane().getLayout()).show(this.getContentPane(), "CardGioco");
            jLabelScuolaE.setText(gioco.getDataGame().getScuola()+" - "+gioco.getDataGame().getElemento());
            if(gioco.getDataGame().getModalitàScura()==true){
                applyDarkTheme();
                jCheckBox1.setSelected(true);
            }else{
                applyLightTheme();
            }
            gioco.getDataGame().orarioApertura();
            if(gioco.getDataGame().getTime()<30000){
                gioco.getDataGame().aggiungiTime();
                SwingUtilities.invokeLater(()->{
                JOptionPane.showMessageDialog(null,"Bentornato in Magic Research! \n Hai ottenuto "+formatta(gioco.getDataGame().getSecondo())+"⏲ pezzi di tempo!","Progresso offline",JOptionPane.INFORMATION_MESSAGE);
           });
            }
            if(gioco.getDataGame().getSilos()!=0 || gioco.getDataGame().getGeyser()!=0){
                    gioco.getDataGame().restartProduction();
                    timer.start();
                } 
            if(gioco.getDataGame().getDepositoLegno()!=0){
                    gioco.getDataGame().restartProductionLegno();
                    timerAddLegno.start();
                } 
            gioco.getDataGame().restartThreadForno();
            gioco.getDataGame().restartThreadEvocazione();
            gioco.getDataGame().restartThreadIllusione();
            gioco.getDataGame().restartThreadIncantesimo();
            gioco.getDataGame().restartThreadForno();
            if(gioco.getDataGame().getApprendistiAcqua()!=0){
                gioco.getDataGame().avviaAcqua();
            }
            if(gioco.getDataGame().getApprendistiRoccia()!=0){
                gioco.getDataGame().avviaRoccia();
            }
            if(gioco.getDataGame().getApprendistiPietra()!=0){
                gioco.getDataGame().avviaPietra();
            }
            if(gioco.getDataGame().getApprendistiGettiMana()!=0){
                gioco.getDataGame().AvviaIncantesimoMana();
            }
            if(gioco.getDataGame().getApprendistiAcquaII()!=0){
                gioco.getDataGame().AvviaAcquaII();
            }
            if(gioco.getDataGame().getApprendistiAcquaIII()!=0){
                gioco.getDataGame().avviAcquaIII();
            }
            if(gioco.getDataGame().getApprendistiBolle()!=0){
                gioco.getDataGame().avviSpettacoloBolle();
            }
            if(gioco.getDataGame().getApprendistiDepositoLegno()!=0){
                gioco.getDataGame().avviDepositiLegno();
            }
            if(gioco.getDataGame().getApprendistiFuoco()!=0){
                gioco.getDataGame().avviSpettacoloFuoco();
            }
            if(gioco.getDataGame().getApprendistiGeyserMana()!=0){
                gioco.getDataGame().avviGeyserIncanto();
            }
            if(gioco.getDataGame().getApprendistiMagia()!=0){
                gioco.getDataGame().avviSpettacoloMagia();
            }
            if(gioco.getDataGame().getApprendistiMasso()!=0){
                gioco.getDataGame().avviMasso();
            }
            if(gioco.getDataGame().getApprendistiMineraliFerro()!=0){
                gioco.getDataGame().avviMineraleFerro();
            }
            if(gioco.getDataGame().getApprendistiSbarraFerro()!=0){
                gioco.getDataGame().avviBarreFerro();
            }
            if(gioco.getDataGame().getApprendistiVento()!=0){
                gioco.getDataGame().avviSpettacoloVento();
            }
            jPanel62.setVisible(gioco.getDataGame().getTime()>0);
            jLabel172.setVisible(gioco.getDataGame().getTime()>0);
            jButton82.setVisible(gioco.getDataGame().getTime()>0);
            settColors();
            SetGioco();
        }
    }
    private void applyLightTheme() {
        LafManager.install(new IntelliJTheme()); 
        resetComponentColors(this, false); 
        SwingUtilities.updateComponentTreeUI(this);
        repaint();
        settColors();
        setProgressBarTextColor(barra, Color.WHITE);
    }
    public String formatta(Number valore) {
        double numero = valore.doubleValue();
        if (numero >= 1000000000) {
            return String.format(numero % 1 == 0 ? "%.0fB" : "%.2fB", numero / 1000000000);
        } else if (numero >= 1000000) {
            return String.format(numero % 1 == 0 ? "%.0fM" : "%.2fM", numero / 1000000);
        } else if (numero >= 10000) {
            return String.format(numero % 1 == 0 ? "%.0fK" : "%.2fK", numero / 1000);
        } else {
            return numero % 1 == 0 ? String.format("%.0f", numero) : String.format("%.2f", numero);
        }
    }
    private void applyDarkTheme() {
        LafManager.install(new OneDarkTheme());
        resetComponentColors(this, true); 
        SwingUtilities.updateComponentTreeUI(this);
        settColors();
        repaint();
        setProgressBarTextColor(barra, Color.WHITE);
}
    private void resetComponentColors(Container container, boolean isDarkMode) {
    for (Component c : container.getComponents()) {
        if (c instanceof JPanel) {
            if (isDarkMode) {
                c.setBackground(null); 
            } else {
                c.setBackground(Color.WHITE); 
            }
        } else if (c instanceof JLabel) {
            if (isDarkMode) {
                c.setForeground(new Color(255,255,255));
                jLabel4.setForeground(Color.WHITE);
            } else {
                c.setForeground(Color.BLACK);
                jLabel4.setForeground(Color.WHITE);
            }
        }else if (c instanceof JButton) {
            if (isDarkMode) {
                c.setForeground(Color.WHITE);
                jComboBox1.setForeground(Color.WHITE);
                jComboBox2.setForeground(Color.WHITE);
                jComboBox3.setForeground(Color.WHITE);
            } else {
                c.setForeground(Color.BLACK); 
                jComboBox1.setForeground(Color.BLACK);
                jComboBox2.setForeground(Color.BLACK);
                jComboBox3.setForeground(Color.BLACK);
            }
        }
        if (c instanceof Container) {
            resetComponentColors((Container) c, isDarkMode);
        }
    }
}

    private void copyFile(File source, File dest) {
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(dest)) {
            byte[] buffer = new byte[4096];
            int len;
            while ((len = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
            System.out.println("File copiato correttamente in " + dest.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Errore nella copia del file: " + e.getMessage());
        }
    }
    public void setProgressBarTextColor(JProgressBar barra, Color colore) {
        barra.setUI(new BasicProgressBarUI() {
            @Override
            protected void paintString(Graphics g, int x, int y, int width, int height, int amountFull, Insets b) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(colore);
                String text = barra.getString();
                if (text != null) {
                    FontMetrics fm = g2.getFontMetrics();
                    int textX = (width - fm.stringWidth(text)) / 2;
                    int textY = (height + fm.getAscent() - fm.getDescent()) / 2;
                    g2.drawString(text, textX, textY);
                }
            }
        });
    }
    Timer timerPezziTempo=new Timer(1000,new ActionListener(){
       public void actionPerformed(ActionEvent e){
                gioco.getDataGame().spendiTempo();
                if(modeSelected.equals("2")){
                    if(gioco.getDataGame().getTime()<3){
                        jLabel184.setText("1x");
                        gioco.getDataGame().setVelocità("normale");
                        jLabel185.setVisible(false);
                        jLabel186.setVisible(false);
                        timerPezziTempo.stop();
                    }else{
                        
                    }
                }else if(modeSelected.equals("8")){
                    if(gioco.getDataGame().getTime()<4){
                        jLabel184.setText("1x");
                        gioco.getDataGame().setVelocità("normale");
                        jLabel185.setVisible(false);
                        jLabel186.setVisible(false);
                        timerPezziTempo.stop();
                    }
                }
                if(gioco.getDataGame().getTime()<1){ 
                    jLabel172.setVisible(false);
                    jButton82.setVisible(false);
                    jPanel62.setVisible(false);
                }
       }
   });
    Timer timerLegno=new Timer(100,new ActionListener(){
       public void actionPerformed(ActionEvent e){
               gioco.getDataGame().aggiungiLegno(1);
       }
   });
    Timer timerFerro=new Timer(100,new ActionListener(){
       public void actionPerformed(ActionEvent e){
                gioco.getDataGame().aggiungiFerro(0.10);
       }
   });
    Timer timerMana=new Timer(100,new ActionListener(){
    public void actionPerformed(ActionEvent e){
                gioco.getDataGame().aggiungiMana(1);
                
           }
   });
    Timer timerGenerale=new Timer(25,new ActionListener(){
    public void actionPerformed(ActionEvent e){
                schermataLivello();
                setVisibilitàRisorse();
                aggiornoBottoni();
                setBarra();
                SetRisorse();
                updateGUI();
           }
   });
   Timer timer = new Timer(1000, new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        setBarra();
        if (incantesimoManaAttivo) {
            jButton18.setText("● Incanta i getti di mana      60★");
        } else {
            jButton18.setText("Incanta i getti di mana       60★");
        }
        if(incantesimoGeyserAttivo){
            jButton66.setText("● Incanta Geyser di Mana 160★");
        }else{
            jButton66.setText("Incanta Geyser di Mana 160★");
        }

        if (incantesimoManaAttivo) {
            incantesimoCounterMana++;
            if (incantesimoCounterMana >= 30) {
                incantesimoManaAttivo = false;
                incantesimoCounterMana = 0;
            }
        }
        if(incantesimoGeyserAttivo){
            incantesimoCountergeyser++;
            if(incantesimoCountergeyser>=20){
                incantesimoGeyserAttivo=false;
                incantesimoCounterMana=0;
            }
        }
    }
});
   public void setIcone(){
       // icone seziono
       campusB.setIcon(new ImageIcon(campus));
       campusB.setHorizontalTextPosition(SwingConstants.RIGHT);
       campusB.setVerticalTextPosition(SwingConstants.CENTER);
       helpb.setIcon(new ImageIcon(aiuto));
       helpb.setHorizontalTextPosition(SwingConstants.RIGHT);
       helpb.setVerticalTextPosition(SwingConstants.CENTER);
       impostazioniB.setIcon(new ImageIcon(impostazioni));
       impostazioniB.setHorizontalTextPosition(SwingConstants.RIGHT);
       impostazioniB.setVerticalTextPosition(SwingConstants.CENTER);
       jButton6.setIcon(new ImageIcon(informazioni));
       jButton6.setHorizontalTextPosition(SwingConstants.RIGHT);
       jButton6.setVerticalTextPosition(SwingConstants.CENTER);
       jButton42.setIcon(new ImageIcon(penzione));
       jButton42.setHorizontalTextPosition(SwingConstants.RIGHT);
       jButton42.setVerticalTextPosition(SwingConstants.CENTER);
       jButton38.setIcon(new ImageIcon(ricerca));
       jButton38.setHorizontalTextPosition(SwingConstants.RIGHT);
       jButton38.setVerticalTextPosition(SwingConstants.CENTER);
       jButton9.setIcon(new ImageIcon(apprendisti));
       jButton9.setHorizontalTextPosition(SwingConstants.RIGHT);
       jButton9.setVerticalTextPosition(SwingConstants.CENTER);
       jButton124.setIcon(new ImageIcon(inventario));
       jButton124.setHorizontalTextPosition(SwingConstants.RIGHT);
       jButton124.setVerticalTextPosition(SwingConstants.CENTER);
       // tempo
       jLabel144.setIcon(new ImageIcon(tempo));
       jLabel144.setText("Pezzi di Tempo:");
       jLabel144.setHorizontalTextPosition(SwingConstants.RIGHT);
       jLabel144.setVerticalTextPosition(SwingConstants.CENTER);
       jLabel246.setIcon(new ImageIcon(tempo));
       jLabel246.setText("Pezzi di Tempo:");
       jLabel246.setHorizontalTextPosition(SwingConstants.RIGHT);
       jLabel246.setVerticalTextPosition(SwingConstants.CENTER);
       jLabel210.setIcon(new ImageIcon(tempo));
       jLabel210.setText("Pezzi di Tempo:");
       jLabel210.setHorizontalTextPosition(SwingConstants.RIGHT);
       jLabel210.setVerticalTextPosition(SwingConstants.CENTER);
       jLabel170.setIcon(new ImageIcon(tempo));
       jLabel170.setText("Pezzi di Tempo:");
       jLabel170.setHorizontalTextPosition(SwingConstants.RIGHT);
       jLabel170.setVerticalTextPosition(SwingConstants.CENTER);
       
        //icone temperatura
        jLabel235.setIcon(new ImageIcon(temperatura));
        jLabel235.setText("Temperatura:");
        
        //icone mana
        jLabel3.setIcon(new ImageIcon(iconamana));
        jLabel3.setText("Mana:");
        jLabel3.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel3.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel216.setIcon(new ImageIcon(iconamana));
        jLabel216.setText("Mana:");
        jLabel216.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel216.setVerticalTextPosition(SwingConstants.CENTER);
                
        //icone legno
        
        jLabel15.setIcon(new ImageIcon(iconalegno));
        jLabel15.setText("Legno:");
        jLabel15.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel15.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel217.setIcon(new ImageIcon(iconalegno));
        jLabel217.setText("Legno:");
        jLabel217.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel217.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel232.setIcon(new ImageIcon(iconalegno));
        jLabel232.setText("Legno:");
        jLabel232.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel232.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel31.setIcon(new ImageIcon(iconalegno));
        jLabel31.setText("Legno:");
        jLabel31.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel31.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel46.setIcon(new ImageIcon(iconalegno));
        jLabel46.setText("Legno:");
        jLabel46.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel46.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel37.setIcon(new ImageIcon(iconalegno));
        jLabel37.setText("Legno:");
        jLabel37.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel37.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel175.setIcon(new ImageIcon(iconalegno));
        jLabel175.setText("Legno:");
        jLabel175.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel175.setVerticalTextPosition(SwingConstants.CENTER);
               
        //icone pietra
        
        jLabel7.setIcon(new ImageIcon(iconapietra));
        jLabel197.setIcon(new ImageIcon(iconapietra));
        jLabel7.setText("Pietra:");
        jLabel197.setText("Pietra:");
        jLabel7.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel7.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel197.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel197.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel218.setIcon(new ImageIcon(iconapietra));
        jLabel218.setText("Pietra:");
        jLabel218.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel218.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel223.setIcon(new ImageIcon(iconapietra));
        jLabel223.setText("Pietra:");
        jLabel223.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel223.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel226.setIcon(new ImageIcon(iconapietra));
        jLabel226.setText("Pietra:");
        jLabel226.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel226.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel233.setIcon(new ImageIcon(iconapietra));
        jLabel233.setText("Pietra:");
        jLabel233.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel233.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel240.setIcon(new ImageIcon(iconapietra));
        jLabel240.setText("Pietra:");
        jLabel240.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel240.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel32.setIcon(new ImageIcon(iconapietra));
        jLabel32.setText("Pietra:");
        jLabel32.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel32.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel47.setIcon(new ImageIcon(iconapietra));
        jLabel47.setText("Pietra:");
        jLabel47.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel47.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel38.setIcon(new ImageIcon(iconapietra));
        jLabel38.setText("Pietra:");
        jLabel38.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel38.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel187.setIcon(new ImageIcon(iconapietra));
        jLabel187.setText("Pietra:");
        jLabel187.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel187.setVerticalTextPosition(SwingConstants.CENTER);
                
        //icone ferro
        
        jLabel16.setIcon(new ImageIcon(iconaferro));
        jLabel16.setText("Ferro:");
        jLabel16.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel16.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel209.setIcon(new ImageIcon(iconaferro));
        jLabel209.setText("Ferro:");
        jLabel209.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel209.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel227.setIcon(new ImageIcon(iconaferro));
        jLabel227.setText("Ferro:");
        jLabel227.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel227.setVerticalTextPosition(SwingConstants.CENTER);
        
        //icone acqua
        
        jLabel9.setIcon(new ImageIcon(iconaacqua));
        jLabel198.setIcon(new ImageIcon(iconaacqua));
        jLabel9.setText("Acqua:");
        jLabel198.setText("Acqua:");
        jLabel9.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel9.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel198.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel198.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel208.setIcon(new ImageIcon(iconaacqua));
        jLabel208.setText("Acqua:");
        jLabel208.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel208.setVerticalTextPosition(SwingConstants.CENTER);
        
        //icone monete
        jLabel160.setIcon(new ImageIcon(iconamonete));
        jLabel160.setText("Monete:");
        jLabel160.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel160.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel11.setIcon(new ImageIcon(iconamonete));
        jLabel11.setText("Monete:");
        jLabel11.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel11.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel203.setIcon(new ImageIcon(iconamonete));
        jLabel203.setText("Monete:");
        jLabel203.setHorizontalTextPosition(SwingConstants.RIGHT);   
        jLabel203.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel207.setIcon(new ImageIcon(iconamonete));
        jLabel207.setText("Monete:");
        jLabel207.setHorizontalTextPosition(SwingConstants.RIGHT);   
        jLabel207.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel221.setIcon(new ImageIcon(iconamonete));
        jLabel221.setText("Monete:");
        jLabel221.setHorizontalTextPosition(SwingConstants.RIGHT);   
        jLabel221.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel225.setIcon(new ImageIcon(iconamonete));
        jLabel225.setText("Monete:");
        jLabel225.setHorizontalTextPosition(SwingConstants.RIGHT);   
        jLabel225.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel231.setIcon(new ImageIcon(iconamonete));
        jLabel231.setText("Monete:");
        jLabel231.setHorizontalTextPosition(SwingConstants.RIGHT);   
        jLabel231.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel239.setIcon(new ImageIcon(iconamonete));
        jLabel239.setText("Monete:");
        jLabel239.setHorizontalTextPosition(SwingConstants.RIGHT);   
        jLabel239.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel30.setIcon(new ImageIcon(iconamonete));
        jLabel30.setText("Monete:");
        jLabel30.setHorizontalTextPosition(SwingConstants.RIGHT);   
        jLabel30.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel45.setIcon(new ImageIcon(iconamonete));
        jLabel45.setText("Monete:");
        jLabel45.setHorizontalTextPosition(SwingConstants.RIGHT);  
        jLabel45.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel36.setIcon(new ImageIcon(iconamonete));
        jLabel36.setText("Monete:");
        jLabel36.setHorizontalTextPosition(SwingConstants.RIGHT);  
        jLabel36.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel174.setIcon(new ImageIcon(iconamonete));
        jLabel174.setText("Monete:");
        jLabel174.setHorizontalTextPosition(SwingConstants.RIGHT); 
        jLabel174.setVerticalTextPosition(SwingConstants.CENTER);
        
        // icone bottoni risorse
        
        jButton14.setIcon(new ImageIcon(iconamana));
        jButton14.setHorizontalTextPosition(SwingConstants.LEFT);
        jButton14.setIconTextGap(5);
        jButton16.setIcon(new ImageIcon(iconamana));
        jButton16.setHorizontalTextPosition(SwingConstants.LEFT);
        jButton16.setIconTextGap(5);
        jButton37.setIcon(new ImageIcon(iconamana));
        jButton37.setHorizontalTextPosition(SwingConstants.LEFT);
        jButton37.setIconTextGap(5);
        jButton40.setIcon(new ImageIcon(iconamana));
        jButton40.setHorizontalTextPosition(SwingConstants.LEFT);
        jButton40.setIconTextGap(5);
        jButton46.setIcon(new ImageIcon(iconamana));
        jButton46.setHorizontalTextPosition(SwingConstants.LEFT);
        jButton46.setIconTextGap(5);
        jButton48.setIcon(new ImageIcon(iconamana));
        jButton48.setHorizontalTextPosition(SwingConstants.LEFT);
        jButton48.setIconTextGap(5);
        jButton50.setIcon(new ImageIcon(iconamana));
        jButton50.setHorizontalTextPosition(SwingConstants.LEFT);
        jButton50.setIconTextGap(5);
        jButton52.setIcon(new ImageIcon(iconamana));
        jButton52.setHorizontalTextPosition(SwingConstants.LEFT);
        jButton52.setIconTextGap(5);
        jButton122.setIcon(new ImageIcon(iconamana));
        jButton122.setHorizontalTextPosition(SwingConstants.LEFT);
        jButton122.setIconTextGap(5);
        jButton18.setIcon(new ImageIcon(iconamana));
        jButton18.setHorizontalTextPosition(SwingConstants.LEFT);
        jButton18.setIconTextGap(5);
        jButton67.setIcon(new ImageIcon(iconamana));
        jButton67.setHorizontalTextPosition(SwingConstants.LEFT);
        jButton67.setIconTextGap(5);
        jButton66.setIcon(new ImageIcon(iconamana));
        jButton66.setHorizontalTextPosition(SwingConstants.LEFT);
        jButton66.setIconTextGap(5);
        jButton20.setIcon(new ImageIcon(iconamana));
        jButton20.setHorizontalTextPosition(SwingConstants.LEFT);
        jButton20.setIconTextGap(5);
        jButton54.setIcon(new ImageIcon(iconamana));
        jButton54.setHorizontalTextPosition(SwingConstants.LEFT);
        jButton54.setIconTextGap(5);
        jButton56.setIcon(new ImageIcon(iconamana));
        jButton56.setHorizontalTextPosition(SwingConstants.LEFT);
        jButton56.setIconTextGap(5);
        jButton58.setIcon(new ImageIcon(iconamana));
        jButton58.setHorizontalTextPosition(SwingConstants.LEFT);
        jButton58.setIconTextGap(5);
                
        
        //button item
        jChest.setIcon(new ImageIcon(chest)); 
        jRamo.setIcon(new ImageIcon(branch));
        jClub.setIcon(new ImageIcon(club));
        jDagger.setIcon(new ImageIcon(dagger));
        jSword.setIcon(new ImageIcon(sword));
        jHandAxe.setIcon(new ImageIcon(handAxe));
        jFirewand.setIcon(new ImageIcon(firewand));
        jSickle.setIcon(new ImageIcon(sickle));
        jIronMail.setIcon(new ImageIcon(ironMail));
        jWizardsRobe.setIcon(new ImageIcon(elderWizardRobe));
        jThiefsGarb.setIcon(new ImageIcon(thiefGarb));
        jCristallo.setIcon(new ImageIcon(crystallizedMana));
        jSandali.setIcon(new ImageIcon(woodenSandals));
        jCloak.setIcon(new ImageIcon(cloak));
        jClothShoes.setIcon(new ImageIcon(clothShoes));
        jEnchantedCloak.setIcon(new ImageIcon(enchantedCloak));
        jCloath.setIcon(new ImageIcon(cloth));
   }

   public void setBarra(){
    if (!timer.isRunning()) {
        barra.setString("★" + gioco.getDataGame().getMana() + "/" + gioco.getDataGame().getMaxMana());
        barra.setValue(gioco.getDataGame().getMana());
        
    } else {
        if (incantesimoManaAttivo) {
            jLabel6.setText(gioco.getDataGame().getMana() + "/" + gioco.getDataGame().getMaxMana());
            barra.setString("★" + gioco.getDataGame().getMana() + "/" + gioco.getDataGame().getMaxMana()
                + "(+" + (gioco.getDataGame().getCalcoloMana() * 2 + gioco.getDataGame().getGeyser()*2 + gioco.getDataGame().getRamo()*2 + gioco.getDataGame().getCristallo()*2)+ "/s)");
            barra.setValue(gioco.getDataGame().getMana());
            jLabel60.setVisible(true);
            jLabel60.setText("+" +  (gioco.getDataGame().getCalcoloMana() * 2 + gioco.getDataGame().getGeyser()*2 + gioco.getDataGame().getRamo()*2 + gioco.getDataGame().getCristallo()*2)+ "/s");
        } else if (incantesimoGeyserAttivo) {
            jLabel6.setText(gioco.getDataGame().getMana() + "/" + gioco.getDataGame().getMaxMana());
            barra.setString("★" + gioco.getDataGame().getMana() + "/" + gioco.getDataGame().getMaxMana()
                + "(+" +(gioco.getDataGame().getCalcoloMana()+ gioco.getDataGame().getGeyser()*4 + gioco.getDataGame().getRamo()*2 + gioco.getDataGame().getCristallo()*2)+ "/s)");
            barra.setValue(gioco.getDataGame().getMana());
            jLabel60.setVisible(true);
            jLabel60.setText("+" +(gioco.getDataGame().getCalcoloMana()+ gioco.getDataGame().getGeyser()*4 + gioco.getDataGame().getRamo()*2 + gioco.getDataGame().getCristallo()*2)+ "/s");
        } else {
            jLabel6.setText(gioco.getDataGame().getMana() + "/" + gioco.getDataGame().getMaxMana());
            barra.setString("★" + gioco.getDataGame().getMana() + "/" + gioco.getDataGame().getMaxMana()
                + "(+" +(gioco.getDataGame().getCalcoloMana() + gioco.getDataGame().getGeyser()*2 + gioco.getDataGame().getRamo()*2 + gioco.getDataGame().getCristallo()*2)+ "/s)");
            barra.setValue(gioco.getDataGame().getMana());
            jLabel60.setVisible(true);
        jLabel60.setText("+" +(gioco.getDataGame().getCalcoloMana()+ gioco.getDataGame().getGeyser()*2 + gioco.getDataGame().getRamo()*2 + gioco.getDataGame().getCristallo()*2)+ "/s");
        }
    }
}

   Timer timerAddLegno = new Timer(1000, new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        if (incantesimoLegnoAttivo) {
            setVisibilitàRisorse();
            jLabel97.setVisible(true);
            jLabel97.setText("+" + (gioco.getDataGame().getDepositoLegno() * 2) + "/s");
            jButton67.setText("● Incanta i depositi di legno 80★");
        } else {
            jLabel97.setVisible(true);
            jLabel97.setText("+"+gioco.getDataGame().getDepositoLegno()+"/s");
            jButton67.setText("Incanta i depositi di legno 80★");
        }
        
        if (incantesimoLegnoAttivo) {
            incantesimoCounterLegno++;
            
            if (incantesimoCounterLegno >= 30) {
                incantesimoLegnoAttivo = false;
                incantesimoCounterLegno = 0;
            }
        }
    }
});
    public void aggiornoBottoni(){
    jButton133.setEnabled(jLabel249.getIcon()!=null);
    jButton134.setEnabled(jLabel260.getIcon()!=null);
    jButton135.setEnabled(jLabel261.getIcon()!=null);
    aggiornoButtoneCreaItem();
    jButton122.setEnabled(
    gioco.getDataGame().getMana() >= 300
    && (
        // Beccuccio di Mana
        (gioco.getDataGame().getPietra() >= gioco.getDataGame().getRisorsaNecesariaSilosPietra()
         && gioco.getDataGame().getAcqua()  >= gioco.getDataGame().getRisorsaNecesariaSilosAcqua()
         && gioco.getDataGame().getSilos()  > 0)
        ||
        // Frammento di Mana
        (gioco.getDataGame().getMonete()   >= gioco.getDataGame().getRisorsaNecesariaFrammentoMana()
         && gioco.getDataGame().getManaShard() > 0)
        ||
        // Geyser di Mana
        (gioco.getDataGame().getMonete()   >= gioco.getDataGame().getRisorsaNecessariaMoneteGeyser()
         && gioco.getDataGame().getAcqua()  >= gioco.getDataGame().getRisorsaNecessariaAcquaGeyser()
         && gioco.getDataGame().getFerro()  >= gioco.getDataGame().getRisorsaNecessariaFerroGeyser()
         && gioco.getDataGame().getGeyser() > 0)
        ||
        // Deposito di Legno
        (gioco.getDataGame().getMana()    >= 200
         && gioco.getDataGame().getLegno() >= gioco.getDataGame().getRisorsaNecessariaLegnoLegname()
         && gioco.getDataGame().getPietra()>= gioco.getDataGame().getRisorsaNecessariaPietraLegname()
         && gioco.getDataGame().getDepositoLegno() > 0)
        ||
        // Forno
        (gioco.getDataGame().getMonete()  >= gioco.getDataGame().getRisorsaNecessariaMoneteForno()
         && gioco.getDataGame().getPietra()>= gioco.getDataGame().getRisorsaNecessariaPietraForno()
         && gioco.getDataGame().getFerro()>= gioco.getDataGame().getRisorsaNecessariaFerroForno()
         && gioco.getDataGame().getForno() > 0)
        ||
        // Magazzino
        (gioco.getDataGame().getMonete()  >= gioco.getDataGame().getRisorsaNecessariaMoneteMagazzino()
         && gioco.getDataGame().getPietra()>= gioco.getDataGame().getRisorsaNecessariaPietraMagazzino()
         && gioco.getDataGame().getMagazzino() > 0)
        ||
        // Serbatoio di Acqua
        (gioco.getDataGame().getMonete()  >= gioco.getDataGame().getRisorsaNecessariaMoneteSerbatoioAcqua()
         && gioco.getDataGame().getLegno()>= gioco.getDataGame().getRisorsaNecessariaLegnoSerbatoioAcqua()
         && gioco.getDataGame().getPietra()>= gioco.getDataGame().getRisorsaNecessariaPietraSerbatoioAcqua()
         && gioco.getDataGame().getSerbatoioAcqua() > 0)
        ||
        // Caveau
        (gioco.getDataGame().getMonete()  >= gioco.getDataGame().getRisorsaNecessariaMoneteVault()
         && gioco.getDataGame().getPietra()>= gioco.getDataGame().getRisorsaNecessariaPietraVault()
         && gioco.getDataGame().getCaveau() > 0)
        ||
        // Cabina Ricercatore
        (gioco.getDataGame().getMonete()  >= gioco.getDataGame().getRisorsaNecessariaMoneteCabinaR()
         && gioco.getDataGame().getLegno()>= gioco.getDataGame().getRisorsaNecessariaLegnoCabinaR()
         && gioco.getDataGame().getPietra()>= gioco.getDataGame().getRisorsaNecessariaPietraCabinaR()
         && gioco.getDataGame().getCapacitàRicercatore() > 0)
        ||
        // Apprendisti
        (gioco.getDataGame().getMonete()  >= gioco.getDataGame().getRisorsaNecessariaMoneteApprendista()
         && gioco.getDataGame().getLegno()>= gioco.getDataGame().getRisorsaNecessariaLegnoApprendista()
         && gioco.getDataGame().getPietra()>= gioco.getDataGame().getRisorsanecessariaPietraApprendista()
         && gioco.getDataGame().getApprendisti() > 0)
    )
);
        jButton105.setEnabled(gioco.getDataGame().getApprendistiFuoco()>0);
        jButton103.setEnabled(gioco.getDataGame().getApprendistiBolle()>0);
        jButton101.setEnabled(gioco.getDataGame().getApprendistiVento()>0);
        jButton93.setEnabled(gioco.getDataGame().getApprendistiGeyserMana()>0);
        jButton92.setEnabled(gioco.getDataGame().getApprendistiDepositoLegno()>0);
        jButton60.setEnabled(gioco.getDataGame().getApprendistiSbarraFerro()>0);
        jButton45.setEnabled(gioco.getDataGame().getApprendistiAcquaIII()>0);
        jButton44.setEnabled(gioco.getDataGame().getApprendistiMasso()>0);
        jButton24.setEnabled(gioco.getDataGame().getApprendistiMineraliFerro()>0);
        jButton65.setEnabled(gioco.getDataGame().getApprendistiDisponibili()>0);
        jButton127.setEnabled(gioco.getDataGame().getFornoAttivi()>0);
        jButton128.setEnabled(gioco.getDataGame().forniDisponibili()>0);
        jButton125.setEnabled(gioco.getDataGame().getMonete()>=gioco.getDataGame().getRisorsaNecessariaMoneteForno() && gioco.getDataGame().getPietra()>=gioco.getDataGame().getRisorsaNecessariaPietraForno() && gioco.getDataGame().getFerro()>=gioco.getDataGame().getRisorsaNecessariaFerroForno());
        jButton121.setEnabled(gioco.getDataGame().getMonete()>=2000 && gioco.getDataGame().getLegno()>=2000 && gioco.getDataGame().getFerro()>=100);
        jButton122.setEnabled(gioco.getDataGame().getMana()>=300);
        jButton113.setEnabled(gioco.getDataGame().getTime()>=3000);
        jButton100.setEnabled(gioco.getDataGame().getApprendistiMagia()>0);
        jButton23.setEnabled(gioco.getDataGame().getApprendistiAcquaII()>0);
        jButton87.setEnabled(gioco.getDataGame().getApprendistiGettiMana()>0);
        jButton22.setEnabled(gioco.getDataGame().getApprendistiRoccia()>0);
        jButton11.setEnabled(gioco.getDataGame().getApprendistiAcqua()>0);
        jButton10.setEnabled(gioco.getDataGame().getApprendistiPietra()>0);
        jButton62.setEnabled(gioco.getDataGame().getApprendistiDisponibili()> 0);
        jButton63.setEnabled(gioco.getDataGame().getApprendistiDisponibili()> 0);
        jButton64.setEnabled(gioco.getDataGame().getApprendistiDisponibili()> 0);
        jButton65.setEnabled(gioco.getDataGame().getApprendistiDisponibili()> 0);
        jButton84.setEnabled(gioco.getDataGame().getApprendistiDisponibili()> 0);
        jButton85.setEnabled(gioco.getDataGame().getApprendistiDisponibili()> 0);
        jButton86.setEnabled(gioco.getDataGame().getApprendistiDisponibili()> 0);
        jButton94.setEnabled(gioco.getDataGame().getApprendistiDisponibili()> 0);
        jButton96.setEnabled(gioco.getDataGame().getApprendistiDisponibili()> 0);
        jButton98.setEnabled(gioco.getDataGame().getApprendistiDisponibili()> 0);
        jButton111.setEnabled(gioco.getDataGame().getApprendistiDisponibili()> 0);
        jButton107.setEnabled(gioco.getDataGame().getApprendistiDisponibili()> 0);
        jButton108.setEnabled(gioco.getDataGame().getApprendistiDisponibili()> 0);
        jButton110.setEnabled(gioco.getDataGame().getApprendistiDisponibili()> 0);
        jButton61.setEnabled(gioco.getDataGame().getApprendistiDisponibili()> 0);
        jButton7.setEnabled(gioco.getDataGame().getMonete()>=gioco.getDataGame().getRisorsaNecessariaMoneteApprendista() && gioco.getDataGame().getLegno()>=gioco.getDataGame().getRisorsaNecessariaLegnoApprendista() && gioco.getDataGame().getPietra()>=gioco.getDataGame().getRisorsanecessariaPietraApprendista());
        jButton117.setEnabled(gioco.getDataGame().getMonete()>=gioco.getDataGame().getRisorsaNecessariaMoneteApprendista() && gioco.getDataGame().getLegno()>=gioco.getDataGame().getRisorsaNecessariaLegnoApprendista() && gioco.getDataGame().getPietra()>=gioco.getDataGame().getRisorsanecessariaPietraApprendista());
        BottoneCabina1.setEnabled(gioco.getDataGame().getMonete()>=gioco.getDataGame().getRisorsaNecessariaMoneteCabinaR() && gioco.getDataGame().getLegno()>=gioco.getDataGame().getRisorsaNecessariaLegnoCabinaR() && gioco.getDataGame().getPietra()>=gioco.getDataGame().getRisorsaNecessariaPietraCabinaR());
        jButton4.setEnabled(gioco.getDataGame().getMonete()>=gioco.getDataGame().getRisorsaNecessariaMoneteCabinaR() && gioco.getDataGame().getLegno()>=gioco.getDataGame().getRisorsaNecessariaLegnoCabinaR() && gioco.getDataGame().getPietra()>=gioco.getDataGame().getRisorsaNecessariaPietraCabinaR());
        RaccogliMana.setEnabled(gioco.getDataGame().getMana()<gioco.getDataGame().getMaxMana());
        RaccogliLegno.setEnabled(gioco.getDataGame().getLegno()<gioco.getDataGame().getMaxLegno());
        RaccogliFerro.setEnabled(gioco.getDataGame().getFerro()<gioco.getDataGame().getMaxFerro());
        BottoneSilos.setEnabled(gioco.getDataGame().getPietra()>=gioco.getDataGame().getRisorsaNecesariaSilosPietra() && gioco.getDataGame().getAcqua()>=gioco.getDataGame().getRisorsaNecesariaSilosAcqua());
        BottoneShard.setEnabled(gioco.getDataGame().getMonete()>=gioco.getDataGame().getRisorsaNecesariaFrammentoMana());
        BottoneGeyser.setEnabled(gioco.getDataGame().getMonete()>=gioco.getDataGame().getRisorsaNecessariaMoneteGeyser() && gioco.getDataGame().getAcqua()>=gioco.getDataGame().getRisorsaNecessariaAcquaGeyser() && gioco.getDataGame().getFerro()>=gioco.getDataGame().getRisorsaNecessariaFerroGeyser());
        BottoneLegname.setEnabled(gioco.getDataGame().getMana()>=200 && gioco.getDataGame().getLegno()>=gioco.getDataGame().getRisorsaNecessariaLegnoLegname() && gioco.getDataGame().getPietra()>=gioco.getDataGame().getRisorsaNecessariaPietraLegname());
        BottoneMagazzino.setEnabled(gioco.getDataGame().getMonete()>=gioco.getDataGame().getRisorsaNecessariaMoneteMagazzino() && gioco.getDataGame().getPietra()>=gioco.getDataGame().getRisorsaNecessariaPietraMagazzino());
        BottoneSerbatoio.setEnabled(gioco.getDataGame().getMonete()>=gioco.getDataGame().getRisorsaNecessariaMoneteSerbatoioAcqua() && gioco.getDataGame().getLegno()>= gioco.getDataGame().getRisorsaNecessariaLegnoSerbatoioAcqua() && gioco.getDataGame().getPietra()>=gioco.getDataGame().getRisorsaNecessariaPietraSerbatoioAcqua());
        BottoneCaveau.setEnabled(gioco.getDataGame().getMonete()>=gioco.getDataGame().getRisorsaNecessariaMoneteVault() && gioco.getDataGame().getPietra()>= gioco.getDataGame().getRisorsaNecessariaPietraVault());
        BottonePezziTempo.setEnabled(gioco.getDataGame().getTime()>=3000 && (gioco.getDataGame().getRicercatoriEvocazione()>0 || gioco.getDataGame().getRicercatoriIncanto()>0 || gioco.getDataGame().getRicercatoriIllusione()>0));
        BottoneRicercatore.setEnabled(gioco.getDataGame().getMonete()>=200);
        jButton76.setEnabled(gioco.getDataGame().getTime()>=3000 && (gioco.getDataGame().getRicercatoriEvocazione()>0 || gioco.getDataGame().getRicercatoriIncanto()>0 || gioco.getDataGame().getRicercatoriIllusione()>0));
        jButton81.setEnabled(gioco.getDataGame().getRicercatoriIllusione() > 0);
        jButton80.setEnabled(gioco.getDataGame().getRicercatoriDisponibili() > 0);
        jButton78.setEnabled(gioco.getDataGame().getRicercatoriIncanto() > 0);
        jButton77.setEnabled(gioco.getDataGame().getRicercatoriDisponibili() > 0);
        jButton74.setEnabled(gioco.getDataGame().getRicercatoriDisponibili() > 0);
        jButton73.setEnabled(gioco.getDataGame().getRicercatoriEvocazione() > 0);
        jButton89.setEnabled(gioco.getDataGame().getCapacitàRicercatore()>gioco.getDataGame().getRicercatore() && gioco.getDataGame().getMonete()>=gioco.getDataGame().getRisorsaNecessariaMoneteRicercatore());
        jButton66.setEnabled(gioco.getDataGame().getMana()>=160);
        jButton67.setEnabled(gioco.getDataGame().getMana()>=80);
        barra.setMaximum(gioco.getDataGame().getMaxMana());
        jButton58.setEnabled(gioco.getDataGame().getMana()>=580);
        jButton56.setEnabled(gioco.getDataGame().getMana()>=150);
        jButton54.setEnabled(gioco.getDataGame().getMana()>=70);
        jButton52.setEnabled(gioco.getDataGame().getMana()>=320);
        jButton50.setEnabled(gioco.getDataGame().getMana()>=1060);
        jButton48.setEnabled(gioco.getDataGame().getMana()>=440);
        jButton46.setEnabled(gioco.getDataGame().getMana()>=40);
        jButton40.setEnabled(gioco.getDataGame().getMana()>=180);
        jButton18.setEnabled(gioco.getDataGame().getMana()>=60);
        jLabel60.setVisible(gioco.getDataGame().getCalcoloMana()>0);
        jLabel97.setVisible(gioco.getDataGame().getDepositoLegno()>0);
        jLabel237.setVisible(gioco.getDataGame().getForno()>0);
        jButton20.setEnabled(gioco.getDataGame().getMana()>=30);
        jButton37.setEnabled(gioco.getDataGame().getMana()>=40);
        jButton16.setEnabled(gioco.getDataGame().getMana()>=20);
        jButton14.setEnabled(gioco.getDataGame().getMana()>=10); 
        barra.setValue(gioco.getDataGame().getMana());
    }
    public void settColors() {
        if(Swichcolormanual==false){
             String elemento = gioco.getDataGame().getElemento();
        if (elemento.equals("Fuoco")) {
            jButton150.setBackground(new Color(255,0,0));
            jButton133.setBackground(new Color(255,0,0));
            jButton134.setBackground(new Color(255,0,0));
            jButton135.setBackground(new Color(255,0,0));
            jButton155.setBackground(new Color(255,0,0));
            jButton131.setBackground(new Color(255,0,0));
            jComboBox3.setBackground(new Color(255,0,0));
            jButton130.setBackground(new Color(255,0,0));
            jButton128.setBackground(new Color(255,0,0));
            jButton127.setBackground(new Color(255,0,0));
            jButton125.setBackground(new Color(255,0,0));
            jButton122.setBackground(new Color(255,0,0));
            jButton121.setBackground(new Color(255,0,0));
            jProgressBar2.setForeground(new Color(255,0,0));
            jButton113.setBackground(new Color(255,0,0));
            jButton10.setBackground(new Color(255,0,0));
            jButton11.setBackground(new Color(255,0,0));
            jButton22.setBackground(new Color(255,0,0));
            jButton23.setBackground(new Color(255,0,0));
            jButton24.setBackground(new Color(255,0,0));
            jButton44.setBackground(new Color(255,0,0));
            jButton45.setBackground(new Color(255,0,0));
            jButton60.setBackground(new Color(255,0,0));
            jButton87.setBackground(new Color(255,0,0));
            jButton92.setBackground(new Color(255,0,0));
            jButton93.setBackground(new Color(255,0,0));
            jButton100.setBackground(new Color(255,0,0));
            jButton101.setBackground(new Color(255,0,0));
            jButton103.setBackground(new Color(255,0,0));
            jButton105.setBackground(new Color(255,0,0));
            jButton62.setBackground(new Color(255,0,0));
            jButton63.setBackground(new Color(255,0,0));
            jButton64.setBackground(new Color(255,0,0));
            jButton65.setBackground(new Color(255,0,0));
            jButton84.setBackground(new Color(255,0,0));
            jButton85.setBackground(new Color(255,0,0));
            jButton86.setBackground(new Color(255,0,0));
            jButton94.setBackground(new Color(255,0,0));
            jButton96.setBackground(new Color(255,0,0));
            jButton98.setBackground(new Color(255,0,0));
            jButton111.setBackground(new Color(255,0,0));
            jButton107.setBackground(new Color(255,0,0));
            jButton108.setBackground(new Color(255,0,0));
            jButton110.setBackground(new Color(255,0,0));
            jButton61.setBackground(new Color(255,0,0));
            jButton117.setBackground(new Color(255,0,0));
            jButton7.setBackground(new Color(255,0,0));
            jButton4.setBackground(new Color(255,0,0));
            BottoneCabina1.setBackground(new Color(255,0,0));
            RaccogliMana.setBackground(new Color(255,0,0));
            RaccogliLegno.setBackground(new Color(255,0,0));
            RaccogliFerro.setBackground(new Color(255,0,0));
            BottoneSilos.setBackground(new Color(255,0,0));
            BottoneShard.setBackground(new Color(255,0,0));
            BottoneGeyser.setBackground(new Color(255,0,0));
            BottoneLegname.setBackground(new Color(255,0,0));
            BottoneMagazzino.setBackground(new Color(255,0,0));
            BottoneSerbatoio.setBackground(new Color(255,0,0));
            BottoneCaveau.setBackground(new Color(255,0,0));
            BottonePezziTempo.setBackground(new Color(255,0,0));
            BottoneRicercatore.setBackground(new Color(255,0,0));
            jButton76.setBackground(new Color(255,0,0));
            jButton83.setBackground(new Color(255,0,0));
            jButton90.setBackground(new Color(255,0,0));
            jButton91.setBackground(new Color(255,0,0));
            jButton74.setBackground(new Color(255,0,0));
            jButton73.setBackground(new Color(255,0,0));
            jButton77.setBackground(new Color(255,0,0));
            jButton78.setBackground(new Color(255,0,0));
            jButton80.setBackground(new Color(255,0,0));
            jButton81.setBackground(new Color(255,0,0));
            jButton89.setBackground(new Color(255,0,0));
            jButton66.setBackground(new Color(255,0,0));
            jButton67.setBackground(new Color(255,0,0));
            jButton58.setBackground(new Color(255,0,0));
            jButton56.setBackground(new Color(255,0,0));
            jButton54.setBackground(new Color(255,0,0));
            jButton52.setBackground(new Color(255,0,0));
            jButton50.setBackground(new Color(255,0,0));
            jButton48.setBackground(new Color(255,0,0));
            jButton46.setBackground(new Color(255,0,0));
            jButton43.setBackground(new Color(255,0,0));
            jButton40.setBackground(new Color(255,0,0));
            jButton37.setBackground(new Color(255,0,0));
            jButton36.setBackground(new Color(255,0,0));
            jButton34.setBackground(new Color(255,0,0));
            jComboBox2.setBackground(new Color(255,0,0));
            jButton20.setBackground(new Color(255,0,0));
            jButton18.setBackground(new Color(255,0,0));
            jButton13.setBackground(new Color(255,0,0));
            jComboBox1.setBackground(new Color(255,0,0));
            jButton16.setBackground(new Color(255,0,0));
            jButton14.setBackground(new Color(255,0,0));
            PanelSuperioreG.setBackground(new Color(255, 0, 0));
        } else if (elemento.equals("Acqua")) {
            jButton150.setBackground(new Color(0, 122, 255));
            jButton133.setBackground(new Color(0, 122, 255));
            jButton134.setBackground(new Color(0, 122, 255));
            jButton135.setBackground(new Color(0, 122, 255));
            jButton155.setBackground(new Color(0, 122, 255));
            jButton131.setBackground(new Color(0, 122, 255));
            jComboBox3.setBackground(new Color(0, 122, 255));
            jButton130.setBackground(new Color(0, 122, 255));
            jButton128.setBackground(new Color(0, 122, 255));
            jButton127.setBackground(new Color(0, 122, 255));
            jButton125.setBackground(new Color(0, 122, 255));
            jButton122.setBackground(new Color(0, 122, 255));
            jButton121.setBackground(new Color(0, 122, 255));
            jProgressBar2.setForeground(new Color(0, 122, 255));
            jButton113.setBackground(new Color(0, 122, 255));
            jButton10.setBackground(new Color(0, 122, 255));
            jButton11.setBackground(new Color(0, 122, 255));
            jButton22.setBackground(new Color(0, 122, 255));
            jButton23.setBackground(new Color(0, 122, 255));
            jButton24.setBackground(new Color(0, 122, 255));
            jButton44.setBackground(new Color(0, 122, 255));
            jButton45.setBackground(new Color(0, 122, 255));
            jButton60.setBackground(new Color(0, 122, 255));
            jButton87.setBackground(new Color(0, 122, 255));
            jButton92.setBackground(new Color(0, 122, 255));
            jButton93.setBackground(new Color(0, 122, 255));
            jButton100.setBackground(new Color(0, 122, 255));
            jButton101.setBackground(new Color(0, 122, 255));
            jButton103.setBackground(new Color(0, 122, 255));
            jButton105.setBackground(new Color(0, 122, 255));
            jButton62.setBackground(new Color(0, 122, 255));
            jButton63.setBackground(new Color(0, 122, 255));
            jButton64.setBackground(new Color(0, 122, 255));
            jButton65.setBackground(new Color(0, 122, 255));
            jButton84.setBackground(new Color(0, 122, 255));
            jButton85.setBackground(new Color(0, 122, 255));
            jButton86.setBackground(new Color(0, 122, 255));
            jButton94.setBackground(new Color(0, 122, 255));
            jButton96.setBackground(new Color(0, 122, 255));
            jButton98.setBackground(new Color(0, 122, 255));
            jButton111.setBackground(new Color(0, 122, 255));
            jButton107.setBackground(new Color(0, 122, 255));
            jButton108.setBackground(new Color(0, 122, 255));
            jButton110.setBackground(new Color(0, 122, 255));
            jButton61.setBackground(new Color(0, 122, 255));
            jButton117.setBackground(new Color(0, 122, 255));
            jButton7.setBackground(new Color(0, 122, 255));
            jButton4.setBackground(new Color(0, 122, 255));
            BottoneCabina1.setBackground(new Color(0, 122, 255));
            RaccogliMana.setBackground(new Color(0, 122, 255));
            RaccogliLegno.setBackground(new Color(0, 122, 255));
            RaccogliFerro.setBackground(new Color(0, 122, 255));
            BottoneSilos.setBackground(new Color(0, 122, 255));
            BottoneShard.setBackground(new Color(0, 122, 255));
            BottoneGeyser.setBackground(new Color(0, 122, 255));
            BottoneLegname.setBackground(new Color(0, 122, 255));
            BottoneMagazzino.setBackground(new Color(0, 122, 255));
            BottoneSerbatoio.setBackground(new Color(0, 122, 255));
            BottoneCaveau.setBackground(new Color(0, 122, 255));
            BottonePezziTempo.setBackground(new Color(0, 122, 255));
            BottoneRicercatore.setBackground(new Color(0, 122, 255));
            jButton76.setBackground(new Color(0, 122, 255));
            jButton83.setBackground(new Color(0, 122, 255));
            jButton90.setBackground(new Color(0, 122, 255));
            jButton91.setBackground(new Color(0, 122, 255));
            jButton74.setBackground(new Color(0, 122, 255));
            jButton73.setBackground(new Color(0, 122, 255));
            jButton77.setBackground(new Color(0, 122, 255));
            jButton78.setBackground(new Color(0, 122, 255));
            jButton80.setBackground(new Color(0, 122, 255));
            jButton81.setBackground(new Color(0, 122, 255));
            jButton89.setBackground(new Color(0, 122, 255));
            jButton66.setBackground(new Color(0, 122, 255));
            jButton67.setBackground(new Color(0, 122, 255));
            jButton58.setBackground(new Color(0, 122, 255));
            jButton56.setBackground(new Color(0, 122, 255));
            jButton54.setBackground(new Color(0, 122, 255));
            jButton52.setBackground(new Color(0, 122, 255));
            jButton50.setBackground(new Color(0, 122, 255));
            jButton48.setBackground(new Color(0, 122, 255));
            jButton46.setBackground(new Color(0, 122, 255));
            jButton43.setBackground(new Color(0, 122, 255));
             jButton40.setBackground(new Color(0, 122, 255));
            jButton37.setBackground(new Color(0, 122, 255));
            jButton36.setBackground(new Color(0, 122, 255));
            jButton34.setBackground(new Color(0, 122, 255));
            jComboBox2.setBackground(new Color(0, 122, 255));
            jButton20.setBackground(new Color(0, 122, 255));
            jButton18.setBackground(new Color(0, 122, 255));
            jButton13.setBackground(new Color(0, 122, 255));
            jComboBox1.setBackground(new Color(0, 122, 255));
            jButton16.setBackground(new Color(0, 122, 255));
            jButton14.setBackground(new Color(0, 122, 255));
            PanelSuperioreG.setBackground(new Color(0, 122, 255));
        } else if (elemento.equals("Terra")) {
            jButton150.setBackground(new Color(139, 69, 19));
            jButton133.setBackground(new Color(139, 69, 19));
            jButton134.setBackground(new Color(139, 69, 19));
            jButton135.setBackground(new Color(139, 69, 19));
            jButton155.setBackground(new Color(139, 69, 19));
            jButton131.setBackground(new Color(139, 69, 19));
            jComboBox3.setBackground(new Color(139, 69, 19));
            jButton130.setBackground(new Color(139, 69, 19));
            jButton128.setBackground(new Color(139, 69, 19));
            jButton127.setBackground(new Color(139, 69, 19));
            jButton125.setBackground(new Color(139, 69, 19));
            jButton122.setBackground(new Color(139, 69, 19));
            jButton121.setBackground(new Color(139, 69, 19));
            jProgressBar2.setForeground(new Color(139, 69, 19));
            jButton113.setBackground(new Color(139, 69, 19));
            jButton10.setBackground(new Color(139, 69, 19));
            jButton11.setBackground(new Color(139, 69, 19));
            jButton22.setBackground(new Color(139, 69, 19));
            jButton23.setBackground(new Color(139, 69, 19));
            jButton24.setBackground(new Color(139, 69, 19));
            jButton44.setBackground(new Color(139, 69, 19));
            jButton45.setBackground(new Color(139, 69, 19));
            jButton60.setBackground(new Color(139, 69, 19));
            jButton87.setBackground(new Color(139, 69, 19));
            jButton92.setBackground(new Color(139, 69, 19));
            jButton93.setBackground(new Color(139, 69, 19));
            jButton100.setBackground(new Color(139, 69, 19));
            jButton101.setBackground(new Color(139, 69, 19));
            jButton103.setBackground(new Color(139, 69, 19));
            jButton105.setBackground(new Color(139, 69, 19));
            jButton62.setBackground(new Color(139, 69, 19));
            jButton63.setBackground(new Color(139, 69, 19));
            jButton64.setBackground(new Color(139, 69, 19));
            jButton65.setBackground(new Color(139, 69, 19));
            jButton84.setBackground(new Color(139, 69, 19));
            jButton85.setBackground(new Color(139, 69, 19));
            jButton86.setBackground(new Color(139, 69, 19));
            jButton94.setBackground(new Color(139, 69, 19));
            jButton96.setBackground(new Color(139, 69, 19));
            jButton98.setBackground(new Color(139, 69, 19));
            jButton111.setBackground(new Color(139, 69, 19));
            jButton107.setBackground(new Color(139, 69, 19));
            jButton108.setBackground(new Color(139, 69, 19));
            jButton110.setBackground(new Color(139, 69, 19));
            jButton61.setBackground(new Color(139, 69, 19));
            jButton117.setBackground(new Color(139, 69, 19));
            jButton7.setBackground(new Color(139, 69, 19));
            jButton4.setBackground(new Color(139, 69, 19));
            BottoneCabina1.setBackground(new Color(139, 69, 19));
            RaccogliMana.setBackground(new Color(139, 69, 19));
            RaccogliLegno.setBackground(new Color(139, 69, 19));
            RaccogliFerro.setBackground(new Color(139, 69, 19));
            BottoneSilos.setBackground(new Color(139, 69, 19));
            BottoneShard.setBackground(new Color(139, 69, 19));
            BottoneGeyser.setBackground(new Color(139, 69, 19));
            BottoneLegname.setBackground(new Color(139, 69, 19));
            BottoneMagazzino.setBackground(new Color(139, 69, 19));
            BottoneSerbatoio.setBackground(new Color(139, 69, 19));
            BottoneCaveau.setBackground(new Color(139, 69, 19));
            BottonePezziTempo.setBackground(new Color(139, 69, 19));
            BottoneRicercatore.setBackground(new Color(139, 69, 19));
            jButton76.setBackground(new Color(139, 69, 19));
            jButton83.setBackground(new Color(139, 69, 19));
            jButton90.setBackground(new Color(139, 69, 19));
            jButton91.setBackground(new Color(139, 69, 19));
            jButton74.setBackground(new Color(139, 69, 19));
            jButton73.setBackground(new Color(139, 69, 19));
            jButton77.setBackground(new Color(139, 69, 19));
            jButton78.setBackground(new Color(139, 69, 19));
            jButton80.setBackground(new Color(139, 69, 19));
            jButton81.setBackground(new Color(139, 69, 19));
            jButton89.setBackground(new Color(139, 69, 19));
            jButton66.setBackground(new Color(139, 69, 19));
            jButton67.setBackground(new Color(139, 69, 19));
            jButton58.setBackground(new Color(139, 69, 19));
            jButton56.setBackground(new Color(139, 69, 19));
            jButton54.setBackground(new Color(139, 69, 19));
            jButton52.setBackground(new Color(139, 69, 19));
            jButton50.setBackground(new Color(139, 69, 19));
            jButton48.setBackground(new Color(139, 69, 19));
            jButton46.setBackground(new Color(139, 69, 19));
            jButton43.setBackground(new Color(139, 69, 19));
             jButton40.setBackground(new Color(139, 69, 19));
            jButton37.setBackground(new Color(139, 69, 19));
            jButton36.setBackground(new Color(139, 69, 19));
            jButton34.setBackground(new Color(139, 69, 19));
            jComboBox2.setBackground(new Color(139, 69, 19));
            jButton20.setBackground(new Color(139, 69, 19));
            jButton18.setBackground(new Color(139, 69, 19));
            jButton13.setBackground(new Color(139, 69, 19));
            jComboBox1.setBackground(new Color(139, 69, 19));
            jButton16.setBackground(new Color(139, 69, 19));
            jButton14.setBackground(new Color(139, 69, 19));
            PanelSuperioreG.setBackground(new Color(139, 69, 19));
        } else if (elemento.equals("Aria")) {
            jButton150.setBackground(new Color(50, 205, 50));
            jButton133.setBackground(new Color(50, 205, 50));
            jButton134.setBackground(new Color(50, 205, 50));
            jButton135.setBackground(new Color(50, 205, 50));
            jButton155.setBackground(new Color(50, 205, 50));
            jButton131.setBackground(new Color(50, 205, 50));
            jComboBox3.setBackground(new Color(50, 205, 50));
            jButton130.setBackground(new Color(50, 205, 50));
            jButton128.setBackground(new Color(50, 205, 50));
            jButton127.setBackground(new Color(50, 205, 50));
            jButton125.setBackground(new Color(50, 205, 50));
            jButton122.setBackground(new Color(50, 205, 50));
            jButton121.setBackground(new Color(50, 205, 50));
            jProgressBar2.setForeground(new Color(50, 205, 50));
            jButton113.setBackground(new Color(50, 205, 50));
            jButton10.setBackground(new Color(50, 205, 50));
            jButton11.setBackground(new Color(50, 205, 50));
            jButton22.setBackground(new Color(50, 205, 50));
            jButton23.setBackground(new Color(50, 205, 50));
            jButton24.setBackground(new Color(50, 205, 50));
            jButton44.setBackground(new Color(50, 205, 50));
            jButton45.setBackground(new Color(50, 205, 50));
            jButton60.setBackground(new Color(50, 205, 50));
            jButton87.setBackground(new Color(50, 205, 50));
            jButton92.setBackground(new Color(50, 205, 50));
            jButton93.setBackground(new Color(50, 205, 50));
            jButton100.setBackground(new Color(50, 205, 50));
            jButton101.setBackground(new Color(50, 205, 50));
            jButton103.setBackground(new Color(50, 205, 50));
            jButton105.setBackground(new Color(50, 205, 50));
            jButton62.setBackground(new Color(50, 205, 50));
            jButton63.setBackground(new Color(50, 205, 50));
            jButton64.setBackground(new Color(50, 205, 50));
            jButton65.setBackground(new Color(50, 205, 50));
            jButton84.setBackground(new Color(50, 205, 50));
            jButton85.setBackground(new Color(50, 205, 50));
            jButton86.setBackground(new Color(50, 205, 50));
            jButton94.setBackground(new Color(50, 205, 50));
            jButton96.setBackground(new Color(50, 205, 50));
            jButton98.setBackground(new Color(50, 205, 50));
            jButton111.setBackground(new Color(50, 205, 50));
            jButton107.setBackground(new Color(50, 205, 50));
            jButton108.setBackground(new Color(50, 205, 50));
            jButton110.setBackground(new Color(50, 205, 50));
            jButton61.setBackground(new Color(50, 205, 50));
            jButton117.setBackground(new Color(50, 205, 50));
            jButton7.setBackground(new Color(50, 205, 50));
            jButton4.setBackground(new Color(50, 205, 50));
            BottoneCabina1.setBackground(new Color(50, 205, 50));
            RaccogliMana.setBackground(new Color(50, 205, 50));
            RaccogliLegno.setBackground(new Color(50, 205, 50));
            RaccogliFerro.setBackground(new Color(50, 205, 50));
            BottoneSilos.setBackground(new Color(50, 205, 50));
            BottoneShard.setBackground(new Color(50, 205, 50));
            BottoneGeyser.setBackground(new Color(50, 205, 50));
            BottoneLegname.setBackground(new Color(50, 205, 50));
            BottoneMagazzino.setBackground(new Color(50, 205, 50));
            BottoneSerbatoio.setBackground(new Color(50, 205, 50));
            BottoneCaveau.setBackground(new Color(50, 205, 50));
            BottonePezziTempo.setBackground(new Color(50, 205, 50));
            BottoneRicercatore.setBackground(new Color(50, 205, 50));
            jButton76.setBackground(new Color(50, 205, 50));
            jButton83.setBackground(new Color(50, 205, 50));
            jButton90.setBackground(new Color(50, 205, 50));
            jButton91.setBackground(new Color(50, 205, 50));
            jButton74.setBackground(new Color(50, 205, 50));
            jButton73.setBackground(new Color(50, 205, 50));
            jButton77.setBackground(new Color(50, 205, 50));
            jButton78.setBackground(new Color(50, 205, 50));
            jButton80.setBackground(new Color(50, 205, 50));
            jButton81.setBackground(new Color(50, 205, 50));
            jButton89.setBackground(new Color(50, 205, 50));
            jButton66.setBackground(new Color(50, 205, 50));
            jButton67.setBackground(new Color(50, 205, 50));
            jButton58.setBackground(new Color(50, 205, 50));
            jButton56.setBackground(new Color(50, 205, 50));
            jButton54.setBackground(new Color(50, 205, 50));
            jButton52.setBackground(new Color(50, 205, 50));
            jButton50.setBackground(new Color(50, 205, 50));
            jButton48.setBackground(new Color(50, 205, 50));
            jButton46.setBackground(new Color(50, 205, 50));
            jButton43.setBackground(new Color(50, 205, 50));
             jButton40.setBackground(new Color(50, 205, 50));
            jButton37.setBackground(new Color(50, 205, 50));
            jButton36.setBackground(new Color(50, 205, 50));
            jButton34.setBackground(new Color(50, 205, 50));
            jComboBox2.setBackground(new Color(50, 205, 50));
            jButton20.setBackground(new Color(50, 205, 50));
            jButton18.setBackground(new Color(50, 205, 50));
            jButton13.setBackground(new Color(50, 205, 50));
            jComboBox1.setBackground(new Color(50, 205, 50));
            jButton16.setBackground(new Color(50, 205, 50));
            jButton14.setBackground(new Color(50, 205, 50));
            PanelSuperioreG.setBackground(new Color(50, 205, 50));
        }
        }else if(Swichcolormanual==true){
            if(jComboBox2.getSelectedItem().equals("Elemento Primario")){
                Swichcolormanual=false;
                settColors();
        }else if(jComboBox2.getSelectedItem().equals("Fuoco")){
            jButton150.setBackground(new Color(255,0,0));
            jButton133.setBackground(new Color(255,0,0));
            jButton134.setBackground(new Color(255,0,0));
            jButton135.setBackground(new Color(255,0,0));
            jButton155.setBackground(new Color(255,0,0));
            jButton131.setBackground(new Color(255,0,0));
            jComboBox3.setBackground(new Color(255,0,0));
            jButton130.setBackground(new Color(255,0,0));
            jButton128.setBackground(new Color(255,0,0));
            jButton127.setBackground(new Color(255,0,0));
            jButton125.setBackground(new Color(255,0,0));
            jButton122.setBackground(new Color(255,0,0));
            jButton121.setBackground(new Color(255,0,0));
            jProgressBar2.setForeground(new Color(255,0,0));
            jButton113.setBackground(new Color(255,0,0));
            jButton10.setBackground(new Color(255,0,0));
            jButton11.setBackground(new Color(255,0,0));
            jButton22.setBackground(new Color(255,0,0));
            jButton23.setBackground(new Color(255,0,0));
            jButton24.setBackground(new Color(255,0,0));
            jButton44.setBackground(new Color(255,0,0));
            jButton45.setBackground(new Color(255,0,0));
            jButton60.setBackground(new Color(255,0,0));
            jButton87.setBackground(new Color(255,0,0));
            jButton92.setBackground(new Color(255,0,0));
            jButton93.setBackground(new Color(255,0,0));
            jButton100.setBackground(new Color(255,0,0));
            jButton101.setBackground(new Color(255,0,0));
            jButton103.setBackground(new Color(255,0,0));
            jButton105.setBackground(new Color(255,0,0));
            jButton62.setBackground(new Color(255,0,0));
            jButton63.setBackground(new Color(255,0,0));
            jButton64.setBackground(new Color(255,0,0));
            jButton65.setBackground(new Color(255,0,0));
            jButton84.setBackground(new Color(255,0,0));
            jButton85.setBackground(new Color(255,0,0));
            jButton86.setBackground(new Color(255,0,0));
            jButton94.setBackground(new Color(255,0,0));
            jButton96.setBackground(new Color(255,0,0));
            jButton98.setBackground(new Color(255,0,0));
            jButton111.setBackground(new Color(255,0,0));
            jButton107.setBackground(new Color(255,0,0));
            jButton108.setBackground(new Color(255,0,0));
            jButton110.setBackground(new Color(255,0,0));
            jButton61.setBackground(new Color(255,0,0));
            jButton117.setBackground(new Color(255,0,0));
            jButton7.setBackground(new Color(255,0,0));
            jButton4.setBackground(new Color(255,0,0));
            BottoneCabina1.setBackground(new Color(255,0,0));
            RaccogliMana.setBackground(new Color(255,0,0));
            RaccogliLegno.setBackground(new Color(255,0,0));
            RaccogliFerro.setBackground(new Color(255,0,0));
            BottoneSilos.setBackground(new Color(255,0,0));
            BottoneShard.setBackground(new Color(255,0,0));
            BottoneGeyser.setBackground(new Color(255,0,0));
            BottoneLegname.setBackground(new Color(255,0,0));
            BottoneMagazzino.setBackground(new Color(255,0,0));
            BottoneSerbatoio.setBackground(new Color(255,0,0));
            BottoneCaveau.setBackground(new Color(255,0,0));
            BottonePezziTempo.setBackground(new Color(255,0,0));
            BottoneRicercatore.setBackground(new Color(255,0,0));
            jButton76.setBackground(new Color(255,0,0));
            jButton83.setBackground(new Color(255,0,0));
            jButton90.setBackground(new Color(255,0,0));
            jButton91.setBackground(new Color(255,0,0));
            jButton74.setBackground(new Color(255,0,0));
            jButton73.setBackground(new Color(255,0,0));
            jButton77.setBackground(new Color(255,0,0));
            jButton78.setBackground(new Color(255,0,0));
            jButton80.setBackground(new Color(255,0,0));
            jButton81.setBackground(new Color(255,0,0));
            jButton89.setBackground(new Color(255,0,0));
            jButton66.setBackground(new Color(255,0,0));
            jButton67.setBackground(new Color(255,0,0));
            jButton58.setBackground(new Color(255,0,0));
            jButton56.setBackground(new Color(255,0,0));
            jButton54.setBackground(new Color(255,0,0));
            jButton52.setBackground(new Color(255,0,0));
            jButton50.setBackground(new Color(255,0,0));
            jButton48.setBackground(new Color(255,0,0));
            jButton46.setBackground(new Color(255,0,0));
            jButton43.setBackground(new Color(255,0,0));
            jButton40.setBackground(new Color(255,0,0));
            jButton37.setBackground(new Color(255,0,0));
            jButton36.setBackground(new Color(255,0,0));
            jButton34.setBackground(new Color(255,0,0));
            jComboBox2.setBackground(new Color(255,0,0));
            jButton20.setBackground(new Color(255,0,0));
            jButton18.setBackground(new Color(255,0,0));
            jButton13.setBackground(new Color(255,0,0));
            jComboBox1.setBackground(new Color(255,0,0));
            jButton16.setBackground(new Color(255,0,0));
            jButton14.setBackground(new Color(255,0,0));
            PanelSuperioreG.setBackground(new Color(255, 0, 0));
        }else if(jComboBox2.getSelectedItem().equals("Terra")){
            jButton150.setBackground(new Color(139, 69, 19));
            jButton133.setBackground(new Color(139, 69, 19));
            jButton134.setBackground(new Color(139, 69, 19));
            jButton135.setBackground(new Color(139, 69, 19));
            jButton155.setBackground(new Color(139, 69, 19));
            jButton131.setBackground(new Color(139, 69, 19));
            jComboBox3.setBackground(new Color(139, 69, 19));
            jButton130.setBackground(new Color(139, 69, 19));
           jButton128.setBackground(new Color(139, 69, 19));
            jButton127.setBackground(new Color(139, 69, 19));
            jButton125.setBackground(new Color(139, 69, 19));
            jButton122.setBackground(new Color(139, 69, 19));
            jButton121.setBackground(new Color(139, 69, 19));
            jProgressBar2.setForeground(new Color(139, 69, 19));
            jButton113.setBackground(new Color(139, 69, 19));
            jButton10.setBackground(new Color(139, 69, 19));
            jButton11.setBackground(new Color(139, 69, 19));
            jButton22.setBackground(new Color(139, 69, 19));
            jButton23.setBackground(new Color(139, 69, 19));
            jButton24.setBackground(new Color(139, 69, 19));
            jButton44.setBackground(new Color(139, 69, 19));
            jButton45.setBackground(new Color(139, 69, 19));
            jButton60.setBackground(new Color(139, 69, 19));
            jButton87.setBackground(new Color(139, 69, 19));
            jButton92.setBackground(new Color(139, 69, 19));
            jButton93.setBackground(new Color(139, 69, 19));
            jButton100.setBackground(new Color(139, 69, 19));
            jButton101.setBackground(new Color(139, 69, 19));
            jButton103.setBackground(new Color(139, 69, 19));
            jButton105.setBackground(new Color(139, 69, 19));
            jButton62.setBackground(new Color(139, 69, 19));
            jButton63.setBackground(new Color(139, 69, 19));
            jButton64.setBackground(new Color(139, 69, 19));
            jButton65.setBackground(new Color(139, 69, 19));
            jButton84.setBackground(new Color(139, 69, 19));
            jButton85.setBackground(new Color(139, 69, 19));
            jButton86.setBackground(new Color(139, 69, 19));
            jButton94.setBackground(new Color(139, 69, 19));
            jButton96.setBackground(new Color(139, 69, 19));
            jButton98.setBackground(new Color(139, 69, 19));
            jButton111.setBackground(new Color(139, 69, 19));
            jButton107.setBackground(new Color(139, 69, 19));
            jButton108.setBackground(new Color(139, 69, 19));
            jButton110.setBackground(new Color(139, 69, 19));
            jButton61.setBackground(new Color(139, 69, 19));
            jButton117.setBackground(new Color(139, 69, 19));
            jButton7.setBackground(new Color(139, 69, 19));
            jButton4.setBackground(new Color(139, 69, 19));
            BottoneCabina1.setBackground(new Color(139, 69, 19));
            RaccogliMana.setBackground(new Color(139, 69, 19));
            RaccogliLegno.setBackground(new Color(139, 69, 19));
            RaccogliFerro.setBackground(new Color(139, 69, 19));
            BottoneSilos.setBackground(new Color(139, 69, 19));
            BottoneShard.setBackground(new Color(139, 69, 19));
            BottoneGeyser.setBackground(new Color(139, 69, 19));
            BottoneLegname.setBackground(new Color(139, 69, 19));
            BottoneMagazzino.setBackground(new Color(139, 69, 19));
            BottoneSerbatoio.setBackground(new Color(139, 69, 19));
            BottoneCaveau.setBackground(new Color(139, 69, 19));
            BottonePezziTempo.setBackground(new Color(139, 69, 19));
            BottoneRicercatore.setBackground(new Color(139, 69, 19));
            jButton76.setBackground(new Color(139, 69, 19));
            jButton83.setBackground(new Color(139, 69, 19));
            jButton90.setBackground(new Color(139, 69, 19));
            jButton91.setBackground(new Color(139, 69, 19));
            jButton74.setBackground(new Color(139, 69, 19));
            jButton73.setBackground(new Color(139, 69, 19));
            jButton77.setBackground(new Color(139, 69, 19));
            jButton78.setBackground(new Color(139, 69, 19));
            jButton80.setBackground(new Color(139, 69, 19));
            jButton81.setBackground(new Color(139, 69, 19));
            jButton89.setBackground(new Color(139, 69, 19));
            jButton66.setBackground(new Color(139, 69, 19));
            jButton67.setBackground(new Color(139, 69, 19));
            jButton58.setBackground(new Color(139, 69, 19));
            jButton56.setBackground(new Color(139, 69, 19));
            jButton54.setBackground(new Color(139, 69, 19));
            jButton52.setBackground(new Color(139, 69, 19));
            jButton50.setBackground(new Color(139, 69, 19));
            jButton48.setBackground(new Color(139, 69, 19));
            jButton46.setBackground(new Color(139, 69, 19));
            jButton43.setBackground(new Color(139, 69, 19));
             jButton40.setBackground(new Color(139, 69, 19));
            jButton37.setBackground(new Color(139, 69, 19));
            jButton36.setBackground(new Color(139, 69, 19));
            jButton34.setBackground(new Color(139, 69, 19));
            jComboBox2.setBackground(new Color(139, 69, 19));
            jButton20.setBackground(new Color(139, 69, 19));
            jButton18.setBackground(new Color(139, 69, 19));
            jButton13.setBackground(new Color(139, 69, 19));
            jComboBox1.setBackground(new Color(139, 69, 19));
            jButton16.setBackground(new Color(139, 69, 19));
            jButton14.setBackground(new Color(139, 69, 19));
            PanelSuperioreG.setBackground(new Color(139, 69, 19));
        }else if(jComboBox2.getSelectedItem().equals("Acqua")){
            jButton150.setBackground(new Color(0, 122, 255));
            jButton133.setBackground(new Color(0, 122, 255));
            jButton134.setBackground(new Color(0, 122, 255));
            jButton135.setBackground(new Color(0, 122, 255));
            jButton155.setBackground(new Color(0, 122, 255));
            jButton131.setBackground(new Color(0, 122, 255));
            jComboBox3.setBackground(new Color(0, 122, 255));
            jButton130.setBackground(new Color(0, 122, 255));
             jButton128.setBackground(new Color(0, 122, 255));
            jButton127.setBackground(new Color(0, 122, 255));
            jButton125.setBackground(new Color(0, 122, 255));
            jButton122.setBackground(new Color(0, 122, 255));
            jButton121.setBackground(new Color(0, 122, 255));
            jProgressBar2.setForeground(new Color(0, 122, 255));
            jButton113.setBackground(new Color(0, 122, 255));
            jButton10.setBackground(new Color(0, 122, 255));
            jButton11.setBackground(new Color(0, 122, 255));
            jButton22.setBackground(new Color(0, 122, 255));
            jButton23.setBackground(new Color(0, 122, 255));
            jButton24.setBackground(new Color(0, 122, 255));
            jButton44.setBackground(new Color(0, 122, 255));
            jButton45.setBackground(new Color(0, 122, 255));
            jButton60.setBackground(new Color(0, 122, 255));
            jButton87.setBackground(new Color(0, 122, 255));
            jButton92.setBackground(new Color(0, 122, 255));
            jButton93.setBackground(new Color(0, 122, 255));
            jButton100.setBackground(new Color(0, 122, 255));
            jButton101.setBackground(new Color(0, 122, 255));
            jButton103.setBackground(new Color(0, 122, 255));
            jButton105.setBackground(new Color(0, 122, 255));
            jButton62.setBackground(new Color(0, 122, 255));
            jButton63.setBackground(new Color(0, 122, 255));
            jButton64.setBackground(new Color(0, 122, 255));
            jButton65.setBackground(new Color(0, 122, 255));
            jButton84.setBackground(new Color(0, 122, 255));
            jButton85.setBackground(new Color(0, 122, 255));
            jButton86.setBackground(new Color(0, 122, 255));
            jButton94.setBackground(new Color(0, 122, 255));
            jButton96.setBackground(new Color(0, 122, 255));
            jButton98.setBackground(new Color(0, 122, 255));
            jButton111.setBackground(new Color(0, 122, 255));
            jButton107.setBackground(new Color(0, 122, 255));
            jButton108.setBackground(new Color(0, 122, 255));
            jButton110.setBackground(new Color(0, 122, 255));
            jButton61.setBackground(new Color(0, 122, 255));
            jButton117.setBackground(new Color(0, 122, 255));
            jButton7.setBackground(new Color(0, 122, 255));
            jButton4.setBackground(new Color(0, 122, 255));
            BottoneCabina1.setBackground(new Color(0, 122, 255));
            RaccogliMana.setBackground(new Color(0, 122, 255));
            RaccogliLegno.setBackground(new Color(0, 122, 255));
            RaccogliFerro.setBackground(new Color(0, 122, 255));
            BottoneSilos.setBackground(new Color(0, 122, 255));
            BottoneShard.setBackground(new Color(0, 122, 255));
            BottoneGeyser.setBackground(new Color(0, 122, 255));
            BottoneLegname.setBackground(new Color(0, 122, 255));
            BottoneMagazzino.setBackground(new Color(0, 122, 255));
            BottoneSerbatoio.setBackground(new Color(0, 122, 255));
            BottoneCaveau.setBackground(new Color(0, 122, 255));
            BottonePezziTempo.setBackground(new Color(0, 122, 255));
            BottoneRicercatore.setBackground(new Color(0, 122, 255));
            jButton76.setBackground(new Color(0, 122, 255));
            jButton83.setBackground(new Color(0, 122, 255));
            jButton90.setBackground(new Color(0, 122, 255));
            jButton91.setBackground(new Color(0, 122, 255));
            jButton74.setBackground(new Color(0, 122, 255));
            jButton73.setBackground(new Color(0, 122, 255));
            jButton77.setBackground(new Color(0, 122, 255));
            jButton78.setBackground(new Color(0, 122, 255));
            jButton80.setBackground(new Color(0, 122, 255));
            jButton81.setBackground(new Color(0, 122, 255));
            jButton89.setBackground(new Color(0, 122, 255));
            jButton66.setBackground(new Color(0, 122, 255));
            jButton67.setBackground(new Color(0, 122, 255));
            jButton58.setBackground(new Color(0, 122, 255));
            jButton56.setBackground(new Color(0, 122, 255));
            jButton54.setBackground(new Color(0, 122, 255));
            jButton52.setBackground(new Color(0, 122, 255));
            jButton50.setBackground(new Color(0, 122, 255));
            jButton48.setBackground(new Color(0, 122, 255));
            jButton46.setBackground(new Color(0, 122, 255));
            jButton43.setBackground(new Color(0, 122, 255));
             jButton40.setBackground(new Color(0, 122, 255));
            jButton37.setBackground(new Color(0, 122, 255));
            jButton36.setBackground(new Color(0, 122, 255));
            jButton34.setBackground(new Color(0, 122, 255));
            jComboBox2.setBackground(new Color(0, 122, 255));
            jButton20.setBackground(new Color(0, 122, 255));
            jButton18.setBackground(new Color(0, 122, 255));
            jButton13.setBackground(new Color(0, 122, 255));
            jComboBox1.setBackground(new Color(0, 122, 255));
            jButton16.setBackground(new Color(0, 122, 255));
            jButton14.setBackground(new Color(0, 122, 255));
            PanelSuperioreG.setBackground(new Color(0, 122, 255));
        }else if(jComboBox2.getSelectedItem().equals("Aria")){
            jButton150.setBackground(new Color(50, 205, 50));
            jButton133.setBackground(new Color(50, 205, 50));
            jButton134.setBackground(new Color(50, 205, 50));
            jButton135.setBackground(new Color(50, 205, 50));
            jButton155.setBackground(new Color(50, 205, 50));
            jButton131.setBackground(new Color(50, 205, 50));
            jComboBox3.setBackground(new Color(50, 205, 50));
            jButton130.setBackground(new Color(50, 205, 50));
             jButton128.setBackground(new Color(50, 205, 50));
            jButton127.setBackground(new Color(50, 205, 50));
            jButton125.setBackground(new Color(50, 205, 50));
            jButton122.setBackground(new Color(50, 205, 50));
            jButton121.setBackground(new Color(50, 205, 50));
            jProgressBar2.setForeground(new Color(50, 205, 50));
            jButton113.setBackground(new Color(50, 205, 50));
            jButton10.setBackground(new Color(50, 205, 50));
            jButton11.setBackground(new Color(50, 205, 50));
            jButton22.setBackground(new Color(50, 205, 50));
            jButton23.setBackground(new Color(50, 205, 50));
            jButton24.setBackground(new Color(50, 205, 50));
            jButton44.setBackground(new Color(50, 205, 50));
            jButton45.setBackground(new Color(50, 205, 50));
            jButton60.setBackground(new Color(50, 205, 50));
            jButton87.setBackground(new Color(50, 205, 50));
            jButton92.setBackground(new Color(50, 205, 50));
            jButton93.setBackground(new Color(50, 205, 50));
            jButton100.setBackground(new Color(50, 205, 50));
            jButton101.setBackground(new Color(50, 205, 50));
            jButton103.setBackground(new Color(50, 205, 50));
            jButton105.setBackground(new Color(50, 205, 50));
            jButton62.setBackground(new Color(50, 205, 50));
            jButton63.setBackground(new Color(50, 205, 50));
            jButton64.setBackground(new Color(50, 205, 50));
            jButton65.setBackground(new Color(50, 205, 50));
            jButton84.setBackground(new Color(50, 205, 50));
            jButton85.setBackground(new Color(50, 205, 50));
            jButton86.setBackground(new Color(50, 205, 50));
            jButton94.setBackground(new Color(50, 205, 50));
            jButton96.setBackground(new Color(50, 205, 50));
            jButton98.setBackground(new Color(50, 205, 50));
            jButton111.setBackground(new Color(50, 205, 50));
            jButton107.setBackground(new Color(50, 205, 50));
            jButton108.setBackground(new Color(50, 205, 50));
            jButton110.setBackground(new Color(50, 205, 50));
            jButton61.setBackground(new Color(50, 205, 50));
            jButton117.setBackground(new Color(50, 205, 50));
            jButton7.setBackground(new Color(50, 205, 50));
            jButton4.setBackground(new Color(50, 205, 50));
            BottoneCabina1.setBackground(new Color(50, 205, 50));
            RaccogliMana.setBackground(new Color(50, 205, 50));
            RaccogliLegno.setBackground(new Color(50, 205, 50));
            RaccogliFerro.setBackground(new Color(50, 205, 50));
            BottoneSilos.setBackground(new Color(50, 205, 50));
            BottoneShard.setBackground(new Color(50, 205, 50));
            BottoneGeyser.setBackground(new Color(50, 205, 50));
            BottoneLegname.setBackground(new Color(50, 205, 50));
            BottoneMagazzino.setBackground(new Color(50, 205, 50));
            BottoneSerbatoio.setBackground(new Color(50, 205, 50));
            BottoneCaveau.setBackground(new Color(50, 205, 50));
            BottonePezziTempo.setBackground(new Color(50, 205, 50));
            BottoneRicercatore.setBackground(new Color(50, 205, 50));
            jButton76.setBackground(new Color(50, 205, 50));
            jButton83.setBackground(new Color(50, 205, 50));
            jButton90.setBackground(new Color(50, 205, 50));
            jButton91.setBackground(new Color(50, 205, 50));
            jButton74.setBackground(new Color(50, 205, 50));
            jButton73.setBackground(new Color(50, 205, 50));
            jButton77.setBackground(new Color(50, 205, 50));
            jButton78.setBackground(new Color(50, 205, 50));
            jButton80.setBackground(new Color(50, 205, 50));
            jButton81.setBackground(new Color(50, 205, 50));
            jButton89.setBackground(new Color(50, 205, 50));
            jButton66.setBackground(new Color(50, 205, 50));
            jButton67.setBackground(new Color(50, 205, 50));
            jButton58.setBackground(new Color(50, 205, 50));
            jButton56.setBackground(new Color(50, 205, 50));
            jButton54.setBackground(new Color(50, 205, 50));
            jButton52.setBackground(new Color(50, 205, 50));
            jButton50.setBackground(new Color(50, 205, 50));
            jButton48.setBackground(new Color(50, 205, 50));
            jButton46.setBackground(new Color(50, 205, 50));
            jButton43.setBackground(new Color(50, 205, 50));
             jButton40.setBackground(new Color(50, 205, 50));
            jButton37.setBackground(new Color(50, 205, 50));
            jButton36.setBackground(new Color(50, 205, 50));
            jButton34.setBackground(new Color(50, 205, 50));
            jComboBox2.setBackground(new Color(50, 205, 50));
            jButton20.setBackground(new Color(50, 205, 50));
            jButton18.setBackground(new Color(50, 205, 50));
            jButton13.setBackground(new Color(50, 205, 50));
            jComboBox1.setBackground(new Color(50, 205, 50));
            jButton16.setBackground(new Color(50, 205, 50));
            jButton14.setBackground(new Color(50, 205, 50));
            PanelSuperioreG.setBackground(new Color(50, 205, 50));
        }
        }
       
    }
    public void schermataLivello(){
        if(gioco.getDataGame().getExpEvocazioneA()==true){
           JOptionPane.showMessageDialog(this, "congratulazioni!\n Il tuo livello Evocazione è ora "+gioco.getDataGame().getLivelloAttualeEvocazione()+"!","Livello Evocazione Aumentato!",JOptionPane.INFORMATION_MESSAGE);
           gioco.getDataGame().setExpEvocazioneA(false);
        }
        if(gioco.getDataGame().getExpIllusioneA()==true){
           JOptionPane.showMessageDialog(this, "congratulazioni!\n Il tuo livello Illusione è ora "+gioco.getDataGame().getLivelloAttualeIllusione()+"!","Livello Illusione Aumentato!",JOptionPane.INFORMATION_MESSAGE);
            gioco.getDataGame().setExpIllusioneA(false);
        }
        if(gioco.getDataGame().getExpIncantesimoA()==true){
           JOptionPane.showMessageDialog(this, "congratulazioni!\n Il tuo livello Incantesimo è ora "+gioco.getDataGame().getLivelloAttualeIncanto()+"!","Livello Incanto Aumentato!",JOptionPane.INFORMATION_MESSAGE);
            gioco.getDataGame().setExpIncantesimoA(false);
        }
    }
    public void setTestoLabel(){
        jLabel277.setForeground(new Color(204,204,0));
        jLabel244.setText("<html><p>Crea uno spettacolo di intrattenimento di base basato su piccole illusioni. +30~36</p></html>");
        jLabel116.setText("<html><p>Materializza una barra di ferro. +80⛓</p></html>");
        jLabel114.setText("<html><p>Crea una roccia gigante e aumenta le tue riserve di Pietra. +1200🪨</p></html>");
        jLabel115.setText("<html><p>Converti il Mana in una grande quantità di acqua. +420🌢</p></html>");
        jLabel113.setText("<html><p>Materializza un pezzo di minerale di ferro. +5⛓</p></html>");
        jLabel219.setText("<html><p>Un forno con una fiamma molto calda. Utile per l'artigianato +2🔥/sec,-3🪵/sec,+500 Max🔥</p></html>");
        jLabel214.setText("<html><p>Usa la magia per applicare i tuoi materiali correnti alla costruzione di un edificio casuale. Costruisci un edificio casuale tra quelli che possono essere costruiti.</p></html>");
        jLabel204.setText("<html><p>Usa i tuoi pezzi del tempo per deformare il tempo, influenzando ogni aspetto del gioco. Sposta il tempo in avanti di 10 minuti (Mondo reale)</p></html>");
        jLabel28.setText("<html><p>Alloggi per ricercatori che vivono nel campus. +1 Max Ricercatori</p></html>");
        jLabel34.setText("<html><p>Alloggi per ricercatori che vivono nel campus. +1 Max Ricercatori</p></html>");
        jLabel140.setText("<html><p>Alloggi per apprendisti, che possono aiutare a lanciare incantesimi. +1 Apprendisti massimi</p></html>");
        jLabel43.setText("<html><p>Alloggi per apprendisti, che possono aiutare a lanciare incantesimi. +1 Apprendisti massimi</p></html>");
        jLabel185.setVisible(false);
        jLabel186.setVisible(false);
        jLabel165.setText("<html><p>Usa i tuoi timepiece per fare ricerche. Richiede almeno un ricercatore attivo. Ottieni subito 25 minuti (tempo reale) di ricerca.</p></html>");
        jLabel158.setText("<html><p>Assumi un nuovo ricercatore per ottenere esperienza magica più velocemente. +1 Ricercatore</p></html>");
        TestoTempo.setText("<html><p>Usa i tuoi timepiece per fare ricerche. Richiede almeno un ricercatore attivo. Ottieni subito 25 minuti (tempo reale) di ricerca.</p></html>");
        jLabel151.setText("<html><p>Il pensionamento nel gioco offre numerosi vantaggi. Quando decidi di pensionarti, il gioco si riavvia con una nuova scuola primaria e un nuovo elemento, registrando permanentemente il livello massimo della scuola primaria, chiamato Maximum Primary Level (MPL). Questo livello massimo contribuisce a determinare il Global Research Multiplier e il Global Production Multiplier, che migliorano rispettivamente l'efficacia della ricerca e la produzione di risorse. I moltiplicatori globali sono influenzati dal MPL massimo raggiunto e dalla somma di tutti i MPL delle scuole. Inoltre, i benefici delle Storylines persistono anche attraverso i pensionamenti. Il pensionamento è consigliato quando il progresso nel gioco rallenta o quando i moltiplicatori risultano significativamente aumentati.</p></html>");
        jLabel149.setText("<html><p>Nella schermata di Ricerca, puoi assegnare i ricercatori che hai assunto per svolgere studi sulle scuole di magia. Ogni ricercatore produce una quantità fissa di esperienza scolastica per secondo. La ricerca risulta essere un metodo significativamente più efficace per avanzare nei livelli delle scuole rispetto al semplice lancio di incantesimi, e la sua efficienza aumenta man mano che progredisci nel gioco.</p></html>");
        jLabel147.setText("<html><p>Quando trascorri del tempo lontano dal gioco, guadagnerai una risorsa chiamata ⏲ Time Pieces. Questa risorsa serve come modo per recuperare parte del tempo perso lontano dal gioco. Come regola generale, per ogni secondo trascorso lontano dal gioco, guadagnerai 1⏲. Ad esempio, essere lontano per 8 ore ti farà guadagnare 28.8K⏲ una volta che riapri il gioco. Ci sono diversi modi per utilizzare questa risorsa. Il primo è aumentare la velocità del gioco a un costo di 3 a 4⏲/sec. Puoi attivarlo dal menu a sinistra. Il secondo si chiama \"Use Time Pieces (Warp)\" e ti permette di spendere 3000⏲ per saltare avanti di 10 minuti di gioco. Puoi farlo dalla schermata Campus. L'ultimo si chiama \"Use Time Pieces (Research)\" e ti permette di spendere 3000⏲ in una volta per ottenere 25 minuti reali di Ricerca. Puoi farlo nella schermata Campus o Ricerca. Il modo migliore per utilizzare i Time Pieces dipende dalla tua situazione attuale. Aumentare la velocità del gioco è abbastanza economico e può far passare tutti gli aspetti del gioco molto più velocemente. Se non hai abbastanza tempo per giocare attivamente, Warp può aiutarti a fare molti progressi in poco tempo, specialmente se prepari il gioco per essere efficace senza dover agire manualmente. 10 minuti reali possono darti un grande impulso, quindi potresti doverlo usare solo una o due volte per raggiungere l'obiettivo che stai cercando. D'altra parte, se vuoi sbloccare incantesimi più velocemente e non hai bisogno di altri tipi di progressi, usare ⏲ per la Ricerca è efficace e può anche aiutarti a fare progressi significativi a un costo inferiore.</p></html>");
        jLabel143.setText("<html><p>Modifica magicamente i tuoi Geyser di mana per produrre più mana per un periodo di tempo limitato. 2x★ prodotti dai Geyser di mana per 20 sec</p></html>");
        jLabel142.setText("<html><p>Modifica magicamente i tuoi depositi di legname per farli lavorare più velocemente per un periodo di tempo limitato. 2x🪵 prodotti dai depositi di legname per 30 sec</p></html>");
        TestoCaveau.setText("<html><p>consente di conservare più monete in modo sicuro. +20K Max🪙</p></html>");
        TestoFerro.setText("<html><p>Estrarre il ferro. +0,10⛓</p></html>");
        TestoGeyser.setText("<html><p>Un edificio rinforzato in metallo che produce mana. +2★/s</p></html>");
        jLabel119.setText("<html><p>Crea uno spettacolo di intrattenimento impressionante basato sul fuoco. +2000~2800🪙</p></html>");
        jLabel118.setText("<html><p>creare uno spettacolo di intrattenimento basato sulle bolle. +350~450🪙</p></html>");
        jLabel117.setText("<html><p>creare uno spettacolo di intrattenimento basato sulle raffiche di vento. +100~150🪙</p></html>");
         TestoSerbatoio.setText("<html><p>consente di accumulare acqua. +250🌢</p></html>");
        jLabel103.setText("<html><p><span style=\"color: red;\"Attenzione: hai ancora eventi in corso! Sei sicuro di voler ritirarti?</span></p></html>");
        jLabel102.setText("<html><p><span style=\"color: red;\">Attenzione: sembra che tu abbia ancora molti Time Pieces inutilizzati! Considera di usarli con \"Use Time Pieces (Research)\" (o in altri modi) prima di ritirarti, poiché andranno persi quando ti ritiri!</span>.</p></html>");
        jLabel101.setText("<html><p>Hai accumulato abbastanza conoscenza da sentire che potrebbe essere sufficiente. Consideri il pensionamento.\n" +
        "\n" +
    "Se ti ritiri, resetterai il gioco. Tutto tornerà al suo stato iniziale, eccetto:\n" +
    "- Qualsiasi scuola o elemento sbloccato rimarrà sbloccato;\n" +
    "- Qualsiasi bonus ottenuto da \"(Storyline)\" rimarrà;\n" +
    "- Otterrai un aumento nella ricerca, produzione di edifici e bottino basato sul livello massimo che hai mai raggiunto nella tua scuola primaria (MPL), così come sulla somma degli MPL che hai raggiunto in ogni scuola che hai sbloccato.\n" +
    "\n" +
    "Quando ti ritiri, potrai scegliere una nuova scuola primaria ed elemento.</p></html>");
        jLabel99.setText("<html><p>Convertire il Mana in un pezzo d'acqua più grande. +35🌢</p></html>");
        jLabel98.setText("<html><p>crea una roccia più grande per ottenere molta pietra +90</p></html>");
        jLabel88.setText("<html><p>Puoi importare i dati di salvataggio caricandoli da un file o incollandoli nell'apposito campo.</p><span style=\"color: red;\">ATTENZIONE: questa operazione sovrascriverà i tuoi dati di salvataggio attuali! Assicurati di aver effettuato un backup prima di procedere.</span></html>");
        jLabel86.setText("<html><p>Puoi salvare i tuoi dati direttamente in un file o altrove. Per farlo, nella schermata Opzioni del gioco, puoi utilizzare la funzione di esportazione dei salvataggi per creare un file che potrai conservare dove preferisci. Questo ti permette di avere un backup dei tuoi progressi o di trasferirli tra dispositivi diversi.​</p></html>");
        jLabel83.setText("<html><p>Per impostazione predefinita, il gioco modifica i colori dei pulsanti e dell'interfaccia in base all'elemento scelto. Se preferisci, puoi configurare l'interfaccia in modo che i pulsanti mantengano sempre l'aspetto dell'elemento di tua scelta.</p></html>");
        jLabel79.setText("<html><p>​Nella schermata Opzioni, puoi configurare il gioco ed esportare o importare i tuoi salvataggi; per esportare, premi \"Copia dati di salvataggio negli appunti\" e incolla il testo in un documento come backup, oppure utilizza \"Salva su file\" per creare un file di salvataggio; per importare, incolla il testo precedentemente esportato nel campo dedicato o carica un file di salvataggio; l'interfaccia si aggiornerà immediatamente, ma attenzione: l'importazione sovrascriverà i dati attuali, quindi assicurati di esportarli e conservarli in un luogo sicuro prima di procedere.</p></html>");
        jLabel77.setText("<html><p>Nella schermata delle Statistiche, puoi visualizzare una serie di dati relativi alla tua partita, come il tempo totale di gioco, i livelli massimi raggiunti nelle scuole primarie e il numero di Storyline completate.</p></html>");
        jLabel75.setText("<html><p>​Le Storyline sono eventi speciali che, come gli altri eventi, possono verificarsi casualmente o in seguito a determinate azioni, ma sono spesso più rare e difficili da incontrare. Ogni Storyline è generalmente indipendente dalle altre, quindi, anche se hai un evento Storyline in sospeso, potresti comunque imbatterti in altre Storyline, sia casualmente che in altri modi. Completare una Storyline offre benefici permanenti significativi; pertanto, è consigliabile portarle a termine quando possibile, poiché possono influenzare profondamente il modo in cui si sviluppa il gioco. Le Storyline forniscono esclusivamente vantaggi, senza alcun aspetto negativo. Se all'interno di una Storyline ti viene presentata una scelta, potrai effettuare una decisione diversa in una successiva partita dopo il pensionamento, ottenendo eventualmente un finale differente con un beneficio diverso. I bonus derivanti dalle Storyline completate rimangono permanenti, anche se completi nuovamente la stessa Storyline con un finale diverso. Le Storyline rappresentano il progresso nel gioco e uno degli obiettivi principali è completarle tutte. Puoi monitorare i tuoi progressi nel completamento delle Storyline nel menu Statistiche.</p></html>");
        jLabel73.setText("<html><p>Nella schermata del Campus, puoi eseguire un numero limitato di azioni, come raccogliere Mana o utilizzare le tue risorse per costruire edifici.<br>Risorse<br>Nella parte inferiore di questa schermata, puoi anche vedere il tuo obiettivo attuale; se non sei sicuro di cosa fare dopo, puoi seguire le indicazioni fornite.</p></html>");
        jLabel71.setText("<html><p>Gli incantesimi sono il tuo modo principale di interagire con il gioco; di solito li lanci dal menu degli incantesimi e costano una certa quantità di &#9733;, per questo motivo &#9733; è la risorsa più importante del gioco; puoi ottenere Mana raccogliendolo manualmente nel tuo Campus oppure tramite edifici come i Mana Spouts; gli incantesimi sono suddivisi in scuole di magia che raggruppano gli incantesimi per tema e ne esistono tre: Conjuration, che ti permette principalmente di creare risorse come &#x1FAA8; e &#x1F4A7;, Enchantment, che ti consente di migliorare le prestazioni dei tuoi edifici, e Illusion, che ti permette di ottenere più &#x1FA99; (o sono davvero solo queste tre...?); utilizzare incantesimi di una determinata scuola ti darà esperienza in quella scuola e, col tempo, il livello della scuola aumenterà sbloccando solitamente nuovi incantesimi; all'inizio del gioco hai scelto una scuola primaria di magia e sarà più semplice far salire di livello questa scuola primaria, il che significa che probabilmente sbloccherai incantesimi più avanzati per essa più rapidamente rispetto alle altre.</p></html>");
        jLabel69.setText("<html><p>Gli eventi sono accadimenti che si verificano casualmente nel tempo oppure quando succede qualcosa di specifico. Saprai che si è verificato un evento perché comparirà un dialogo che coprirà lo schermo. Puoi visualizzare l'elenco degli eventi accedendo al menu degli eventi, premendo il pulsante della campana delle notifiche in alto a destra dello schermo. Cliccando su un evento, vedrai l'ultimo messaggio relativo a quell'evento e potrai controllare i messaggi precedenti usando le frecce poste in alto nel dialogo. Gli eventi sono molto importanti nel gioco, poiché la maggior parte dei progressi avviene attraverso eventi che si attivano quando determinate azioni vengono compiute. Gli eventi possono essere o Completati o In Corso. Gli eventi completati non richiedono ulteriori azioni da parte tua, mentre gli eventi in corso indicano che per qualche motivo non hai ancora raggiunto la loro conclusione. Se possibile, dovresti cercare di completare tutti gli eventi in corso. Se ci sono eventi in corso, l'icona della campana delle notifiche mostrerà un numero in rosso per indicarlo. Esiste un tipo speciale di evento chiamato Storyline. Questi eventi sono particolarmente importanti: tienili d'occhio e cerca di completarli il più possibile.</p></html>");
        jLabel67.setText("<html><p>In Magic Research sei il preside di un'istituzione magica. Lancia incantesimi, accumula risorse, costruisci edifici e molto altro per guadagnare prestigio e creare la migliore scuola di magia del mondo! Nell'angolo in alto a sinistra troverai il pulsante del menu, che ti mostra una panoramica delle risorse attuali e ti permette di accedere alle varie aree del gioco. Nell'angolo in alto a destra trovi il pulsante della campana delle notifiche, che ti conduce alla lista degli eventi recenti, offrendoti maggiori informazioni su di essi o la possibilità di interagire con essi. L'altro pulsante importante si trova solitamente nell'angolo in basso a destra: il pulsante della bacchetta magica. Questo ti porta al menu della magia, dove puoi lanciare ogni incantesimo che hai imparato. A seconda della dimensione dello schermo, alcuni di questi pulsanti potrebbero trovarsi in posizioni diverse o i menu che aprono potrebbero essere sempre visibili.</p></html>");
        TestoLegname.setText("<html><p>Elabora rami e alberi, generando automaticamente legno. +1 &#129717;/sec</p></html>");
        jLabel57.setText("<html><p>Modifica magicamente i tuoi getti di mana per produrre più mana per un periodo di tempo limitato. 2X &#9733; prodotto da Beccuccio di mana per 30 sec</p></html>");
        jLabel54.setText("<html><p>Converti Mana in qualche goccia di acqua.+2🌢<p></html>");
        jPanel16.add(barra,BorderLayout.SOUTH);
        TestoShard.setText("<html><p>Aumenta la quantità di mana che puoi immagazzinare. +100 Max mana</p></html>");
        TestoSilos.setText("<html><p>Genera automaticamente Mana e ricarica la tua scorta. +0.50/sec</p></html>");
        TestoLegno.setText("<html><p>Raccogliete rami dalla foresta vicina. +1🪵</p></html>");
        TestoMana.setText("<html><p>Concentra i tuoi pensieri e raccogli mana. +1★</p></html>");
        jLabel13.setText("<html><h5>Scuole</h5></html>");
        jLabel5.setText("<html><h5>Risorse</h5></html>");
        TEsto.setText("Magical Research");
        barra.setUI(new javax.swing.plaf.basic.BasicProgressBarUI());
        barra.setStringPainted(true);
        barra.setForeground(new Color(0, 122, 255));
        barra.setBackground(new Color(0, 0, 145));
        barra.setString("★"+ gioco.getDataGame().getMana() + "/" + gioco.getDataGame().getMaxMana());
    }
    public void SetGioco() {
        timerGenerale.start();
        caricaInventario();
        caricaEquipaggiamento();
        setIcone();
        LivelliUpdateGUI();
        setVisibilitàRisorse();
        Panelli();
        setTestoLabel();
        setProgressBarTextColor(barra, Color.WHITE);
        ((CardLayout)jPanel12.getLayout()).show(jPanel12, "CardPrincipale");
        
    }
    public void Setintro() {
        btnApriFile.setBackground(new Color(0, 122, 255));
        EvocazioneB.setBackground(new Color(0, 122, 255));
        IncantoB.setBackground(new Color(0, 122, 255));
        IllusioneB.setBackground(new Color(0, 122, 255));
        FuocoB.setBackground(new Color(0, 122, 255));
        AcquaB.setBackground(new Color(0, 122, 255));
        TerraB.setBackground(new Color(0, 122, 255));
        AriaB.setBackground(new Color(0, 122, 255));
        setProgressBarTextColor(barra, Color.WHITE);
        FuocoB.setActionCommand("Fuoco");
        AcquaB.setActionCommand("Acqua");
        TerraB.setActionCommand("Terra");
        AriaB.setActionCommand("Aria");
        EvocazioneB.setActionCommand("Evocazione");
        IncantoB.setActionCommand("Incanto");
        IllusioneB.setActionCommand("Illusione");
        IB.setEnabled(false);
        LIE.setText("<html><p>Scegli un elemento primario.</p></html>");
        LSD.setVisible(false);
        LSD.setText("");
        LDE.setVisible(false);
        LDE.setText("");
        jPanel2.setBackground(new Color(0,122,255));
        TS.setText("<html><h4>Scuole</h4></html>");
        LIS.setText("<html><p>Scegli una scuola primaria di magia. Se è la tua prima volta a giocare, si consiglia di scegliere l'evocazione</p></html>");
        jLabel2.setText("<html><h1>Benvenuto in Magical Research!</h1>"
                + "<p>In Magical Research, sei il preside di un'istituzione magica. Quali avventure ti aspettano? Prima di iniziare, "
                + "dovrai scegliere una scuola primaria di magia e un elemento primario. "
                + "La scelta del tuo elemento primario potrebbe influenzare la disponibilità e gli effetti di vari incantesimi. "
                + "Potrai cambiare queste scelte (tramite il ritiro) più avanti nel gioco.</p>"
                + "</html>");
    }
    public void SetRisorse(){
        aggionoLabelCreaItem();
        jButton89.setText("Assumere un Ricercatore(🪙"+gioco.getDataGame().getRisorsaNecessariaMoneteRicercatore()+")");
        if(gioco.getDataGame().getForno()!=0){
            jButton125.setText("Forno("+gioco.getDataGame().getFornoAttivi()+"/"+gioco.getDataGame().getForno()+")(🪙"+formatta(gioco.getDataGame().getRisorsaNecessariaMoneteForno())+" 🪨"+formatta(gioco.getDataGame().getRisorsaNecessariaPietraForno())+" ⛓"+formatta(gioco.getDataGame().getRisorsaNecessariaFerroForno())+")");
        }else{
            jButton125.setText("Forno(🪙"+formatta(gioco.getDataGame().getRisorsaNecessariaMoneteForno())+" 🪨"+formatta(gioco.getDataGame().getRisorsaNecessariaPietraForno())+" ⛓"+formatta(gioco.getDataGame().getRisorsaNecessariaFerroForno())+")");
        }
        if(gioco.getDataGame().getApprendisti()!=0){
            jButton117.setText("Dormitorio per Apprendisti("+gioco.getDataGame().getApprendisti()+")(🪙"+formatta(gioco.getDataGame().getRisorsaNecessariaMoneteApprendista())+" 🪵"+formatta(gioco.getDataGame().getRisorsaNecessariaLegnoApprendista())+" 🪨"+formatta(gioco.getDataGame().getRisorsanecessariaPietraApprendista())+")");
            jButton7.setText("Dormitorio per Apprendisti("+gioco.getDataGame().getApprendisti()+")(🪙"+formatta(gioco.getDataGame().getRisorsaNecessariaMoneteApprendista())+" 🪵"+formatta(gioco.getDataGame().getRisorsaNecessariaLegnoApprendista())+" 🪨"+formatta(gioco.getDataGame().getRisorsanecessariaPietraApprendista())+")");
        }else{
            jButton117.setText("Dormitorio per Apprendisti(🪙"+formatta(gioco.getDataGame().getRisorsaNecessariaMoneteApprendista())+" 🪵"+formatta(gioco.getDataGame().getRisorsaNecessariaLegnoApprendista())+" 🪨"+formatta(gioco.getDataGame().getRisorsanecessariaPietraApprendista())+")");
            jButton7.setText("Dormitorio per Apprendisti(🪙"+formatta(gioco.getDataGame().getRisorsaNecessariaMoneteApprendista())+" 🪵"+formatta(gioco.getDataGame().getRisorsaNecessariaLegnoApprendista())+" 🪨"+formatta(gioco.getDataGame().getRisorsanecessariaPietraApprendista())+")");
        }
        if(gioco.getDataGame().isLegnoVisibile()){
            TestoMagazzino.setText("Aumenta il massimo delle risorse che puoi immagazzinare. +400🪨,+400🪵");
        }else if(gioco.getDataGame().isLegnoVisibile()&& gioco.getDataGame().isFerroVisibile()){
            TestoMagazzino.setText("Aumenta il massimo delle risorse che puoi immagazzinare. +400🪨,+400🪵,+200⛓");
        }else{
            TestoMagazzino.setText("Aumenta il massimo delle risorse che puoi immagazzinare. +400🪨");
        }
        if(gioco.getDataGame().getCapacitàRicercatore()!=1){
            BottoneCabina1.setText("Cabina del Ricercatore("+gioco.getDataGame().getCapacitàRicercatore()+")(🪙"+formatta(gioco.getDataGame().getRisorsaNecessariaMoneteCabinaR())+" 🪵"+formatta(gioco.getDataGame().getRisorsaNecessariaLegnoCabinaR())+" 🪨"+formatta(gioco.getDataGame().getRisorsaNecessariaPietraCabinaR())+")");
            jButton4.setText("Cabina del Ricercatore("+gioco.getDataGame().getCapacitàRicercatore()+")(🪙"+formatta(gioco.getDataGame().getRisorsaNecessariaMoneteCabinaR())+" 🪵"+formatta(gioco.getDataGame().getRisorsaNecessariaLegnoCabinaR())+" 🪨"+formatta(gioco.getDataGame().getRisorsaNecessariaPietraCabinaR())+")");
        }else{
            BottoneCabina1.setText("Cabina del Ricercatore(🪙"+formatta(gioco.getDataGame().getRisorsaNecessariaMoneteCabinaR())+" 🪵"+formatta(gioco.getDataGame().getRisorsaNecessariaLegnoCabinaR())+" 🪨"+formatta(gioco.getDataGame().getRisorsaNecessariaPietraCabinaR())+")");
            jButton4.setText("Cabina del Ricercatore(🪙"+formatta(gioco.getDataGame().getRisorsaNecessariaMoneteCabinaR())+" 🪵"+formatta(gioco.getDataGame().getRisorsaNecessariaLegnoCabinaR())+" 🪨"+formatta(gioco.getDataGame().getRisorsaNecessariaPietraCabinaR())+")");
        }
        if(gioco.getDataGame().getMagazzino() != 0){
        BottoneMagazzino.setText("Magazzino("+gioco.getDataGame().getMagazzino()+")(🪙"+formatta(gioco.getDataGame().getRisorsaNecessariaMoneteMagazzino())+" 🪨"+formatta(gioco.getDataGame().getRisorsaNecessariaPietraMagazzino())+")");
    }else{
        BottoneMagazzino.setText("Magazzino(🪙"+formatta(gioco.getDataGame().getRisorsaNecessariaMoneteMagazzino())+" 🪨"+formatta(gioco.getDataGame().getRisorsaNecessariaPietraMagazzino())+")");
        }
    if(gioco.getDataGame().getDepositoLegno() != 0){
        BottoneLegname.setText("Deposito di Legname("+gioco.getDataGame().getDepositoLegno()+")(★200 🪵"+formatta(gioco.getDataGame().getRisorsaNecessariaLegnoLegname())+" 🪨"+formatta(gioco.getDataGame().getRisorsaNecessariaPietraLegname())+")");
    }else{
        BottoneLegname.setText("Deposito di Legname(★200 🪵"+formatta(gioco.getDataGame().getRisorsaNecessariaLegnoLegname())+" 🪨"+formatta(gioco.getDataGame().getRisorsaNecessariaPietraLegname())+")");
    }
    if(gioco.getDataGame().getCaveau() != 0){
        BottoneCaveau.setText("Caveau("+gioco.getDataGame().getCaveau()+")(🪙"+formatta(gioco.getDataGame().getRisorsaNecessariaMoneteVault())+" 🪨"+formatta(gioco.getDataGame().getRisorsaNecessariaPietraVault())+")");
    }else{
        BottoneCaveau.setText("Caveau(🪙"+formatta(gioco.getDataGame().getRisorsaNecessariaMoneteVault())+" 🪨"+formatta(gioco.getDataGame().getRisorsaNecessariaPietraVault())+")");
    }
    if(gioco.getDataGame().getGeyser() != 0){
        BottoneGeyser.setText("Geyser di Mana("+gioco.getDataGame().getGeyser()+")(🪙"+formatta(gioco.getDataGame().getRisorsaNecessariaMoneteGeyser())+" 🌢"+formatta(gioco.getDataGame().getRisorsaNecessariaAcquaGeyser())+" ⛓"+formatta(gioco.getDataGame().getRisorsaNecessariaFerroGeyser())+")");
    }else{
        BottoneGeyser.setText("Geyser di Mana(🪙"+formatta(gioco.getDataGame().getRisorsaNecessariaMoneteGeyser())+" 🌢"+formatta(gioco.getDataGame().getRisorsaNecessariaAcquaGeyser())+" ⛓"+formatta(gioco.getDataGame().getRisorsaNecessariaFerroGeyser())+")");
    }
    if(gioco.getDataGame().getSilos() != 0){
        BottoneSilos.setText("Beccuccio di Mana("+gioco.getDataGame().getSilos()+")(🪨"+formatta(gioco.getDataGame().getRisorsaNecesariaSilosPietra())+" 🌢"+formatta(gioco.getDataGame().getRisorsaNecesariaSilosAcqua())+")");
    }else{
        BottoneSilos.setText("Beccuccio di Mana(🪨"+formatta(gioco.getDataGame().getRisorsaNecesariaSilosPietra())+" 🌢"+formatta(gioco.getDataGame().getRisorsaNecesariaSilosAcqua())+")");
    }
    
    if(gioco.getDataGame().getManaShard() != 0){
        BottoneShard.setText("Frammento di Mana("+gioco.getDataGame().getManaShard()+")(🪙"+formatta(gioco.getDataGame().getRisorsaNecesariaFrammentoMana())+")");
    }else{
        BottoneShard.setText("Frammento di Mana(🪙"+formatta(gioco.getDataGame().getRisorsaNecesariaFrammentoMana())+")");
    }
    if(gioco.getDataGame().getSerbatoioAcqua() !=0){
        BottoneSerbatoio.setText("Serbatoio dell'Acqua("+gioco.getDataGame().getSerbatoioAcqua()+")(🪙"+formatta(gioco.getDataGame().getRisorsaNecessariaMoneteSerbatoioAcqua())+" 🪵"+formatta(gioco.getDataGame().getRisorsaNecessariaLegnoSerbatoioAcqua())+" 🪨"+formatta(gioco.getDataGame().getRisorsaNecessariaPietraSerbatoioAcqua())+")");
    }else{
        BottoneSerbatoio.setText("Serbatoio dell'Acqua(🪙"+formatta(gioco.getDataGame().getRisorsaNecessariaMoneteSerbatoioAcqua())+" 🪵"+formatta(gioco.getDataGame().getRisorsaNecessariaLegnoSerbatoioAcqua())+" 🪨"+formatta(gioco.getDataGame().getRisorsaNecessariaPietraSerbatoioAcqua())+")");
    }
        jLabel276.setVisible(gioco.getDataGame().getApprendistiFuoco()>0);
        jLabel276.setText("("+gioco.getDataGame().getCalcoloTempoSpettacoloFuoco()+"s/cast)");
        jLabel192.setText(""+gioco.getDataGame().getApprendistiFuoco());
        jLabel137.setText(""+gioco.getDataGame().getApprendistiBolle());
        jLabel275.setVisible(gioco.getDataGame().getApprendistiBolle()>0);
        jLabel275.setText("("+gioco.getDataGame().getCalcoloTempoSpettacoloBolle()+"s/cast)");
        jLabel274.setVisible(gioco.getDataGame().getApprendistiVento()>0);
        jLabel274.setText("("+gioco.getDataGame().getCalcoloTempoSpettacoloVento()+"s/cast)");
        jLabel136.setText(""+gioco.getDataGame().getApprendistiVento());
        jLabel129.setText(""+gioco.getDataGame().getApprendistiGeyserMana());
        jLabel273.setVisible(gioco.getDataGame().getApprendistiGeyserMana()>0);
        jLabel273.setText("("+gioco.getDataGame().getCalcoloTempoGeyser()+"s/cast)");
        jLabel272.setText("("+gioco.getDataGame().getCalcoloTempoDepositiLegno()+"s/cast)");
        jLabel272.setVisible(gioco.getDataGame().getCalcoloTempoDepositiLegno()>0);
        jLabel128.setText(""+gioco.getDataGame().getApprendistiDepositoLegno());
        jLabel122.setText(""+gioco.getDataGame().getApprendistiSbarraFerro());
        jLabel271.setVisible(gioco.getDataGame().getApprendistiSbarraFerro()>0);
        jLabel271.setText("("+gioco.getDataGame().getCalcoloTempoBarreFerro()+"s/cast)");
        jLabel121.setText(""+gioco.getDataGame().getApprendistiAcquaIII());
        jLabel270.setVisible(gioco.getDataGame().getApprendistiAcquaIII()>0);
        jLabel270.setText("("+gioco.getDataGame().getCalcoloTempoAcquaIII()+"s/cast)");
        jLabel269.setVisible(gioco.getDataGame().getApprendistiMasso()>0);
        jLabel269.setText("("+gioco.getDataGame().getCalcoloTempoMasso()+"s/cast)");
        if(gioco.getDataGame().getFornoAttivi()>0){
            jLabel237.setVisible(true);
            jLabel237.setText("+"+gioco.getDataGame().getFornoAttivi()*2+"/sec");
        }else{
            jLabel237.setVisible(false);
        }
        jLabel242.setText(gioco.getDataGame().getFornoAttivi()+"/"+gioco.getDataGame().getForno());
        jLabel234.setText(formatta(gioco.getDataGame().getFerro())+"/"+formatta(gioco.getDataGame().getRisorsaNecessariaFerroForno()));
        jLabel229.setText(formatta(gioco.getDataGame().getPietra())+"/"+formatta(gioco.getDataGame().getRisorsaNecessariaPietraForno()));
        jLabel228.setText(formatta(gioco.getDataGame().getMonete())+"/"+formatta(gioco.getDataGame().getRisorsaNecessariaMoneteForno()));
        RisorsaFerroGeyser.setText(formatta(gioco.getDataGame().getFerro())+"/"+formatta(gioco.getDataGame().getRisorsaNecessariaFerroGeyser()));
        RisorsaAcquaGeyser.setText(formatta(gioco.getDataGame().getAcqua())+"/"+formatta(gioco.getDataGame().getRisorsaNecessariaAcquaGeyser()));
        RisorsaMoneteGeyser.setText(formatta(gioco.getDataGame().getMonete())+"/"+formatta(gioco.getDataGame().getRisorsaNecessariaMoneteGeyser()));
        jLabel211.setText(formatta(gioco.getDataGame().getTime())+"/3000");
        RisorsaPietraCaveau.setText(formatta(gioco.getDataGame().getPietra())+"/"+formatta(gioco.getDataGame().getRisorsaNecessariaPietraVault()));
        RisorsaMoneteCaveau.setText(formatta(gioco.getDataGame().getMonete())+"/"+formatta(gioco.getDataGame().getRisorsaNecessariaMoneteVault()));
        RisorsaPietraSerbatoio.setText(formatta(gioco.getDataGame().getPietra())+"/"+formatta(gioco.getDataGame().getRisorsaNecessariaPietraVault()));
        RisorsaLegnoSerbatoio.setText(formatta(gioco.getDataGame().getLegno())+"/"+formatta(gioco.getDataGame().getRisorsaNecessariaLegnoSerbatoioAcqua()));
        RisorsaMoneteSerbatoio.setText(formatta(gioco.getDataGame().getMonete())+"/"+formatta(gioco.getDataGame().getRisorsaNecessariaMoneteSerbatoioAcqua()));
        jLabel201.setVisible(gioco.getDataGame().getApprendistiMagia()>0);
        jLabel194.setVisible(gioco.getDataGame().getApprendistiAcquaII()>0);
        jLabel41.setText(formatta(gioco.getDataGame().getPietra())+"/"+formatta(gioco.getDataGame().getRisorsaNecessariaPietraCabinaR()));
        jLabel40.setText(formatta(gioco.getDataGame().getLegno())+"/"+formatta(gioco.getDataGame().getRisorsaNecessariaLegnoCabinaR()));
        jLabel39.setText(formatta(gioco.getDataGame().getMonete())+"/"+formatta(gioco.getDataGame().getRisorsaNecessariaMoneteCabinaR()));
        jLabel199.setVisible(gioco.getDataGame().getApprendistiGettiMana()>0);
        jLabel195.setVisible(gioco.getDataGame().getApprendistiRoccia()>0);
        jLabel268.setVisible(gioco.getDataGame().getApprendistiMineraliFerro()>0);
        jLabel193.setVisible(gioco.getDataGame().getApprendistiAcqua()>0);
        jLabel138.setVisible(gioco.getDataGame().getApprendistiPietra()>0);
        jLabel201.setText("("+gioco.getDataGame().getCalcoloTempoSpettacoloMagia()+"s/cast)");
        jLabel194.setText("("+gioco.getDataGame().getCalcoloTempoAcquaII()+"s/cast)");
        jLabel138.setText("("+gioco.getDataGame().getCalcoloTempoPietra()+"s/cast)");
        jLabel193.setText("("+gioco.getDataGame().getCalcoloTempoAcqua()+"s/cast)");
        jLabel195.setText("("+gioco.getDataGame().getCalcoloTempoRoccia()+"s/cast)");
        jLabel199.setText("("+gioco.getDataGame().getCalcoloTempoIncantiMana()+"s/cast)");
        jLabel268.setText("("+gioco.getDataGame().getCalcoloTempoMineraliFerro()+"s/cast)");
        jLabel127.setText(""+gioco.getDataGame().getApprendistiGettiMana());
        jLabel110.setText(""+gioco.getDataGame().getApprendistiRoccia());
        jLabel111.setText(""+gioco.getDataGame().getApprendistiAcquaII());
        jLabel112.setText(""+gioco.getDataGame().getApprendistiMineraliFerro());
        jLabel120.setText(""+gioco.getDataGame().getApprendistiMasso());
        jLabel135.setText(""+gioco.getDataGame().getApprendistiMagia());
        jLabel109.setText(""+gioco.getDataGame().getApprendistiAcqua());
        jLabel108.setText(""+gioco.getDataGame().getApprendistiPietra());
        jLabel190.setText(formatta(gioco.getDataGame().getPietra())+"/"+formatta(gioco.getDataGame().getRisorsanecessariaPietraApprendista()));
        jLabel189.setText(formatta(gioco.getDataGame().getLegno())+"/"+formatta(gioco.getDataGame().getRisorsaNecessariaLegnoApprendista()));
        jLabel188.setText(formatta(gioco.getDataGame().getMonete())+"/"+formatta(gioco.getDataGame().getRisorsaNecessariaMoneteApprendista()));
        jLabel51.setText(gioco.getDataGame().getApprendistiDisponibili()+"/"+gioco.getDataGame().getApprendisti());
        jLabel277.setVisible(calcoloManaTotale()>gioco.getDataGame().getMana());
        RisorsaApprendistaPietra.setText(formatta(gioco.getDataGame().getPietra())+"/"+formatta(gioco.getDataGame().getRisorsanecessariaPietraApprendista()));
        RisorsaApprendistaLegno.setText(formatta(gioco.getDataGame().getLegno())+"/"+formatta(gioco.getDataGame().getRisorsaNecessariaLegnoApprendista()));
        RisorsaApprendistaMonete.setText(formatta(gioco.getDataGame().getMonete())+"/"+formatta(gioco.getDataGame().getRisorsaNecessariaMoneteApprendista()));
        BottonePezziTempo.setText("Usa Pezzi di Tempo(Ricerca)(⏲ 3000)");
        jButton113.setText("Usa Pezzi di Tempo(Salto temporale)(⏲ 3000)");
        jButton76.setText("Usa Pezzi di Tempo(⏲ 3000)");
        jLabel164.setText(formatta(gioco.getDataGame().getMonete())+"/"+formatta(gioco.getDataGame().getRisorsaNecessariaMoneteRicercatore()));
        RisorsaPietraCabina.setText(formatta(gioco.getDataGame().getPietra())+"/"+formatta(gioco.getDataGame().getRisorsaNecessariaPietraCabinaR()));
        RisorsaLegnoCabina.setText(formatta(gioco.getDataGame().getLegno())+"/"+formatta(gioco.getDataGame().getRisorsaNecessariaLegnoCabinaR()));
        RisorsaMoneteCabina.setText(formatta(gioco.getDataGame().getMonete())+"/"+formatta(gioco.getDataGame().getRisorsaNecessariaMoneteCabinaR()));
        RisorsaTempo.setText(formatta(gioco.getDataGame().getTime())+"/3000");
        RisorsaPietraMagazzino.setText(formatta(gioco.getDataGame().getPietra())+"/"+formatta(gioco.getDataGame().getRisorsaNecessariaPietraMagazzino()));
        RisorsaMoneteMagazzino.setText(formatta(gioco.getDataGame().getMonete())+"/"+formatta(gioco.getDataGame().getRisorsaNecessariaMoneteMagazzino()));
        RisorsaPietraLegname.setText(formatta(gioco.getDataGame().getPietra())+"/"+formatta(gioco.getDataGame().getRisorsaNecessariaPietraLegname()));
        RisorsaLegnoLegname.setText(formatta(gioco.getDataGame().getLegno())+"/"+formatta(gioco.getDataGame().getRisorsaNecessariaLegnoLegname()));
        RisorsaManaLegname.setText(formatta(gioco.getDataGame().getMana())+"/200");
        RisorsaMoneteShard.setText(formatta(gioco.getDataGame().getMonete())+"/"+formatta(gioco.getDataGame().getRisorsaNecesariaFrammentoMana()));
        RisorsaAcquaSilos.setText(formatta(gioco.getDataGame().getAcqua())+"/"+formatta(gioco.getDataGame().getRisorsaNecesariaSilosAcqua()));
        RisorsaPietraSilos.setText(formatta(gioco.getDataGame().getPietra())+"/"+formatta(gioco.getDataGame().getRisorsaNecesariaSilosPietra()));
        jLabel171.setText(formatta(gioco.getDataGame().getTime())+"/3000");
        jLabel177.setText(gioco.getDataGame().getRicercatoriDisponibili() + " / " + gioco.getDataGame().getCapacitàRicercatore());
        jLabel169.setText("" + gioco.getDataGame().getRicercatoriIllusione());
        jLabel163.setText("" + gioco.getDataGame().getRicercatoriIncanto());
        jLabel157.setText("" +gioco.getDataGame().getRicercatoriEvocazione());
        jLabel179.setText(""+gioco.getDataGame().getRicercatore()+"/"+gioco.getDataGame().getCapacitàRicercatore());
        jLabel168.setText("Lv"+gioco.getDataGame().getLivelloAttualeIllusione());
        jLabel162.setText("Lv"+gioco.getDataGame().getLivelloAttualeIncanto());
        jLabel156.setText("Lv"+gioco.getDataGame().getLivelloAttualeEvocazione());
        jLabel26.setText(formatta(gioco.getDataGame().getIllusioneExp())+"/"+formatta(gioco.getDataGame().getMaxIllusioneExp()));
        jLabel25.setText(formatta(gioco.getDataGame().getIncantoExp())+"/"+formatta(gioco.getDataGame().getMaxIncantoExp()));
        jLabel24.setText(formatta(gioco.getDataGame().getEvocazioneExp())+"/"+formatta(gioco.getDataGame().getMaxevocazioneoExp()));
        jLabel22.setText("Lv"+gioco.getDataGame().getLivelloAttualeIllusione());
        jLabel21.setText("Lv"+gioco.getDataGame().getLivelloAttualeIncanto());
        jLabel23.setText("Lv"+gioco.getDataGame().getLivelloAttualeEvocazione());
        jLabel145.setText(formatta(gioco.getDataGame().getTime())+"/"+formatta(gioco.getDataGame().getMaxTime()));
        jLabel17.setText(formatta(gioco.getDataGame().getLegno()) + "/" + formatta(gioco.getDataGame().getMaxLegno()));
        jLabel18.setText(formatta(gioco.getDataGame().getFerro()) + "/" + formatta(gioco.getDataGame().getMaxFerro()));
        jLabel12.setText(formatta(gioco.getDataGame().getMonete()) + "/" + formatta(gioco.getDataGame().getMaxMonete()));
        jLabel10.setText(formatta(gioco.getDataGame().getAcqua()) + "/" + formatta(gioco.getDataGame().getMaxAcqua()));
        jLabel8.setText(formatta(gioco.getDataGame().getPietra()) + "/" + formatta(gioco.getDataGame().getMaxPietra()));
        jLabel6.setText(formatta(gioco.getDataGame().getMana()) + "/" + formatta(gioco.getDataGame().getMaxMana()));  
        jLabel236.setText(formatta(gioco.getDataGame().getFiamma())+"/"+formatta(gioco.getDataGame().getMaxFiamma()));
    }
    
   public void setVisibilitàRisorse(){
    // Aggiornamento della visibilità delle label usando i flag
    if(gioco.getDataGame().getTime()<=0){
        jLabel172.setVisible(false);
        jButton82.setVisible(false);
        jPanel62.setVisible(false);
    }
    jLabel235.setVisible(gioco.getDataGame().isFiammaVisibile());
    jLabel236.setVisible(gioco.getDataGame().isFiammaVisibile());
    jLabel145.setVisible(gioco.getDataGame().isTimeVisibile());
    jLabel144.setVisible(gioco.getDataGame().isTimeVisibile());
    jLabel17.setVisible(gioco.getDataGame().isLegnoVisibile());
    jLabel15.setVisible(gioco.getDataGame().isLegnoVisibile());
    jLabel18.setVisible(gioco.getDataGame().isFerroVisibile());
    jLabel16.setVisible(gioco.getDataGame().isFerroVisibile());
    jLabel12.setVisible(gioco.getDataGame().isMoneteVisibile());
    jLabel11.setVisible(gioco.getDataGame().isMoneteVisibile());
    jLabel10.setVisible(gioco.getDataGame().isAcquaVisibile());
    jLabel9.setVisible(gioco.getDataGame().isAcquaVisibile());
    jLabel8.setVisible(gioco.getDataGame().isPietraVisibile());
    jLabel7.setVisible(gioco.getDataGame().isPietraVisibile());
    jLabel6.setVisible(gioco.getDataGame().isManaVisibile());
    jLabel3.setVisible(gioco.getDataGame().isManaVisibile());
    // parte destra
    LivelliUpdateGUI();
}

    public void choiceB2() {
        LDE.setVisible(true);
        if (FuocoB.isSelected()) {
            LDE.setText("<html><p>Hai selezionato il Fuoco! Un elemento di base, spesso pericoloso ma potente.</p></html>");
            FuocoB.setBackground(new Color(0, 122, 255));
            AcquaB.setBackground(Color.WHITE);
            TerraB.setBackground(Color.WHITE);
            AriaB.setBackground(Color.WHITE);
        } else if (AcquaB.isSelected()) {
            LDE.setText("<html><p>Hai selezionato l'Acqua! Un elemento fondamentale per creare fluidità.</p></html>");
            FuocoB.setBackground(Color.WHITE);
            AcquaB.setBackground(new Color(0, 122, 255));
            TerraB.setBackground(Color.WHITE);
            AriaB.setBackground(Color.WHITE);
        } else if (TerraB.isSelected()) {
            LDE.setText("<html><p>Hai selezionato la Terra! Un elemento solido e affidabile.</p></html>");
            FuocoB.setBackground(Color.WHITE);
            AcquaB.setBackground(Color.WHITE);
            TerraB.setBackground(new Color(0, 122, 255));
            AriaB.setBackground(Color.WHITE);
        } else if (AriaB.isSelected()) {
            LDE.setText("<html><p>Hai selezionato l'Aria! Un elemento leggero e dinamico.</p></html>");
            FuocoB.setBackground(Color.WHITE);
            AcquaB.setBackground(Color.WHITE);
            TerraB.setBackground(Color.WHITE);
            AriaB.setBackground(new Color(0, 122, 255));
        }
    }
    public void choiceB1() {
        LSD.setVisible(true);
        if (EvocazioneB.isSelected()) {
            LSD.setText("<html><p>Hai selezionato l'Evocazione! Ideale per creare oggetti dal nulla.</p></html>");
            EvocazioneB.setBackground(new Color(0, 122, 255));
            IncantoB.setBackground(Color.WHITE);
            IllusioneB.setBackground(Color.WHITE);
        } else if (IncantoB.isSelected()) {
            LSD.setText("<html><p>Hai selezionato l'Incantamento! Ottimo per modificare le proprietà degli oggetti.</p></html>");
            EvocazioneB.setBackground(Color.WHITE);
            IncantoB.setBackground(new Color(0, 122, 255));
            IllusioneB.setBackground(Color.WHITE);
        } else if (IllusioneB.isSelected()) {
            LSD.setText("<html><p>Hai selezionato l'Illusione! Perfetto per alterare la percezione della realtà.</p></html>");
            EvocazioneB.setBackground(Color.WHITE);
            IncantoB.setBackground(Color.WHITE);
            IllusioneB.setBackground(new Color(0, 122, 255));
        }
    }
    public void IBA() {
        boolean scuola = buttonGroup1.getSelection() != null;
        boolean elemento = buttonGroup2.getSelection() != null;
        if (scuola && elemento) {
            IB.setBackground(new Color(0, 122, 255));
            IB.setEnabled(true);
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel22 = new javax.swing.JPanel();
        jProgressBar2 = new javax.swing.JProgressBar();
        jLabel212 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        HomePage = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel12 = new javax.swing.JPanel();
        PanneloItem = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jButton130 = new javax.swing.JButton();
        jLabel249 = new javax.swing.JLabel();
        jLabel260 = new javax.swing.JLabel();
        jLabel261 = new javax.swing.JLabel();
        jLabel262 = new javax.swing.JLabel();
        jLabel263 = new javax.swing.JLabel();
        jLabel264 = new javax.swing.JLabel();
        jButton133 = new javax.swing.JButton();
        jButton134 = new javax.swing.JButton();
        jButton135 = new javax.swing.JButton();
        jLabel265 = new javax.swing.JLabel();
        jPanel51 = new javax.swing.JPanel();
        jButton136 = new javax.swing.JButton();
        jButton137 = new javax.swing.JButton();
        jButton138 = new javax.swing.JButton();
        jButton139 = new javax.swing.JButton();
        jButton140 = new javax.swing.JButton();
        jButton141 = new javax.swing.JButton();
        jButton142 = new javax.swing.JButton();
        jButton143 = new javax.swing.JButton();
        jButton144 = new javax.swing.JButton();
        jButton145 = new javax.swing.JButton();
        jButton146 = new javax.swing.JButton();
        jButton147 = new javax.swing.JButton();
        jButton148 = new javax.swing.JButton();
        jButton149 = new javax.swing.JButton();
        jButton151 = new javax.swing.JButton();
        jButton152 = new javax.swing.JButton();
        jButton153 = new javax.swing.JButton();
        jButton154 = new javax.swing.JButton();
        jPanel63 = new javax.swing.JPanel();
        jLabel266 = new javax.swing.JLabel();
        jLabel267 = new javax.swing.JLabel();
        jButton155 = new javax.swing.JButton();
        jButton150 = new javax.swing.JButton();
        PanneloApprendisti = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        jButton45 = new javax.swing.JButton();
        jButton60 = new javax.swing.JButton();
        jButton61 = new javax.swing.JButton();
        jButton62 = new javax.swing.JButton();
        jButton63 = new javax.swing.JButton();
        jButton64 = new javax.swing.JButton();
        jButton65 = new javax.swing.JButton();
        jButton84 = new javax.swing.JButton();
        jButton85 = new javax.swing.JButton();
        jButton86 = new javax.swing.JButton();
        jLabel123 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        jButton87 = new javax.swing.JButton();
        jButton92 = new javax.swing.JButton();
        jButton93 = new javax.swing.JButton();
        jButton94 = new javax.swing.JButton();
        jButton96 = new javax.swing.JButton();
        jButton98 = new javax.swing.JButton();
        jLabel130 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jButton100 = new javax.swing.JButton();
        jButton101 = new javax.swing.JButton();
        jButton103 = new javax.swing.JButton();
        jButton105 = new javax.swing.JButton();
        jButton107 = new javax.swing.JButton();
        jButton108 = new javax.swing.JButton();
        jButton110 = new javax.swing.JButton();
        jButton111 = new javax.swing.JButton();
        jLabel139 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jButton117 = new javax.swing.JButton();
        jButton118 = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jLabel140 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        jLabel174 = new javax.swing.JLabel();
        jLabel175 = new javax.swing.JLabel();
        jLabel187 = new javax.swing.JLabel();
        jLabel188 = new javax.swing.JLabel();
        jLabel189 = new javax.swing.JLabel();
        jLabel190 = new javax.swing.JLabel();
        jButton115 = new javax.swing.JButton();
        jLabel192 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        jLabel193 = new javax.swing.JLabel();
        jLabel195 = new javax.swing.JLabel();
        jLabel199 = new javax.swing.JLabel();
        jLabel194 = new javax.swing.JLabel();
        jLabel201 = new javax.swing.JLabel();
        jLabel268 = new javax.swing.JLabel();
        jLabel269 = new javax.swing.JLabel();
        jLabel270 = new javax.swing.JLabel();
        jLabel271 = new javax.swing.JLabel();
        jLabel272 = new javax.swing.JLabel();
        jLabel273 = new javax.swing.JLabel();
        jLabel274 = new javax.swing.JLabel();
        jLabel275 = new javax.swing.JLabel();
        jLabel276 = new javax.swing.JLabel();
        PanneloPrincipale = new javax.swing.JPanel();
        jLabel191 = new javax.swing.JLabel();
        jPanel67 = new javax.swing.JPanel();
        RaccogliMana = new javax.swing.JButton();
        jButton95 = new javax.swing.JButton();
        jPanel68 = new javax.swing.JPanel();
        TestoMana = new javax.swing.JLabel();
        RaccogliLegno = new javax.swing.JButton();
        jButton97 = new javax.swing.JButton();
        jPanel69 = new javax.swing.JPanel();
        TestoLegno = new javax.swing.JLabel();
        RaccogliFerro = new javax.swing.JButton();
        jButton99 = new javax.swing.JButton();
        jPanel70 = new javax.swing.JPanel();
        TestoFerro = new javax.swing.JLabel();
        jPanel71 = new javax.swing.JPanel();
        BottoneSilos = new javax.swing.JButton();
        jButton102 = new javax.swing.JButton();
        jPanel72 = new javax.swing.JPanel();
        TestoSilos = new javax.swing.JLabel();
        jLabel196 = new javax.swing.JLabel();
        jLabel197 = new javax.swing.JLabel();
        jLabel198 = new javax.swing.JLabel();
        RisorsaPietraSilos = new javax.swing.JLabel();
        RisorsaAcquaSilos = new javax.swing.JLabel();
        BottoneShard = new javax.swing.JButton();
        jButton104 = new javax.swing.JButton();
        jPanel73 = new javax.swing.JPanel();
        TestoShard = new javax.swing.JLabel();
        jLabel202 = new javax.swing.JLabel();
        jLabel203 = new javax.swing.JLabel();
        RisorsaMoneteShard = new javax.swing.JLabel();
        BottoneGeyser = new javax.swing.JButton();
        jButton106 = new javax.swing.JButton();
        jPanel74 = new javax.swing.JPanel();
        TestoGeyser = new javax.swing.JLabel();
        jLabel206 = new javax.swing.JLabel();
        jLabel207 = new javax.swing.JLabel();
        jLabel208 = new javax.swing.JLabel();
        jLabel209 = new javax.swing.JLabel();
        RisorsaMoneteGeyser = new javax.swing.JLabel();
        RisorsaAcquaGeyser = new javax.swing.JLabel();
        RisorsaFerroGeyser = new javax.swing.JLabel();
        BottoneMana = new javax.swing.JButton();
        jLabel213 = new javax.swing.JLabel();
        BottoneProduzione = new javax.swing.JButton();
        jPanel75 = new javax.swing.JPanel();
        BottoneLegname = new javax.swing.JButton();
        jButton109 = new javax.swing.JButton();
        jPanel76 = new javax.swing.JPanel();
        TestoLegname = new javax.swing.JLabel();
        jLabel215 = new javax.swing.JLabel();
        jLabel216 = new javax.swing.JLabel();
        jLabel217 = new javax.swing.JLabel();
        jLabel218 = new javax.swing.JLabel();
        RisorsaManaLegname = new javax.swing.JLabel();
        RisorsaLegnoLegname = new javax.swing.JLabel();
        RisorsaPietraLegname = new javax.swing.JLabel();
        jButton125 = new javax.swing.JButton();
        jButton126 = new javax.swing.JButton();
        jPanel41 = new javax.swing.JPanel();
        jLabel219 = new javax.swing.JLabel();
        jLabel220 = new javax.swing.JLabel();
        jLabel221 = new javax.swing.JLabel();
        jLabel223 = new javax.swing.JLabel();
        jLabel227 = new javax.swing.JLabel();
        jLabel228 = new javax.swing.JLabel();
        jLabel229 = new javax.swing.JLabel();
        jLabel234 = new javax.swing.JLabel();
        jLabel241 = new javax.swing.JLabel();
        jLabel242 = new javax.swing.JLabel();
        jButton127 = new javax.swing.JButton();
        jButton128 = new javax.swing.JButton();
        jLabel222 = new javax.swing.JLabel();
        BottoneMagazzinaggio = new javax.swing.JButton();
        jPanel77 = new javax.swing.JPanel();
        BottoneMagazzino = new javax.swing.JButton();
        jButton112 = new javax.swing.JButton();
        jPanel78 = new javax.swing.JPanel();
        TestoMagazzino = new javax.swing.JLabel();
        jLabel224 = new javax.swing.JLabel();
        jLabel225 = new javax.swing.JLabel();
        jLabel226 = new javax.swing.JLabel();
        RisorsaMoneteMagazzino = new javax.swing.JLabel();
        RisorsaPietraMagazzino = new javax.swing.JLabel();
        BottoneSerbatoio = new javax.swing.JButton();
        jButton114 = new javax.swing.JButton();
        jPanel79 = new javax.swing.JPanel();
        TestoSerbatoio = new javax.swing.JLabel();
        jLabel231 = new javax.swing.JLabel();
        jLabel230 = new javax.swing.JLabel();
        jLabel232 = new javax.swing.JLabel();
        jLabel233 = new javax.swing.JLabel();
        RisorsaMoneteSerbatoio = new javax.swing.JLabel();
        RisorsaLegnoSerbatoio = new javax.swing.JLabel();
        RisorsaPietraSerbatoio = new javax.swing.JLabel();
        BottoneCaveau = new javax.swing.JButton();
        jButton116 = new javax.swing.JButton();
        jPanel80 = new javax.swing.JPanel();
        TestoCaveau = new javax.swing.JLabel();
        jLabel238 = new javax.swing.JLabel();
        jLabel239 = new javax.swing.JLabel();
        jLabel240 = new javax.swing.JLabel();
        RisorsaMoneteCaveau = new javax.swing.JLabel();
        RisorsaPietraCaveau = new javax.swing.JLabel();
        jLabel243 = new javax.swing.JLabel();
        BottoneTempo = new javax.swing.JButton();
        jPanel81 = new javax.swing.JPanel();
        BottonePezziTempo = new javax.swing.JButton();
        jButton119 = new javax.swing.JButton();
        jPanel82 = new javax.swing.JPanel();
        TestoTempo = new javax.swing.JLabel();
        jLabel245 = new javax.swing.JLabel();
        jLabel246 = new javax.swing.JLabel();
        RisorsaTempo = new javax.swing.JLabel();
        jButton113 = new javax.swing.JButton();
        jButton120 = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jLabel204 = new javax.swing.JLabel();
        jLabel205 = new javax.swing.JLabel();
        jLabel210 = new javax.swing.JLabel();
        jLabel211 = new javax.swing.JLabel();
        BottoneRicercatore = new javax.swing.JButton();
        BottoneRaccolta = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        BottoneCabina1 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        RisorsaMoneteCabina = new javax.swing.JLabel();
        RisorsaLegnoCabina = new javax.swing.JLabel();
        RisorsaPietraCabina = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        RisorsaApprendistaMonete = new javax.swing.JLabel();
        RisorsaApprendistaLegno = new javax.swing.JLabel();
        RisorsaApprendistaPietra = new javax.swing.JLabel();
        jLabel200 = new javax.swing.JLabel();
        jButton121 = new javax.swing.JButton();
        PanelloRitirati = new javax.swing.JPanel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jButton43 = new javax.swing.JButton();
        CardHelp = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jButton25 = new javax.swing.JButton();
        jPanel29 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jButton26 = new javax.swing.JButton();
        jPanel30 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jButton27 = new javax.swing.JButton();
        jPanel31 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jButton28 = new javax.swing.JButton();
        jPanel32 = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jButton29 = new javax.swing.JButton();
        jPanel33 = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jButton30 = new javax.swing.JButton();
        jPanel34 = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jButton31 = new javax.swing.JButton();
        jPanel35 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        jButton70 = new javax.swing.JButton();
        jPanel54 = new javax.swing.JPanel();
        jLabel147 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        jButton71 = new javax.swing.JButton();
        jPanel55 = new javax.swing.JPanel();
        jLabel149 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        jButton72 = new javax.swing.JButton();
        jPanel56 = new javax.swing.JPanel();
        jLabel151 = new javax.swing.JLabel();
        PanelloImpostazioni = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jButton32 = new javax.swing.JButton();
        jPanel36 = new javax.swing.JPanel();
        jLabel82 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel85 = new javax.swing.JLabel();
        jButton33 = new javax.swing.JButton();
        jPanel37 = new javax.swing.JPanel();
        jLabel86 = new javax.swing.JLabel();
        jButton34 = new javax.swing.JButton();
        jLabel87 = new javax.swing.JLabel();
        jButton35 = new javax.swing.JButton();
        jPanel38 = new javax.swing.JPanel();
        jLabel88 = new javax.swing.JLabel();
        jButton36 = new javax.swing.JButton();
        PanelloAbout = new javax.swing.JPanel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        PanelloRicerca = new javax.swing.JPanel();
        jLabel154 = new javax.swing.JLabel();
        jPanel57 = new javax.swing.JPanel();
        jLabel155 = new javax.swing.JLabel();
        jLabel156 = new javax.swing.JLabel();
        jLabel157 = new javax.swing.JLabel();
        jButton73 = new javax.swing.JButton();
        jButton74 = new javax.swing.JButton();
        jPanel59 = new javax.swing.JPanel();
        jLabel161 = new javax.swing.JLabel();
        jLabel162 = new javax.swing.JLabel();
        jLabel163 = new javax.swing.JLabel();
        jButton77 = new javax.swing.JButton();
        jButton78 = new javax.swing.JButton();
        jPanel61 = new javax.swing.JPanel();
        jLabel167 = new javax.swing.JLabel();
        jLabel168 = new javax.swing.JLabel();
        jButton80 = new javax.swing.JButton();
        jButton81 = new javax.swing.JButton();
        jLabel169 = new javax.swing.JLabel();
        jLabel176 = new javax.swing.JLabel();
        jLabel177 = new javax.swing.JLabel();
        jLabel178 = new javax.swing.JLabel();
        jLabel179 = new javax.swing.JLabel();
        jLabel180 = new javax.swing.JLabel();
        jLabel181 = new javax.swing.JLabel();
        jLabel182 = new javax.swing.JLabel();
        jButton88 = new javax.swing.JButton();
        jPanel66 = new javax.swing.JPanel();
        jButton89 = new javax.swing.JButton();
        jPanel58 = new javax.swing.JPanel();
        jLabel159 = new javax.swing.JLabel();
        jLabel160 = new javax.swing.JLabel();
        jLabel164 = new javax.swing.JLabel();
        jLabel158 = new javax.swing.JLabel();
        jButton75 = new javax.swing.JButton();
        jButton76 = new javax.swing.JButton();
        jPanel60 = new javax.swing.JPanel();
        jLabel165 = new javax.swing.JLabel();
        jLabel166 = new javax.swing.JLabel();
        jLabel170 = new javax.swing.JLabel();
        jLabel171 = new javax.swing.JLabel();
        jButton79 = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        PanneloCreaItem = new javax.swing.JPanel();
        jButton132 = new javax.swing.JButton();
        jLabel247 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jPanel49 = new javax.swing.JPanel();
        jChest = new javax.swing.JButton();
        jClub = new javax.swing.JButton();
        jSword = new javax.swing.JButton();
        jRamo = new javax.swing.JButton();
        jIronMail = new javax.swing.JButton();
        jDagger = new javax.swing.JButton();
        jWizardsRobe = new javax.swing.JButton();
        jSickle = new javax.swing.JButton();
        jHandAxe = new javax.swing.JButton();
        jFirewand = new javax.swing.JButton();
        jThiefsGarb = new javax.swing.JButton();
        jCristallo = new javax.swing.JButton();
        jSandali = new javax.swing.JButton();
        jCloak = new javax.swing.JButton();
        jClothShoes = new javax.swing.JButton();
        jEnchantedCloak = new javax.swing.JButton();
        jCloath = new javax.swing.JButton();
        jPanel50 = new javax.swing.JPanel();
        jLabel248 = new javax.swing.JLabel();
        jLabel250 = new javax.swing.JLabel();
        jLabel251 = new javax.swing.JLabel();
        jLabel252 = new javax.swing.JLabel();
        jLabel253 = new javax.swing.JLabel();
        jLabel254 = new javax.swing.JLabel();
        jLabel255 = new javax.swing.JLabel();
        jLabel256 = new javax.swing.JLabel();
        jLabel257 = new javax.swing.JLabel();
        jLabel258 = new javax.swing.JLabel();
        jButton131 = new javax.swing.JButton();
        jLabel259 = new javax.swing.JLabel();
        PanelloFisso = new javax.swing.JPanel();
        FissoPrincipale = new javax.swing.JPanel();
        jLabel152 = new javax.swing.JLabel();
        jLabel153 = new javax.swing.JLabel();
        FissoApprendisti = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel277 = new javax.swing.JLabel();
        PanelSuperioreG = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel8 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton13 = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jButton37 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jPanel39 = new javax.swing.JPanel();
        jLabel98 = new javax.swing.JLabel();
        jButton40 = new javax.swing.JButton();
        jPanel40 = new javax.swing.JPanel();
        jLabel99 = new javax.swing.JLabel();
        jButton41 = new javax.swing.JButton();
        jPanel42 = new javax.swing.JPanel();
        jLabel113 = new javax.swing.JLabel();
        jButton48 = new javax.swing.JButton();
        jButton49 = new javax.swing.JButton();
        jPanel43 = new javax.swing.JPanel();
        jLabel114 = new javax.swing.JLabel();
        jButton50 = new javax.swing.JButton();
        jButton51 = new javax.swing.JButton();
        jPanel44 = new javax.swing.JPanel();
        jLabel115 = new javax.swing.JLabel();
        jButton52 = new javax.swing.JButton();
        jButton53 = new javax.swing.JButton();
        jPanel45 = new javax.swing.JPanel();
        jLabel116 = new javax.swing.JLabel();
        jButton47 = new javax.swing.JButton();
        jButton46 = new javax.swing.JButton();
        jButton122 = new javax.swing.JButton();
        jButton123 = new javax.swing.JButton();
        jPanel28 = new javax.swing.JPanel();
        jLabel214 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jLabel58 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jPanel26 = new javax.swing.JPanel();
        jLabel244 = new javax.swing.JLabel();
        jButton54 = new javax.swing.JButton();
        jButton55 = new javax.swing.JButton();
        jPanel46 = new javax.swing.JPanel();
        jLabel117 = new javax.swing.JLabel();
        jButton56 = new javax.swing.JButton();
        jButton57 = new javax.swing.JButton();
        jPanel47 = new javax.swing.JPanel();
        jLabel118 = new javax.swing.JLabel();
        jButton59 = new javax.swing.JButton();
        jButton58 = new javax.swing.JButton();
        jPanel48 = new javax.swing.JPanel();
        jLabel119 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jPanel25 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jPanel52 = new javax.swing.JPanel();
        jLabel142 = new javax.swing.JLabel();
        jButton67 = new javax.swing.JButton();
        jButton68 = new javax.swing.JButton();
        jButton66 = new javax.swing.JButton();
        jButton69 = new javax.swing.JButton();
        jPanel53 = new javax.swing.JPanel();
        jLabel143 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        PanelloInformazioni = new javax.swing.JPanel();
        TEsto = new javax.swing.JLabel();
        campusB = new javax.swing.JButton();
        helpb = new javax.swing.JButton();
        impostazioniB = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel144 = new javax.swing.JLabel();
        jLabel235 = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        jLabel236 = new javax.swing.JLabel();
        jLabel237 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        BottonEXp = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jButton42 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        jPanel62 = new javax.swing.JPanel();
        jLabel173 = new javax.swing.JLabel();
        jButton83 = new javax.swing.JButton();
        jButton90 = new javax.swing.JButton();
        jButton91 = new javax.swing.JButton();
        jLabel183 = new javax.swing.JLabel();
        jLabel184 = new javax.swing.JLabel();
        jLabel185 = new javax.swing.JLabel();
        jLabel186 = new javax.swing.JLabel();
        jLabel172 = new javax.swing.JLabel();
        jButton82 = new javax.swing.JButton();
        BottoneSI = new javax.swing.JButton();
        jLabelScuolaE = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton124 = new javax.swing.JButton();
        jButton129 = new javax.swing.JButton();
        barra = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        TS = new javax.swing.JLabel();
        LIS = new javax.swing.JLabel();
        EvocazioneB = new javax.swing.JToggleButton();
        IncantoB = new javax.swing.JToggleButton();
        IllusioneB = new javax.swing.JToggleButton();
        LSD = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        TE = new javax.swing.JLabel();
        LIE = new javax.swing.JLabel();
        FuocoB = new javax.swing.JToggleButton();
        AcquaB = new javax.swing.JToggleButton();
        TerraB = new javax.swing.JToggleButton();
        AriaB = new javax.swing.JToggleButton();
        LDE = new javax.swing.JLabel();
        IB = new javax.swing.JButton();
        btnApriFile = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setMaximumSize(new java.awt.Dimension(1264, 700));
        jPanel22.setMinimumSize(new java.awt.Dimension(1264, 700));
        jPanel22.setLayout(new java.awt.GridBagLayout());

        jProgressBar2.setMaximum(600);
        jProgressBar2.setPreferredSize(new java.awt.Dimension(230, 5));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        jPanel22.add(jProgressBar2, gridBagConstraints);

        jLabel212.setText("Caricamento del gioco, un momento");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        jPanel22.add(jLabel212, gridBagConstraints);

        getContentPane().add(jPanel22, "card4");

        jPanel16.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setMaximumSize(new java.awt.Dimension(1264, 650));
        jPanel5.setMinimumSize(new java.awt.Dimension(1264, 650));
        jPanel5.setPreferredSize(new java.awt.Dimension(1264, 650));

        HomePage.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setViewportView(null);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setMaximumSize(new java.awt.Dimension(487, 2550));
        jPanel12.setMinimumSize(new java.awt.Dimension(487, 2550));
        jPanel12.setPreferredSize(new java.awt.Dimension(487, 2550));
        jPanel12.setLayout(new java.awt.CardLayout());

        PanneloItem.setBackground(new java.awt.Color(255, 255, 255));

        jLabel59.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel59.setText("Inventario");

        jButton130.setText("Crea oggetti");
        jButton130.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton130MouseClicked(evt);
            }
        });

        jLabel262.setText("Mano: Vuoto");

        jLabel263.setText("Corpo: Vuoto");

        jLabel264.setText("Accessorio: Vuoto");

        jButton133.setText("Disequipaggia");
        jButton133.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton133MouseClicked(evt);
            }
        });

        jButton134.setText("Disequipaggia");
        jButton134.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton134MouseClicked(evt);
            }
        });

        jButton135.setText("Disequipaggia");
        jButton135.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton135MouseClicked(evt);
            }
        });

        jLabel265.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        jLabel265.setText("Equipaggiamento");

        jPanel51.setBackground(new java.awt.Color(255, 255, 255));
        jPanel51.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton136.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton136MouseClicked(evt);
            }
        });

        jButton137.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton137MouseClicked(evt);
            }
        });

        jButton138.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton138MouseClicked(evt);
            }
        });

        jButton139.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton139MouseClicked(evt);
            }
        });

        jButton140.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton140MouseClicked(evt);
            }
        });

        jButton141.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton141MouseClicked(evt);
            }
        });

        jButton142.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton142MouseClicked(evt);
            }
        });

        jButton143.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton143MouseClicked(evt);
            }
        });

        jButton144.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton144MouseClicked(evt);
            }
        });

        jButton145.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton145MouseClicked(evt);
            }
        });

        jButton146.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton146MouseClicked(evt);
            }
        });

        jButton147.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton147MouseClicked(evt);
            }
        });

        jButton148.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton148MouseClicked(evt);
            }
        });

        jButton149.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton149MouseClicked(evt);
            }
        });

        jButton151.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton151MouseClicked(evt);
            }
        });

        jButton152.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton152MouseClicked(evt);
            }
        });

        jButton153.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton153MouseClicked(evt);
            }
        });

        jButton154.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton154MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton145, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton136, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel51Layout.createSequentialGroup()
                        .addComponent(jButton137, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton138, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton139, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton140, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton141, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton142, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton143, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton144, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel51Layout.createSequentialGroup()
                        .addComponent(jButton146, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton147, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton148, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton149, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton151, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton152, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton153, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton154, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton136, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton137, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton138, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton139, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton140, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton141, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton142, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton143, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton144, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton145, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton146, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton147, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton148, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton149, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton151, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton152, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton153, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton154, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel63.setBackground(new java.awt.Color(255, 255, 255));

        jLabel266.setText("jLabel266");

        jButton155.setText("Equipaggia");
        jButton155.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton155MouseClicked(evt);
            }
        });

        jButton150.setText("Scartare");
        jButton150.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton150MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel63Layout = new javax.swing.GroupLayout(jPanel63);
        jPanel63.setLayout(jPanel63Layout);
        jPanel63Layout.setHorizontalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel63Layout.createSequentialGroup()
                        .addComponent(jLabel266, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel267, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
                    .addGroup(jPanel63Layout.createSequentialGroup()
                        .addComponent(jButton155)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton150)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel63Layout.setVerticalGroup(
            jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel63Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel267, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel266))
                .addGap(26, 26, 26)
                .addGroup(jPanel63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton155)
                    .addComponent(jButton150))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanneloItemLayout = new javax.swing.GroupLayout(PanneloItem);
        PanneloItem.setLayout(PanneloItemLayout);
        PanneloItemLayout.setHorizontalGroup(
            PanneloItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanneloItemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanneloItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanneloItemLayout.createSequentialGroup()
                        .addGroup(PanneloItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel59)
                            .addGroup(PanneloItemLayout.createSequentialGroup()
                                .addGroup(PanneloItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel249, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel260, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel261, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addGroup(PanneloItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel264, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel263, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel262, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                        .addGroup(PanneloItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton130)
                            .addComponent(jButton133)
                            .addComponent(jButton134)
                            .addComponent(jButton135)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanneloItemLayout.createSequentialGroup()
                        .addComponent(jLabel265, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanneloItemLayout.setVerticalGroup(
            PanneloItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanneloItemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanneloItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton130)
                    .addComponent(jLabel59))
                .addGap(18, 18, 18)
                .addGroup(PanneloItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel249, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel262)
                    .addComponent(jButton133, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanneloItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel260, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel263)
                    .addComponent(jButton134, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanneloItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel261, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel264)
                    .addComponent(jButton135, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel265)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel63, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(2008, Short.MAX_VALUE))
        );

        jPanel12.add(PanneloItem, "cardItem");

        PanneloApprendisti.setBackground(new java.awt.Color(255, 255, 255));

        jLabel53.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel53.setText("Evocazione");

        jLabel55.setText("Crea Pietra");

        jLabel56.setText("Crea Acqua");

        jLabel61.setText("Crea Roccia");

        jLabel62.setText("Crea Acqua II");

        jLabel104.setText("Crea Minerale di Ferro");

        jLabel105.setText("Crea Masso");

        jLabel106.setText("Crea Acqua III");

        jLabel107.setText("Crea Sbarra di Ferro");

        jLabel108.setText("0");

        jLabel109.setText("0");

        jLabel110.setText("0");

        jLabel111.setText("0");

        jLabel112.setText("0");

        jLabel120.setText("0");

        jLabel121.setText("0");

        jLabel122.setText("0");

        jButton10.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jButton10.setText("-");
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton10MouseClicked(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jButton11.setText("-");
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton11MouseClicked(evt);
            }
        });

        jButton22.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jButton22.setText("-");
        jButton22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton22MouseClicked(evt);
            }
        });

        jButton23.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jButton23.setText("-");
        jButton23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton23MouseClicked(evt);
            }
        });

        jButton24.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jButton24.setText("-");
        jButton24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton24MouseClicked(evt);
            }
        });

        jButton44.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jButton44.setText("-");
        jButton44.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton44MouseClicked(evt);
            }
        });

        jButton45.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jButton45.setText("-");
        jButton45.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton45MouseClicked(evt);
            }
        });

        jButton60.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jButton60.setText("-");
        jButton60.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton60MouseClicked(evt);
            }
        });

        jButton61.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jButton61.setText("+");
        jButton61.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton61MouseClicked(evt);
            }
        });

        jButton62.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jButton62.setText("+");
        jButton62.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton62MouseClicked(evt);
            }
        });

        jButton63.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jButton63.setText("+");
        jButton63.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton63MouseClicked(evt);
            }
        });

        jButton64.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jButton64.setText("+");
        jButton64.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton64MouseClicked(evt);
            }
        });

        jButton65.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jButton65.setText("+");
        jButton65.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton65MouseClicked(evt);
            }
        });

        jButton84.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jButton84.setText("+");
        jButton84.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton84MouseClicked(evt);
            }
        });

        jButton85.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jButton85.setText("+");
        jButton85.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton85MouseClicked(evt);
            }
        });

        jButton86.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jButton86.setText("+");
        jButton86.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton86MouseClicked(evt);
            }
        });

        jLabel123.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel123.setText("Incantesimo");

        jLabel124.setText("Incanta i Getti di Mana");

        jLabel125.setText("Incanta i Depositi di Legno");

        jLabel126.setText("Incanta Geyser di Mana ");

        jLabel127.setText("0");

        jLabel128.setText("0");

        jLabel129.setText("0");

        jButton87.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jButton87.setText("-");
        jButton87.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton87MouseClicked(evt);
            }
        });

        jButton92.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jButton92.setText("-");
        jButton92.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton92MouseClicked(evt);
            }
        });

        jButton93.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jButton93.setText("-");
        jButton93.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton93MouseClicked(evt);
            }
        });

        jButton94.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jButton94.setText("+");
        jButton94.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton94MouseClicked(evt);
            }
        });

        jButton96.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jButton96.setText("+");
        jButton96.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton96MouseClicked(evt);
            }
        });

        jButton98.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jButton98.setText("+");
        jButton98.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton98MouseClicked(evt);
            }
        });

        jLabel130.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel130.setText("Illusione");

        jLabel131.setText("Spettacolo di Magia");

        jLabel132.setText("Spettacolo del Vento");

        jLabel133.setText("Spettacolo di Bolle");

        jLabel134.setText("Spettacolo di Fuoco");

        jLabel135.setText("0");

        jLabel136.setText("0");

        jLabel137.setText("0");

        jButton100.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jButton100.setText("-");
        jButton100.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton100MouseClicked(evt);
            }
        });

        jButton101.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jButton101.setText("-");
        jButton101.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton101MouseClicked(evt);
            }
        });

        jButton103.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jButton103.setText("-");
        jButton103.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton103MouseClicked(evt);
            }
        });

        jButton105.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jButton105.setText("-");
        jButton105.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton105MouseClicked(evt);
            }
        });

        jButton107.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jButton107.setText("+");
        jButton107.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton107MouseClicked(evt);
            }
        });

        jButton108.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jButton108.setText("+");
        jButton108.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton108MouseClicked(evt);
            }
        });

        jButton110.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jButton110.setText("+");
        jButton110.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton110MouseClicked(evt);
            }
        });

        jButton111.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jButton111.setText("+");
        jButton111.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton111MouseClicked(evt);
            }
        });

        jLabel139.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel139.setText("Edifici");

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        jButton117.setText("Dormitorio per Apprendisti");
        jButton117.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton117MouseClicked(evt);
            }
        });

        jButton118.setText("⊳");
        jButton118.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton118MouseClicked(evt);
            }
        });

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));

        jLabel140.setText("Testo");

        jLabel141.setText("Costo:");

        jLabel174.setText("🪙 Monete");

        jLabel175.setText("🪵 Legno");

        jLabel187.setText("🪨 Pietra");

        jLabel188.setText("0/0");

        jLabel189.setText("0/0");

        jLabel190.setText("0/0");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel140, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel141)
                        .addGap(107, 107, 107)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel174, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel175, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel187, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel188, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(jLabel189, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel190, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel140)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel141)
                    .addComponent(jLabel174)
                    .addComponent(jLabel188))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel175)
                    .addComponent(jLabel189))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel187)
                    .addComponent(jLabel190))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jButton117, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton118)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton117, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton118))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jButton115.setText("▼");
        jButton115.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton115MouseClicked(evt);
            }
        });

        jLabel192.setText("0");

        jLabel138.setText("(60s/cast)");

        jLabel193.setText("(60s/cast)");

        jLabel195.setText("(60s/cast)");

        jLabel199.setText("(60s/cast)");

        jLabel194.setText("(60s/cast)");

        jLabel201.setText("(60s/cast)");

        jLabel268.setText("(60s/cast)");

        jLabel269.setText("(60s/cast)");

        jLabel270.setText("(60s/cast)");

        jLabel271.setText("(60s/cast)");

        jLabel272.setText("(60s/cast)");

        jLabel273.setText("(60s/cast)");

        jLabel274.setText("(60s/cast)");

        jLabel275.setText("(60s/cast)");

        jLabel276.setText("(60s/cast)");

        javax.swing.GroupLayout PanneloApprendistiLayout = new javax.swing.GroupLayout(PanneloApprendisti);
        PanneloApprendisti.setLayout(PanneloApprendistiLayout);
        PanneloApprendistiLayout.setHorizontalGroup(
            PanneloApprendistiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanneloApprendistiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanneloApprendistiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanneloApprendistiLayout.createSequentialGroup()
                        .addGroup(PanneloApprendistiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanneloApprendistiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel53, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel55, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel56, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel61, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel104, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel105, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel106, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel107, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(PanneloApprendistiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel125, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel124, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel126, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(PanneloApprendistiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel130)
                                .addComponent(jLabel132, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                                .addComponent(jLabel131, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel133, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel134, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PanneloApprendistiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanneloApprendistiLayout.createSequentialGroup()
                                .addComponent(jLabel276)
                                .addGap(53, 53, 53)
                                .addComponent(jLabel192, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanneloApprendistiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanneloApprendistiLayout.createSequentialGroup()
                                    .addComponent(jLabel272)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel128, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanneloApprendistiLayout.createSequentialGroup()
                                    .addComponent(jLabel273)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel129, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanneloApprendistiLayout.createSequentialGroup()
                                    .addComponent(jLabel201)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel135, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanneloApprendistiLayout.createSequentialGroup()
                                    .addComponent(jLabel274)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel136, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanneloApprendistiLayout.createSequentialGroup()
                                    .addComponent(jLabel275)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel137, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(PanneloApprendistiLayout.createSequentialGroup()
                                    .addGroup(PanneloApprendistiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel199, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel138, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel193, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel195, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel194, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel268, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel269, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel270, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel271, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGroup(PanneloApprendistiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(PanneloApprendistiLayout.createSequentialGroup()
                                            .addGap(55, 55, 55)
                                            .addGroup(PanneloApprendistiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel122, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel121, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel120, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel112, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel111, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel110, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel109, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel108, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanneloApprendistiLayout.createSequentialGroup()
                                            .addGap(54, 54, 54)
                                            .addComponent(jLabel127, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanneloApprendistiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanneloApprendistiLayout.createSequentialGroup()
                                .addComponent(jButton23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton64))
                            .addGroup(PanneloApprendistiLayout.createSequentialGroup()
                                .addComponent(jButton24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton65))
                            .addGroup(PanneloApprendistiLayout.createSequentialGroup()
                                .addComponent(jButton44)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton84))
                            .addGroup(PanneloApprendistiLayout.createSequentialGroup()
                                .addComponent(jButton45)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton85))
                            .addGroup(PanneloApprendistiLayout.createSequentialGroup()
                                .addComponent(jButton60)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton86))
                            .addGroup(PanneloApprendistiLayout.createSequentialGroup()
                                .addComponent(jButton22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton63))
                            .addGroup(PanneloApprendistiLayout.createSequentialGroup()
                                .addGroup(PanneloApprendistiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton10, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(PanneloApprendistiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton61)
                                    .addComponent(jButton62)))
                            .addGroup(PanneloApprendistiLayout.createSequentialGroup()
                                .addComponent(jButton87)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton94))
                            .addGroup(PanneloApprendistiLayout.createSequentialGroup()
                                .addComponent(jButton92)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton96))
                            .addGroup(PanneloApprendistiLayout.createSequentialGroup()
                                .addComponent(jButton93)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton98))
                            .addGroup(PanneloApprendistiLayout.createSequentialGroup()
                                .addComponent(jButton100)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton111))
                            .addGroup(PanneloApprendistiLayout.createSequentialGroup()
                                .addComponent(jButton101)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton107))
                            .addGroup(PanneloApprendistiLayout.createSequentialGroup()
                                .addComponent(jButton103)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton108))
                            .addGroup(PanneloApprendistiLayout.createSequentialGroup()
                                .addComponent(jButton105)
                                .addGap(12, 12, 12)
                                .addComponent(jButton110)))
                        .addGap(29, 29, 29))
                    .addGroup(PanneloApprendistiLayout.createSequentialGroup()
                        .addComponent(jLabel123)
                        .addContainerGap(395, Short.MAX_VALUE))
                    .addGroup(PanneloApprendistiLayout.createSequentialGroup()
                        .addComponent(jLabel139, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton115)
                        .addGap(37, 37, 37))
                    .addGroup(PanneloApprendistiLayout.createSequentialGroup()
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 19, Short.MAX_VALUE))))
        );
        PanneloApprendistiLayout.setVerticalGroup(
            PanneloApprendistiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanneloApprendistiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel53)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanneloApprendistiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(jLabel108)
                    .addComponent(jButton10)
                    .addComponent(jButton61)
                    .addComponent(jLabel138))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanneloApprendistiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(jLabel109)
                    .addComponent(jButton11)
                    .addComponent(jButton62)
                    .addComponent(jLabel193))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanneloApprendistiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(jLabel110)
                    .addComponent(jButton22)
                    .addComponent(jButton63)
                    .addComponent(jLabel195))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanneloApprendistiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel111)
                    .addComponent(jButton23)
                    .addComponent(jButton64)
                    .addComponent(jLabel194))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanneloApprendistiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel104)
                    .addComponent(jLabel112)
                    .addComponent(jButton24)
                    .addComponent(jButton65)
                    .addComponent(jLabel268))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanneloApprendistiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel105)
                    .addComponent(jLabel120)
                    .addComponent(jButton44)
                    .addComponent(jButton84)
                    .addComponent(jLabel269))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanneloApprendistiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel106)
                    .addComponent(jLabel121)
                    .addComponent(jButton45)
                    .addComponent(jButton85)
                    .addComponent(jLabel270))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanneloApprendistiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel107)
                    .addComponent(jLabel122)
                    .addComponent(jButton60)
                    .addComponent(jButton86)
                    .addComponent(jLabel271))
                .addGap(18, 18, 18)
                .addComponent(jLabel123)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanneloApprendistiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel127, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanneloApprendistiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel124)
                        .addComponent(jButton87)
                        .addComponent(jButton94)
                        .addComponent(jLabel199)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanneloApprendistiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel125)
                    .addComponent(jLabel128)
                    .addComponent(jButton92)
                    .addComponent(jButton96)
                    .addComponent(jLabel272))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanneloApprendistiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel126)
                    .addComponent(jButton93)
                    .addComponent(jButton98)
                    .addComponent(jLabel129)
                    .addComponent(jLabel273))
                .addGap(18, 18, 18)
                .addComponent(jLabel130)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanneloApprendistiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel131)
                    .addComponent(jButton100)
                    .addComponent(jButton111)
                    .addComponent(jLabel135)
                    .addComponent(jLabel201))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanneloApprendistiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel132)
                    .addComponent(jLabel136)
                    .addComponent(jButton101)
                    .addComponent(jButton107)
                    .addComponent(jLabel274))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanneloApprendistiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel133)
                    .addComponent(jLabel137)
                    .addComponent(jButton103)
                    .addComponent(jButton108)
                    .addComponent(jLabel275))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanneloApprendistiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton110)
                    .addGroup(PanneloApprendistiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel134)
                        .addComponent(jLabel192)
                        .addComponent(jButton105)
                        .addComponent(jLabel276)))
                .addGap(18, 18, 18)
                .addGroup(PanneloApprendistiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel139)
                    .addComponent(jButton115))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1769, Short.MAX_VALUE))
        );

        jPanel12.add(PanneloApprendisti, "CardApprendisti");

        PanneloPrincipale.setBackground(new java.awt.Color(255, 255, 255));
        PanneloPrincipale.setMaximumSize(new java.awt.Dimension(500, 2550));
        PanneloPrincipale.setMinimumSize(new java.awt.Dimension(500, 2550));
        PanneloPrincipale.setPreferredSize(new java.awt.Dimension(500, 2550));

        jLabel191.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel191.setText("Raccogli");

        jPanel67.setBackground(new java.awt.Color(255, 255, 255));

        RaccogliMana.setText("Raccogli Mana");
        RaccogliMana.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RaccogliManaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                RaccogliManaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                RaccogliManaMouseReleased(evt);
            }
        });

        jButton95.setText("⊳");
        jButton95.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton95MouseClicked(evt);
            }
        });

        jPanel68.setBackground(new java.awt.Color(255, 255, 255));

        TestoMana.setText("Testo");

        javax.swing.GroupLayout jPanel68Layout = new javax.swing.GroupLayout(jPanel68);
        jPanel68.setLayout(jPanel68Layout);
        jPanel68Layout.setHorizontalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel68Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TestoMana, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel68Layout.setVerticalGroup(
            jPanel68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel68Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TestoMana)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        RaccogliLegno.setText("Raccogli Legno");
        RaccogliLegno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RaccogliLegnoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                RaccogliLegnoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                RaccogliLegnoMouseReleased(evt);
            }
        });

        jButton97.setText("⊳");
        jButton97.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton97MouseClicked(evt);
            }
        });

        jPanel69.setBackground(new java.awt.Color(255, 255, 255));

        TestoLegno.setText("Testo");

        javax.swing.GroupLayout jPanel69Layout = new javax.swing.GroupLayout(jPanel69);
        jPanel69.setLayout(jPanel69Layout);
        jPanel69Layout.setHorizontalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel69Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TestoLegno, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel69Layout.setVerticalGroup(
            jPanel69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel69Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TestoLegno)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        RaccogliFerro.setText("Raccogli Ferro");
        RaccogliFerro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RaccogliFerroMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                RaccogliFerroMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                RaccogliFerroMouseReleased(evt);
            }
        });

        jButton99.setText("⊳");
        jButton99.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton99MouseClicked(evt);
            }
        });

        jPanel70.setBackground(new java.awt.Color(255, 255, 255));

        TestoFerro.setText("Testo");

        javax.swing.GroupLayout jPanel70Layout = new javax.swing.GroupLayout(jPanel70);
        jPanel70.setLayout(jPanel70Layout);
        jPanel70Layout.setHorizontalGroup(
            jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel70Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TestoFerro, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel70Layout.setVerticalGroup(
            jPanel70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel70Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TestoFerro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel67Layout = new javax.swing.GroupLayout(jPanel67);
        jPanel67.setLayout(jPanel67Layout);
        jPanel67Layout.setHorizontalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel67Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel67Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(RaccogliMana, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton95)
                        .addGap(147, 147, 147))
                    .addGroup(jPanel67Layout.createSequentialGroup()
                        .addGroup(jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel68, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel67Layout.createSequentialGroup()
                                .addComponent(RaccogliLegno, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton97))
                            .addComponent(jPanel69, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel67Layout.createSequentialGroup()
                        .addGroup(jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel67Layout.createSequentialGroup()
                                .addComponent(RaccogliFerro, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton99))
                            .addComponent(jPanel70, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel67Layout.setVerticalGroup(
            jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel67Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RaccogliMana, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton95))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel68, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RaccogliLegno, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton97))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel69, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RaccogliFerro, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton99))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel70, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel71.setBackground(new java.awt.Color(255, 255, 255));

        BottoneSilos.setText("Beccuccio di Mana");
        BottoneSilos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BottoneSilosMouseClicked(evt);
            }
        });

        jButton102.setText("⊳");
        jButton102.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton102MouseClicked(evt);
            }
        });

        jPanel72.setBackground(new java.awt.Color(255, 255, 255));

        TestoSilos.setText("Testo");

        jLabel196.setText("Costo:");

        jLabel197.setText("🪨 Pietra");

        jLabel198.setText("🌢  Acqua");

        RisorsaPietraSilos.setText("0/0");

        RisorsaAcquaSilos.setText("0/0");

        javax.swing.GroupLayout jPanel72Layout = new javax.swing.GroupLayout(jPanel72);
        jPanel72.setLayout(jPanel72Layout);
        jPanel72Layout.setHorizontalGroup(
            jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel72Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel72Layout.createSequentialGroup()
                        .addComponent(TestoSilos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel72Layout.createSequentialGroup()
                        .addComponent(jLabel196)
                        .addGap(110, 110, 110)
                        .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel72Layout.createSequentialGroup()
                                .addComponent(jLabel198)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(RisorsaAcquaSilos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel72Layout.createSequentialGroup()
                                .addComponent(jLabel197)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(RisorsaPietraSilos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(30, 42, Short.MAX_VALUE))))
        );
        jPanel72Layout.setVerticalGroup(
            jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel72Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TestoSilos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel196)
                    .addComponent(jLabel197)
                    .addComponent(RisorsaPietraSilos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel72Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel198)
                    .addComponent(RisorsaAcquaSilos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BottoneShard.setText("Frammento di Mana");
        BottoneShard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BottoneShardMouseClicked(evt);
            }
        });

        jButton104.setText("⊳");
        jButton104.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton104MouseClicked(evt);
            }
        });

        jPanel73.setBackground(new java.awt.Color(255, 255, 255));

        TestoShard.setText("Testo");

        jLabel202.setText("Costo:");

        jLabel203.setText("🪙 Monete");

        RisorsaMoneteShard.setBackground(new java.awt.Color(255, 255, 255));
        RisorsaMoneteShard.setText("0/0");

        javax.swing.GroupLayout jPanel73Layout = new javax.swing.GroupLayout(jPanel73);
        jPanel73.setLayout(jPanel73Layout);
        jPanel73Layout.setHorizontalGroup(
            jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel73Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TestoShard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel73Layout.createSequentialGroup()
                        .addComponent(jLabel202)
                        .addGap(87, 87, 87)
                        .addComponent(jLabel203)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RisorsaMoneteShard, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 33, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel73Layout.setVerticalGroup(
            jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel73Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TestoShard)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel202)
                    .addComponent(jLabel203)
                    .addComponent(RisorsaMoneteShard))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BottoneGeyser.setText("Geyser di Mana");
        BottoneGeyser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BottoneGeyserMouseClicked(evt);
            }
        });

        jButton106.setText("⊳");
        jButton106.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton106MouseClicked(evt);
            }
        });

        jPanel74.setBackground(new java.awt.Color(255, 255, 255));

        TestoGeyser.setText("Testo");

        jLabel206.setText("Costo:");

        jLabel207.setText("🪙 Monete");

        jLabel208.setText("🌢  Acqua");

        jLabel209.setText("⛓  Ferro");

        RisorsaMoneteGeyser.setText("0/0");

        RisorsaAcquaGeyser.setText("0/0");

        RisorsaFerroGeyser.setText("0/0");

        javax.swing.GroupLayout jPanel74Layout = new javax.swing.GroupLayout(jPanel74);
        jPanel74.setLayout(jPanel74Layout);
        jPanel74Layout.setHorizontalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel74Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TestoGeyser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel74Layout.createSequentialGroup()
                        .addComponent(jLabel206)
                        .addGap(91, 91, 91)
                        .addGroup(jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel209, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel208, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel207, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(RisorsaMoneteGeyser, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(RisorsaAcquaGeyser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(RisorsaFerroGeyser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 17, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel74Layout.setVerticalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel74Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TestoGeyser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel206)
                    .addComponent(jLabel207)
                    .addComponent(RisorsaMoneteGeyser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel208)
                    .addComponent(RisorsaAcquaGeyser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel209)
                    .addComponent(RisorsaFerroGeyser))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel71Layout = new javax.swing.GroupLayout(jPanel71);
        jPanel71.setLayout(jPanel71Layout);
        jPanel71Layout.setHorizontalGroup(
            jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel71Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel72, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel71Layout.createSequentialGroup()
                        .addComponent(BottoneSilos, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton102))
                    .addGroup(jPanel71Layout.createSequentialGroup()
                        .addComponent(BottoneShard, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton104))
                    .addComponent(jPanel73, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel71Layout.createSequentialGroup()
                        .addComponent(BottoneGeyser, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton106))
                    .addComponent(jPanel74, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel71Layout.setVerticalGroup(
            jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel71Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BottoneSilos, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton102))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel72, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BottoneShard, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton104))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel73, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BottoneGeyser, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton106))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel74, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BottoneMana.setText("▼");
        BottoneMana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BottoneManaActionPerformed(evt);
            }
        });

        jLabel213.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel213.setText("Produzione");

        BottoneProduzione.setText("▼");
        BottoneProduzione.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BottoneProduzioneMouseClicked(evt);
            }
        });

        jPanel75.setBackground(new java.awt.Color(255, 255, 255));

        BottoneLegname.setText("Deposito di Legname");
        BottoneLegname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BottoneLegnameMouseClicked(evt);
            }
        });

        jButton109.setText("⊳");
        jButton109.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton109MouseClicked(evt);
            }
        });

        jPanel76.setBackground(new java.awt.Color(255, 255, 255));

        TestoLegname.setBackground(new java.awt.Color(255, 255, 255));
        TestoLegname.setText("Testo");

        jLabel215.setText("Costo:");

        jLabel216.setText("★ Mana");

        jLabel217.setText("🪵 Legno");

        jLabel218.setText("🪨 Pietra");

        RisorsaManaLegname.setText("0/0");

        RisorsaLegnoLegname.setText("0/0");

        RisorsaPietraLegname.setText("0/0");

        javax.swing.GroupLayout jPanel76Layout = new javax.swing.GroupLayout(jPanel76);
        jPanel76.setLayout(jPanel76Layout);
        jPanel76Layout.setHorizontalGroup(
            jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel76Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel76Layout.createSequentialGroup()
                        .addComponent(jLabel215)
                        .addGap(66, 66, 66)
                        .addGroup(jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel217)
                            .addComponent(jLabel216)))
                    .addGroup(jPanel76Layout.createSequentialGroup()
                        .addComponent(jLabel218)
                        .addGap(1, 1, 1)))
                .addGap(42, 42, 42)
                .addGroup(jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(RisorsaManaLegname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RisorsaLegnoLegname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RisorsaPietraLegname, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addContainerGap(78, Short.MAX_VALUE))
            .addComponent(TestoLegname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel76Layout.setVerticalGroup(
            jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel76Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TestoLegname)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel215)
                    .addComponent(jLabel216)
                    .addComponent(RisorsaManaLegname))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel217)
                    .addComponent(RisorsaLegnoLegname))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel218)
                    .addComponent(RisorsaPietraLegname))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton125.setText("Forno");
        jButton125.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton125MouseClicked(evt);
            }
        });

        jButton126.setText("⊳");
        jButton126.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton126MouseClicked(evt);
            }
        });

        jPanel41.setBackground(new java.awt.Color(255, 255, 255));

        jLabel219.setText("Testo");

        jLabel220.setText("Costo:");

        jLabel221.setText("🪙 Monete");

        jLabel223.setText("🪨 Pietra");

        jLabel227.setText("⛓  Ferro");

        jLabel228.setText("0/0");

        jLabel229.setText("0/0");

        jLabel234.setText("0/0");

        jLabel241.setText("Importo Attivo:");

        jLabel242.setText("0/1");

        jButton127.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jButton127.setText("-");
        jButton127.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton127MouseClicked(evt);
            }
        });

        jButton128.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jButton128.setText("+");
        jButton128.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton128MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel41Layout.createSequentialGroup()
                        .addComponent(jLabel219, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(17, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel41Layout.createSequentialGroup()
                        .addComponent(jLabel220)
                        .addGap(163, 163, 163)
                        .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel41Layout.createSequentialGroup()
                                .addComponent(jLabel221)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel228, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel41Layout.createSequentialGroup()
                                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel41Layout.createSequentialGroup()
                                        .addComponent(jLabel242, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton127)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton128))
                                    .addGroup(jPanel41Layout.createSequentialGroup()
                                        .addComponent(jLabel223, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel229, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel41Layout.createSequentialGroup()
                                        .addComponent(jLabel227, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel234, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))))
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addComponent(jLabel241)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel219)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel220)
                    .addComponent(jLabel221)
                    .addComponent(jLabel228))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel223)
                    .addComponent(jLabel229))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel227)
                    .addComponent(jLabel234))
                .addGap(18, 18, 18)
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel241)
                    .addComponent(jLabel242)
                    .addComponent(jButton127)
                    .addComponent(jButton128))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel75Layout = new javax.swing.GroupLayout(jPanel75);
        jPanel75.setLayout(jPanel75Layout);
        jPanel75Layout.setHorizontalGroup(
            jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel75Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel75Layout.createSequentialGroup()
                        .addComponent(BottoneLegname, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton109))
                    .addGroup(jPanel75Layout.createSequentialGroup()
                        .addComponent(jButton125, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton126))
                    .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel76, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel75Layout.setVerticalGroup(
            jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel75Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BottoneLegname, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton109))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel76, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton125, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton126))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel222.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel222.setText("Magazzinaggio");

        BottoneMagazzinaggio.setText("▼");
        BottoneMagazzinaggio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BottoneMagazzinaggioMouseClicked(evt);
            }
        });

        jPanel77.setBackground(new java.awt.Color(255, 255, 255));

        BottoneMagazzino.setText("Magazzino");
        BottoneMagazzino.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BottoneMagazzinoMouseClicked(evt);
            }
        });

        jButton112.setText("⊳");
        jButton112.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton112MouseClicked(evt);
            }
        });

        jPanel78.setBackground(new java.awt.Color(255, 255, 255));

        TestoMagazzino.setText("Testo");

        jLabel224.setText("Costo:");

        jLabel225.setText("🪙 Monete");

        jLabel226.setText("🪨 Pietra");

        RisorsaMoneteMagazzino.setText("0/0");

        RisorsaPietraMagazzino.setText("0/0");

        javax.swing.GroupLayout jPanel78Layout = new javax.swing.GroupLayout(jPanel78);
        jPanel78.setLayout(jPanel78Layout);
        jPanel78Layout.setHorizontalGroup(
            jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel78Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TestoMagazzino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel78Layout.createSequentialGroup()
                        .addComponent(jLabel224)
                        .addGap(57, 57, 57)
                        .addGroup(jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel225, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel226, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(RisorsaPietraMagazzino, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(RisorsaMoneteMagazzino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 60, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel78Layout.setVerticalGroup(
            jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel78Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TestoMagazzino)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel224)
                    .addComponent(jLabel225)
                    .addComponent(RisorsaMoneteMagazzino))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel226)
                    .addComponent(RisorsaPietraMagazzino))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BottoneSerbatoio.setText("Serbatoio dell'Acqua");
        BottoneSerbatoio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BottoneSerbatoioMouseClicked(evt);
            }
        });

        jButton114.setText("⊳");
        jButton114.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton114MouseClicked(evt);
            }
        });

        jPanel79.setBackground(new java.awt.Color(255, 255, 255));

        TestoSerbatoio.setText("Testo");

        jLabel231.setText("🪙 Monete");

        jLabel230.setText("Costo:");

        jLabel232.setText("🪵 Legno");

        jLabel233.setText("🪨 Pietra");

        RisorsaMoneteSerbatoio.setText("0/0");

        RisorsaLegnoSerbatoio.setText("0/0");

        RisorsaPietraSerbatoio.setText("0/0");

        javax.swing.GroupLayout jPanel79Layout = new javax.swing.GroupLayout(jPanel79);
        jPanel79.setLayout(jPanel79Layout);
        jPanel79Layout.setHorizontalGroup(
            jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel79Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TestoSerbatoio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel79Layout.createSequentialGroup()
                        .addComponent(jLabel230)
                        .addGap(66, 66, 66)
                        .addGroup(jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel79Layout.createSequentialGroup()
                                .addComponent(jLabel233, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(RisorsaPietraSerbatoio, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel79Layout.createSequentialGroup()
                                .addGroup(jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel232, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel231, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(RisorsaMoneteSerbatoio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(RisorsaLegnoSerbatoio, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))))
                        .addGap(0, 38, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel79Layout.setVerticalGroup(
            jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel79Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TestoSerbatoio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel230)
                    .addComponent(jLabel231)
                    .addComponent(RisorsaMoneteSerbatoio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel232)
                    .addComponent(RisorsaLegnoSerbatoio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel233)
                    .addComponent(RisorsaPietraSerbatoio))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BottoneCaveau.setText("Caveau");
        BottoneCaveau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BottoneCaveauMouseClicked(evt);
            }
        });

        jButton116.setText("⊳");
        jButton116.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton116MouseClicked(evt);
            }
        });

        jPanel80.setBackground(new java.awt.Color(255, 255, 255));

        TestoCaveau.setText("Testo");

        jLabel238.setText("Costo:");

        jLabel239.setText("🪙 Monete");

        jLabel240.setText("🪨 Pietra");

        RisorsaMoneteCaveau.setText("0/0");

        RisorsaPietraCaveau.setText("0/0");

        javax.swing.GroupLayout jPanel80Layout = new javax.swing.GroupLayout(jPanel80);
        jPanel80.setLayout(jPanel80Layout);
        jPanel80Layout.setHorizontalGroup(
            jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel80Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TestoCaveau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel80Layout.createSequentialGroup()
                        .addComponent(jLabel238)
                        .addGap(56, 56, 56)
                        .addGroup(jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel240, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel239, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(RisorsaPietraCaveau, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(RisorsaMoneteCaveau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(54, 54, 54)))
                .addContainerGap())
        );
        jPanel80Layout.setVerticalGroup(
            jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel80Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TestoCaveau)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel238)
                    .addComponent(jLabel239)
                    .addComponent(RisorsaMoneteCaveau))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel240)
                    .addComponent(RisorsaPietraCaveau))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel77Layout = new javax.swing.GroupLayout(jPanel77);
        jPanel77.setLayout(jPanel77Layout);
        jPanel77Layout.setHorizontalGroup(
            jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel77Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel78, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel77Layout.createSequentialGroup()
                        .addComponent(BottoneMagazzino, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton112))
                    .addGroup(jPanel77Layout.createSequentialGroup()
                        .addComponent(BottoneSerbatoio, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton114))
                    .addComponent(jPanel79, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel77Layout.createSequentialGroup()
                        .addComponent(BottoneCaveau, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton116))
                    .addComponent(jPanel80, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel77Layout.setVerticalGroup(
            jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel77Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BottoneMagazzino, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton112))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel78, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BottoneSerbatoio, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton114))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel79, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BottoneCaveau, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton116))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel80, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel243.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel243.setText("Usa i Pezzi di Tempo");

        BottoneTempo.setText("▼");
        BottoneTempo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BottoneTempoMouseClicked(evt);
            }
        });

        jPanel81.setBackground(new java.awt.Color(255, 255, 255));

        BottonePezziTempo.setText("Usa Pezzi di Tempo(Ricerca)");
        BottonePezziTempo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BottonePezziTempoMouseClicked(evt);
            }
        });

        jButton119.setText("⊳");
        jButton119.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton119MouseClicked(evt);
            }
        });

        jPanel82.setBackground(new java.awt.Color(255, 255, 255));

        TestoTempo.setText("Testo");

        jLabel245.setText("Costo:");

        jLabel246.setText("⏲  Pezzi di Tempo");

        RisorsaTempo.setText("0/3000");

        javax.swing.GroupLayout jPanel82Layout = new javax.swing.GroupLayout(jPanel82);
        jPanel82.setLayout(jPanel82Layout);
        jPanel82Layout.setHorizontalGroup(
            jPanel82Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel82Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel82Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TestoTempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel82Layout.createSequentialGroup()
                        .addComponent(jLabel245)
                        .addGap(62, 62, 62)
                        .addComponent(jLabel246)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RisorsaTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel82Layout.setVerticalGroup(
            jPanel82Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel82Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TestoTempo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel82Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel245)
                    .addComponent(jLabel246)
                    .addComponent(RisorsaTempo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton113.setText("Usa Pezzi di Tempo(Salto temporale)");
        jButton113.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton113MouseClicked(evt);
            }
        });

        jButton120.setText("⊳");
        jButton120.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton120MouseClicked(evt);
            }
        });

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));

        jLabel204.setText("Testo");

        jLabel205.setText("Costo:");

        jLabel210.setText("⏲  Pezzi di Tempo");

        jLabel211.setText("0/3000");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel204, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel205)
                        .addGap(62, 62, 62)
                        .addComponent(jLabel210)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel211)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel204)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel205)
                    .addComponent(jLabel210)
                    .addComponent(jLabel211))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel81Layout = new javax.swing.GroupLayout(jPanel81);
        jPanel81.setLayout(jPanel81Layout);
        jPanel81Layout.setHorizontalGroup(
            jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel81Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel82, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel81Layout.createSequentialGroup()
                        .addGroup(jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel81Layout.createSequentialGroup()
                                .addComponent(BottonePezziTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton119))
                            .addGroup(jPanel81Layout.createSequentialGroup()
                                .addComponent(jButton113, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton120)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel81Layout.setVerticalGroup(
            jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel81Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BottonePezziTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton119))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel82, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton113, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton120))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BottoneRicercatore.setText("Compra Ricercatore 🪙 200");
        BottoneRicercatore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BottoneRicercatoreMouseClicked(evt);
            }
        });

        BottoneRaccolta.setText("▼");
        BottoneRaccolta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BottoneRaccoltaMouseClicked(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel27.setText("Alloggiamento");

        jButton1.setText("▼");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        BottoneCabina1.setText("Cabina del Ricercatore");
        BottoneCabina1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BottoneCabina1MouseClicked(evt);
            }
        });

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jLabel28.setText("Testo");

        jLabel29.setText("Costo:");

        jLabel30.setText("🪙 Monete");

        jLabel31.setText("🪵 Legno");

        jLabel32.setText("🪨 Pietra");

        RisorsaMoneteCabina.setText("0/0");

        RisorsaLegnoCabina.setText("0/0");

        RisorsaPietraCabina.setText("0/0");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(84, 84, 84)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(RisorsaMoneteCabina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(RisorsaLegnoCabina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(RisorsaPietraCabina, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addGap(0, 115, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30)
                    .addComponent(RisorsaMoneteCabina))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(RisorsaLegnoCabina))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(RisorsaPietraCabina))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton3.setText("⊳");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jButton7.setText("Dormitorio per Apprendisti");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });

        jButton8.setText("⊳");
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        jLabel43.setText("Testo");

        jLabel44.setText("Costo:");

        jLabel45.setText("🪙 Monete");

        jLabel46.setText("🪵 Legno");

        jLabel47.setText("🪨 Pietra");

        RisorsaApprendistaMonete.setText("0/0");

        RisorsaApprendistaLegno.setText("0/0");

        RisorsaApprendistaPietra.setText("0/0");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(15, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(RisorsaApprendistaMonete, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(RisorsaApprendistaLegno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(RisorsaApprendistaPietra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(23, 23, 23))))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel43)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(jLabel45)
                    .addComponent(RisorsaApprendistaMonete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(RisorsaApprendistaLegno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(RisorsaApprendistaPietra))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(BottoneCabina1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3))
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8))
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BottoneCabina1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel200.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel200.setText("Mana");

        jButton121.setText("Costruire una stazione di lavorazione(🪙2k 🪵2k,⛓ 100)");
        jButton121.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton121MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PanneloPrincipaleLayout = new javax.swing.GroupLayout(PanneloPrincipale);
        PanneloPrincipale.setLayout(PanneloPrincipaleLayout);
        PanneloPrincipaleLayout.setHorizontalGroup(
            PanneloPrincipaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanneloPrincipaleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanneloPrincipaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanneloPrincipaleLayout.createSequentialGroup()
                        .addComponent(jPanel75, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanneloPrincipaleLayout.createSequentialGroup()
                        .addGroup(PanneloPrincipaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PanneloPrincipaleLayout.createSequentialGroup()
                                .addComponent(jLabel213, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BottoneProduzione))
                            .addGroup(PanneloPrincipaleLayout.createSequentialGroup()
                                .addComponent(jLabel191, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BottoneRaccolta))
                            .addGroup(PanneloPrincipaleLayout.createSequentialGroup()
                                .addComponent(jLabel200)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BottoneMana)))
                        .addGap(28, 28, 28))
                    .addGroup(PanneloPrincipaleLayout.createSequentialGroup()
                        .addGroup(PanneloPrincipaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel77, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel81, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanneloPrincipaleLayout.createSequentialGroup()
                        .addComponent(jButton121)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanneloPrincipaleLayout.createSequentialGroup()
                        .addGroup(PanneloPrincipaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PanneloPrincipaleLayout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addGroup(PanneloPrincipaleLayout.createSequentialGroup()
                                .addComponent(jLabel222, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BottoneMagazzinaggio))
                            .addGroup(PanneloPrincipaleLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel243)
                                .addGap(297, 297, 297)
                                .addComponent(BottoneTempo)))
                        .addGap(28, 28, 28))
                    .addGroup(PanneloPrincipaleLayout.createSequentialGroup()
                        .addGroup(PanneloPrincipaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel71, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel67, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BottoneRicercatore))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        PanneloPrincipaleLayout.setVerticalGroup(
            PanneloPrincipaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanneloPrincipaleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanneloPrincipaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel191)
                    .addComponent(BottoneRaccolta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel67, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanneloPrincipaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BottoneMana)
                    .addComponent(jLabel200))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel71, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanneloPrincipaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel213)
                    .addComponent(BottoneProduzione))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel75, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanneloPrincipaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel222)
                    .addComponent(BottoneMagazzinaggio))
                .addGap(9, 9, 9)
                .addComponent(jPanel77, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanneloPrincipaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel243)
                    .addComponent(BottoneTempo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel81, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BottoneRicercatore, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanneloPrincipaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton121)
                .addContainerGap(371, Short.MAX_VALUE))
        );

        jPanel12.add(PanneloPrincipale, "CardPrincipale");

        PanelloRitirati.setBackground(new java.awt.Color(255, 255, 255));

        jLabel100.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel100.setText("Pensionamento");

        jLabel101.setText("jLabel101");

        jLabel102.setText("jLabel102");

        jLabel103.setText("jLabel103");

        jButton43.setText("Sei Sicuro di andare in pensione?");
        jButton43.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton43MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PanelloRitiratiLayout = new javax.swing.GroupLayout(PanelloRitirati);
        PanelloRitirati.setLayout(PanelloRitiratiLayout);
        PanelloRitiratiLayout.setHorizontalGroup(
            PanelloRitiratiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelloRitiratiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelloRitiratiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel100, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel101, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel102, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel103, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton43, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        PanelloRitiratiLayout.setVerticalGroup(
            PanelloRitiratiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelloRitiratiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel100)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel101)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel102)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel103)
                .addGap(18, 18, 18)
                .addComponent(jButton43)
                .addContainerGap(2401, Short.MAX_VALUE))
        );

        jPanel12.add(PanelloRitirati, "PanelloRitirati");

        CardHelp.setBackground(new java.awt.Color(255, 255, 255));
        CardHelp.setMaximumSize(null);

        jLabel63.setBackground(new java.awt.Color(255, 255, 255));
        jLabel63.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel63.setText("Help");

        jLabel64.setText("Impara a giocare!");

        jLabel65.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        jLabel65.setText("Introduzione");

        jButton25.setText("⊳");
        jButton25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton25MouseClicked(evt);
            }
        });

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));

        jLabel66.setBackground(new java.awt.Color(255, 255, 255));
        jLabel66.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        jLabel66.setText("Benvenuto in Magical Research!");

        jLabel67.setText("jLabel67");

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel66)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel67)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel68.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        jLabel68.setText("Eventi");

        jButton26.setText("⊳");
        jButton26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton26MouseClicked(evt);
            }
        });

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));

        jLabel69.setText("jLabel69");

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel69)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel70.setBackground(new java.awt.Color(255, 255, 255));
        jLabel70.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        jLabel70.setText("Incantesimi");

        jButton27.setText("⊳");
        jButton27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton27MouseClicked(evt);
            }
        });

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));

        jLabel71.setText("jLabel71");

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel71)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel72.setBackground(new java.awt.Color(255, 255, 255));
        jLabel72.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        jLabel72.setText("Campus");

        jButton28.setText("⊳");
        jButton28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton28MouseClicked(evt);
            }
        });

        jPanel32.setBackground(new java.awt.Color(255, 255, 255));

        jLabel73.setText("jLabel73");

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel73)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel74.setBackground(new java.awt.Color(255, 255, 255));
        jLabel74.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        jLabel74.setText("Storie");

        jButton29.setText("⊳");
        jButton29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton29MouseClicked(evt);
            }
        });

        jPanel33.setBackground(new java.awt.Color(255, 255, 255));

        jLabel75.setText("jLabel75");

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel75)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel76.setBackground(new java.awt.Color(255, 255, 255));
        jLabel76.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        jLabel76.setText("Statistiche");

        jButton30.setText("⊳");
        jButton30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton30MouseClicked(evt);
            }
        });

        jPanel34.setBackground(new java.awt.Color(255, 255, 255));

        jLabel77.setText("jLabel77");

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel77))
        );

        jLabel78.setBackground(new java.awt.Color(255, 255, 255));
        jLabel78.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        jLabel78.setText("Impostazioni / Salva dati");

        jButton31.setText("⊳");
        jButton31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton31MouseClicked(evt);
            }
        });

        jPanel35.setBackground(new java.awt.Color(255, 255, 255));

        jLabel79.setText("jLabel79");

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel79)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel146.setFont(new java.awt.Font("Cantarell", 1, 13)); // NOI18N
        jLabel146.setText("progresso offline");

        jButton70.setText("⊳");
        jButton70.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton70MouseClicked(evt);
            }
        });

        jPanel54.setBackground(new java.awt.Color(255, 255, 255));

        jLabel147.setText("jLabel147");

        javax.swing.GroupLayout jPanel54Layout = new javax.swing.GroupLayout(jPanel54);
        jPanel54.setLayout(jPanel54Layout);
        jPanel54Layout.setHorizontalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel147, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel54Layout.setVerticalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel147)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel148.setFont(new java.awt.Font("Cantarell", 1, 13)); // NOI18N
        jLabel148.setText("Ricerca");

        jButton71.setText("⊳");
        jButton71.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton71MouseClicked(evt);
            }
        });

        jPanel55.setBackground(new java.awt.Color(255, 255, 255));

        jLabel149.setText("jLabel149");

        javax.swing.GroupLayout jPanel55Layout = new javax.swing.GroupLayout(jPanel55);
        jPanel55.setLayout(jPanel55Layout);
        jPanel55Layout.setHorizontalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel149, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel55Layout.setVerticalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel149)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel150.setFont(new java.awt.Font("Cantarell", 1, 13)); // NOI18N
        jLabel150.setText("Pensionamento");

        jButton72.setText("⊳");
        jButton72.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton72MouseClicked(evt);
            }
        });

        jPanel56.setBackground(new java.awt.Color(255, 255, 255));

        jLabel151.setText("jLabel151");

        javax.swing.GroupLayout jPanel56Layout = new javax.swing.GroupLayout(jPanel56);
        jPanel56.setLayout(jPanel56Layout);
        jPanel56Layout.setHorizontalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel151, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel56Layout.setVerticalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel151)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout CardHelpLayout = new javax.swing.GroupLayout(CardHelp);
        CardHelp.setLayout(CardHelpLayout);
        CardHelpLayout.setHorizontalGroup(
            CardHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CardHelpLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CardHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CardHelpLayout.createSequentialGroup()
                        .addGroup(CardHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel31, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel30, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel29, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(62, 62, 62))
                    .addGroup(CardHelpLayout.createSequentialGroup()
                        .addGroup(CardHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CardHelpLayout.createSequentialGroup()
                        .addGroup(CardHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(CardHelpLayout.createSequentialGroup()
                                .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton29))
                            .addGroup(CardHelpLayout.createSequentialGroup()
                                .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton28))
                            .addGroup(CardHelpLayout.createSequentialGroup()
                                .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton27))
                            .addGroup(CardHelpLayout.createSequentialGroup()
                                .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton26))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CardHelpLayout.createSequentialGroup()
                                .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton25))
                            .addGroup(CardHelpLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(CardHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton31)
                                    .addComponent(jButton30)
                                    .addComponent(jButton70)
                                    .addComponent(jButton71)
                                    .addComponent(jButton72))))
                        .addGap(41, 41, 41))))
            .addGroup(CardHelpLayout.createSequentialGroup()
                .addGroup(CardHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(CardHelpLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(CardHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel146, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel148, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel150, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        CardHelpLayout.setVerticalGroup(
            CardHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CardHelpLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel63)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel64)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CardHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65)
                    .addComponent(jButton25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CardHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68)
                    .addComponent(jButton26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CardHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel70)
                    .addComponent(jButton27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CardHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel72)
                    .addComponent(jButton28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CardHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel74)
                    .addComponent(jButton29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CardHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel76)
                    .addComponent(jButton30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CardHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel78)
                    .addComponent(jButton31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CardHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel146)
                    .addComponent(jButton70))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CardHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel148)
                    .addComponent(jButton71))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CardHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel150)
                    .addComponent(jButton72))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel12.add(CardHelp, "CardHelp");

        PanelloImpostazioni.setBackground(new java.awt.Color(255, 255, 255));

        jLabel80.setBackground(new java.awt.Color(255, 255, 255));
        jLabel80.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel80.setText("Impostazioni");

        jLabel81.setBackground(new java.awt.Color(255, 255, 255));
        jLabel81.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        jLabel81.setText("Tema e Interfaccia");

        jButton32.setText("⊳");
        jButton32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton32MouseClicked(evt);
            }
        });

        jPanel36.setBackground(new java.awt.Color(255, 255, 255));

        jLabel82.setText("Cambia i colori per essere più facile per gli occhi");

        jCheckBox1.setText("Abilita la modalità scura");
        jCheckBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox1MouseClicked(evt);
            }
        });

        jLabel83.setText("jLabel83");

        jLabel84.setText("colore dell'interfaccia utente del gioco");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elemento Primario", "Fuoco", "Terra", "Acqua", "Aria" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel82)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel83)
                .addGap(18, 18, 18)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel84)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel85.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        jLabel85.setText("Salva File");

        jButton33.setText("⊳");
        jButton33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton33MouseClicked(evt);
            }
        });

        jPanel37.setBackground(new java.awt.Color(255, 255, 255));

        jLabel86.setText("jLabel86");

        jButton34.setForeground(new java.awt.Color(255, 255, 255));
        jButton34.setText("Salva File");
        jButton34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton34MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel86)
                .addGap(18, 18, 18)
                .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel87.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        jLabel87.setText("Carica File");

        jButton35.setText("⊳");
        jButton35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton35MouseClicked(evt);
            }
        });

        jPanel38.setBackground(new java.awt.Color(255, 255, 255));

        jLabel88.setText("jLabel88");

        jButton36.setForeground(new java.awt.Color(255, 255, 255));
        jButton36.setText("Carica da File");
        jButton36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton36MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel88)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelloImpostazioniLayout = new javax.swing.GroupLayout(PanelloImpostazioni);
        PanelloImpostazioni.setLayout(PanelloImpostazioniLayout);
        PanelloImpostazioniLayout.setHorizontalGroup(
            PanelloImpostazioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelloImpostazioniLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelloImpostazioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelloImpostazioniLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelloImpostazioniLayout.createSequentialGroup()
                        .addGroup(PanelloImpostazioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PanelloImpostazioniLayout.createSequentialGroup()
                                .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton35))
                            .addGroup(PanelloImpostazioniLayout.createSequentialGroup()
                                .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton33))
                            .addGroup(PanelloImpostazioniLayout.createSequentialGroup()
                                .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton32)))
                        .addGap(48, 48, 48))
                    .addGroup(PanelloImpostazioniLayout.createSequentialGroup()
                        .addGroup(PanelloImpostazioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel80, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel37, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel38, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        PanelloImpostazioniLayout.setVerticalGroup(
            PanelloImpostazioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelloImpostazioniLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel80)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelloImpostazioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel81)
                    .addComponent(jButton32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelloImpostazioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel85)
                    .addComponent(jButton33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelloImpostazioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel87)
                    .addComponent(jButton35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(2121, Short.MAX_VALUE))
        );

        jPanel12.add(PanelloImpostazioni, "cardImpostazioni");

        PanelloAbout.setBackground(new java.awt.Color(255, 255, 255));

        jLabel89.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel89.setText("Informazioni su");

        jLabel90.setFont(new java.awt.Font("Cantarell", 0, 20)); // NOI18N
        jLabel90.setText("Magic Research");

        jLabel91.setFont(new java.awt.Font("Cantarell", 1, 14)); // NOI18N
        jLabel91.setText("Versione definitiva");

        jLabel92.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        jLabel92.setText("Versione 1.15.0 (1706683748852)");

        jLabel93.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        jLabel93.setText("Gioco di Emanuele Ferrara");

        jLabel94.setFont(new java.awt.Font("Cantarell", 1, 14)); // NOI18N
        jLabel94.setText("Crediti");

        jLabel95.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        jLabel95.setText("A game by @Maticolotto");

        jLabel96.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        jLabel96.setText("Fai un giro nel gioco originale ");

        javax.swing.GroupLayout PanelloAboutLayout = new javax.swing.GroupLayout(PanelloAbout);
        PanelloAbout.setLayout(PanelloAboutLayout);
        PanelloAboutLayout.setHorizontalGroup(
            PanelloAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelloAboutLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelloAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel89)
                    .addComponent(jLabel90)
                    .addComponent(jLabel91)
                    .addComponent(jLabel92)
                    .addComponent(jLabel93)
                    .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel95)
                    .addComponent(jLabel96))
                .addContainerGap(304, Short.MAX_VALUE))
        );
        PanelloAboutLayout.setVerticalGroup(
            PanelloAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelloAboutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel89)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel90)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel91)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel92)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel93)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel94)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel95)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel96)
                .addContainerGap(2340, Short.MAX_VALUE))
        );

        jPanel12.add(PanelloAbout, "CardAbout");

        PanelloRicerca.setBackground(new java.awt.Color(255, 255, 255));

        jLabel154.setText("Scuole");

        jPanel57.setBackground(new java.awt.Color(255, 255, 255));

        jLabel155.setText("Evocazione:");

        jLabel156.setText("1");

        jLabel157.setText("0");

        jButton73.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jButton73.setText("-");
        jButton73.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton73MouseClicked(evt);
            }
        });

        jButton74.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jButton74.setText("+");
        jButton74.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton74MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel57Layout = new javax.swing.GroupLayout(jPanel57);
        jPanel57.setLayout(jPanel57Layout);
        jPanel57Layout.setHorizontalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel155)
                .addGap(1, 1, 1)
                .addComponent(jLabel156)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 261, Short.MAX_VALUE)
                .addComponent(jLabel157, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton73)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton74)
                .addGap(49, 49, 49))
        );
        jPanel57Layout.setVerticalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel155)
                    .addComponent(jLabel156)
                    .addComponent(jLabel157)
                    .addComponent(jButton73)
                    .addComponent(jButton74))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel59.setBackground(new java.awt.Color(255, 255, 255));

        jLabel161.setText("Incantesimo: ");

        jLabel162.setText("1");

        jLabel163.setText("0");

        jButton77.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jButton77.setText("+");
        jButton77.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton77MouseClicked(evt);
            }
        });

        jButton78.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jButton78.setText("-");
        jButton78.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton78MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel59Layout = new javax.swing.GroupLayout(jPanel59);
        jPanel59.setLayout(jPanel59Layout);
        jPanel59Layout.setHorizontalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel161)
                .addGap(1, 1, 1)
                .addComponent(jLabel162)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 252, Short.MAX_VALUE)
                .addComponent(jLabel163, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton78)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton77)
                .addGap(49, 49, 49))
        );
        jPanel59Layout.setVerticalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel161)
                    .addComponent(jLabel162)
                    .addComponent(jLabel163)
                    .addComponent(jButton77)
                    .addComponent(jButton78))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel61.setBackground(new java.awt.Color(255, 255, 255));

        jLabel167.setText("Illusione:");

        jLabel168.setText("1");

        jButton80.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jButton80.setText("+");
        jButton80.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton80MouseClicked(evt);
            }
        });

        jButton81.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jButton81.setText("-");
        jButton81.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton81MouseClicked(evt);
            }
        });

        jLabel169.setText("0");

        javax.swing.GroupLayout jPanel61Layout = new javax.swing.GroupLayout(jPanel61);
        jPanel61.setLayout(jPanel61Layout);
        jPanel61Layout.setHorizontalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel61Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel167)
                .addGap(1, 1, 1)
                .addComponent(jLabel168)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 276, Short.MAX_VALUE)
                .addComponent(jLabel169, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton81)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton80)
                .addGap(49, 49, 49))
        );
        jPanel61Layout.setVerticalGroup(
            jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel61Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel167)
                    .addComponent(jLabel168)
                    .addComponent(jButton80)
                    .addComponent(jButton81)
                    .addComponent(jLabel169))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel176.setText("Ricercatori disponibili:");

        jLabel177.setText("0/0");

        jLabel178.setText("Capacità del ricercatore:");

        jLabel179.setText("0/0");

        jLabel180.setText("Exp per ricercatore:");

        jLabel181.setText("1/sec");

        jLabel182.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel182.setText("Azioni");

        jButton88.setText("▼");
        jButton88.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton88MouseClicked(evt);
            }
        });

        jPanel66.setBackground(new java.awt.Color(255, 255, 255));

        jButton89.setText("Assumere un Ricercatore");
        jButton89.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton89MouseClicked(evt);
            }
        });

        jPanel58.setBackground(new java.awt.Color(255, 255, 255));

        jLabel159.setText("Costo:");

        jLabel160.setText("🪙Monete:");

        jLabel164.setText("0/0");

        jLabel158.setText("jLabel158");

        javax.swing.GroupLayout jPanel58Layout = new javax.swing.GroupLayout(jPanel58);
        jPanel58.setLayout(jPanel58Layout);
        jPanel58Layout.setHorizontalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel158, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel58Layout.createSequentialGroup()
                        .addComponent(jLabel159)
                        .addGap(98, 98, 98)
                        .addComponent(jLabel160)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel164, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel58Layout.setVerticalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel158)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel159)
                    .addComponent(jLabel160)
                    .addComponent(jLabel164))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton75.setText("⊳");
        jButton75.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton75MouseClicked(evt);
            }
        });

        jButton76.setText("Usa Pezzi di Tempo");
        jButton76.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton76MouseClicked(evt);
            }
        });

        jPanel60.setBackground(new java.awt.Color(255, 255, 255));

        jLabel165.setText("jLabel165");

        jLabel166.setText("Costo:");

        jLabel170.setText("⏲ Pezzi di Tempo:");

        jLabel171.setText("0/0");

        javax.swing.GroupLayout jPanel60Layout = new javax.swing.GroupLayout(jPanel60);
        jPanel60.setLayout(jPanel60Layout);
        jPanel60Layout.setHorizontalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel60Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel165, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel60Layout.createSequentialGroup()
                        .addComponent(jLabel166)
                        .addGap(76, 76, 76)
                        .addComponent(jLabel170)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel171, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel60Layout.setVerticalGroup(
            jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel60Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel165)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel166)
                    .addComponent(jLabel170)
                    .addComponent(jLabel171))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton79.setText("⊳");
        jButton79.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton79MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel66Layout = new javax.swing.GroupLayout(jPanel66);
        jPanel66.setLayout(jPanel66Layout);
        jPanel66Layout.setHorizontalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel66Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel66Layout.createSequentialGroup()
                        .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton76, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton89, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton75)
                            .addComponent(jButton79)))
                    .addComponent(jPanel60, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel66Layout.setVerticalGroup(
            jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel66Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton89, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton75))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton76, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton79))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel60, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel33.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel33.setText("Edifici");

        jButton2.setText("▼");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jButton4.setText("Cabina del Ricercatore");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        jButton5.setText("⊳");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        jLabel34.setText("Testo");

        jLabel35.setText("Costo:");

        jLabel36.setText("🪙 Monete");

        jLabel37.setText("🪵 Legno");

        jLabel38.setText("🪨 Pietra");

        jLabel39.setText("0/0");

        jLabel40.setText("0/0");

        jLabel41.setText("0/0");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addGap(90, 90, 90)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(jLabel36)
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(jLabel40))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jLabel41))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelloRicercaLayout = new javax.swing.GroupLayout(PanelloRicerca);
        PanelloRicerca.setLayout(PanelloRicercaLayout);
        PanelloRicercaLayout.setHorizontalGroup(
            PanelloRicercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelloRicercaLayout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(jLabel154)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(PanelloRicercaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelloRicercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelloRicercaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelloRicercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelloRicercaLayout.createSequentialGroup()
                        .addGroup(PanelloRicercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelloRicercaLayout.createSequentialGroup()
                                .addComponent(jLabel33)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2))
                            .addGroup(PanelloRicercaLayout.createSequentialGroup()
                                .addComponent(jLabel182, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton88))
                            .addGroup(PanelloRicercaLayout.createSequentialGroup()
                                .addGroup(PanelloRicercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel176, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel178, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel180, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(PanelloRicercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel179)
                                    .addComponent(jLabel177)
                                    .addComponent(jLabel181))))
                        .addGap(35, 35, 35))
                    .addGroup(PanelloRicercaLayout.createSequentialGroup()
                        .addComponent(jPanel66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(PanelloRicercaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelloRicercaLayout.setVerticalGroup(
            PanelloRicercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelloRicercaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel154)
                .addGap(37, 37, 37)
                .addComponent(jPanel57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel59, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanelloRicercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel176)
                    .addComponent(jLabel177))
                .addGap(18, 18, 18)
                .addGroup(PanelloRicercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel178)
                    .addComponent(jLabel179))
                .addGap(18, 18, 18)
                .addGroup(PanelloRicercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel180)
                    .addComponent(jLabel181))
                .addGap(18, 18, 18)
                .addGroup(PanelloRicercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel182)
                    .addComponent(jButton88))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelloRicercaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1779, Short.MAX_VALUE))
        );

        jPanel12.add(PanelloRicerca, "CardRIcerca");

        PanneloCreaItem.setBackground(new java.awt.Color(255, 255, 255));

        jButton132.setText("⊲");
        jButton132.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton132MouseClicked(evt);
            }
        });

        jLabel247.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel247.setText("Creazioni");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tutto", "Oggetto della Missione", "Mano", "Corpo", "Accessorio", "Attrezzatura", "Materiale" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jPanel49.setBackground(new java.awt.Color(255, 255, 255));
        jPanel49.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jChest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jChestMouseClicked(evt);
            }
        });

        jClub.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jClubMouseClicked(evt);
            }
        });

        jSword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSwordMouseClicked(evt);
            }
        });

        jRamo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRamoMouseClicked(evt);
            }
        });

        jIronMail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jIronMailMouseClicked(evt);
            }
        });

        jDagger.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDaggerMouseClicked(evt);
            }
        });

        jWizardsRobe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jWizardsRobeMouseClicked(evt);
            }
        });

        jSickle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSickleMouseClicked(evt);
            }
        });

        jHandAxe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jHandAxeMouseClicked(evt);
            }
        });

        jFirewand.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jFirewandMouseClicked(evt);
            }
        });

        jThiefsGarb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jThiefsGarbMouseClicked(evt);
            }
        });

        jCristallo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCristalloMouseClicked(evt);
            }
        });

        jSandali.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSandaliMouseClicked(evt);
            }
        });

        jCloak.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCloakMouseClicked(evt);
            }
        });

        jClothShoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jClothShoesMouseClicked(evt);
            }
        });

        jEnchantedCloak.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jEnchantedCloakMouseClicked(evt);
            }
        });

        jCloath.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCloathMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel49Layout.createSequentialGroup()
                        .addComponent(jChest, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jRamo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jClub, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jDagger, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSword, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jHandAxe, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jFirewand, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSickle, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel49Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jWizardsRobe, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jThiefsGarb, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel49Layout.createSequentialGroup()
                                .addComponent(jCristallo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jSandali, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jCloath, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jCloak, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jClothShoes, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jEnchantedCloak, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jIronMail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jChest, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRamo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jClub, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDagger, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSword, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jHandAxe, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jFirewand, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSickle, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jIronMail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jWizardsRobe, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jThiefsGarb, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCristallo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSandali, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCloak, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jClothShoes, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jEnchantedCloak, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCloath, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel50.setBackground(new java.awt.Color(255, 255, 255));

        jLabel248.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel248.setText("jLabel248");

        jLabel250.setText("jLabel250");

        jLabel251.setBackground(new java.awt.Color(204, 204, 204));
        jLabel251.setText(".");

        jLabel252.setText("jLabel252");

        jLabel253.setText("Costo:");

        jLabel254.setText("jLabel254");

        jLabel255.setText("jLabel255");

        jLabel256.setText("jLabel256");

        jLabel257.setText("jLabel257");

        jLabel258.setText("jLabel258");

        jButton131.setText("Crea");
        jButton131.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton131MouseClicked(evt);
            }
        });

        jLabel259.setText("jLabel259");

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel50Layout.createSequentialGroup()
                        .addComponent(jLabel252)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel50Layout.createSequentialGroup()
                        .addComponent(jLabel253)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel256, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                            .addComponent(jLabel255, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel254, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel257)
                            .addComponent(jLabel258)
                            .addComponent(jLabel259))
                        .addGap(34, 34, 34))
                    .addGroup(jPanel50Layout.createSequentialGroup()
                        .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel248)
                            .addComponent(jLabel250, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addComponent(jLabel251, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(jPanel50Layout.createSequentialGroup()
                        .addComponent(jButton131)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel251, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel50Layout.createSequentialGroup()
                        .addComponent(jLabel248)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel250)))
                .addGap(26, 26, 26)
                .addComponent(jLabel252)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel253)
                    .addComponent(jLabel254)
                    .addComponent(jLabel257))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel255)
                    .addComponent(jLabel258))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel256)
                    .addComponent(jLabel259))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton131)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanneloCreaItemLayout = new javax.swing.GroupLayout(PanneloCreaItem);
        PanneloCreaItem.setLayout(PanneloCreaItemLayout);
        PanneloCreaItemLayout.setHorizontalGroup(
            PanneloCreaItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanneloCreaItemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanneloCreaItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanneloCreaItemLayout.createSequentialGroup()
                        .addComponent(jButton132)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel247)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanneloCreaItemLayout.setVerticalGroup(
            PanneloCreaItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanneloCreaItemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanneloCreaItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton132)
                    .addComponent(jLabel247))
                .addGap(30, 30, 30)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(2093, Short.MAX_VALUE))
        );

        jPanel12.add(PanneloCreaItem, "CardCrafiting");

        jScrollPane1.setViewportView(jPanel12);

        HomePage.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        PanelloFisso.setBackground(new java.awt.Color(255, 255, 255));
        PanelloFisso.setMaximumSize(new java.awt.Dimension(501, 90));
        PanelloFisso.setLayout(new java.awt.CardLayout());

        FissoPrincipale.setBackground(new java.awt.Color(255, 255, 255));
        FissoPrincipale.setMaximumSize(new java.awt.Dimension(501, 90));
        FissoPrincipale.setMinimumSize(new java.awt.Dimension(501, 90));
        FissoPrincipale.setPreferredSize(new java.awt.Dimension(501, 90));

        jLabel152.setText("Obiettivo attuale");

        jLabel153.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel153.setText("Obiettivo");

        javax.swing.GroupLayout FissoPrincipaleLayout = new javax.swing.GroupLayout(FissoPrincipale);
        FissoPrincipale.setLayout(FissoPrincipaleLayout);
        FissoPrincipaleLayout.setHorizontalGroup(
            FissoPrincipaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FissoPrincipaleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FissoPrincipaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel153, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel152, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 16, Short.MAX_VALUE))
        );
        FissoPrincipaleLayout.setVerticalGroup(
            FissoPrincipaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FissoPrincipaleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel153)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel152)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        PanelloFisso.add(FissoPrincipale, "card4");

        FissoApprendisti.setBackground(new java.awt.Color(255, 255, 255));
        FissoApprendisti.setMaximumSize(new java.awt.Dimension(501, 90));
        FissoApprendisti.setMinimumSize(new java.awt.Dimension(501, 90));
        FissoApprendisti.setPreferredSize(new java.awt.Dimension(501, 90));

        jLabel42.setText("Apprendisti disponibili:");

        jLabel48.setText("Consumo di Mana stimato:");

        jLabel51.setText("0/0");

        jLabel52.setText("0/sec");

        jLabel277.setForeground(new java.awt.Color(204, 204, 0));
        jLabel277.setText("Attenzione: Il tuo Mana non è sufficente per sostenere gli Apprendisti!!");

        javax.swing.GroupLayout FissoApprendistiLayout = new javax.swing.GroupLayout(FissoApprendisti);
        FissoApprendisti.setLayout(FissoApprendistiLayout);
        FissoApprendistiLayout.setHorizontalGroup(
            FissoApprendistiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FissoApprendistiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FissoApprendistiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FissoApprendistiLayout.createSequentialGroup()
                        .addComponent(jLabel277, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(FissoApprendistiLayout.createSequentialGroup()
                        .addGroup(FissoApprendistiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                        .addGroup(FissoApprendistiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                        .addGap(30, 30, 30))))
        );
        FissoApprendistiLayout.setVerticalGroup(
            FissoApprendistiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FissoApprendistiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FissoApprendistiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(jLabel51))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(FissoApprendistiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(jLabel52))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel277)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        PanelloFisso.add(FissoApprendisti, "card3");

        HomePage.add(PanelloFisso, java.awt.BorderLayout.PAGE_START);

        PanelSuperioreG.setPreferredSize(new java.awt.Dimension(721, 31));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Campus");

        javax.swing.GroupLayout PanelSuperioreGLayout = new javax.swing.GroupLayout(PanelSuperioreG);
        PanelSuperioreG.setLayout(PanelSuperioreGLayout);
        PanelSuperioreGLayout.setHorizontalGroup(
            PanelSuperioreGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSuperioreGLayout.createSequentialGroup()
                .addGap(578, 578, 578)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelSuperioreGLayout.setVerticalGroup(
            PanelSuperioreGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelSuperioreGLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(12, 12, 12))
        );

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setMaximumSize(new java.awt.Dimension(364, 1400));
        jPanel8.setMinimumSize(new java.awt.Dimension(364, 1400));
        jPanel8.setPreferredSize(new java.awt.Dimension(364, 1400));

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Evocazione", "Incantesimo", "Illusione" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton13.setText("Espandi tutto");
        jButton13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton13MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButton13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));

        jButton14.setText("Crea Ciottolo          10");
        jButton14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton14MouseClicked(evt);
            }
        });

        jButton15.setText("⊳");
        jButton15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton15MouseClicked(evt);
            }
        });

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));

        jLabel50.setText("Converti Mana in pochi ciottoli +5🪨");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel50)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addComponent(jLabel50)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jButton16.setText("Crea Acqua          20");
        jButton16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton16MouseClicked(evt);
            }
        });

        jButton17.setText("⊳");
        jButton17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton17MouseClicked(evt);
            }
        });

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));

        jLabel54.setText("Converti Mana in +2🌢 ");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel54)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton37.setText("Crea Roccia           40");
        jButton37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton37MouseClicked(evt);
            }
        });

        jButton39.setText("⊳");
        jButton39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton39MouseClicked(evt);
            }
        });

        jPanel39.setBackground(new java.awt.Color(255, 255, 255));

        jLabel98.setText("jLabel98");

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel98, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel98)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton40.setText("Crea Acqua II           180");
        jButton40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton40MouseClicked(evt);
            }
        });

        jPanel40.setBackground(new java.awt.Color(255, 255, 255));

        jLabel99.setText("jLabel99");

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel99, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel99)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton41.setText("⊳");
        jButton41.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton41MouseClicked(evt);
            }
        });

        jPanel42.setBackground(new java.awt.Color(255, 255, 255));

        jLabel113.setText("jLabel113");

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel113, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel113)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton48.setText("Crea Masso           440");
        jButton48.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton48MouseClicked(evt);
            }
        });

        jButton49.setText("⊳");
        jButton49.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton49MouseClicked(evt);
            }
        });

        jPanel43.setBackground(new java.awt.Color(255, 255, 255));

        jLabel114.setText("jLabel114");

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel114, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel114)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton50.setText("Crea Acqua III           1060");
        jButton50.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton50MouseClicked(evt);
            }
        });

        jButton51.setText("⊳");
        jButton51.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton51MouseClicked(evt);
            }
        });

        jPanel44.setBackground(new java.awt.Color(255, 255, 255));

        jLabel115.setText("jLabel115");

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel115, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel115)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton52.setText("Crea Sbarra di Ferro       320");
        jButton52.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton52MouseClicked(evt);
            }
        });

        jButton53.setText("⊳");
        jButton53.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton53MouseClicked(evt);
            }
        });

        jPanel45.setBackground(new java.awt.Color(255, 255, 255));

        jLabel116.setText("jLabel116");

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel116, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel116)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton47.setText("⊳");
        jButton47.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton47MouseClicked(evt);
            }
        });

        jButton46.setText("Crea Minerale di Ferro    20");
        jButton46.setMaximumSize(new java.awt.Dimension(235, 25));
        jButton46.setMinimumSize(new java.awt.Dimension(235, 25));
        jButton46.setPreferredSize(new java.awt.Dimension(235, 25));
        jButton46.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton46MouseClicked(evt);
            }
        });

        jButton122.setText("Evoca Edificio           300");
        jButton122.setPreferredSize(new java.awt.Dimension(220, 25));
        jButton122.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton122MouseClicked(evt);
            }
        });

        jButton123.setText("⊳");
        jButton123.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton123MouseClicked(evt);
            }
        });

        jPanel28.setBackground(new java.awt.Color(255, 255, 255));

        jLabel214.setText("jLabel214");

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel214, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel214)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton15))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton17))
                    .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton39))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jButton40, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton41))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jButton46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton47))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jButton48, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton49))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jButton50, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton51))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jButton52, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton53))
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jButton122, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton123))
                    .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton40, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton41))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton46, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton47))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton48, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton49))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton50, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton51))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton52, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton53))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton122, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton123))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton12.setText("▼");
        jButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton12MouseClicked(evt);
            }
        });

        jLabel58.setFont(new java.awt.Font("Liberation Sans", 0, 15)); // NOI18N
        jLabel58.setText("Lancia Incantesimo");

        jLabel49.setText("Per scuola");

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));
        jPanel27.setMaximumSize(new java.awt.Dimension(282, 177));
        jPanel27.setMinimumSize(new java.awt.Dimension(282, 177));
        jPanel27.setName(""); // NOI18N

        jButton20.setText("Spettacolo di Magia       30");
        jButton20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton20MouseClicked(evt);
            }
        });

        jButton21.setText("⊳");
        jButton21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton21MouseClicked(evt);
            }
        });

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));
        jPanel26.setMaximumSize(new java.awt.Dimension(245, 95));
        jPanel26.setMinimumSize(new java.awt.Dimension(245, 95));

        jLabel244.setText("jLabel244");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel244, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel244)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton54.setText("Spettacolo del Vento         70");
        jButton54.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton54MouseClicked(evt);
            }
        });

        jButton55.setText("⊳");
        jButton55.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton55MouseClicked(evt);
            }
        });

        jPanel46.setBackground(new java.awt.Color(255, 255, 255));

        jLabel117.setBackground(new java.awt.Color(255, 255, 255));
        jLabel117.setText("jLabel117");

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel117, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel46Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel117)
                .addContainerGap())
        );

        jButton56.setText("Spettacolo di Bolle           150");
        jButton56.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton56MouseClicked(evt);
            }
        });

        jButton57.setText("⊳");
        jButton57.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton57MouseClicked(evt);
            }
        });

        jPanel47.setBackground(new java.awt.Color(255, 255, 255));

        jLabel118.setText("jLabel118");

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel118, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel118)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton59.setText("⊳");
        jButton59.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton59MouseClicked(evt);
            }
        });

        jButton58.setText("Spettacolo di Fuoco           580");
        jButton58.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton58MouseClicked(evt);
            }
        });

        jPanel48.setBackground(new java.awt.Color(255, 255, 255));

        jLabel119.setText("jLabel119");

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel119, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel119)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton21))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jButton54, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton55))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jButton56, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton57))
                    .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jButton58, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton59))
                    .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton54, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton55))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton56, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton57))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton58, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton59))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));

        jButton18.setText("Incanta i Getti di Mana       60");
        jButton18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton18MouseClicked(evt);
            }
        });

        jButton19.setText("⊳");
        jButton19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton19MouseClicked(evt);
            }
        });

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));

        jLabel57.setText("jLabel57");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addComponent(jLabel57)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel52.setBackground(new java.awt.Color(255, 255, 255));

        jLabel142.setText("jLabel142");

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel142, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel142)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton67.setText("Incanta i Depositi di Legno 80");
        jButton67.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton67MouseClicked(evt);
            }
        });

        jButton68.setText("⊳");
        jButton68.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton68MouseClicked(evt);
            }
        });

        jButton66.setText("Incanta Geyser di Mana 160");
        jButton66.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton66MouseClicked(evt);
            }
        });

        jButton69.setText("⊳");
        jButton69.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton69MouseClicked(evt);
            }
        });

        jPanel53.setBackground(new java.awt.Color(255, 255, 255));

        jLabel143.setText("jLabel143");

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel143, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel143)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jButton66, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton69)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addComponent(jButton67, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton68))
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton19))
                            .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton67, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton68))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton66, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton69))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton12)
                        .addGap(83, 83, 83))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(39, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(jLabel58))
                            .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 13, Short.MAX_VALUE))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel58)
                .addGap(17, 17, 17)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton12)
                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel8);

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane4.setBorder(null);
        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setMaximumSize(new java.awt.Dimension(367, 627));
        jScrollPane4.setMinimumSize(new java.awt.Dimension(367, 627));
        jScrollPane4.setPreferredSize(new java.awt.Dimension(367, 627));

        PanelloInformazioni.setBackground(new java.awt.Color(255, 255, 255));
        PanelloInformazioni.setMaximumSize(new java.awt.Dimension(367, 900));
        PanelloInformazioni.setMinimumSize(new java.awt.Dimension(367, 900));
        PanelloInformazioni.setPreferredSize(new java.awt.Dimension(367, 900));

        TEsto.setBackground(new java.awt.Color(255, 255, 255));
        TEsto.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        TEsto.setText("jLabel3");

        campusB.setText(" Campus [C]");
        campusB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campusBMouseClicked(evt);
            }
        });

        helpb.setText("Aiuto");
        helpb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                helpbMouseClicked(evt);
            }
        });

        impostazioniB.setText(" Impostazioni");
        impostazioniB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                impostazioniBMouseClicked(evt);
            }
        });

        jButton6.setText(" Informazioni su");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel5.setText("jLabel5");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setMaximumSize(new java.awt.Dimension(2147483647, 627));
        jPanel6.setPreferredSize(new java.awt.Dimension(627, 131));
        jPanel6.setLayout(new java.awt.GridBagLayout());

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("★Mana: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 100;
        jPanel6.add(jLabel3, gridBagConstraints);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("🪨Pietra:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 100;
        jPanel6.add(jLabel7, gridBagConstraints);

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("🌢 Acqua:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 100;
        jPanel6.add(jLabel9, gridBagConstraints);

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("🪙 Monete:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 100;
        jPanel6.add(jLabel11, gridBagConstraints);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 15;
        jPanel6.add(jLabel6, gridBagConstraints);

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 15;
        jPanel6.add(jLabel8, gridBagConstraints);

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 15;
        jPanel6.add(jLabel10, gridBagConstraints);

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 15;
        jPanel6.add(jLabel12, gridBagConstraints);

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("🪵Legno:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 100;
        jPanel6.add(jLabel15, gridBagConstraints);

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 15;
        jPanel6.add(jLabel17, gridBagConstraints);

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("⛓️ Ferro:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.ipadx = 100;
        jPanel6.add(jLabel16, gridBagConstraints);

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.ipadx = 15;
        jPanel6.add(jLabel18, gridBagConstraints);

        jLabel60.setFont(new java.awt.Font("Liberation Sans", 0, 10)); // NOI18N
        jLabel60.setText("jLabel60");
        jPanel6.add(jLabel60, new java.awt.GridBagConstraints());

        jLabel97.setFont(new java.awt.Font("Cantarell", 0, 10)); // NOI18N
        jLabel97.setText("jLabel97");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        jPanel6.add(jLabel97, gridBagConstraints);

        jLabel144.setBackground(new java.awt.Color(255, 255, 255));
        jLabel144.setText("🕒 Pezzi del tempo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.ipadx = 80;
        jPanel6.add(jLabel144, gridBagConstraints);

        jLabel235.setText("🔥 Temperatura:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.ipadx = 80;
        jPanel6.add(jLabel235, gridBagConstraints);

        jLabel145.setBackground(new java.awt.Color(255, 255, 255));
        jLabel145.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.ipadx = 15;
        jPanel6.add(jLabel145, gridBagConstraints);

        jLabel236.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.ipadx = 15;
        jPanel6.add(jLabel236, gridBagConstraints);

        jLabel237.setFont(new java.awt.Font("Cantarell", 0, 10)); // NOI18N
        jLabel237.setText("jLabel237");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 14;
        jPanel6.add(jLabel237, gridBagConstraints);

        jLabel13.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel13.setText("jLabel13");

        BottonEXp.setText("▼");
        BottonEXp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BottonEXpMouseClicked(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new java.awt.GridBagLayout());

        jLabel14.setText("Evocazione: ");
        jPanel7.add(jLabel14, new java.awt.GridBagConstraints());

        jLabel19.setText("Incantesimo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 15;
        jPanel7.add(jLabel19, gridBagConstraints);

        jLabel20.setText("Illusione:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 10;
        jPanel7.add(jLabel20, gridBagConstraints);

        jLabel21.setText("Lv1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 150;
        jPanel7.add(jLabel21, gridBagConstraints);

        jLabel22.setText("Lv1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 150;
        jPanel7.add(jLabel22, gridBagConstraints);

        jLabel23.setText("Lv1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 150;
        jPanel7.add(jLabel23, gridBagConstraints);

        jLabel24.setText("0/0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 40;
        jPanel7.add(jLabel24, gridBagConstraints);

        jLabel25.setText("0/0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 40;
        jPanel7.add(jLabel25, gridBagConstraints);

        jLabel26.setText("0/0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 40;
        jPanel7.add(jLabel26, gridBagConstraints);

        jButton42.setText("Pensionamento");
        jButton42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton42MouseClicked(evt);
            }
        });

        jButton38.setText(" Ricerca");
        jButton38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton38MouseClicked(evt);
            }
        });

        jPanel62.setBackground(new java.awt.Color(255, 255, 255));

        jLabel173.setText("velocità di gioco:");

        jButton83.setText("Normale");
        jButton83.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton83MouseClicked(evt);
            }
        });

        jButton90.setText("2x");
        jButton90.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton90MouseClicked(evt);
            }
        });

        jButton91.setText("8x");
        jButton91.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton91MouseClicked(evt);
            }
        });

        jLabel183.setText("Velocità corrente:");

        jLabel184.setText("1x");

        jLabel185.setText("Costo Pezzi di Tempo: ");

        jLabel186.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        jLabel186.setText("lala");

        javax.swing.GroupLayout jPanel62Layout = new javax.swing.GroupLayout(jPanel62);
        jPanel62.setLayout(jPanel62Layout);
        jPanel62Layout.setHorizontalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel62Layout.createSequentialGroup()
                .addComponent(jLabel173, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jButton83)
                .addGap(6, 6, 6)
                .addComponent(jButton90, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jButton91, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel62Layout.createSequentialGroup()
                .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel185)
                    .addComponent(jLabel183))
                .addGap(141, 141, 141)
                .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel184, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(jLabel186, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel62Layout.setVerticalGroup(
            jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel62Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel62Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel173))
                    .addComponent(jButton83)
                    .addComponent(jButton90)
                    .addComponent(jButton91))
                .addGap(6, 6, 6)
                .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel183)
                    .addComponent(jLabel184))
                .addGap(6, 6, 6)
                .addGroup(jPanel62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel185)
                    .addComponent(jLabel186)))
        );

        jLabel172.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel172.setText("Accelera il tempo");

        jButton82.setText("▼");
        jButton82.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton82MouseClicked(evt);
            }
        });

        BottoneSI.setText("▼");
        BottoneSI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BottoneSIMouseClicked(evt);
            }
        });

        jLabelScuolaE.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        jLabelScuolaE.setText("jLabel53");

        jButton9.setText(" Apprendisti");
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton9MouseClicked(evt);
            }
        });

        jButton124.setText("Inventario");
        jButton124.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton124MouseClicked(evt);
            }
        });

        jButton129.setText("Aggiungi Tempo");
        jButton129.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton129MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PanelloInformazioniLayout = new javax.swing.GroupLayout(PanelloInformazioni);
        PanelloInformazioni.setLayout(PanelloInformazioniLayout);
        PanelloInformazioniLayout.setHorizontalGroup(
            PanelloInformazioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelloInformazioniLayout.createSequentialGroup()
                .addGroup(PanelloInformazioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campusB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(helpb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(impostazioniB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton124, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelloInformazioniLayout.createSequentialGroup()
                        .addGroup(PanelloInformazioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel62, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addGroup(PanelloInformazioniLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BottonEXp))
                    .addGroup(PanelloInformazioniLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelloInformazioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelloInformazioniLayout.createSequentialGroup()
                                .addComponent(TEsto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                                .addComponent(jLabelScuolaE, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8))
                            .addGroup(PanelloInformazioniLayout.createSequentialGroup()
                                .addComponent(jLabel172, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton82))
                            .addGroup(PanelloInformazioniLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BottoneSI))
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(PanelloInformazioniLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton129)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelloInformazioniLayout.setVerticalGroup(
            PanelloInformazioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelloInformazioniLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelloInformazioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TEsto)
                    .addComponent(jLabelScuolaE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campusB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(helpb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(impostazioniB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton124, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelloInformazioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel172)
                    .addComponent(jButton82))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel62, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelloInformazioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(BottoneSI))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelloInformazioniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(BottonEXp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton129)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        jScrollPane4.setViewportView(PanelloInformazioni);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelSuperioreG, javax.swing.GroupLayout.DEFAULT_SIZE, 1264, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(511, 511, 511)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(390, 390, 390)
                    .addComponent(HomePage, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(373, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(PanelSuperioreG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 7, Short.MAX_VALUE))))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(55, 55, 55)
                    .addComponent(HomePage, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(5, Short.MAX_VALUE)))
        );

        jPanel16.add(jPanel5, java.awt.BorderLayout.CENTER);

        barra.setPreferredSize(new java.awt.Dimension(146, 30));
        jPanel16.add(barra, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jPanel16, "CardGioco");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1225, 700));
        jPanel1.setMinimumSize(new java.awt.Dimension(1225, 700));
        jPanel1.setPreferredSize(new java.awt.Dimension(1225, 700));

        jPanel2.setBackground(new java.awt.Color(0, 122, 255));

        jLabel1.setBackground(new java.awt.Color(0, 122, 255));
        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Benvenuto in Magical Research!");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(510, 510, 510)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jLabel2.setText("jLabel2");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel2.setMaximumSize(new java.awt.Dimension(440, 17));
        jLabel2.setPreferredSize(new java.awt.Dimension(440, 17));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setMaximumSize(new java.awt.Dimension(325, 300));
        jPanel3.setMinimumSize(new java.awt.Dimension(325, 300));
        jPanel3.setPreferredSize(new java.awt.Dimension(325, 300));

        TS.setText("Scuole");

        LIS.setText(".");
        LIS.setToolTipText("");
        LIS.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        LIS.setMaximumSize(new java.awt.Dimension(295, 70));
        LIS.setMinimumSize(new java.awt.Dimension(295, 70));
        LIS.setPreferredSize(new java.awt.Dimension(295, 70));

        buttonGroup1.add(EvocazioneB);
        EvocazioneB.setText("Evocazione");
        EvocazioneB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EvocazioneBActionPerformed(evt);
            }
        });

        buttonGroup1.add(IncantoB);
        IncantoB.setText("Incanto");
        IncantoB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IncantoBActionPerformed(evt);
            }
        });

        buttonGroup1.add(IllusioneB);
        IllusioneB.setText("Illusione");
        IllusioneB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IllusioneBActionPerformed(evt);
            }
        });

        LSD.setBackground(new java.awt.Color(255, 255, 255));
        LSD.setFont(new java.awt.Font("Liberation Sans", 0, 12)); // NOI18N
        LSD.setText(".");
        LSD.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        LSD.setMaximumSize(new java.awt.Dimension(296, 46));
        LSD.setMinimumSize(new java.awt.Dimension(296, 46));
        LSD.setPreferredSize(new java.awt.Dimension(296, 46));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(LIS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(134, 134, 134)
                                .addComponent(TS)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LSD, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(EvocazioneB, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(IncantoB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(IllusioneB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(TS)
                .addGap(2, 2, 2)
                .addComponent(LIS, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(EvocazioneB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IncantoB)
                .addGap(2, 2, 2)
                .addComponent(IllusioneB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LSD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setMaximumSize(new java.awt.Dimension(325, 300));
        jPanel4.setMinimumSize(new java.awt.Dimension(325, 300));
        jPanel4.setPreferredSize(new java.awt.Dimension(325, 300));

        TE.setFont(new java.awt.Font("Cantarell", 0, 15)); // NOI18N
        TE.setText("Elementi");

        LIE.setBackground(new java.awt.Color(255, 255, 255));
        LIE.setText(".");
        LIE.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        buttonGroup2.add(FuocoB);
        FuocoB.setText("Fuoco");
        FuocoB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FuocoBActionPerformed(evt);
            }
        });

        buttonGroup2.add(AcquaB);
        AcquaB.setText("Acqua");
        AcquaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AcquaBActionPerformed(evt);
            }
        });

        buttonGroup2.add(TerraB);
        TerraB.setText("Terra");
        TerraB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TerraBActionPerformed(evt);
            }
        });

        buttonGroup2.add(AriaB);
        AriaB.setText("Aria");
        AriaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AriaBActionPerformed(evt);
            }
        });

        LDE.setText(".");
        LDE.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(FuocoB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AcquaB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TerraB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AriaB, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(LIE, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(TE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LDE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(TE)
                .addGap(2, 2, 2)
                .addComponent(LIE)
                .addGap(47, 47, 47)
                .addComponent(FuocoB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AcquaB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TerraB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AriaB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LDE, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                .addContainerGap())
        );

        IB.setFont(new java.awt.Font("Liberation Sans", 0, 14)); // NOI18N
        IB.setText("Inizia il gioco");
        IB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IBMouseClicked(evt);
            }
        });

        btnApriFile.setText("Carica salvataggi");
        btnApriFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnApriFileMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(525, 525, 525)
                .addComponent(IB, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnApriFile, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(162, 162, 162)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(401, 401, 401)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(163, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IB)
                    .addComponent(btnApriFile))
                .addGap(22, 22, 22))
        );

        getContentPane().add(jPanel1, "CardIntro");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EvocazioneBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EvocazioneBActionPerformed
        choiceB1();
        IBA();
    }//GEN-LAST:event_EvocazioneBActionPerformed

    private void IncantoBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IncantoBActionPerformed
        choiceB1();
        IBA();
    }//GEN-LAST:event_IncantoBActionPerformed

    private void IllusioneBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IllusioneBActionPerformed
        choiceB1();
        IBA();
    }//GEN-LAST:event_IllusioneBActionPerformed

    private void FuocoBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FuocoBActionPerformed
        choiceB2();
        IBA();
    }//GEN-LAST:event_FuocoBActionPerformed

    private void AcquaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AcquaBActionPerformed
        choiceB2();
        IBA();
    }//GEN-LAST:event_AcquaBActionPerformed

    private void TerraBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TerraBActionPerformed
        choiceB2();
        IBA();
    }//GEN-LAST:event_TerraBActionPerformed

    private void AriaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AriaBActionPerformed
        choiceB2();
        IBA();
    }//GEN-LAST:event_AriaBActionPerformed

    private void IBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IBMouseClicked
        String scuolaScelta = buttonGroup1.getSelection().getActionCommand();
        String elementoScelto = buttonGroup2.getSelection().getActionCommand();
        gioco.getDataGame().setScuola(scuolaScelta);
        gioco.getDataGame().setElemento(elementoScelto);
        ((CardLayout)this.getContentPane().getLayout()).show(this.getContentPane(),"CardGioco");
        settColors();
        jLabelScuolaE.setText(gioco.getDataGame().getScuola()+" - "+gioco.getDataGame().getElemento());

    }//GEN-LAST:event_IBMouseClicked

    private void btnApriFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnApriFileMouseClicked
        AperturaFile();
    }//GEN-LAST:event_btnApriFileMouseClicked

    private void jButton16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton16MouseClicked
        gioco.getDataGame().compraAcqua();
    }//GEN-LAST:event_jButton16MouseClicked

    private void jButton14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton14MouseClicked
        gioco.getDataGame().compraPietra();
    }//GEN-LAST:event_jButton14MouseClicked

    private void jButton13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton13MouseClicked
        if(allExpand==true){
            jPanel20.setVisible(false);
            jPanel21.setVisible(false);
            jPanel39.setVisible(false);
            jPanel40.setVisible(false);
            jPanel42.setVisible(false);
            jPanel43.setVisible(false);
            jPanel44.setVisible(false);
            jPanel45.setVisible(false);
            jPanel25.setVisible(false);
            jPanel52.setVisible(false);
            jPanel53.setVisible(false);
            jPanel26.setVisible(false);
            jPanel46.setVisible(false);
            jPanel47.setVisible(false);
            jPanel48.setVisible(false);
            jButton15.setText("⊳");
            jButton17.setText("⊳");
            jButton39.setText("⊳");
            jButton41.setText("⊳");
            jButton47.setText("⊳");
            jButton49.setText("⊳");
            jButton51.setText("⊳");
            jButton53.setText("⊳");
            jButton19.setText("⊳");
            jButton68.setText("⊳");
            jButton69.setText("⊳");
            jButton21.setText("⊳");
            jButton55.setText("⊳");
            jButton57.setText("⊳");
            jButton59.setText("⊳");
            jButton13.setText("Espandi tutto");
            allExpand=false;
        }else{
            jPanel20.setVisible(true);
            jPanel21.setVisible(true);
            jPanel28.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=9);
            jPanel39.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=3);
            jPanel40.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=3);
            jPanel42.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=5);
            jPanel43.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=6);
            jPanel44.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=6);
            jPanel45.setVisible(gioco.getDataGame().getLivelloAttualeEvocazione()>=7);
            jPanel25.setVisible(true);
            jPanel52.setVisible(gioco.getDataGame().getLivelloAttualeIncanto()>=2 && gioco.getDataGame().getDepositoLegno()>0);
            jPanel53.setVisible(gioco.getDataGame().getLivelloAttualeIncanto()>=8 && gioco.getDataGame().getGeyser()>0);
            jPanel26.setVisible(true);
            jPanel46.setVisible(gioco.getDataGame().getLivelloAttualeIllusione()>=4);
            jPanel47.setVisible(gioco.getDataGame().getLivelloAttualeIllusione()>=7);
            jPanel48.setVisible(gioco.getDataGame().getLivelloAttualeIncanto()>=8);
            jButton13.setText("Comprimi tutto");
            jButton15.setText("▼");
            jButton17.setText("▼");
            jButton39.setText("▼");
            jButton41.setText("▼");
            jButton47.setText("▼");
            jButton49.setText("▼");
            jButton51.setText("▼");
            jButton53.setText("▼");
            jButton19.setText("▼");
            jButton68.setText("▼");
            jButton69.setText("▼");
            jButton21.setText("▼");
            jButton55.setText("▼");
            jButton57.setText("▼");
            jButton59.setText("▼");
            allExpand=true;
        }
    }//GEN-LAST:event_jButton13MouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        if(jComboBox1.getSelectedItem().equals("Evocazione")){
            jPanel19.setVisible(true);
            jPanel24.setVisible(false);
            jPanel27.setVisible(false);
        }else if(jComboBox1.getSelectedItem().equals("Incantesimo")){
            jPanel19.setVisible(false);
            jPanel24.setVisible(true);
            jPanel27.setVisible(false);
        }else if(jComboBox1.getSelectedItem().equals("Illusione")){
            jPanel19.setVisible(false);
            jPanel24.setVisible(false);
            jPanel27.setVisible(true);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton20MouseClicked
        gioco.getDataGame().compraMonete();
    }//GEN-LAST:event_jButton20MouseClicked

    private void campusBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campusBMouseClicked
        jLabel4.setText("Campus");
        PanelloFisso.setVisible(true);
        ((CardLayout)PanelloFisso.getLayout()).show(PanelloFisso, "card4");
        jScrollPane1.getVerticalScrollBar().setValue(0);
        ((CardLayout)jPanel12.getLayout()).show(jPanel12, "CardPrincipale");
        jPanel63.setVisible(false);
        
    }//GEN-LAST:event_campusBMouseClicked

    private void impostazioniBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_impostazioniBMouseClicked
       jLabel4.setText("Impostazioni");
       PanelloFisso.setVisible(false);
       jScrollPane1.getVerticalScrollBar().setValue(0);
        ((CardLayout)jPanel12.getLayout()).show(jPanel12, "cardImpostazioni");
        jPanel63.setVisible(false);
    }//GEN-LAST:event_impostazioniBMouseClicked

    private void helpbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpbMouseClicked
        jLabel4.setText("Aiuto");
        PanelloFisso.setVisible(false);
        jScrollPane1.getVerticalScrollBar().setValue(0);
        jPanel63.setVisible(false);
        ((CardLayout)jPanel12.getLayout()).show(jPanel12, "CardHelp");
        
    }//GEN-LAST:event_helpbMouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        jLabel4.setText("Informazioni su");
        PanelloFisso.setVisible(false);
        jScrollPane1.getVerticalScrollBar().setValue(0);
        ((CardLayout)jPanel12.getLayout()).show(jPanel12, "CardAbout");
        jPanel63.setVisible(false);
        
    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton36MouseClicked
        AperturaFile();
    }//GEN-LAST:event_jButton36MouseClicked

    private void jButton34MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton34MouseClicked
       jButton34.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Scegli dove salvare i dati");
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("File di salvataggio (*.txt)", "txt"));
        int returnVal = fileChooser.showSaveDialog(Main.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            // Se l'utente non ha specificato l'estensione, aggiungila
            if (!fileToSave.getName().toLowerCase().endsWith(".txt")) {
                fileToSave = new File(fileToSave.getAbsolutePath() + ".txt");
            }
            // Salva i dati attuali in quel file
            gioco.getDataGame().salvaSuFile(fileToSave.getAbsolutePath());
            JOptionPane.showMessageDialog(Main.this, "Dati salvati correttamente in:\n" + fileToSave.getAbsolutePath());
        } else {
            JOptionPane.showMessageDialog(Main.this, "Operazione di salvataggio annullata.");
        }
    }
});

    }//GEN-LAST:event_jButton34MouseClicked

    private void jButton37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton37MouseClicked
        gioco.getDataGame().compraRoccia();     
    }//GEN-LAST:event_jButton37MouseClicked

    private void jButton40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton40MouseClicked
        gioco.getDataGame().compraAcquaII();
    }//GEN-LAST:event_jButton40MouseClicked

    private void jCheckBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox1MouseClicked
        if(jCheckBox1.isSelected()){
              applyDarkTheme();
              gioco.getDataGame().setModalitàScura(true);
        }else{
             applyLightTheme();
             gioco.getDataGame().setModalitàScura(false);
        }
    }//GEN-LAST:event_jCheckBox1MouseClicked

    private void jButton42MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton42MouseClicked
       jLabel4.setText("Pensionamento");
       PanelloFisso.setVisible(false);
       jScrollPane1.getVerticalScrollBar().setValue(0);
        ((CardLayout)jPanel12.getLayout()).show(jPanel12, "PanelloRitirati");
        jPanel63.setVisible(false);
    }//GEN-LAST:event_jButton42MouseClicked

    private void jButton43MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton43MouseClicked
        gioco.getDataGame().cancellaSalvataggio("salvataggio.txt");
        riavviaApplicazione(); 
    }//GEN-LAST:event_jButton43MouseClicked

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        Swichcolormanual=true;
        settColors();
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton46MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton46MouseClicked
        gioco.getDataGame().compraMineraliDiFerro();
    }//GEN-LAST:event_jButton46MouseClicked

    private void jButton48MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton48MouseClicked
           gioco.getDataGame().compraMasso();
    }//GEN-LAST:event_jButton48MouseClicked

    private void jButton50MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton50MouseClicked
        gioco.getDataGame().compraAcquaIII();

    }//GEN-LAST:event_jButton50MouseClicked

    private void jButton52MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton52MouseClicked
        gioco.getDataGame().compraBarreFerro();

    }//GEN-LAST:event_jButton52MouseClicked

    private void jButton54MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton54MouseClicked
        gioco.getDataGame().compraMoneteVento();

    }//GEN-LAST:event_jButton54MouseClicked

    private void jButton56MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton56MouseClicked
        gioco.getDataGame().compraMoneteBolle();
 
    }//GEN-LAST:event_jButton56MouseClicked

    private void jButton58MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton58MouseClicked
        gioco.getDataGame().compraMoneteFuoco();

        
    }//GEN-LAST:event_jButton58MouseClicked

    private void jButton18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton18MouseClicked
        if(gioco.getDataGame().getMana()>=60){
            gioco.getDataGame().IncantiGettiManaAttiva();
            incantesimoManaAttivo = true;
            incantesimoCounterMana = 0;
            timer.start();
            updateGUI();
        }
        
    }//GEN-LAST:event_jButton18MouseClicked

    private void jButton67MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton67MouseClicked
        if(gioco.getDataGame().getMana()>=80){
            gioco.getDataGame().IncantiDepositiLegname();
            incantesimoLegnoAttivo = true;
            incantesimoCounterLegno = 0;
            timerAddLegno.start();
            updateGUI();
        }
    }//GEN-LAST:event_jButton67MouseClicked

    private void jButton66MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton66MouseClicked
        if(gioco.getDataGame().getMana()>=160){
            gioco.getDataGame().IncantiGeyserAttiva();
            incantesimoGeyserAttivo = true;
            incantesimoCountergeyser = 0;
            timer.start();
            updateGUI();
        }
    }//GEN-LAST:event_jButton66MouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        gioco.getDataGame().setVelocità("normale");
        jLabel184.setText("1x");
        jLabel185.setVisible(false);
        jLabel186.setVisible(false);
        timerPezziTempo.stop();
        gioco.getDataGame().salvaSuFile("salvataggio.txt");
    }//GEN-LAST:event_formWindowClosing

    private void jButton38MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton38MouseClicked
        jLabel4.setText("Ricerca");
        PanelloFisso.setVisible(false);
        jScrollPane1.getVerticalScrollBar().setValue(0);
        ((CardLayout)jPanel12.getLayout()).show(jPanel12, "CardRIcerca");
        jPanel63.setVisible(false);
    }//GEN-LAST:event_jButton38MouseClicked

    private void jButton89MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton89MouseClicked
            gioco.getDataGame().compraRicercatore();
    }//GEN-LAST:event_jButton89MouseClicked

    private void jButton74MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton74MouseClicked
        gioco.getDataGame().aggiungiRicercatoreEvocazione();
    }//GEN-LAST:event_jButton74MouseClicked

    private void jButton73MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton73MouseClicked
        gioco.getDataGame().rimuoviRicercatoreEvocazione();
    }//GEN-LAST:event_jButton73MouseClicked

    private void jButton77MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton77MouseClicked
       gioco.getDataGame().aggiungiRicercatoreIncanto();
    }//GEN-LAST:event_jButton77MouseClicked

    private void jButton78MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton78MouseClicked
       gioco.getDataGame().rimuoviRicercatoreIncanto();
    }//GEN-LAST:event_jButton78MouseClicked

    private void jButton80MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton80MouseClicked
        gioco.getDataGame().aggiungiRicercatoreIllusione();
    }//GEN-LAST:event_jButton80MouseClicked

    private void jButton81MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton81MouseClicked
       gioco.getDataGame().rimuoviRicercatoreIllusione();
    }//GEN-LAST:event_jButton81MouseClicked

    private void jButton83MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton83MouseClicked
        if(gioco.getDataGame().getTime()>0){
            gioco.getDataGame().setVelocità("normale");
            jLabel184.setText("1x");
            jLabel185.setVisible(false);
            jLabel186.setVisible(false);
            timerPezziTempo.stop();
        }
    }//GEN-LAST:event_jButton83MouseClicked

    private void jButton90MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton90MouseClicked
        if(gioco.getDataGame().getTime()>=3){
            gioco.getDataGame().setVelocità("2");
            jLabel184.setText("2x");
            jLabel185.setVisible(true);
            jLabel186.setVisible(true);
            modeSelected="2";
            String image=getClass().getResource("/Img/Time.png").toString();
            jLabel186.setText("<html><p>3<img src='"+image+"' width='18' height='18'>/sec</p></html>");
            if(!timerPezziTempo.isRunning()){
                timerPezziTempo.start();
            }
            
        }
    }//GEN-LAST:event_jButton90MouseClicked

    private void jButton91MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton91MouseClicked
        if(gioco.getDataGame().getTime()>=4){
            gioco.getDataGame().setVelocità("8");
            modeSelected="8";
            jLabel184.setText("8x");
            jLabel185.setVisible(true);
            jLabel186.setVisible(true);
            String image=getClass().getResource("/Img/Time.png").toString();
            jLabel186.setText("<html><p>4<img src='"+image+"' width='18' height='18'>/sec</p></html>");
             if(!timerPezziTempo.isRunning()){
                timerPezziTempo.start();
            }
        }
    }//GEN-LAST:event_jButton91MouseClicked

    private void jButton76MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton76MouseClicked
        gioco.getDataGame().SpendiPezziTempo();
    }//GEN-LAST:event_jButton76MouseClicked

    private void BottoneProduzioneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BottoneProduzioneMouseClicked
        if(jPanel75.isVisible()){
            BottoneProduzione.setText("⊳");
            jPanel75.setVisible(false);
        }else{
            BottoneProduzione.setText("▼");
            jPanel75.setVisible(true);
        }
    }//GEN-LAST:event_BottoneProduzioneMouseClicked

    private void BottoneMagazzinaggioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BottoneMagazzinaggioMouseClicked
        if(jPanel77.isVisible()){
            BottoneMagazzinaggio.setText("⊳");
            jPanel77.setVisible(false);
        }else{
            BottoneMagazzinaggio.setText("▼");
            jPanel77.setVisible(true);
        }
    }//GEN-LAST:event_BottoneMagazzinaggioMouseClicked

    private void BottoneTempoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BottoneTempoMouseClicked
        if(jPanel81.isVisible()){
            BottoneTempo.setText("⊳");
            jPanel81.setVisible(false);
        }else{
            BottoneTempo.setText("▼");
            jPanel81.setVisible(true);
        }
    }//GEN-LAST:event_BottoneTempoMouseClicked

    private void jButton95MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton95MouseClicked
        if(jPanel68.isVisible()){
            jButton95.setText("⊳");
            jPanel68.setVisible(false);
        }else{
            jButton95.setText("▼");
            jPanel68.setVisible(true);
        }
    }//GEN-LAST:event_jButton95MouseClicked

    private void jButton97MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton97MouseClicked
        if(jPanel69.isVisible()){
            jButton97.setText("⊳");
            jPanel69.setVisible(false);
        }else{
            jButton97.setText("▼");
            jPanel69.setVisible(true);
        }
    }//GEN-LAST:event_jButton97MouseClicked

    private void jButton99MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton99MouseClicked
        if(jPanel70.isVisible()){
            jPanel70.setVisible(false);
            jButton99.setText("⊳");
        }else{
            jPanel70.setVisible(true);
            jButton99.setText("▼");
        }
    }//GEN-LAST:event_jButton99MouseClicked

    private void jButton102MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton102MouseClicked
       if(jPanel72.isVisible()){
           jButton102.setText("⊳");
           jPanel72.setVisible(false);
       }else{
           jButton102.setText("▼");
           jPanel72.setVisible(true);
       }
    }//GEN-LAST:event_jButton102MouseClicked

    private void jButton104MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton104MouseClicked
        if(jPanel73.isVisible()){
            jButton104.setText("⊳");
            jPanel73.setVisible(false);
        }else{
             jButton104.setText("▼");
            jPanel73.setVisible(true);
        }
    }//GEN-LAST:event_jButton104MouseClicked

    private void jButton106MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton106MouseClicked
        if(jPanel74.isVisible()){
            jButton106.setText("⊳");
            jPanel74.setVisible(false);
        }else{
            jButton106.setText("▼");
            jPanel74.setVisible(true);
        }
    }//GEN-LAST:event_jButton106MouseClicked

    private void jButton109MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton109MouseClicked
        if(jPanel76.isVisible()){
            jButton109.setText("⊳");
            jPanel76.setVisible(false);
        }else{
            jButton109.setText("▼");
            jPanel76.setVisible(true);
        }
    }//GEN-LAST:event_jButton109MouseClicked

    private void jButton112MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton112MouseClicked
        if(jPanel78.isVisible()){
            jButton112.setText("⊳");
            jPanel78.setVisible(false);
        }else{
            jButton112.setText("▼");
            jPanel78.setVisible(true);
        }
    }//GEN-LAST:event_jButton112MouseClicked

    private void jButton114MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton114MouseClicked
        if(jPanel79.isVisible()){
            jButton114.setText("⊳");
            jPanel79.setVisible(false);
        }else{
            jButton114.setText("▼");
            jPanel79.setVisible(true);
        }
    }//GEN-LAST:event_jButton114MouseClicked

    private void jButton116MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton116MouseClicked
       if(jPanel80.isVisible()){
           jButton116.setText("⊳");
           jPanel80.setVisible(false);
       }else{
           jButton116.setText("▼");
           jPanel80.setVisible(true);
       }
    }//GEN-LAST:event_jButton116MouseClicked

    private void jButton119MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton119MouseClicked
        if(jPanel82.isVisible()){
            jButton119.setText("⊳");
            jPanel82.setVisible(false);
        }else{
            jButton119.setText("▼");
            jPanel82.setVisible(true);
        }
    }//GEN-LAST:event_jButton119MouseClicked

    private void jButton25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton25MouseClicked
       if(jPanel29.isVisible()){
           jButton25.setText("⊳");
           jPanel29.setVisible(false);
       }else{
           jButton25.setText("▼");
           jPanel29.setVisible(true);
       }
    }//GEN-LAST:event_jButton25MouseClicked

    private void jButton26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton26MouseClicked
        if(jPanel30.isVisible()){
            jButton26.setText("⊳");
            jPanel30.setVisible(false);
        }else{
            jButton26.setText("▼");
            jPanel30.setVisible(true);
        }
    }//GEN-LAST:event_jButton26MouseClicked

    private void jButton27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton27MouseClicked
        if(jPanel31.isVisible()){
            jButton27.setText("⊳");
            jPanel31.setVisible(false);
        }else{
            jButton27.setText("▼");
            jPanel31.setVisible(true);
        }
    }//GEN-LAST:event_jButton27MouseClicked

    private void jButton28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton28MouseClicked
        if(jPanel32.isVisible()){
            jButton28.setText("⊳");
            jPanel32.setVisible(false);
        }else{
            jButton28.setText("▼");
            jPanel32.setVisible(true);
        }
    }//GEN-LAST:event_jButton28MouseClicked

    private void jButton29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton29MouseClicked
        if(jPanel33.isVisible()){
            jButton29.setText("⊳");
            jPanel33.setVisible(false);
        }else{
            jButton29.setText("▼");
            jPanel33.setVisible(true);
        }
    }//GEN-LAST:event_jButton29MouseClicked

    private void jButton30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton30MouseClicked
       if(jPanel34.isVisible()){
           jButton30.setText("⊳");
           jPanel34.setVisible(false);
       }else{
           jButton30.setText("▼");
           jPanel34.setVisible(true);
       }
    }//GEN-LAST:event_jButton30MouseClicked

    private void jButton31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton31MouseClicked
        if(jPanel35.isVisible()){
            jButton31.setText("⊳");
            jPanel35.setVisible(false);
        }else{
            jButton31.setText("▼");
            jPanel35.setVisible(true);
        }
    }//GEN-LAST:event_jButton31MouseClicked

    private void jButton70MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton70MouseClicked
       if(jPanel54.isVisible()){
           jButton70.setText("⊳");
           jPanel54.setVisible(false);
       }else{
           jButton70.setText("▼");
           jPanel54.setVisible(true);
       }
    }//GEN-LAST:event_jButton70MouseClicked

    private void jButton71MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton71MouseClicked
        if(jPanel55.isVisible()){
            jButton71.setText("⊳");
            jPanel55.setVisible(false);
        }else{
            jButton71.setText("▼");
            jPanel55.setVisible(true);
        }
    }//GEN-LAST:event_jButton71MouseClicked

    private void jButton72MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton72MouseClicked
        if(jPanel56.isVisible()){
            jButton72.setText("⊳");
            jPanel56.setVisible(false);
        }else{
            jButton72.setText("▼");
            jPanel56.setVisible(true);
        }
    }//GEN-LAST:event_jButton72MouseClicked

    private void jButton32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton32MouseClicked
        if(jPanel36.isVisible()){
            jButton32.setText("⊳");
            jPanel36.setVisible(false);
        }else{
            jButton32.setText("▼");
            jPanel36.setVisible(true);
        }
    }//GEN-LAST:event_jButton32MouseClicked

    private void jButton33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton33MouseClicked
        if(jPanel37.isVisible()){
            jButton33.setText("⊳");
            jPanel37.setVisible(false);
        }else{
            jButton33.setText("▼");
            jPanel37.setVisible(true);
        }
    }//GEN-LAST:event_jButton33MouseClicked

    private void jButton35MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton35MouseClicked
        if(jPanel38.isVisible()){
            jButton35.setText("⊳");
            jPanel38.setVisible(false);
        }else{
            jButton35.setText("▼");
            jPanel38.setVisible(true);
        }
    }//GEN-LAST:event_jButton35MouseClicked

    private void jButton88MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton88MouseClicked
        if(jPanel66.isVisible()){
            jButton88.setText("⊳");
            jPanel66.setVisible(false);
        }else{
            jButton88.setText("▼");
            jPanel66.setVisible(true);
        }
    }//GEN-LAST:event_jButton88MouseClicked

    private void jButton12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseClicked
        if(VisibilitàNegozio==true){
            jPanel19.setVisible(false);
            jPanel24.setVisible(false);
            jPanel27.setVisible(false);
            jComboBox1.setVisible(false);
            jButton13.setVisible(false);
            jButton12.setText("⊳");
            VisibilitàNegozio=false;
        }else {
            if(jComboBox1.getSelectedItem().equals("Evocazione")){
                jPanel19.setVisible(true);
                jPanel24.setVisible(false);
                jPanel27.setVisible(false);
                jButton12.setText("▼");
                jComboBox1.setVisible(true);
                jButton13.setVisible(true);
                VisibilitàNegozio=true;
            }else if(jComboBox1.getSelectedItem().equals("Incantesimo")){
                jPanel19.setVisible(false);
                jPanel24.setVisible(true);
                jPanel27.setVisible(false);
                jButton12.setText("▼");
                jComboBox1.setVisible(true);
                jButton13.setVisible(true);
                VisibilitàNegozio=true;
            }else{
                jPanel19.setVisible(false);
                jPanel24.setVisible(false);
                jPanel27.setVisible(true);
                jButton12.setText("▼");
                jComboBox1.setVisible(true);
                jButton13.setVisible(true);
                VisibilitàNegozio=true;
            }
        }
    }//GEN-LAST:event_jButton12MouseClicked

    private void jButton15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton15MouseClicked
        if(jPanel20.isVisible()){
            jButton15.setText("⊳");
            jPanel20.setVisible(false);
        }else{
            jButton15.setText("▼");
            jPanel20.setVisible(true);
        }
    }//GEN-LAST:event_jButton15MouseClicked

    private void jButton17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton17MouseClicked
        if(jPanel21.isVisible()){
            jButton17.setText("⊳");
            jPanel21.setVisible(false);
        }else{
            jButton17.setText("▼");
            jPanel21.setVisible(true);
        }
    }//GEN-LAST:event_jButton17MouseClicked

    private void jButton39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton39MouseClicked
        if(jPanel39.isVisible()){
            jButton39.setText("⊳");
            jPanel39.setVisible(false);
        }else{
            jButton39.setText("▼");
            jPanel39.setVisible(true);
        }
    }//GEN-LAST:event_jButton39MouseClicked

    private void jButton41MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton41MouseClicked
        if(jPanel40.isVisible()){
            jButton41.setText("⊳");
            jPanel40.setVisible(false);
        }else{
            jButton41.setText("▼");
            jPanel40.setVisible(true);
        }
    }//GEN-LAST:event_jButton41MouseClicked

    private void jButton47MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton47MouseClicked
        if(jPanel42.isVisible()){
            jButton47.setText("⊳");
            jPanel42.setVisible(false);
        }else{
            jButton47.setText("▼");
            jPanel42.setVisible(true);
        }
    }//GEN-LAST:event_jButton47MouseClicked

    private void jButton49MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton49MouseClicked
        if(jPanel43.isVisible()){
            jButton49.setText("⊳");
            jPanel43.setVisible(false);
        }else{
            jButton49.setText("▼");
            jPanel43.setVisible(true);
        }
    }//GEN-LAST:event_jButton49MouseClicked

    private void jButton51MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton51MouseClicked
        if(jPanel44.isVisible()){
            jButton51.setText("⊳");
            jPanel44.setVisible(false);
        }else{
            jButton51.setText("▼");
            jPanel44.setVisible(true);
        }
    }//GEN-LAST:event_jButton51MouseClicked

    private void jButton53MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton53MouseClicked
        if(jPanel45.isVisible()){
            jButton53.setText("⊳");
            jPanel45.setVisible(false);
        }else{
            jButton53.setText("▼");
            jPanel45.setVisible(true);
        }
    }//GEN-LAST:event_jButton53MouseClicked

    private void jButton19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton19MouseClicked
        if(jPanel25.isVisible()){
            jButton19.setText("⊳");
            jPanel25.setVisible(false);
        }else{
            jButton19.setText("▼");
            jPanel25.setVisible(true);
        }
    }//GEN-LAST:event_jButton19MouseClicked

    private void jButton68MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton68MouseClicked
        if(jPanel52.isVisible()){
            jButton68.setText("⊳");
            jPanel52.setVisible(false);
        }else{
            jButton68.setText("▼");
            jPanel52.setVisible(true);
        }
    }//GEN-LAST:event_jButton68MouseClicked

    private void jButton69MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton69MouseClicked
        if(jPanel53.isVisible()){
            jButton69.setText("⊳");
            jPanel53.setVisible(false);
        }else{
            jButton69.setText("▼");
            jPanel53.setVisible(true);
        }
    }//GEN-LAST:event_jButton69MouseClicked

    private void jButton21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton21MouseClicked
        if(jPanel26.isVisible()){
            jButton21.setText("⊳");
            jPanel26.setVisible(false);
        }else{
            jButton21.setText("▼");
            jPanel26.setVisible(true);
        }
    }//GEN-LAST:event_jButton21MouseClicked

    private void jButton55MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton55MouseClicked
        if(jPanel46.isVisible()){
            jButton55.setText("⊳");
            jPanel46.setVisible(false);
        }else{
            jButton55.setText("▼");
            jPanel46.setVisible(true);
        }
    }//GEN-LAST:event_jButton55MouseClicked

    private void jButton57MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton57MouseClicked
        if(jPanel47.isVisible()){
            jButton57.setText("⊳");
            jPanel47.setVisible(false);
        }else{
            jButton57.setText("▼");
            jPanel47.setVisible(true);
        }
    }//GEN-LAST:event_jButton57MouseClicked

    private void jButton59MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton59MouseClicked
        if(jPanel48.isVisible()){
            jButton59.setText("⊳");
            jPanel48.setVisible(false);
        }else{
            jButton59.setText("▼");
            jPanel48.setVisible(true);
        }
    }//GEN-LAST:event_jButton59MouseClicked

    private void jButton82MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton82MouseClicked
        if(jPanel62.isVisible()){
            jButton82.setText("⊳");
            jPanel62.setVisible(false);
        }else{
            jButton82.setText("▼");
            jPanel62.setVisible(true);
        }
    }//GEN-LAST:event_jButton82MouseClicked

    private void BottonEXpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BottonEXpMouseClicked
       if(jPanel7.isVisible()){
           BottonEXp.setText("⊳");
           jPanel7.setVisible(false);
       }else{
           BottonEXp.setText("▼");
           jPanel7.setVisible(true);
       }
    }//GEN-LAST:event_BottonEXpMouseClicked

    private void jButton79MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton79MouseClicked
        if(jPanel60.isVisible()){
            jButton79.setText("⊳");
            jPanel60.setVisible(false);
        }else{
            jButton79.setText("▼");
            jPanel60.setVisible(true);
        }
    }//GEN-LAST:event_jButton79MouseClicked

    private void jButton75MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton75MouseClicked
        if(jPanel58.isVisible()){
            jButton75.setText("⊳");
            jPanel58.setVisible(false);
        }else{
            jButton75.setText("▼");
            jPanel58.setVisible(true);
        }
    }//GEN-LAST:event_jButton75MouseClicked

    private void BottoneRaccoltaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BottoneRaccoltaMouseClicked
         if(jPanel67.isVisible()){
            BottoneRaccolta.setText("⊳");
            jPanel67.setVisible(false);
        }else{
            BottoneRaccolta.setText("▼");
            jPanel67.setVisible(true);  
        }
    }//GEN-LAST:event_BottoneRaccoltaMouseClicked

    private void BottoneSIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BottoneSIMouseClicked
        if(jPanel6.isVisible()){
            BottoneSI.setText("⊳");
            jPanel6.setVisible(false);
        }else{
            BottoneSI.setText("▼");
            jPanel6.setVisible(true);
        }
    }//GEN-LAST:event_BottoneSIMouseClicked

    private void RaccogliManaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RaccogliManaMouseClicked
        gioco.getDataGame().aggiungiMana(1);
    }//GEN-LAST:event_RaccogliManaMouseClicked

    private void RaccogliLegnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RaccogliLegnoMouseClicked
        gioco.getDataGame().aggiungiLegno(1);
    }//GEN-LAST:event_RaccogliLegnoMouseClicked

    private void RaccogliFerroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RaccogliFerroMouseClicked
        gioco.getDataGame().aggiungiFerro(0.10);
    }//GEN-LAST:event_RaccogliFerroMouseClicked

    private void BottoneSilosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BottoneSilosMouseClicked
        gioco.getDataGame().costruisciSilos();
        timer.start();
    }//GEN-LAST:event_BottoneSilosMouseClicked

    private void BottoneShardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BottoneShardMouseClicked
        gioco.getDataGame().compraManaShard();
    }//GEN-LAST:event_BottoneShardMouseClicked

    private void BottoneGeyserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BottoneGeyserMouseClicked
       gioco.getDataGame().compraGeyser();
        timer.start();
    }//GEN-LAST:event_BottoneGeyserMouseClicked

    private void BottoneLegnameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BottoneLegnameMouseClicked
        gioco.getDataGame().costruisciDepositoLegname();
        timerAddLegno.start();
    }//GEN-LAST:event_BottoneLegnameMouseClicked

    private void BottoneMagazzinoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BottoneMagazzinoMouseClicked
        gioco.getDataGame().compraMagazzino();
    }//GEN-LAST:event_BottoneMagazzinoMouseClicked

    private void BottoneSerbatoioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BottoneSerbatoioMouseClicked
        gioco.getDataGame().compraSerbatoioA();
    }//GEN-LAST:event_BottoneSerbatoioMouseClicked

    private void BottoneCaveauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BottoneCaveauMouseClicked
        gioco.getDataGame().compraCaveau();
    }//GEN-LAST:event_BottoneCaveauMouseClicked

    private void BottonePezziTempoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BottonePezziTempoMouseClicked
        gioco.getDataGame().SpendiPezziTempo();
    }//GEN-LAST:event_BottonePezziTempoMouseClicked

    private void BottoneRicercatoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BottoneRicercatoreMouseClicked
        if(gioco.getDataGame().getMonete()>=200){
            gioco.getDataGame().compraRicercatore();
            JOptionPane.showMessageDialog(this,"Apparve un ricercatore selvaggio\n\nTiri fuori 200 monete dalle tasche e le consegni alla ricercatrice. Lei le guarda e le ripone nelle tasche della sua tunica.\nPerfetto! Inizio subito\", esclama. \"Sono sicura che questo sia l'inizio di una relazione molto fruttuosa per entrambi!\".\nHai sbloccato la funzione \"Ricerca\"! Potresti trovarla nel menu a sinistra.");
        }
    }//GEN-LAST:event_BottoneRicercatoreMouseClicked

    private void RaccogliManaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RaccogliManaMousePressed
        timerMana.setDelay(250);
        timerMana.start();
    }//GEN-LAST:event_RaccogliManaMousePressed

    private void RaccogliManaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RaccogliManaMouseReleased
        timerMana.stop();
    }//GEN-LAST:event_RaccogliManaMouseReleased

    private void RaccogliLegnoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RaccogliLegnoMousePressed
        timerLegno.setDelay(250);
        timerLegno.start();
    }//GEN-LAST:event_RaccogliLegnoMousePressed

    private void RaccogliLegnoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RaccogliLegnoMouseReleased
        timerLegno.stop();
    }//GEN-LAST:event_RaccogliLegnoMouseReleased

    private void RaccogliFerroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RaccogliFerroMousePressed
        timerFerro.setDelay(250);
        timerFerro.start();
    }//GEN-LAST:event_RaccogliFerroMousePressed

    private void RaccogliFerroMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RaccogliFerroMouseReleased
        timerFerro.stop();
    }//GEN-LAST:event_RaccogliFerroMouseReleased

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        if(jPanel9.isVisible()){
            jButton1.setText("⊳");
            jPanel9.setVisible(false);
        }else{
            jButton1.setText("▼");
            jPanel9.setVisible(true);
        }
            
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        if(jPanel10.isVisible()){
            jButton3.setText("⊳");
            jPanel10.setVisible(false);
        }else{
            jButton3.setText("▼");
            jPanel10.setVisible(true);
        }
    }//GEN-LAST:event_jButton3MouseClicked

    private void BottoneCabina1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BottoneCabina1MouseClicked
        gioco.getDataGame().compraCapacitàRicercatore();
    }//GEN-LAST:event_BottoneCabina1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        if(jPanel11.isVisible()){
            jButton2.setText("⊳");
            jPanel11.setVisible(false);
        }else{
            jButton2.setText("▼");
            jPanel11.setVisible(true);
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        if(jPanel13.isVisible()){
            jButton5.setText("⊳");
            jPanel13.setVisible(false);
        }else{
            jButton5.setText("▼");
            jPanel13.setVisible(true);
        }
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        gioco.getDataGame().compraCapacitàRicercatore();
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
       if(jPanel14.isVisible()){
           jButton8.setText("⊳");
           jPanel14.setVisible(false);
       }else{
           jButton8.setText("▼");
           jPanel14.setVisible(true);
       }
    }//GEN-LAST:event_jButton8MouseClicked

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        gioco.getDataGame().compraApprendista();
    }//GEN-LAST:event_jButton7MouseClicked

    private void jButton9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseClicked
        jLabel4.setText("Apprendisti");
        PanelloFisso.setVisible(true);
        ((CardLayout)PanelloFisso.getLayout()).show(PanelloFisso, "card3");
        jScrollPane1.getVerticalScrollBar().setValue(0);
        ((CardLayout)jPanel12.getLayout()).show(jPanel12, "CardApprendisti");
        jPanel63.setVisible(false);
    }//GEN-LAST:event_jButton9MouseClicked

    private void jButton117MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton117MouseClicked
        gioco.getDataGame().compraApprendista();
    }//GEN-LAST:event_jButton117MouseClicked

    private void jButton115MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton115MouseClicked
       if(jPanel15.isVisible()){
           jButton115.setText("⊳");
           jPanel15.setVisible(false);
       }else{
           jButton115.setText("▼");
           jPanel15.setVisible(true);
       }
    }//GEN-LAST:event_jButton115MouseClicked

    private void jButton118MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton118MouseClicked
        if(jPanel17.isVisible()){
            jPanel17.setVisible(false);
            jButton118.setText("⊳");
        }else{
            jPanel17.setVisible(true);
            jButton118.setText("▼");
        }
    }//GEN-LAST:event_jButton118MouseClicked

    private void jButton61MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton61MouseClicked
        gioco.getDataGame().aggiungereApprendistaPietra();
        jLabel52.setText(calcoloManaApprendisti()+"/sec");
    }//GEN-LAST:event_jButton61MouseClicked

    private void jButton10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseClicked
        gioco.getDataGame().rimuovereApprendistaPietra();
        jLabel52.setText(calcoloManaApprendisti()+"/sec");
    }//GEN-LAST:event_jButton10MouseClicked

    private void jButton62MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton62MouseClicked
        gioco.getDataGame().aggiungereApprendistaAcqua();
        jLabel52.setText(calcoloManaApprendisti()+"/sec");
    }//GEN-LAST:event_jButton62MouseClicked

    private void jButton11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseClicked
        gioco.getDataGame().rimuovereApprendistaAcqua();
        jLabel52.setText(calcoloManaApprendisti()+"/sec");
    }//GEN-LAST:event_jButton11MouseClicked

    private void jButton63MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton63MouseClicked
        gioco.getDataGame().aggiungereApprendistaRoccia();
        jLabel52.setText(calcoloManaApprendisti()+"/sec");
    }//GEN-LAST:event_jButton63MouseClicked

    private void jButton22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton22MouseClicked
        gioco.getDataGame().rimuovereApprendistaRoccia();
        jLabel52.setText(calcoloManaApprendisti()+"/sec");
    }//GEN-LAST:event_jButton22MouseClicked

    private void jButton94MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton94MouseClicked
        gioco.getDataGame().aggiungereApprendistaIncantoMana();
        jLabel52.setText(calcoloManaApprendisti()+"/sec");
    }//GEN-LAST:event_jButton94MouseClicked

    private void jButton87MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton87MouseClicked
        gioco.getDataGame().rimuovereApprendistaIncantoMana();
        jLabel52.setText(calcoloManaApprendisti()+"/sec");
    }//GEN-LAST:event_jButton87MouseClicked

    private void BottoneManaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BottoneManaActionPerformed
        boolean vis= jPanel71.isVisible();
        jPanel71.setVisible(!vis);
        BottoneMana.setText(vis ? "⊳": "▼");
        jPanel71.getParent().revalidate();
        jPanel71.getParent().repaint();
    }//GEN-LAST:event_BottoneManaActionPerformed

    private void jButton64MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton64MouseClicked
        gioco.getDataGame().aggiungereApprendistaAcquaII();
        jLabel52.setText(calcoloManaApprendisti()+"/sec");
    }//GEN-LAST:event_jButton64MouseClicked

    private void jButton23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton23MouseClicked
        gioco.getDataGame().rimuovereApprendistaAcquaII();
        jLabel52.setText(calcoloManaApprendisti()+"/sec");
    }//GEN-LAST:event_jButton23MouseClicked

    private void jButton111MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton111MouseClicked
        gioco.getDataGame().aggiungereApprendistaSpettacoloMagia();
        jLabel52.setText(calcoloManaApprendisti()+"/sec");
    }//GEN-LAST:event_jButton111MouseClicked

    private void jButton100MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton100MouseClicked
        gioco.getDataGame().rimuovereApprendistaSpettacoloMagia();
        jLabel52.setText(calcoloManaApprendisti()+"/sec");
    }//GEN-LAST:event_jButton100MouseClicked

    private void jButton120MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton120MouseClicked
       if(jPanel18.isVisible()){
           jButton120.setText("⊳");
           jPanel18.setVisible(false);
       }else{
           jButton120.setText("▼");
           jPanel18.setVisible(true);
       }
    }//GEN-LAST:event_jButton120MouseClicked

    private void jButton113MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton113MouseClicked
        if(gioco.getDataGame().getTime()>=3000){
        gioco.getDataGame().saltoTemporaleTime();
        ((CardLayout)this.getContentPane().getLayout()).show(this.getContentPane(),"card4");
        Timer timerMana=new Timer(10,new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ciclo+=2;
                jLabel212.setText("Deformandosi nel tempo.... "+ciclo+"/600");
                jProgressBar2.setValue(ciclo); 
                if(ciclo>=600){
                    ciclo=0;
                    caricamento();
                    ((Timer)e.getSource()).stop();
                }
           }
         });
        timerMana.start();
        }
      
        
    }//GEN-LAST:event_jButton113MouseClicked

    private void jButton123MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton123MouseClicked
        if(jPanel28.isVisible()){
            jButton123.setText("⊳");
            jPanel28.setVisible(false);
        }else{
            jButton123.setText("▼");
            jPanel28.setVisible(true);
        }
    }//GEN-LAST:event_jButton123MouseClicked

    private void jButton121MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton121MouseClicked
        gioco.getDataGame().compraStazioneDiLavoro();
    }//GEN-LAST:event_jButton121MouseClicked

    private void jButton126MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton126MouseClicked
        if(jPanel41.isVisible()){
            jButton126.setText("⊳");
            jPanel41.setVisible(false);
        }else{
            jButton126.setText("▼");
            jPanel41.setVisible(true);
        }
    }//GEN-LAST:event_jButton126MouseClicked

    private void jButton128MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton128MouseClicked
        gioco.getDataGame().aggiungiForno();
    }//GEN-LAST:event_jButton128MouseClicked

    private void jButton127MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton127MouseClicked
        gioco.getDataGame().rimuovereForno();
    }//GEN-LAST:event_jButton127MouseClicked

    private void jButton125MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton125MouseClicked
        gioco.getDataGame().compraForno();
    }//GEN-LAST:event_jButton125MouseClicked

    private void jButton129MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton129MouseClicked
       gioco.getDataGame().temp();
       jLabel172.setVisible(gioco.getDataGame().getTime()>0);
       jButton82.setVisible(gioco.getDataGame().getTime()>0);

    }//GEN-LAST:event_jButton129MouseClicked

    private void jButton122MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton122MouseClicked
        gioco.getDataGame().casualBuilding();
    }//GEN-LAST:event_jButton122MouseClicked

    private void jButton124MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton124MouseClicked
        jLabel4.setText("Inventario");
        PanelloFisso.setVisible(false);
        jScrollPane1.getVerticalScrollBar().setValue(0);
        jPanel63.setVisible(false);
        ((CardLayout)jPanel12.getLayout()).show(jPanel12, "cardItem");
    }//GEN-LAST:event_jButton124MouseClicked

    private void jButton130MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton130MouseClicked
         ((CardLayout)jPanel12.getLayout()).show(jPanel12, "CardCrafiting");
    }//GEN-LAST:event_jButton130MouseClicked

    private void jButton132MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton132MouseClicked
        ((CardLayout)jPanel12.getLayout()).show(jPanel12, "cardItem");
        jPanel50.setVisible(false);
    }//GEN-LAST:event_jButton132MouseClicked

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        if(jComboBox3.getSelectedItem().equals("Tutto")){
            jChest.setVisible(true);
            jRamo.setVisible(true);
            jClub.setVisible(true);
            jDagger.setVisible(true);
            jSword.setVisible(true);
            jHandAxe.setVisible(true);
            jFirewand.setVisible(true);
            jSickle.setVisible(true);
            jIronMail.setVisible(true);
            jWizardsRobe.setVisible(true);
            jThiefsGarb.setVisible(true);
            jCristallo.setVisible(true);
            jSandali.setVisible(true);
            jCloak.setVisible(true);
            jClothShoes.setVisible(true);
            jEnchantedCloak.setVisible(true);
            jCloath.setVisible(true);
        }else if(jComboBox3.getSelectedItem().equals("Oggetto della Missione")){
            jChest.setVisible(true);
            jRamo.setVisible(false);
            jClub.setVisible(false);
            jDagger.setVisible(false);
            jSword.setVisible(false);
            jHandAxe.setVisible(false);
            jFirewand.setVisible(false);
            jSickle.setVisible(false);
            jIronMail.setVisible(false);
            jWizardsRobe.setVisible(false);
            jThiefsGarb.setVisible(false);
            jCristallo.setVisible(false);
            jSandali.setVisible(false);
            jCloak.setVisible(false);
            jClothShoes.setVisible(false);
            jEnchantedCloak.setVisible(false);
            jCloath.setVisible(false);
        }else if(jComboBox3.getSelectedItem().equals("Mano")){
            jRamo.setVisible(true);
            jClub.setVisible(true);
            jDagger.setVisible(true);
            jSword.setVisible(true);
            jHandAxe.setVisible(true);
            jFirewand.setVisible(true);
            jSickle.setVisible(true);
            jChest.setVisible(false);
            jIronMail.setVisible(false);
            jWizardsRobe.setVisible(false);
            jThiefsGarb.setVisible(false);
            jCristallo.setVisible(false);
            jSandali.setVisible(false);
            jCloak.setVisible(false);
            jClothShoes.setVisible(false);
            jEnchantedCloak.setVisible(false);
            jCloath.setVisible(false);
        }else if(jComboBox3.getSelectedItem().equals("Corpo")){
            jIronMail.setVisible(true);
            jWizardsRobe.setVisible(true);
            jThiefsGarb.setVisible(true);
            jRamo.setVisible(false);
            jClub.setVisible(false);
            jDagger.setVisible(false);
            jSword.setVisible(false);
            jHandAxe.setVisible(false);
            jFirewand.setVisible(false);
            jSickle.setVisible(false);
            jChest.setVisible(false);
            jCristallo.setVisible(false);
            jSandali.setVisible(false);
            jCloak.setVisible(false);
            jClothShoes.setVisible(false);
            jEnchantedCloak.setVisible(false);
            jCloath.setVisible(false);
        }else if(jComboBox3.getSelectedItem().equals("Accessorio")){
            jCristallo.setVisible(true);
            jSandali.setVisible(true);
            jCloak.setVisible(true);
            jClothShoes.setVisible(true);
            jEnchantedCloak.setVisible(true);
            jIronMail.setVisible(false);
            jWizardsRobe.setVisible(false);
            jThiefsGarb.setVisible(false);
            jRamo.setVisible(false);
            jClub.setVisible(false);
            jDagger.setVisible(false);
            jSword.setVisible(false);
            jHandAxe.setVisible(false);
            jFirewand.setVisible(false);
            jSickle.setVisible(false);
            jChest.setVisible(false);
            jCloath.setVisible(false);
        }else if(jComboBox3.getSelectedItem().equals("Attrezzatura")){
            jChest.setVisible(false);
            jRamo.setVisible(true);
            jClub.setVisible(true);
            jDagger.setVisible(true);
            jSword.setVisible(true);
            jHandAxe.setVisible(true);
            jFirewand.setVisible(true);
            jSickle.setVisible(true);
            jIronMail.setVisible(true);
            jWizardsRobe.setVisible(true);
            jThiefsGarb.setVisible(true);
            jCristallo.setVisible(true);
            jSandali.setVisible(true);
            jCloak.setVisible(true);
            jClothShoes.setVisible(true);
            jEnchantedCloak.setVisible(true);
            jCloath.setVisible(false);
        }else if(jComboBox3.getSelectedItem().equals("Materiale")){
            jChest.setVisible(false);
            jRamo.setVisible(false);
            jClub.setVisible(false);
            jDagger.setVisible(false);
            jSword.setVisible(false);
            jHandAxe.setVisible(false);
            jFirewand.setVisible(false);
            jSickle.setVisible(false);
            jIronMail.setVisible(false);
            jWizardsRobe.setVisible(false);
            jThiefsGarb.setVisible(false);
            jCristallo.setVisible(false);
            jSandali.setVisible(false);
            jCloak.setVisible(false);
            jClothShoes.setVisible(false);
            jEnchantedCloak.setVisible(false);
            jCloath.setVisible(true);
        }
        
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jChestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jChestMouseClicked
        jPanel50.setVisible(true);
        labelFisseItem();
        OggettoSelezionatoCreazione=1;
        jLabel251.setIcon(new ImageIcon(chest));
        jLabel248.setText("Cassa Leggera");
        jLabel250.setText("<html><p>Una cassa di legno molto leggera. Ottima per trasportare oggetti</p></html>");
        jLabel254.setIcon(new ImageIcon(iconamana));
        jLabel255.setIcon(new ImageIcon(iconalegno));
        jLabel256.setIcon(new ImageIcon(iconaferro));
        jLabel254.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel254.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel255.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel255.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel256.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel256.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel254.setText("Mana:");
        jLabel255.setText("Legno:");
        jLabel256.setText("Ferro:");
        itemSelected="cassaLeggera";
        jLabel252.setText("Totale posseduto:"+gioco.getDataGame().getCassa());
    }//GEN-LAST:event_jChestMouseClicked

    private void jRamoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRamoMouseClicked
        jPanel50.setVisible(true);
        labelFisseItem();
        OggettoSelezionatoCreazione=2;
        jLabel251.setIcon(new ImageIcon(branch));
        jLabel248.setText("Ramo");
        String mana=getClass().getResource("/Img/mana.png").toString();
        jLabel250.setText("<html><p>Un ramo infuso magicamente. Produce una piccola quantità di <img src='"+mana+"' width='13' height='13'></p></html>");
        jLabel254.setIcon(new ImageIcon(iconalegno));
        jLabel255.setIcon(new ImageIcon(iconamana));
        jLabel254.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel254.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel255.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel255.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel254.setText("Legno:");
        jLabel255.setText("Mana:");
        jLabel256.setVisible(false);
        itemSelected="ramo";
        jLabel252.setText("Totale posseduto:"+gioco.getDataGame().getRamo());
    }//GEN-LAST:event_jRamoMouseClicked

    private void jClubMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jClubMouseClicked
        jPanel50.setVisible(true);
        labelFisseItem();
        OggettoSelezionatoCreazione=3;
        jLabel251.setIcon(new ImageIcon(club));
        jLabel248.setText("Mazza");
        jLabel250.setText("<html><p>Una mazza di legno. Leggermente pesante</p></html>");
        jLabel254.setIcon(new ImageIcon(iconalegno));
        jLabel254.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel254.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel254.setText("Legno:");
        jLabel255.setVisible(false);
        jLabel256.setVisible(false);
        itemSelected="mazza";
        jLabel252.setText("Totale posseduto:"+gioco.getDataGame().getMazza());
    }//GEN-LAST:event_jClubMouseClicked

    private void jDaggerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDaggerMouseClicked
        jPanel50.setVisible(true);
        labelFisseItem();
        OggettoSelezionatoCreazione=4;
        jLabel251.setIcon(new ImageIcon(dagger));
        jLabel248.setText("Pugnale");
        jLabel250.setText("<html><p>Un'arma agile e leggera</p></html>");
        jLabel254.setIcon(new ImageIcon(iconaferro));
        jLabel255.setIcon(new ImageIcon(iconalegno));
        jLabel256.setIcon(new ImageIcon(temperatura));
         jLabel254.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel254.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel255.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel255.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel256.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel256.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel254.setText("Ferro:");
        jLabel255.setText("Legno:");
        jLabel256.setText("Temperatura:");
        itemSelected="pugnale";
        jLabel252.setText("Totale posseduto:"+gioco.getDataGame().getPugnale());
    }//GEN-LAST:event_jDaggerMouseClicked

    private void jSwordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSwordMouseClicked
        jPanel50.setVisible(true);
        labelFisseItem();
        OggettoSelezionatoCreazione=5;
        jLabel251.setIcon(new ImageIcon(sword));
        jLabel248.setText("Spada");
        jLabel250.setText("<html><p>Una spada: un'arma potente nelle mani di un esperto</p></html>");
        jLabel254.setIcon(new ImageIcon(iconaferro));
        jLabel255.setIcon(new ImageIcon(iconalegno));
        jLabel256.setIcon(new ImageIcon(temperatura));
         jLabel254.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel254.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel255.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel255.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel256.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel256.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel254.setText("Ferro:");
        jLabel255.setText("Legno:");
        jLabel256.setText("Temperatura:");
        itemSelected="spada";
        jLabel252.setText("Totale posseduto:"+gioco.getDataGame().getSpada());
    }//GEN-LAST:event_jSwordMouseClicked

    private void jHandAxeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jHandAxeMouseClicked
        jPanel50.setVisible(true);
        labelFisseItem();
        OggettoSelezionatoCreazione=6;
        jLabel251.setIcon(new ImageIcon(handAxe));
        jLabel248.setText("Ascia a una Mano");
        jLabel250.setText("<html><p>Un'ascia. Lenta, ma molto dannosa</p></html>");
        jLabel254.setIcon(new ImageIcon(iconaferro));
        jLabel255.setIcon(new ImageIcon(iconalegno));
        jLabel256.setIcon(new ImageIcon(temperatura));
        jLabel254.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel254.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel255.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel255.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel256.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel256.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel254.setText("Ferro:");
        jLabel255.setText("Legno:");
        jLabel256.setText("Temperatura:");
        itemSelected="asciaMano";
        jLabel252.setText("Totale posseduto:"+gioco.getDataGame().getAscia());
    }//GEN-LAST:event_jHandAxeMouseClicked

    private void jFirewandMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jFirewandMouseClicked
        jPanel50.setVisible(true);
        labelFisseItem();
        OggettoSelezionatoCreazione=7;
        jLabel251.setIcon(new ImageIcon(firewand));
        jLabel248.setText("Staffa di Fuoco");
        jLabel250.setText("<html><p>La bacchetta magica di un mago con il potere del fuoco. Può essere un'arma efficace!</p></html>");
        jLabel254.setIcon(new ImageIcon(iconalegno));
        jLabel255.setIcon(new ImageIcon(iconamana));
        jLabel256.setIcon(new ImageIcon(firespeck));
        jLabel254.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel254.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel255.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel255.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel256.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel256.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel254.setText("Legno:");
        jLabel255.setText("Mana:");
        jLabel256.setText("Granello di Fuoco:");
        itemSelected="staffaFuoco";
        jLabel252.setText("Totale posseduto:"+gioco.getDataGame().getStaffaFuoco());
    }//GEN-LAST:event_jFirewandMouseClicked

    private void jSickleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSickleMouseClicked
        jPanel50.setVisible(true);
        labelFisseItem();
        OggettoSelezionatoCreazione=8;
        jLabel251.setIcon(new ImageIcon(sickle));
        jLabel248.setText("Falce");
        jLabel250.setText("<html><p>Un'arma spesso usata dai contadini... o dai mietitori</p></html>");
       jLabel254.setIcon(new ImageIcon(iconaferro));
        jLabel255.setIcon(new ImageIcon(iconalegno));
        jLabel256.setIcon(new ImageIcon(temperatura));
        jLabel254.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel254.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel255.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel255.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel256.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel256.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel254.setText("Ferro:");
        jLabel255.setText("Legno:");
        jLabel256.setText("Temperatura:");
        itemSelected="falce";
        jLabel252.setText("Totale posseduto:"+gioco.getDataGame().getFalce());
    }//GEN-LAST:event_jSickleMouseClicked

    private void jIronMailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jIronMailMouseClicked
        jPanel50.setVisible(true);
        labelFisseItem();
        OggettoSelezionatoCreazione=9;
        jLabel251.setIcon(new ImageIcon(ironMail));
        jLabel248.setText("Maglia di Ferro");
        jLabel250.setText("<html><p>Protezione toracica pesante, per resistere ai colpi più duri</p></html>");
        jLabel254.setIcon(new ImageIcon(iconaferro));
        jLabel255.setIcon(new ImageIcon(temperatura));
         jLabel254.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel254.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel255.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel255.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel254.setText("Ferro:");
        jLabel255.setText("Temperatura:");
        jLabel256.setVisible(false);
        jLabel252.setText("Totale posseduto:"+gioco.getDataGame().getArmaturaMaglia());
        itemSelected="MagliaFerro";
    }//GEN-LAST:event_jIronMailMouseClicked

    private void jWizardsRobeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jWizardsRobeMouseClicked
        jPanel50.setVisible(true);
        labelFisseItem();
        OggettoSelezionatoCreazione=10;
        jLabel251.setIcon(new ImageIcon(elderWizardRobe));
        jLabel248.setText("Tunica del Mago");
        jLabel250.setText("<html><p>Abiti intrisi di magia, per chi ama lanciare incantesimi</p></html>");
        jLabel254.setIcon(new ImageIcon(iconamana));
        jLabel255.setIcon(new ImageIcon(clothrisorsa));
         jLabel254.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel254.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel255.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel255.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel254.setText("Mana:");
        jLabel255.setText("Stoffa:");
        jLabel256.setVisible(false);
        jLabel252.setText("Totale posseduto:"+gioco.getDataGame().getTunicaStregone());
        itemSelected="TunicaMago";
    }//GEN-LAST:event_jWizardsRobeMouseClicked

    private void jThiefsGarbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jThiefsGarbMouseClicked
        jPanel50.setVisible(true);
        labelFisseItem();
        OggettoSelezionatoCreazione=11;
        jLabel251.setIcon(new ImageIcon(thiefGarb));
        jLabel248.setText("Abito del Ladro");
        jLabel250.setText("<html><p>Un indumento potenziato magicamente, pensato esclusivamente per l'attacco.</p></html>");
        jLabel254.setIcon(new ImageIcon(iconamana));
        jLabel255.setIcon(new ImageIcon(temperatura));
        jLabel256.setIcon(new ImageIcon(clothrisorsa));
         jLabel254.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel254.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel255.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel255.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel256.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel256.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel254.setText("Mana:");
        jLabel255.setText("Temperatura:");
        jLabel256.setText("Stoffa:");
        jLabel252.setText("Totale posseduto:"+gioco.getDataGame().getVestitoLadro());
        itemSelected="abitoLadro";
    }//GEN-LAST:event_jThiefsGarbMouseClicked

    private void jCristalloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCristalloMouseClicked
        jPanel50.setVisible(true);
        labelFisseItem();
        OggettoSelezionatoCreazione=12;
        jLabel251.setIcon(new ImageIcon(crystallizedMana));
        String mana=getClass().getResource("/Img/mana.png").toString();
        jLabel248.setText("Cristallo di Mana");
        jLabel250.setText("<html><p>Una piccola roccia composta da materiale condensato. +2<img src='"+mana+"' width='13' height='13'>/sec</p></html>");
        jLabel254.setIcon(new ImageIcon(iconamana));
         jLabel254.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel254.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel254.setText("");
        jLabel255.setVisible(false);
        jLabel256.setVisible(false);
        jLabel252.setText("Totale posseduto:"+gioco.getDataGame().getCristallo());
        itemSelected="cristalloMana";
    }//GEN-LAST:event_jCristalloMouseClicked

    private void jSandaliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSandaliMouseClicked
        jPanel50.setVisible(true);
        labelFisseItem();
        OggettoSelezionatoCreazione=13;
        jLabel251.setIcon(new ImageIcon(woodenSandals));
        jLabel248.setText("Sandali di Legno");
        jLabel250.setText("<html><p>Un paio di sandali scomodi e goffi</p></html>");
        jLabel254.setIcon(new ImageIcon(iconalegno));
         jLabel254.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel254.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel254.setText("Legno:");
        jLabel255.setVisible(false);
        jLabel256.setVisible(false);
       jLabel252.setText("Totale posseduto:"+gioco.getDataGame().getSandaliLegno());
        itemSelected="sandaliLegno";
    }//GEN-LAST:event_jSandaliMouseClicked

    private void jCloakMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCloakMouseClicked
        jPanel50.setVisible(true);
        labelFisseItem();
        OggettoSelezionatoCreazione=14;
        jLabel251.setIcon(new ImageIcon(cloak));
        jLabel248.setText("Mantello");
        jLabel250.setText("<html><p>Un mantello semplice fatto di stoffa.</p></html>");
        jLabel254.setIcon(new ImageIcon(clothrisorsa));
         jLabel254.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel254.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel254.setText("Stoffa:");
        jLabel255.setVisible(false);
        jLabel256.setVisible(false);
        jLabel252.setText("Totale posseduto:"+gioco.getDataGame().getMantello());
        itemSelected="mantello";
    }//GEN-LAST:event_jCloakMouseClicked

    private void jClothShoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jClothShoesMouseClicked
       jPanel50.setVisible(true);
       labelFisseItem();
       OggettoSelezionatoCreazione=15;
       jLabel251.setIcon(new ImageIcon(clothShoes));
       jLabel248.setText("Scarpe di Stoffa");
       jLabel250.setText("<html><p>Scarpe semplici in tessuto. Rendono la camminata un po' più facile.</p></html>");
        jLabel254.setIcon(new ImageIcon(clothrisorsa));
         jLabel254.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel254.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel254.setText("Stoffa:");
        jLabel255.setVisible(false);
        jLabel256.setVisible(false);
        jLabel252.setText("Totale posseduto:"+gioco.getDataGame().getScarpeStoffa());
        itemSelected="scarpeStoffa";
    }//GEN-LAST:event_jClothShoesMouseClicked

    private void jEnchantedCloakMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jEnchantedCloakMouseClicked
        jPanel50.setVisible(true);
        labelFisseItem();
        OggettoSelezionatoCreazione=16;
        jLabel251.setIcon(new ImageIcon(enchantedCloak));
        jLabel248.setText("Mantello Incantato");
        jLabel250.setText("<html><p>Un mantello che è stato riformato e migliorato con la magia</p></html>");
        jLabel254.setIcon(new ImageIcon(iconamana));
        jLabel255.setIcon(new ImageIcon(cloakrisorsa));
        jLabel256.setIcon(new ImageIcon(clothrisorsa));
         jLabel254.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel254.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel255.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel255.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel256.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel256.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel254.setText("Mana:");
        jLabel255.setText("Mantello:");
        jLabel256.setText("Stoffa:");
        jLabel252.setText("Totale posseduto:"+gioco.getDataGame().getMantelloIncantato());
        itemSelected="mantelloIncantato";
    }//GEN-LAST:event_jEnchantedCloakMouseClicked

    private void jCloathMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCloathMouseClicked
        jPanel50.setVisible(true);
        labelFisseItem();
        OggettoSelezionatoCreazione=17;
        jLabel251.setIcon(new ImageIcon(cloth));
        jLabel248.setText("Stoffa");
        jLabel250.setText("<html><p>Un materiale di base per molti equipaggiamenti, in particolare per gli incantatori</p></html>");
        jLabel254.setIcon(new ImageIcon(wool));
         jLabel254.setHorizontalTextPosition(SwingConstants.RIGHT);
        jLabel254.setVerticalTextPosition(SwingConstants.CENTER);
        jLabel254.setText("Lana:");
        jLabel255.setVisible(false);
        jLabel256.setVisible(false);
        jLabel252.setText("Totale posseduto:"+gioco.getDataGame().getStoffa());
        itemSelected="stoffa";
    }//GEN-LAST:event_jCloathMouseClicked

    private void jButton131MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton131MouseClicked
    switch (itemSelected) {
        case "cassaLeggera":
            if (gioco.getDataGame().getMana() >= 750 && gioco.getDataGame().getLegno() >= 4500 && gioco.getDataGame().getFerro() >= 10) { 
                gioco.getDataGame().compraCassa(); 
                jLabel252.setText("Totale posseduto:"+gioco.getDataGame().getCassa());
            }
            break;
        case "ramo":
            if (gioco.getDataGame().getLegno() >= 300 && gioco.getDataGame().getMana() >= 1000) { 
                gioco.getDataGame().compraRamo(); 
                controlloInventario(branch,"Ramo");
                jLabel252.setText("Totale posseduto:"+gioco.getDataGame().getRamo());
            }
            break;
        case "mazza":
            if (gioco.getDataGame().getLegno() >= 900) { 
                gioco.getDataGame().compraMazza(); 
                controlloInventario(club,"Mazza");
                jLabel252.setText("Totale posseduto:"+gioco.getDataGame().getMazza());
            }
            break;
        case "pugnale":
            if (gioco.getDataGame().getFerro() >= 60 && gioco.getDataGame().getLegno() >= 40 && gioco.getDataGame().getFiamma() >= 300) { 
                gioco.getDataGame().compraPugnale();
                controlloInventario(dagger,"Pugnale");
                jLabel252.setText("Totale posseduto:"+gioco.getDataGame().getPugnale());
            }
            break;
        case "spada":
            if (gioco.getDataGame().getFerro() >= 120 && gioco.getDataGame().getLegno() >= 200 && gioco.getDataGame().getFiamma() >= 600) { 
                gioco.getDataGame().compraSpada(); 
                controlloInventario(sword,"Spada");
                jLabel252.setText("Totale posseduto:"+gioco.getDataGame().getSpada());
            }
            break;
        case "asciaMano":
            if (gioco.getDataGame().getFerro() >= 150 && gioco.getDataGame().getLegno() >= 300 && gioco.getDataGame().getFiamma() >= 600) { 
                gioco.getDataGame().compraAscia(); 
                controlloInventario(handAxe,"Ascia a una Mano");
                jLabel252.setText("Totale posseduto:"+gioco.getDataGame().getAscia());
            }
            break;
        case "staffaFuoco":
            if (gioco.getDataGame().getLegno() >= 3000 && gioco.getDataGame().getMana() >= 2500 && gioco.getDataGame().getFireSpeak() >= 1) { 
                gioco.getDataGame().compraStaffaFuoco(); 
                controlloInventario(firewand,"Staffa di Fuoco");
                jLabel252.setText("Totale posseduto:"+gioco.getDataGame().getStaffaFuoco());
            }
            break;
        case "falce":
            if (gioco.getDataGame().getFerro() >= 1100 && gioco.getDataGame().getLegno() >= 3000 && gioco.getDataGame().getFiamma() >= 1500) {
                gioco.getDataGame().compraFalce(); 
                controlloInventario(sickle,"Falce");
                jLabel252.setText("Totale posseduto:"+gioco.getDataGame().getFalce());
            }
            break;
        case "MagliaFerro":
            if (gioco.getDataGame().getFerro() >= 300 && gioco.getDataGame().getFiamma() >= 1200) { 
                gioco.getDataGame().compraArmaturaMaglia(); 
                controlloInventario(ironMail,"Maglia di Ferro");
                jLabel252.setText("Totale posseduto:"+gioco.getDataGame().getArmaturaMaglia());
            }
            break;
        case "TunicaMago":
            if (gioco.getDataGame().getMana() >= 1600 && gioco.getDataGame().getStoffa() >= 12) { 
                gioco.getDataGame().compraTunicaStregone();
                controlloInventario(elderWizardRobe,"Tunica del Mago");
                jLabel252.setText("Totale posseduto:"+gioco.getDataGame().getTunicaStregone());
            }
            break;
        case "abitoLadro":
            if (gioco.getDataGame().getMana() >= 2000 && gioco.getDataGame().getFiamma() >= 1500 && gioco.getDataGame().getStoffa() >= 15) {
                gioco.getDataGame().compraVestitoLadro(); 
                controlloInventario(thiefGarb,"Abito da Ladro");
                jLabel252.setText("Totale posseduto:"+gioco.getDataGame().getVestitoLadro());
            }
            break;
        case "cristalloMana":
            if (gioco.getDataGame().getMana() >= 1000) {
                gioco.getDataGame().compraCristallo(); 
                jLabel252.setText("Totale posseduto:"+gioco.getDataGame().getCristallo());
            }
            break;
        case "sandaliLegno":
            if (gioco.getDataGame().getLegno() >= 750) { 
                gioco.getDataGame().compraSandaliLegno(); 
                controlloInventario(woodenSandals,"Sandali di Legno");
                jLabel252.setText("Totale posseduto:"+gioco.getDataGame().getSandaliLegno());
            }
            break;
        case "mantello":
            if (gioco.getDataGame().getStoffa() >= 4) { 
                gioco.getDataGame().compraMantello(); 
                controlloInventario(cloak,"Mantello");
                jLabel252.setText("Totale posseduto:"+gioco.getDataGame().getMantello());
            }
            break;
        case "scarpeStoffa":
            if (gioco.getDataGame().getStoffa() >= 8) { 
                gioco.getDataGame().compraScarpeStoffa(); 
                controlloInventario(clothShoes,"Scarpe di Stoffa");
                jLabel252.setText("Totale posseduto:"+gioco.getDataGame().getScarpeStoffa());
            }
            break;
        case "mantelloIncantato":
            if (gioco.getDataGame().getMana() >= 2200 && gioco.getDataGame().getMantello() >= 1 && gioco.getDataGame().getStoffa() >= 4) { 
                gioco.getDataGame().compraMantelloIncantato(); 
                controlloInventario(enchantedCloak,"Mantello Incantato");
                jLabel252.setText("Totale posseduto:"+gioco.getDataGame().getMantelloIncantato());
            }
            break;
        case "stoffa":
            if (gioco.getDataGame().getLana() >= 4) { 
                gioco.getDataGame().compraStoffa(); 
                jLabel252.setText("Totale posseduto:"+gioco.getDataGame().getStoffa());
            }
            break;
    }
    }//GEN-LAST:event_jButton131MouseClicked

    private void jButton136MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton136MouseClicked
        if(jButton136.getIcon()!=null){
            bottoneSelected=1;
            Icon icon =jButton136.getIcon();
            jLabel266.setText(jButton136.getName());
            jPanel63.setVisible(true);
            jLabel267.setIcon(icon);
        }else{
            jPanel63.setVisible(false);
        }
    }//GEN-LAST:event_jButton136MouseClicked

    private void jButton137MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton137MouseClicked
       if(jButton137.getIcon()!=null){
           bottoneSelected=2;
            Icon icon=jButton137.getIcon();
            jLabel266.setText(jButton137.getName());
            jPanel63.setVisible(true);
             jLabel267.setIcon(icon);
        }else{
            jPanel63.setVisible(false);
        }
    }//GEN-LAST:event_jButton137MouseClicked

    private void jButton138MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton138MouseClicked
       if(jButton138.getIcon()!=null){
           bottoneSelected=3;
           Icon icon=jButton138.getIcon();
             jLabel266.setText(jButton138.getName());
             jPanel63.setVisible(true);
             jLabel267.setIcon(icon);
        }else{
            jPanel63.setVisible(false);
        }
    }//GEN-LAST:event_jButton138MouseClicked

    private void jButton139MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton139MouseClicked
        if(jButton139.getIcon()!=null){
            bottoneSelected=4;
            Icon icon=jButton139.getIcon();
            jLabel266.setText(jButton139.getName());
            jPanel63.setVisible(true);
            jLabel267.setIcon(icon);
        }else{
            jPanel63.setVisible(false);
        }
    }//GEN-LAST:event_jButton139MouseClicked

    private void jButton140MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton140MouseClicked
         if(jButton140.getIcon()!=null){
             bottoneSelected=5;
             Icon icon=jButton140.getIcon();
            jLabel266.setText(jButton140.getName());
            jPanel63.setVisible(true);
            jLabel267.setIcon(icon);
        }else{
            jPanel63.setVisible(false);
        }
    }//GEN-LAST:event_jButton140MouseClicked

    private void jButton141MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton141MouseClicked
        if(jButton141.getIcon()!=null){
            bottoneSelected=6;
            Icon icon=jButton141.getIcon();
            jLabel266.setText(jButton141.getName());
            jPanel63.setVisible(true);
            jLabel267.setIcon(icon);
        }else{
            jPanel63.setVisible(false);
        }
    }//GEN-LAST:event_jButton141MouseClicked

    private void jButton142MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton142MouseClicked
        if(jButton142.getIcon()!=null){
            bottoneSelected=7;
            Icon icon=jButton142.getIcon();
            jLabel266.setText(jButton142.getName());
            jPanel63.setVisible(true);
            jLabel267.setIcon(icon);
        }else{
            jPanel63.setVisible(false);
        }
    }//GEN-LAST:event_jButton142MouseClicked

    private void jButton143MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton143MouseClicked
       if(jButton143.getIcon()!=null){
           bottoneSelected=8;
           Icon icon=jButton143.getIcon();
           jLabel266.setText(jButton143.getName()); 
           jPanel63.setVisible(true);
           jLabel267.setIcon(icon);
        }else{
            jPanel63.setVisible(false);
        }
    }//GEN-LAST:event_jButton143MouseClicked

    private void jButton144MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton144MouseClicked
        if(jButton144.getIcon()!=null){
            bottoneSelected=9;
            Icon icon=jButton144.getIcon();
            jLabel266.setText(jButton144.getName());
            jPanel63.setVisible(true);
            jLabel267.setIcon(icon);
        }else{
            jPanel63.setVisible(false);
        }
    }//GEN-LAST:event_jButton144MouseClicked

    private void jButton145MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton145MouseClicked
         if(jButton136.getIcon()!=null){
             bottoneSelected=10;
             Icon icon=jButton145.getIcon();
            jLabel266.setText(jButton145.getName());
            jPanel63.setVisible(true);
            jLabel267.setIcon(icon);
        }else{
            jPanel63.setVisible(false);
        }
    }//GEN-LAST:event_jButton145MouseClicked

    private void jButton146MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton146MouseClicked
        if(jButton146.getIcon()!=null){
            bottoneSelected=11;
            Icon icon=jButton146.getIcon();
            jLabel266.setText(jButton146.getName());
            jPanel63.setVisible(true);
            jLabel267.setIcon(icon);
        }else{
            jPanel63.setVisible(false);
        }
    }//GEN-LAST:event_jButton146MouseClicked

    private void jButton147MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton147MouseClicked
        if(jButton147.getIcon()!=null){
            bottoneSelected=12;
            Icon icon=jButton147.getIcon();
            jLabel266.setText(jButton147.getName());
            jPanel63.setVisible(true);
            jLabel267.setIcon(icon);
        }else{
            jPanel63.setVisible(false);
        }
    }//GEN-LAST:event_jButton147MouseClicked

    private void jButton148MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton148MouseClicked
        if(jButton148.getIcon()!=null){
            bottoneSelected=13;
            Icon icon=jButton148.getIcon();
            jLabel266.setText(jButton148.getName());
            jPanel63.setVisible(true);
            jLabel267.setIcon(icon);
        }else{
            jPanel63.setVisible(false);
        }
    }//GEN-LAST:event_jButton148MouseClicked

    private void jButton149MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton149MouseClicked
        if(jButton149.getIcon()!=null){
            bottoneSelected=14;
            Icon icon=jButton149.getIcon();
            jLabel266.setText(jButton149.getName());
            jPanel63.setVisible(true);
            jLabel267.setIcon(icon);
        }else{
            jPanel63.setVisible(false);
        }
    }//GEN-LAST:event_jButton149MouseClicked

    private void jButton151MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton151MouseClicked
         if(jButton151.getIcon()!=null){
             bottoneSelected=15;
             Icon icon=jButton151.getIcon();
            jLabel266.setText(jButton151.getName());
            jPanel63.setVisible(true);
            jLabel267.setIcon(icon);
        }else{
            jPanel63.setVisible(false);
        }
    }//GEN-LAST:event_jButton151MouseClicked

    private void jButton152MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton152MouseClicked
       if(jButton152.getIcon()!=null){
           bottoneSelected=16;
           Icon icon=jButton152.getIcon();
            jLabel266.setText(jButton152.getName());
            jPanel63.setVisible(true);
            jLabel267.setIcon(icon);
        }else{
            jPanel63.setVisible(false);
        }
    }//GEN-LAST:event_jButton152MouseClicked

    private void jButton153MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton153MouseClicked
        if(jButton153.getIcon()!=null){
            bottoneSelected=17;
            Icon icon=jButton153.getIcon();
            jLabel266.setText(jButton153.getName());
            jPanel63.setVisible(true);
            jLabel267.setIcon(icon);
        }else{
            jPanel63.setVisible(false);
        }
    }//GEN-LAST:event_jButton153MouseClicked

    private void jButton154MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton154MouseClicked
       if(jButton153.getIcon()!=null){
           bottoneSelected=18;
           Icon icon=jButton153.getIcon();
            jLabel266.setText(jButton154.getName());
            jPanel63.setVisible(true);
            jLabel267.setIcon(icon);
        }else{
            jPanel63.setVisible(false);
        }
    }//GEN-LAST:event_jButton154MouseClicked

    private void jButton155MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton155MouseClicked
    switch (bottoneSelected) {
        case 1: {
            JButton btn = jButton136;
            btn.setEnabled(false);
            String name = btn.getName();
            Icon icon = btn.getIcon();
            ImageIcon image = (ImageIcon) icon;
            Image img = image.getImage().getScaledInstance(72, 72, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(img);
            if (name.equals("Ramo") || name.equals("Mazza") || name.equals("Pugnale") || name.equals("Spada") || name.equals("Ascia a una Mano") || name.equals("Staffa di Fuoco") || name.equals("Falce")) {
                jLabel249.setIcon(scaledIcon);
                jLabel249.setName("1");
                jLabel262.setText("Mano: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel249.getName());
            } else if (name.equals("Maglia di Ferro") || name.equals("Tunica del Mago") || name.equals("Abito del Ladro") || name.equals("Mantello Incantato") || name.equals("Scarpe di Stoffa") || name.equals("Mantello") || name.equals("Sandali di Legno")) {
                jLabel260.setIcon(scaledIcon);
                jLabel260.setName("1");
                jLabel263.setText("Corpo: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel260.getName());
            } else {
                jLabel261.setIcon(scaledIcon);
                jLabel261.setName("1");
                jLabel264.setText("Accessorio: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel261.getName());
            }
            break;
        }
        case 2: {
            JButton btn = jButton137;
            btn.setEnabled(false);
            String name = btn.getName();
            Icon icon = btn.getIcon();
            ImageIcon image = (ImageIcon) icon;
            Image img = image.getImage().getScaledInstance(72, 72, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(img);
            if (name.equals("Ramo") || name.equals("Mazza") || name.equals("Pugnale") || name.equals("Spada") || name.equals("Ascia a una Mano") || name.equals("Staffa di Fuoco") || name.equals("Falce")) {
                jLabel249.setIcon(scaledIcon);
                jLabel249.setName("2");
                jLabel262.setText("Mano: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel249.getName());
            } else if (name.equals("Maglia di Ferro") || name.equals("Tunica del Mago") || name.equals("Abito del Ladro") || name.equals("Mantello Incantato") || name.equals("Scarpe di Stoffa") || name.equals("Mantello") || name.equals("Sandali di Legno")) {
                jLabel260.setIcon(scaledIcon);
                jLabel260.setName("2");
                jLabel263.setText("Corpo: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel260.getName());
            } else {
                jLabel261.setIcon(scaledIcon);
                jLabel261.setName("2");
                jLabel264.setText("Accessorio: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel261.getName());
            }
            break;
        }
        case 3: {
            JButton btn = jButton138;
            btn.setEnabled(false);
            String name = btn.getName();
            Icon icon = btn.getIcon();
            ImageIcon image = (ImageIcon) icon;
            Image img = image.getImage().getScaledInstance(72, 72, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(img);
            if (name.equals("Ramo") || name.equals("Mazza") || name.equals("Pugnale") || name.equals("Spada") || name.equals("Ascia a una Mano") || name.equals("Staffa di Fuoco") || name.equals("Falce")) {
                jLabel249.setIcon(scaledIcon);
                jLabel249.setName("3");
                jLabel262.setText("Mano: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel249.getName());
            } else if (name.equals("Maglia di Ferro") || name.equals("Tunica del Mago") || name.equals("Abito del Ladro") || name.equals("Mantello Incantato") || name.equals("Scarpe di Stoffa") || name.equals("Mantello") || name.equals("Sandali di Legno")) {
                jLabel260.setIcon(scaledIcon);
                jLabel260.setName("3");
                jLabel263.setText("Corpo: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel260.getName());
            } else {
                jLabel261.setIcon(scaledIcon);
                jLabel261.setName("3");
                jLabel264.setText("Accessorio: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel261.getName());
            }
            break;
        }
        case 4: {
            JButton btn = jButton139;
            btn.setEnabled(false);
            String name = btn.getName();
            Icon icon = btn.getIcon();
            ImageIcon image = (ImageIcon) icon;
            Image img = image.getImage().getScaledInstance(72, 72, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(img);
            if (name.equals("Ramo") || name.equals("Mazza") || name.equals("Pugnale") || name.equals("Spada") || name.equals("Ascia a una Mano") || name.equals("Staffa di Fuoco") || name.equals("Falce")) {
                jLabel249.setIcon(scaledIcon);
                jLabel249.setName("4");
                jLabel262.setText("Mano: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel249.getName());
            } else if (name.equals("Maglia di Ferro") || name.equals("Tunica del Mago") || name.equals("Abito del Ladro") || name.equals("Mantello Incantato") || name.equals("Scarpe di Stoffa") || name.equals("Mantello") || name.equals("Sandali di Legno")) {
                jLabel260.setIcon(scaledIcon);
                jLabel260.setName("4");
                jLabel263.setText("Corpo: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel260.getName());
            } else {
                jLabel261.setIcon(scaledIcon);
                jLabel261.setName("4");
                jLabel264.setText("Accessorio: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel261.getName());
            }
            break;
        }
        case 5: {
            JButton btn = jButton140;
            btn.setEnabled(false);
            String name = btn.getName();
            Icon icon = btn.getIcon();
            ImageIcon image = (ImageIcon) icon;
            Image img = image.getImage().getScaledInstance(72, 72, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(img);
            if (name.equals("Ramo") || name.equals("Mazza") || name.equals("Pugnale") || name.equals("Spada") || name.equals("Ascia a una Mano") || name.equals("Staffa di Fuoco") || name.equals("Falce")) {
                jLabel249.setIcon(scaledIcon);
                jLabel249.setName("5");
                jLabel262.setText("Mano: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel249.getName());
            } else if (name.equals("Maglia di Ferro") || name.equals("Tunica del Mago") || name.equals("Abito del Ladro") || name.equals("Mantello Incantato") || name.equals("Scarpe di Stoffa") || name.equals("Mantello") || name.equals("Sandali di Legno")) {
                jLabel260.setIcon(scaledIcon);
                jLabel260.setName("5");
                jLabel263.setText("Corpo: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel260.getName());
            } else {
                jLabel261.setIcon(scaledIcon);
                jLabel261.setName("5");
                jLabel264.setText("Accessorio: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel261.getName());
            }
            break;
        }
        case 6: {
            JButton btn = jButton141;
            btn.setEnabled(false);
            String name = btn.getName();
            Icon icon = btn.getIcon();
            ImageIcon image = (ImageIcon) icon;
            Image img = image.getImage().getScaledInstance(72, 72, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(img);
            if (name.equals("Ramo") || name.equals("Mazza") || name.equals("Pugnale") || name.equals("Spada") || name.equals("Ascia a una Mano") || name.equals("Staffa di Fuoco") || name.equals("Falce")) {
                jLabel249.setIcon(scaledIcon);
                jLabel249.setName("6");
                jLabel262.setText("Mano: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel249.getName());
            } else if (name.equals("Maglia di Ferro") || name.equals("Tunica del Mago") || name.equals("Abito del Ladro") || name.equals("Mantello Incantato") || name.equals("Scarpe di Stoffa") || name.equals("Mantello") || name.equals("Sandali di Legno")) {
                jLabel260.setIcon(scaledIcon);
                jLabel260.setName("6");
                jLabel263.setText("Corpo: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel260.getName());
            } else {
                jLabel261.setIcon(scaledIcon);
                jLabel261.setName("6");
                jLabel264.setText("Accessorio: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel261.getName());
            }
            break;
        }
        case 7: {
            JButton btn = jButton142;
            btn.setEnabled(false);
            String name = btn.getName();
            Icon icon = btn.getIcon();
            ImageIcon image = (ImageIcon) icon;
            Image img = image.getImage().getScaledInstance(72, 72, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(img);
            if (name.equals("Ramo") || name.equals("Mazza") || name.equals("Pugnale") || name.equals("Spada") || name.equals("Ascia a una Mano") || name.equals("Staffa di Fuoco") || name.equals("Falce")) {
                jLabel249.setIcon(scaledIcon);
                jLabel249.setName("7");
                jLabel262.setText("Mano: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel249.getName());
            } else if (name.equals("Maglia di Ferro") || name.equals("Tunica del Mago") || name.equals("Abito del Ladro") || name.equals("Mantello Incantato") || name.equals("Scarpe di Stoffa") || name.equals("Mantello") || name.equals("Sandali di Legno")) {
                jLabel260.setIcon(scaledIcon);
                jLabel260.setName("7");
                jLabel263.setText("Corpo: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel260.getName());
            } else {
                jLabel261.setIcon(scaledIcon);
                jLabel261.setName("7");
                jLabel264.setText("Accessorio: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel261.getName());
            }
            break;
        }
        case 8: {
            JButton btn = jButton143;
            btn.setEnabled(false);
            String name = btn.getName();
            Icon icon = btn.getIcon();
            ImageIcon image = (ImageIcon) icon;
            Image img = image.getImage().getScaledInstance(72, 72, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(img);
            if (name.equals("Ramo") || name.equals("Mazza") || name.equals("Pugnale") || name.equals("Spada") || name.equals("Ascia a una Mano") || name.equals("Staffa di Fuoco") || name.equals("Falce")) {
                jLabel249.setIcon(scaledIcon);
                jLabel249.setName("8");
                jLabel262.setText("Mano: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel249.getName());
            }else if (name.equals("Maglia di Ferro") || name.equals("Tunica del Mago") || name.equals("Abito del Ladro") || name.equals("Mantello Incantato") || name.equals("Scarpe di Stoffa") || name.equals("Mantello") || name.equals("Sandali di Legno")) {
                jLabel260.setIcon(scaledIcon);
                jLabel260.setName("8");
                jLabel263.setText("Corpo: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel260.getName());
            } else {
                jLabel261.setIcon(scaledIcon);
                jLabel261.setName("8");
                jLabel264.setText("Accessorio: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel261.getName());
            }
            break;
        }
        case 9: {
            JButton btn = jButton144;
            btn.setEnabled(false);
            String name = btn.getName();
            Icon icon = btn.getIcon();
            ImageIcon image = (ImageIcon) icon;
            Image img = image.getImage().getScaledInstance(72, 72, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(img);
            if (name.equals("Ramo") || name.equals("Mazza") || name.equals("Pugnale") || name.equals("Spada") || name.equals("Ascia a una Mano") || name.equals("Staffa di Fuoco") || name.equals("Falce")) {
                jLabel249.setIcon(scaledIcon);
                jLabel249.setName("9");
                jLabel262.setText("Mano: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel249.getName());
            } else if (name.equals("Maglia di Ferro") || name.equals("Tunica del Mago") || name.equals("Abito del Ladro") || name.equals("Mantello Incantato") || name.equals("Scarpe di Stoffa") || name.equals("Mantello") || name.equals("Sandali di Legno")) {
                jLabel260.setIcon(scaledIcon);
                jLabel260.setName("9");
                jLabel263.setText("Corpo: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel260.getName());
            } else {
                jLabel261.setIcon(scaledIcon);
                jLabel261.setName("9");
                jLabel264.setText("Accessorio: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel261.getName());
            }
            break;
        }
        case 10: {
            JButton btn = jButton145;
            btn.setEnabled(false);
            String name = btn.getName();
            Icon icon = btn.getIcon();
            ImageIcon image = (ImageIcon) icon;
            Image img = image.getImage().getScaledInstance(72, 72, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(img);
            if (name.equals("Ramo") || name.equals("Mazza") || name.equals("Pugnale") || name.equals("Spada") || name.equals("Ascia a una Mano") || name.equals("Staffa di Fuoco") || name.equals("Falce")) {
                jLabel249.setIcon(scaledIcon);
                jLabel249.setName("10");
                jLabel262.setText("Mano: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel249.getName());
            } else if (name.equals("Maglia di Ferro") || name.equals("Tunica del Mago") || name.equals("Abito del Ladro") || name.equals("Mantello Incantato") || name.equals("Scarpe di Stoffa") || name.equals("Mantello") || name.equals("Sandali di Legno")) {
                jLabel260.setIcon(scaledIcon);
                jLabel260.setName("10");
                jLabel263.setText("Corpo: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel260.getName());
            } else {
                jLabel261.setIcon(scaledIcon);
                jLabel261.setName("10");
                jLabel264.setText("Accessorio: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel261.getName());
            }
            break;
        }
        case 11: {
            JButton btn = jButton146;
            btn.setEnabled(false);
            String name = btn.getName();
            Icon icon = btn.getIcon();
            ImageIcon image = (ImageIcon) icon;
            Image img = image.getImage().getScaledInstance(72, 72, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(img);
            if (name.equals("Ramo") || name.equals("Mazza") || name.equals("Pugnale") || name.equals("Spada") || name.equals("Ascia a una Mano") || name.equals("Staffa di Fuoco") || name.equals("Falce")) {
                jLabel249.setIcon(scaledIcon);
                jLabel249.setName("11");
                jLabel262.setText("Mano: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel249.getName());
            } else if (name.equals("Maglia di Ferro") || name.equals("Tunica del Mago") || name.equals("Abito del Ladro") || name.equals("Mantello Incantato") || name.equals("Scarpe di Stoffa") || name.equals("Mantello") || name.equals("Sandali di Legno")) {
                jLabel260.setIcon(scaledIcon);
                jLabel260.setName("11");
                jLabel263.setText("Corpo: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel260.getName());
            } else {
                jLabel261.setIcon(scaledIcon);
                jLabel261.setName("11");
                jLabel264.setText("Accessorio: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel261.getName());
            }
            break;
        }
        case 12: {
            JButton btn = jButton147;
            btn.setEnabled(false);
            String name = btn.getName();
            Icon icon = btn.getIcon();
            ImageIcon image = (ImageIcon) icon;
            Image img = image.getImage().getScaledInstance(72, 72, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(img);
            if (name.equals("Ramo") || name.equals("Mazza") || name.equals("Pugnale") || name.equals("Spada") || name.equals("Ascia a una Mano") || name.equals("Staffa di Fuoco") || name.equals("Falce")) {
                jLabel249.setIcon(scaledIcon);
                jLabel249.setName("12");
                jLabel262.setText("Mano: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel249.getName());
            } else if (name.equals("Maglia di Ferro") || name.equals("Tunica del Mago") || name.equals("Abito del Ladro") || name.equals("Mantello Incantato") || name.equals("Scarpe di Stoffa") || name.equals("Mantello") || name.equals("Sandali di Legno")) {
                jLabel260.setIcon(scaledIcon);
                jLabel260.setName("12");
                jLabel263.setText("Corpo: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel260.getName());
            } else {
                jLabel261.setIcon(scaledIcon);
                jLabel261.setName("12");
                jLabel264.setText("Accessorio: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel261.getName());
            }
            break;
        }
        case 13: {
            JButton btn = jButton148;
            btn.setEnabled(false);
            String name = btn.getName();
            Icon icon = btn.getIcon();
            ImageIcon image = (ImageIcon) icon;
            Image img = image.getImage().getScaledInstance(72, 72, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(img);
            if (name.equals("Ramo") || name.equals("Mazza") || name.equals("Pugnale") || name.equals("Spada") || name.equals("Ascia a una Mano") || name.equals("Staffa di Fuoco") || name.equals("Falce")) {
                jLabel249.setIcon(scaledIcon);
                jLabel249.setName("13");
                jLabel262.setText("Mano: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel249.getName());
            } else if (name.equals("Maglia di Ferro") || name.equals("Tunica del Mago") || name.equals("Abito del Ladro") || name.equals("Mantello Incantato") || name.equals("Scarpe di Stoffa") || name.equals("Mantello") || name.equals("Sandali di Legno")) {
                jLabel260.setIcon(scaledIcon);
                jLabel260.setName("13");
                jLabel263.setText("Corpo: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel260.getName());
            } else {
                jLabel261.setIcon(scaledIcon);
                jLabel261.setName("13");
                jLabel264.setText("Accessorio: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel261.getName());
            }
            break;
        }
        case 14: {
            JButton btn = jButton149;
            btn.setEnabled(false);
            String name = btn.getName();
            Icon icon = btn.getIcon();
            ImageIcon image = (ImageIcon) icon;
            Image img = image.getImage().getScaledInstance(72, 72, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(img);
            if (name.equals("Ramo") || name.equals("Mazza") || name.equals("Pugnale") || name.equals("Spada") || name.equals("Ascia a una Mano") || name.equals("Staffa di Fuoco") || name.equals("Falce")) {
                jLabel249.setIcon(scaledIcon);
                jLabel249.setName("14");
                jLabel262.setText("Mano: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel249.getName());
            } else if (name.equals("Maglia di Ferro") || name.equals("Tunica del Mago") || name.equals("Abito del Ladro") || name.equals("Mantello Incantato") || name.equals("Scarpe di Stoffa") || name.equals("Mantello") || name.equals("Sandali di Legno")) {
                jLabel260.setIcon(scaledIcon);
                jLabel260.setName("14");
                jLabel263.setText("Corpo: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel260.getName());
            } else {
                jLabel261.setIcon(scaledIcon);
                jLabel261.setName("14");
                jLabel264.setText("Accessorio: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel261.getName());
            }
            break;
        }
        case 15: {
            JButton btn = jButton151;
            btn.setEnabled(false);
            String name = btn.getName();
            Icon icon = btn.getIcon();
            ImageIcon image = (ImageIcon) icon;
            Image img = image.getImage().getScaledInstance(72, 72, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(img);
            if (name.equals("Ramo") || name.equals("Mazza") || name.equals("Pugnale") || name.equals("Spada") || name.equals("Ascia a una Mano") || name.equals("Staffa di Fuoco") || name.equals("Falce")) {
                jLabel249.setIcon(scaledIcon);
                jLabel249.setName("15");
                jLabel262.setText("Mano: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel249.getName());
            } else if (name.equals("Maglia di Ferro") || name.equals("Tunica del Mago") || name.equals("Abito del Ladro") || name.equals("Mantello Incantato") || name.equals("Scarpe di Stoffa") || name.equals("Mantello") || name.equals("Sandali di Legno")) {
                jLabel260.setIcon(scaledIcon);
                jLabel260.setName("15");
                jLabel263.setText("Corpo: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel260.getName());
            } else {
                jLabel261.setIcon(scaledIcon);
                jLabel261.setName("15");
                jLabel264.setText("Accessorio: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel261.getName());
            }
            break;
        }
        case 16: {
            JButton btn = jButton152;
            btn.setEnabled(false);
            String name = btn.getName();
            Icon icon = btn.getIcon();
            ImageIcon image = (ImageIcon) icon;
            Image img = image.getImage().getScaledInstance(72, 72, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(img);
            if (name.equals("Ramo") || name.equals("Mazza") || name.equals("Pugnale") || name.equals("Spada") || name.equals("Ascia a una Mano") || name.equals("Staffa di Fuoco") || name.equals("Falce")) {
                jLabel249.setIcon(scaledIcon);
                jLabel249.setName("16");
                jLabel262.setText("Mano: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel249.getName());
            } else if (name.equals("Maglia di Ferro") || name.equals("Tunica del Mago") || name.equals("Abito del Ladro") || name.equals("Mantello Incantato") || name.equals("Scarpe di Stoffa") || name.equals("Mantello") || name.equals("Sandali di Legno")) {
                jLabel260.setIcon(scaledIcon);
                jLabel260.setName("16");
                jLabel263.setText("Corpo: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel260.getName());
            } else {
                jLabel261.setIcon(scaledIcon);
                jLabel261.setName("16");
                jLabel264.setText("Accessorio: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel261.getName());
            }
            break;
        }
        case 17: {
            JButton btn = jButton153;
            btn.setEnabled(false);
            String name = btn.getName();
            Icon icon = btn.getIcon();
            ImageIcon image = (ImageIcon) icon;
            Image img = image.getImage().getScaledInstance(72, 72, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(img);
            if (name.equals("Ramo") || name.equals("Mazza") || name.equals("Pugnale") || name.equals("Spada") || name.equals("Ascia a una Mano") || name.equals("Staffa di Fuoco") || name.equals("Falce")) {
                jLabel249.setIcon(scaledIcon);
                jLabel249.setName("17");
                jLabel262.setText("Mano: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel249.getName());
            } else if (name.equals("Maglia di Ferro") || name.equals("Tunica del Mago") || name.equals("Abito del Ladro") || name.equals("Mantello Incantato") || name.equals("Scarpe di Stoffa") || name.equals("Mantello") || name.equals("Sandali di Legno")) {
                jLabel260.setIcon(scaledIcon);
                jLabel260.setName("17");
                jLabel263.setText("Corpo: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel260.getName());
            } else {
                jLabel261.setIcon(scaledIcon);
                jLabel261.setName("17");
                jLabel264.setText("Accessorio: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel261.getName());
            }
            break;
        }
        case 18: {
            JButton btn = jButton154;
            btn.setEnabled(false);
            String name = btn.getName();
            Icon icon = btn.getIcon();
            ImageIcon image = (ImageIcon) icon;
            Image img = image.getImage().getScaledInstance(72, 72, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(img);
            if (name.equals("Ramo") || name.equals("Mazza") || name.equals("Pugnale") || name.equals("Spada") || name.equals("Ascia a una Mano") || name.equals("Staffa di Fuoco") || name.equals("Falce")) {
                jLabel249.setIcon(scaledIcon);
                jLabel249.setName("18");
                jLabel262.setText("Mano: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel249.getName());
            } else if (name.equals("Maglia di Ferro") || name.equals("Tunica del Mago") || name.equals("Abito del Ladro") || name.equals("Mantello Incantato") || name.equals("Scarpe di Stoffa") || name.equals("Mantello") || name.equals("Sandali di Legno")) {
                jLabel260.setIcon(scaledIcon);
                jLabel260.setName("18");
                jLabel263.setText("Corpo: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel260.getName());
            } else {
                jLabel261.setIcon(scaledIcon);
                jLabel261.setName("18");
                jLabel264.setText("Accessorio: " + name);
                gioco.getDataGame().aggiungiEquipaggiamento(name, jLabel261.getName());
            }
            break;
        }
    }
    jPanel63.setVisible(false);
    }//GEN-LAST:event_jButton155MouseClicked

    private void jButton133MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton133MouseClicked
        int posizioneOggetto=Integer.parseInt(jLabel249.getName());
        jLabel249.setIcon(null);
        jLabel249.setName(null);
        jLabel262.setText("Mano: Vuoto");
        gioco.getDataGame().setMano("");
        switch(posizioneOggetto){
            case 1:
                jButton136.setEnabled(true);
            case 2:
                jButton137.setEnabled(true);
            case 3:
                jButton138.setEnabled(true);
            case 4: 
                jButton139.setEnabled(true);
            case 5:
                jButton140.setEnabled(true);
            case 6:
                jButton141.setEnabled(true);
            case 7:
                jButton142.setEnabled(true);
            case 8:
                jButton143.setEnabled(true);
            case 9:
                jButton144.setEnabled(true);
            case 10:
                jButton145.setEnabled(true);
            case 11:
                jButton146.setEnabled(true);
            case 12:
                jButton147.setEnabled(true);
            case 13:
                jButton148.setEnabled(true);
            case 14:
                jButton149.setEnabled(true);
            case 15:
                jButton151.setEnabled(true);
            case 16:
                jButton152.setEnabled(true);
            case 17:
                jButton153.setEnabled(true);
            case 18:
                jButton154.setEnabled(true);
        }
    }//GEN-LAST:event_jButton133MouseClicked

    private void jButton134MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton134MouseClicked
        int posizioneOggetto=Integer.parseInt(jLabel260.getName());
        jLabel260.setIcon(null);
        jLabel260.setName(null);
        jLabel263.setText("Corpo: Vuoto");
        gioco.getDataGame().setCorpo("");
        switch(posizioneOggetto){
            case 1:
                jButton136.setEnabled(true);
            case 2:
                jButton137.setEnabled(true);
            case 3:
                jButton138.setEnabled(true);
            case 4: 
                jButton139.setEnabled(true);
            case 5:
                jButton140.setEnabled(true);
            case 6:
                jButton141.setEnabled(true);
            case 7:
                jButton142.setEnabled(true);
            case 8:
                jButton143.setEnabled(true);
            case 9:
                jButton144.setEnabled(true);
            case 10:
                jButton145.setEnabled(true);
            case 11:
                jButton146.setEnabled(true);
            case 12:
                jButton147.setEnabled(true);
            case 13:
                jButton148.setEnabled(true);
            case 14:
                jButton149.setEnabled(true);
            case 15:
                jButton151.setEnabled(true);
            case 16:
                jButton152.setEnabled(true);
            case 17:
                jButton153.setEnabled(true);
            case 18:
                jButton154.setEnabled(true);
        }
    }//GEN-LAST:event_jButton134MouseClicked

    private void jButton135MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton135MouseClicked
        int posizioneOggetto=Integer.parseInt(jLabel261.getName());
        jLabel261.setIcon(null);
        jLabel261.setName(null);
        jLabel264.setText("Accessorio: Vuoto");
        gioco.getDataGame().setAccessorio("");
        switch(posizioneOggetto){
            case 1:
                jButton136.setEnabled(true);
            case 2:
                jButton137.setEnabled(true);
            case 3:
                jButton138.setEnabled(true);
            case 4: 
                jButton139.setEnabled(true);
            case 5:
                jButton140.setEnabled(true);
            case 6:
                jButton141.setEnabled(true);
            case 7:
                jButton142.setEnabled(true);
            case 8:
                jButton143.setEnabled(true);
            case 9:
                jButton144.setEnabled(true);
            case 10:
                jButton145.setEnabled(true);
            case 11:
                jButton146.setEnabled(true);
            case 12:
                jButton147.setEnabled(true);
            case 13:
                jButton148.setEnabled(true);
            case 14:
                jButton149.setEnabled(true);
            case 15:
                jButton151.setEnabled(true);
            case 16:
                jButton152.setEnabled(true);
            case 17:
                jButton153.setEnabled(true);
            case 18:
                jButton154.setEnabled(true);
        }
    }//GEN-LAST:event_jButton135MouseClicked

    private void jButton65MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton65MouseClicked
        gioco.getDataGame().aggiungereApprendistaMineraleFerro();
        jLabel52.setText(calcoloManaApprendisti()+"/sec");
    }//GEN-LAST:event_jButton65MouseClicked

    private void jButton24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton24MouseClicked
        gioco.getDataGame().rimuovereApprendistaMineraleFerro();
        jLabel52.setText(calcoloManaApprendisti()+"/sec");
    }//GEN-LAST:event_jButton24MouseClicked

    private void jButton84MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton84MouseClicked
         gioco.getDataGame().aggiungereApprendistaMasso();
        jLabel52.setText(calcoloManaApprendisti()+"/sec");
    }//GEN-LAST:event_jButton84MouseClicked

    private void jButton44MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton44MouseClicked
        gioco.getDataGame().rimuovereApprendistaMasso();
        jLabel52.setText(calcoloManaApprendisti()+"/sec");
    }//GEN-LAST:event_jButton44MouseClicked

    private void jButton85MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton85MouseClicked
       gioco.getDataGame().aggiungereApprendistaAcquaIII();
        jLabel52.setText(calcoloManaApprendisti()+"/sec");
    }//GEN-LAST:event_jButton85MouseClicked

    private void jButton45MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton45MouseClicked
        gioco.getDataGame().rimuovereApprendistaAcquaIII();
        jLabel52.setText(calcoloManaApprendisti()+"/sec");
    }//GEN-LAST:event_jButton45MouseClicked

    private void jButton86MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton86MouseClicked
        gioco.getDataGame().aggiungereApprendistaSbarraFerro();
        jLabel52.setText(calcoloManaApprendisti()+"/sec");
    }//GEN-LAST:event_jButton86MouseClicked

    private void jButton60MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton60MouseClicked
        gioco.getDataGame().rimuovereApprendistaSbarraFerro();
        jLabel52.setText(calcoloManaApprendisti()+"/sec");
    }//GEN-LAST:event_jButton60MouseClicked

    private void jButton96MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton96MouseClicked
        gioco.getDataGame().aggiungereApprendistaIncantoDepositi();
        jLabel52.setText(calcoloManaApprendisti()+"/sec");
    }//GEN-LAST:event_jButton96MouseClicked

    private void jButton92MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton92MouseClicked
        gioco.getDataGame().rimuovereApprendistaIncantoDepositi();
        jLabel52.setText(calcoloManaApprendisti()+"/sec");
    }//GEN-LAST:event_jButton92MouseClicked

    private void jButton98MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton98MouseClicked
        gioco.getDataGame().aggiungereApprendistaGeyserIncanto();
        jLabel52.setText(calcoloManaApprendisti()+"/sec");
    }//GEN-LAST:event_jButton98MouseClicked

    private void jButton93MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton93MouseClicked
        gioco.getDataGame().rimuovereApprendistaGeyserIncanto();
        jLabel52.setText(calcoloManaApprendisti()+"/sec");
    }//GEN-LAST:event_jButton93MouseClicked

    private void jButton107MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton107MouseClicked
        gioco.getDataGame().aggiungereApprendistaVento();
        jLabel52.setText(calcoloManaApprendisti()+"/sec");
    }//GEN-LAST:event_jButton107MouseClicked

    private void jButton101MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton101MouseClicked
        gioco.getDataGame().rimuovereApprendistaVento();
        jLabel52.setText(calcoloManaApprendisti()+"/sec");
    }//GEN-LAST:event_jButton101MouseClicked

    private void jButton108MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton108MouseClicked
        gioco.getDataGame().aggiungereApprendistaBolle();
        jLabel52.setText(calcoloManaApprendisti()+"/sec");
    }//GEN-LAST:event_jButton108MouseClicked

    private void jButton103MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton103MouseClicked
        gioco.getDataGame().rimuovereApprendistaBolle();
        jLabel52.setText(calcoloManaApprendisti()+"/sec");
    }//GEN-LAST:event_jButton103MouseClicked

    private void jButton110MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton110MouseClicked
         gioco.getDataGame().aggiungereApprendistaFuoco();
        jLabel52.setText(calcoloManaApprendisti()+"/sec");
    }//GEN-LAST:event_jButton110MouseClicked

    private void jButton105MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton105MouseClicked
        gioco.getDataGame().rimuovereApprendistaFuoco();
        jLabel52.setText(calcoloManaApprendisti()+"/sec");
    }//GEN-LAST:event_jButton105MouseClicked

    private void jButton150MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton150MouseClicked
        if(jButton150.getText().equals("Scartare")){
            jButton150.setText("Sei sicuro?");
        }else if(jButton150.getText().equals("Sei sicuro?")){
            if(bottoniItem.get(bottoneSelected-1).isEnabled()){
            String oggetto=bottoniItem.get(bottoneSelected-1).getName();
            switch(oggetto){
            case "Maglia di Ferro":
                gioco.getDataGame().rimuoviMagliFerro();
                break;
            case "Falce":
                gioco.getDataGame().rimuoviFalce();
                break;
            case "Staffa di Fuoco":
                gioco.getDataGame().rimuoviStaffaFuoco();
                break;
            case "Ascia a una Mano":
                gioco.getDataGame().rimuoviAscia();
                break;
            case "Spada":
                gioco.getDataGame().rimuoviSpada();
                break;
            case "Pugnale":
                gioco.getDataGame().rimuoviPugnale();
                break;
            case "Mazza":
                gioco.getDataGame().rimuoviMazza();
                break;
            case "Ramo":
                gioco.getDataGame().rimuoviRamo();
                break;
            case "Mantello Incantato":
                gioco.getDataGame().rimuoviMantelloIncantato();
                break;
            case "Scarpe di Stoffa":
                gioco.getDataGame().rimuoviScarpeStoffa();
                break;
            case "Mantello":
                gioco.getDataGame().rimuoviMantello();
                break;
            case "Sandali di Legno":
                gioco.getDataGame().rimuoviSandali();
                break;
            case "Abito da Ladro":
                gioco.getDataGame().rimuoviAbitoLadro();
                break;
            case "Tunica del Mago":
                gioco.getDataGame().rimuoviTunicaStregone();
                break;
        }
        bottoniItem.get(bottoneSelected-1).setIcon(null);
        bottoniItem.get(bottoneSelected-1).setName(null);
        gioco.getDataGame().rimuoviItemInventario(bottoneSelected-1);
        }
            jButton150.setText("Scartare");
        }
        
        

    }//GEN-LAST:event_jButton150MouseClicked
    private void controlloInventario(Image a, String id){
          for(JButton b:bottoniItem){
            if(b.getIcon()==null){
                b.setIcon(new ImageIcon(a));
                b.setName(id);
                gioco.getDataGame().aggiungiItemInventario(id);
                return;
            }
        }
    }
    private double calcoloManaApprendisti(){
        double n=0.16 * gioco.getDataGame().getApprendistiPietra()+0.33*gioco.getDataGame().getApprendistiAcqua()+1.33*gioco.getDataGame().getApprendistiRoccia()+1.33*gioco.getDataGame().getApprendistiGettiMana()+3*gioco.getDataGame().getApprendistiAcquaII()+0.5*gioco.getDataGame().getApprendistiMagia()+0.66*gioco.getDataGame().getApprendistiMineraliFerro()+7.33*gioco.getDataGame().getApprendistiMasso()+17.06*gioco.getDataGame().getApprendistiAcquaIII()+5.33*gioco.getDataGame().getApprendistiSbarraFerro()+1.33*gioco.getDataGame().getApprendistiDepositoLegno()+2.66*gioco.getDataGame().getApprendistiGeyserMana()+1.16*gioco.getDataGame().getApprendistiVento()+2.50*gioco.getDataGame().getApprendistiBolle()+4.83*gioco.getDataGame().getApprendistiFuoco();
        return n;
    }
    private double calcoloManaTotale(){
        return (gioco.getDataGame().getCalcoloTempoAcqua()+gioco.getDataGame().getCalcoloTempoAcquaII()+gioco.getDataGame().getCalcoloTempoAcquaIII()+gioco.getDataGame().getCalcoloTempoBarreFerro()+gioco.getDataGame().getCalcoloTempoDepositiLegno()+gioco.getDataGame().getCalcoloTempoGeyser()+gioco.getDataGame().getCalcoloTempoIncantiMana()+gioco.getDataGame().getCalcoloTempoMasso()+gioco.getDataGame().getCalcoloTempoMineraliFerro()+gioco.getDataGame().getCalcoloTempoPietra()+gioco.getDataGame().getCalcoloTempoRoccia()+gioco.getDataGame().getCalcoloTempoSpettacoloBolle()+gioco.getDataGame().getCalcoloTempoSpettacoloFuoco()+gioco.getDataGame().getCalcoloTempoSpettacoloMagia()+gioco.getDataGame().getCalcoloTempoSpettacoloVento())*calcoloManaApprendisti();
    }
   private void labelFisseItem(){
       jLabel254.setVisible(true);
       jLabel255.setVisible(true);
       jLabel256.setVisible(true);
   }
   private void labelItem(){
       jLabel257.setVisible(true);
       jLabel258.setVisible(true);
       jLabel259.setVisible(true);
   }
  private void riavviaApplicazione() {
        try {
            String javaBin = System.getProperty("java.home") + "/bin/java";
            String classPath = System.getProperty("java.class.path");
            String className = getClass().getName();

            ProcessBuilder builder = new ProcessBuilder(javaBin, "-cp", classPath, className);
            builder.start(); // Avvia una nuova istanza dell'app

            System.exit(0); // Chiude l'attuale istanza
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
  
public static void main(String args[]) {
      try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton AcquaB;
    private javax.swing.JToggleButton AriaB;
    private javax.swing.JButton BottonEXp;
    private javax.swing.JButton BottoneCabina1;
    private javax.swing.JButton BottoneCaveau;
    private javax.swing.JButton BottoneGeyser;
    private javax.swing.JButton BottoneLegname;
    private javax.swing.JButton BottoneMagazzinaggio;
    private javax.swing.JButton BottoneMagazzino;
    private javax.swing.JButton BottoneMana;
    private javax.swing.JButton BottonePezziTempo;
    private javax.swing.JButton BottoneProduzione;
    private javax.swing.JButton BottoneRaccolta;
    private javax.swing.JButton BottoneRicercatore;
    private javax.swing.JButton BottoneSI;
    private javax.swing.JButton BottoneSerbatoio;
    private javax.swing.JButton BottoneShard;
    private javax.swing.JButton BottoneSilos;
    private javax.swing.JButton BottoneTempo;
    private javax.swing.JPanel CardHelp;
    private javax.swing.JToggleButton EvocazioneB;
    private javax.swing.JPanel FissoApprendisti;
    private javax.swing.JPanel FissoPrincipale;
    private javax.swing.JToggleButton FuocoB;
    private javax.swing.JPanel HomePage;
    private javax.swing.JButton IB;
    private javax.swing.JToggleButton IllusioneB;
    private javax.swing.JToggleButton IncantoB;
    private javax.swing.JLabel LDE;
    private javax.swing.JLabel LIE;
    private javax.swing.JLabel LIS;
    private javax.swing.JLabel LSD;
    private javax.swing.JPanel PanelSuperioreG;
    private javax.swing.JPanel PanelloAbout;
    private javax.swing.JPanel PanelloFisso;
    private javax.swing.JPanel PanelloImpostazioni;
    private javax.swing.JPanel PanelloInformazioni;
    private javax.swing.JPanel PanelloRicerca;
    private javax.swing.JPanel PanelloRitirati;
    private javax.swing.JPanel PanneloApprendisti;
    private javax.swing.JPanel PanneloCreaItem;
    private javax.swing.JPanel PanneloItem;
    private javax.swing.JPanel PanneloPrincipale;
    private javax.swing.JButton RaccogliFerro;
    private javax.swing.JButton RaccogliLegno;
    private javax.swing.JButton RaccogliMana;
    private javax.swing.JLabel RisorsaAcquaGeyser;
    private javax.swing.JLabel RisorsaAcquaSilos;
    private javax.swing.JLabel RisorsaApprendistaLegno;
    private javax.swing.JLabel RisorsaApprendistaMonete;
    private javax.swing.JLabel RisorsaApprendistaPietra;
    private javax.swing.JLabel RisorsaFerroGeyser;
    private javax.swing.JLabel RisorsaLegnoCabina;
    private javax.swing.JLabel RisorsaLegnoLegname;
    private javax.swing.JLabel RisorsaLegnoSerbatoio;
    private javax.swing.JLabel RisorsaManaLegname;
    private javax.swing.JLabel RisorsaMoneteCabina;
    private javax.swing.JLabel RisorsaMoneteCaveau;
    private javax.swing.JLabel RisorsaMoneteGeyser;
    private javax.swing.JLabel RisorsaMoneteMagazzino;
    private javax.swing.JLabel RisorsaMoneteSerbatoio;
    private javax.swing.JLabel RisorsaMoneteShard;
    private javax.swing.JLabel RisorsaPietraCabina;
    private javax.swing.JLabel RisorsaPietraCaveau;
    private javax.swing.JLabel RisorsaPietraLegname;
    private javax.swing.JLabel RisorsaPietraMagazzino;
    private javax.swing.JLabel RisorsaPietraSerbatoio;
    private javax.swing.JLabel RisorsaPietraSilos;
    private javax.swing.JLabel RisorsaTempo;
    private javax.swing.JLabel TE;
    private javax.swing.JLabel TEsto;
    private javax.swing.JLabel TS;
    private javax.swing.JToggleButton TerraB;
    private javax.swing.JLabel TestoCaveau;
    private javax.swing.JLabel TestoFerro;
    private javax.swing.JLabel TestoGeyser;
    private javax.swing.JLabel TestoLegname;
    private javax.swing.JLabel TestoLegno;
    private javax.swing.JLabel TestoMagazzino;
    private javax.swing.JLabel TestoMana;
    private javax.swing.JLabel TestoSerbatoio;
    private javax.swing.JLabel TestoShard;
    private javax.swing.JLabel TestoSilos;
    private javax.swing.JLabel TestoTempo;
    private javax.swing.JProgressBar barra;
    private javax.swing.JButton btnApriFile;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton campusB;
    private javax.swing.JButton helpb;
    private javax.swing.JButton impostazioniB;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton100;
    private javax.swing.JButton jButton101;
    private javax.swing.JButton jButton102;
    private javax.swing.JButton jButton103;
    private javax.swing.JButton jButton104;
    private javax.swing.JButton jButton105;
    private javax.swing.JButton jButton106;
    private javax.swing.JButton jButton107;
    private javax.swing.JButton jButton108;
    private javax.swing.JButton jButton109;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton110;
    private javax.swing.JButton jButton111;
    private javax.swing.JButton jButton112;
    private javax.swing.JButton jButton113;
    private javax.swing.JButton jButton114;
    private javax.swing.JButton jButton115;
    private javax.swing.JButton jButton116;
    private javax.swing.JButton jButton117;
    private javax.swing.JButton jButton118;
    private javax.swing.JButton jButton119;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton120;
    private javax.swing.JButton jButton121;
    private javax.swing.JButton jButton122;
    private javax.swing.JButton jButton123;
    private javax.swing.JButton jButton124;
    private javax.swing.JButton jButton125;
    private javax.swing.JButton jButton126;
    private javax.swing.JButton jButton127;
    private javax.swing.JButton jButton128;
    private javax.swing.JButton jButton129;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton130;
    private javax.swing.JButton jButton131;
    private javax.swing.JButton jButton132;
    private javax.swing.JButton jButton133;
    private javax.swing.JButton jButton134;
    private javax.swing.JButton jButton135;
    private javax.swing.JButton jButton136;
    private javax.swing.JButton jButton137;
    private javax.swing.JButton jButton138;
    private javax.swing.JButton jButton139;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton140;
    private javax.swing.JButton jButton141;
    private javax.swing.JButton jButton142;
    private javax.swing.JButton jButton143;
    private javax.swing.JButton jButton144;
    private javax.swing.JButton jButton145;
    private javax.swing.JButton jButton146;
    private javax.swing.JButton jButton147;
    private javax.swing.JButton jButton148;
    private javax.swing.JButton jButton149;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton150;
    private javax.swing.JButton jButton151;
    private javax.swing.JButton jButton152;
    private javax.swing.JButton jButton153;
    private javax.swing.JButton jButton154;
    private javax.swing.JButton jButton155;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton49;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton51;
    private javax.swing.JButton jButton52;
    private javax.swing.JButton jButton53;
    private javax.swing.JButton jButton54;
    private javax.swing.JButton jButton55;
    private javax.swing.JButton jButton56;
    private javax.swing.JButton jButton57;
    private javax.swing.JButton jButton58;
    private javax.swing.JButton jButton59;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton60;
    private javax.swing.JButton jButton61;
    private javax.swing.JButton jButton62;
    private javax.swing.JButton jButton63;
    private javax.swing.JButton jButton64;
    private javax.swing.JButton jButton65;
    private javax.swing.JButton jButton66;
    private javax.swing.JButton jButton67;
    private javax.swing.JButton jButton68;
    private javax.swing.JButton jButton69;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton70;
    private javax.swing.JButton jButton71;
    private javax.swing.JButton jButton72;
    private javax.swing.JButton jButton73;
    private javax.swing.JButton jButton74;
    private javax.swing.JButton jButton75;
    private javax.swing.JButton jButton76;
    private javax.swing.JButton jButton77;
    private javax.swing.JButton jButton78;
    private javax.swing.JButton jButton79;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton80;
    private javax.swing.JButton jButton81;
    private javax.swing.JButton jButton82;
    private javax.swing.JButton jButton83;
    private javax.swing.JButton jButton84;
    private javax.swing.JButton jButton85;
    private javax.swing.JButton jButton86;
    private javax.swing.JButton jButton87;
    private javax.swing.JButton jButton88;
    private javax.swing.JButton jButton89;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButton90;
    private javax.swing.JButton jButton91;
    private javax.swing.JButton jButton92;
    private javax.swing.JButton jButton93;
    private javax.swing.JButton jButton94;
    private javax.swing.JButton jButton95;
    private javax.swing.JButton jButton96;
    private javax.swing.JButton jButton97;
    private javax.swing.JButton jButton98;
    private javax.swing.JButton jButton99;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JButton jChest;
    private javax.swing.JButton jCloak;
    private javax.swing.JButton jCloath;
    private javax.swing.JButton jClothShoes;
    private javax.swing.JButton jClub;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JButton jCristallo;
    private javax.swing.JButton jDagger;
    private javax.swing.JButton jEnchantedCloak;
    private javax.swing.JButton jFirewand;
    private javax.swing.JButton jHandAxe;
    private javax.swing.JButton jIronMail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel175;
    private javax.swing.JLabel jLabel176;
    private javax.swing.JLabel jLabel177;
    private javax.swing.JLabel jLabel178;
    private javax.swing.JLabel jLabel179;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel180;
    private javax.swing.JLabel jLabel181;
    private javax.swing.JLabel jLabel182;
    private javax.swing.JLabel jLabel183;
    private javax.swing.JLabel jLabel184;
    private javax.swing.JLabel jLabel185;
    private javax.swing.JLabel jLabel186;
    private javax.swing.JLabel jLabel187;
    private javax.swing.JLabel jLabel188;
    private javax.swing.JLabel jLabel189;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel190;
    private javax.swing.JLabel jLabel191;
    private javax.swing.JLabel jLabel192;
    private javax.swing.JLabel jLabel193;
    private javax.swing.JLabel jLabel194;
    private javax.swing.JLabel jLabel195;
    private javax.swing.JLabel jLabel196;
    private javax.swing.JLabel jLabel197;
    private javax.swing.JLabel jLabel198;
    private javax.swing.JLabel jLabel199;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel200;
    private javax.swing.JLabel jLabel201;
    private javax.swing.JLabel jLabel202;
    private javax.swing.JLabel jLabel203;
    private javax.swing.JLabel jLabel204;
    private javax.swing.JLabel jLabel205;
    private javax.swing.JLabel jLabel206;
    private javax.swing.JLabel jLabel207;
    private javax.swing.JLabel jLabel208;
    private javax.swing.JLabel jLabel209;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel210;
    private javax.swing.JLabel jLabel211;
    private javax.swing.JLabel jLabel212;
    private javax.swing.JLabel jLabel213;
    private javax.swing.JLabel jLabel214;
    private javax.swing.JLabel jLabel215;
    private javax.swing.JLabel jLabel216;
    private javax.swing.JLabel jLabel217;
    private javax.swing.JLabel jLabel218;
    private javax.swing.JLabel jLabel219;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel220;
    private javax.swing.JLabel jLabel221;
    private javax.swing.JLabel jLabel222;
    private javax.swing.JLabel jLabel223;
    private javax.swing.JLabel jLabel224;
    private javax.swing.JLabel jLabel225;
    private javax.swing.JLabel jLabel226;
    private javax.swing.JLabel jLabel227;
    private javax.swing.JLabel jLabel228;
    private javax.swing.JLabel jLabel229;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel230;
    private javax.swing.JLabel jLabel231;
    private javax.swing.JLabel jLabel232;
    private javax.swing.JLabel jLabel233;
    private javax.swing.JLabel jLabel234;
    private javax.swing.JLabel jLabel235;
    private javax.swing.JLabel jLabel236;
    private javax.swing.JLabel jLabel237;
    private javax.swing.JLabel jLabel238;
    private javax.swing.JLabel jLabel239;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel240;
    private javax.swing.JLabel jLabel241;
    private javax.swing.JLabel jLabel242;
    private javax.swing.JLabel jLabel243;
    private javax.swing.JLabel jLabel244;
    private javax.swing.JLabel jLabel245;
    private javax.swing.JLabel jLabel246;
    private javax.swing.JLabel jLabel247;
    private javax.swing.JLabel jLabel248;
    private javax.swing.JLabel jLabel249;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel250;
    private javax.swing.JLabel jLabel251;
    private javax.swing.JLabel jLabel252;
    private javax.swing.JLabel jLabel253;
    private javax.swing.JLabel jLabel254;
    private javax.swing.JLabel jLabel255;
    private javax.swing.JLabel jLabel256;
    private javax.swing.JLabel jLabel257;
    private javax.swing.JLabel jLabel258;
    private javax.swing.JLabel jLabel259;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel260;
    private javax.swing.JLabel jLabel261;
    private javax.swing.JLabel jLabel262;
    private javax.swing.JLabel jLabel263;
    private javax.swing.JLabel jLabel264;
    private javax.swing.JLabel jLabel265;
    private javax.swing.JLabel jLabel266;
    private javax.swing.JLabel jLabel267;
    private javax.swing.JLabel jLabel268;
    private javax.swing.JLabel jLabel269;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel270;
    private javax.swing.JLabel jLabel271;
    private javax.swing.JLabel jLabel272;
    private javax.swing.JLabel jLabel273;
    private javax.swing.JLabel jLabel274;
    private javax.swing.JLabel jLabel275;
    private javax.swing.JLabel jLabel276;
    private javax.swing.JLabel jLabel277;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JLabel jLabelScuolaE;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel66;
    private javax.swing.JPanel jPanel67;
    private javax.swing.JPanel jPanel68;
    private javax.swing.JPanel jPanel69;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel70;
    private javax.swing.JPanel jPanel71;
    private javax.swing.JPanel jPanel72;
    private javax.swing.JPanel jPanel73;
    private javax.swing.JPanel jPanel74;
    private javax.swing.JPanel jPanel75;
    private javax.swing.JPanel jPanel76;
    private javax.swing.JPanel jPanel77;
    private javax.swing.JPanel jPanel78;
    private javax.swing.JPanel jPanel79;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel80;
    private javax.swing.JPanel jPanel81;
    private javax.swing.JPanel jPanel82;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JButton jRamo;
    private javax.swing.JButton jSandali;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jSickle;
    private javax.swing.JButton jSword;
    private javax.swing.JButton jThiefsGarb;
    private javax.swing.JButton jWizardsRobe;
    // End of variables declaration//GEN-END:variables
}