package pl.apilia.library.web.wrapper;

/**
 * Created by Grzegorz on 2016-04-13.
 */
public class AuthorAndBookWrapper {

    private Long bookId;
    private Long authorId;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
