package com.example.user.mvpretrofitrxjava2.root;

import android.app.Application;

import com.example.user.mvpretrofitrxjava2.TopMovies.MVPmodule;
import com.example.user.mvpretrofitrxjava2.http.ApiModuleMoreInfo;
import com.example.user.mvpretrofitrxjava2.http.ApiModuleMovie;

public class App extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .mVPmodule(new MVPmodule())
                .apiModuleMoreInfo(new ApiModuleMoreInfo())
                .apiModuleMovie(new ApiModuleMovie())
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}