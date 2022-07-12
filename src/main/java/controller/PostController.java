package controller;

import controller.dto.File;
import controller.dto.Saying;
import domain.FileRepository;
import service.PostService;

import java.util.ArrayList;
import java.util.Scanner;

public class AppController {
    public void run(){

        ArrayList<Saying> sayings;
        String cmd;
        int id;

        System.out.println("== 명언 SSG ==");

        Scanner sc = new Scanner(System.in);

        FileRepository fileRepository = new FileRepository();

        File file = fileRepository.getFile();

        sayings = file.getSayings();
        id = file.getId();

        PostService post = new PostService();

        outer:
        while (true) {
            System.out.print("명령) ");
            cmd = sc.next().trim();

            switch (cmd) {
                case "종료":
                    fileRepository.saveFile(new File(id, sayings));
                    break outer;

                case "빌드":
                    fileRepository.saveFile(new File(id, sayings));
                    break;

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

