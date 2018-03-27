package br.com.sample.model;

import java.util.List;

public class BookRepository {

    public List<Book> findAll () {
        return List.of(new Book(
                        "Desbravando Java",
                        "Rodrigo Turini",
                        Book.Category.PROGRAMMING
                ),
                new Book(
                        "APIs Java",
                        "Rodrigo Turini",
                        Book.Category.PROGRAMMING
                ),
                new Book(
                        "Certificação Java",
                        "Guilherme Silveira",
                        Book.Category.PROGRAMMING, Book.Category.ARCHITECTURE
                ),
                new Book(
                        "TDD",
                        "Mauricio Aniche",
                        Book.Category.PROGRAMMING, Book.Category.AGILE),
                new Book(
                        "SOLID",
                        "Mauricio Aniche",
                        Book.Category.PROGRAMMING
                ),
                new Book(
                        "Guia da Startup",
                        "Joaquim Torres",
                        Book.Category.AGILE
                ));
    }
}
