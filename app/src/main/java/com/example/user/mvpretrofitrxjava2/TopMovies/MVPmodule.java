package com.example.user.mvpretrofitrxjava2.TopMovies;

import com.example.user.mvpretrofitrxjava2.http.MoreInfoApiService;
import com.example.user.mvpretrofitrxjava2.http.MovieApiService;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MVPmodule {
    @Provides
    public Contract.Presenter provideTopMoviesActivityPresenter(Contract.Model model) {
        return new Ipresenter(model);
    }

    @Provides
    public Contract.Model provideTopMoviesActivityModel(Repository repository) {
        return new Imodel(repository);
    }

    @Singleton
    @Provides
    public Repository provideRepo(MovieApiService movieApiService, MoreInfoApiService moreInfoApiService) {
        return new IRepository(movieApiService, moreInfoApiService);
    }
}
