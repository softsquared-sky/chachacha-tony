package com.example.project_chachacha.template.src.Cha_Shop_Detail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.project_chachacha.R;
import com.example.project_chachacha.template.src.BaseActivity;

public class WriteReview extends BaseActivity {

    private ImageView star1,star2,star3,star4,star5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_review);

        star1 = findViewById(R.id.star1);
        star2 = findViewById(R.id.star2);
        star3 = findViewById(R.id.star3);
        star4 = findViewById(R.id.star4);
        star5 = findViewById(R.id.star5);
    }

    public void starClick(View view){
        switch (view.getId()){
            case R.id.star1:
                star1.setImageResource(R.drawable.ic_yellow_star);
                star2.setImageResource(R.drawable.ic_grey50);
                star3.setImageResource(R.drawable.ic_grey50);
                star4.setImageResource(R.drawable.ic_grey50);
                star5.setImageResource(R.drawable.ic_grey50);
                break;
            case R.id.star2:
                star1.setImageResource(R.drawable.ic_yellow_star);
                star2.setImageResource(R.drawable.ic_yellow_star);
                star3.setImageResource(R.drawable.ic_grey50);
                star4.setImageResource(R.drawable.ic_grey50);
                star5.setImageResource(R.drawable.ic_grey50);
                break;
            case R.id.star3:
                star1.setImageResource(R.drawable.ic_yellow_star);
                star2.setImageResource(R.drawable.ic_yellow_star);
                star3.setImageResource(R.drawable.ic_yellow_star);
                star4.setImageResource(R.drawable.ic_grey50);
                star5.setImageResource(R.drawable.ic_grey50);
                break;
            case R.id.star4:
                star1.setImageResource(R.drawable.ic_yellow_star);
                star2.setImageResource(R.drawable.ic_yellow_star);
                star3.setImageResource(R.drawable.ic_yellow_star);
                star4.setImageResource(R.drawable.ic_yellow_star);
                star5.setImageResource(R.drawable.ic_grey50);
                break;
            case R.id.star5:
                star1.setImageResource(R.drawable.ic_yellow_star);
                star2.setImageResource(R.drawable.ic_yellow_star);
                star3.setImageResource(R.drawable.ic_yellow_star);
                star4.setImageResource(R.drawable.ic_yellow_star);
                star5.setImageResource(R.drawable.ic_yellow_star);
                break;
        }
    }
}
