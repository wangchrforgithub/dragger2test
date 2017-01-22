package com.example.administrator.myapplicationdragger2.module;

import android.content.Context;
import android.util.Log;

/**
 * Created by administrator on 17/1/22.
 */

public class Person {
    private String name;
    private Context mContext;

    public Person() {
        Log.i("wangchr", "Person create");
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(Context context) {
        this.mContext = context;
    }

}
