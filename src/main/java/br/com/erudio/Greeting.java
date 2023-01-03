package br.com.erudio;

public class Greeting {

    private final long id;
    private final String comment;

    public Greeting(long id, String comment) {
        this.id = id;
        this.comment = comment;
    }

    public long getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }
}
