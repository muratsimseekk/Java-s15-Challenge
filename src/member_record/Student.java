package member_record;

import com.workintech.enums.Type;
import member_record.Member_Record;

public class Student extends Member_Record {
    public Student(int id, String name, String address, String phoneNubmer, Type type, String dateOfMembership, int noBooksIssue) {
        super(id, name, address, phoneNubmer, type, dateOfMembership, noBooksIssue);
    }


}
