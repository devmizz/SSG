import java.util.ArrayList;
import java.util.Scanner;

public class Post {

    Scanner sc = new Scanner(System.in);

<<<<<<< HEAD
    Saying add(int id) {
        String phrase;
=======
    Saying enroll(int phraseId) {
        String saying;
>>>>>>> 6163a56 (for pull)
        String writer;

        System.out.print("명언: ");
        saying = sc.next().trim();
        sc.nextLine();
        System.out.print("작가: ");
        writer = sc.next().trim();

        System.out.println(id + "번 명언이 등록되었습니다.");

<<<<<<< HEAD
        return new Saying(id, writer, phrase);
    }

    void show(ArrayList<Saying> sayings) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("---------------");
        for (int i = sayings.size() - 1; i >= 0; i--) {
            Saying findSaying = sayings.get(i);
            System.out.println(findSaying.getNumber() + " / " + findSaying.getAuthor() + " / " + findSaying.getContent());
=======
        return new Saying(phraseId, writer, saying);
    }

    void show(ArrayList<Saying> sayings) {
        if(sayings != null) {
            System.out.println("번호 / 작가 / 명언");
            System.out.println("---------------");
            for (int i = sayings.size() - 1; i >= 0; i--) {
                Saying findSaying = sayings.get(i);
                System.out.println(findSaying.getId() + " / " + findSaying.getAuthor() + " / " + findSaying.getContent());
            }
        } else {
            System.out.println("현재 명언이 없습니다.");
>>>>>>> 6163a56 (for pull)
        }
    }

    ArrayList<Saying> delete(ArrayList<Saying> sayings) {
        boolean isDeleted = false;
        System.out.print("id=");
        int delNumber = sc.nextInt();
        for (int i = 0; i < sayings.size(); i++) {
<<<<<<< HEAD
            if (delNumber == sayings.get(i).getNumber()) {
=======
            if (delNumber == sayings.get(i).getId()) {
>>>>>>> 6163a56 (for pull)
                sayings.remove(i);
                isDeleted = true;
                break;
            }
        }
        if(! isDeleted)
            System.out.println(delNumber + "번 명언은 존재하지 않습니다.");

        return sayings;
    }

    ArrayList<Saying> update(ArrayList<Saying> sayings) {
        Saying updatePrase = null;
        int updateId;
        int index = 0;

        System.out.print("id=");
        updateId = sc.nextInt();

        for(int i = 0; i < sayings.size(); i++) {
<<<<<<< HEAD
            if(updateId == sayings.get(i).getNumber()) {
=======
            if(updateId == sayings.get(i).getId()) {
>>>>>>> 6163a56 (for pull)
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
