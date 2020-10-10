package com.udemy.covidtour.ui.register;

import androidx.lifecycle.MutableLiveData;

import com.google.gson.JsonObject;
import com.udemy.basemodule.base.BaseViewModel;
import com.udemy.covidtour.dao.ApiBuilder;

import okhttp3.Response;
import okhttp3.ResponseBody;

public class RegisterViewModel extends BaseViewModel {
    private MutableLiveData<ResponseBody> isSuccess = new MutableLiveData<>();

    public void register(String email, String name, String password){
        JsonObject body = new JsonObject();
        body.addProperty("email", email);
        body.addProperty("name", name);
        body.addProperty("password", password);
        doAction(ApiBuilder.getInstance().register(body).toObservable(),
                isSuccess);
    }

    public MutableLiveData<ResponseBody> getIsSuccess() {
        return isSuccess;
    }
}
