//import com.workintech.enums.Type;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Faculty extends Member_Record{
//
//    // Faculty icin tek 1 tane id verilebilir . Bu yuzden list kullanabiliriz.
//    private  static List<Faculty> facultyList = new ArrayList<>();
//
//
//    public Faculty() {
//    }
//
//    public Faculty(int id, String name, String address, String phoneNubmer, Type type, String dateOfMembership, int noBooksIssue) {
//        super(id, name, address, phoneNubmer, type, dateOfMembership, noBooksIssue);
//    }
//
//    @Override
//    public void addMember(Member_Record member) {
//
//        System.out.println("Member Listeye eklendi . ");
//        if (member instanceof Faculty){
//            facultyList.add((Faculty) member);
//            System.out.println("Member Faculty listesine eklendi : " + member);
//        }
//    }
//
//    public static List<Faculty> getFacultyList() {
//        return facultyList;
//    }
//
//
//}
