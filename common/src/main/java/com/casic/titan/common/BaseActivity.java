package com.casic.titan.common;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by fz on 2023/8/4 9:31
 * describe :
 */
public abstract class BaseActivity<VM extends BaseViewModel, VDB extends ViewDataBinding> extends AppCompatActivity implements BaseView {
    protected VDB binding;
    protected VM mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        if (mViewModel == null) {
            Class modelClass;
            Type type = getClass().getGenericSuperclass();
            if (type instanceof ParameterizedType) {
                modelClass = (Class) ((ParameterizedType) type).getActualTypeArguments()[0];
            } else {
                //如果没有指定泛型参数，则默认使用BaseViewModel
                modelClass = BaseViewModel.class;
            }
            mViewModel = (VM) new ViewModelProvider(this).get(modelClass);
            mViewModel.setBaseView(this);
        }
        binding = DataBindingUtil.setContentView(this, getLayoutId());
        binding.setLifecycleOwner(this);
        initView(savedInstanceState);
        initData(getIntent().getExtras() == null ? new Bundle() : getIntent().getExtras());
    }

    /**
     * 获取布局id
     *
     * @return 布局id
     */
    protected abstract @LayoutRes int getLayoutId();

    /**
     * 页面初始化
     * @param savedInstanceState 懂的都懂
     */
    protected abstract void initView(@Nullable Bundle savedInstanceState);

    /**
     * 参数初始化
     *
     * @param bundle 上个页面传递的参数
     */
    protected abstract void initData(Bundle bundle);

    @Override
    public void showToast(String msg) {
        if (TextUtils.isEmpty(msg)) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(() -> Toast.makeText(this, msg, Toast.LENGTH_SHORT).show());
    }

    @Override
    public void onError(String errorCode, String msg, Throwable throwable) {
        // TODO 自己根据逻辑实现
    }

    @Override
    public void showLoading(String msg) {
        // TODO 自己根据逻辑实现
    }

    @Override
    public void hideLoading() {
        // TODO 自己根据逻辑实现
    }
}
