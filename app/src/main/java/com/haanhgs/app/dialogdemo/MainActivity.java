package com.haanhgs.app.dialogdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements OnButtonClicked{

    @BindView(R.id.tvMessage)
    TextView tvMessage;
    @BindView(R.id.bnClass)
    Button bnClass;

    private static final String MESSAGE = "message";

    private void loadSavedInstanceState(Bundle bundle){
        if (bundle != null){
            tvMessage.setText(bundle.getString(MESSAGE));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        loadSavedInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(MESSAGE, tvMessage.getText().toString());
    }

    private void openDialog(){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment fragment = getSupportFragmentManager().findFragmentByTag("dialog");
        if (fragment == null){
            FragmentDialog dialog = new FragmentDialog();
            dialog.show(getSupportFragmentManager(), "dialog");
        }
    }

    @OnClick({R.id.bnClass})
    public void onViewClicked(View view) {
        openDialog();
    }

    //handle Ok clicked in Dialog
    @Override
    public void onOkClicked() {
        tvMessage.setText(getResources().getString(R.string.ok_pressed));
    }

    //handle Cancel clicked in Dialog
    @Override
    public void onCancelClicked() {
        tvMessage.setText(getResources().getString(R.string.cancel_pressed));
    }
}
