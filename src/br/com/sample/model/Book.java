package br.com.sample.model;

import java.util.List;

public class Book {

    private String name;

    private String author;

    private List<Category> categories;

    public Book (final String name, final String author, final Category... categories) {
        this.name = name;
        this.author = author;
        this.categories = List.of(categories);
    }

    public String getName () {
        return name;
    }

    public void setName (final String name) {
        this.name = name;
    }

    public String getAuthor () {
        return author;
    }

    public void setAuthor (final String author) {
        this.author = author;
    }

    public List<Category> getCategories () {
        return categories;
    }

    public void setCategories (final List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString () {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("name='").append(name).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append(", categories=").append(categories);
        sb.append('}');
        return sb.toString();
    }

    public enum Category {

        ART, PROGRAMMING, AGILE, ARCHITECTURE
    }
}
