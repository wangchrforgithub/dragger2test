package com.example.administrator.myapplicationdragger2.module;

import dagger.Module;
import dagger.Provides;

/**
 * Created by administrator on 17/1/22.
 */

@Module
public class PersonModule {
    @Provides
    Person providerPerson() {
        return new Person();
    }
}
