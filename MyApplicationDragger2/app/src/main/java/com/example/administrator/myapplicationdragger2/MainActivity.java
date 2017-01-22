package com.example.administrator.myapplicationdragger2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.administrator.myapplicationdragger2.component.DaggerMainComponent;
import com.example.administrator.myapplicationdragger2.component.MainComponent;
import com.example.administrator.myapplicationdragger2.module.Person;
import com.example.administrator.myapplicationdragger2.module.PersonModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject
    Person mPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("wangchr"," activity create");
        MainComponent component = DaggerMainComponent.builder().personModule(new PersonModule()).build();
        component.inject(this);

    }
}
