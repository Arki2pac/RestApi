package pl.apilia.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.apilia.library.db.AuthorRepository;
import pl.apilia.library.db.BookRepository;
import pl.apilia.library.model.Author;
import pl.apilia.library.web.wrapper.AuthorAndBookWrapper;
import pl.apilia.library.model.Book;

import java.util.List;

/**
 * Created by Grzegorz on 2016-04-13.
 */

@Service
public class AuthorServiceImpl {


    @Autowired
    private BookRepository bookRepository;


    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAuthors() {
        return (List<Author>) authorRepository.findAll();
    }

    public ResponseEntity addAuthor(Author author){
        authorRepository.save(author);
        return new ResponseEntity(HttpStatus.OK);
    }

    public ResponseEntity addBookToAuthor(AuthorAndBookWrapper authorAndBookWrapper){
        Book book = bookRepository.findById(authorAndBookWrapper.getBookId());
        Author author = authorRepository.findById(authorAndBookWrapper.getAuthorId());
        addBook(book, author);
        return new ResponseEntity(HttpStatus.OK);
    }

    public Author findAllBooksByAuthorId(Long authorId){
        Author author = authorRepository.findById(authorId);
        return author;
    }

    public List<Author> findAllBooksByAuthorSurname(String authorSurname){
        List<Author> author = authorRepository.findBySurnameContaining(authorSurname);
        return author;
    }

    public void addBook(Book book, Author author){
        List<Book> books = author.getBooks();
        books.add(book);
        author.setBooks(books);
        authorRepository.save(author);
    }
}
