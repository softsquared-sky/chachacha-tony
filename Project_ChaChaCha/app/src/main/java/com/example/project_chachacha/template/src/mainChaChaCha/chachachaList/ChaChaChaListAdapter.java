package com.example.project_chachacha.template.src.mainChaChaCha.chachachaList;

import android.content.Context;
import android.content.Intent;
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
import com.example.project_chachacha.template.src.myPage.StoreShop.StoreShopItemData;
import com.example.project_chachacha.template.src.shop.shopdetatil.ShopDetailActivity;

import java.util.ArrayList;

public class ChaChaChaListAdapter extends RecyclerView.Adapter<ChaChaChaListAdapter.CustomViewHolder> {
    private Context context;
    private ArrayList<ChaChaChaListItemData> arrayList;

    public ChaChaChaListAdapter(Context context, ArrayList<ChaChaChaListItemData> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ChaChaChaListAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chachacha_item,parent,false);

        ChaChaChaListAdapter.CustomViewHolder viewHolder = new ChaChaChaListAdapter.CustomViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ChaChaChaListAdapter.CustomViewHolder holder, final int position) {

        holder.title.setText(arrayList.get(position).getShopName());
        String mood = arrayList.get(position).getMood().replace(",","");
        holder.moodtext.setText(mood);
        holder.writing.setText(arrayList.get(position).getWriting());
        Glide.with(holder.itemView.getContext()).load(arrayList.get(position).getImgurl()).into(holder.backimg);

        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ShopDetailActivity.class);
                intent.putExtra("storenum", arrayList.get(position).getStorenum());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected TextView title;
        protected TextView writing;
        protected TextView moodtext;
        protected ImageView backimg;
        protected View item;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.shop);
            this.moodtext = itemView.findViewById(R.id.moodtext);
            this.writing = itemView.findViewById(R.id.chachacha_item_tv_writing);
            this.backimg = itemView.findViewById(R.id.list_item_img);
            GradientDrawable drawable = (GradientDrawable)context.getDrawable(R.drawable.image_rounding);
            this.backimg.setBackground(drawable);
            this.backimg.setClipToOutline(true);
            this.item = itemView.findViewById(R.id.chachacha_item);
        }
    }
}
