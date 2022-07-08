import java.util.ArrayList;
import java.util.Scanner;

public class Post {

    Scanner sc = new Scanner(System.in);

    Saying add(int id) {
        String phrase;
        String writer;

        System.out.print("명언: ");
        phrase = sc.next().trim();
        sc.nextLine();
        System.out.print("작가: ");
        writer = sc.next().trim();

        System.out.println(id + "번 명언이 등록되었습니다.");

        return new Saying(id, writer, phrase);
    }

    void show(ArrayList<Saying> sayings) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("---------------");
        for (int i = sayings.size() - 1; i >= 0; i--) {
            Saying findSaying = sayings.get(i);
            System.out.println(findSaying.getNumber() + " / " + findSaying.getAuthor() + " / " + findSaying.getContent());
        }
    }

    ArrayList<Saying> delete(ArrayList<Saying> sayings) {
        boolean isDeleted = false;
        System.out.print("id=");
        int delNumber = sc.nextInt();
        for (int i = 0; i < sayings.size(); i++) {
            if (delNumber == sayings.get(i).getNumber()) {
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
            if(updateId == sayings.get(i).getNumber()) {
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
