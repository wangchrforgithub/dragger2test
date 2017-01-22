package com.example.administrator.myapplicationdragger2.component;

import com.example.administrator.myapplicationdragger2.MainActivity;
import com.example.administrator.myapplicationdragger2.module.SecModele;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by administrator on 17/2/6.
 */

//@Singleton
//依赖组建写法
//注意：！！1父依赖的Component中需要添加提供对象的接口。
//2子依赖的Component中的注解中添加dependencies = AppComponent.class。
@Component(dependencies = MainComponent.class, modules = SecModele.class)
public interface SecComponent {
    void inject(MainActivity mainActivity);
}
