package com.udemy.covidtour.ui.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.udemy.basemodule.base.BaseActivity;
import com.udemy.covidtour.MainActivity;
import com.udemy.covidtour.R;
import com.udemy.covidtour.databinding.ActivityLoginBinding;
import com.udemy.covidtour.model.User;
import com.udemy.covidtour.ui.register.RegisterActivity;
import com.udemy.covidtour.util.Validator;

public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginViewModel> implements LoginListener {
    @Override
    protected Class<LoginViewModel> getViewModelClass() {
        return LoginViewModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding.setListener(this);
        viewModel.getUser().observe(this, user -> {
            if (user != null){
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra(User.class.getName(), user);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onLoginClicked() {
        if (Validator.isEmpty(binding.edtPassword, binding.edtUserName)) {
            return;
        }
        viewModel.login(binding.edtUserName.getText().toString(),
                binding.edtPassword.getText().toString());
    }

    @Override
    public void onRegisterClicked() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
