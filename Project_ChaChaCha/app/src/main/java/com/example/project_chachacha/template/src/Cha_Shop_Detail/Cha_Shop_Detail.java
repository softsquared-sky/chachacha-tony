package com.example.project_chachacha.template.src.Cha_Shop_Detail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.project_chachacha.R;
import com.example.project_chachacha.template.src.BaseActivity;
import com.example.project_chachacha.template.src.ShopInfo.ShopInfo;

public class Cha_Shop_Detail extends BaseActivity {

    private Button review;

    private ImageView mivmoreinfo;
    private ImageView mivstar;
    boolean like = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cha__shop__detail);

        review=findViewById(R.id.goto_review);
        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cha_Shop_Detail.this, WriteReview.class);
                startActivity(intent);
            }
        });

        mivmoreinfo = findViewById(R.id.moreinfo);
        mivmoreinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cha_Shop_Detail.this, ShopInfo.class);
                startActivity(intent);
            }
        });

        mivstar = findViewById(R.id.star);
        mivstar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(like==false){
                    mivstar.setImageResource(R.drawable.ic_yellow_star);
                    like = true;
                }
                else{
                    mivstar.setImageResource(R.drawable.ic_empty_star);
                    like = false;
                }
            }
        });
    }
}
