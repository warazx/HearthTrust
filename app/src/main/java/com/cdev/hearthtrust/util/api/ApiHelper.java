package com.cdev.hearthtrust.util.api;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.TextView;

import com.cdev.hearthtrust.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ApiHelper {
    private OkHttpClient client = new OkHttpClient();
    private String mashapeHeader, mashapeKey;
    private Context context;
    private Handler handler = new Handler(Looper.getMainLooper());

    public ApiHelper(Context context) {
        this.context = context;
        mashapeHeader = context.getResources().getString(R.string.MashapeHead);
        mashapeKey = context.getResources().getString(R.string.MashapeKey);
    }

    public void run(String url) throws IOException {
        final Request request = new Request.Builder()
                .header(mashapeHeader, mashapeKey)
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        TextView textView = ((Activity)context).findViewById(R.id.content_text);
                        textView.setText(string);
                    }
                });
            }
        });
    }
}
