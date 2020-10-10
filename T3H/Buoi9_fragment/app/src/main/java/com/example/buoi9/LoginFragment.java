package com.example.buoi9;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LoginFragment extends Fragment implements View.OnClickListener {

    private final String TAG = "LoginFragment";
    private EditText edtUserName;
    private EditText edtPassword;
    private Button btnLogin;
    private Button btnRegister;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(TAG, "onActivityCreated");
        edtUserName = getActivity().findViewById(R.id.edt_user_name);
        edtPassword = getActivity().findViewById(R.id.edt_password);
        btnLogin = getActivity().findViewById(R.id.btn_login);
        btnRegister = getActivity().findViewById(R.id.btn_register);
        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                break;
            case R.id.btn_register:
                if (getActivity() instanceof MainActivity){
                    MainActivity main = (MainActivity) getActivity();
                    main.showFragment(main.getFmRegister());
                }
                break;
        }
    }

    public EditText getEdtUserName() {
        return edtUserName;
    }

    public EditText getEdtPassword() {
        return edtPassword;
    }

    public void setInfo(String userName, String password){
        Log.e(TAG, "setInfo");
        edtUserName.setText(userName);
        edtPassword.setText(password);
    }
}
