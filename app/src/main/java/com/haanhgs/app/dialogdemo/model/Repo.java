package com.haanhgs.app.dialogdemo.model;

import androidx.lifecycle.MutableLiveData;

public class Repo {

    private MutableLiveData<Model> liveData = new MutableLiveData<>();
    private Model model = new Model();

    public Repo() {
        liveData.setValue(model);
    }

    public MutableLiveData<Model> getLiveData(){
        return liveData;
    }

    public void setString(String string){
        model.setInform(string);
        liveData.setValue(model);
    }

}
