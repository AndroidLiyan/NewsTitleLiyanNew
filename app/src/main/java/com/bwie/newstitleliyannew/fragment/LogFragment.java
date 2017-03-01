package com.bwie.newstitleliyannew.fragment;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.newstitleliyannew.R;
import com.bwie.newstitleliyannew.activity.MainActivity;
import com.bwie.newstitleliyannew.activity.SetActivity;
import com.bwie.newstitleliyannew.application.App;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.tencent.connect.UserInfo;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 类的用途：
 *
 * @author 李岩
 * @date ${date} ${time}
 * ${tags}
 */

public class LogFragment extends Fragment {

    private View view;
    private LinearLayout night;
    private MainActivity parentActivity;
    private ImageView qq;
    private ImageView wexin;
    private ImageView webo;
    private ImageView shouChang;
    private ImageView liShi;
    private ImageView yeJian;
    private static Tencent mTencent;
    private String appId = "1105933117";
    private IUiListener loginListener; //授权登录监听器
    private String scope; //获取信息的范围参数
    private ImageView loginFrag_headImage;
    private TextView login_name;
    private RelativeLayout shezhi;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.log_layout, null);
        qq = (ImageView) view.findViewById(R.id.qq);
        wexin = (ImageView) view.findViewById(R.id.weixin);
        webo = (ImageView) view.findViewById(R.id.weibo);
        shouChang = (ImageView) view.findViewById(R.id.shouChang);
        liShi = (ImageView) view.findViewById(R.id.liShi);
        yeJian = (ImageView) view.findViewById(R.id.yeJian);
        loginFrag_headImage = (ImageView) view.findViewById(R.id.LoginFrag_headImage);
        login_name = (TextView) view.findViewById(R.id.login_name);
        shezhi = (RelativeLayout) view.findViewById(R.id.shezhi);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //
        App.mChangeImage(App.Mode);
        mSetImage();
        //
        night = (LinearLayout) view.findViewById(R.id.night);
        parentActivity = (MainActivity) getActivity();
        night.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentNightMode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
                parentActivity.getDelegate().setLocalNightMode(currentNightMode == Configuration.UI_MODE_NIGHT_NO
                        ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO);
                // 同样需要调用recreate方法使之生效
                getActivity().recreate();
                //判断
                if (App.Mode == 0) {
                    App.Mode = 1;
                } else {
                    App.Mode = 0;
                }
            }
        });
        qq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
        shezhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getActivity(), SetActivity.class);
                startActivity(it);
            }
        });

    }
    @Override
    public void onDestroy() {
        if (mTencent != null) {
            //注销登录
            mTencent.logout(getActivity());
        }
        super.onDestroy();
    }

    public void login() {
        mTencent = mTencent.createInstance(appId, getActivity());
        //如果session无效，就开始登录
        if (!mTencent.isSessionValid()) {
            //开始qq授权登录
            mTencent.login(this, scope, loginListener);
            initData();
        }
    }

    private void initData() {
        //要所有权限，不然会再次申请增量权限，这里不要设置成get_user_info,add_t
        scope = "all";
        loginListener = new IUiListener() {
            @Override
            public void onError(UiError arg0) {

            }

            @Override
            public void onComplete(Object value) {

                System.out.println("有数据返回..");
                if (value == null) {
                    return;
                }
                try {
                    JSONObject jo = (JSONObject) value;

                    int ret = jo.getInt("ret");

                    System.out.println("json=" + String.valueOf(jo));

                    if (ret == 0) {
                        Toast.makeText(getActivity(), "登录成功",
                                Toast.LENGTH_LONG).show();
                        String openID = jo.getString("openid");
                        String accessToken = jo.getString("access_token");
                        String expires = jo.getString("expires_in");
                        mTencent.setOpenId(openID);
                        mTencent.setAccessToken(accessToken, expires);
                    }

                } catch (Exception e) {
                }
            }

            @Override
            public void onCancel() {
            }
        };
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constants.REQUEST_LOGIN) {
            if (resultCode == -1) {
                Tencent.onActivityResultData(requestCode, resultCode, data, loginListener);
                Tencent.handleResultData(data, loginListener);
                UserInfo info = new UserInfo(getActivity(), mTencent.getQQToken());
                info.getUserInfo(new IUiListener() {
                    @Override
                    public void onComplete(Object o) {
                        try {
                            JSONObject info = (JSONObject) o;
                            String nickName = info.getString("nickname");//获取用户昵称
                            //获取用户头像的url
                            String iconUrl = info.getString("figureurl_qq_2");
                            login_name.setText(nickName);
                            //Toast.makeText(getActivity(), "昵称：" + nickName, Toast.LENGTH_SHORT).show();
                            //进行修改头像
                            setHide(iconUrl);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(UiError uiError) {
                    }

                    @Override
                    public void onCancel() {
                    }
                });
            }
        }
    }

    private void setHide(String url) {
        qq.setVisibility(View.INVISIBLE);
        wexin.setVisibility(View.INVISIBLE);
        webo.setVisibility(View.INVISIBLE);
        loginFrag_headImage.setVisibility(View.VISIBLE);
        ImageLoader.getInstance().displayImage(url, loginFrag_headImage);
    }

    private void mSetImage() {
        qq.setImageResource(App.resourceMap.get("qq"));
        wexin.setImageResource(App.resourceMap.get("weixin"));
        webo.setImageResource(App.resourceMap.get("webo"));
        shouChang.setImageResource(App.resourceMap.get("shouChang"));
        liShi.setImageResource(App.resourceMap.get("liShi"));
        yeJian.setImageResource(App.resourceMap.get("yeJian"));
    }
}
