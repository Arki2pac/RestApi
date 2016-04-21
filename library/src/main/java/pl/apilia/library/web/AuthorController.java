package pl.apilia.library.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.apilia.library.model.Author;
import pl.apilia.library.web.wrapper.AuthorAndBookWrapper;
import pl.apilia.library.service.AuthorServiceImpl;

import java.util.List;

/**
 * Created by Grzegorz on 2016-03-25.
 */
@RestController
public class AuthorController {

    @Autowired
    private AuthorServiceImpl authorServiceImpl;

    @RequestMapping("/authors")
    public List<Author> getAuthors(){
        return authorServiceImpl.getAuthors();
    }


    @RequestMapping(value = "/authors/add", method = RequestMethod.POST)
    public ResponseEntity addAuthor(@RequestBody Author author){
         return authorServiceImpl.addAuthor(author);
    }

    @RequestMapping(value = "/authors/add/book", method = RequestMethod.POST)
    public ResponseEntity addBookToAuthor(@RequestBody AuthorAndBookWrapper authorAndBookWrapper){
        return authorServiceImpl.addBookToAuthor(authorAndBookWrapper);
    }

    @RequestMapping("/authors/find/id/{authorId}")
    public Author findAllBooksByAuthorId(@PathVariable Long authorId){
        return authorServiceImpl.findAllBooksByAuthorId(authorId);
    }


    @RequestMapping("/authors/find/surname/{authorSurname}")
    public List<Author> findAllBooksByAuthorSurname(@PathVariable String authorSurname){
        return authorServiceImpl.findAllBooksByAuthorSurname(authorSurname);
    }
}
