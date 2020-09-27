package com.haanhgs.app.dialogdemo.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.haanhgs.app.dialogdemo.R;
import com.haanhgs.app.dialogdemo.viewmodel.MyViewModel;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//test change git name
public class MainActivity extends AppCompatActivity{

    @BindView(R.id.tvMessage)
    TextView tvMessage;
    @BindView(R.id.bnClass)
    Button bnClass;

    private MyViewModel viewModel;

    private void initViewModel(){
        viewModel = new ViewModelProvider(this).get(MyViewModel.class);
        viewModel.getLiveData().observe(this, model -> tvMessage.setText(model.getInform()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initViewModel();
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
        viewModel.setString("");
        openDialog();
    }
}
