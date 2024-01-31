package com.workintech.library;


import java.util.HashSet;
import java.util.Set;

public  class Library {
    //Book classindaki book lar.


    public static Set<Library> bookList = new HashSet<>();
    Set<Library> readerList = new HashSet<>();

    public Library() {
    }

    public Set<Library> getBookList () {
        return bookList;
    }

    public Set<Library> getReaderList() {
        return readerList;
    }

    public void addBook (Book book) {
        bookList.add(book);
    }



}
