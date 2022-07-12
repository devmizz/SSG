package controller.dto;

public class Id {

    private int id;

    public Id(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "{" +
                "id:" + id +
                '}';
    }
}
