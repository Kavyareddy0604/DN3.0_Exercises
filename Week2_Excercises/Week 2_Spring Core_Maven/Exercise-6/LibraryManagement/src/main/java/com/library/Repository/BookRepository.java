package com.library.Repository;


import org.springframework.stereotype.Repository;

import  java.util.*;
@Repository
public class BookRepository {

    public List<String> getBooks()
    {
        return Arrays.asList("Book1","Book2","Book3");
    }
}
