import com.workintech.enums.Edition;
import com.workintech.enums.Status;

import java.util.HashSet;
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





    }
}