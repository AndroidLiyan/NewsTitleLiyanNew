package com.bwie.newstitleliyannew.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwie.newstitleliyannew.R;

/**
 * 类的用途：
 *
 * @author 李岩
 * @date ${date} ${time}
 * ${tags}
 */

public class MyCustomTitleBar extends RelativeLayout {

    private Button titlebar_btn;
    private TextView titlebar_title;
    private ImageView titlebar_image;

    public MyCustomTitleBar(Context context) {
        super(context);
    }

    public MyCustomTitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.title_bar_layout, this);
        titlebar_btn = (Button) view.findViewById(R.id.titlebar_btn);
        titlebar_title = (TextView) view.findViewById(R.id.titlebar_title);
        titlebar_image = (ImageView) view.findViewById(R.id.titlebar_image);
        TypedArray typedArray = context.getResources().obtainAttributes(attrs, R.styleable.Titlesbar);
        if (typedArray != null) {
            Drawable drawable = typedArray.getDrawable(R.styleable.Titlesbar_titlebar_btn_image);
            titlebar_btn.setBackground(drawable);
            String title = typedArray.getString(R.styleable.Titlesbar_titlebar_title);
            titlebar_title.setText(title);
        }
        typedArray.recycle();
    }
    public void setbtnOnClickLister(OnClickListener listener){
        titlebar_btn.setOnClickListener(listener);
    }
    public void setTitlrText(String str){
        titlebar_title.setText(str);
    }
}
