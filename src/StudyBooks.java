import com.workintech.enums.Edition;
import com.workintech.enums.Status;

import java.util.HashSet;
import java.util.Set;

public class StudyBooks extends Book {

    private static Set<StudyBooks> studyBooksList = new HashSet<>();
    public StudyBooks(int bookID, String author, String name, double price, Status status, Edition edition, String dateOfPurchase) {
        super(bookID, author, name, price, status, edition, dateOfPurchase);
    }

    public static Set<StudyBooks> getStudyBooksList() {
        return studyBooksList;
    }

    @Override
    public void getTitle() {
        System.out.println("The book title is Study . ");
    }


    @Override
    public void addBook(Book book) {
        Book.getBookList().add(book);
        if (book instanceof StudyBooks){
            studyBooksList.add((StudyBooks) book) ;
        }
    }
}
