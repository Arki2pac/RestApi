package pl.apilia.library.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.apilia.library.exceptions.BadRequestException;
import pl.apilia.library.exceptions.NotFoundException;
import pl.apilia.library.model.Book;
import pl.apilia.library.service.BookServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Grzegorz on 2016-03-24.
 */
@RestController
public class BookController {

    @Autowired
    private BookServiceImpl bookServiceImpl;


    @RequestMapping(method = RequestMethod.DELETE, value = "/books/{bookId}")
    public ResponseEntity deleteBook(@PathVariable("bookId") Long bookId) throws NotFoundException{
        if (bookServiceImpl.findBookById(bookId) == null) {
            throw new NotFoundException("Książka o podanym id nie istnieje.");
        }
        bookServiceImpl.delete(bookId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/books")
    public List<Book> getBooks() throws NotFoundException {
        if (bookServiceImpl.getBooks() == null){
            throw new NotFoundException("Nie ma książek w bibliotece");
        }
       return bookServiceImpl.getBooks();
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public ResponseEntity addBook(@RequestBody Book book) throws BadRequestException{
        if(book.getGenre() == null){
            throw new BadRequestException("Nie podałeś rodzaju książki(genre)");
        }
        if(book.getTitle() == null){
            throw new BadRequestException("Nie podałeś tytułu(title) książki");
        }
        bookServiceImpl.addBook(book);
        return new ResponseEntity(HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/books/genre")
    public List<Book> findBooksByGenre(@RequestParam(value = "genre") String genre) throws NotFoundException{
        if(bookServiceImpl.findBooksByGenre(genre) == null){
            throw new NotFoundException("Książka o takim gatunku nie istnieje");
        }
        return bookServiceImpl.findBooksByGenre(genre);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/books/{bookId}")
    public Book findBookById(@PathVariable Long bookId) throws NotFoundException{
        if (bookServiceImpl.findBookById(bookId) == null) {
            throw new NotFoundException("Książka o podanym id nie istnieje.");
        }
        return bookServiceImpl.findBookById(bookId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/books/title")
    public List<Book> findBookByTitle(@RequestParam(value = "title") String bookTitle) throws NotFoundException{
        if (bookServiceImpl.findBookByTitle(bookTitle) == null) {
            throw new NotFoundException("Książka o podanym tytule nie istnieje.");
        }
        return bookServiceImpl.findBookByTitle(bookTitle);
    }
}