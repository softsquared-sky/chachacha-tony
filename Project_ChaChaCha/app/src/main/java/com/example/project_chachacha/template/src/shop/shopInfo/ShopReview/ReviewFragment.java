package com.example.project_chachacha.template.src.shop.shopInfo.ShopReview;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.project_chachacha.R;
import com.example.project_chachacha.template.src.CustomDialogOneButton;
import com.example.project_chachacha.template.src.shop.shopInfo.ShopReview.Interfaces.ReviewView;
import com.example.project_chachacha.template.src.shop.shopInfo.ShopReview.models.Review;
import com.example.project_chachacha.template.src.shop.shopInfo.ShopReview.models.ReviewCount;
import com.example.project_chachacha.template.src.shop.shopInfo.ShopReview.models.ReviewResult;

import java.util.ArrayList;
import java.util.List;

public class ReviewFragment extends Fragment implements ReviewView {

    private TextView mTvTotalReview;

    private RecyclerView recyclerView;
    private ArrayList<ReviewItemData> arrayList;
    private ReviewListAdapter adapter;
    private LinearLayoutManager linearLayoutManager;

    private CustomDialogOneButton customDialogOneButton;
    private String message;
    private int storeNum;

    private int totalReview;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_review, container, false);

        Bundle extra = this.getArguments();
        if(extra!=null){
            storeNum = extra.getInt("storenum",0);
        }

        mTvTotalReview = rootView.findViewById(R.id.shopReview_tv_totalReview);
        recyclerView = rootView.findViewById(R.id.shopReview_rv_list);
        arrayList = new ArrayList<>();
        adapter = new ReviewListAdapter(getActivity(),arrayList); // 생성에 context필요할수도?
        recyclerView.setAdapter(adapter);

        final ReviewService reviewService = new ReviewService(this);
        reviewService.getShopReview(storeNum);
        // Inflate the layout for this fragment
        return rootView;
    }


    @Override
    public void validateSuccess(int code, String message, ReviewResult reviewResult) {
        final int Success = 209;
        final int InvalidToken = 201;
        final int storeNumFormError = 210;
        final int InvalidStoreNum = 499;
        if(code==Success){
            totalReview = reviewResult.getReviewCount();
            String content = "리뷰 "+totalReview+"개";
            mTvTotalReview.setText(getString(R.string.common_content, content));
            List<Review> reviews = reviewResult.getReview();
            for(int i=0; i<reviews.size(); i++){
                ReviewItemData reviewItemData = new ReviewItemData(reviews.get(i).getName(),reviews.get(i).getStar(),reviews.get(i).getText());
                arrayList.add(reviewItemData);
            }
            adapter.notifyDataSetChanged();
        }
        else{
            switch (code){
                case InvalidToken:
                    message="로그인이 만료되었습니다.\n다시 로그인해주세요.";
                    break;
                case storeNumFormError:
                    message="storeNum형식이 올바르지 않습니다.";
                    break;
                case InvalidStoreNum:
                    message="유효하지 않은 storeNum입니다.";
                    break;
            }
            customDialogOneButton = new CustomDialogOneButton(getContext(),message);
            customDialogOneButton.setCancelable(true);
            customDialogOneButton.show();
        }
    }

    @Override
    public void validateFailure(String message) {
        System.out.println("ReviewFragment: " + message);
    }
}
