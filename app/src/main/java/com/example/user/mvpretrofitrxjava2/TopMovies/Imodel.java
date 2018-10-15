package com.example.user.mvpretrofitrxjava2.TopMovies;

import android.arch.lifecycle.ViewModel;

import com.example.user.mvpretrofitrxjava2.http.ApiModel.Result;

import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;

public class Imodel implements Contract.Model {

    private Repository repository;

    public Imodel(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<MovieData> getData() {
        return Observable.zip(
                repository.getResultData(),
                repository.getCountryData(),
                new BiFunction<Result, String, MovieData>() {
                    @Override
                    public MovieData apply(Result result, String s) {
                        return new MovieData(result.title, s);
                    }
                }
        );
    }
}
