package com.mozi.component;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

/**
 * 判断登录
 */
@Interceptor(priority = 8, name = "测试用拦截器")
public class TestInterceptor implements IInterceptor {
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        System.out.println("TestInterceptor====path:"+postcard.getPath());

        callback.onContinue(postcard);  // 处理完成，交还控制权
    }

    @Override
    public void init(Context context) {
        System.out.println("// 拦截器的初始化，会在sdk初始化的时候调用该方法，仅会调用一次");
    }
}
