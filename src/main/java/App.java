import controller.PostController;
import controller.dto.Post;
import controller.dto.Saying;

import java.util.Scanner;

public class App {

    PostController postController = new PostController();
    Scanner sc = new Scanner(System.in);

    public void run() {
        int id;
        String cmd, saying, author;

        System.out.println("== 명언 SSG ==");

        postController.initialize();

        outer:
        while (true) {
            System.out.print("명령) ");
            cmd = sc.next().trim();

            switch (cmd) {
                case "종료":
                    postController.save();
                    break outer;

                case "빌드":
                    postController.save();
                    break;

                case "등록":
                    System.out.print("명언: ");
                    saying = sc.next().trim();
                    sc.nextLine();
                    System.out.print("작가: ");
                    author = sc.next().trim();

                    id = postController.add(new Post(saying, author));

                    System.out.println(id + "번 명언이 등록되었습니다.");
                    break;

                case "목록":
                    System.out.println(postController.show());
                    break;

                case "삭제":
                    System.out.print("id=");
                    id = sc.nextInt();
                    if(!postController.delete(id))
                        System.out.println(id + "번 명언은 존재하지 않습니다.");
                    break;

                case "수정":
                    System.out.print("id=");
                    id = sc.nextInt();
                    int tempId = id;
                    postController.find(id).ifPresentOrElse(
                            sayingObj -> {
                                System.out.println(sayingObj.getId() + "번 명언을 수정합니다.");
                                System.out.println("기존 명언 : " + sayingObj.getContent());
                                System.out.print("새 명언 : ");
                                sc.nextLine();
                                String updateSaying = sc.nextLine();
                                sayingObj.setContent(updateSaying);
                                postController.update(sayingObj);
                            }
                            , () -> {
                                System.out.println(tempId + "번 명언은 존재하지 않습니다.");
                            }
                    );
                    break;
            }
        }
    }
}
