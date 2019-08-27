package com.example.project_chachacha.template.src.Shopdetatil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.project_chachacha.R;
import com.example.project_chachacha.template.src.BaseActivity;
import com.example.project_chachacha.template.src.ShopInfo.ShopInfo;

public class ShopDetail extends BaseActivity {

    private ImageView mivmoreinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_detail);

        mivmoreinfo = findViewById(R.id.moreinfo);
        mivmoreinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShopDetail.this, ShopInfo.class);
                startActivity(intent);
            }
        });
    }
}
