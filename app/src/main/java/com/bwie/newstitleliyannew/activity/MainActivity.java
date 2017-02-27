package com.bwie.newstitleliyannew.activity;

import android.graphics.Color;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwie.newstitleliyannew.R;
import com.bwie.newstitleliyannew.application.App;
import com.bwie.newstitleliyannew.fragment.HomeFragment;
import com.bwie.newstitleliyannew.fragment.LogFragment;
import com.bwie.newstitleliyannew.fragment.LoveFragment;
import com.bwie.newstitleliyannew.fragment.VideoFragment;
import com.umeng.message.PushAgent;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout lin_home, lin_video, lin_attention, lin_log;
    private ImageView home_frag_image, video_frag_image, attention_frag_image, log_frag_image;
    private TextView home_frag_text, video_frag_text, attention_frag_text, log_frag_text;
    private List<ImageView> list_image = new ArrayList<>();
    private List<TextView> list_text = new ArrayList<>();
    private int Image_before[] = {R.mipmap.b_newhome_tabbar, R.mipmap.b_newvideo_tabbar, R.mipmap.b_newcare_tabbar, R.mipmap.b_newmine_tabbar};
    private int Image_later[] = {R.mipmap.b_newhome_tabbar_press, R.mipmap.b_newvideo_tabbar_press, R.mipmap.b_newcare_tabbar_press, R.mipmap.b_newmine_tabbar_press};
    private int Image_before_night[] = {R.mipmap.b_newhome_tabbar_night, R.mipmap.b_newvideo_tabbar_night, R.mipmap.b_newcare_tabbar_night, R.mipmap.b_newmine_tabbar_night};
    private int Image_later_night[] = {R.mipmap.b_newhome_tabbar_press_night, R.mipmap.b_newvideo_tabbar_press_night, R.mipmap.b_newcare_tabbar_press_night, R.mipmap.b_newmine_tabbar_press_night};
    private String fragment1Tag = "f1";
    private String fragment2Tag = "f2";
    private String fragment3Tag = "f3";
    private String fragment4Tag = "f4";
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //消息推送初始化
        //getDelegate();
        PushAgent.getInstance(this).onAppStart();
        initView();
    }

    private void initView() {
        //获取控件
        lin_home = (LinearLayout) findViewById(R.id.lin_home);
        lin_video = (LinearLayout) findViewById(R.id.lin_video);
        lin_attention = (LinearLayout) findViewById(R.id.lin_attention);
        lin_log = (LinearLayout) findViewById(R.id.lin_log);
        home_frag_image = (ImageView) findViewById(R.id.home_frag_image);
        home_frag_text = (TextView) findViewById(R.id.home_frag_text);
        video_frag_image = (ImageView) findViewById(R.id.video_frag_image);
        video_frag_text = (TextView) findViewById(R.id.video_frag_text);
        attention_frag_image = (ImageView) findViewById(R.id.attention_frag_image);
        attention_frag_text = (TextView) findViewById(R.id.attention_frag_text);
        log_frag_image = (ImageView) findViewById(R.id.log_frag_image);
        log_frag_text = (TextView) findViewById(R.id.log_frag_text);
        //设置点击事件
        lin_home.setOnClickListener(this);
        lin_video.setOnClickListener(this);
        lin_attention.setOnClickListener(this);
        lin_log.setOnClickListener(this);
        //添加集合
        list_image.add(home_frag_image);
        list_image.add(video_frag_image);
        list_image.add(attention_frag_image);
        list_image.add(log_frag_image);
        list_text.add(home_frag_text);
        list_text.add(video_frag_text);
        list_text.add(attention_frag_text);
        list_text.add(log_frag_text);
        fm = getSupportFragmentManager();
        if (App.fragment) {
            Fragment fragment1 = new HomeFragment();
            fm.beginTransaction().add(R.id.fl, fragment1, fragment1Tag).commit();
            rbColor(0);
            App.fragment = false;
        } else {
            rbColor(3);
        }
    }

    @Override
    public void onClick(View view) {
        //开启事物
        FragmentTransaction ft = fm.beginTransaction();
        //设置tag
        Fragment fragment1 = fm.findFragmentByTag(fragment1Tag);
        Fragment fragment2 = fm.findFragmentByTag(fragment2Tag);
        Fragment fragment3 = fm.findFragmentByTag(fragment3Tag);
        Fragment fragment4 = fm.findFragmentByTag(fragment4Tag);
        //首先将是所有的都隐藏
        if (fragment1 != null) {
            ft.hide(fragment1);
        }
        if (fragment2 != null) {
            ft.hide(fragment2);
        }
        if (fragment3 != null) {
            ft.hide(fragment3);
        }
        if (fragment4 != null) {
            ft.hide(fragment4);
        }
        switch (view.getId()) {
            case R.id.lin_home:
                if (fragment1 == null) {
                    fragment1 = new HomeFragment();
                    ft.add(R.id.fl, fragment1, fragment1Tag);
                } else {
                    ft.show(fragment1);
                }
                rbColor(0);
                break;
            case R.id.lin_video:
                if (fragment2 == null) {
                    fragment2 = new VideoFragment();
                    ft.add(R.id.fl, fragment2, fragment2Tag);
                } else {
                    ft.show(fragment2);
                }
                rbColor(1);
                break;
            case R.id.lin_attention:
                if (fragment3 == null) {
                    fragment3 = new LoveFragment();
                    ft.add(R.id.fl, fragment3, fragment3Tag);
                } else {
                    ft.show(fragment3);
                }
                rbColor(2);
                break;
            case R.id.lin_log:
                if (fragment4 == null) {
                    fragment4 = new LogFragment();
                    ft.add(R.id.fl, fragment4, fragment4Tag);
                } else {
                    ft.show(fragment4);
                }
                rbColor(3);
                break;
        }
        ft.commit();
    }

    //切换背景的颜色图片
    private void rbColor(int i) {
        if (App.Mode == 0) {
            for (int j = 0; j < 4; j++) {
                if (j == i) {
                    list_image.get(j).setBackgroundResource(Image_later[j]);
                    list_text.get(j).setTextColor(Color.RED);
                } else {
                    list_image.get(j).setBackgroundResource(Image_before[j]);
                    list_text.get(j).setTextColor(Color.BLACK);
                }
            }
        } else {
            for (int j = 0; j < 4; j++) {
                if (j == i) {
                    list_image.get(j).setBackgroundResource(Image_later_night[j]);
                    list_text.get(j).setTextColor(Color.BLACK);
                } else {
                    list_image.get(j).setBackgroundResource(Image_before_night[j]);
                    list_text.get(j).setTextColor(Color.GRAY);
                }
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putBoolean("flag", App.fragment);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        App.fragment = (boolean) savedInstanceState.get("flag");
    }
}
