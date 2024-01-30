import com.workintech.enums.Type;

import java.util.ArrayList;
import java.util.List;

public class Student extends Member_Record {

    private static  List<Student> studentList = new ArrayList<>();

    public Student() {
    }

    public Student(int id, String name, String address, String phoneNubmer, Type type, String dateOfMembership, int noBooksIssue) {
        super(id, name, address, phoneNubmer, type, dateOfMembership, noBooksIssue);
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




}
