package com.casic.titan.common;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

/**
 * Created by fz on 2023/8/4 9:31
 * describe :
 */
public class BaseViewModel<BV extends BaseView> extends AndroidViewModel {
    protected BV baseView;

    public BaseViewModel(@NonNull Application application) {
        super(application);
    }

    public void setBaseView(BV baseView) {
        this.baseView = baseView;
    }
}
