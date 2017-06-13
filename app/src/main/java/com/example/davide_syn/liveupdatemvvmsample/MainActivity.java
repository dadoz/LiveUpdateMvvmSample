package com.example.davide_syn.liveupdatemvvmsample;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.davide_syn.liveupdatemvvmsample.databinding.PeopleActivityBinding;
import com.example.davide_syn.liveupdatemvvmsample.viewmodel.PeopleViewModel;

import java.util.Observable;
import java.util.Observer;


public class MainActivity extends AppCompatActivity implements Observer {
    private PeopleViewModel peopleViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.people_activity);
        initDataBinding();
        peopleViewModel.addObserver(this);
    }

    /**
     * init data binding
     */
    private void initDataBinding() {
        PeopleActivityBinding peopleActivityBinding = DataBindingUtil
                .setContentView(this, R.layout.people_activity);
        peopleViewModel = new PeopleViewModel(this);
        peopleActivityBinding.setPeopleViewModel(peopleViewModel);
    }

    @Override
    public void update(Observable observable, Object o) {
        Log.e("TAG", "hey on update");
    }
}
