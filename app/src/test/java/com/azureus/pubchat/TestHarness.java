package com.azureus.pubchat;

import com.pubnub.api.PNConfiguration;

class TestHarness {

    private static final String SUB_KEY = "demo";
    private static final String PUB_KEY = "demo";

    PNConfiguration getPnConfiguration() {
        PNConfiguration pnConfiguration = new PNConfiguration();
        pnConfiguration.setSubscribeKey(SUB_KEY);
        pnConfiguration.setPublishKey(PUB_KEY);
        pnConfiguration.setUuid("andrtest19");
        return pnConfiguration;
    }

}
