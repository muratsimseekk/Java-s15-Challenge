package member_record;

import com.workintech.enums.Type;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Member_Record student = new Student();
        Member_Record faculty = new Faculty();

        Member_Record student2 = new Student(9,"Ali" , "Veli" , "Deli" , Type.FACULTY ,"121212" , 4);

        List<Student> studentList = Student.getStudentList();
        List<Faculty> facultyList = Faculty.getFacultyList();

        Member_Record memberRecord = new Member_Record();


        ((Student)student2).addMember(student2) ;

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
    }
}

