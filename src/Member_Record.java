import com.workintech.enums.Type;

import java.util.*;

public  class Member_Record {
    private int id ;
    private String name ;
    private String address ;
    private String phoneNumber;
    private Type type ;

    private String dateOfMembership ;

    private int noBooksIssue ;


    Book book =new Book() {
        @Override
        public void getTitle() {

        }
    };

    // Set yerine list kullanidim cunku Set ler hashCode lar ile tutuyorlar . memberList filter ederken ( getMember() ) bana oncelik olarak
    // id si eslesenleri getirsin istiyorum .
    private  List<Member_Record> memberList = new ArrayList<>();

    public Member_Record() {
    }

    public Member_Record(int id, String name, String address, String phoneNumber, Type type, String dateOfMembership, int noBooksIssue) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.type = type;
        this.dateOfMembership = dateOfMembership;
        this.noBooksIssue = noBooksIssue;
    }

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

        for (Member_Record member : memberList){
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
                    System.out.println("Member id : " + member.id + " is not allowed get more than 5 books . ");
                }

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
                    System.out.println("Member id : " + member.id + " has already no books .");
                }
            }

        }

    }

    // Pay bill methodu bakilacak . Book ucretini odemesi gerekiyor .
    public double payBill(double budget){
        if (budget < book.getPrice()){
            System.out.println("The budget is not enough to pay bill . ");
            return budget;
        }
        else {
            System.out.println("Succesfully paid bill . ");
            return budget-book.getPrice();
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Type getType() {
        return type;
    }

    public String getDateOfMembership() {
        return dateOfMembership;
    }

    public int getNoBooksIssue() {
        return noBooksIssue;
    }

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
                ", phoneNumber='" + phoneNumber + '\'' +
                ", type=" + type +
                ", dateOfMembership='" + dateOfMembership + '\'' +
                ", noBooksIssue=" + noBooksIssue +
                '}';
    }
}
