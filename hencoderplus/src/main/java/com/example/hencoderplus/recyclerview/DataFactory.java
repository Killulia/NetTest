package com.example.hencoderplus.recyclerview;

import java.util.ArrayList;

public class DataFactory {

    static ArrayList<User> list;

    static {
        list = new ArrayList<User>();
        list.add(new User("Jordan"));
        list.add(new User("Wilt"));
        list.add(new User("Lebron"));
        list.add(new User("Aduba"));
        list.add(new User("Bill"));
        list.add(new User("Magic"));
        list.add(new User("Tim"));
        list.add(new User("Bird"));
        list.add(new User("Shaq"));
        list.add(new User("Kobe"));
        list.add(new User("Hakim"));
        list.add(new User("West"));
        list.add(new User("Oska"));
    }
}
