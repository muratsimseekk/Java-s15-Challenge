import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Author implements Person{

    private String name ;

    Set<Book> bookSet = new HashSet<>();


    List<Book> bookList = new ArrayList<>();

    public Author(String name) {
        this.name = name;
    }

    @Override
    public void whoYouAre(Person person) {
        if (person instanceof Author){
            System.out.println(person + " is Author . ");
        }
    }



    public Book newBook (Book book) {
        book.addBook(book);
        for (Book books : Book.getBookList()){
           if ( books.getAuthor().equalsIgnoreCase(this.name)){
               bookSet.add(books);
           }
        }

        return book;
    }

    public List<Book> showBook (String authName) {
        for (Book book : Book.getBookList()){
            if (book.getAuthor().equalsIgnoreCase(authName)){
                System.out.println(authName +" named author's book list : ");
                bookList.add(book);
            }
        }

        return bookList;
    }
}
