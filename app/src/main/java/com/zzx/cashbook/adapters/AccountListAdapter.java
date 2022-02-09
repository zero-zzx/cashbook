package com.zzx.cashbook.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zzx.cashbook.R;
import com.zzx.cashbook.beans.AccountBean;

import java.util.List;

public class AccountListAdapter extends BaseAdapter {
    List<AccountBean> list;
    Context context;

    public AccountListAdapter(List<AccountBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view= LayoutInflater.from(context).inflate(R.layout.activity_main_lv,viewGroup,false);
        AccountBean bean=list.get(i);
        ImageView imageView=view.findViewById(R.id.main_lv_iv);
        TextView typename,note,money,time;
        typename=view.findViewById(R.id.main_lv_typename);
        note=view.findViewById(R.id.main_lv_note);
        money=view.findViewById(R.id.main_lv_money);
        time=view.findViewById(R.id.main_lv_time);


        imageView.setImageResource(bean.getsImageId());
        typename.setText(bean.getTypeName());
        note.setText(bean.getNote());
        money.setText("¥ "+bean.getMoney());
        time.setText(bean.getTime());

        return view;
    }
}
