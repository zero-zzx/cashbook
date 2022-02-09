package com.zzx.cashbook;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.zzx.cashbook.adapters.RecordPagerAdapter;
import com.zzx.cashbook.fragments.IncomeRecordFragment;
import com.zzx.cashbook.fragments.OutcomeRecordFragment;

import java.util.ArrayList;
import java.util.List;

public class RecordActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView imageView;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        imageView=findViewById(R.id.record_back);
        tabLayout=findViewById(R.id.record_tab);
        viewPager=findViewById(R.id.record_vp);

        initView();

        initLogic();

    }

    private void initView() {
        List<Fragment> list=new ArrayList<>();
        list.add(new OutcomeRecordFragment());
        list.add(new IncomeRecordFragment());

        RecordPagerAdapter adapter=new RecordPagerAdapter(getSupportFragmentManager(),list);

        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
    }

    private void initLogic() {
        imageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.record_back:
                finish();
                break;
            default:
                break;
        }

    }
}
