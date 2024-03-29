package com.example.project_chachacha.template.src.myPage.MyPageMain;

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
import com.example.project_chachacha.template.src.CustomDialogOneButton;
import com.example.project_chachacha.template.src.login.LoginActivity;
import com.example.project_chachacha.template.src.myPage.MypageActivity;
import com.example.project_chachacha.template.src.myPage.MyPageMain.Interfaces.MypageMainView;
import com.example.project_chachacha.template.src.myPage.MyReview.MyreviewFragment;
import com.example.project_chachacha.template.src.myPage.ProfileEdit.ProfileEditFragment;
import com.example.project_chachacha.template.src.myPage.StoreShop.StoreShopFragment;

import static com.example.project_chachacha.template.src.ApplicationClass.USERID;
import static com.example.project_chachacha.template.src.ApplicationClass.sSharedPreferences;


public class MypageMainFragment extends Fragment implements MypageMainView {

    private TextView mTvUserName, mTvComment, mTvEmail, mTvPhone, mTvRegisterDay;
    private CustomDialogOneButton mCustomDialogOneButton;

    private String tempName, tempComment, tempEmail, tempPhone, tempRegisterDay;

    private boolean FirstExecute = false;

    public static MypageMainFragment newInstance(){
        return new MypageMainFragment();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup view = (ViewGroup)inflater.inflate(R.layout.fragment_mypage_main,container,false);

        mTvUserName = view.findViewById(R.id.myPageMain_tv_userName);
        mTvComment = view.findViewById(R.id.myPageMain_tv_comment);
        mTvEmail = view.findViewById(R.id.register_edt_email);
        mTvPhone = view.findViewById(R.id.myPageMain_tv_phone);
        mTvRegisterDay = view.findViewById(R.id.myPageMain_tv_regitDay);


        final MypageMainService mMypageMainService = new MypageMainService(this);
        mMypageMainService.getMypage(USERID);

        TextView tvLogout = view.findViewById(R.id.myPageMain_tv_logout); // 로그아웃
        tvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sSharedPreferences.edit();
                editor.putBoolean("check",false);
                editor.apply();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                if(getActivity()!=null){
                    getActivity().finish();
                }
            }
        });

        TextView tvEdit = view.findViewById(R.id.edit); // 수정하기
        tvEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getActivity()!=null){
                    ((MypageActivity)getActivity()).replaceFragment(ProfileEditFragment.newInstance());
                }
            }
        });

        ImageView ivReview = view.findViewById(R.id.myPageMain_iv_myReview);
        ivReview.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(getActivity()!=null){
                    ((MypageActivity)getActivity()).replaceFragment(MyreviewFragment.newInstance());
                }
            }
        });

        ImageView ivStore = view.findViewById(R.id.myPageMain_iv_saveShop);
        ivStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getActivity()!=null){
                    ((MypageActivity)getActivity()).replaceFragment(StoreShopFragment.newInstance());
                }
            }
        });
        // Inflate the layout for this fragment
        return view;
//        return inflater.inflate(R.layout.fragment_mypage_main, container, false);
    }


    @Override
    public void validateSuccess(int code, String message, String name, String writing, String email, String phone, String signuptime) {
        final int Success = 115;
        final int InvalidToken = 201;
        final int InvalidUserId = 399;
        final String msg;
        if(code == Success){
            System.out.println("성공!!!" + writing);
            mTvUserName.setText(name);
            mTvComment.setText(writing);
            mTvEmail.setText(email);
            mTvPhone.setText(phone);
            mTvRegisterDay.setText(signuptime);
        }
        else{
            if(code == InvalidToken){
                msg = "유효하지 않은 토큰입니다.\n다시 로그인 해주세요.";
            }
            else{
                msg = "유효하지 않은 아이디입니다.\n다시 로그인 해주세요.";
            }
            mCustomDialogOneButton = new CustomDialogOneButton(getContext(),msg);
            mCustomDialogOneButton.setCancelable(false);
            mCustomDialogOneButton.show();
            if(getActivity()!=null){
                getActivity().finish();
            }
        }
    }

    @Override
    public void validateFailure(int code, String message) {
        System.out.println("실패!!" + " " + message);
        String msg = "서버가 응답하지 않습니다.";
        mCustomDialogOneButton = new CustomDialogOneButton(getContext(),msg);
        mCustomDialogOneButton.setCancelable(false);
        mCustomDialogOneButton.show();
    }
}
