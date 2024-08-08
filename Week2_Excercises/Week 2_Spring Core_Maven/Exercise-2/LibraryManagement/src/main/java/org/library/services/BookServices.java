package org.library.services;

import org.library.repository.BookRepository;

public class BookServices {

    private BookRepository bookRepository;


    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void listBooks()
    {
        bookRepository.getBooks().forEach(System.out::println);
    }


}
