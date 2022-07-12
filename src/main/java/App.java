import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public void run() throws Exception {

        ArrayList<Saying> sayings;
        String cmd;
        int id;

        System.out.println("== 명언 SSG ==");

        Scanner sc = new Scanner(System.in);

        ManageFile manageFile = new ManageFile();

        FileDTO file = manageFile.getFile();

        sayings = file.getSayings();
<<<<<<< HEAD
        id = file.getId();
=======
        phraseId = file.getId();
>>>>>>> 6163a56 (for pull)

        id++;

        Post post = new Post();

        outer:
        while (true) {
            System.out.print("명령) ");
            cmd = sc.next().trim();

            switch (cmd) {
                case "종료":
<<<<<<< HEAD
                    manageFile.saveFile(new FileDTO(id, sayings));
=======
                    manageFile.saveFile(new FileDTO(phraseId, sayings));
>>>>>>> 6163a56 (for pull)
                    break outer;

                case "빌드":
                    manageFile.saveFile(new FileDTO(phraseId, sayings));
                    break;

                case "등록":
<<<<<<< HEAD
                    sayings.add(post.add(id));
                    id++;
=======
                    sayings.add(post.enroll(phraseId));
                    phraseId++;
>>>>>>> 6163a56 (for pull)
                    break;

                case "목록":
                    post.show(sayings);
                    break;

                case "삭제":
                    sayings = post.delete(sayings);
                    break;

                case "수정":
                    sayings = post.update(sayings);
                    break;
            }
        }
        sc.close();
    }
}

