package pl.apilia.library.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Grzegorz on 2016-03-25.
 */

@Entity

public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String surname;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Book> books;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getFirstName() {

        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId(Long authorId) {

        return id;
    }


}
