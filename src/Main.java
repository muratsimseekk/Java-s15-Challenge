import com.workintech.enums.Edition;
import com.workintech.enums.Status;
import com.workintech.library.Book;
import com.workintech.library.Library;
import com.workintech.library.bookTitle.Journals;
import com.workintech.library.bookTitle.Magazines;
import com.workintech.library.bookTitle.StudyBooks;

public class Main {
 public static void main(String[] args) {


  Book library = new Book();

  Book book2 = new StudyBooks(6, "Alice", "Mathematics", 24.99, Status.IN_STOCK, Edition.SECOND_EDITION, "2024-01-31") ;





  library.addBook(new Journals(2, "Scientist", "Science Journal", 19.99, Status.IN_STOCK, Edition.LIBRARY_EDITION, "2024-01-30"));
  library.addBook(new Journals(33,"Murat Simsek" , "PARLA" ,150 ,Status.IN_STOCK ,Edition.E_BOOK,"10.10.2011"));
  library.addBook(new Journals(12,"Ayse Simsek" , "PARLA" ,187 ,Status.IN_STOCK ,Edition.E_BOOK,"10.10.2011"));

  library.addBook(new StudyBooks(3, "Alice", "Mathematics", 24.99, Status.IN_STOCK, Edition.SECOND_EDITION, "2024-01-31"));
  library.addBook(new StudyBooks(5, "John Doe", "Java Programming", 29.99, Status.IN_STOCK, Edition.FIRST_EDITION, "2024-01-29") );
  library.addBook(new Magazines(4, "Tech Geek", "Tech Magazine", 14.99, Status.IN_STOCK, Edition.E_BOOK, "2024-02-01"));

  book2.addBook(new StudyBooks(9, "Scientist", "Science Journal", 19.99, Status.IN_STOCK, Edition.LIBRARY_EDITION, "2024-01-30"));
  book2.addBook(new StudyBooks(17,"Ayse Simsek" , "PARLA" ,187 ,Status.IN_STOCK ,Edition.E_BOOK,"10.10.2011"));
  System.out.println("Library book list  : " + library.getBookList());

  System.out.println("Book list : " + library.getBookList());


  System.out.println("Study book list : " + ((StudyBooks)book2).getStudyBooksList()   );

  System.out.println();
 }
}