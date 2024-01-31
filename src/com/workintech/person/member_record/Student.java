package com.workintech.person.member_record;

import com.workintech.enums.Type;
import com.workintech.library.Book;
import com.workintech.library.Library;
import com.workintech.library.Reader;

import java.util.*;

public class Student extends Member_Record implements Reader {

    private  double totalAmount ;
    private  List<Student> studentList = new ArrayList<>();

    Map<Integer , Double> studentMap = new HashMap<>();

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

        for (Member_Record student : getMemberList()){

           if (student.getId() == memberId ){

               for (Library book : bookList){
                   if (((Book)book).getBookID() == bookID){
                       ((Student)student).totalAmount += ((Book)book).getPrice();
                       studentMap.put(memberId , ((Student) student).totalAmount ) ;
                       System.out.println("Student id : " + student.getId() + " has purchased the book . Total amount : " + ((Student)student).totalAmount  );

                   }
               }

           }

        }

    }

    public void getStudentMap() {
        Set<Integer> keys = studentMap.keySet();
        System.out.println("Borclular listesi :" );
        for (Integer key : keys){
            System.out.println("Student id : " + key + " , total dept : " + studentMap.get(key) );
        }
    }

    @Override
    public void borrowBook() {

    }

    @Override
    public void returnBook() {

    }

    @Override
    public void showBook() {

    }

    @Override
    public void whoYouAre() {

    }
}
