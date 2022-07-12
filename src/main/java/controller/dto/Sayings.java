package controller.dto;

import java.util.ArrayList;

public class Sayings {

    private int id;
    private ArrayList<Saying> sayings;

    public Sayings(int id, ArrayList<Saying> sayings) {
        this.id = id;
        this.sayings = sayings;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Saying> getSayings() {
        return sayings;
    }
}
