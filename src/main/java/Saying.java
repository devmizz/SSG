class Saying {
    private int number;
    private String author;
    private String content;

    public Saying(int number, String author, String content) {
        this.number = number;
        this.author = author;
        this.content = content;
    }

    public int getNumber() {
        return number;
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
        return "Phrase{" +
                "number=" + number +
                ", writer='" + author + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}