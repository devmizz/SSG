import java.util.ArrayList;

public class FileDTO {

    private int phraseId;
    private ArrayList<Phrase> phrases;

    public FileDTO(int phraseId, ArrayList<Phrase> phrases) {
        this.phraseId = phraseId;
        this.phrases = phrases;
    }

    public int getPhraseId() {
        return phraseId;
    }

    public ArrayList<Phrase> getPhrases() {
        return phrases;
    }
}
