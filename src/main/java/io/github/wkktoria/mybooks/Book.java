package io.github.wkktoria.mybooks;

public class Book {
    private int id;
    private String title;
    private String author;
    private Status status;

    public Book(final int id, final String title, final String author, final Status status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.status = status;
    }

    public Book(final String author, final String title, final Status status) {
        this.author = author;
        this.title = title;
        this.status = status;
    }

    public static Status getStatusFromString(final String status) {
        switch (status) {
            case "plan to read":
                return Book.Status.PLAN_TO_READ;
            case "currently reading":
                return Book.Status.CURRENTLY_READING;
            case "completed":
                return Book.Status.COMPLETED;
            default:
                return null;
        }
    }

    public static String getStringFromStatus(final Status status) {
        switch (status) {
            case PLAN_TO_READ:
                return "plan to read";
            case CURRENTLY_READING:
                return "currently reading";
            case COMPLETED:
                return "completed";
            default:
                return null;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(final String author) {
        this.author = author;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(final Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", status=" + status +
                '}';
    }

    public enum Status {
        PLAN_TO_READ,
        CURRENTLY_READING,
        COMPLETED
    }
}
