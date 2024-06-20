package io.github.wkktoria.mybooks;

public class Status {
    private int id;
    private String description;

    public Status(final int id, final String description) {
        this.id = id;
        this.description = description;
    }

    public Status(final String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
