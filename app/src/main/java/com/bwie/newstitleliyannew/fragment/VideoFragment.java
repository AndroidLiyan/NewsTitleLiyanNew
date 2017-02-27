package com.bwie.newstitleliyannew.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.newstitleliyannew.R;
import com.bwie.newstitleliyannew.adapter.TabAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 类的用途：
 *
 * @author 李岩
 * @date ${date} ${time}
 * ${tags}
 */

public class VideoFragment extends Fragment {

    private View view;
    private TabLayout video_tablayout;
    private ViewPager video_viewpager;
    private String [] title = {"热点视频","娱乐视频","搞笑视频","精品视频"};
    private String [] id = {"V9LG4B3A0","V9LG4CHOR","V9LG4E6VR","00850FRB"};
    private List<Fragment> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.video_layout, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initData();
    }

    private void initView(){
        video_tablayout = (TabLayout) view.findViewById(R.id.video_tablayout);
        video_viewpager = (ViewPager) view.findViewById(R.id.video_viewpager);
    }
    private void initData() {
        for (int i = 0; i < title.length ; i++) {
            PlayFragment playFragment = new PlayFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id",id[i]);
            playFragment.setArguments(bundle);
            list.add(playFragment);
        }
        TabAdapter adapter = new TabAdapter(getFragmentManager(), getActivity(), title, list);
        video_viewpager.setAdapter(adapter);
        video_tablayout.setupWithViewPager(video_viewpager);
        video_tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }
}
