package com.cdev.hearthtrust.util.api;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.cdev.hearthtrust.R;
import com.cdev.hearthtrust.models.HsCard;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

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
            List<HsCard> cards;
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }



            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    Gson gson = new Gson();
                    Type listType = new TypeToken<List<HsCard>>(){}.getType();
                    cards = gson.fromJson(response.body().string(), listType);
                    Log.d("TEST", cards.toString());



                    //HsCardResponse[] hsCardResponse = HsCardResponse.parseJSON(response.body().string());
                    //Log.d("TAG", "" + hsCardResponse);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        ListView listView = ((Activity)context).findViewById(R.id.card_list);
                        listView.setAdapter(new ArrayAdapter<>(context, R.layout.card_list_item, cards));
                    }
                });
            }
        });
    }
}
