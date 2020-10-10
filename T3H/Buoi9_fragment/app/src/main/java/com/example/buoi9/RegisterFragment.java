package com.example.buoi9;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RegisterFragment extends Fragment implements View.OnClickListener {
    private final String TAG = "RegisterFragment";
    private EditText edtRegUserName;
    private EditText edtRegPassword;
    private Button btnRegRegister;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e(TAG, "onActivityCreated");
        edtRegPassword = getActivity().findViewById(R.id.edt_reg_password);
        edtRegUserName = getActivity().findViewById(R.id.edt_reg_user_name);
        btnRegRegister = getActivity().findViewById(R.id.btn_reg_register);
        btnRegRegister.setOnClickListener(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }

    @Override
    public void onClick(View v) {
        String userName = edtRegUserName.getText().toString();
        String password = edtRegPassword.getText().toString();
        if (userName.isEmpty() || password.isEmpty()) {
            Toast.makeText(getContext(), "User name or password is empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (getActivity() instanceof MainActivity) {
            MainActivity mainActivity = (MainActivity) getActivity();
            final LoginFragment fmLogin = mainActivity.getFmLogin();
//            mainActivity.showFragment(mainActivity.getFmLogin(), new Runnable() {
//                @Override
//                public void run() {
//                    fmLogin.setInfo(userName, password);
//                }
//            });
            mainActivity.showFragment(fmLogin);
            fmLogin.setInfo(userName, password);
        }
    }
}
