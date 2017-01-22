package com.example.administrator.myapplicationdragger2.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by administrator on 17/2/6.
 */

@Module
public class SecModele {

    @Provides
    Person providerPersonContext(Context context) {
        return new Person(context);
    }
}
