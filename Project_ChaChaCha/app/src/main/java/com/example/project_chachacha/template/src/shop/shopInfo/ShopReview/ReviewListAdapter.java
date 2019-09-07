package com.example.project_chachacha.template.src.shop.shopInfo.ShopReview;

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

public class ReviewListAdapter extends RecyclerView.Adapter<ReviewListAdapter.ReviewListviewholder> {

    private ArrayList<ReviewItemData> arrayList;
    private Context context;
    private String rate;

    public ReviewListAdapter(Context context, ArrayList<ReviewItemData> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ReviewListviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shopreview_item,parent,false);

        ReviewListviewholder viewHolder = new ReviewListviewholder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewListviewholder holder, int position) {

        final int size = arrayList.size()-1;

        if(arrayList.get(size-position).getRate()==5){
            holder.ivRate1.setImageResource(R.drawable.ic_yellow_star);
            holder.ivRate2.setImageResource(R.drawable.ic_yellow_star);
            holder.ivRate3.setImageResource(R.drawable.ic_yellow_star);
            holder.ivRate4.setImageResource(R.drawable.ic_yellow_star);
            holder.ivRate5.setImageResource(R.drawable.ic_yellow_star);
        }
        else if(arrayList.get(size-position).getRate()==4){
            holder.ivRate1.setImageResource(R.drawable.ic_yellow_star);
            holder.ivRate2.setImageResource(R.drawable.ic_yellow_star);
            holder.ivRate3.setImageResource(R.drawable.ic_yellow_star);
            holder.ivRate4.setImageResource(R.drawable.ic_yellow_star);
            holder.ivRate5.setImageResource(R.drawable.ic_star_black_24dp);
        }
        else if(arrayList.get(size-position).getRate()==3){
            holder.ivRate1.setImageResource(R.drawable.ic_yellow_star);
            holder.ivRate2.setImageResource(R.drawable.ic_yellow_star);
            holder.ivRate3.setImageResource(R.drawable.ic_yellow_star);
            holder.ivRate4.setImageResource(R.drawable.ic_star_black_24dp);
            holder.ivRate5.setImageResource(R.drawable.ic_star_black_24dp);
        }
        else if(arrayList.get(size-position).getRate()==2){
            holder.ivRate1.setImageResource(R.drawable.ic_yellow_star);
            holder.ivRate2.setImageResource(R.drawable.ic_yellow_star);
            holder.ivRate3.setImageResource(R.drawable.ic_star_black_24dp);
            holder.ivRate4.setImageResource(R.drawable.ic_star_black_24dp);
            holder.ivRate5.setImageResource(R.drawable.ic_star_black_24dp);
        }
        else if(arrayList.get(size-position).getRate()==1){
            holder.ivRate1.setImageResource(R.drawable.ic_yellow_star);
            holder.ivRate2.setImageResource(R.drawable.ic_star_black_24dp);
            holder.ivRate3.setImageResource(R.drawable.ic_star_black_24dp);
            holder.ivRate4.setImageResource(R.drawable.ic_star_black_24dp);
            holder.ivRate5.setImageResource(R.drawable.ic_star_black_24dp);
        }
        else{
            holder.ivRate1.setImageResource(R.drawable.ic_star_black_24dp);
            holder.ivRate2.setImageResource(R.drawable.ic_star_black_24dp);
            holder.ivRate3.setImageResource(R.drawable.ic_star_black_24dp);
            holder.ivRate4.setImageResource(R.drawable.ic_star_black_24dp);
            holder.ivRate5.setImageResource(R.drawable.ic_star_black_24dp);
        }

        holder.tvName.setText(arrayList.get(size-position).getName());
        holder.tvContent.setText(arrayList.get(size-position).getContent());

        if(position==arrayList.size()-1){
            System.out.println("안보이게?");
            holder.viewDivide.setVisibility(View.GONE);
        }

        // rate에 대해 추가
        // 여기서 클릭리스너로 (롱클릭 등) 삭제같은것 가능
    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    public class ReviewListviewholder extends RecyclerView.ViewHolder {

        protected ImageView ivRate1, ivRate2, ivRate3, ivRate4, ivRate5;
        protected TextView tvName;
        protected TextView tvContent;
        protected View viewDivide;

        public ReviewListviewholder(@NonNull View itemView) {
            super(itemView);
            this.tvName = itemView.findViewById(R.id.shopReviewList_tv_userName);
            this.tvContent = itemView.findViewById(R.id.shop_review_content);
            this.ivRate1 = itemView.findViewById(R.id.shopReviewList_iv_rate1);
            this.ivRate2 = itemView.findViewById(R.id.shopReviewList_iv_rate2);
            this.ivRate3 = itemView.findViewById(R.id.shopReviewList_iv_rate3);
            this.ivRate4 = itemView.findViewById(R.id.shopReviewList_iv_rate4);
            this.ivRate5 = itemView.findViewById(R.id.shopReviewList_iv_rate5);
            this.viewDivide = itemView.findViewById(R.id.divider);

        }
    }
}
