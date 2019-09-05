package com.example.project_chachacha.template.src.mainChaChaCha.chachachaList;

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
import com.example.project_chachacha.template.src.myPage.StoreShop.StoreShopItemData;

import java.util.ArrayList;

public class ChaChaChaListAdapter extends RecyclerView.Adapter<ChaChaChaListAdapter.CustomViewHolder> {
    private Context context;
    private ArrayList<StoreShopItemData> arrayList;

    public ChaChaChaListAdapter(Context context, ArrayList<StoreShopItemData> arrayList) {
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
    public void onBindViewHolder(@NonNull ChaChaChaListAdapter.CustomViewHolder holder, int position) {

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
