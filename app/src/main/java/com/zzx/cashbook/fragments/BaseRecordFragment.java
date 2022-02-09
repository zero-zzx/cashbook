package com.zzx.cashbook.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.zzx.cashbook.R;
import com.zzx.cashbook.adapters.RecordGVAdapter;
import com.zzx.cashbook.beans.AccountBean;
import com.zzx.cashbook.beans.TypeBean;
import com.zzx.cashbook.daos.DBManager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class BaseRecordFragment extends Fragment implements View.OnClickListener{
    GridView gv;
    List<TypeBean> list;
    RecordGVAdapter adapter;

    EditText money,note;
    TextView time;
    Button ensure;

    AccountBean bean;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bean=new AccountBean();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_income,container,false);
        gv=view.findViewById(R.id.frag_income_gv);
        money=view.findViewById(R.id.frag_income_tv_money);
        note=view.findViewById(R.id.frag_income_note);
        time=view.findViewById(R.id.frag_income_time);
        ensure=view.findViewById(R.id.frag_income_ensure);

        initView();

        initLogic();

        return view;
    }

    private void initView() {
        initItemView();
        list = DBManager.getTypeList(getKind());
        adapter=new RecordGVAdapter(list,getContext());
        gv.setAdapter(adapter);

        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        String now=simpleDateFormat.format(date);
        time.setText(now);
        bean.setTime(now);
    }

    protected abstract void initItemView();

    public abstract int getKind();

    private void initLogic() {
        bean.setKind(getKind());
        ensure.setOnClickListener(this);

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                adapter.setPos(i);
                adapter.notifyDataSetInvalidated();

                TypeBean typeBean=list.get(i);
                bean.setsImageId(typeBean.getsImageId());
                bean.setTypeName(typeBean.getTypename());
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.frag_income_ensure:
                String moneyStr=money.getText().toString();
                if("".equals(moneyStr)||"0".equals(moneyStr)){
                    getActivity().finish();
                }
                bean.setMoney(Float.parseFloat(moneyStr));
                bean.setNote(note.getText().toString());
                DBManager.addToAccountTable(bean);

                getActivity().finish();
                break;
            default:
                break;
        }
    }
}
