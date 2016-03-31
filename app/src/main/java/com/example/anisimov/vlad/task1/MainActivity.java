package com.example.anisimov.vlad.task1;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Integer> mImageIds;
    private RecyclerView mRecycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(getString(R.string.app_title));
        }
        mRecycleView = (RecyclerView) findViewById(R.id.recycle_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecycleView.setLayoutManager(linearLayoutManager);
        mImageIds = new ArrayList<>();
        mImageIds.add(R.drawable.ph2);
        mImageIds.add(R.drawable.ph1);
        RVAdapter adapter = new RVAdapter(mImageIds);
        mRecycleView.setAdapter(adapter);
    }

    public void pushToast(View v) {
        String message = (v.getClass().getName().equals("android.support.v7.widget.AppCompatTextView")) ? "You touched TextView" : "You touched ImageView"; //Using ternary expression as advised
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int mId = item.getItemId();
        if (mId == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


}

