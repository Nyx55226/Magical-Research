package com.mycompany.mavenproject;

import java.io.Serializable;
import java.util.ArrayList;

public class ObjectivesManager implements Serializable {
    private static final long serialVersionUID = 657L;

    // Non serializziamo la lista vera e propria, solo lo stato (currentIndex)
    private transient ArrayList<Objective> objectives;
    private int currentIndex;

    /** Costruttore no‐arg: carica tutti gli obiettivi dal factory e setta index=0 */
    public ObjectivesManager() {
        this(ObjectiveFactory.createAllObjectives());
    }

    /** Costruttore “interno” per iniettare liste custom (usato dal no‐arg) */
    public ObjectivesManager(ArrayList<Objective> allObjectives) {
        this.objectives = allObjectives;
        this.currentIndex = 0;
    }

    /** Permette di reiniettare la lista (utile dopo deserializzazione) */
    public void setObjectives(ArrayList<Objective> objectives) {
        this.objectives = objectives;
    }

    public void addObjective(Objective obj) {
        objectives.add(obj);
    }

    public Objective updateAndConsume(dataGame dataGame) {
        if (currentIndex < objectives.size()) {
            Objective current = objectives.get(currentIndex);
            if (current.checkAndUpdate(dataGame)) {
                currentIndex++;
                return current;
            }
        }
        return null;
    }

    public Objective getCurrentObjective() {
        if (currentIndex < objectives.size()) {
            return objectives.get(currentIndex);
        }
        return null;
    }

    public boolean isFunctionalityUnlocked(String functionalityId) {
        for (int i = 0; i < currentIndex && i < objectives.size(); i++) {
            if (objectives.get(i).getFunctionalities().contains(functionalityId)) {
                return true;
            }
        }
        return false;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int index) {
        this.currentIndex = index;
    }
}
