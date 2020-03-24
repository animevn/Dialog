package com.haanhgs.app.dialogdemo.viewmodel;

import android.app.Application;
import com.haanhgs.app.dialogdemo.model.Model;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class ViewModel extends AndroidViewModel {

    private final MutableLiveData<Model> liveData = new MutableLiveData<>();

    public ViewModel(@NonNull Application application) {
        super(application);
        liveData.setValue(new Model());
    }

    public MutableLiveData<Model> getLiveData() {
        return liveData;
    }

    public void setLiveData(Model model) {
        this.liveData.setValue(model);
    }

    public void setString(String string){
        Model model = new Model();
        model.setInform(string);
        liveData.setValue(model);
    }
}
