import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public void run() throws Exception {

        ArrayList<Phrase> phrases;
        String cmd;
        int phraseId;

        System.out.println("== 명언 SSG ==");

        Scanner sc = new Scanner(System.in);

        ManageFile manageFile = new ManageFile();

        FileDTO file = manageFile.getFile();

        phrases = file.getPhrases();
        phraseId = file.getPhraseId();

        phraseId++;

        Post post = new Post();

        outer:
        while (true) {
            System.out.print("명령) ");
            cmd = sc.next().trim();

            switch (cmd) {
                case "종료":
                    manageFile.saveFile(phraseId, phrases);
                    break outer;

                case "등록":
                    phrases.add(post.enroll(phraseId));
                    phraseId++;
                    break;

                case "목록":
                    post.show(phrases);
                    break;

                case "삭제":
                    phrases = post.delete(phrases);
                    break;

                case "수정":
                    phrases = post.update(phrases);
                    break;
            }
        }
        sc.close();
    }
}

