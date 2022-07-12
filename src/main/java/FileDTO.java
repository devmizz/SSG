import java.util.ArrayList;

public class FileDTO {

    private int id;
    private ArrayList<Saying> sayings;

    public FileDTO(int id, ArrayList<Saying> sayings) {
        this.id = id;
        this.sayings = sayings;
    }

<<<<<<< HEAD
    public int getId() {
        return id;
    }

=======
    public FileDTO() {

    }

    public int getId() {
        return id;
    }

>>>>>>> 6163a56 (for pull)
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
