package com.api.book.bootrestbook.services;

import com.api.book.bootrestbook.entities.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookService {
    public static List<Book> list= new ArrayList<>();
    static {
        list.add(new Book(123, "xyz", "yt"));
        list.add(new Book(456, "abc", "gh"));
        list.add(new Book(678, "567", "yua"));
    }

    //get all the books in once
    public List<Book> getAllBooks() {
        return list;
    }
    //get single book by ID
    public Book getBookbyId(int id){
        Book book=null;
        book=list.stream().filter(e->e.getId()==id).findFirst().get();
        return book;
    }
    //create entry in json file
    public Book addBook(Book b){
        list.add(b);
        return b;
    }
    //deletion of book
    public void deleteBook(int bid){
        list=list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
    }
    //updation of book
    public void updateBook(Book book,int bookId){
        list=list.stream().map(b->{
            if(b.getId()==bookId)
            {
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
            }
            return b;
        }).collect(Collectors.toList());
    }

}
