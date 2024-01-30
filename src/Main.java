import com.workintech.enums.Edition;
import com.workintech.enums.Status;
import com.workintech.enums.Type;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<Journals> journalList = Journals.getJournalsList();
        Set<StudyBooks> studyBooksList = StudyBooks.getStudyBooksList();

        Book journal = new Journals();


        Book javaProgrammingBook = new StudyBooks(5, "John Doe", "Java Programming", 29.99, Status.LENT, Edition.FIRST_EDITION, "2024-01-29");
       Journals scienceJournal = new Journals(2, "Scientist", "Science Journal", 19.99, Status.WAITING_ORDER, Edition.LIBRARY_EDITION, "2024-01-30");
        StudyBooks mathBook = new StudyBooks(3, "Alice", "Mathematics", 24.99, Status.IN_STOCK, Edition.SECOND_EDITION, "2024-01-31");
        Magazines techMagazine = new Magazines(4, "Tech Geek", "Tech Magazine", 14.99, Status.WAITING_ORDER, Edition.E_BOOK, "2024-02-01");

        journal.addBook(new Journals(1,"Ayse Simsek" , "PARLA" ,150 ,Status.IN_STOCK ,Edition.E_BOOK,"10.10.2011"));
        journal.addBook(new Journals(12,"Ayse Simsek" , "PARLA" ,187 ,Status.IN_STOCK ,Edition.E_BOOK,"10.10.2011"));
        journal.addBook(new Journals(33,"Murat Simsek" , "PARLA" ,150 ,Status.IN_STOCK ,Edition.E_BOOK,"10.10.2011"));
        journal.addBook(new Journals(31,"Murat Simsek" , "PARLA" ,130 ,Status.IN_STOCK ,Edition.E_BOOK,"10.10.2011"));
        journal.addBook(new Journals(21,"Mehmet Simsek" , "PARLA" ,122 ,Status.IN_STOCK ,Edition.E_BOOK,"10.10.2011"));
        journal.addBook(new Journals(51,"Ali Simsek" , "PARLA" ,139 ,Status.IN_STOCK ,Edition.E_BOOK,"10.10.2011"));
        journal.addBook(new Journals(71,"Ali Simsek" , "PARLA" ,158 ,Status.IN_STOCK ,Edition.E_BOOK,"10.10.2011"));
        javaProgrammingBook.addBook(javaProgrammingBook);
        scienceJournal.addBook(scienceJournal);
        mathBook.addBook(mathBook);
        techMagazine.addBook(techMagazine);

        System.out.println("Tum booklar : ");
        Book.display();


        System.out.println("Journal tipindeki booklar ");
        for (Book journals : journalList){
            System.out.println(journals);
        }

        System.out.println("Study Book tipindeki booklar ");

        for (Book study : studyBooksList){
            System.out.println(study);
        }
        Member_Record student = new Student();
        Member_Record faculty = new Faculty();


        List<Student> studentList = Student.getStudentList();
        List<Faculty> facultyList = Faculty.getFacultyList();

        Member_Record memberRecord = new Member_Record();


        student.addMember(new Student(3,"Aayse","Antep","5332221113", Type.STUDENT,"12.12.2021" ,2));
        student.addMember(new Student(4,"Tugce","Antep","5332221113", Type.FACULTY,"12.12.2021" ,2));
        faculty.addMember(new Faculty(1,"Ali","Antep","5332221113", Type.STUDENT ,"12.12.2021" ,2));
        faculty.addMember(new Faculty(2,"Mehmet","Antep","5332221113", Type.STUDENT,"12.12.2021" ,2));

        System.out.println("*********************");

        System.out.println("Students tam liste : " + studentList);

        System.out.println("*********************");

        System.out.println("Faculty tam liste : " + facultyList );

        System.out.println("*********************");


        System.out.println(memberRecord.getMemberList());


        System.out.println("***********************");

        Person auth = new Author("Ayse Simsek");

        System.out.println("Eklenen Book : "+ ((Author)auth).newBook(new StudyBooks(4, "Tech Geek", "Tech Magazine", 14.99, Status.WAITING_ORDER, Edition.E_BOOK, "2024-02-01")));

        System.out.println(((Author)auth).showBook("Ayse Simsek"));








    }
}