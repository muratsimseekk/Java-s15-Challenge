package com.workintech.library.bookTitle;

import com.workintech.enums.Edition;
import com.workintech.enums.Status;
import com.workintech.library.Book;

import java.util.HashSet;
import java.util.Set;

public class Magazines extends Book {

    private static Set<Book> magazinesList = new HashSet<>();
    public Magazines(int bookID, String author, String name, double price, Status status, Edition edition, String dateOfPurchase) {
        super(bookID, author, name, price, status, edition, dateOfPurchase);
    }

//    @Override
//    public void getTitle(int idOfBook) {
//        for (Magazines magazine : magazinesList){
//            if (magazine.getBookID() == idOfBook){
//                System.out.println("The book title is Magazine .");
//            }
//        }
//    }


    public  Set<Book> getMagazinesList() {
        return magazinesList;
    }

    public static void addMagazines(Magazines book){
        magazinesList.add(book);
    }

    @Override
    public void addBook(Book book) {
        if (book instanceof Magazines){
            magazinesList.add((Magazines)book);
        }
    }


}
