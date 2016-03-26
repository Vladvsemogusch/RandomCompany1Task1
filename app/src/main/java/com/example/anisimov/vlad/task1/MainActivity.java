package com.example.anisimov.vlad.task1;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

//[Comment] Wrong status bar color
//[Comment] Wrong toolbar color
public class MainActivity extends AppCompatActivity {
    private List<Integer> mImageIds;
    private RecyclerView mRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        ActionBar mAb = getSupportActionBar(); //[Comment] Use informative names. actionBar
        mAb.setDisplayHomeAsUpEnabled(true); //[Comment] Here you can catch NPE
        mAb.setTitle(getResources().getString(R.string.app_title));
        mRv = (RecyclerView) findViewById(R.id.rv);
        LinearLayoutManager mLlm = new LinearLayoutManager(this); //[Comment] It's local variable. Don't use "m" here
        mLlm.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRv.setLayoutManager(mLlm);
        mImageIds = new ArrayList<>(2); //[Comment] Bad practice. Why fixed size?
        mImageIds.add(R.drawable.ph2);
        mImageIds.add(R.drawable.ph1);
        RVAdapter mAdapter = new RVAdapter(mImageIds);
        mRv.setAdapter(mAdapter);

    }

    public void pushToast(View v){
        if(v.getClass().getName().equals("android.support.v7.widget.AppCompatTextView")){
            Toast.makeText(this,"You touched item with following content:\n" + ((TextView)v).getText(),Toast.LENGTH_LONG).show(); //[Comment] Wrong information. Please show control name
        }else{
            Toast.makeText(this,"You touched image",Toast.LENGTH_LONG).show(); //[Comment] Also you can use ternar expression
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu); //[Comment] You don't need this
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem mSettingsItem = menu.findItem(R.id.action_settings);
        mSettingsItem.setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int mId = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (mId == R.id.action_settings) {
            return true;
        }
        if (mId == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


}

