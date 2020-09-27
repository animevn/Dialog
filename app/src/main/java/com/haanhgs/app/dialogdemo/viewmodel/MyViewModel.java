package com.haanhgs.app.dialogdemo.viewmodel;

import com.haanhgs.app.dialogdemo.model.Model;
import com.haanhgs.app.dialogdemo.model.Repo;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    private Repo repo = new Repo();

    public MutableLiveData<Model> getLiveData() {
        return repo.getLiveData();
    }

    public void setString(String string){
        repo.setString(string);
    }
}
