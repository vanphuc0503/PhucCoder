package com.udemy.covidtour.ui.register;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.udemy.basemodule.base.BaseActivity;
import com.udemy.covidtour.R;
import com.udemy.covidtour.databinding.ActivityRegisterBinding;
import com.udemy.covidtour.util.Validator;

public class RegisterActivity extends BaseActivity<ActivityRegisterBinding, RegisterViewModel> implements RegisterListener {
    @Override
    protected Class<RegisterViewModel> getViewModelClass() {
        return RegisterViewModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding.setListener(this);
        viewModel.getIsSuccess().observe(this, response -> {
            if (response != null ){
                finish();
            }
        });

    }

    @Override
    public void onRegisterClicked() {
        if (Validator.isEmpty(binding.edtName, binding.edtUserName, binding.edtPassword)){
            return;
        }
        String email = binding.edtUserName.getText().toString();
        String password = binding.edtPassword.getText().toString();
        String name = binding.edtName.getText().toString();
        viewModel.register(email, name, password);
    }
}
