package com.zzx.cashbook.fragments;

import com.zzx.cashbook.R;

public class IncomeRecordFragment extends BaseRecordFragment {
    @Override
    protected void initItemView() {
        bean.setsImageId(R.mipmap.in_qt_fs);
        bean.setTypeName("其他");
    }

    @Override
    public int getKind() {
        return 1;
    }
}
