package com.casic.titan.shadow;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.casic.titan.constant.Constant;
import com.casic.titan.shadow.base.MyApplication;
import com.casic.titan.shadow.plugin_manager.PluginHelper;
import com.tencent.shadow.core.common.Logger;
import com.tencent.shadow.core.common.LoggerFactory;
import com.tencent.shadow.dynamic.host.EnterCallback;

/**
 * Created by fz on 2023/8/3 17:43
 * describe :
 */
public class MainActivity extends AppCompatActivity {
    private static final Logger logger = LoggerFactory.getLogger(MainActivity.class);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void start_plugin_app(View view) {
        PluginHelper.getInstance().singlePool.execute(()-> {
            MyApplication.getApp().loadPluginManager(PluginHelper.getInstance().pluginManagerFile);

            /**
             * @param context context
             * @param formId  标识本次请求的来源位置，用于区分入口
             * @param bundle  参数列表, 建议在参数列表加入自己的验证
             * @param callback 用于从PluginManager实现中返回View
             */
            Bundle bundle = new Bundle();//插件 zip，这几个参数也都可以不传，直接在 PluginManager 中硬编码
            bundle.putString(
                    Constant.KEY_PLUGIN_ZIP_PATH,
                    PluginHelper.getInstance().pluginZipFile.getAbsolutePath()
            );
            bundle.putString(
                    Constant.KEY_PLUGIN_NAME,
                    Constant.PLUGIN_APP_NAME
            ); // partKey 每个插件都有自己的 partKey 用来区分多个插件，如何配置在下面讲到
            bundle.putString(
                    Constant.KEY_ACTIVITY_CLASSNAME,
                    "com.casic.titan.shadow.MainActivity"
            ); //要启动的插件的Activity页面
            bundle.putBundle(Constant.KEY_EXTRAS, new Bundle()) ;// 要传入到插件里的参数
            MyApplication.getApp().getPluginManager().enter(
                    this,
                    Constant.FROM_ID_START_ACTIVITY,
                    bundle,
                    new EnterCallback() {
                        @Override
                        public void onShowLoadingView(View view) {

                        }

                        @Override
                        public void onCloseLoadingView() {

                        }

                        @Override
                        public void onEnterComplete() {

                        }
                    });
        });
    }
    public void start_plugin_user(View view) {
        PluginHelper.getInstance().singlePool.execute(()-> {
            MyApplication.getApp().loadPluginManager(PluginHelper.getInstance().pluginManagerFile);

            /**
             * @param context context
             * @param formId  标识本次请求的来源位置，用于区分入口
             * @param bundle  参数列表, 建议在参数列表加入自己的验证
             * @param callback 用于从PluginManager实现中返回View
             */
            Bundle bundle = new Bundle();//插件 zip，这几个参数也都可以不传，直接在 PluginManager 中硬编码
            bundle.putString(
                    Constant.KEY_PLUGIN_ZIP_PATH,
                    PluginHelper.getInstance().pluginZipFile.getAbsolutePath()
            );
            bundle.putString(
                    Constant.KEY_PLUGIN_NAME,
                    Constant.PLUGIN_USER_NAME
            ); // partKey 每个插件都有自己的 partKey 用来区分多个插件，如何配置在下面讲到
            bundle.putString(
                    Constant.KEY_ACTIVITY_CLASSNAME,
                    "com.casic.titan.user.LoginActivity"
            ); //要启动的插件的Activity页面
            bundle.putBundle(Constant.KEY_EXTRAS, new Bundle()) ;// 要传入到插件里的参数
            MyApplication.getApp().getPluginManager().enter(
                    this,
                    Constant.FROM_ID_START_ACTIVITY,
                    bundle,
                    new EnterCallback() {
                        @Override
                        public void onShowLoadingView(View view) {

                        }

                        @Override
                        public void onCloseLoadingView() {

                        }

                        @Override
                        public void onEnterComplete() {

                        }
                    });
        });
    }
}
