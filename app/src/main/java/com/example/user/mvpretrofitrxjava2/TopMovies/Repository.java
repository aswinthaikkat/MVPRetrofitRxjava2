package com.example.user.mvpretrofitrxjava2.TopMovies;




import com.example.user.mvpretrofitrxjava2.http.ApiModel.Result;

import io.reactivex.Observable;


public interface Repository {

    Observable<Result> getResultsFromMemory();

    Observable<Result> getResultsFromNetwork();

    Observable<String> getCountriesFromMemory();

    Observable<String> getCountriesFromNetwork();

    Observable<String> getCountryData();

    Observable<Result> getResultData();

}
