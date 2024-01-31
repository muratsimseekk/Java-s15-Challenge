package com.workintech.library;

public interface Reader {
    void purchaseBook(int memberId , int bookID);
    void borrowBook();
    void returnBook();
    void showBook();
    void whoYouAre();
}
