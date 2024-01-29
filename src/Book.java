import com.workintech.enums.Edition;
import com.workintech.enums.Status;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public abstract class Book {

    private int bookID ;
    private String author ;
    private String name;
    private double price ;
    private Status status ;
    private Edition edition ;



    private String dateOfPurchase ;

    public Book(int bookID, String author, String name, double price, Status status, Edition edition, String dateOfPurchase) {
        this.bookID = bookID;
        this.author = author;
        this.name = name;
        this.price = price;
        this.status = status;
        this.edition = edition;
        this.dateOfPurchase = dateOfPurchase;
    }


    public abstract void getTitle();

    public void updateStatus () {
        System.out.println("Updating this book's status : " + this.name + " to " + this.status );
    }

    public void getOwner() {}
    public void changeOwner () {

    }
    public String getAuthor() {
        return author;
    }
    public void display() {

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
