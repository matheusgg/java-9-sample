package br.com.sample;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.sample.model.Book;
import br.com.sample.model.Book.Category;
import br.com.sample.model.BookRepository;

public class CollectorsSample {

    public static void main (final String... args) {
        final BookRepository bookRepository = new BookRepository();

        final List<Book> books = bookRepository.findAll();

        // Filtrar todos os autores com livros sobre AGILE
        //        final Map<String, List<Book>> filtered = books.stream()
        //                .filter(b -> b.getCategories().contains(Category.AGILE))
        //                .collect(Collectors.groupingBy(Book::getAuthor));
        //        System.out.println(filtered);

        // Collectors.filtering - Filtrar todos os autores com livros sobre AGILE, porém retornando os demais também
        //        final Map<String, List<Book>> filtered2 = books.stream()
        //                .collect(Collectors.groupingBy(Book::getAuthor,
        //                        Collectors.filtering(b -> b.getCategories().contains(Category.AGILE), Collectors.toList())));
        //        System.out.println(filtered2);

        // Collectors.flatMapping - Agrupar autores e recuperar as categorias
        final Map<String, Set<Category>> filtered3 = books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor,
                        Collectors.flatMapping(b -> b.getCategories().stream(), Collectors.toSet())));
        System.out.println(filtered3);
    }
}
