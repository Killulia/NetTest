package com.example.hencoderplus;

import android.os.Bundle;
import android.os.Environment;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hencoderplus.recyclerview.DemoAdapter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {


    RecyclerView rvTest;
    DemoAdapter adapter = new DemoAdapter(this);
    String path = Environment.getExternalStorageDirectory() + File.separator + "test.txt";
    Button btAdd;
    ConstraintSet constraintSet1 = new ConstraintSet();
    ConstraintSet constraintSet2 = new ConstraintSet();
    ConstraintLayout constraintLayout;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //        setContentView(R.layout.activity_main);

        /*  constraintlyout-base    */
//        setContentView(R.layout.constraint_base);

        /* constraintlyout-barrier_and_chain */
//        setContentView(R.layout.constraint_barrier_and_chain);

        /* constraintlyout-flow_and_set */
        setContentView(R.layout.constraint_flow);
        constraintLayout = findViewById(R.id.cl_flow);
        imageView = findViewById(R.id.iv_1);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onApplyClick(v);
            }
        });





//        buildTypeTest();
        /*  recyclerview  */
//        btAdd = findViewById(R.id.bt_add);
//        rvTest = findViewById(R.id.rv_test);
//        rvTest.setLayoutManager(new LinearLayoutManager(this));
//        rvTest.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
//        adapter.setOnItemClickListner(new DemoAdapter.OnItemClickListner() {
//            @Override
//            public void onItemClick(View view, int position) {
//                Toast.makeText(MainActivity.this, position + "", Toast.LENGTH_SHORT).show();
//            }
//        });
//        rvTest.setAdapter(adapter);
//        btAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                adapter.insertOne();
//            }
//        });


    }

    public void onApplyClick(View view) {
        TransitionManager.beginDelayedTransition(constraintLayout);//过度动画
        constraintSet1.clone(this,R.layout.constraint_flow_set);
        constraintSet1.applyTo(constraintLayout);
    }


    /*  gradle  */
    private void buildTypeTest() {
        PriceUtils.display();
        RangeUtils.display();
        Utils.drawBadge(this);
    }

    /* io   */
    private void ioTest() {

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


}
