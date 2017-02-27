package com.bwie.newstitleliyannew.utils;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bwie.newstitleliyannew.R;
import com.bwie.newstitleliyannew.bean.NewsContent;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 类的用途：
 *
 * @author 李岩
 * @date ${date} ${time}
 * ${tags}
 */

public class NetUtils {
    public static <T> void loadNetData(String url, final Class<T> clazz, final CallbackData callbackData, final Context context, final View view) {
        x.http().get(new RequestParams(url), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                List<T> list = new ArrayList<T>();
                try {
                    JSONObject obj = new JSONObject(result);
                    Iterator<String> keys = obj.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        JSONArray array = obj.optJSONArray(next);
                        for (int i = 0; i < array.length(); i++) {
                            JSONObject object = array.optJSONObject(i);
                            T newsContent = gson.fromJson(object.toString(), clazz);
                            list.add(newsContent);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                callbackData.success(list);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                int netWorkType = IsNetUtils.getNetWorkType(context);
                if (netWorkType == 0) {
                    Toast.makeText(context, "您没有网络！", Toast.LENGTH_SHORT).show();
                    view.findViewById(R.id.title_net).setBackgroundResource(R.mipmap.neterror);
                    view.findViewById(R.id.title_net).setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                int netWorkType = IsNetUtils.getNetWorkType(context);
                if (netWorkType == 1) {
                    Toast.makeText(context, "wap网络！", Toast.LENGTH_SHORT).show();
                    view.findViewById(R.id.title_net).setVisibility(View.INVISIBLE);
                } else if (netWorkType == 2) {
                    Toast.makeText(context, "2G网络！", Toast.LENGTH_SHORT).show();
                    view.findViewById(R.id.title_net).setVisibility(View.INVISIBLE);
                } else if (netWorkType == 3) {
                    Toast.makeText(context, "4G网络！", Toast.LENGTH_SHORT).show();
                    view.findViewById(R.id.title_net).setVisibility(View.INVISIBLE);
                } else if (netWorkType == 4) {
                    Toast.makeText(context, "wifi网络！", Toast.LENGTH_SHORT).show();
                    view.findViewById(R.id.title_net).setVisibility(View.INVISIBLE);
                }

            }
        });

    }

    public interface CallbackData<T> {
        void success(List<T> newsContents);
    }
}
