package com.BookStore.BookStore.Service;

import com.BookStore.BookStore.Entity.MyBookList;
import com.BookStore.BookStore.Repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookListService {
    @Autowired
    private MyBookRepository myBookRepository;
    public void saveMyBooks(MyBookList myBookList){
        myBookRepository.save(myBookList);
    }
    public List<MyBookList> getAllBooks(){
        return myBookRepository.findAll();
    }
    public void deleteById(int id){
        myBookRepository.deleteById(id);
    }
}
