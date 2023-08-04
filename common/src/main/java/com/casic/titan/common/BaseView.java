package com.casic.titan.common;

/**
 * Created by fz on 2023/8/4 9:31
 * describe :
 */
public interface BaseView {
    /**
     * 吐司弹框
     * @param msg 吐司内容
     */
    void showToast(String msg);

    /**
     * 错误处理
     * @param errorCode 错误码
     * @param msg 错误信息
     * @param throwable 异常
     */
    void onError(String errorCode,String msg,Throwable throwable);
    /**
     * 显示加载框
     * @param msg 加载狂内容
     */
    void showLoading(String msg);

    /**
     * 取消加载框
     */
    void hideLoading();
}
