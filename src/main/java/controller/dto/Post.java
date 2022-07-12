package controller.dto;

public class Post {
    private String saying;
    private String author;

    public Post(String saying, String author) {
        this.saying = saying;
        this.author = author;
    }

    public String getSaying() {
        return saying;
    }

    public String getAuthor() {
        return author;
    }
}
