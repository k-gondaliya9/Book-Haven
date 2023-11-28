package com.BookStore.BookStore.Controller;

import com.BookStore.BookStore.Entity.Book;
import com.BookStore.BookStore.Entity.MyBookList;
import com.BookStore.BookStore.Service.BookService;
import com.BookStore.BookStore.Service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    BookService bookService;
    @Autowired
    MyBookListService myBookListService;
    @GetMapping("/home")
    public String home(){
        return "home";
    }
    @GetMapping("/book_register")
    public String bookRegister(){
        return "bookRegister";
    }
    @GetMapping("/available_books")
    public ModelAndView getAllBook(){
        List<Book> list=bookService.getAllBook();
//        ModelAndView modelAndView=new ModelAndView();
//        modelAndView.setViewName("bookList");
//        modelAndView.addObject("book",list);
        return new ModelAndView("bookList","book",list);
    }
    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b){
        bookService.save(b);
        return "redirect:/available_books";
    }

    @GetMapping("my_books")
    public String getMyBooks(Model model){
        List<MyBookList>list=myBookListService.getAllBooks();
        model.addAttribute("book",list);
        return "myBooks";
    }
    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id){
        Book book=bookService.getBookById(id);
        MyBookList myBookList=new MyBookList(book.getId(),book.getName(),book.getAuthor(),book.getPrice());
        myBookListService.saveMyBooks(myBookList);
        return "redirect:/my_books";
    }
    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id,Model model){
        Book b=bookService.getBookById(id);
        model.addAttribute("book",b);
        return "bookEdit";
    }
    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id")int id){
        bookService.deleteById(id);
        return "redirect:/available_books";
    }
}
