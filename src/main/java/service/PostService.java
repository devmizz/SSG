package service;

import controller.dto.Saying;

import java.util.ArrayList;
import java.util.Scanner;

public class PostService {

    Scanner sc = new Scanner(System.in);

    public Saying add(int id) {
        String saying;
        String writer;

        System.out.print("명언: ");
        saying = sc.next().trim();
        sc.nextLine();
        System.out.print("작가: ");
        writer = sc.next().trim();

        System.out.println(id + "번 명언이 등록되었습니다.");
        return new Saying(id, writer, saying);
    }

    public void show(ArrayList<Saying> sayings) {
        if(sayings != null) {
            System.out.println("번호 / 작가 / 명언");
            System.out.println("---------------");
            for (int i = sayings.size() - 1; i >= 0; i--) {
                Saying findSaying = sayings.get(i);
                System.out.println(findSaying.getId() + " / " + findSaying.getAuthor() + " / " + findSaying.getContent());
            }
        } else {
            System.out.println("현재 명언이 없습니다.");
        }
    }

    public ArrayList<Saying> delete(ArrayList<Saying> sayings) {
        boolean isDeleted = false;
        System.out.print("id=");
        int delNumber = sc.nextInt();
        for (int i = 0; i < sayings.size(); i++) {
            if (delNumber == sayings.get(i).getId()) {
                sayings.remove(i);
                isDeleted = true;
                break;
            }
        }
        if(! isDeleted)
            System.out.println(delNumber + "번 명언은 존재하지 않습니다.");

        return sayings;
    }

    public ArrayList<Saying> update(ArrayList<Saying> sayings) {
        Saying updatePrase = null;
        int updateId;
        int index = 0;

        System.out.print("id=");
        updateId = sc.nextInt();

        for(int i = 0; i < sayings.size(); i++) {
            if(updateId == sayings.get(i).getId()) {
                updatePrase = sayings.get(i);
                index = i;
                break;
            }
        }

        if(updatePrase == null) {
            System.out.println(updateId + "번 명언은 존재하지 않습니다.");
            return sayings;
        }

        System.out.println(updateId + "번 명언을 수정합니다.");
        System.out.println("기존 명언 : " + updatePrase.getContent());
        System.out.print("새 명언 : ");
        updatePrase.setContent(sc.next().trim());
        sayings.set(index, updatePrase);

        return sayings;
    }


}