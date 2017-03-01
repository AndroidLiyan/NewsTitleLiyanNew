package com.bwie.newstitleliyannew.activity;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bwie.newstitleliyannew.R;
import com.bwie.newstitleliyannew.custom.MyCustomTitleBar;

public class SetActivity extends BaseActivity {

    private MyCustomTitleBar set_titlebar;
    private TextView set_clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        set_titlebar = (MyCustomTitleBar) findViewById(R.id.set_titlebar);
        set_clear = (TextView) findViewById(R.id.set_clear);
        set_titlebar.setTitlrText("设置");
        set_titlebar.setbtnOnClickLister(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        findViewById(R.id.set_one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SetActivity.this);
                builder.setMessage("是否确认清楚？");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        set_clear.setText("0.0MB");
                    }
                });
                builder.show();
            }
        });
        findViewById(R.id.set_two).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mShowAlertDialog();
            }
        });
        findViewById(R.id.set_three).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mShowAlertDialog();
            }
        });
        findViewById(R.id.set_four).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mShowAlertDialog();
            }
        });
        findViewById(R.id.set_five).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mShowAlertDialog();
            }
        });
        findViewById(R.id.set_sex).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mShowAlertDialog();
            }
        });
        findViewById(R.id.set_seven).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mShowAlertDialog();
            }
        });
        findViewById(R.id.set_eight).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mShowAlertDialog();
            }
        });
        findViewById(R.id.set_nine).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mShowAlertDialog();
            }
        });
    }
    public void mShowAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(SetActivity.this);
        builder.setMessage("此功能暂未开发！");
        builder.setPositiveButton("确定",null);
        builder.show();
    }
}
