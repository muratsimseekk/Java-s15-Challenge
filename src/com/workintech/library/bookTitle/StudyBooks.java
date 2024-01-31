package com.workintech.library.bookTitle;

import com.workintech.enums.Edition;
import com.workintech.enums.Status;
import com.workintech.library.Book;
import com.workintech.library.Library;

import java.util.HashSet;
import java.util.Set;

public class StudyBooks extends Book {

    Set<StudyBooks> studyBooksList = new HashSet<>();




    public StudyBooks(int bookID, String author, String name, double price, Status status, Edition edition, String dateOfPurchase) {
        super(bookID, author, name, price, status, edition, dateOfPurchase);
        studyBooksList.add(this);
    }

//    @Override
//    public void getTitle(int idOfBook) {
//        for (StudyBooks studyBook : studyBooksList){
//            if (studyBook.getBookID() == idOfBook){
//                System.out.println("The book title is Study Book .");
//            }
//        }
//    }

    public Set<StudyBooks> getStudyBooksList() {
        return studyBooksList;
    }


    @Override
    public void addBook(Book book) {
        Library.bookList.add(book);
        if (book instanceof StudyBooks){
            studyBooksList.add((StudyBooks) book) ;
        }

    }
}
