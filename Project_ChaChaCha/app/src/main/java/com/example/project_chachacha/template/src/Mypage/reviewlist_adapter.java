package com.example.project_chachacha.template.src.Mypage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_chachacha.R;

import java.util.ArrayList;

public class reviewlist_adapter extends RecyclerView.Adapter<reviewlist_adapter.CustomViewHolder> {

    private ArrayList<review_item> arrayList;

    public reviewlist_adapter(ArrayList<review_item> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_item,parent,false);

        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        holder.iv_profile_img.setImageResource(arrayList.get(position).getProfile());
        holder.tv_shopName.setText(arrayList.get(position).getShopName());
        holder.tv_address.setText(arrayList.get(position).getAddress());
        holder.tv_content.setText(arrayList.get(position).getContent());

        // rate에 대해 추가
        // 여기서 클릭리스너로 (롱클릭 등) 삭제같은것 가능
    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected ImageView iv_profile_img;
        protected TextView tv_shopName;
        protected ImageView iv_rate1, iv_rate2, iv_rate3, iv_rate4, iv_rate5;
        protected TextView tv_address;
        protected TextView tv_content;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.iv_profile_img = (ImageView)itemView.findViewById(R.id.profile_img);
            this.tv_shopName = (TextView)itemView.findViewById(R.id.shopName);
            this.tv_address = (TextView)itemView.findViewById(R.id.shopAddress);
            this.tv_content = (TextView)itemView.findViewById(R.id.content);

        }
    }
}
