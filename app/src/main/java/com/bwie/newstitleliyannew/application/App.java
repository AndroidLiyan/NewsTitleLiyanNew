package com.bwie.newstitleliyannew.application;

import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;

import com.bwie.newstitleliyannew.R;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;

import org.xutils.x;

import java.util.HashMap;

import static anetwork.channel.http.NetworkSdkSetting.context;

/**
 * 类的用途：
 *
 * @author 李岩
 * @date ${date} ${time}
 * ${tags}
 */

public class App extends Application {
    public static boolean fragment;
    public static HashMap<String, Integer> resourceMap;
    public static int Mode;

    @Override
    public void onCreate() {
        super.onCreate();
        resourceMap = new HashMap<>();
        context = getApplicationContext();
        fragment = true;
        Mode = 0;
        // 默认设置为日间模式
           // AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        x.Ext.init(this);
        ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(this);
        config.threadPriority(Thread.NORM_PRIORITY - 2);
        config.denyCacheImageMultipleSizesInMemory();
        config.diskCacheFileNameGenerator(new Md5FileNameGenerator());
        config.diskCacheSize(50 * 1024 * 1024); // 50 MiB
        config.tasksProcessingOrder(QueueProcessingType.LIFO);
        config.writeDebugLogs(); // Remove for release app

        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config.build());
        //
        PushAgent mPushAgent = PushAgent.getInstance(this);
//注册推送服务，每次调用register方法都会回调该接口
        mPushAgent.register(new IUmengRegisterCallback() {

            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回device token
                Log.i("deviceToken", "onSuccess: " + deviceToken);
            }

            @Override
            public void onFailure(String s, String s1) {

            }
        });


    }

    public static void swichclior(int tag) {
        switch (tag) {
            //白天模式
            case 0:
                resourceMap.put("qq", R.mipmap.qq_allshare_normal);
                resourceMap.put("weixin", R.mipmap.weixin_allshare_normal);
                resourceMap.put("webo", R.mipmap.cellphoneicon_login_profile);
                resourceMap.put("top", R.mipmap.search_background);
                resourceMap.put("shouChang",R.mipmap.b_film_star_edge);
                resourceMap.put("liShi",R.mipmap.b_newtoutiao_tabbar);
                resourceMap.put("yeJian",R.mipmap.nighticon_profile);
                resourceMap.put("friend",R.mipmap.user_subscribe);
                break;
            //夜间模式
            case 1:
                resourceMap.put("qq", R.mipmap.qqicon_login_profile);
                resourceMap.put("weixin", R.mipmap.wixinicon_login_profile);
                resourceMap.put("webo", R.mipmap.webo);
                resourceMap.put("top", R.mipmap.search_backgroundb);
                resourceMap.put("shouChang",R.mipmap.b_film_star_edge_night);
                resourceMap.put("liShi",R.mipmap.b_newtoutiao_tabbar_night);
                resourceMap.put("yeJian",R.mipmap.dayicon_profile_press);
                resourceMap.put("friend",R.mipmap.user_dynamic);
                break;
        }
    }

    public static void mChangeImage(int i) {
        if (i == 0) {
            swichclior(0);
        } else if (i == 1) {
            swichclior(1);
        }
    }


}
