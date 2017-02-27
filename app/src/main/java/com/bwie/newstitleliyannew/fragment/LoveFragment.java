package com.bwie.newstitleliyannew.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bwie.newstitleliyannew.R;
import com.bwie.newstitleliyannew.application.App;

/**
 * 类的用途：
 *
 * @author 李岩
 * @date ${date} ${time}
 * ${tags}
 */

public class LoveFragment extends Fragment {

    private View view;
    private ImageView friend_image;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.love_layout, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        friend_image = (ImageView) view.findViewById(R.id.friend_image);
        App.mChangeImage(App.Mode);
        mSetImage();
    }
    private void mSetImage(){
        friend_image.setImageResource(App.resourceMap.get("friend"));
    }
}
