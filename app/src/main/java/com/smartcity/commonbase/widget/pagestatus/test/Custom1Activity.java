package com.smartcity.commonbase.widget.pagestatus.test;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import com.smartcity.commonbase.widget.pagestatus.Builder;
import com.smartcity.commonbase.widget.pagestatus.PageStatusHelper;

/**
 * Author: YuJunKui
 * Time:2018/10/7 15:59
 * Tips:
 */
public class Custom1Activity extends AppCompatActivity {

    private PageStatusHelper statusHelper;

    //可以是list 也可以是任何view
    private View contentView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(false);
        getSupportActionBar().setTitle("定制一");
        setContentView(R.layout.activity_simple);

        contentView = findViewById(R.id.rv_content);

        statusHelper = new Builder(this)
                .setErrorLayout(R.layout.view_custom_error)
                .setEmptyImage(R.drawable.ic_loading_empty)
                .setNetworkImage(R.drawable.ic_loading_no_net)
                .setLoadingLayout(R.layout.view_custom_loading)
                .build();
        statusHelper.bindView(contentView);


        statusHelper.refreshPageStatus(PageStatusHelper.LOADING);
        statusHelper.refreshPageStatus(PageStatusHelper.ERROR);
        statusHelper.refreshPageStatus(PageStatusHelper.EMPTY);

    }

    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btn_content:
                //数据加载完成调用这个方法
                statusHelper.refreshPageStatus(PageStatusHelper.CONTENT);
                break;

            case R.id.btn_empty:
                //空视图
                statusHelper.refreshPageStatus(PageStatusHelper.EMPTY);
                break;

            case R.id.btn_loading:
                //加载中
                statusHelper.refreshPageStatus(PageStatusHelper.LOADING);
                break;

            case R.id.btn_loading_error:
                //加载失败
                statusHelper.refreshPageStatus(PageStatusHelper.ERROR);
                break;

            case R.id.btn_no_login:
                //未登录
                statusHelper.refreshPageStatus(PageStatusHelper.NO_LOGIN);
                break;

            case R.id.btn_no_network:
                //没有网络
                statusHelper.refreshPageStatus(PageStatusHelper.NET_WORK);
                break;
        }
    }

}
