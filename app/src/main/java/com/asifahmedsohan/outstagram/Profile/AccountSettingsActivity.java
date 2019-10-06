package com.asifahmedsohan.outstagram.Profile;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.asifahmedsohan.outstagram.R;
import com.asifahmedsohan.outstagram.Utils.SectionStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by sohan on 05,October,2019
 */
public class AccountSettingsActivity extends AppCompatActivity {

    private static final String TAG = "AccountSettingsActivity";
    private Context mContext;

    private SectionStatePagerAdapter pagerAdapter;
    private ViewPager mViewpager;
    private RelativeLayout mRelativeLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountsettings);
        mContext = AccountSettingsActivity.this;
        Log.d(TAG, "onCreate: Started");
        mViewpager = (ViewPager)findViewById(R.id.container);
        mRelativeLayout = (RelativeLayout)findViewById(R.id.relLayout1);

        setUpSettigngsList();
        setupFragments();

        //set up back arrow for navigating back to profile
        ImageView backArrow = (ImageView)findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Navigating back to profile activity");
                finish();
            }
        });
    }

    private void setupFragments(){

        pagerAdapter = new SectionStatePagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new EditProfileFragment(), getString(R.string.edit_profile_fragment));
        pagerAdapter.addFragment(new SignOutFragment(), getString(R.string.sign_out_fragment));

    }

    private void setViewpager(int fragmentNumber){
        mRelativeLayout.setVisibility(View.GONE);
        Log.d(TAG, "setmViewpager: Navigating to fragment number " + fragmentNumber);
        mViewpager.setAdapter(pagerAdapter);
        mViewpager.setCurrentItem(fragmentNumber);

    }

    private void setUpSettigngsList(){

        Log.d(TAG, "setUpSettigngsList: initializing account setting list");

        ListView listView = (ListView)findViewById(R.id.lvAccountSettings);

        ArrayList <String> options = new ArrayList<>();
        options.add(getString(R.string.edit_profile_fragment));
        options.add(getString(R.string.sign_out_fragment));

        ArrayAdapter adapter = new ArrayAdapter(mContext, android.R.layout.simple_list_item_1, options);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(TAG, "onItemClick: navigating to fragment" + i);
                setViewpager(i);
            }
        });
    }
}
