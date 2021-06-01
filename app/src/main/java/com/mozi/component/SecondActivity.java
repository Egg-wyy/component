package com.mozi.component;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;


@Route(path = "/test/activity2")
public class SecondActivity extends AppCompatActivity {


    @Autowired
    public String keyword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ARouter.getInstance().inject(this);


        System.out.println("keyword:======"+keyword);



    }
}
