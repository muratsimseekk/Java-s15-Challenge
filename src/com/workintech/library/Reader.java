package com.workintech.library;

public interface Reader {
    void purchaseBook(int memberId , int bookID);
    void borrowBook(int memberId , int bookID);
    void returnBook();
    void showBook();
    void whoYouAre();
}
