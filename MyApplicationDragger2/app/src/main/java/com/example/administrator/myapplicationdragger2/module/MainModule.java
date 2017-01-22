package com.example.administrator.myapplicationdragger2.module;

import android.content.Context;
import android.util.Log;

import com.example.administrator.myapplicationdragger2.present.APresent;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by administrator on 17/1/22.
 */

@Module
public class MainModule {
    Context mContext;

    public MainModule(Context context) {
        mContext = context;
    }

    //================================================
    //带参数的注入，参数也要提供provider方法，如下
    @Provides
    APresent providerApresent() {
        return new APresent(mContext);
    }

    //为present提供带参数的注入，需要写参数的provider 方法
    /*
    *可能会有疑问，我既然module中已经保存了Context对象，那么为什么不直接使用Context对象呢，
    * 因为解耦，如果使用了保存的对象，会导致下次Context获取发生变化时，需要修改providerPerson(Context context)中的代码。
    * 为了实现结偶，故此实现
      ！！！！！注意：
      ！！！！！在编写Module中，不能出现传入参数和返回参数一致的情况，会导致死循环！！！！！
    */
    @Provides
    Context providerContext() {
        return mContext;
    }
    //================================================

    @Provides
//    @Singleton
        //单利,这里设置，同时在MainComponent中也设置@Singleton
    Person providerPerson() {
        Log.i("wangchr", "provider person single");
        return new Person();
    }


    /*
    如果这里也写了一个同样提供 Person的无参方法，在编译的时候会曝出
    Muti Bound Exception错误
    @Provides
    Person providerPersonNotSingle() {
        Log.i("wangchr","provider person not single");
        return new Person();
    }*/


    /*
    写了有参数的构造方法，但是在编译的时候，也会曝出Person is bound multiple times Exception
    @Provides
    Person providerNamedPerson(){
        Log.i("wangchr","provider named person");
        return new Person("Adam");
    }*/

    @Provides
    /* 直接写，也会出现Person is bound multiple times Exception。
    * （注意：这里参数是根据上面提供的方法"providerContext"输入的
    *
    * 解决方法，用named标签
    * 在调用的时候：
    *  @Named("context") // 标记
       @Inject 就可以掉起
    *
    */
    @Named("context")
    Person providerPersonNeedContext(Context context) {

        Log.i("wangchr","providerPersonNeedContext");
        return new Person(context);
    }


    //由此可见，不是必须是已provider命名
    @Provides
    Car createCar() {
        return new Car("benZ");
    }
}
