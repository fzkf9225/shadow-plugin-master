package io.coderf.arklab.user;

import androidx.annotation.Nullable;

import android.os.Bundle;

import io.coderf.arklab.common.BaseActivity;
import io.coderf.arklab.common.BaseViewModel;
import io.coderf.arklab.user.databinding.ActivityHomeBinding;

public class HomeActivity extends BaseActivity<BaseViewModel, ActivityHomeBinding> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {

    }

    @Override
    protected void initData(Bundle bundle) {
        binding.setLoginUser(bundle.getString(LoginActivity.LOGIN_USER,"暂未登录"));
    }
}