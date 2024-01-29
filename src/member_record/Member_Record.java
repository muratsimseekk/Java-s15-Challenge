package member_record;

import com.workintech.enums.Type;

public class Member_Record {
    private int id ;
    private String name ;
    private String address ;
    private String phoneNubmer ;
    private Type type ;

    private String dateOfMembership ;

    private int noBooksIssue ;

    public Member_Record(int id, String name, String address, String phoneNubmer, Type type, String dateOfMembership, int noBooksIssue) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNubmer = phoneNubmer;
        this.type = type;
        this.dateOfMembership = dateOfMembership;
        this.noBooksIssue = noBooksIssue;
    }

    public void getMember () {}
    public void inc_book_issue () {}
    public void dec_book_issue(){}
    public void payBill(){}
 }
