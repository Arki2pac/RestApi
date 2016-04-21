package pl.apilia.library.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private Integer pagesNo;
    private String genre;

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {

        return genre;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Author> authors;

 public void setPagesNo(Integer pagesNo) {
        this.pagesNo = pagesNo;
    }


    public int getPagesNo() {

        return pagesNo;
    }

    public String getTitle() {
        return title;
    }

    public Long getId(Long id) {
        return this.id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
