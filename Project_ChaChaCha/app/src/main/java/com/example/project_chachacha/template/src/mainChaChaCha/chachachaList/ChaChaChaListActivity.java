package com.example.project_chachacha.template.src.mainChaChaCha.chachachaList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.project_chachacha.R;
import com.example.project_chachacha.template.src.BaseActivity;
import com.example.project_chachacha.template.src.CustomDialogOneButton;
import com.example.project_chachacha.template.src.CustomDialogTwoButton;
import com.example.project_chachacha.template.src.mainChaChaCha.chachachaList.Interfaces.ChaListView;
import com.example.project_chachacha.template.src.mainChaChaCha.chachachaList.models.ChaListResult;
import com.example.project_chachacha.template.src.mainChaChaCha.chachachaSelect.ChachachaActivity;
import com.example.project_chachacha.template.src.myPage.StoreShop.StoreShopItemData;

import java.util.ArrayList;
import java.util.List;

public class ChaChaChaListActivity extends BaseActivity implements ChaListView {

    private RecyclerView recyclerView;
    private ChaChaChaListAdapter adapter;
    private ArrayList<ChaChaChaListItemData> arrayList;

    private ImageView mIvback;

    private final int size = 10;
    private int people;
    private String kind;
    private String mode;
    private int page=0;

    private CustomDialogTwoButton mCustomDialogTwoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cha_cha_cha2);

        Intent intent = getIntent();
        people = intent.getIntExtra("people", 0);
        kind = intent.getStringExtra("kind");
        mode = intent.getStringExtra("mode");

        final ChaListService chaListService = new ChaListService(this);
        chaListService.postChaList(people, kind, mode, page, size);

        System.out.println(people + " " + kind + " " + mode);


        arrayList = new ArrayList<>();

        recyclerView = findViewById(R.id.chachachalist_rv_list);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int lastVisiblePosition = ((LinearLayoutManager)recyclerView.getLayoutManager()).findLastCompletelyVisibleItemPosition();
                int itemTotalCount = recyclerView.getAdapter().getItemCount();

                if(itemTotalCount%10==0 && itemTotalCount!=0){
                    if(lastVisiblePosition+1 == itemTotalCount){
                        page = page+size;
                        chaListService.postChaList(people, kind, mode, page, size);
                    }
                }
            }
        });
        adapter = new ChaChaChaListAdapter(this, arrayList);
        recyclerView.setAdapter(adapter);

        mIvback = findViewById(R.id.chachachalist_iv_back);
        mIvback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private final View.OnClickListener finishListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ChachachaActivity ca = (ChachachaActivity)ChachachaActivity.sChaChaChaActivity;
            ca.finish();
            Intent intent = new Intent(ChaChaChaListActivity.this, ChachachaActivity.class);
            startActivity(intent);
            finish();
            mCustomDialogTwoButton.dismiss();
        }
    };

    @Override
    public void validateSuccess(int code, List<ChaListResult> results) {
        System.out.println(code);
        final int Success = 206;
        if(code == Success){
            for(int i=0; i<results.size(); i++){
                arrayList.add(new ChaChaChaListItemData(results.get(i).getStorename(),results.get(i).getMode(),results.get(i).getStorewriting(),
                        results.get(i).getImageurl(), results.get(i).getStorenum()));
            }
            adapter.notifyDataSetChanged();

            if(results.size()==0){
                if(arrayList.size()==0){
                    mCustomDialogTwoButton = new CustomDialogTwoButton(ChaChaChaListActivity.this, "검색결과가 없습니다.\n다시 검색하시겠습니까?", finishListener);
                    mCustomDialogTwoButton.setCancelable(false);
                    mCustomDialogTwoButton.show();
                }
            }
        }
    }

    @Override
    public void validateFailure(String msg) {
        System.out.println(msg);
    }
}
