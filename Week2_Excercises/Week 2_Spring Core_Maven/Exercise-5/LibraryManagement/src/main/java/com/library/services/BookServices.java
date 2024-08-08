package com.library.services;

import com.library.Repository.BookRepository;

public class BookServices {

    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public void  listbooks()
    {
        bookRepository.getBooks().forEach(System.out::println);
    }
}
