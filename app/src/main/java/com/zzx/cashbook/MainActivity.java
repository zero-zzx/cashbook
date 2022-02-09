package com.zzx.cashbook;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.zzx.cashbook.adapters.AccountListAdapter;
import com.zzx.cashbook.beans.AccountBean;
import com.zzx.cashbook.daos.DBManager;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView imageView;
    ListView lv;
    List<AccountBean> list;
    AccountListAdapter adapter;

    Button record,about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView=findViewById(R.id.main_search);
        lv=findViewById(R.id.main_lv);
        record=findViewById(R.id.main_record);
        about=findViewById(R.id.main_about);

        initView();

        initLogic();
    }

    @Override
    protected void onResume() {
        super.onResume();
        list.clear();
        list.addAll(DBManager.selectFromAccountTable());
        adapter.notifyDataSetChanged();
    }

    private void initView() {
        list= DBManager.selectFromAccountTable();
        adapter=new AccountListAdapter(list,this);
        lv.setAdapter(adapter);
    }

    private void initLogic() {
        imageView.setOnClickListener(this);
        record.setOnClickListener(this);
        about.setOnClickListener(this);

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                AccountBean bean=list.get(i);

                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("提示").setMessage("主人，你真的要删除这条内容吗？喵~").setNegativeButton("取消",null)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                DBManager.deleteFromAccountTble(bean.getId());

                                list.remove(bean);
                                adapter.notifyDataSetChanged();
                            }
                        });
                builder.create().show();
                return false;
            }
        });
    }

    @Override
    public void onClick(View view) {
        Intent it=null;
        switch(view.getId()){
            case R.id.main_search:
                it=new Intent(this,SearchActivity.class);
                break;
            case R.id.main_record:
                it=new Intent(this,RecordActivity.class);
                break;
            case R.id.main_about:
                it=new Intent(this,AboutActivity.class);
                break;
            default:
                break;
        }
        startActivity(it);
    }
}