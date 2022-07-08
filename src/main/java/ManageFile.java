import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ManageFile {

    private String filepath = "/Users/chanki/Desktop/programming/likelion/ssg/out.txt";

    FileDTO getFile() throws FileNotFoundException {

        Scanner fileSc = new Scanner(new File(filepath));

        if(fileSc.hasNext()) {

            String parse = fileSc.nextLine();

            int phraseId = parsePhraseId(parse);

            String[] phrasesRaw = parse.substring(parse.indexOf('[') + 1, parse.indexOf(']')).split(", P");

            ArrayList<Phrase> phrases = new ArrayList<>();

            for(String phrase: phrasesRaw) {
                String[] source = phrase.substring(phrase.indexOf('{') + 1, phrase.indexOf('}')).split(", ");
                phrases.add(parsePhrase(source));
            }

            return new FileDTO(phraseId, phrases);
        } else {
            return null;
        }
    }

    Phrase parsePhrase(String[] source) {
        int phraseId = 0;
        String writer;
        String phrase;

        phraseId = Integer.parseInt(source[0].substring(source[0].indexOf('=') + 1));
        writer = source[1].substring(source[1].indexOf('\'') + 1, source[1].length() - 1);
        phrase = source[2].substring(source[2].indexOf('\'') + 1, source[2].length() - 1);

        return new Phrase(phraseId, writer, phrase);
    }

    int parsePhraseId(String parse) {
        int start, end;
        start = parse.indexOf("phraseId=") + "phraseId=".length();
        end = parse.indexOf(',');

        return Integer.parseInt(parse.substring(start, end));
    }

    void saveFile(FileDTO file) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(filepath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(file.toString());
        pw.println(file);

        pw.flush();
        pw.close();
    }
}
