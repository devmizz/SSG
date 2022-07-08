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
        id = file.getId();

        id++;

        Post post = new Post();

        outer:
        while (true) {
            System.out.print("명령) ");
            cmd = sc.next().trim();

            switch (cmd) {
                case "종료":
                    manageFile.saveFile(new FileDTO(id, sayings));
                    break outer;

                case "등록":
                    sayings.add(post.add(id));
                    id++;
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

