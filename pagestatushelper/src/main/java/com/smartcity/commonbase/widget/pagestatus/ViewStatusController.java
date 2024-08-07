package com.smartcity.commonbase.widget.pagestatus;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.smartcity.commonbase.widget.pagestatus.imp.ConstraintLayoutViewStatusImp;
import com.smartcity.commonbase.widget.pagestatus.imp.FrameLayoutViewStatusImp;
import com.smartcity.commonbase.widget.pagestatus.imp.LinearLayoutViewStatusImp;
import com.smartcity.commonbase.widget.pagestatus.imp.RelativeLayoutViewStatusImp;
import com.smartcity.commonbase.widget.pagestatus.imp.ViewGroupViewStatusImp;
import com.smartcity.commonbase.widget.pagestatus.imp.ViewStatusInterface;

/**
 * Author: YuJunKui
 * Time:2017/12/8 10:38
 * Tips:
 */

public class ViewStatusController {

    private ViewStatusInterface viewStatusInterface;

    public void showViewStatus(View bindView, View addView, LayoutParams params) {

        //理论上只有有一次成立

        if (viewStatusInterface==null) {

            ViewGroup parent = (ViewGroup) bindView.getParent();

            if (parent instanceof RelativeLayout) {

                viewStatusInterface = new RelativeLayoutViewStatusImp();
            } else if (parent instanceof LinearLayout) {

                viewStatusInterface = new LinearLayoutViewStatusImp();
            } else if (parent instanceof FrameLayout) {

                viewStatusInterface = new FrameLayoutViewStatusImp();
            } else if (parent instanceof ConstraintLayout) {

                viewStatusInterface = new ConstraintLayoutViewStatusImp();
            } else if (parent instanceof ViewPager || parent instanceof ScrollView) {

                throw new RuntimeException("不支持直属父布局为" + parent.getClass().getSimpleName() + "使用PageStatusHelper，解决方案暂为在 binview外套一层布局");
            } else {
//            throw new RuntimeException("不支持" + bindView.getParent().getClass().getSimpleName() + "布局使用PageStatusHelper，联系维护者");
                viewStatusInterface = new FrameLayoutViewStatusImp();
            }
        }
        viewStatusInterface.addStatusView(bindView, addView, params);

    }

    public void showContent() {

        if (viewStatusInterface == null) return;
        viewStatusInterface.showContentView();

    }

}
