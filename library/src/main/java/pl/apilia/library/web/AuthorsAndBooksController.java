package pl.apilia.library.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.apilia.library.service.AuthorServiceImpl;
import pl.apilia.library.web.wrapper.AuthorAndBookWrapper;

/**
 * Created by infokomes on 17.05.16.
 */
@RestController
public class AuthorsAndBooksController {

    @Autowired
    private AuthorServiceImpl authorServiceImpl;

    @RequestMapping(value = "/authorsandbooks", method = RequestMethod.POST)
    public ResponseEntity addBookToAuthor(@RequestBody AuthorAndBookWrapper authorAndBookWrapper){
        return authorServiceImpl.addBookToAuthor(authorAndBookWrapper);
    }

}
