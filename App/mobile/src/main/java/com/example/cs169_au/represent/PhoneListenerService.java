package com.example.cs169_au.represent;

/**
 * Created by cs169-au on 3/5/16.
 */
import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.WearableListenerService;

import java.nio.charset.StandardCharsets;

/**
 */
public class PhoneListenerService extends WearableListenerService {

    //   WearableListenerServices don't need an iBinder or an onStartCommand: they just need an onMessageReceieved.
    private static final String TOAST = "/send_congressman";

    @Override
    public void onMessageReceived(MessageEvent messageEvent) {
        Log.d("T", "in PhoneListenerService, got: " + messageEvent.getPath());
        String name = new String(messageEvent.getData(), StandardCharsets.UTF_8);

        Intent newIntent;

        if (name.equals("Sandy")) {
            newIntent = new Intent(this, Detailed.class);
            startActivity(newIntent);
        } else if (name.equals("Chinton")) {
            newIntent = new Intent(this, DetailChinton.class);
            startActivity(newIntent);
        } else if (name.equals("Rump")) {
            newIntent = new Intent(this, Detailed.class);
            startActivity(newIntent);
        }

        // so you may notice this crashes the phone because it's
        //''sending message to a Handler on a dead thread''... that's okay. but don't do this.
        // replace sending a toast with, like, starting a new activity or something.
        // who said skeleton code is untouchable? #breakCSconceptions

    }

}