package com.azureus.pubchat;

import android.os.Bundle;

import com.pubnub.api.PNConfiguration;
import com.pubnub.api.PubNub;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    PubNub mPubNub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initPubNub();
    }

    private void initPubNub() {
        PNConfiguration pnConfiguration = new PNConfiguration();
        pnConfiguration.setSubscribeKey("demo");
        pnConfiguration.setPublishKey("demo");
        pnConfiguration.setUuid("android_test");
        mPubNub = new PubNub(pnConfiguration);
    }
}
