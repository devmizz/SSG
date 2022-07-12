package domain;

import controller.dto.DataFile;
import controller.dto.File;
import controller.dto.IdFile;
import controller.dto.Saying;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileRepository {

    private String dataFilepath = "/Users/chanki/Desktop/programming/likelion/ssg/data.json";
    private String idFilepath = "/Users/chanki/Desktop/programming/likelion/ssg/id.json";

    public File getFile() {

        Scanner idSc;
        Scanner fileSc;

        try {
            idSc = new Scanner(new java.io.File(idFilepath));
            fileSc = new Scanner(new java.io.File(dataFilepath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new File(1, new ArrayList<>());
        }

        if(fileSc.hasNext()) {
            String fileContent = fileSc.nextLine();

            String[] sayings = fileContent.substring(fileContent.indexOf('[') + 1, fileContent.indexOf(']')).split("}, ");

            ArrayList<Saying> result = new ArrayList<>();

            int id = parsePhraseId(idSc.nextLine());

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
        String writer = source[1].substring(source[1].indexOf("=\"") + 2, source[1].length() - 1);
        String phrase = source[2].substring(source[2].indexOf("=\"") + 2, source[2].length() - 1);

        return new Saying(phraseId, writer, phrase);
    }

    int parsePhraseId(String parse) {
        int start = parse.indexOf("id=") + "id=".length();

        return Integer.parseInt(parse.substring(start, parse.length() - 1));
    }

    public void saveFile(File file) {
        PrintWriter idPw = null;
        PrintWriter dataPw = null;

        try {
            idPw = new PrintWriter(idFilepath);
            dataPw = new PrintWriter(dataFilepath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        dataPw.println(new DataFile(file.getSayings()));
        idPw.println(new IdFile(file.getId()));

        dataPw.flush();
        idPw.flush();
        dataPw.close();
        idPw.close();
    }
}
