package com.bwie.newstitleliyannew.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.newstitleliyannew.R;
import com.bwie.newstitleliyannew.bean.NewsContent;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * 类的用途：
 *
 * @author 李岩
 * @date ${date} ${time}
 * ${tags}
 */

public class HomeListAdapter extends BaseAdapter {
    private Context context;
    private List<NewsContent> list = new ArrayList<>();
    private int TYPE_1 = 0;
    private int TYPE_2 = 1;
    private int TYPE_3 = 2;
    private DisplayImageOptions options;

    public HomeListAdapter(Context context) {
        this.context = context;
        //设置imageloader
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
    public NewsContent getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemViewType(int position) {
        //多条目
        NewsContent item = getItem(position);
        if (item.getImgextra() != null && item.getImgsrc() != null && item.getTitle() != null) {
            return TYPE_3;
        } else if (item.getImgsrc() != null && item.getImgextra() == null) {
            return TYPE_2;
        } else if (item.getImgextra() == null && item.getImgsrc() == null) {
            return TYPE_1;
        }
        return TYPE_1;
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHoler1 viewHoler1 = null;
        ViewHoler2 viewHoler2 = null;
        ViewHoler3 viewHoler3 = null;
        if (view == null) {
            if (getItemViewType(i) == TYPE_3) {
                viewHoler3 = new ViewHoler3();
                view = LayoutInflater.from(context).inflate(R.layout.item3, null);
                viewHoler3.textView = (TextView) view.findViewById(R.id.item3_text_title);
                viewHoler3.image_one = (ImageView) view.findViewById(R.id.item3_imagelist1);
                viewHoler3.image_two = (ImageView) view.findViewById(R.id.item3_imagelist2);
                viewHoler3.image_three = (ImageView) view.findViewById(R.id.item3_imagelist3);
                viewHoler3.t1 = (TextView) view.findViewById(R.id.item3_text_source);
                viewHoler3.t2 = (TextView) view.findViewById(R.id.item3_text_comment_count);
                viewHoler3.t3 = (TextView) view.findViewById(R.id.item3_text_behot_time);
                view.setTag(viewHoler3);
            } else if (getItemViewType(i) == TYPE_2) {
                viewHoler2 = new ViewHoler2();
                view = LayoutInflater.from(context).inflate(R.layout.item2, null);
                viewHoler2.textview = (TextView) view.findViewById(R.id.item2_text_title);
                viewHoler2.iamge = (ImageView) view.findViewById(R.id.item2_middle_image);
                viewHoler2.t1 = (TextView) view.findViewById(R.id.item2_text_source);
                viewHoler2.t2 = (TextView) view.findViewById(R.id.item2_text_comment_count);
                viewHoler2.t3 = (TextView) view.findViewById(R.id.item2_text_behot_time);
                view.setTag(viewHoler2);
            } else {
                viewHoler1 = new ViewHoler1();
                view = LayoutInflater.from(context).inflate(R.layout.item1, null);
                viewHoler1.textview = (TextView) view.findViewById(R.id.item1_text_title);
                viewHoler1.t1 = (TextView) view.findViewById(R.id.item1_text_source);
                viewHoler1.t2 = (TextView) view.findViewById(R.id.item1_text_comment_count);
                viewHoler1.t3 = (TextView) view.findViewById(R.id.item1_text_behot_time);

                view.setTag(viewHoler1);
            }

        } else {
            if (getItemViewType(i) == TYPE_3) {
                viewHoler3 = (ViewHoler3) view.getTag();
            } else if (getItemViewType(i) == TYPE_2) {
                viewHoler2 = (ViewHoler2) view.getTag();
            } else {
                viewHoler1 = (ViewHoler1) view.getTag();
            }

        }
        if (getItemViewType(i) == TYPE_3) {
            viewHoler3.textView.setText(getItem(i).getTitle());
            viewHoler3.t1.setText(getItem(i).getSource());
            viewHoler3.t2.setText(getItem(i).getVotecount() + "条评论");
            viewHoler3.t3.setText(getItem(i).getPtime());
            ImageLoader.getInstance().displayImage(getItem(i).getImgextra().get(0).getImgsrc(), viewHoler3.image_one, options);
            ImageLoader.getInstance().displayImage(getItem(i).getImgextra().get(1).getImgsrc(), viewHoler3.image_two, options);
            ImageLoader.getInstance().displayImage(getItem(i).getImgsrc(), viewHoler3.image_three, options);
        } else if (getItemViewType(i) == TYPE_2) {
            viewHoler2.textview.setText(getItem(i).getTitle());
            viewHoler2.t1.setText(getItem(i).getSource());
            viewHoler2.t2.setText(getItem(i).getVotecount() + "条评论");
            viewHoler2.t3.setText(getItem(i).getPtime());
            String url = getItem(i).getImgsrc();
            ImageLoader.getInstance().displayImage(url, viewHoler2.iamge, options);
        } else {
            viewHoler1.textview.setText(getItem(i).getTitle());
            viewHoler1.t1.setText(getItem(i).getSource());
            viewHoler1.t2.setText(getItem(i).getVotecount() + "条评论");
            viewHoler1.t3.setText(getItem(i).getPtime());
        }
        return view;
    }

    class ViewHoler1 {
        TextView textview, t1, t2, t3;
    }

    class ViewHoler2 {
        TextView textview, t1, t2, t3;
        ImageView iamge;
    }

    class ViewHoler3 {
        TextView textView, t1, t2, t3;
        ImageView image_one, image_two, image_three;

    }

    public void addData(List<NewsContent> data, boolean isNeedClear) {
        if (data != null) {
            if (isNeedClear) {
                list.clear();
            }
            list.addAll(data);
        }
    }
}
