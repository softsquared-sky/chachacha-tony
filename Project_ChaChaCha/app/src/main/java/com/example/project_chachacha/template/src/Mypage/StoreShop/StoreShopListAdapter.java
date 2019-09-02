package com.example.project_chachacha.template.src.Mypage.StoreShop;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
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

public class StoreShopListAdapter extends RecyclerView.Adapter<StoreShopListAdapter.CustomViewHolder> {

    private Context context;
    private ArrayList <StoreShopItemData> arrayList;

    public StoreShopListAdapter(Context context, ArrayList<StoreShopItemData> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.storeshop_item,parent,false);

        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StoreShopListAdapter.CustomViewHolder holder, int position) {

        holder.tvTitle.setText(arrayList.get(position).getShopName());
        holder.tvMood.setText(arrayList.get(position).getMood());
        holder.tvWriting.setText(arrayList.get(position).getWriting());
        Glide.with(holder.itemView.getContext()).load(arrayList.get(position).getImgurl()).into(holder.ivBackImg);
//        holder.ivBackImg.setImageResource(R.drawable.ic_launcher_background); // 임시
    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected TextView tvTitle;
        protected TextView tvMood;
        protected TextView tvWriting;
        protected ImageView ivBackImg;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvTitle = itemView.findViewById(R.id.shop);
            this.tvMood = itemView.findViewById(R.id.moodtext);
            this.tvWriting = itemView.findViewById(R.id.writing);
            this.ivBackImg = itemView.findViewById(R.id.storeShop_iv_backImg);
            GradientDrawable drawable = (GradientDrawable)context.getDrawable(R.drawable.image_rounding);
            this.ivBackImg.setBackground(drawable);
            this.ivBackImg.setClipToOutline(true);
        }
    }
}
