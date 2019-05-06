package com.bksx.nettest.activity;

import android.os.Environment;
import android.os.Bundle;
import com.bksx.nettest.R;
import java.io.File;
import java.io.IOException;

import androidx.appcompat.app.AppCompatActivity;
import okio.Okio;

public class OkioActivity extends AppCompatActivity {

    private String txt = "Anything but ordinary";
    private String filePath = Environment.getExternalStorageDirectory() + "/" + "output.txt";
    private File file ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okio);
//        setContentView(R.layout.activity_constraint_test);
        writeText();
    }

    private void writeText() {
        file = new File(filePath);
        try {
            Okio.buffer(Okio.sink(file)).writeUtf8(txt).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
