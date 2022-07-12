class Saying {
<<<<<<< HEAD
    private int number;
    private String author;
    private String content;

    public Saying(int number, String author, String content) {
        this.number = number;
=======
    private int id;
    private String author;
    private String content;

    public Saying(int id, String author, String content) {
        this.id = id;
>>>>>>> 6163a56 (for pull)
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
<<<<<<< HEAD
        return "Phrase{" +
                "number=" + number +
=======
        return "Saying{" +
                "number=" + id +
>>>>>>> 6163a56 (for pull)
                ", writer='" + author + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}