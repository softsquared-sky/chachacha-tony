package com.example.project_chachacha.template.src.shop.shopInfo.ShopMenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_chachacha.R;

import java.util.ArrayList;

public class MenuListAdapter extends RecyclerView.Adapter<MenuListAdapter.MenuListViewHolder>{

    private ArrayList<MenuItemData> arrayList;
    private Context context;

    public MenuListAdapter(Context context, ArrayList<MenuItemData>arrayList){
        this.context =context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MenuListAdapter.MenuListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.shopmenu_item,parent,false);

        MenuListViewHolder viewHolder = new MenuListViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MenuListAdapter.MenuListViewHolder holder, int position) {

        holder.mTvFoodName.setText(arrayList.get(position).getFoodName());
        String content = arrayList.get(position).getPrice()+"원";
        holder.mTvPrice.setText(content);

    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    public class MenuListViewHolder extends RecyclerView.ViewHolder{

        protected TextView mTvFoodName;
        protected TextView mTvPrice;

        public MenuListViewHolder(@NonNull View itemView) {
            super(itemView);

            mTvFoodName = itemView.findViewById(R.id.shopmenu_item_tv_food);
            mTvPrice = itemView.findViewById(R.id.shopmenu_item_tv_price);
        }
    }
}
