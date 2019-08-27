package com.example.project_chachacha.template.src.ShopInfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_chachacha.R;
import com.example.project_chachacha.template.src.Mypage.review_item;
import com.example.project_chachacha.template.src.Mypage.reviewlist_adapter;

import java.util.ArrayList;
import java.util.List;

public class Shop_review_adapter extends RecyclerView.Adapter<Shop_review_adapter.Shop_review_viewholder> {

    private ArrayList<Shop_review_data> arrayList;
    private Context context;
    private String rate;

    public Shop_review_adapter(Context context, ArrayList<Shop_review_data> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Shop_review_viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shop_review_item,parent,false);

        Shop_review_viewholder viewHolder = new Shop_review_viewholder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Shop_review_viewholder holder, int position) {

        if(arrayList.get(position).getRate()=="5"){
            holder.iv_rate1.setImageResource(R.drawable.ic_yellow_star);
            holder.iv_rate2.setImageResource(R.drawable.ic_yellow_star);
            holder.iv_rate3.setImageResource(R.drawable.ic_yellow_star);
            holder.iv_rate4.setImageResource(R.drawable.ic_yellow_star);
            holder.iv_rate5.setImageResource(R.drawable.ic_yellow_star);
        }
        else if(arrayList.get(position).getRate()=="4"){
            holder.iv_rate1.setImageResource(R.drawable.ic_yellow_star);
            holder.iv_rate2.setImageResource(R.drawable.ic_yellow_star);
            holder.iv_rate3.setImageResource(R.drawable.ic_yellow_star);
            holder.iv_rate4.setImageResource(R.drawable.ic_yellow_star);
            holder.iv_rate5.setImageResource(R.drawable.ic_star_black_24dp);
        }
        else if(arrayList.get(position).getRate()=="3"){
            holder.iv_rate1.setImageResource(R.drawable.ic_yellow_star);
            holder.iv_rate2.setImageResource(R.drawable.ic_yellow_star);
            holder.iv_rate3.setImageResource(R.drawable.ic_yellow_star);
            holder.iv_rate4.setImageResource(R.drawable.ic_star_black_24dp);
            holder.iv_rate5.setImageResource(R.drawable.ic_star_black_24dp);
        }
        else if(arrayList.get(position).getRate()=="2"){
            holder.iv_rate1.setImageResource(R.drawable.ic_yellow_star);
            holder.iv_rate2.setImageResource(R.drawable.ic_yellow_star);
            holder.iv_rate3.setImageResource(R.drawable.ic_star_black_24dp);
            holder.iv_rate4.setImageResource(R.drawable.ic_star_black_24dp);
            holder.iv_rate5.setImageResource(R.drawable.ic_star_black_24dp);
        }
        else if(arrayList.get(position).getRate()=="1"){
            holder.iv_rate1.setImageResource(R.drawable.ic_yellow_star);
            holder.iv_rate2.setImageResource(R.drawable.ic_star_black_24dp);
            holder.iv_rate3.setImageResource(R.drawable.ic_star_black_24dp);
            holder.iv_rate4.setImageResource(R.drawable.ic_star_black_24dp);
            holder.iv_rate5.setImageResource(R.drawable.ic_star_black_24dp);
        }
        else{
            holder.iv_rate1.setImageResource(R.drawable.ic_star_black_24dp);
            holder.iv_rate2.setImageResource(R.drawable.ic_star_black_24dp);
            holder.iv_rate3.setImageResource(R.drawable.ic_star_black_24dp);
            holder.iv_rate4.setImageResource(R.drawable.ic_star_black_24dp);
            holder.iv_rate5.setImageResource(R.drawable.ic_star_black_24dp);
        }

        holder.name.setText(arrayList.get(position).getName());
        holder.content.setText(arrayList.get(position).getContent());

        // rate에 대해 추가
        // 여기서 클릭리스너로 (롱클릭 등) 삭제같은것 가능
    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    public class Shop_review_viewholder extends RecyclerView.ViewHolder {

        protected ImageView iv_rate1, iv_rate2, iv_rate3, iv_rate4, iv_rate5;
        protected TextView name;
        protected TextView content;

        public Shop_review_viewholder(@NonNull View itemView) {
            super(itemView);
            this.name = (TextView)itemView.findViewById(R.id.user_name);
            this.content = (TextView)itemView.findViewById(R.id.shop_review_content);
            this.iv_rate1 = (ImageView)itemView.findViewById(R.id.rate1);
            this.iv_rate2 = (ImageView)itemView.findViewById(R.id.rate2);
            this.iv_rate3 = (ImageView)itemView.findViewById(R.id.rate3);
            this.iv_rate4 = (ImageView)itemView.findViewById(R.id.rate4);
            this.iv_rate5 = (ImageView)itemView.findViewById(R.id.rate5);

        }
    }
}
