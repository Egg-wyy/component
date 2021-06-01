package com.mozi.base;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

public class BaseApp extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        initARouter();

    }

    private void initARouter() {
        ARouter.openLog();     // Print log
        ARouter.openDebug();

        ARouter.init(this);
    }
}
