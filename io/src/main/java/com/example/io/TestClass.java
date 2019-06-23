package com.example.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import okio.Buffer;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

public class TestClass {

    public static void main(String[] args){
        okioCopy();
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

    private static void okioCopy(){
        File file = new File("E:\\okio.txt");
        File file2 = new File("E:\\copy.txt");
        try (BufferedSink sink = Okio.buffer(Okio.sink(file2))){
            sink.writeAll(Okio.buffer(Okio.source(file)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
