package com.workintech.library;

import com.workintech.enums.Edition;
import com.workintech.enums.Status;
import com.workintech.library.bookTitle.Journals;
import com.workintech.library.bookTitle.Magazines;
import com.workintech.library.bookTitle.StudyBooks;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Book extends Library{

    private int bookID ;
    private String author ;
    private String name;
    private double price ;
    private Status status ;
    private Edition edition ;

    private String dateOfPurchase ;


    private Set <Book> bookSet = new HashSet<>();

    public Book() {
    }

    public Book(int bookID, String author, String name, double price, Status status, Edition edition, String dateOfPurchase) {
        this.bookID = bookID;
        this.author = author;
        this.name = name;
        this.price = price;
        this.status = status;
        this.edition = edition;
        this.dateOfPurchase = dateOfPurchase;
    }
//    public  void getTitle(int idOfBook){
//        for (Library book : getBookList()){
//            if (((Book)book).getBookID() == idOfBook){
//                if (((Book)book) instanceof StudyBooks){
//                    System.out.println("The book title is Study .");
//                } else if (((Book)book) instanceof Journals) {
//                    System.out.println("The book title is Journal .");
//                } else if (((Book)book) instanceof Magazines) {
//                    System.out.println("The book title is Magazine .");
//                }
//            }
//        }
//    };
    //get title subclass lara gore ytazdir .

    public void getAuthor(int idBook) {
        for (Library book : getBookList()){
            if (((Book)book).getBookID() == idBook){
                System.out.println("Book id : " +((Book)book).getBookID());
                System.out.println("Author name  : "  + ((Book) book).author);
            }
        }
    }
    //Reader ve faculty yaptiktan sonra change ve get owner i duzenle .

    public void changeOwner (int ownerID , int idOfBook , int newOwnerID) {}
    public void getOwner(int currentOwnerID , int idOfBook) {}


    public void display () {
        int i =1 ;
        for (Library books : getBookList()){
            System.out.println("Book " + i + " : " + books);
            i += 1;
        }
    }

    public void updateStatus(int idBook ,Status status){
        for (Library book : getBookList()){
            if (((Book)book).getBookID() == idBook){
                ((Book) book).status = status;
                System.out.println("Updating this book's status : " + ((Book) book).getName() + " to " + status );
            }
        }

    }

    @Override
    public void addBook(Book book) {
        super.getBookList().add(book);
        bookSet.add(book);
    }


    @Override
    public Set<Library> getBookList() {
        return super.getBookList();
    }

    @Override
    public Set<Library> getReaderList() {
        return super.getReaderList();
    }


    public int getBookID() {
        return bookID;
    }



    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Status getStatus() {
        return status;
    }

    public Edition getEdition() {
        return edition;
    }

    public String getDateOfPurchase() {
        return dateOfPurchase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return bookID == book.bookID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookID);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookID=" + bookID +
                ", author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", edition=" + edition +
                ", dateOfPurchase='" + dateOfPurchase + '\'' +

                '}';
    }
}
