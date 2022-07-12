package domain;

import controller.dto.File;
import controller.dto.Saying;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileRepository {

    private String filepath = "/Users/chanki/Desktop/programming/likelion/ssg/data.json";

    public File getFile() throws FileNotFoundException {

        Scanner fileSc = new Scanner(new java.io.File(filepath));

        if(fileSc.hasNext()) {
            String fileContent = fileSc.nextLine();

            String[] sayings = fileContent.substring(fileContent.indexOf('[') + 1, fileContent.indexOf(']')).split("}, ");

            ArrayList<Saying> result = new ArrayList<>();

            int id = parsePhraseId(fileContent);

            for(String saying: sayings) {
                if(saying.contains("}")) {
                    String[] source = saying.substring(saying.indexOf('{') + 1, saying.indexOf('}')).split(", ");
                    result.add(parsePhrase(source));
                } else {
                    String[] source = saying.substring(saying.indexOf('{') + 1).split(", ");
                    result.add(parsePhrase(source));
                }
            }

            return new File(id, result);
        } else {
            return new File(1, new ArrayList<>());
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

    public void saveFile(File file) {
        PrintWriter pw = null;

        try {
            pw = new PrintWriter(filepath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        pw.println(file.toString());
        pw.flush();
        pw.close();
    }
}
