package pl.apilia.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.apilia.library.db.BookRepository;
import pl.apilia.library.model.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Grzegorz on 2016-03-30.
 */
@Service
public class BookServiceImpl {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    public void delete(Long bookId){
        Long id = bookId;
        bookRepository.delete(bookId);
    }

    public String comma(List<Book> books) {
        StringBuilder sb = new StringBuilder();
        for (Book book : books){
            sb.append(book.getTitle() + ",");
        }
        return sb.toString();
    }

    public String bookList(){
        List<Book> book = new ArrayList<>();
        book = getBooks();
        String bookList = comma(book);
        return bookList;
    }

    public String[] getTitle(List<Book> books){
        String[] tablica = new String[books.size()];
        int i = 0;
        for(Book book : books){
            tablica[i] = book.getTitle();
            i++;
        }
        return tablica;
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public List<Book> findBooksByGenre(String genre){
        List<Book> books = new ArrayList<>();
        books = bookRepository.findByGenreContaining(genre);
        return books;
    }

    public Book findBookById(Long bookId){
        Book book = bookRepository.findById(bookId);
        return book;
    }

    public List<Book> findBookByTitle(String bookTitle){
        List<Book> books = bookRepository.findByTitleContaining(bookTitle);
        return books;
    }
}


