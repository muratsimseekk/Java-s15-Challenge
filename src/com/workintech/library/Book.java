package com.workintech.library;

import com.workintech.enums.Edition;
import com.workintech.enums.Status;
import com.workintech.library.bookTitle.Journals;
import com.workintech.library.bookTitle.Magazines;
import com.workintech.library.bookTitle.StudyBooks;

import java.util.*;

public class Book extends Library{

    private int bookID ;
    private String author ;
    private String name;
    private double price ;
    private Status status ;
    private Edition edition ;

    private String dateOfPurchase ;
    private static Set<Book> bookSet = new HashSet<>();
    public  Set<StudyBooks> studyBooksList = new HashSet<>();

    public Set<Journals> journalsList = new HashSet<>();

    public Set <Magazines> magazinesList = new HashSet<>();

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
    public  void getTitle(int idOfBook){
        for (Library book : getBookList()){
            if (((Book)book).getBookID() == idOfBook){
                if (((Book)book) instanceof StudyBooks){
                    System.out.println("The book title is Study .");
                } else if (((Book)book) instanceof Journals) {
                    System.out.println("The book title is Journal .");
                } else if (((Book)book) instanceof Magazines) {
                    System.out.println("The book title is Magazine .");
                }
            }
        }
    };


    public Set<Book> getBookByID (int bookID) {
        Set <Book> result = new HashSet<>();
        for (Book book : bookSet){
            if (book.getBookID() == bookID){
               result.add(book);
            }
        }

        return result;
    }

    public Set <Book> getBookByName (String bookName) {
        Set <Book> result = new HashSet<>();
        for (Book book : bookSet){
            if (book.getName().equalsIgnoreCase(bookName)){
                result.add(book);
            }
        }
        return result;
    }

    public Set <Book> getBookByAuthor (String authName ) {
        Set <Book> result = new HashSet<>();

        for (Book book : bookSet){
            if (book.getAuthor().equalsIgnoreCase(authName)){
                result.add(book);
            }
        }
        return result;
    }

    public Set<Book> updateBook(int bookID , String changeAuthor , String changeName , double changePrice){
        Set<Book> result = new HashSet<>();

        for (Book book : bookSet){
            if (book.getBookID()==bookID){
                book.setAuthor(changeAuthor);
                book.setName(changeName);
                book.setPrice(changePrice);
                System.out.println("Kitabin bilgileri degistirildi .");
                result.add(book);
            }

        }
        return result;
    }

    public boolean noStock ( int bookID){

        for (Book book : bookSet){
            if (book.getBookID() == bookID && !book.getStatus().equals(Status.IN_STOCK)){
                System.out.println("Kitap stokta yok .");
                return false;
            }

        }

        return true;

    }

    public void removeBook (int bookID){
        // Iterator u book cinsinden tanimladim .
        Iterator<Book> iterator = bookSet.iterator();

        while (iterator.hasNext()){

            Book book = iterator.next(); // her bir kitaba iterator ile erisim sagladim.
            if (book.getBookID() == bookID){
                System.out.println(book.getName() + " isimli kitap sistemden kaldirildi. ");
                iterator.remove(); // kitabi sistemden kaldir .
                return;
            }
        }
        System.out.println("Book with ID " + bookID + " not found.");
    }

    public String getAuthor() {
        return author;
    }

    public void getAuthor(int idBook) {
        for (Library book : getBookList()){
            if (((Book)book).getBookID() == idBook){
                System.out.println("Book id : " +((Book)book).getBookID());
                System.out.println("Book name : " +((Book)book).getName());
                System.out.println("Author name  : "  + ((Book) book).author);
                System.out.println("***************");
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

    public Set<Book> getBookSet() {
        return bookSet;
    }

    @Override
    public void addBook(Book book) {
        super.getBookList().add(book);
        bookSet.add(book);

        if (book instanceof StudyBooks){
            studyBooksList.add((StudyBooks) book);
        }
        else if (book instanceof Journals){
            journalsList.add((Journals) book);
        } else if (book instanceof Magazines) {
            magazinesList.add((Magazines) book);
        }


    }

    public Set<Journals> getJournalsList() {
        return journalsList;
    }

    public Set<Magazines> getMagazinesList() {
        return magazinesList;
    }

    public Set<StudyBooks> getStudyBooksList() {
        return studyBooksList;
    }

    @Override
    public Set<Library> getBookList() {
        return super.getBookList();
    }

    @Override
    public Collection getReaderList() {
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

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setEdition(Edition edition) {
        this.edition = edition;
    }

    public void setDateOfPurchase(String dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public static void setBookSet(Set<Book> bookSet) {
        Book.bookSet = bookSet;
    }


    // esitlik bookID ye gore saglanir . Set kullandik . Hashcode a gore bakacak .
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
