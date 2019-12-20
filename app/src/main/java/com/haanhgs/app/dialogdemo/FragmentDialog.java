package com.haanhgs.app.dialogdemo;

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

public class FragmentDialog extends DialogFragment {

    public interface OnButtonClicked{
        void onOkClicked();
        void onCancelClicked();
    }

    private OnButtonClicked listener;

    public void setListener(OnButtonClicked listener) {
        this.listener = listener;
    }

    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.bnCancel)
    Button button;
    @BindView(R.id.bnOK)
    Button button2;

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
