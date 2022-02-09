package com.zzx.cashbook;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener{
    ImageButton imageButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        imageButton=findViewById(R.id.about_back);

        initView();

        initLogic();

    }

    private void initView() {
    }

    private void initLogic() {
        imageButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.about_back:
                finish();
                break;
            default:
                break;
        }
    }
}
