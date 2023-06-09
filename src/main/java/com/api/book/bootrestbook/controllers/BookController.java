package com.api.book.bootrestbook.controllers;
import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
//    public Book getBooks() {
//        Book obj = new Book();
//        obj.setId(12345);
//        obj.setAuthor("Jennie");
//        obj.setTitle("XYZ");
//        return obj;
//    }
    public List<Book> getBooks(){
        return this.bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id") int id){
        return bookService.getBookbyId(id);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book){
        Book b=this.bookService.addBook(book);
        return b;
    }

    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable("bookId") int bookId){
        this.bookService.deleteBook(bookId);
    }
    @PutMapping("/books/{bookId}")
    public void updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId){
        this.bookService.updateBook(book,bookId);
    }

}
