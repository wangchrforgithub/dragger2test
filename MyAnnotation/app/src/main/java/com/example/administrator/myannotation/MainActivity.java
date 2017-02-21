package com.example.administrator.myannotation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.administrator.myannotation.generated.GeneratedMyClass;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TestAnnotation ta = new TestAnnotation();
        /*
        * 1 需要在gradle中添加相应的依赖
        * 2 需要引用annotation
        * 3 编译
        * */
        GeneratedMyClass gc = new GeneratedMyClass();
        Log.i("wangchr","gc message is " + gc.getMessage());
    }
}
