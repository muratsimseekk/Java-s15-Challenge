package com.workintech.library;

public interface Reader {
    void purchaseBook(int memberId , int bookID);
    void borrowBook(int memberId , int bookID);
    void returnBook(int memberId , int bookID);
    void showBook(int bookID);
    void whoYouAre();
}
