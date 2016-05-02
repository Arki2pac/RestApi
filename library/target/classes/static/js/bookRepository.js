/**
 * Created by Grzegorz on 2016-04-08.
 */
angular.module('bookStore')
    .service('httpRepository', function($http){

        var booksUrl = '/books';
        var authorsUrl = '/authors';

        this.getBooks = function(){
          return $http.get(booksUrl);
        };

        this.getAuthors = function(){
            return $http.get(authorsUrl);
        };

        this.getBooksByGenre = function(genre){
            return $http.get(booksUrl + '/find/genre/' + genre);
        };

        this.getBooksByTitle = function(title){
            return $http.get(booksUrl + '/find/title/' + title);
        };

        this.getAuthorsAndBooksByAuthorSurname = function(authorSurname){
            return $http.get(authorsUrl + '/find/surname/' + authorSurname);
        };

        this.addAuthor = function(author){
            return $http.post(authorsUrl + '/add', author);
        };

        this.addBook = function(book){
            return $http.post(booksUrl + '/add/book', book);
        };

        this.addBookToAuthor = function(authorAndBook){
            return $http.post(authorsUrl + '/add/book', authorAndBook);
        };
        
        this.deleteBook = function(bookTitle){
            return $http.delete(booksUrl + '/' + bookTitle);
        }
    });

