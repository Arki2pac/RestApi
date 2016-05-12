/**
 * Created by Grzegorz on 2016-04-01.
 */



var library = angular.module('bookStore', ['ngRoute']);

    library.config(['$routeProvider',
        function($routeProvider) {
            $routeProvider.
                when('/bookandauthorslist', {
                    templateUrl: 'html/booksAndAuthors.html'
                }).
                when('/json', {
                    templateUrl: 'html/json.html'
                }).
                when('/bookslist', {
                    templateUrl: 'html/books.html'
                }).
                when('/search', {
                    templateUrl: 'html/search.html'
                }).
                when('/add', {
                    templateUrl: 'html/addToLibrary.html'
                }).
                when('/login', {
                    templateUrl: 'html/login.html'
                }).
                when('/delete', {
                    templateUrl: 'html/delete.html'
                });
        }]);

    library.controller('SearchController', function($scope, httpRepository){

        $scope.boolTitle = false;
        $scope.boolGenre = false;
        $scope.boolSurname = false;



        $scope.getBoolTitle = function(){
            return $scope.boolTitle;
        };

        $scope.getBoolGenre = function(){
            return $scope.boolGenre;
        };

        $scope.getBoolSurname = function(){
            return $scope.boolSurname;
        };

        $scope.error = function(){
           console.log("Nie ma takiej książki");
        };
        
        $scope.getBooks = function() {
            httpRepository.getBooks()
                .then(function (response) {
                    $scope.bookData = response.data;
                });
        }();


        $scope.getBooksByGenre = function(){
            httpRepository.getBooksByGenre($scope.selectedGenre)
                .then(function(response){
                    $scope.genreData = response.data;
                    if(response.data.length < 1){
                        $scope.error();
                    }
                    else{
                        $scope.boolGenre = true;
                        $scope.getBoolGenre();
                    }
                });
        };

        $scope.getBooksByTitle = function(){
            httpRepository.getBooksByTitle($scope.selectedTitle)
                .then(function(response){
                    $scope.titleData = response.data;
                    if(response.data.length < 1){
                            $scope.error();
                    }
                    else{
                        $scope.boolTitle = true;
                        $scope.getBoolTitle();
                    }
                });
        };

        $scope.getAuthorsAndBooksByAuthorSurname = function(){
            httpRepository.getAuthorsAndBooksByAuthorSurname($scope.selectedAuthor)
                .then(function(response){
                    $scope.authorsData = response.data;
                    if(response.data.length < 1){
                        $scope.error();
                    }
                    else{
                        $scope.boolSurname = true;
                        $scope.getBoolSurname();
                    }
                });
        };

        $scope.getAuthors = function(){
            httpRepository.getAuthors()
                .then(function (response) {
                    $scope.authorData = response.data;
                });

        }();
    });

library.controller('AddController', function($scope, httpRepository){


    $scope.deleteBook = function() {
        var bookId = $scope.selectedBookId;
        httpRepository.deleteBook(bookId)
    };
    
    $scope.addBook = function () {
        var book = {
            title: $scope.selectedBookTitle,
            genre: $scope.selectedBookGenre,
            pagesNo: $scope.selectedBookNumberOfPages
        };
        httpRepository.addBook(book)
    };

    $scope.addBookToAuthor = function(){
        var authorAndBook = {
            bookId: $scope.selectedBookId,
            authorId: $scope.selectedAuthorId
        };
        httpRepository.addBookToAuthor(authorAndBook)
    };

    $scope.addAuthor = function() {
        var author = {
            firstName: $scope.selectedAuthorFirstName,
            surname: $scope.selectedAuthorSurname
        };
        httpRepository.addAuthor(author);
    };
});
