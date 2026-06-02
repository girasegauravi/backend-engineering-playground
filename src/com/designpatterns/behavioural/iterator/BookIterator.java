package com.designpatterns.behavioural.iterator;

import java.util.List;

public class BookIterator {
    List<Book> books;
    int index = 0;

    public BookIterator(List<Book> books) {
        this.books = books;
    }

    public boolean hasNext(){
        return index < books.size();
    }

    public Book next(){
        Book book = books.get(index);
        index++;
        return book;
    }
}
