import java.util.ArrayList;
import java.util.Scanner;

public class Post {

    Scanner sc = new Scanner(System.in);

    Phrase enroll(int phraseId) {
        String phrase;
        String writer;

        System.out.print("명언: ");
        phrase = sc.next().trim();
        sc.nextLine();
        System.out.print("작가: ");
        writer = sc.next().trim();

        System.out.println(phraseId + "번 명언이 등록되었습니다.");

        return new Phrase(phraseId, writer, phrase);
    }

    void show(ArrayList<Phrase> phrases) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("---------------");
        for (int i = phrases.size() - 1; i >= 0; i--) {
            Phrase findPhrase = phrases.get(i);
            System.out.println(findPhrase.getNumber() + " / " + findPhrase.getWriter() + " / " + findPhrase.getContent());
        }
    }

    ArrayList<Phrase> delete(ArrayList<Phrase> phrases) {
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

        return phrases;
    }

    ArrayList<Phrase> update(ArrayList<Phrase> phrases) {
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
            return phrases;
        }

        System.out.println(updateId + "번 명언을 수정합니다.");
        System.out.println("기존 명언 : " + updatePrase.getContent());
        System.out.print("새 명언 : ");
        updatePrase.setContent(sc.next().trim());
        phrases.set(index, updatePrase);

        return phrases;
    }


}
