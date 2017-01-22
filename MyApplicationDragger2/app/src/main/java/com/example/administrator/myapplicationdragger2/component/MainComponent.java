package com.example.administrator.myapplicationdragger2.component;

import com.example.administrator.myapplicationdragger2.MainActivity;
import com.example.administrator.myapplicationdragger2.module.PersonModule;

import dagger.Component;

/**
 * Created by administrator on 17/1/22.
 */

@Component(modules = PersonModule.class)
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
