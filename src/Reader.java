import com.workintech.enums.Status;
import com.workintech.enums.Type;


import java.util.Set;

public class Reader extends Student implements Person {

    Set<Book> bookList = Book.getBookList();

    public Reader() {
    }

    public Reader(int id, String name, String address, String phoneNubmer, Type type, String dateOfMembership, int noBooksIssue) {
        super(id, name, address, phoneNubmer, type, dateOfMembership, noBooksIssue);
    }


    // Method overridee ederek ulasmaya calismaliyiz . Direkt olarak cekmek yerine metod icerisinden override ile return etmek gerekiyor,


    @Override
    public Member_Record getMember(int memberId) {
        return super.getMember(memberId);
    }

    public void purchaseBook(int bookID) {

        for (Book book : bookList){
            if (book.getBookID() == bookID){
                System.out.println("Reader : " + getMember(getId()) + " has purchased the book : " + book.getName());
                bookList.remove(book);
                book.updateStatus(Status.NO_STOCK);
            }
        }
    }
    public void barrowBook(){}
    public void returnBook(){}
    public void showBook(){}
    @Override
    public void whoYouAre(Person person) {

    }
}
