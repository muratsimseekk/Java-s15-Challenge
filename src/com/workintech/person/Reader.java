package com.workintech.person;

import java.util.HashSet;
import java.util.Set;

public class Reader extends Person{

    Set<Reader> readerSet = new HashSet<>();
    public Reader() {
    }

    @Override
    public void whoYouAre() {
        System.out.println("Person is a Reader .");
    }
}
