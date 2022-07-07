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

            int phraseId = Integer.parseInt(fileSc.nextLine());
            ArrayList<Phrase> phrases = new ArrayList<>();

            while (fileSc.hasNextLine()) {

                String input = fileSc.nextLine();
                String[] splitInput;
                int start = input.indexOf('{');

                splitInput = input.substring(start + 1, input.length() - 1).split(" ");

                phrases.add(parsePhrase(splitInput));
            }

            return new FileDTO(phraseId, phrases);
        } else {
            return null;
        }
    }

    Phrase parsePhrase(String[] splitInput) {
        int phraseId = 0;
        String writer;
        String phrase;

        phraseId = Integer.parseInt(splitInput[0].substring(splitInput[0].indexOf('=') + 1, splitInput[0].length() - 1));
        writer = splitInput[1].substring(splitInput[1].indexOf('\'') + 1, splitInput[1].length() - 2);
        phrase = splitInput[2].substring(splitInput[2].indexOf('\'') + 1, splitInput[2].length() - 1);

        return new Phrase(phraseId, writer, phrase);
    }

    void saveFile(int phraseId, ArrayList<Phrase> phrases) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter("/Users/chanki/Desktop/programming/likelion/ssg/out.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        pw.println(phraseId - 1);
        for (Phrase phrase : phrases) {
            pw.println(phrase.toString());
        }

        pw.flush();
        pw.close();
    }
}
