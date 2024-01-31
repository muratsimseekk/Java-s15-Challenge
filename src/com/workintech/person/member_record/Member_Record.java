package com.workintech.person.member_record;

import com.workintech.enums.Type;

import java.util.ArrayList;
import java.util.List;

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

        memberList.add(this);
        System.out.println("Member succefully created . Member id : " + this.id);
    }

    // Set yerine list kullanidim cunku Set ler hashCode lar ile tutuyorlar . memberList filter ederken ( getMember() ) bana oncelik olarak
    // id si eslesenleri getirsin istiyorum .
    private List<Member_Record> memberList = new ArrayList<>();


    public void addMember (Member_Record member){
        memberList.add(member);
    }

    public List<Member_Record> getMemberList() {
        memberList.addAll(Student.getStudentList());
        memberList.addAll(Faculty.getFacultyList());
        System.out.println("Tum member larin Listesi : ");
        return memberList;
    }

        // id si eslesmeyen member icin arama yapilirken , ayni isimdeki farkli kuillanicilari
        // liste halinde bastirmak istesek getMember methodunun tipini ne yapmaliydik ?
        public Member_Record getMember (int memberId ) {
            List<Member_Record> memberListCopy = getMemberList();
        for (Member_Record member : memberListCopy){
            if (member.id == memberId) {
                return member;
            }
        }
        return null;
    }

    // Bir kisi 5 den fazla kitabi odunc alamaz . Bunun icin yazilan condition.
    public void inc_book_issue (int memberId) {
        for (Member_Record member : memberList){
            if (member.id == memberId){
                if (member.noBooksIssue <=5){
                    member.noBooksIssue += 1;
                    System.out.println("Member id : " +member.id + " barrowed books number has increased to" + member.noBooksIssue);
                }
                else {
                    System.out.println("Member id : " +member.id + " can not get more than 5 books .");
                }


            }
            else {
                System.out.println("Member id " + member.id + " has no library membership .");
            }
        }
    }
    public void dec_book_issue(int memberId){
        for (Member_Record member : memberList){

            if (member.id == memberId){
                if (member.noBooksIssue > 0 && member.noBooksIssue <=5 ){
                    member.noBooksIssue -=1;
                    System.out.println("Member id : " +member.id + " has returned the book , number of books decreased to :" + member.noBooksIssue);
                }
                else {
                    System.out.println("Member id " + member.id + " hasn't taken any book from library . ");
                }

            }
            else {
                System.out.println("Member id " + member.id + " has no library membership .");
            }

        }

    }

    // Pay bill methodu bakilacak . Book ucretini odemesi gerekiyor .
//    public double payBill(double budget) {
//    }


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
