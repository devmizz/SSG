package controller.dto;

import java.util.ArrayList;

public class Data {

    private ArrayList<Saying> sayings;

    public Data(ArrayList<Saying> sayings) {
        this.sayings = sayings;
    }

    public ArrayList<Saying> getSayings() {
        return sayings;
    }

    @Override
    public String toString() {
        return sayings + "";
    }
}
