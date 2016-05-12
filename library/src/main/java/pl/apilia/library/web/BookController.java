package pl.apilia.library.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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


    @RequestMapping(method = RequestMethod.DELETE, value = "/books/delete/{bookId}")
    public ResponseEntity deleteBook(@PathVariable("bookId") Long bookId){
        bookServiceImpl.delete(bookId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping("/books/list")
    public String bookList(){
        return bookServiceImpl.bookList();
    }

    @RequestMapping("/books")
    public List<Book> getBooks() {
       return bookServiceImpl.getBooks();
    }

    @RequestMapping(value = "/books/add/book", method = RequestMethod.POST)
    public ResponseEntity addBook(@RequestBody Book book){
        bookServiceImpl.addBook(book);
        return new ResponseEntity(HttpStatus.OK);
    }


    @RequestMapping("/books/find/genre/{genre}")
    public List<Book> findBooksByGenre(@PathVariable String genre){
        return bookServiceImpl.findBooksByGenre(genre);
    }

    @RequestMapping("/books/find/id/{bookId}")
    public Book findBookById(@PathVariable Long bookId){
        return bookServiceImpl.findBookById(bookId);
    }

    @RequestMapping("/books/find/title/{bookTitle}")
    public List<Book> findBookByTitle(@PathVariable String bookTitle){
        return bookServiceImpl.findBookByTitle(bookTitle);
    }
}