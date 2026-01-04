package com.mycompany.mavenproject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.function.Predicate;

public class Objective implements Serializable {
    private static final long serialVersionUID = 657L;

    private String id;
    private String description;
    private boolean completed;
    private ArrayList<String> functionalities;
    private String popupMessage;

    // transient perché non serializziamo le lambda
    transient private Predicate<dataGame> condition;

    public Objective(String id, String description,
                     ArrayList<String> functionalities,
                     Predicate<dataGame> condition,
                     String popupMessage) {
        this.id = id;
        this.description = description;
        this.functionalities = functionalities;
        this.condition = condition;
        this.popupMessage = popupMessage;
        this.completed = false;
    }

    public boolean checkAndUpdate(dataGame dataGame) {
        if (!completed && condition != null && condition.test(dataGame)) {
            completed = true;
            return true;
        }
        return false;
    }

    // Dopo la deserializzazione, ripristina la lambda
    private void readObject(java.io.ObjectInputStream in)
            throws java.io.IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.condition = ConditionFactory.getCondition(this.id);
    }

    // --- Getter e Setter ---
    public String getId() { return id; }
    public String getDescription() { return description; }
    public ArrayList<String> getFunctionalities() { return functionalities; }
    public boolean isCompleted() { return completed; }
    public String getPopupMessage() { return popupMessage; }
    public void setCompleted(boolean completed) { this.completed = completed; }
}
