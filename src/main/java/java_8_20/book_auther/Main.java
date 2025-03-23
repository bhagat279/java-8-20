package java_8_20.book_auther;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Author {
    String name;

    public Author(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Book {
    String title;
    Author author;

    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
    }

    public Author getAuthor() {
        return author;
    }
}

public class Main {

    public static void main(String[] args) {

        Author author1 = new Author("J.K. Rowling");
        Author author2 = new Author("George R.R. Martin");
        Author author3 = new Author("J.R.R. Tolkien");


        List<Book> books = Arrays.asList(
                new Book("Harry Potter and the Philosopher's Stone", author1),
                new Book("Harry Potter and the Chamber of Secrets", author1),
                new Book("A Game of Thrones", author2),
                new Book("A Clash of Kings", author2),
                new Book("The Hobbit", author3),
                new Book("The Fellowship of the Ring", author3),
                new Book("The Two Towers", author3)
        );


      /* Map<Author,List<Book>> bookByAuthor = books.stream().collect(Collectors.groupingBy(
                author->author.getAuthor()

        ));

      Map.Entry<Author,List<Book>> maxBookByAuthor= bookByAuthor.entrySet().stream()
               .max((e1,e2)->Integer.compare(e1.getValue().size(),e2.getValue().size())).get();

        System.out.println(maxBookByAuthor.getKey().name+":"+maxBookByAuthor.getValue().size());*/

      Map<Author,Long> bookByAuthor =  books.stream().collect(Collectors.groupingBy(
                author->author.getAuthor(),
                Collectors.counting()
        ));

        Map.Entry<Author, Long> authorLongEntry = bookByAuthor.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get();
        System.out.println(authorLongEntry.getKey().name+":"+authorLongEntry.getValue());
    }
}

// You are given Book and Author classes. Write a program to find the author who has written the most books, and print the author's name and the count of books they
//  have written.