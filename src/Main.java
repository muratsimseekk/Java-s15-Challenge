import com.workintech.enums.Edition;
import com.workintech.enums.Status;
import com.workintech.enums.Type;
import com.workintech.library.Book;
import com.workintech.library.Library;
import com.workintech.library.bookTitle.Journals;
import com.workintech.library.bookTitle.Magazines;
import com.workintech.library.bookTitle.StudyBooks;
import com.workintech.person.Author;
import com.workintech.person.member_record.Member_Record;
import com.workintech.person.member_record.Student;

import java.util.Set;

public class Main {
 public static void main(String[] args) {


  Book library = new Book();

  Book book2 = new StudyBooks(6, "Alice", "Mathematics", 24.99, Status.IN_STOCK, Edition.SECOND_EDITION, "2024-01-31") ;

  Author author = new Author();



  library.addBook(new Journals(2, "Scientist", "Science Journal", 19.99, Status.IN_STOCK, Edition.LIBRARY_EDITION, "2024-01-30"));
  library.addBook(new Journals(33,"Murat Simsek" , "PARLA" ,150 ,Status.IN_STOCK ,Edition.E_BOOK,"10.10.2011"));
  library.addBook(new Journals(12,"Ayse Simsek" , "PARLA" ,187 ,Status.IN_STOCK ,Edition.E_BOOK,"10.10.2011"));

  library.addBook(new StudyBooks(3, "Alice", "Mathematics", 24.99, Status.IN_STOCK, Edition.SECOND_EDITION, "2024-01-31"));
  library.addBook(new StudyBooks(5, "John Doe", "Java Programming", 29.99, Status.IN_STOCK, Edition.FIRST_EDITION, "2024-01-29") );
  library.addBook(new Magazines(4, "Tech Geek", "Tech Magazine", 14.99, Status.IN_STOCK, Edition.E_BOOK, "2024-02-01"));

  book2.addBook(new StudyBooks(9, "Scientist", "Science Journal", 19.99, Status.IN_STOCK, Edition.LIBRARY_EDITION, "2024-01-30"));
  book2.addBook(new StudyBooks(17,"Ayse Simsek" , "Scince Study" ,187 ,Status.IN_STOCK ,Edition.E_BOOK,"10.10.2011"));


//  System.out.println("Book list : " + library.getBookList()); // tum kitaplarin listesi .


//  System.out.println("Study book list : " + ((StudyBooks)book2).getStudyBooksList()   ); // calisir

  System.out.println("******************");


  author.newBook(new StudyBooks(18,"Ayse Simsek" , "Scince Study" ,187 ,Status.IN_STOCK ,Edition.E_BOOK,"10.10.2011"));

  author.newBook(new StudyBooks(18,"Ayse Simsek" , "Scince Study" ,187 ,Status.IN_STOCK ,Edition.E_BOOK,"10.10.2011"));
  author.newBook(new StudyBooks(33,"Ayse Simsek" , "Scince Study" ,187 ,Status.IN_STOCK ,Edition.E_BOOK,"10.10.2011"));
  author.newBook(new StudyBooks(14,"Ayse Simsek" , "Scince Study" ,187 ,Status.IN_STOCK ,Edition.E_BOOK,"10.10.2011"));
  author.newBook(new StudyBooks(34,"Ayse Simsek" , "Scince Study" ,187 ,Status.IN_STOCK ,Edition.E_BOOK,"10.10.2011"));


  Member_Record memberRecord = new Member_Record();

  book2.addBook(new StudyBooks(21,"Ayse Simsek" , "Scince Study" ,187 ,Status.IN_STOCK ,Edition.E_BOOK,"10.10.2011"));

//  System.out.println("Library book list  : " + library.getBookList()); // calisir



  System.out.println(library.getBookList().size());
  author.showBook("Ayse Simsek");

//  System.out.println("Study book list : " + (((StudyBooks) book2).getStudyBooksList())); // Study kategorisindeki kitaplarin listesi

  Student student = new Student();
  student.addMember(new Student(1,"Murat", Type.STUDENT,"Bugun","Cukurova","111222333444",0));
  student.addMember(new Student(3,"Ali", Type.STUDENT,"Bugun","Cukurova","111222333444",0));
  student.addMember(new Student(4,"Veli", Type.STUDENT,"Bugun","Cukurova","111222333444",0));

 student.purchaseBook(1,21);
 student.purchaseBook(1,4);
 student.purchaseBook(3,14);


//  System.out.println("Student member list " + student.getStudentList());; // Student uyeler

//  System.out.println("Tum memberlarin listesi : " + memberRecord.getMemberList()); // Tum uyeler
  student.getStudentMap();
 }
}