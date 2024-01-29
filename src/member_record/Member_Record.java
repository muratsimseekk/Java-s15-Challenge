package member_record;

import com.workintech.enums.Type;

import java.util.*;

public class Member_Record {
    private int id ;
    private String name ;
    private String address ;
    private String phoneNubmer ;
    private Type type ;

    private String dateOfMembership ;

    private int noBooksIssue ;


    // Set yerine list kullanidim cunku Set ler hashCode lar ile tutuyorlar . memberList filter ederken ( getMember() ) bana oncelik olarak
    // id si eslesenleri getirsin istiyorum .
    private List<Member_Record> memberList = new ArrayList<>();

    public Member_Record() {
    }

    public Member_Record(int id, String name, String address, String phoneNubmer, Type type, String dateOfMembership, int noBooksIssue) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNubmer = phoneNubmer;
        this.type = type;
        this.dateOfMembership = dateOfMembership;
        this.noBooksIssue = noBooksIssue;
    }

    public void addMember (Member_Record member){
        memberList.add(member);
    }

    public List<Member_Record> getMemberList() {
        return memberList;
    }

    // id si eslesmeyen member icin arama yapilirken , ayni isimdeki farkli kuillanicilari
    // liste halinde bastirmak istesek getMember methodunun tipini ne yapmaliydik ?
    public Member_Record getMember (int memberId ) {

        for (Member_Record member : memberList){
            if (member.id == memberId) {
                return member;
            }
        }
        return null;
    }
    public void inc_book_issue () {}
    public void dec_book_issue(){}
    public void payBill(){}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Member_Record that)) return false;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Member_Record{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNubmer='" + phoneNubmer + '\'' +
                ", type=" + type +
                ", dateOfMembership='" + dateOfMembership + '\'' +
                ", noBooksIssue=" + noBooksIssue +
                '}';
    }
}
