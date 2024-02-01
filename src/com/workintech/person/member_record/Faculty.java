package com.workintech.person.member_record;

import com.workintech.enums.Status;
import com.workintech.enums.Type;
import com.workintech.library.Book;
import com.workintech.library.Library;
import com.workintech.library.Reader;

import java.util.*;

public class Faculty extends Member_Record implements Reader {

    private double totalAmount;

    private  List<Faculty> facultyList = new ArrayList<>();

    Map<Integer , Double> facultyDebtMap = new HashMap<>();
    Map <Integer , Set<Book>> facultyLentMap = new HashMap<>();

    Map<Integer , Book> facultyMap = new HashMap<>();


    public Faculty() {
    }

    public Faculty(int id, String name,Type type , String phoneNubmer,String address ,String dateOfMembership, int noBooksIssue) {
        super(id, name,type, address, phoneNubmer, dateOfMembership, noBooksIssue);

    }

    @Override
    public void addMember(Member_Record member) {
        Member_Record.memberList.add(member);
        Library.readerList.add(member);
        System.out.println("Member Listeye eklendi . ");
        if (member instanceof Faculty){
            facultyList.add((Faculty) member);
            System.out.println("Member Faculty listesine eklendi : " + member);
        }
    }

    public List<Faculty> getFacultyList() {
        return facultyList;
    }

    @Override
    public void purchaseBook(int facultyID, int bookID) {
        Set<Library> bookList = Library.bookList;
        Iterator<Library> iterator = bookList.iterator();

        while (iterator.hasNext()) {
            Library book = iterator.next();
            if (book instanceof Book && ((Book) book).getBookID() == bookID && ((Book)book).getStatus().equals(Status.IN_STOCK)) {
                for (Member_Record faculty : getMemberList()) {
                    if (faculty.getId() == facultyID) {
                        ((Faculty) faculty).totalAmount += ((Book) book).getPrice();
                        facultyDebtMap.put(facultyID, ((Faculty) faculty).totalAmount);

                        System.out.println("Faculty id: " + faculty.getId() +
                                " has purchased the book. Total amount: " + ((Faculty) faculty).totalAmount);
                        iterator.remove();
                        System.out.println(((Book) book).getName() + " has been removed from the book list.");
                        ((Book)book).setStatus(Status.NO_STOCK);
                        return;
                    }
                }
            }
        }
        System.out.println("Book with ID " + bookID + " or Faculty with ID " + facultyID + " not found.");
    }

    @Override
    public void borrowBook(int memberId, int bookID) {
        Set<Library> bookList = Library.bookList;
        Iterator<Library> iterator = bookList.iterator();

        while (iterator.hasNext()) {
            Library book = iterator.next();
            if (!((Book) book).noStock(bookID)) {
                System.out.println("Book with ID : " + bookID + " is not in stock . ");
                return;
            } else if ((((Book) book).getBookID() == bookID)) {
                for (Member_Record faculty : facultyList) {

                    if (faculty.getId() == memberId ) {
                        // Enum degeri degistirildi
                        ((Book) book).setStatus(Status.LENT);
                        inc_book_issue(memberId);

                        if (faculty.getNoBooksIssue()<5){

                            // kiralama ucretini yansit .
                            ((Faculty) faculty).totalAmount += ((Book) book).getPrice();
                            facultyDebtMap.put(memberId, ((Faculty) faculty).totalAmount);

                            // Eğer öğrenciye ait bir kitap set daha önce oluşturulmuşsa, map icerisine value olarak ekledim .
                            if (facultyLentMap.containsKey(memberId)) {
                                facultyLentMap.get(memberId).add((Book) book);

                            } else {
                                // Eğer öğrenciye ait bir kitap set yoksa, yeni key ile mape ekledim .
                                Set<Book> lentBooks = new HashSet<>();
                                lentBooks.add((Book) book);
                                facultyLentMap.put(memberId, lentBooks);
                            }

//                        factory.inc_book_issue(memberId); // odunc aldigi kitap +1 oldu.
                            facultyMap.put(memberId, (Book) book);
                            System.out.println("Student id: " + faculty.getId() +
                                    " has lent the book  : " + ((Book) book));
                            return;
                        }
                        else {
                            System.out.println("Student id : " +faculty.getId()+ " 5 den fazla kitap alinamaz . ");
                        }

                    }
                }
            }
        }
    }

    @Override
    public void returnBook(int memberId , int bookID) {

        Set <Library> bookList = Library.bookList;

        for (Library book : bookList){
            if (((Book)book).getBookID() == bookID){
                if (((Book)book).getStatus().equals(Status.IN_STOCK)){
                    System.out.println("Kitap zaten iade edilmis . ");
                    return;
                }
                else {
                    for (Member_Record faculty : facultyList){
                        if (faculty.getId() == memberId ){

                            faculty.dec_book_issue(memberId); // kitabi geri getirdi -1 oldu .

                            ((Book)book).setStatus(Status.IN_STOCK); // kitap geri geldi IN_STOCK diye degistirildi .
                            if (faculty.getNoBooksIssue()>0){
                                ((Faculty) faculty).totalAmount -= ((Book) book).getPrice();
                                facultyDebtMap.put(memberId, ((Faculty) faculty).totalAmount);
                                facultyLentMap.get(memberId).remove((Book) book);
                                System.out.println("Student id: " + faculty.getId() +
                                        " has returned the book : " + ((Book)book));

                            }

                        }
                    }
                }

            }
        }

    }

    @Override
    public void showBook(int bookID) {
        Set<Integer> keys = facultyMap.keySet();
        // borrow olan kitaplari burda goster .
        for (Integer key : keys){
            System.out.println("Faculty id : " + key + " , own this book : " + facultyMap.get(key));
        }
    }

    public void getFacultyMap() {
        Set<Integer> keys = facultyDebtMap.keySet();
        System.out.println("Borclular listesi :" );
        for (Integer key : keys){
            System.out.println("Student id : " + key + " , total dept : " + facultyDebtMap.get(key) );
        }
    }

    public Map<Integer, Double> getFacultyDebtMap() {
        return facultyDebtMap;
    }

    public void getFacultyLentMap() {
        Set<Integer> keys = facultyLentMap.keySet();
        System.out.println("Kiradaki kitaplar : ");
        for (Integer key : keys){
            System.out.println("Student id : " + key + " , book status " + facultyLentMap.get(key));
        }
    }

    @Override
    public boolean inc_book_issue(int memberId) {
        for (Faculty faculty : facultyList){

            if (faculty.getNoBooksIssue() <5){
                faculty.setNoBooksIssue(faculty.getNoBooksIssue()+1);
                return true;
            }

        }
        System.out.println("5 den fazla kitap alinamaz. ");
        return false;
    }

    @Override
    public boolean dec_book_issue(int memberId) {
        for (Faculty faculty : facultyList){

            if (faculty.getNoBooksIssue() >0){
                faculty.setNoBooksIssue(faculty.getNoBooksIssue()-1);
                return true;
            } else if (faculty.getNoBooksIssue()==0) {
                System.out.println("Kiralanmis kitabi yok");
            }
        }
        return false;
    }

    @Override
    public void whoYouAre() {
        System.out.println("The reader is Faculty .");
    }
}
