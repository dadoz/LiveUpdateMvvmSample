package com.example.davide_syn.liveupdatemvvmsample.viewmodel;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;


import java.lang.ref.WeakReference;
import java.util.Observable;

/**
 * Created by davide-syn on 6/13/17.
 */

public class PeopleViewModel extends Observable {

    private final WeakReference<Context> context;
    private ObservableInt peopleEditButton;
    private ObservableField<String> messageLabel;
    private ObservableInt peopleProgress;
    private ObservableInt peopleLabel;
    private ObservableInt peopleRecycler;
    private ObservableInt peopleEditLabel;
    private ObservableField<String> peopleEditLabelContent;
    private static String TAG = "PeopleViewModel";

    public PeopleViewModel(@NonNull Context context) {
        this.context = new WeakReference<>(context);
        messageLabel = new ObservableField<>("blalalal");
        peopleProgress = new ObservableInt(View.VISIBLE);
        peopleLabel = new ObservableInt(View.GONE);
        peopleRecycler = new ObservableInt(View.GONE);
        peopleEditLabel  = new ObservableInt(View.GONE);
        peopleEditButton  = new ObservableInt(View.GONE);
        peopleEditLabelContent = new ObservableField<>("test");
    }

    public ObservableField getMessageLabel() {
        return messageLabel;
    }

    public void setMessageLabel(ObservableField messageLabel) {
        this.messageLabel = messageLabel;
    }

    public void onChangeLabelClick(View view) {
        messageLabel.set(peopleEditLabelContent.get());
    }

    public void onClickFabLoad(View view) {
        Log.e(TAG, "hey click");
        peopleProgress.set(View.GONE);
        peopleLabel.set(View.VISIBLE);

        peopleEditLabel.set(peopleEditLabel.get() == View.GONE ? View.VISIBLE : View.GONE);
        peopleEditLabelContent.set(peopleEditLabel.get() == View.GONE ? "" : peopleEditLabelContent.get());
    }

    public ObservableInt getPeopleEditButton() {
        return peopleEditButton;
    }
    public ObservableInt getPeopleProgress() {
        return peopleProgress;
    }

    public ObservableInt getPeopleLabel() {
        return peopleLabel;
    }

    public ObservableInt getPeopleRecycler() {
        return peopleRecycler;
    }

    public ObservableInt getPeopleEditLabel () {
        return peopleEditLabel ;
    }

    public ObservableField<String> getPeopleEditLabelContent() {
        return peopleEditLabelContent;
    }

    public void setPeopleEditLabelContent(ObservableField<String> peopleEditLabelContent) {
        this.peopleEditLabelContent = peopleEditLabelContent;
    }
    public TextWatcher peopleEditLabelWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            messageLabel.set(editable.toString());
        }
    };
}
