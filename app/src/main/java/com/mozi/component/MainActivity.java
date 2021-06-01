package com.mozi.component;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import org.java_websocket.WebSocket;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;


@Route(path = "/test/activity")
public class MainActivity extends AppCompatActivity {


    MainFragment mainFragment;

    Fragment indexFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/test/activity2").navigation();
            }
        });

        findViewById(R.id.setting).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/test2/setting").navigation();
            }
        });

        mainFragment = new MainFragment();

        indexFragment = (Fragment) ARouter.getInstance().build("/test2/index").navigation();

        System.out.println("55555");
        RadioGroup radioGroup = findViewById(R.id.main_raido_group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.main_raido_btn_1:
                        System.out.println("11111111");
                        ARouter.getInstance().build("/test/activity2").withString("keyword","代码").navigation();
                        break;
                    case R.id.main_raido_btn_2:
                        System.out.println("2222");
                        ARouter.getInstance().build("/test2/setting").navigation();
                        break;
                    case R.id.main_raido_btn_3:
                        System.out.println("333");
                    {
                        FragmentManager manager = getSupportFragmentManager();
                        FragmentTransaction transaction = manager.beginTransaction();
                        transaction.add(R.id.main_content_view,mainFragment);
                        transaction.commitAllowingStateLoss();
                    }

                        break;
                    case R.id.main_raido_btn_4:
                        System.out.println("444");
                    {

                        FragmentManager manager = getSupportFragmentManager();
                        FragmentTransaction transaction = manager.beginTransaction();
                        transaction.add(R.id.main_content_view,indexFragment);
                        transaction.commitAllowingStateLoss();
                    }
                        break;
                }
            }
        });

        URI uri = null;
        try {
            uri = new URI("url");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        WebSocketClient webSocketClient  = new WebSocketClient(uri) {
            @Override
            public void onOpen(ServerHandshake handshakedata) {

            }

            @Override
            public void onMessage(String message) {

            }

            @Override
            public void onClose(int code, String reason, boolean remote) {

            }

            @Override
            public void onError(Exception ex) {

            }
        };

        WebSocketServer webSocketServer = new WebSocketServer(){
            @Override
            public void onOpen(WebSocket conn, ClientHandshake handshake) {

            }

            @Override
            public void onClose(WebSocket conn, int code, String reason, boolean remote) {

            }

            @Override
            public void onMessage(WebSocket conn, String message) {

            }

            @Override
            public void onError(WebSocket conn, Exception ex) {

            }

            @Override
            public void onStart() {

            }
        };
        webSocketServer.start();


    }
}
