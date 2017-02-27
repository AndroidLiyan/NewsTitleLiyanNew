package com.bwie.newstitleliyannew.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.newstitleliyannew.R;
import com.bwie.newstitleliyannew.bean.NewsContent;
import com.bwie.newstitleliyannew.bean.VideoContent;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;


/**
 * 类的用途：
 *
 * @author 李岩
 * @date ${date} ${time}
 * ${tags}
 */

public class VideoListAdapter extends BaseAdapter {
    private Context context;
    private List<VideoContent> list = new ArrayList<>();
    private DisplayImageOptions options;

    public VideoListAdapter(Context context) {
        this.context = context;
        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.ic_ss_loading)
                .showImageForEmptyUri(R.mipmap.profile_bg)
                .showImageOnFail(R.mipmap.big_loadpic_full_listpage)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                //.displayer(new CircleBitmapDisplayer(Color.WHITE, 5))
                .build();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public VideoContent getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder v = null;
        if (view == null) {
            v = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.video_item, null);
            v.jc = (JCVideoPlayer) view.findViewById(R.id.jicao);
            v.image = (ImageView) view.findViewById(R.id.video_item_image);
            v.textView = (TextView) view.findViewById(R.id.video_item_text);
            view.setTag(v);
        } else {
            v = (ViewHolder) view.getTag();
        }
        v.jc.setUp(getItem(i).getMp4_url(), getItem(i).getTitle());
        ImageLoader.getInstance().displayImage(getItem(i).getCover(), v.jc.ivThumb);
        if (getItem(i).getVideoTopic() != null) {
            ImageLoader.getInstance().displayImage(getItem(i).getVideoTopic().getTopic_icons(), v.image, options);
            v.textView.setText(getItem(i).getVideoTopic().getTname());
        }

        return view;
    }

    class ViewHolder {
        JCVideoPlayer jc;
        ImageView image;
        TextView textView;
    }

    public void addData(List<VideoContent> data, boolean IsNeedClear) {
        if (IsNeedClear) {
            list.clear();
        }
        list.addAll(data);
    }
}
