package com.stolaine.applocker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private List<ResolveInfo> mApplications;
    private List<AppItem> mApplicationItems;
    private RecyclerView mRecyclerView;
    private AppListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getApplicationList();
        initializeListView();
    }

    void getApplicationList() {
        PackageManager pm = getApplicationContext().getPackageManager();
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        mApplications = pm.queryIntentActivities(mainIntent, 0);
        Log.i(TAG, "getApplicationList: number of main applications = " + mApplications.size());
        mApplicationItems = new ArrayList<>();
        for (ResolveInfo info : mApplications) {
            CharSequence appName = info.loadLabel(pm);
            AppItem appItem = new AppItem(appName.toString(), info.loadIcon(pm));
            mApplicationItems.add(appItem);
        }
        Collections.sort(mApplicationItems);
    }

    void initializeListView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mAdapter = new AppListAdapter(mApplicationItems);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }
}