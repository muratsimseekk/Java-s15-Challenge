import com.workintech.enums.Edition;
import com.workintech.enums.Status;
import com.workintech.enums.Type;
import com.workintech.library.Book;
import com.workintech.library.Library;
import com.workintech.library.bookTitle.Journals;
import com.workintech.library.bookTitle.Magazines;
import com.workintech.library.bookTitle.StudyBooks;
import com.workintech.person.Author;
import com.workintech.person.member_record.Faculty;
import com.workintech.person.member_record.Member_Record;
import com.workintech.person.member_record.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class Main {
 public static void main(String[] args) {


//  Book book = new Book();
//
//  Book book2 = new StudyBooks(6, "Alice", "Mathematics", 24.99, Status.IN_STOCK, Edition.SECOND_EDITION, "2024-01-31") ;
//
//  Author author = new Author();
//
//
//
//  book.addBook(new Journals(2, "Scientist", "Science Journal", 19.99, Status.IN_STOCK, Edition.LIBRARY_EDITION, "2024-01-30"));
//  book.addBook(new Journals(33,"Murat Simsek" , "PARLA" ,150 ,Status.IN_STOCK ,Edition.E_BOOK,"10.10.2011"));
//  book.addBook(new Journals(12,"Ayse Simsek" , "PARLA" ,187 ,Status.IN_STOCK ,Edition.E_BOOK,"10.10.2011"));
//
//  book.addBook(new StudyBooks(3, "Alice", "Mathematics", 24.99, Status.IN_STOCK, Edition.SECOND_EDITION, "2024-01-31"));
//  book.addBook(new StudyBooks(5, "John Doe", "Java Programming", 29.99, Status.IN_STOCK, Edition.FIRST_EDITION, "2024-01-29") );
//  book.addBook(new Magazines(4, "Tech Geek", "Tech Magazine", 14.99, Status.IN_STOCK, Edition.E_BOOK, "2024-02-01"));
//
//  book2.addBook(new StudyBooks(9, "Scientist", "Science Journal", 19.99, Status.IN_STOCK, Edition.LIBRARY_EDITION, "2024-01-30"));
//  book2.addBook(new StudyBooks(17,"Ayse Simsek" , "Scince Study" ,187 ,Status.IN_STOCK ,Edition.E_BOOK,"10.10.2011"));


//  System.out.println("Book list : " + book.getBookList()); // tum kitaplarin listesi .


//  System.out.println("Study book list : " + ((StudyBooks)book2).getStudyBooksList()   ); // calisir

  System.out.println("******************");


//  author.newBook(new StudyBooks(18,"Ayse Simsek" , "Scince Study" ,187 ,Status.IN_STOCK ,Edition.E_BOOK,"10.10.2011"));
//
//  author.newBook(new StudyBooks(18,"Ayse Simsek" , "Scince Study" ,187 ,Status.IN_STOCK ,Edition.E_BOOK,"10.10.2011"));
//  author.newBook(new StudyBooks(33,"Ayse Simsek" , "Scince Study" ,187 ,Status.IN_STOCK ,Edition.E_BOOK,"10.10.2011"));
//  author.newBook(new StudyBooks(14,"Ayse Simsek" , "Scince Study" ,187 ,Status.IN_STOCK ,Edition.E_BOOK,"10.10.2011"));
//  author.newBook(new StudyBooks(34,"Ayse Simsek" , "Scince Study" ,187 ,Status.IN_STOCK ,Edition.E_BOOK,"10.10.2011"));
//
//
//  Member_Record memberRecord = new Member_Record();
//
//  book2.addBook(new StudyBooks(21,"Ayse Simsek" , "Scince Study" ,187 ,Status.IN_STOCK ,Edition.E_BOOK,"10.10.2011"));
//
////  System.out.println("Library book list  : " + book.getBookList()); // calisir
//
//
//
//  System.out.println(book.getBookList().size());
//  author.showBook("Ayse Simsek");
//
////  System.out.println("Study book list : " + (((StudyBooks) book2).getStudyBooksList())); // Study kategorisindeki kitaplarin listesi
//






//  System.out.println("Student member list " + student.getStudentList());; // Student uyeler

//  System.out.println("Tum memberlarin listesi : " + memberRecord.getMemberList()); // Tum uyeler






  Library book = new Book();

  book.addBook(new Journals(2, "John Doe", "Science Journal", 19.99, Status.IN_STOCK, Edition.LIBRARY_EDITION, "2024-01-30"));
  book.addBook(new Journals(33,"Murat Simsek" , "100 yil" ,150 ,Status.NO_STOCK ,Edition.E_BOOK,"10.10.2011"));
  book.addBook(new Journals(12,"Ali Veli" , "Dogu" ,187 ,Status.IN_STOCK ,Edition.E_BOOK,"11.12.2017"));


  book.addBook(new StudyBooks(11, "Alice", "Mathematics", 24.99, Status.IN_STOCK, Edition.SECOND_EDITION, "2024-01-31"));
  book.addBook(new StudyBooks(12, "Alice", "Chemical", 29.99, Status.IN_STOCK, Edition.SECOND_EDITION, "2024-01-31"));
  book.addBook(new StudyBooks(13, "Alice", "Language", 21.99, Status.IN_STOCK, Edition.SECOND_EDITION, "2024-01-31"));
  book.addBook(new StudyBooks(14, "Alice", "Sport", 34.99, Status.IN_STOCK, Edition.SECOND_EDITION, "2024-01-31"));

  book.addBook(new StudyBooks(33,"Kemal Mustafa" , "Scince Study" ,187 ,Status.IN_STOCK ,Edition.E_BOOK,"07.02.2019"));

  book.addBook(new Magazines(4, "Tech Geek", "Tech Magazine", 14.99, Status.IN_STOCK, Edition.E_BOOK, "2024-02-01"));
  book.addBook(new Magazines(9, "Show", "Tech Magazine", 19.99, Status.IN_STOCK, Edition.E_BOOK, "2024-02-01"));

  System.out.println("Kitaplarin tam listesi " + (book).getBookList());

  System.out.println("***************************");

  System.out.println("Id ye gore getirilen kitap : " + ((Book)book).getBookByID(33));
  System.out.println("Kitap ismine gore getirilen kitap : " + ((Book)book).getBookByName("Mathematics"));
  System.out.println("Yazar ismine gore getirilen kitap : " + ((Book)book).getBookByAuthor("Tech Geek"));

  System.out.println("******************************");

  System.out.println("Kitabin id sine gore bilgilerinin guncellenmesi : " + ((Book)book).updateBook(12,"Allen","Bati",50));
  ((Book) book).removeBook(9);
  System.out.println("Guncel kitaplarin listesi : " + (((Book)book).getBookSet()));

  System.out.println("********************************");

  System.out.println("Journal listesi : " + ((Book)book).getJournalsList());
  System.out.println("Study book  listesi : " + ((Book)book).getStudyBooksList());
  System.out.println("Magazines listesi : " + ((Book)book).getMagazinesList());

  System.out.println("********************************");

  Author author = new Author();

  author.showBook("Alice");
  Student student = new Student();
  Faculty faculty = new Faculty();
  Collection<Library> readerList = Library.readerList;
  List<Student> studentList = student.getStudentList();
  student.addMember(new Student(1,"Murat", Type.STUDENT,"Bugun","Cukurova","111222333444",0));
  student.addMember(new Student(3,"Ali", Type.STUDENT,"Bugun","Cukurova","111222333444",0));
  student.addMember(new Student(4,"Veli", Type.STUDENT,"Bugun","Cukurova","111222333444",0));

  faculty.addMember(new Faculty(4,"Engineering",Type.FACULTY,"Dun","Cukurova","3221111324",0));

  student.purchaseBook(1,21);
  student.purchaseBook(1,4);
  student.purchaseBook(3,14);

  System.out.println("*********************");

  System.out.println("***************");
  System.out.println("Sistemde kayitli reader Listesi : " + readerList);
  System.out.println("Sistemdeki student listesi " + studentList);
  System.out.println("***************");
  //ayni idli eklenmez.
  student.addMember(new Student(1,"Murat", Type.STUDENT,"Bugun","Cukurova","111222333444",0));
  //farkli id li eklenir .
  student.addMember(new Student(2,"Murat", Type.STUDENT,"Bugun","Cukurova","111222333444",0));
  System.out.println("*****************");

  System.out.println("Kitap sistemde var mi ?? : " + ((Book) book).noStock(13));

  System.out.println("****************");
  // Kitap odunc al .
  student.borrowBook(1,33);
  System.out.println("****************");
  student.borrowBook(1,13);
  student.borrowBook(1,2);
  student.borrowBook(1,13); // Kitap kiralandigindan tekrar kiralanamaz. Sistemde yok .
  student.borrowBook(2,11);
  student.borrowBook(1,14);
  //Kiradaki kitaplarin listesi
  student.getStudentLentMap();

  System.out.println("***************");
  student.returnBook(1,2);
  student.returnBook(1,2);

  System.out.println("***************");
  System.out.println(student.getStudentDeptMap());;
 }
}