package com.haanhgs.app.dialogdemo.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.haanhgs.app.dialogdemo.R;
import com.haanhgs.app.dialogdemo.viewmodel.MyViewModel;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentDialog extends DialogFragment {

    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.bnCancel)
    Button button;
    @BindView(R.id.bnOK)
    Button button2;

    private FragmentActivity activity;
    private MyViewModel viewModel;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialog, container, false);
        ButterKnife.bind(this, view);
        viewModel = new ViewModelProvider(activity).get(MyViewModel.class);
        return view;
    }

    @OnClick({R.id.bnCancel, R.id.bnOK})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bnCancel:
                viewModel.setString(getResources().getString(R.string.cancel_pressed));
                dismiss();
                break;
            case R.id.bnOK:
                viewModel.setString(getResources().getString(R.string.ok_pressed));
                dismiss();
                break;
        }
    }
}
