package com.example.user.mvpretrofitrxjava2.root;

import com.example.user.mvpretrofitrxjava2.TopMovies.MVPmodule;
import com.example.user.mvpretrofitrxjava2.TopMovies.MainActivity;
import com.example.user.mvpretrofitrxjava2.http.ApiModuleMoreInfo;
import com.example.user.mvpretrofitrxjava2.http.ApiModuleMovie;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class,MVPmodule.class,ApiModuleMovie.class,ApiModuleMoreInfo.class})
public interface ApplicationComponent {

    void inject(MainActivity target);

}
