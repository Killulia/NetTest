package com.example.javatest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import okio.Buffer;
import okio.Okio;
import okio.Source;

public class TestClass {

    public static void main(String[] args){
        okio1();
    }

    private static void okio1(){
        try (Source source = Okio.source(new File("E:\\test.txt"))){
            Buffer buffer = new Buffer();
            source.read(buffer, 1024);
            System.out.println(buffer.readUtf8());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
