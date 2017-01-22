package com.example.administrator.myapplicationdragger2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.administrator.myapplicationdragger2.component.DaggerMainComponent;
import com.example.administrator.myapplicationdragger2.component.MainComponent;
import com.example.administrator.myapplicationdragger2.module.Car;
import com.example.administrator.myapplicationdragger2.module.MainModule;
import com.example.administrator.myapplicationdragger2.module.Person;
import com.example.administrator.myapplicationdragger2.present.APresent;

import javax.inject.Inject;
import javax.inject.Named;

//学习博客：http://blog.csdn.net/lisdye2/article/details/51942511
public class MainActivity extends AppCompatActivity {
    @Inject
    @Named("context")
    //通过注解的方式，可以区分Module返回值相同的情况
    //使用时，使用者的@Inject上，必须要加入注解@Named("xxx"),不然编译期会报错。
    Person mPerson;

    @Inject
    Person mPersonSed;

    @Inject
    Car mCar;
    @Inject
    APresent mAPresent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //只需要在这里初始化一个容器，以后每次需要注入新的依赖，只要在声明处加上"@Inject"
        initDragger();
        //Log测试
        printLog();
    }


    private void initDragger() {
        setContentView(R.layout.activity_main);
        MainComponent component = DaggerMainComponent.builder().mainModule(new MainModule(this)).build();
        component.inject(this);

        //组建依赖的写法
        //注意：！！1父依赖的Component中需要添加提供对象的接口。
        //2子依赖的Component中的注解中添加dependencies = AppComponent.class。
        //DaggerSecComponent.builder().mainComponent(component).secModele(new SecModele()).build().inject(this);
    }

    private void printLog() {
        log("mPerson  " + mPerson);
        log("mPersonSed  " + mPersonSed);
        log("car  " + mCar.getBrand());
        log("present app name " + mAPresent.getAppName());
    }

    private void log(String info) {
        Log.i("wangchr", info);
    }


}
