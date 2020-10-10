package com.t3h.mp3music.ui.base;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;


public abstract class BaseActivity<BD extends ViewDataBinding, VM extends BaseViewModel> extends AppCompatActivity {
    protected BD binding;
    protected VM viewModel;
    private PermissionListener permissionListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, getLayoutId());
        viewModel = new ViewModelProvider(this).get(getViewModelClass());
        init();
    }

    protected void requestPermission(String[] permission,
                                     PermissionListener permissionListener) {
        this.permissionListener = permissionListener;
        if (checkPermission(permission, true)) {
            permissionListener.onResult(true);
        }
    }

    private boolean checkPermission(String[] permissions, boolean withRequest) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            for (String p : permissions) {
                if (checkSelfPermission(p) != PackageManager.PERMISSION_GRANTED) {
                    if (withRequest) {
                        requestPermissions(permissions, 0);
                    }
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        permissionListener.onResult(checkPermission(permissions, false));
    }

    protected abstract Class<VM> getViewModelClass();

    protected abstract void init();

    protected abstract int getLayoutId();

    public interface PermissionListener {
        void onResult(boolean isGranted);
    }
}
