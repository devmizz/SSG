package controller.dto;

import java.util.ArrayList;

public class File {

    private int id;
    private ArrayList<Saying> sayings;

    public File(int id, ArrayList<Saying> sayings) {
        this.id = id;
        this.sayings = sayings;
    }
    public File() {

    }

    public int getId() {
        return id;
    }

    public ArrayList<Saying> getSayings() {
        return sayings;
    }

    @Override
    public String toString() {
        return "{" +
                "phraseId=" + id +
                ", phrases=" + sayings +
                '}';
    }
}
