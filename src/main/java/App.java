import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class App {
    public void run() throws Exception {

//        HashMap<Integer, Phrase> phrases = new HashMap<>();
        ArrayList<Phrase> phrases = new ArrayList<>();
        String cmd;
        String phrase, writer;
        int number = 1;
        int updateId;

        System.out.println("== 명언 SSG ==");

        Scanner sc = new Scanner(System.in);

        outer:
        while(true) {
            System.out.print("명령) ");
            cmd = sc.next().trim();

            switch (cmd) {
                case "종료" :
                    PrintWriter pw = new PrintWriter("/Users/chanki/Desktop/programming/likelion/ssg/out.txt");

                    for(int i = 0; i < phrases.size(); i++) {
                        System.out.println(phrases.get(i).toString());
                        pw.println(phrases.get(i).toString());
                    }

                    break outer;
                case "등록" :
                    System.out.print("명언: ");
                    phrase = sc.next().trim();
                    sc.nextLine();
                    System.out.print("작가: ");
                    writer = sc.next().trim();
                    phrases.add(new Phrase(number, writer, phrase));
                    System.out.println(phrases.size() + "번 명언이 등록되었습니다.");
                    number++;
                    break;
                case "목록" :
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("---------------");
                    for(int i = phrases.size() - 1; i >= 0; i--) {
                        Phrase findPhrase = phrases.get(i);
                        System.out.println(findPhrase.getNumber() + " / " + findPhrase.getWriter() + " / " + findPhrase.getContent());
                    }
                    break;
                case "삭제" :
                    System.out.print("id=");
                    int delNumber = sc.nextInt();
                    for(int i = 0; i < phrases.size(); i++) {
                        if(delNumber == phrases.get(i).getNumber()) {
                            phrases.remove(i);
                        }
                    }
                    break;
                case "수정" :
                    System.out.print("id=");
                    updateId = sc.nextInt() - 1;
                    Phrase updatePrase = phrases.get(updateId);
                    System.out.println(updateId + "번 명언을 수정합니다.");
                    System.out.println("기존 명언 : " + updatePrase.getContent());
                    System.out.print("새 명언 : ");
                    updatePrase.setContent(sc.next().trim());
                    phrases.set(updateId, updatePrase);
                    break;
            }
        }
        sc.close();
    }
}

class Phrase {
    private int number;
    private String writer;
    private String content;

    public Phrase(int number, String writer, String content) {
        this.number = number;
        this.writer = writer;
        this.content = content;
    }

    public int getNumber() {
        return number;
    }

    public String getWriter() {
        return writer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Phrase{" +
                "number=" + number +
                ", writer='" + writer + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}