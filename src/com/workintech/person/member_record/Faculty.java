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
    Map <Integer , Enum> facultyLentMap = new HashMap<>();

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
    public void borrowBook(int facultyID, int bookID) {
        Set <Library> bookList = Library.bookList;
        Iterator<Library> iterator = bookList.iterator();

        while (iterator.hasNext()){
            Library book = iterator.next();
            if (book instanceof Book && ((Book) book).getBookID() == bookID){
                for (Member_Record faculty : facultyList){
                    if (faculty.getId() == facultyID ){
                        //Map value enum verilmesi icin once guncellendi sonra value olarak atandi .
                        ((Book)book).setStatus(Status.LENT);
                        faculty.inc_book_issue(facultyID); // odunc aldigi kitap +1 oldu .
                        facultyLentMap.put(facultyID,((Book)book).getStatus());
                        facultyMap.put(facultyID , ((Book) book)); // borrow oldugunda faculty idsi ile hangi kitap oldugunu bir map e aldik .
                        System.out.println("Faculty id: " + faculty.getId() +
                                " has lent the book. Book's current status : " + ((Book)book).getStatus());
                        return;
                    }
                }
            }
            else {
                System.out.println("Book with ID : " + bookID + " is not in stock . ");
            }
        }
    }

    @Override
    public void returnBook(int facultyID, int bookID) {
        Set <Library> bookList = Library.bookList;

        for (Library book : bookList){
            if (((Book)book).getBookID() == bookID){
                for (Member_Record student : facultyList){
                    if (student.getId() == facultyID){

                        student.dec_book_issue(facultyID); // kitabi geri getirdi -1 oldu .
                        ((Book)book).setStatus(Status.IN_STOCK); // kitap geri geldi IN_STOCK diye degistirildi .
                        System.out.println("Faculty id: " + student.getId() +
                                " has returned the book. Book's current status : " + ((Book)book).getStatus());
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

    @Override
    public void whoYouAre() {
        System.out.println("The reader is Faculty .");
    }
}
