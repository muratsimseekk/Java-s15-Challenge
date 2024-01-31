package com.workintech.person;

import com.workintech.library.Book;
import com.workintech.library.Library;
import com.workintech.library.bookTitle.Journals;
import com.workintech.library.bookTitle.Magazines;
import com.workintech.library.bookTitle.StudyBooks;

import java.util.HashSet;
import java.util.Set;

public class Author implements Person{

    Book book = new Book();

    StudyBooks studyBooks = new StudyBooks();

    Set<Book> authorSet = new HashSet<>();

    Library library = new Library();

    @Override
    public void whoYouAre() {
        System.out.println("Person is a Author.");
    }

    public void showBook(String name) {

        //Library book listine erisip icerisindeki author u authorSet icerisine atalim.
        Set<Library> books = Library.bookList;

        for (Library author : books){
            if (((Book)author).getAuthor().equalsIgnoreCase(name) ){
                ((Book)author).getAuthor(((Book) author).getBookID());
            }
        }

    }

    public void newBook(Book book){


        library.addBook(book);
        book.addBook(book);

        if (book instanceof StudyBooks){
            System.out.println("New book added to Study Books Category ********* " + book);
            StudyBooks.addStudyBook((StudyBooks) book);
        }
        else if (book instanceof Journals){
            System.out.println("New book added to Journals Category ********* " + book);
            Journals.addJournalsList((Journals) book );

        } else if (book instanceof Magazines) {
            System.out.println("New book added to Magazines Category ********* " + book);
            Magazines.addMagazines((Magazines) book);
        }

    }

}
