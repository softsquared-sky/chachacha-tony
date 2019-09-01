package com.example.project_chachacha.template.src.Mypage.Myreview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_chachacha.R;

import java.util.ArrayList;

public class MyreviewListAdapter extends RecyclerView.Adapter<MyreviewListAdapter.CustomViewHolder> {

    private ArrayList<MyreviewItemData> arrayList;
    private Context context;

    public MyreviewListAdapter(Context context, ArrayList<MyreviewItemData> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.Myreview_item, parent, false);

        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        if (arrayList.get(position).getRate() == 5) {
            holder.ivRate1.setImageResource(R.drawable.ic_yellow_star);
            holder.ivRate2.setImageResource(R.drawable.ic_yellow_star);
            holder.ivRate3.setImageResource(R.drawable.ic_yellow_star);
            holder.ivRate4.setImageResource(R.drawable.ic_yellow_star);
            holder.ivRate5.setImageResource(R.drawable.ic_yellow_star);
        } else if (arrayList.get(position).getRate() == 4) {
            holder.ivRate1.setImageResource(R.drawable.ic_yellow_star);
            holder.ivRate2.setImageResource(R.drawable.ic_yellow_star);
            holder.ivRate3.setImageResource(R.drawable.ic_yellow_star);
            holder.ivRate4.setImageResource(R.drawable.ic_yellow_star);
            holder.ivRate5.setImageResource(R.drawable.ic_star_black_24dp);
        } else if (arrayList.get(position).getRate() == 3) {
            holder.ivRate1.setImageResource(R.drawable.ic_yellow_star);
            holder.ivRate2.setImageResource(R.drawable.ic_yellow_star);
            holder.ivRate3.setImageResource(R.drawable.ic_yellow_star);
            holder.ivRate4.setImageResource(R.drawable.ic_star_black_24dp);
            holder.ivRate5.setImageResource(R.drawable.ic_star_black_24dp);
        } else if (arrayList.get(position).getRate() == 2) {
            holder.ivRate1.setImageResource(R.drawable.ic_yellow_star);
            holder.ivRate2.setImageResource(R.drawable.ic_yellow_star);
            holder.ivRate3.setImageResource(R.drawable.ic_star_black_24dp);
            holder.ivRate4.setImageResource(R.drawable.ic_star_black_24dp);
            holder.ivRate5.setImageResource(R.drawable.ic_star_black_24dp);
        } else if (arrayList.get(position).getRate() == 1) {
            holder.ivRate1.setImageResource(R.drawable.ic_yellow_star);
            holder.ivRate2.setImageResource(R.drawable.ic_star_black_24dp);
            holder.ivRate3.setImageResource(R.drawable.ic_star_black_24dp);
            holder.ivRate4.setImageResource(R.drawable.ic_star_black_24dp);
            holder.ivRate5.setImageResource(R.drawable.ic_star_black_24dp);
        } else {
            holder.ivRate1.setImageResource(R.drawable.ic_star_black_24dp);
            holder.ivRate2.setImageResource(R.drawable.ic_star_black_24dp);
            holder.ivRate3.setImageResource(R.drawable.ic_star_black_24dp);
            holder.ivRate4.setImageResource(R.drawable.ic_star_black_24dp);
            holder.ivRate5.setImageResource(R.drawable.ic_star_black_24dp);
        }

        holder.ivProfileImg.setImageResource(arrayList.get(position).getProfile());
        holder.tvShopName.setText(arrayList.get(position).getShopName());
        holder.tvAddress.setText(arrayList.get(position).getAddress());
        holder.tvContent.setText(arrayList.get(position).getContent());

        // 여기서 클릭리스너로 (롱클릭 등) 삭제같은것 가능
    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected ImageView ivProfileImg;
        protected TextView tvShopName;
        protected ImageView ivRate1, ivRate2, ivRate3, ivRate4, ivRate5;
        protected TextView tvAddress;
        protected TextView tvContent;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.ivProfileImg = itemView.findViewById(R.id.myreview_item_iv_profileImg);
            this.tvShopName = itemView.findViewById(R.id.myreview_tv_shopName);
            this.tvAddress = itemView.findViewById(R.id.myreview_tv_shopAddress);
            this.tvContent = itemView.findViewById(R.id.myreview_tv_content);
            this.ivRate1 = itemView.findViewById(R.id.myreview_iv_rate1);
            this.ivRate2 = itemView.findViewById(R.id.myreview_iv_rate2);
            this.ivRate3 = itemView.findViewById(R.id.myreview_iv_rate3);
            this.ivRate4 = itemView.findViewById(R.id.myreview_iv_rate4);
            this.ivRate5 = itemView.findViewById(R.id.myreview_iv_rate5);

        }
    }
}
