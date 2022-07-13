package util;

public class Converter {
    String url;

    public Converter(String url) {
        this.url = url;
    }

    public String getCmd() {
        return url.split("\\?")[0];
    }

    public int getIdParam() {
        return Integer.parseInt(url.substring(url.indexOf("id=") + "id=".length()));
    }
}
