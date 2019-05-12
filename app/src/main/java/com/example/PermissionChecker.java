package com.example;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class PermissionChecker extends Thread {

    Activity activity;
    Context context;

    public PermissionChecker(Activity activity, Context context) {
        super();
        this.activity = activity;
        this.context = context;
    }

    public void run() {
        Log.d(TAG, "Mой поток запущен...");

        if(ActivityCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED){
            System.out.println("everything is OK! permission is garanted");
        } else {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        }

        if(ActivityCompat.checkSelfPermission(context, Manifest.permission.RECORD_AUDIO)== PackageManager.PERMISSION_GRANTED){
            System.out.println("everything is OK! permission for AUDIO record is garanted");
        } else {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.RECORD_AUDIO},1);
        }

        Log.d(TAG, "Mой поток заканчивает работу...");
    }
}
