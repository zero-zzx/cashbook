package com.zzx.cashbook.daos;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.zzx.cashbook.beans.AccountBean;
import com.zzx.cashbook.beans.TypeBean;

import java.util.ArrayList;
import java.util.List;

public class DBManager {
    private static SQLiteDatabase db;

    public static void init(Context context){
        DBOpenHelper dbOpenHelper=new DBOpenHelper(context);
        db=dbOpenHelper.getWritableDatabase();
    }

    @SuppressLint("Range")
    public static List<TypeBean> getTypeList(int kind){
        List<TypeBean> list=new ArrayList<>();
        String sql="select * from typetb where kind="+kind;
        Cursor cursor = db.rawQuery(sql,null);

        while (cursor.moveToNext()){
            int id=cursor.getInt(cursor.getColumnIndex("id"));
            String typename=cursor.getString(cursor.getColumnIndex("typename"));
            int imageId=cursor.getInt(cursor.getColumnIndex("imageId"));
            int sImageId= cursor.getInt(cursor.getColumnIndex("sImageId"));

            list.add(new TypeBean(id,typename,imageId,sImageId,kind));
        }
        return list;
    }

    public static void addToAccountTable(AccountBean bean){
        ContentValues values=new ContentValues();
        values.put("typename",bean.getTypeName());
        values.put("sImageId",bean.getsImageId());
        values.put("note",bean.getNote());
        values.put("money",bean.getMoney());
        values.put("time",bean.getTime());
        values.put("kind",bean.getKind());
        db.insert("accounttb",null,values);
    }

    @SuppressLint("Range")
    public static List<AccountBean> selectFromAccountTable(){
        List<AccountBean> list=new ArrayList<>();
        String sql="select * from accounttb order by id desc";
        Cursor cursor=db.rawQuery(sql,null);
        while(cursor.moveToNext()){
            int id=cursor.getInt(cursor.getColumnIndex("id"));
            String typename=cursor.getString(cursor.getColumnIndex("typename"));
            int sImageId= cursor.getInt(cursor.getColumnIndex("sImageId"));
            int kind= cursor.getInt(cursor.getColumnIndex("kind"));
            float money= cursor.getFloat(cursor.getColumnIndex("money"));
            String note=cursor.getString(cursor.getColumnIndex("note"));
            String time=cursor.getString(cursor.getColumnIndex("time"));
            list.add(new AccountBean(id,typename,sImageId,kind,money,note,time));
        }

        return list;
    }

    @SuppressLint("Range")
    public static List<AccountBean> selectFromAccountTable(String str){
        List<AccountBean> list=new ArrayList<>();
        String sql="select * from accounttb where note like '%"+str+"%'";
        Cursor cursor=db.rawQuery(sql,null);
        while(cursor.moveToNext()){
            int id=cursor.getInt(cursor.getColumnIndex("id"));
            String typename=cursor.getString(cursor.getColumnIndex("typename"));
            int sImageId= cursor.getInt(cursor.getColumnIndex("sImageId"));
            int kind= cursor.getInt(cursor.getColumnIndex("kind"));
            float money= cursor.getFloat(cursor.getColumnIndex("money"));
            String note=cursor.getString(cursor.getColumnIndex("note"));
            String time=cursor.getString(cursor.getColumnIndex("time"));
            list.add(new AccountBean(id,typename,sImageId,kind,money,note,time));
        }

        return list;
    }

    public static void deleteFromAccountTble(int id){
        db.delete("accounttb","id=?",new String[]{id+""});
    }

}
