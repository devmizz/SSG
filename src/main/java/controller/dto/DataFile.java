package controller.dto;

import java.util.ArrayList;

public class DataFile {

    private ArrayList<Saying> sayings;

    public DataFile(ArrayList<Saying> sayings) {
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
