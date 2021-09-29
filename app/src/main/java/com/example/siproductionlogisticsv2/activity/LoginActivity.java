package com.example.siproductionlogisticsv2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.siproductionlogisticsv2.R;
import com.example.siproductionlogisticsv2.fragment.LoginFragment;

public class LoginActivity extends AppCompatActivity implements LoginFragment.loginListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initInstance();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, new LoginFragment(), "LoginFragment")
                    .commit();
        }
    }

    private void initInstance() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }

    @Override
    public void onFinishLogin() {
        finish();
    }
}