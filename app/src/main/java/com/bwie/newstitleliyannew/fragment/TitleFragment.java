package com.bwie.newstitleliyannew.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.bwie.newstitleliyannew.R;
import com.bwie.newstitleliyannew.activity.WebviewActivity;
import com.bwie.newstitleliyannew.adapter.HomeListAdapter;
import com.bwie.newstitleliyannew.bean.NewsContent;
import com.bwie.newstitleliyannew.utils.NetUtils;
import com.bwie.newstitleliyannew.utils.UrlUtils;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.List;

/**
 * 类的用途：
 *
 * @author 李岩
 * @date ${date} ${time}
 * ${tags}
 */

public class TitleFragment extends Fragment implements PullToRefreshBase.OnRefreshListener2 {

    private View view;
    private PullToRefreshListView pulltorefresh;
    private String id;
    private int currentpage = 0;
    private HomeListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.title_layout, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = getArguments();
        id = bundle.getString("id");
        initview();
        initData(false);
        pulltorefresh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(getActivity(), WebviewActivity.class);
                String url_3w = adapter.getItem(i).getUrl_3w();
                it.putExtra("url", url_3w);
                startActivity(it);
            }
        });
    }

    private void initview() {
        pulltorefresh = (PullToRefreshListView) view.findViewById(R.id.pulltorefresh);
        pulltorefresh.setMode(PullToRefreshBase.Mode.BOTH);
        pulltorefresh.setOnRefreshListener(this);
        adapter = new HomeListAdapter(getActivity());
        pulltorefresh.setAdapter(adapter);
    }

    private void initData(final boolean isNeedClear) {
        String url = UrlUtils.geturl(id, currentpage);
        NetUtils.loadNetData(url, NewsContent.class, new NetUtils.CallbackData() {
            @Override
            public void success(final List list) {
                adapter.addData(list, isNeedClear);
                adapter.notifyDataSetChanged();
                pulltorefresh.onRefreshComplete();
            }
        }, getActivity(), view);
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        currentpage = 0;
        initData(true);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        currentpage += 20;
        initData(false);
        ;
    }
}
