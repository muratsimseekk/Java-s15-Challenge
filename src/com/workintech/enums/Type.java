package com.workintech.enums;

public enum Type {

    // tip olarak kitap kiralama sinirlandirilabilir . Projeye yansit  .
    STUDENT ,
    FACULTY;


    public boolean isFaculty () {
        return this== FACULTY;
    }
}
