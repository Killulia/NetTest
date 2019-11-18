package com.example.hencoderplus.io;

import android.os.Environment;
import android.util.Log;

import com.example.io.TestClass;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class IOTest {

    static String path = Environment.getExternalStorageDirectory() + File.separator + "test.txt";


    /* io   */
    public static void ioTest() {

        File file = new File(path);
        if (!file.exists()) {
            Log.d("ccg", "io1");
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            FileWriter writer = new FileWriter(file);
            writer.write("abc");
            writer.flush();
        } catch (IOException e) {
            Log.d("ccg", "异常：" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void okioCopy(){
        TestClass.okioCopy();
    }
}
