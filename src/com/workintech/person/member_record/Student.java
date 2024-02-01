package com.workintech.person.member_record;

import com.workintech.enums.Status;
import com.workintech.enums.Type;
import com.workintech.library.Book;
import com.workintech.library.Library;
import com.workintech.library.Reader;

import java.util.*;

public class Student extends Member_Record implements Reader {

    private  double totalAmount ;
    private  List<Student> studentList = new ArrayList<>();

    // map ile ayni id li kullanicilari key olarak verip ustune tekrar eklememesi icin unique id ozelligini kullandim .
    Map<Integer , Double> studentDeptMap = new HashMap<>();

    Map <Integer , Enum > studentLentMap = new HashMap<>();

    // kitaplarin kimde oldugunu gostericek .
    Map <Integer , Book> studentMap = new HashMap<>();

    public Student() {
    }

    public Student(int id, String name, Type type, String dateOfMembership, String address, String phoneNumber, int noBooksIssue) {
        super(id, name, type, dateOfMembership, address, phoneNumber, noBooksIssue);

    }

    public  List<Student> getStudentList() {
        System.out.println("Student list guncellendi" );
        return studentList;
    }

    public void addMember(Member_Record member) {
        memberList.addAll(((Student) member).studentList);
        System.out.println("Member liste eklendi .");
            if (member instanceof Student) {
                studentList.add((Student) member);
                System.out.println("Student List e eklendi : " + member);
            }
    }

    @Override
    public List<Member_Record> getMemberList() {

        return super.getMemberList();
    }

    @Override
    public void purchaseBook(int memberId, int bookID) {
        Set<Library> bookList = Library.bookList;
        Iterator<Library> iterator = bookList.iterator();

        while (iterator.hasNext()) {
            Library book = iterator.next();
            if (book instanceof Book && ((Book) book).getBookID() == bookID && ((Book)book).getStatus().equals(Status.IN_STOCK)) {
                for (Member_Record student : getMemberList()) {
                    if (student.getId() == memberId) {
                        ((Student) student).totalAmount += ((Book) book).getPrice();
                        studentDeptMap.put(memberId, ((Student) student).totalAmount);

                        System.out.println("Student id: " + student.getId() +
                                " has purchased the book. Total amount: " + ((Student) student).totalAmount);
                        iterator.remove();
                        System.out.println(((Book) book).getName() + " has been removed from the book list.");
                        ((Book)book).setStatus(Status.NO_STOCK);
                        return;
                    }
                }
            }
        }
        System.out.println("Book with ID " + bookID + " or Student with ID " + memberId + " not found.");
    }

    @Override
    public void borrowBook(int memberId, int bookID) {
        Set <Library> bookList = Library.bookList;
        Iterator<Library> iterator = bookList.iterator();

        while (iterator.hasNext()){
            Library book = iterator.next();
            if (book instanceof Book && ((Book) book).getBookID() == bookID){
                for (Member_Record student : studentList){
                    if (student.getId() == memberId ){
                        //Map value enum verilmesi icin once guncellendi sonra value olarak atandi .
                        ((Book)book).setStatus(Status.LENT);
                        student.inc_book_issue(memberId); // odunc aldigi kitap +1 oldu .
                        studentLentMap.put(memberId,((Book)book).getStatus());
                        studentMap.put(memberId , (Book) book) ;
                        System.out.println("Student id: " + student.getId() +
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
    public void returnBook(int memberId , int bookID) {

        Set <Library> bookList = Library.bookList;

        for (Library book : bookList){
            if (((Book)book).getBookID() == bookID){
                for (Member_Record student : studentList){
                    if (student.getId() == memberId){

                        student.dec_book_issue(memberId); // kitabi geri getirdi -1 oldu .

                        ((Book)book).setStatus(Status.IN_STOCK); // kitap geri geldi IN_STOCK diye degistirildi .

                        System.out.println("Student id: " + student.getId() +
                                " has returned the book. Book's current status : " + ((Book)book).getStatus());
                    }
                }
            }
        }

    }

    @Override
    public void showBook(int bookID) {
        Set<Library> bookList = Library.bookList;
        Set <Integer> keys = studentMap.keySet();
        for(Integer key : keys){
            System.out.println("Student id : " + key + " , own this book : " + studentMap.get(key));
        }

    }

    public void getStudentMap() {
        Set<Integer> keys = studentDeptMap.keySet();
        System.out.println("Borclular listesi :" );
        for (Integer key : keys){
            System.out.println("Student id : " + key + " , total dept : " + studentDeptMap.get(key) );
        }
    }

    public void getStudentLentMap() {
        Set<Integer> keys = studentLentMap.keySet();
        System.out.println("Kiradaki kitaplar : ");
        for (Integer key : keys){
            System.out.println("Student id : " + key + " , book status " + studentLentMap.get(key));
        }
    }



    @Override
    public void whoYouAre() {
        System.out.println("Person is a Student . ");
    }


}