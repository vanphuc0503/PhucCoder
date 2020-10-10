package com.udemy.covidtour.ui.login;

import androidx.lifecycle.MutableLiveData;

import com.google.gson.JsonObject;
import com.udemy.basemodule.base.BaseViewModel;
import com.udemy.covidtour.dao.ApiBuilder;
import com.udemy.covidtour.model.User;

public class LoginViewModel extends BaseViewModel {
    private MutableLiveData<User> user = new MutableLiveData<>();

    public void login(String email, String password){
        JsonObject body = new JsonObject();
        body.addProperty("email", email);
        body.addProperty("password", password);
        doAction(ApiBuilder.getInstance().login(body).toObservable(), user);
    }

    public MutableLiveData<User> getUser() {
        return user;
    }
}
