package com.example.user.mvpretrofitrxjava2.TopMovies;

import android.arch.lifecycle.ViewModel;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.user.mvpretrofitrxjava2.R;
import com.example.user.mvpretrofitrxjava2.root.App;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements  Contract.View{
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Inject
    Contract.Presenter presenter;

    private ListAdapter listAdapter;
    private List<MovieData> resultList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((App) getApplication()).getComponent().inject(this);
        ButterKnife.bind(this);
        listAdapter = new ListAdapter(resultList);
        recyclerView.setAdapter(listAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,1));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.setView(this);
        presenter.loadData();
    }


    @Override
    protected void onStop() {
        super.onStop();
        presenter.rxUnsubscribe();
        resultList.clear();
        listAdapter.notifyDataSetChanged();
    }


    @Override
    public void updateData(MovieData movieModel) {
        resultList.add(movieModel);
        listAdapter.notifyItemInserted(resultList.size() - 1);
    }

    @Override
    public void displayString(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();

    }
}
