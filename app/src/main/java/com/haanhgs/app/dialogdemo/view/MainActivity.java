package com.haanhgs.app.dialogdemo.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.haanhgs.app.dialogdemo.R;
import com.haanhgs.app.dialogdemo.viewmodel.ViewModel;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity{

    @BindView(R.id.tvMessage)
    TextView tvMessage;
    @BindView(R.id.bnClass)
    Button bnClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ViewModel viewModel = new ViewModelProvider(this).get(ViewModel.class);
        viewModel.getLiveData().observe(this, model -> tvMessage.setText(model.getInform()));
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
}
