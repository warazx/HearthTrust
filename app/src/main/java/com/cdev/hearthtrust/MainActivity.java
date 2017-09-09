package com.cdev.hearthtrust;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.cdev.hearthtrust.util.api.ApiHelper;
import com.cdev.hearthtrust.util.api.ApiUrl;
import com.cdev.hearthtrust.util.enums.HSClass;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private String[] classes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawer_layout);
        drawerList = findViewById(R.id.left_drawer);
        classes = getResources().getStringArray(R.array.Classes);

        drawerList.setAdapter(new ArrayAdapter<>(this,
                R.layout.drawer_list_item, classes));

        ApiHelper apiHelper = new ApiHelper(this);
        try {
            apiHelper.run(new ApiUrl().forClass(HSClass.HUNTER));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
