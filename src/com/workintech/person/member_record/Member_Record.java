package com.workintech.person.member_record;

import com.workintech.enums.Type;
import com.workintech.library.Library;

import java.util.*;

public class Member_Record {

    private int id ;
    private String name ;
    private Type type ;

    private String dateOfMembership ;
    private String address ;
    private String phoneNumber;
    private int noBooksIssue ;



    public Member_Record() {
    }

    public Member_Record(int id, String name, Type type, String dateOfMembership, String address, String phoneNumber, int noBooksIssue) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.dateOfMembership = dateOfMembership;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.noBooksIssue = 0;
    }

    // Set yerine list kullanidim cunku Set ler hashCode lar ile tutuyorlar . memberList filter ederken ( getMember() ) bana oncelik olarak
    // id si eslesenleri getirsin istiyorum .
    public static List<Member_Record> memberList = new ArrayList<>();



    public void addMember (Member_Record member){
        memberList.add(member);
        Library.readerList.add(member);
        if (member instanceof Student){
            ((Student)member).getStudentList().add((Student) member);
        }
    }

    public List<Member_Record> getMemberList() {
        return memberList;
    }

        // id si eslesmeyen member icin arama yapilirken , ayni isimdeki farkli kuillanicilari
        // liste halinde bastirmak istesek getMember methodunun tipini ne yapmaliydik ?
        public static Member_Record getMember (int memberId ) {
            List<Member_Record> memberListCopy = Member_Record.memberList;
        for (Member_Record member : memberListCopy){
            if (member.id == memberId) {
                return member;
            }
        }
        return null;
    }

    // Bir kisi 5 den fazla kitabi odunc alamaz . Bunun icin yazilan condition.
    public boolean inc_book_issue (int memberId) {
        for (Member_Record member : memberList){
            if (member.id == memberId){
                if (member.noBooksIssue <=5){
                    member.noBooksIssue += 1;
                    System.out.println("Member id : " +member.id + " barrowed books number has increased to" + member.noBooksIssue);
                    return true;
                }
                else {
                    System.out.println("Member id : " +member.id + " can not get more than 5 books .");
                }
            }
        }
        return false;
    }
    public boolean dec_book_issue(int memberId){
        for (Member_Record member : memberList){

            if (member.id == memberId){
                if (member.noBooksIssue > 0 && member.noBooksIssue <=5 ){
                    member.noBooksIssue -=1;
                    System.out.println("Member id : " +member.id + " has returned the book , number of books decreased to :" + member.noBooksIssue);
                    return true;
                }


            }


        }
        return false;
    }

    // Pay bill methodu bakilacak . Book ucretini odemesi gerekiyor .
    public double payBill(int memberID) {
        return 0 ;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public String getDateOfMembership() {
        return dateOfMembership;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getNoBooksIssue() {
        return noBooksIssue;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setDateOfMembership(String dateOfMembership) {
        this.dateOfMembership = dateOfMembership;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setNoBooksIssue(int noBooksIssue) {
        this.noBooksIssue = noBooksIssue;
    }

    // esitlik id ye gore saglanir .
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
                ", type=" + type +
                ", dateOfMembership='" + dateOfMembership + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", noBooksIssue=" + noBooksIssue +

                '}';
    }
}
