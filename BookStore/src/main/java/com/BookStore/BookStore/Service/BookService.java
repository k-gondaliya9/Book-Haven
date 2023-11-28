package com.BookStore.BookStore.Service;

import com.BookStore.BookStore.Entity.Book;
import com.BookStore.BookStore.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    public void save(Book b){
        bookRepository.save(b);
    }
    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }
    public Book getBookById(int id){
        return bookRepository.getById(id);
    }
    public void deleteById(int id){
        bookRepository.deleteById(id);
    }
}
