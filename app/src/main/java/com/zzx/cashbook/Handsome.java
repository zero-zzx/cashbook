package com.zzx.cashbook;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.zzx.cashbook.daos.DBManager;

public class Handsome extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DBManager.init(this);
    }
}
