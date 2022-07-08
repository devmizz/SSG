import java.util.ArrayList;

public class FileDTO {

    private int id;
    private ArrayList<Saying> sayings;

    public FileDTO(int id, ArrayList<Saying> sayings) {
        this.id = id;
        this.sayings = sayings;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Saying> getSayings() {
        return sayings;
    }

    @Override
    public String toString() {
        return "File{" +
                "phraseId=" + id +
                ", phrases=" + sayings +
                '}';
    }
}
