package com.workintech.library.bookTitle;

import com.workintech.enums.Edition;
import com.workintech.enums.Status;
import com.workintech.library.Book;
import com.workintech.library.Library;

import java.util.HashSet;
import java.util.Set;

public class Journals extends Book {

    private  static  Set<Journals> journalsList = new HashSet<>();
    public Journals(int bookID, String author, String name, double price, Status status, Edition edition, String dateOfPurchase) {
        super(bookID, author, name, price, status, edition, dateOfPurchase);
    }

//    @Override
//    public void getTitle(int idOfBook) {
//        for (Journals journal : journalsList){
//            if (journal.getBookID() == idOfBook){
//                System.out.println("The book title is Journal .");
//            }
//        }
//    }


    public static void addJournalsList (Journals book){

        journalsList.add(book);

    }
    public Set<Journals> getJournalsList() {
        return journalsList;
    }

    @Override
    public void addBook(Book book) {

        if (book instanceof Journals){
            journalsList.add((Journals)book);
        }
    }


}
