package com.example.user.mvpretrofitrxjava2.TopMovies;


import io.reactivex.Observable;

public interface Contract {
    interface View{
        void updateData(MovieData movieModel);
        void displayString(String s);
    }

    interface Presenter{
        void setView(Contract.View v);
        void loadData();
        void rxUnsubscribe();


    }
    interface Model{
        Observable<MovieData> getData();
    }
}
