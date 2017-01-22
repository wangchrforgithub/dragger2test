package com.example.administrator.myapplicationdragger2.component;

import android.content.Context;

import com.example.administrator.myapplicationdragger2.MainActivity;
import com.example.administrator.myapplicationdragger2.module.Car;
import com.example.administrator.myapplicationdragger2.module.MainModule;
import com.example.administrator.myapplicationdragger2.module.Person;
import com.example.administrator.myapplicationdragger2.present.APresent;

import javax.inject.Named;

import dagger.Component;

/**
 * Created by administrator on 17/1/22.
 */

//@Singleton
@Component(modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity mainActivity);
    Context providerContext();
    Car getCar();
    APresent getAPresent();
    @Named("context")
    Person getPerson();
}
