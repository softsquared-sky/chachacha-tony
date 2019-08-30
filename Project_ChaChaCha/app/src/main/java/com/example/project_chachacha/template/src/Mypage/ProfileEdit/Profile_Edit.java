package com.example.project_chachacha.template.src.Mypage.ProfileEdit;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project_chachacha.R;
import com.example.project_chachacha.template.src.Mypage.Mypage;
import com.example.project_chachacha.template.src.Mypage.Mypage_main;
import com.example.project_chachacha.template.src.Mypage.ProfileEdit.Interfaces.ProfileEditView;

import static com.example.project_chachacha.template.src.ApplicationClass._COMMENT;
import static com.example.project_chachacha.template.src.ApplicationClass._EMAIL;
import static com.example.project_chachacha.template.src.ApplicationClass._PHONE;
import static com.example.project_chachacha.template.src.ApplicationClass._USERID;
import static com.example.project_chachacha.template.src.ApplicationClass._USERNAME;


public class Profile_Edit extends Fragment implements ProfileEditView {

    private ImageView mIvback;
    private TextView mTvcommit;
    private EditText comment, email, callNum, name;

    public static Profile_Edit newInstance(){
        return new Profile_Edit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile__edit,null);
        mIvback = view.findViewById(R.id.back);
        mIvback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Mypage)getActivity()).replaceFragment(Mypage_main.newInstance());
            }
        });

        final ProfileEditService profileEditService = new ProfileEditService(this);

        mTvcommit = view.findViewById(R.id.commit);
        mTvcommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profileEditService.patchEdit(_USERID, name.getText().toString(), comment.getText().toString(),
                        email.getText().toString(),callNum.getText().toString());
            }
        });

        name = view.findViewById(R.id.name);
        comment = view.findViewById(R.id.comment);
        email = view.findViewById(R.id.email);
        callNum = view.findViewById(R.id.callNum);

        name.setText(_USERNAME);
        comment.setText(_COMMENT);
        email.setText(_EMAIL);
        String phoneTmp = _PHONE.replace("-","");
        callNum.setText(phoneTmp);


        // Inflate the layout for this fragment
        return view;
//        return inflater.inflate(R.layout.fragment_profile__edit, container, false);
    }


    @Override
    public void validateSuccess(int code, String message) {
        if (code==200){
            System.out.println("마이페이지 수정 성공: "+ message);
            ((Mypage)getActivity()).replaceFragment(Mypage_main.newInstance());
        }
        else{
            System.out.println(code + " " + message);
        }

    }

    @Override
    public void validateFailure(int code, String message) {
        System.out.println("마이페이지 수정: " + message);
    }
}
