package com.example.newproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.newproject.databinding.ActivityRegistErBinding;
import com.example.newproject.ui.MyActivity;
import com.example.newproject.util.HttpUtils;

import java.io.IOException;

public class RegisterActivity extends AppCompatActivity {

    private ActivityRegistErBinding binding; // binding 不需要layout文件中的context

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistErBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        RegisterFragment fragment = new RegisterFragment();


        setActionListener();
    }

    private void setActionListener() {

        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUp(view);
            }
        });
    }

    public void signUpSuccessful(String account) {
        Intent intent = new Intent(RegisterActivity.this, MyActivity.class);

        intent.putExtra("account", account);

        setResult(RESULT_OK, intent);
        finish();
    }
    private void signUp(final View view) {
        Log.d("yds", "邮箱注册");
        String account = binding.etRaccount.getText().toString();
        try {
            new HttpUtils().register(account);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String passWord = binding.btnRegister.getText().toString();

//        final User user = new User();
//        user.setUsername(account);
//        user.setPassword(passWord);
//        user.signUp(new SaveListener<User>() {
//            @Override
//            public void done(User user, BmobException e) {
//                if (e == null) {
//                    signUpSuccessful(account);
//                    Snackbar.make(view, "注册成功", Snackbar.LENGTH_LONG).show();
//                } else {
//                    Snackbar.make(view, "尚未失败：" + e.getMessage(), Snackbar.LENGTH_LONG).show();
//                }
//            }
//        });
    }
}
