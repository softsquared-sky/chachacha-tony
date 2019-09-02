package com.example.project_chachacha.template.src.Mypage.MypageMain;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project_chachacha.R;
import com.example.project_chachacha.template.src.Login.LoginActivity;
import com.example.project_chachacha.template.src.Mypage.MypageActivity;
import com.example.project_chachacha.template.src.Mypage.MypageMain.Interfaces.MypageMainView;
import com.example.project_chachacha.template.src.Mypage.Myreview.MyreviewFragment;
import com.example.project_chachacha.template.src.Mypage.ProfileEdit.ProfileEditFragment;
import com.example.project_chachacha.template.src.Mypage.StoreShop.StoreShopFragment;

import static android.content.Context.MODE_PRIVATE;
import static com.example.project_chachacha.template.src.ApplicationClass.COMMENT;
import static com.example.project_chachacha.template.src.ApplicationClass.EMAIL;
import static com.example.project_chachacha.template.src.ApplicationClass.PHONE;
import static com.example.project_chachacha.template.src.ApplicationClass.USERID;
import static com.example.project_chachacha.template.src.ApplicationClass.USERNAME;
import static com.example.project_chachacha.template.src.ApplicationClass.sSharedPreferences;
import static com.example.project_chachacha.template.src.ApplicationClass.sharedPreferences;


public class MypageMainFragment extends Fragment implements MypageMainView {

    private TextView mTvUserName, mTvComment, mTvEmail, mTvPhone, mTvRegisterDay;
    private SharedPreferences.Editor editor = sSharedPreferences.edit();

    public static MypageMainFragment newInstance(){
        return new MypageMainFragment();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_mypage_main,null);
        ViewGroup view = (ViewGroup)inflater.inflate(R.layout.fragment_mypage_main,container,false);

        mTvUserName = view.findViewById(R.id.myPageMain_tv_userName);
        mTvComment = view.findViewById(R.id.myPageMain_tv_comment);
        mTvEmail = view.findViewById(R.id.register_edt_email);
        mTvPhone = view.findViewById(R.id.myPageMain_tv_phone);
        mTvRegisterDay = view.findViewById(R.id.RegitDay);

//        Bundle extra = this.getArguments();
//        if(extra!=null){
//            extra = getArguments();
//            strUserId = extra.getString("strUserId");
//        }

        final MypageMainService mMypageMainService = new MypageMainService(this);

//        SharedPreferences sp = this.getActivity().getSharedPreferences("Auto",Context.MODE_PRIVATE);
//        String strUserId = sp.getString("strUserId", null);
//        USERID = strUserId;

        mMypageMainService.getMypage(USERID);
        System.out.println("넘어온 UserId: " + USERID);

        TextView tvLogout = view.findViewById(R.id.myPageMain_tv_logout);
        tvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Context context = getActivity();
                editor.putBoolean("check",false);
                editor.apply();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        TextView tvEdit = (TextView) view.findViewById(R.id.edit);
        tvEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                USERNAME = mTvUserName.getText().toString();
                COMMENT = mTvComment.getText().toString();
                EMAIL = mTvEmail.getText().toString();
                PHONE = mTvPhone.getText().toString();
                ((MypageActivity)getActivity()).replaceFragment(ProfileEditFragment.newInstance());
            }
        });

        ImageView ivReview = view.findViewById(R.id.myPageMain_iv_myReview);
        ivReview.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ((MypageActivity)getActivity()).replaceFragment(MyreviewFragment.newInstance());
            }
        });

        ImageView ivStore = view.findViewById(R.id.myPageMain_iv_saveShop);
        ivStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MypageActivity)getActivity()).replaceFragment(StoreShopFragment.newInstance());
            }
        });
        // Inflate the layout for this fragment
        return view;
//        return inflater.inflate(R.layout.fragment_mypage_main, container, false);
    }


    @Override
    public void validateSuccess(int code, String message, String name, String writing, String email, String phone, String signuptime) {
        System.out.println("성공!!!" + writing);
        mTvUserName.setText(name);
        mTvComment.setText(writing);
        mTvEmail.setText(email);
        mTvPhone.setText(phone);
        mTvRegisterDay.setText(signuptime);
    }

    @Override
    public void validateFailure(int code, String message) {
        System.out.println("실패!!" + " " + message);
    }
}
