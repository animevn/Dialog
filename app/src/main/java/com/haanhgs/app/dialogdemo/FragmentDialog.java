package com.haanhgs.app.dialogdemo;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//this is to use instance of - can transfer to viewmodel
public class FragmentDialog extends DialogFragment {

    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.bnCancel)
    Button button;
    @BindView(R.id.bnOK)
    Button button2;

    private OnButtonClicked listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnButtonClicked){
            listener = (OnButtonClicked)context;
        }else {
            throw new ClassCastException("must implement OnButtonClicked lister if this is called");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialog, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.bnCancel, R.id.bnOK})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bnCancel:
                listener.onCancelClicked();
                dismiss();
                break;
            case R.id.bnOK:
                listener.onOkClicked();
                dismiss();
                break;
        }
    }
}
