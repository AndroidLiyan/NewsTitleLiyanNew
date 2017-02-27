package com.bwie.newstitleliyannew.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bwie.newstitleliyannew.R;
import com.bwie.newstitleliyannew.activity.ChannerActivity;
import com.bwie.newstitleliyannew.activity.MainActivity;
import com.bwie.newstitleliyannew.adapter.TabAdapter;
import com.bwie.newstitleliyannew.application.App;
import com.bwie.newstitleliyannew.utils.UrlUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 类的用途：
 *
 * @author 李岩
 * @date ${date} ${time}
 * ${tags}
 */

public class HomeFragment extends Fragment {

    private View view;
    private TabLayout home_tablayout;
    private ViewPager home_viewpager;
    //第二次做的时候，感觉在这里如果把title中的东西放在数据库中，或者在后台，然后还有与之相对应的接口在其中，这样的话就好多了
    private String[] title = {"足球", "笑话", "娱乐", "体育", "财经", "科技", "电影", "汽车"};
    private String[] id = {UrlUtils.FOOTBALL_ID, UrlUtils.JOKE_ID,
            UrlUtils.ENTERTAINMENT_ID, UrlUtils.SPORTS_ID,
            UrlUtils.FINANCE_ID, UrlUtils.TECH_ID, UrlUtils.MOVIE_ID, UrlUtils.CAR_ID};

    private List<Fragment> list = new ArrayList<>();
    private ImageView top, channer_image;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.home_layout, null);
        top = (ImageView) view.findViewById(R.id.loadpic);
        channer_image = (ImageView) view.findViewById(R.id.channer_image);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        App.mChangeImage(App.Mode);
        mSetImage();
        initView();
        initData();
    }

    private void initView() {
        home_tablayout = (TabLayout) view.findViewById(R.id.home_tablayout);
        home_viewpager = (ViewPager) view.findViewById(R.id.home_viewpager);
        channer_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getActivity(), ChannerActivity.class);
                startActivity(it);
            }
        });
    }

    private void initData() {
        list.clear();
        for (int i = 0; i < title.length; i++) {
            TitleFragment titleFragment = new TitleFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", id[i]);
            titleFragment.setArguments(bundle);
            list.add(titleFragment);
        }

        TabAdapter adapter = new TabAdapter(getFragmentManager(), getActivity(), title, list);
        home_viewpager.setAdapter(adapter);
//        home_viewpager.setOffscreenPageLimit(3);
        home_tablayout.setupWithViewPager(home_viewpager);
        home_tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    private void mSetImage() {
        top.setBackgroundResource(App.resourceMap.get("top"));
    }
}
