package com.example.project_chachacha.template.src.Shopdetatil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.project_chachacha.R;
import com.example.project_chachacha.template.src.BaseActivity;
import com.example.project_chachacha.template.src.ShopInfo.ShopInfo;
import com.example.project_chachacha.template.src.Shopdetatil.Interfaces.ShopDetailView;
import com.example.project_chachacha.template.src.Shopdetatil.models.ShopDetailResult;

import java.util.List;

public class ShopDetail extends BaseActivity implements ShopDetailView {

    private ImageView mivmoreinfo, shopimg, call;
    private TextView shoptitle, shoptitle2, mood, writing, shopaddress, shoptime;
    private String phone;
    private int storeNum; // 넘겨받아야하는값

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_detail);

        shoptitle = findViewById(R.id.shoptitle);
        shoptitle2 = findViewById(R.id.shoptitle2);
        mood = findViewById(R.id.mood);
        writing = findViewById(R.id.storewriting);
        shopaddress = findViewById(R.id.shopAddress);
        shoptime = findViewById(R.id.shoptime);
        shopimg = findViewById(R.id.shopimg);
        call = findViewById(R.id.call);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(phone));
                startActivity(intent);
            }
        });

        final ShopDetailService shopDetailService = new ShopDetailService(this);
        shopDetailService.getDetail(10); // 받은값으로 해당 가게 조회

        mivmoreinfo = findViewById(R.id.moreinfo);
        mivmoreinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShopDetail.this, ShopInfo.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void validateSuccess(int code, String message, List<ShopDetailResult> results) {
        if(code==207){
            List<ShopDetailResult> result = results;
            for(int i=0; i<result.size(); i++){
                shoptitle.setText(result.get(i).getStorename());
                shoptitle2.setText(result.get(i).getStorename());
                mood.setText(result.get(i).getMode());
                writing.setText(result.get(i).getStorewriting());
                shopaddress.setText(result.get(i).getAddress());
                shoptime.setText(result.get(i).getOpentime() + "-" + result.get(i).getClosstime());
                Glide.with(this).load(result.get(i).getImageurl()).into(shopimg);
                phone = result.get(i).getPhone();
            }
            phone = phone.replace("-","");
            phone = "tel:"+phone;
        }
    }

    @Override
    public void validateFailure(int code, String message) {
        System.out.println(code + " " + message);
    }
}
