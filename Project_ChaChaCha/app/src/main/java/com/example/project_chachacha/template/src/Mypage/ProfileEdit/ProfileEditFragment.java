package com.example.project_chachacha.template.src.Mypage.ProfileEdit;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project_chachacha.R;
import com.example.project_chachacha.template.src.Mypage.MypageActivity;
import com.example.project_chachacha.template.src.Mypage.MypageMain.MypageMainFragment;
import com.example.project_chachacha.template.src.Mypage.ProfileEdit.Interfaces.ProfileEditView;

import static com.example.project_chachacha.template.src.ApplicationClass.COMMENT;
import static com.example.project_chachacha.template.src.ApplicationClass.EMAIL;
import static com.example.project_chachacha.template.src.ApplicationClass.PHONE;
import static com.example.project_chachacha.template.src.ApplicationClass.USERID;
import static com.example.project_chachacha.template.src.ApplicationClass.USERNAME;


public class ProfileEditFragment extends Fragment implements ProfileEditView {

    private EditText mEdtComment, mEdtEmail, mEdtPhone, mEdtName;

    public static ProfileEditFragment newInstance(){
        return new ProfileEditFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile__edit,container, false);
        ImageView mIvBack = view.findViewById(R.id.profileEdit_iv_back);
        mIvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MypageActivity)getActivity()).replaceFragment(MypageMainFragment.newInstance());
            }
        });

        final ProfileEditService profileEditService = new ProfileEditService(this);

        TextView mTvCommit = view.findViewById(R.id.profileEdit_tv_commit);
        mTvCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(USERID);
                profileEditService.patchEdit(USERID, mEdtName.getText().toString(), mEdtComment.getText().toString(),
                        mEdtEmail.getText().toString(), mEdtPhone.getText().toString());
            }
        });

        mEdtName = view.findViewById(R.id.profileEdit_edt_name);
        mEdtComment = view.findViewById(R.id.profileEdit_edt_comment);
        mEdtEmail = view.findViewById(R.id.profileEdit_edt_email);
        mEdtPhone = view.findViewById(R.id.profileEdit_edt_phone);

        mEdtName.setText(USERNAME);
        mEdtComment.setText(COMMENT);
        mEdtEmail.setText(EMAIL);
        String phoneTmp = PHONE.replace("-","");
        mEdtPhone.setText(phoneTmp);


        // Inflate the layout for this fragment
        return view;
//        return inflater.inflate(R.layout.fragment_profile__edit, container, false);
    }


    @Override
    public void validateSuccess(int code, String message) {
        if (code==200){
            System.out.println("마이페이지 수정 성공: "+ message);
            ((MypageActivity)getActivity()).replaceFragment(MypageMainFragment.newInstance());
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
