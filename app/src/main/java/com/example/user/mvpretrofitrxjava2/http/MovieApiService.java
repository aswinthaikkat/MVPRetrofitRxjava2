package com.example.user.mvpretrofitrxjava2.http;

import com.example.user.mvpretrofitrxjava2.http.ApiModel.TopRated;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApiService {

    @GET("top_rated")
    Observable<TopRated> getTopRatedMovies(@Query("page") Integer page);

}
