package com.zzx.cashbook.fragments;

import com.zzx.cashbook.R;

public class OutcomeRecordFragment extends BaseRecordFragment {

    @Override
    protected void initItemView() {
        bean.setsImageId(R.mipmap.ic_qita_fs);
        bean.setTypeName("其他");
    }

    @Override
    public int getKind() {
        return 0;
    }
}
