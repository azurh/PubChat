package com.azureus.pubchat;

import com.google.gson.JsonObject;
import com.pubnub.api.PubNub;
import com.pubnub.api.PubNubException;
import com.pubnub.api.models.consumer.PNPublishResult;
import com.pubnub.api.models.consumer.presence.PNSetStateResult;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ConnectToPubNubTest extends TestHarness {

    private PubNub pubnub;

    @Before
    public void beforeEach() {
        pubnub = new PubNub(getPnConfiguration());
    }

    @After
    public void afterEach() {
        pubnub.forceDestroy();
        pubnub = null;
    }

    @Test
    public void testUuid() {
        String uuid = UUID.randomUUID().toString();
        pubnub.getConfiguration().setUuid(uuid);
        assertEquals(uuid, pubnub.getConfiguration().getUuid());
    }

    @Test
    public void testUserMetadata() throws PubNubException {
        final JsonObject metadata = new JsonObject();
        metadata.addProperty("color", "red");

        PNSetStateResult result = pubnub.setPresenceState()
                .channels(Collections.singletonList(UUID.randomUUID().toString()))
                .state(metadata)
                .sync();
        assertNotNull(result);
        assertEquals(metadata, result.getState().getAsJsonObject());
    }

    @Test
    public void testPublish() throws PubNubException {

        JsonObject message = new JsonObject();
        message.addProperty("text", UUID.randomUUID().toString().substring(0, 5));

        PNPublishResult response = pubnub.publish()
                .channel("budapest2019")
                .message(message)
                .sync();

        assertNotNull(response);

    }

}
