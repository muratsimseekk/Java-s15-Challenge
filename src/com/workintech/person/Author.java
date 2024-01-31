package com.workintech.person;

import com.workintech.library.Book;
import com.workintech.library.Library;

import java.util.HashSet;
import java.util.Set;

public class Author extends Person{

    Book book = new Book();
    Set<Book> authorSet = new HashSet<>();


    @Override
    public void whoYouAre() {
        System.out.println("Person is a Author.");
    }

    public void showBook(String name) {

        //Library book listine erisip icerisindeki author u authorSet icerisine atalim.
        Set<Library> books = Library.bookList;

        for (Library author : books){
            if (((Book)author).getAuthor().equalsIgnoreCase(name) ){
                ((Book)author).getAuthor(((Book) author).getBookID());
            }
        }


    }

}
