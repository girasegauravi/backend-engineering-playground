package com.designpatterns.behavioural.iterator;

public class Main {
    public static void main(String[] args) {

        Library library = new Library();

        library.addBook(new Book("Clean Code"));
        library.addBook(new Book("Design Patterns"));
        library.addBook(new Book("Effective Java"));

        BookIterator iterator = library.iterator();

        while (iterator.hasNext()) {

            Book book = iterator.next();

            System.out.println(book.getName());
        }
    }
}
