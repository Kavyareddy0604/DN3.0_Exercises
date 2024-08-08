package com.library.Services;

import com.library.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BookServices {

    private BookRepository bookRepository;

    @Autowired
   public BookServices(BookRepository bookRepository)
   {
       this.bookRepository=bookRepository;
   }

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void  listbooks()
    {
        bookRepository.getBooks().forEach(System.out::println);
    }
}
