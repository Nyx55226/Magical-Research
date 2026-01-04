
package com.mycompany.mavenproject;

import java.util.function.Predicate;

public class ConditionFactory {
    public static Predicate<dataGame> getCondition(String id) {
        switch (id) {
            case "1":
                return d -> d.getMana() >= 10;
            case "2":
                return d -> d.getPietra() >= 10 && d.getAcqua() >= 2;
            case "3":
                return d -> d.getMana() >= 50;
            case "4":
                return d -> d.getManaShard() == 1;
            case "5":
                return d -> d.getRicercatore() == 1;
            case "6":
                return d -> d.getPietra() >= 30;
            case "7":
                return d -> d.getMagazzino() >= 1;
            case "8":
                return d -> d.getLivelloAttualeEvocazione() >= 2
                          || d.getLivelloAttualeIncanto() >= 2
                          || d.getLivelloAttualeIllusione() >= 2;
            case "9":
                return d -> d.getLegno() >= 50;
            case "10":
                return d -> d.getApprendisti()>=1;
            case "11":
                return d -> d.getMonete()>=800;
            case "12":
                return d -> d.getLivelloAttualeEvocazione()>=6 ||
                            d.getLivelloAttualeIllusione()>=6 ||
                            d.getLivelloAttualeIncanto()>=6;
            case "13":
                return d -> d.getStazioneDiLavoro()>0;
            case "14":
                return d-> d.getCassa()>0 || d.getRamo()>0 ||
                            d.getMazza()>0 || d.getPugnale()>0 ||
                            d.getSpada()>0 || d.getAscia()>0 ||
                            d.getStaffaFuoco()>0 || d.getFalce()>0 ||
                            d.getArmaturaMaglia()>0 || d.getTunicaStregone()>0 ||
                            d.getVestitoLadro()>0 || d.getCristallo()>0 ||
                            d.getSandaliLegno()>0 || d.getMantello()>0 ||
                            d.getScarpeStoffa()>0 || d.getMantelloIncantato()>0 ||
                            d.getStoffa()>0;
            default:
                return dg -> false;
        }
    }
}
