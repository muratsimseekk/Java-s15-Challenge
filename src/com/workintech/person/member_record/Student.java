package com.workintech.person.member_record;

import com.workintech.enums.Type;
import com.workintech.library.Book;
import com.workintech.library.Library;
import com.workintech.library.Reader;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Student extends Member_Record implements Reader {

    private  double totalAmount ;
    private static List<Student> studentList = new ArrayList<>();



    public Student() {
    }

    public Student(int id, String name, Type type, String dateOfMembership, String address, String phoneNumber, int noBooksIssue) {
        super(id, name, type, dateOfMembership, address, phoneNumber, noBooksIssue);
    }

    public static List<Student> getStudentList() {
        return studentList;
    }

    public void addMember(Member_Record member) {

        System.out.println("Member liste eklendi .");
            if (member instanceof Student) {
                studentList.add((Student) member);
                System.out.println("Student List e eklendi : " + member);
            }
    }

    @Override
    public Member_Record getMember(int memberId) {
        return super.getMember(memberId);
    }

    @Override
    public void purchaseBook(int memberId, int bookID) {

        Set<Library> bookList = Library.bookList;

        for (Student student : studentList){
           if (student.getId() == memberId ){
               for (Library book : bookList){
                   if (((Book)book).getBookID() == bookID){

                       student.totalAmount += ((Book)book).getPrice();
                       System.out.println("Student id : " + student.getId() + " has purchased the book . Total amount : " + student.totalAmount  );
                   }
                   else {
                       System.out.println("Book id is not valid .");
                   }
               }

           }
           else {
               System.out.println("Member ID is not valid . Create new member before purchasing .");
           }
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
