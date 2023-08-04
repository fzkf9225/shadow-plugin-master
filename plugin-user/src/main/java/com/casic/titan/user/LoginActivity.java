package com.casic.titan.user;

import androidx.annotation.Nullable;

import android.content.Intent;
import android.os.Bundle;

import com.casic.titan.common.BaseActivity;
import com.casic.titan.user.databinding.ActivityLoginBinding;


public class LoginActivity extends BaseActivity<LoginViewModel, ActivityLoginBinding> implements LoginView {
    public final static String LOGIN_USER = "login_user";

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        binding.setLoginViewModel(mViewModel);
        RequestLoginBean requestLoginBean = new RequestLoginBean();
        binding.setLoginBean(requestLoginBean);
    }

    @Override
    protected void initData(Bundle bundle) {

    }

    @Override
    public void onLoginSuccess(String phone) {
        Intent intent = new Intent(this, HomeActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(LOGIN_USER, phone);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}