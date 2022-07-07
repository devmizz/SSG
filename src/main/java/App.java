import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public void run() throws Exception {

        ArrayList<Phrase> phrases = new ArrayList<>();
        String cmd;
        String phrase, writer;
        int phraseId = 0;
        int number = 1;

        System.out.println("== 명언 SSG ==");

        Scanner sc = new Scanner(System.in);
        Scanner fileSc = new Scanner(new File("/Users/chanki/Desktop/programming/likelion/ssg/out.txt"));

        while(fileSc.hasNextLine()) {
            String input = fileSc.nextLine();
            String[] splitInput;
            int start = input.indexOf('{');


            splitInput = input.substring(start + 1, input.length() - 1).split(" ");

            phraseId = Integer.parseInt(splitInput[0].substring(splitInput[0].indexOf('=') + 1, splitInput[0].length() - 1));
            writer = splitInput[1].substring(splitInput[1].indexOf('\'') + 1, splitInput[1].length() - 2);
            phrase = splitInput[2].substring(splitInput[2].indexOf('\'') + 1, splitInput[2].length() - 1);

            phrases.add(new Phrase(phraseId, writer, phrase));
        }

        phraseId++;

        outer:
        while (true) {
            System.out.print("명령) ");
            cmd = sc.next().trim();

            switch (cmd) {
                case "종료":
                    PrintWriter pw = new PrintWriter("/Users/chanki/Desktop/programming/likelion/ssg/out.txt");

                    for (int i = 0; i < phrases.size(); i++) {
                        pw.println(phrases.get(i).toString());
                    }

                    pw.flush();
                    pw.close();

                    break outer;
                case "등록":
                    System.out.print("명언: ");
                    phrase = sc.next().trim();
                    sc.nextLine();
                    System.out.print("작가: ");
                    writer = sc.next().trim();
                    phrases.add(new Phrase(phraseId, writer, phrase));
                    System.out.println(phraseId + "번 명언이 등록되었습니다.");
                    phraseId++;
                    break;
                case "목록":
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("---------------");
                    for (int i = phrases.size() - 1; i >= 0; i--) {
                        Phrase findPhrase = phrases.get(i);
                        System.out.println(findPhrase.getNumber() + " / " + findPhrase.getWriter() + " / " + findPhrase.getContent());
                    }
                    break;
                case "삭제":
                    boolean isDeleted = false;
                    System.out.print("id=");
                    int delNumber = sc.nextInt();
                    for (int i = 0; i < phrases.size(); i++) {
                        if (delNumber == phrases.get(i).getNumber()) {
                            phrases.remove(i);
                            isDeleted = true;
                            break;
                        }
                    }
                    if(! isDeleted)
                        System.out.println(delNumber + "번 명언은 존재하지 않습니다.");
                    break;
                case "수정":
                    Phrase updatePrase = null;
                    int updateId;
                    int index = 0;

                    System.out.print("id=");
                    updateId = sc.nextInt();

                    for(int i = 0; i < phrases.size(); i++) {
                        if(updateId == phrases.get(i).getNumber()) {
                            updatePrase = phrases.get(i);
                            index = i;
                            break;
                        }
                    }
                    if(updatePrase == null) {
                        System.out.println(updateId + "번 명언은 존재하지 않습니다.");
                        break;
                    }
                    System.out.println(updateId + "번 명언을 수정합니다.");
                    System.out.println("기존 명언 : " + updatePrase.getContent());
                    System.out.print("새 명언 : ");
                    updatePrase.setContent(sc.next().trim());
                    phrases.set(index, updatePrase);
                    break;
            }
        }
        sc.close();
    }
}

