package com.kstransfter.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.kstransfter.R;

public class OtpActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        try {
            initial();
          } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initial() {

    }


}