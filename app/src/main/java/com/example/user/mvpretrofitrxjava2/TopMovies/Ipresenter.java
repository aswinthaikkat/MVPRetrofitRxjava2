package com.example.user.mvpretrofitrxjava2.TopMovies;

import android.arch.lifecycle.ViewModel;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class Ipresenter implements Contract.Presenter {
    private Contract.Model model;
    private Contract.View view;
    private Disposable subscription = null;


    public Ipresenter(Contract.Model model) {
    this.model = model;
    }

    @Override
    public void setView(Contract.View v) {
        this.view = v;
    }

    @Override
    public void loadData() {
        subscription = model
                .getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<MovieData>() {
                    @Override
                    public void onComplete() {
                    }


                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        if (view != null) {
                            view.displayString("Error getting movies");
                        }
                    }

                    @Override
                    public void onNext(MovieData viewModel) {
                        if (view != null) {
                            view.updateData(viewModel);
                        }
                    }
                });

    }

    @Override
    public void rxUnsubscribe() {
        if (subscription != null) {
            if (!subscription.isDisposed()) {
                subscription.dispose();
            }
        }

    }
}
