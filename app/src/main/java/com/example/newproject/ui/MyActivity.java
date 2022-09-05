package com.example.newproject.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.newproject.MainActivity;
import com.example.newproject.RegisterActivity;
import com.example.newproject.SharedHelper;
import com.example.newproject.User;
import com.example.newproject.databinding.ActivityMyBinding;

public class MyActivity extends AppCompatActivity {

    private ActivityMyBinding binding;
    public SharedHelper sharedHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 设置logout重新进入主界面

//        Bmob.initialize(this, "82a9e99d8e5b7ad7e95804931a40a6e1");
        binding = ActivityMyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sharedHelper = new SharedHelper(getApplicationContext());
        setActionListener();
    }

    public boolean logout() {
        String str = null;
        str = getIntent().getStringExtra("logout");
        if (str != null && str.equals("logout")) {
            sharedHelper.saveStatus(false);
            return true;
        }
        return false;
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!logout()) {
            if (sharedHelper.read().get("status")) {
                loginSuccessful();
            }
        }

    }

    public void setActionListener() {

        // 设置登录按钮的功能
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login(view);

            }
        });

        // 设置注册按钮功能
        binding.tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyActivity.this, RegisterActivity.class);

                startActivityForResult(intent, 100);
            }
        });
    }

    public void loginSuccessful() {
        Intent intent = new Intent(MyActivity.this, MainActivity.class);

        startActivity(intent);
        sharedHelper.saveStatus(true);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        binding.etAccount.setText(data.getStringExtra("account"));
    }

    private void login(final View view) {
        final User user = new User();
        //此处替换为你的用户名
        user.setUsername(binding.etAccount.getText().toString());
        //此处替换为你的密码
        user.setPassword(binding.etPassword.getText().toString());
        loginSuccessful();
//        user.login(new SaveListener<User>() {
//            @Override
//            public void done(User bmobUser, BmobException e) {
//                if (e == null) {
//                    User user = BmobUser.getCurrentUser(User.class);
//                    loginSuccessful();
//                    Snackbar.make(view, "登录成功：" + user.getUsername(), Snackbar.LENGTH_LONG).show();
//
//                } else {
//                    Snackbar.make(view, "登录失败：" + e.getMessage(), Snackbar.LENGTH_LONG).show();
//                }
//            }
//        });
    }
}
