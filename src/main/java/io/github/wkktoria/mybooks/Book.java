package io.github.wkktoria.mybooks;

public class Book {
    private int id;
    private String title;
    private String author;

    public Book(final int id, final String title, final String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public Book(final String author, final String title) {
        this.author = author;
        this.title = title;
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

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
    }
}
