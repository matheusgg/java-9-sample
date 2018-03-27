package br.com.sample;

import java.util.List;
import java.util.Optional;

import br.com.sample.model.Book;
import br.com.sample.model.BookRepository;

public class OptionalSample {

    public static void main (final String... args) {
        final BookRepository bookRepository = new BookRepository();
        final List<Book> books = bookRepository.findAll();

        final Optional<Book> optionalBook = books.stream()
                .filter(b -> b.getCategories().contains(Book.Category.ART))
                .findAny();

        // Optional.ifPresentOrElse
        optionalBook
                .ifPresentOrElse(System.out::println,
                        () -> System.out.println("There are no books with this category"));

        // Optional.or
        optionalBook
                .or(() -> books.stream()
                        .filter(b -> b.getCategories().contains(Book.Category.PROGRAMMING))
                        .findAny())
                .or(() -> books.stream()
                        .filter(b -> b.getCategories().contains(Book.Category.ARCHITECTURE))
                        .findAny())
                .ifPresentOrElse(System.out::println,
                        () -> System.out.println("There are no books with this category"));
    }
}
