package com.bwie.newstitleliyannew.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.newstitleliyannew.R;
import com.bwie.newstitleliyannew.adapter.VideoListAdapter;
import com.bwie.newstitleliyannew.bean.NewsContent;
import com.bwie.newstitleliyannew.bean.VideoContent;
import com.bwie.newstitleliyannew.utils.NetUtils;
import com.bwie.newstitleliyannew.utils.UrlUtils;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * 类的用途：
 *
 * @author 李岩
 * @date ${date} ${time}
 * ${tags}
 */

public class PlayFragment extends Fragment implements PullToRefreshBase.OnRefreshListener2 {

    private View view;
    private PullToRefreshListView pulltorefresh_video;
    private String id;
    private int currentpage = 0;
    private VideoListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.play_layout, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        id = bundle.getString("id");
        initview();
        initData(false);
    }

    private void initview() {
        pulltorefresh_video = (PullToRefreshListView) view.findViewById(R.id.pulltorefresh_video);
        adapter = new VideoListAdapter(getActivity());
        pulltorefresh_video.setAdapter(adapter);
        pulltorefresh_video.setMode(PullToRefreshBase.Mode.BOTH);
        pulltorefresh_video.setOnRefreshListener(this);
    }

    private void initData(final boolean IsNeedClear) {
        String url = UrlUtils.geturlVideo(id, currentpage);
        NetUtils.loadNetData(url, VideoContent.class, new NetUtils.CallbackData() {
            @Override
            public void success(List list) {
                adapter.addData(list, IsNeedClear);
                adapter.notifyDataSetChanged();
                pulltorefresh_video.onRefreshComplete();
            }
        },getActivity(),view);
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        currentpage = 0;
        initData(true);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        currentpage += 10;
        initData(false);
    }

    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
}
