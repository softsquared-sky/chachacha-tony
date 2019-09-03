package com.example.project_chachacha.template.src.mypage.MyChaChaCha;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.project_chachacha.R;

import java.util.ArrayList;

public class MyChaChaChaListAdapter extends RecyclerView.Adapter<MyChaChaChaListAdapter.CustomViewHolder> {

    private ArrayList<MyChaChaChaItemData> arrayList;
    private Context context;

    MyChaChaChaListAdapter(Context context, ArrayList<MyChaChaChaItemData> arrayList){
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyChaChaChaListAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mychachacha_item, parent, false);

        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyChaChaChaListAdapter.CustomViewHolder holder, int position) {

        holder.mTvShopName.setText(arrayList.get(position).getShopName());
        Glide.with(holder.itemView.getContext()).load(arrayList.get(position).getImgurl()).into(holder.mIvShopImg);
        holder.mIvShopImg.setAlpha(0.9F);
    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{

        protected ImageView mIvShopImg;
        protected TextView mTvShopName;
        protected View mViewList;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mTvShopName = itemView.findViewById(R.id.mychachacha_item_tv_shopName);
            this.mIvShopImg = itemView.findViewById(R.id.mychachacha_item_iv_img);
//            GradientDrawable drawable = (GradientDrawable)context.getDrawable(R.drawable.image_rounding);
//            this.mIvShopImg.setBackground(drawable);
            this.mViewList = itemView.findViewById(R.id.mychachacha_item);
            this.mViewList.setClipToOutline(true);
        }
    }

}
