package com.example.project_chachacha.template.src.ShopInfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project_chachacha.R;
import com.example.project_chachacha.template.src.BaseActivity;
import com.example.project_chachacha.template.src.Mypage.Mypage_main;

public class ShopInfo extends BaseActivity {

    private ImageView mivstar;
    boolean like = false;
    private TextView mbtn_menu, mbtn_review;
    private View line1,line2;

    private FragmentManager fragmentManager;
    private Menu menu;
    private Review review;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_info);

        mbtn_menu = findViewById(R.id.btn_menu);
        mbtn_review = findViewById(R.id.btn_review);
        line1 = findViewById(R.id.menuview);
        line2 = findViewById(R.id.reviewview);

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

        menu = new Menu();
        review = new Review();

        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_view,menu).commitAllowingStateLoss();

        mbtn_menu.setPressed(true);
        mbtn_menu.setSelected(true);
        line1.setPressed(true);
        line1.setSelected(true);
    }

    public void menuClick(View v){

        transaction = fragmentManager.beginTransaction();

        switch (v.getId()){
            case R.id.btn_menu:
                mbtn_menu.setPressed(true);
                mbtn_menu.setSelected(true);
                mbtn_review.setPressed(false);
                mbtn_review.setSelected(false);
                line1.setPressed(true);
                line1.setSelected(true);
                line2.setPressed(false);
                line2.setSelected(false);
                transaction.replace(R.id.fragment_view,menu).commitAllowingStateLoss();
                break;
            case R.id.btn_review:
                mbtn_review.setPressed(true);
                mbtn_review.setSelected(true);
                mbtn_menu.setPressed(false);
                mbtn_menu.setSelected(false);
                line2.setPressed(true);
                line2.setSelected(true);
                line1.setPressed(false);
                line1.setSelected(false);
                transaction.replace(R.id.fragment_view,review).commitAllowingStateLoss();
                break;

        }
    }
}
