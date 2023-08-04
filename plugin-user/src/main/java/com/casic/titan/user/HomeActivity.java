package com.casic.titan.user;

import androidx.annotation.Nullable;

import android.os.Bundle;

import com.casic.titan.common.BaseActivity;
import com.casic.titan.common.BaseViewModel;
import com.casic.titan.user.databinding.ActivityHomeBinding;

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