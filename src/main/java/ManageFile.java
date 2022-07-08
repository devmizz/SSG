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

            String fileContent = fileSc.nextLine();

            int id = parsePhraseId(fileContent);

            String[] sayings = fileContent.substring(fileContent.indexOf('[') + 1, fileContent.indexOf(']')).split(", P");

            ArrayList<Saying> result = new ArrayList<>();

            for(String saying: sayings) {
                String[] source = saying.substring(saying.indexOf('{') + 1, saying.indexOf('}')).split(", ");
                result.add(parsePhrase(source));
            }

            return new FileDTO(id, result);
        } else {
            return null;
        }
    }

    Saying parsePhrase(String[] source) {
        int phraseId = Integer.parseInt(source[0].substring(source[0].indexOf('=') + 1));
        String writer = source[1].substring(source[1].indexOf('\'') + 1, source[1].length() - 1);
        String phrase = source[2].substring(source[2].indexOf('\'') + 1, source[2].length() - 1);

        return new Saying(phraseId, writer, phrase);
    }

    int parsePhraseId(String parse) {
        int start = parse.indexOf("phraseId=") + "phraseId=".length();
        int end = parse.indexOf(',');

        return Integer.parseInt(parse.substring(start, end));
    }

    void saveFile(FileDTO file) {
        PrintWriter pw = null;

        try {
            pw = new PrintWriter(filepath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        pw.println(file);
        pw.flush();
        pw.close();
    }
}
