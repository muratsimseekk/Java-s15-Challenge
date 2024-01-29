package member_record;

import com.workintech.enums.Type;

public class Main {
    public static void main(String[] args) {

        Member_Record student = new Member_Record();
        student.addMember(new Member_Record(1,"Ali","Antep","5332221113", Type.YEARLY,"12.12.2021" ,2));
        student.addMember(new Member_Record(2,"Mehmet","Antep","5332221113", Type.YEARLY,"12.12.2021" ,2));
        student.addMember(new Member_Record(3,"Aayse","Antep","5332221113", Type.YEARLY,"12.12.2021" ,2));
        student.addMember(new Member_Record(4,"Tugce","Antep","5332221113", Type.YEARLY,"12.12.2021" ,2));

        System.out.println( student.getMemberList());


        System.out.println(student.getMember(7));

    }
}
