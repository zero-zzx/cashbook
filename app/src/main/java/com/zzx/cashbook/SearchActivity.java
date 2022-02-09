package com.zzx.cashbook;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.zzx.cashbook.adapters.AccountListAdapter;
import com.zzx.cashbook.beans.AccountBean;
import com.zzx.cashbook.daos.DBManager;

import java.util.ArrayList;
import java.util.List;


public class SearchActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView back,search;
    EditText editText;

    ListView lv;
    List<AccountBean> list;
    AccountListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        back=findViewById(R.id.search_back);
        search=findViewById(R.id.search_show);
        editText=findViewById(R.id.search_et);
        lv=findViewById(R.id.search_lv);

        initView();

        initLogic();

    }

    private void initView() {
    }

    private void initLogic() {
        back.setOnClickListener(this);
        search.setOnClickListener(this);

        list=new ArrayList<>();
        adapter=new AccountListAdapter(list,this);
        lv.setAdapter(adapter);

        lv.setEmptyView(findViewById(R.id.search_tv_empty));

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.search_back:
                finish();
                break;
            case R.id.search_show:
                String str=editText.getText().toString().trim();
                if("".equals(str)||str.isEmpty()){
                    Toast.makeText(this,"输入内容为空！",Toast.LENGTH_SHORT).show();
                    return;
                }
                list.clear();
                list.addAll(DBManager.selectFromAccountTable(str));
                adapter.notifyDataSetChanged();
                break;
            default:
                break;
        }

    }
}
