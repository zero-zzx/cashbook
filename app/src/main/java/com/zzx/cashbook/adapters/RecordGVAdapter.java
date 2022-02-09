package com.zzx.cashbook.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zzx.cashbook.R;
import com.zzx.cashbook.beans.TypeBean;

import java.util.List;

public class RecordGVAdapter extends BaseAdapter {
    List<TypeBean> list;
    Context context;
    int position;

    public RecordGVAdapter(List<TypeBean> list, Context context) {
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
        view = LayoutInflater.from(context).inflate(R.layout.fragment_income_gv_item,viewGroup,false);
        TypeBean bean=list.get(i);
        ImageView imageView=view.findViewById(R.id.record_frag_gv_iv);
        TextView textView=view.findViewById(R.id.record_frag_gv_tv);

        textView.setText(bean.getTypename());

        if(i==position){
            imageView.setImageResource(bean.getsImageId());
        }else {
            imageView.setImageResource(bean.getImageId());
        }

        return view;
    }

    public void setPos(int i){
        position=i;
    }
}
