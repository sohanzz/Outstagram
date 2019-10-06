package com.asifahmedsohan.outstagram.Profile;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.asifahmedsohan.outstagram.R;

import java.util.ArrayList;

/**
 * Created by sohan on 05,October,2019
 */
public class AccountSettingsActivity extends AppCompatActivity {

    private static final String TAG = "AccountSettingsActivity";
    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountsettings);
        mContext = AccountSettingsActivity.this;
        Log.d(TAG, "onCreate: Started");

        setUpSettigngsList();
    }

    private void setUpSettigngsList(){

        Log.d(TAG, "setUpSettigngsList: initializing account setting list");

        ListView listView = (ListView)findViewById(R.id.lvAccountSettings);

        ArrayList <String> options = new ArrayList<>();
        options.add(getString(R.string.edit_profile));
        options.add(getString(R.string.sign_out));

        ArrayAdapter adapter = new ArrayAdapter(mContext, android.R.layout.simple_list_item_1, options);
        listView.setAdapter(adapter);
    }
}
