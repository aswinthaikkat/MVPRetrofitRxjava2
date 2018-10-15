package com.example.user.mvpretrofitrxjava2.http;

import com.example.user.mvpretrofitrxjava2.http.ApiModel.Ombd;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MoreInfoApiService {

    @GET("/")
    Observable<Ombd> getCountry(@Query("t") String title);
}
