package com.casic.titan.user;

import com.casic.titan.common.BaseView;

/**
 * Created by fz on 2023/8/4 9:52
 * describe :
 */
public interface LoginView extends BaseView {
    void onLoginSuccess(String phone);
}
