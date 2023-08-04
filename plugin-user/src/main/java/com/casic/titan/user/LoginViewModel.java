package com.casic.titan.user;

import android.app.Application;
import android.text.TextUtils;
import android.view.View;

import androidx.annotation.NonNull;

import com.casic.titan.common.BaseViewModel;

/**
 * Created by fz on 2023/8/4 9:51
 * describe :
 */
public class LoginViewModel extends BaseViewModel<LoginView> {

    public LoginViewModel(@NonNull Application application) {
        super(application);
    }

    public void loginClick(View view, RequestLoginBean requestLoginBean){
        if(TextUtils.isEmpty(requestLoginBean.getUsername())){
            baseView.showToast("请输入手机号码");
            return;
        }
        if(TextUtils.isEmpty(requestLoginBean.getPassword())){
            baseView.showToast("请输入密码");
            return;
        }
        baseView.onLoginSuccess(requestLoginBean.getUsername());
    }
}
