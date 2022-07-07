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