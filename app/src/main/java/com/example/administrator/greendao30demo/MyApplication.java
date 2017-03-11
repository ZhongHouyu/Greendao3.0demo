package com.example.administrator.greendao30demo;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.anye.greendao.gen.DaoMaster;
import com.anye.greendao.gen.DaoSession;

/**
 * Created by Administrator on 2017/3/11.
 */

public class MyApplication extends Application{
    private DaoMaster.DevOpenHelper mhelper;
    private SQLiteDatabase db;
    private DaoMaster mDaomaster;
    private DaoSession mDaoSession;
    public static MyApplication instance;
    @Override
    public void onCreate(){
        super.onCreate();
        instance = this;
        setDatabase();
    }
    public static MyApplication getInstance(){
        return instance;
    }
    private void setDatabase(){
        mhelper = new DaoMaster.DevOpenHelper(this,"notes-db",null);
        db = mhelper.getWritableDatabase();
        mDaomaster = new DaoMaster(db);
        mDaoSession = mDaomaster.newSession();
    }
    public DaoSession getmDaoSession(){
        return mDaoSession;
    }
    public SQLiteDatabase getDb(){
        return db;
    }
}
