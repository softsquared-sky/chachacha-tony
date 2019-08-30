package com.example.project_chachacha.template.src.Mypage;

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
import com.example.project_chachacha.template.src.Login.Login;
import com.example.project_chachacha.template.src.Mypage.Interfaces.MypageView;
import com.example.project_chachacha.template.src.Mypage.Myreview.Myreview;
import com.example.project_chachacha.template.src.Mypage.ProfileEdit.Profile_Edit;
import com.example.project_chachacha.template.src.Mypage.StoreShop.StoreShop;

import static android.content.Context.MODE_PRIVATE;
import static com.example.project_chachacha.template.src.ApplicationClass._COMMENT;
import static com.example.project_chachacha.template.src.ApplicationClass._EMAIL;
import static com.example.project_chachacha.template.src.ApplicationClass._PHONE;
import static com.example.project_chachacha.template.src.ApplicationClass._USERID;
import static com.example.project_chachacha.template.src.ApplicationClass._USERNAME;
import static com.example.project_chachacha.template.src.ApplicationClass.sharedPreferences;


public class Mypage_main extends Fragment implements MypageView {

    TextView mTvEdit;
    TextView mTvlogout;
    ImageView mIvreview;
    ImageView mIvstore;
    TextView username, comment, _email, _phone, regitday;
    String userid;

    public static Mypage_main newInstance(){
        return new Mypage_main();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mypage_main,null);

        username = view.findViewById(R.id.username);
        comment = view.findViewById(R.id.comment);
        _email = view.findViewById(R.id.email);
        _phone = view.findViewById(R.id.callNum);
        regitday = view.findViewById(R.id.RegitDay);

//        Bundle extra = this.getArguments();
//        if(extra!=null){
//            extra = getArguments();
//            userid = extra.getString("userid");
//        }

        final MypageService mMypageService = new MypageService(this);

        SharedPreferences sp = this.getActivity().getSharedPreferences("Auto",Context.MODE_PRIVATE);
        userid = sp.getString("userid",null);
        _USERID = userid;

        mMypageService.getMypage(userid);
        System.out.println("넘어온 userid: " + userid);

        mTvlogout = (TextView)view.findViewById(R.id.logout);
        mTvlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getActivity();
                sharedPreferences = context.getSharedPreferences("Auto", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("check",false);
                editor.commit();
                Intent intent = new Intent(getActivity(), Login.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        mTvEdit = (TextView)view.findViewById(R.id.edit);
        mTvEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _USERNAME = username.getText().toString();
                _COMMENT = comment.getText().toString();
                _EMAIL = _email.getText().toString();
                _PHONE = _phone.getText().toString();
                ((Mypage)getActivity()).replaceFragment(Profile_Edit.newInstance());
            }
        });

        mIvreview = (ImageView)view.findViewById(R.id.myreview);
        mIvreview.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ((Mypage)getActivity()).replaceFragment(Myreview.newInstance());
            }
        });

        mIvstore = (ImageView)view.findViewById(R.id.saveshop);
        mIvstore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Mypage)getActivity()).replaceFragment(StoreShop.newInstance());
            }
        });
        // Inflate the layout for this fragment
        return view;
//        return inflater.inflate(R.layout.fragment_mypage_main, container, false);
    }


    @Override
    public void validateSuccess(int code, String message, String name, String writing, String email, String phone, String signuptime) {
        System.out.println("성공!!!" + name);
        username.setText(name);
        comment.setText(writing);
        _email.setText(email);
        _phone.setText(phone);
        regitday.setText(signuptime);
    }

    @Override
    public void validateFailure(int code, String message) {
        System.out.println("실패!!" + " " + message);
    }
}
