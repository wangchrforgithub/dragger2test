package com.example.administrator.myapplicationdragger2.present;

import android.content.Context;

import com.example.administrator.myapplicationdragger2.R;

/**
 * Created by administrator on 17/1/23.
 */

public class APresent {
    private Context mContext;

    public APresent(Context context) {
        mContext = context;
    }

    public String getAppName() {
        return mContext.getString(R.string.app_name);
    }
}
