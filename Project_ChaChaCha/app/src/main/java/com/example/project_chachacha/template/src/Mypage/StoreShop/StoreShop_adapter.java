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

import com.example.project_chachacha.R;

import java.util.ArrayList;

public class StoreShop_adapter extends RecyclerView.Adapter<StoreShop_adapter.CustomViewHolder> {

    private Context context;
    private ArrayList <StoreShop_item> arrayList;

    public StoreShop_adapter(Context context, ArrayList<StoreShop_item> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.store_shop_item,parent,false);

        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StoreShop_adapter.CustomViewHolder holder, int position) {

        holder.title.setText(arrayList.get(position).getShopName());
        holder.moodtext.setText(arrayList.get(position).getMood());
        holder.backimg.setImageResource(R.drawable.ic_launcher_background); // 임시
    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected TextView title;
        protected TextView moodtext;
        protected ImageView backimg;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.shop);
            this.moodtext = itemView.findViewById(R.id.moodtext);
            this.backimg = itemView.findViewById(R.id.list_item_img);
            GradientDrawable drawable = (GradientDrawable)context.getDrawable(R.drawable.image_rounding);
            this.backimg.setBackground(drawable);
            this.backimg.setClipToOutline(true);
        }
    }
}
