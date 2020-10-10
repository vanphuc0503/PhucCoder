package com.udemy.basemodule.base;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class BaseViewModel extends ViewModel {

    private CompositeDisposable disposable = new CompositeDisposable();
    private MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    private MutableLiveData<Throwable>  error = new MutableLiveData<>();

    protected <T> void doAction(AsynAction<T> action, MutableLiveData<T> result) {
        Observable<T> observable = Observable.create(emitter -> {
            try {
                T t = action.getAction();
                emitter.onNext(t);
            } catch (Exception ex) {
                emitter.onError(ex);
            } finally {
                emitter.onComplete();
            }
        });
        observable.observeOn(Schedulers.io());
        observable.subscribeOn(AndroidSchedulers.mainThread());
        doAction(observable, result);
    }

    protected <T> void doAction(Observable<T> observable, MutableLiveData<T> result){
        isLoading.postValue(true);
        error.postValue(null);
        Disposable disposable = observable.subscribe(value -> {
                    result.postValue(value);
                },
                error -> {
                    isLoading.postValue(false);
                    this.error.postValue(error);
                },
                () ->{
                    isLoading.postValue(false);
                }
        );
        this.disposable.add(disposable);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }

    public MutableLiveData<Boolean> getIsLoading() {
        return isLoading;
    }

    public MutableLiveData<Throwable> getError() {
        return error;
    }

    public interface AsynAction<T> {
        T getAction() throws Exception;
    }
}
