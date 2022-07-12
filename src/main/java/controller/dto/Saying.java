package controller.dto;

public class Saying {
    private int id;
    private String author;
    private String content;

    public Saying() {
    }

    public Saying(int id, String author, String content) {
        this.id = id;
        this.author = author;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"author\":\"" + author + '\"' +
                ", \"content\":\"" + content + '\"' +
                '}';
    }
}