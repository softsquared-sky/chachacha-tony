package com.example.project_chachacha.template.src.myPage.MyChaChaCha;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.project_chachacha.R;
import com.example.project_chachacha.template.src.CustomDialogTwoButton;
import com.example.project_chachacha.template.src.myChaShopDetail.myChaShop.MyChaShopDetail;
import com.example.project_chachacha.template.src.myPage.MyChaChaCha.Interfaces.MyChaChaChaView;
import com.example.project_chachacha.template.src.myPage.MyChaChaCha.models.MyChaChaChaResult;

import java.util.ArrayList;
import java.util.List;

import static com.example.project_chachacha.template.src.ApplicationClass.USERID;

public class MyChaChaChaListAdapter extends RecyclerView.Adapter<MyChaChaChaListAdapter.CustomViewHolder> implements MyChaChaChaView {

    private ArrayList<MyChaChaChaItemData> arrayList;
    private Context context;

    private int pos;

    private final MyChaChaChaService myChaChaChaService = new MyChaChaChaService(this);

    private CustomDialogTwoButton mCustomDialogTwoButton;

    MyChaChaChaListAdapter(Context context, ArrayList<MyChaChaChaItemData> arrayList){
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public void validateSuccess(int code, List<MyChaChaChaResult> list) {

    }

    @Override
    public void validateSuccessDelete(int code) {
        arrayList.remove(pos);
        notifyDataSetChanged();
        System.out.println("성공???");
    }

    @Override
    public void validateFailure(String message) {
        System.out.println("실패???");
    }

    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    private OnItemClickListener mListener = null;

    public void setOnItemClickListener(OnItemClickListener listener){
        this.mListener = listener;
    }

    @NonNull
    @Override
    public MyChaChaChaListAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mychachacha_item, parent, false);

        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyChaChaChaListAdapter.CustomViewHolder holder, final int position) {

        final int size = arrayList.size()-1;

        holder.mTvShopName.setText(arrayList.get(size-position).getShopName());
        Glide.with(holder.itemView.getContext()).load(arrayList.get(size-position).getImgurl()).into(holder.mIvShopImg);
        holder.mIvShopImg.setAlpha(0.9F);

        final View.OnClickListener deleteListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myChaChaChaService.deleteMyCha(USERID, arrayList.get(size-position).getChanum());
                pos = size-position;
                mCustomDialogTwoButton.dismiss();
            }
        };

        holder.mViewList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MyChaShopDetail.class);
                intent.putExtra("chanum", arrayList.get(size-position).getChanum());
                intent.putExtra("storenum", arrayList.get(size-position).getStorenum());
                context.startActivity(intent);
            }
        });
        holder.mViewList.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View view) {
                mCustomDialogTwoButton = new CustomDialogTwoButton(context, "해당가게를 마이차차차에서 삭제하시겠습니까?", deleteListener);
                mCustomDialogTwoButton.setCancelable(false);
                mCustomDialogTwoButton.show();
                return true;
            }
        });


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
