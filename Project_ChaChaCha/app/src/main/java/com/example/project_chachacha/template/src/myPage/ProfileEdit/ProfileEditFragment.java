package com.example.project_chachacha.template.src.myPage.ProfileEdit;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project_chachacha.R;
import com.example.project_chachacha.template.src.CustomDialogOneButton;
import com.example.project_chachacha.template.src.myPage.MyPageMain.Interfaces.MypageMainView;
import com.example.project_chachacha.template.src.myPage.MyPageMain.MypageMainService;
import com.example.project_chachacha.template.src.myPage.MypageActivity;
import com.example.project_chachacha.template.src.myPage.MyPageMain.MypageMainFragment;
import com.example.project_chachacha.template.src.myPage.ProfileEdit.Interfaces.ProfileEditView;

import java.util.regex.Pattern;

import static com.example.project_chachacha.template.src.ApplicationClass.USERID;


public class ProfileEditFragment extends Fragment implements ProfileEditView, MypageMainView, MypageActivity.OnBackPressedListener {

    private EditText mEdtComment, mEdtEmail, mEdtPhone, mEdtName;
    private CustomDialogOneButton customDialogOneButton;

    private ProfileEditFragment mProfileEditFragment;

    private String msg;

    public static ProfileEditFragment newInstance(){
        return new ProfileEditFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile__edit,container, false);

        mProfileEditFragment = new ProfileEditFragment();

        mEdtName = view.findViewById(R.id.profileEdit_edt_name);
        mEdtComment = view.findViewById(R.id.profileEdit_edt_comment);
        mEdtEmail = view.findViewById(R.id.profileEdit_edt_email);
        mEdtPhone = view.findViewById(R.id.profileEdit_edt_phone);

        ImageView mIvBack = view.findViewById(R.id.profileEdit_iv_back);
        mIvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getActivity()!=null){
                    ((MypageActivity)getActivity()).replaceFragment(MypageMainFragment.newInstance());

                }
            }
        });

        final MypageMainService mypageMainService = new MypageMainService(this);
        mypageMainService.getMypage(USERID);

        final ProfileEditService profileEditService = new ProfileEditService(this);

        TextView mTvCommit = view.findViewById(R.id.profileEdit_tv_commit);
        mTvCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(USERID);
                String userName = mEdtName.getText().toString();
                String comment = mEdtComment.getText().toString();
                String email = mEdtEmail.getText().toString();
                String phone = mEdtPhone.getText().toString();
                if(userName.equals("")){
                    customDialogOneButton = new CustomDialogOneButton(getContext(), "이름을 입력해주세요.");
                    customDialogOneButton.setCancelable(false);
                    customDialogOneButton.show();
                    mEdtName.requestFocus();
                }
                else if(comment.equals("")){
                    customDialogOneButton = new CustomDialogOneButton(getContext(), "소개글을 입력해주세요.");
                    customDialogOneButton.setCancelable(false);
                    customDialogOneButton.show();
                    mEdtComment.requestFocus();
                }
                else if(email.equals("")){
                    customDialogOneButton = new CustomDialogOneButton(getContext(), "이메일을 입력해주세요.");
                    customDialogOneButton.setCancelable(false);
                    customDialogOneButton.show();
                    mEdtEmail.requestFocus();
                }
                else if(phone.equals("")){
                    customDialogOneButton = new CustomDialogOneButton(getContext(), "전화번호를 입력해주세요.");
                    customDialogOneButton.setCancelable(false);
                    customDialogOneButton.show();
                    mEdtPhone.requestFocus();
                }
                else if(!Pattern.matches("^[가-힣]{2,5}$",userName)){
                    customDialogOneButton = new CustomDialogOneButton(getContext(), "이름을 올바르게 입력해주세요.");
                    customDialogOneButton.setCancelable(false);
                    customDialogOneButton.show();
                    mEdtName.requestFocus();
                }
                else if(!Pattern.matches("^[가-힣0-9a-zA-Z\\s]*$",comment)){
                    customDialogOneButton = new CustomDialogOneButton(getContext(), "소개글을 올바르게 입력해주세요.\n한글,영문,숫자 형식입니다.");
                    customDialogOneButton.setCancelable(false);
                    customDialogOneButton.show();
                    mEdtComment.requestFocus();
                }
                else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    customDialogOneButton = new CustomDialogOneButton(getContext(), "올바른 이메일 형식으로 입력해주세요.");
                    customDialogOneButton.setCancelable(false);
                    customDialogOneButton.show();
                    mEdtEmail.requestFocus();
                }
                else if(!Pattern.matches("^01([0|1|6|7|8|9][0-9]{3,4}[0-9]{4})$",phone)){
                    customDialogOneButton = new CustomDialogOneButton(getContext(), "올바른 전화번호 형식으로 입력해주세요.");
                    customDialogOneButton.setCancelable(false);
                    customDialogOneButton.show();
                    mEdtPhone.requestFocus();
                }
                else{
                    System.out.println("실행????");
                    profileEditService.patchEdit(USERID, mEdtName.getText().toString(), mEdtComment.getText().toString(),
                            mEdtEmail.getText().toString(), mEdtPhone.getText().toString());
                }
            }
        });



        // Inflate the layout for this fragment
        return view;
//        return inflater.inflate(R.layout.fragment_profile__edit, container, false);
    }


    @Override
    public void validateSuccess(int code, String message) {
        System.out.println(code + " ????????");
        final int Success = 200;
        final int InvalidToken = 201;
        final int InvalidFormName = 103;
        final int InvalidFormPhone = 106;
        final int InvalideFormComment = 116;
        final int empty = 109;
        final int InvalidUserId = 399;
        final int duplicateEmail = 102;
        if (code==Success){
            System.out.println("마이페이지 수정 성공: "+ message);
            if(getActivity()!=null){
                ((MypageActivity)getActivity()).replaceFragment(MypageMainFragment.newInstance());
            }
        }
        else{
            switch (code){
                case InvalidToken:
                    msg = "유효하지 않은 토큰입니다.\n다시 로그인 해주세요.";
                    customDialogOneButton = new CustomDialogOneButton(getContext(),msg);
                    customDialogOneButton.setCancelable(false);
                    customDialogOneButton.show();
                    if(getActivity()!=null){
                        getActivity().finish();
                    }
                    break;
                case InvalidFormName:
                    msg = "이름을 올바르게 입력해주세요.";
                    customDialogOneButton = new CustomDialogOneButton(getContext(),msg);
                    customDialogOneButton.setCancelable(false);
                    customDialogOneButton.show();
                    mEdtName.requestFocus();
                    break;
                case InvalidFormPhone:
                    msg = "올바른 전화번호 형식으로 입력해주세요.";
                    customDialogOneButton = new CustomDialogOneButton(getContext(),msg);
                    customDialogOneButton.setCancelable(false);
                    customDialogOneButton.show();
                    mEdtPhone.requestFocus();
                    break;
                case InvalideFormComment:
                    msg = "소개글을 올바르게 입력해주세요.\n한글,영문,숫자 형식입니다.";
                    customDialogOneButton = new CustomDialogOneButton(getContext(),msg);
                    customDialogOneButton.setCancelable(false);
                    customDialogOneButton.show();
                    mEdtComment.requestFocus();
                    break;
                case empty:
                    msg = "모든 항목을 입력해주세요.";
                    customDialogOneButton = new CustomDialogOneButton(getContext(),msg);
                    customDialogOneButton.setCancelable(false);
                    customDialogOneButton.show();
                    break;
                case InvalidUserId:
                    msg = "유효하지 않은 아이디입니다.\n다시 로그인 해주세요.";
                    customDialogOneButton = new CustomDialogOneButton(getContext(),msg);
                    customDialogOneButton.setCancelable(false);
                    customDialogOneButton.show();
                    if(getActivity()!=null){
                        getActivity().finish();
                    }
                    break;
                case duplicateEmail:
                    msg = "중복된 이메일입니다.";
                    customDialogOneButton = new CustomDialogOneButton(getContext(),msg);
                    customDialogOneButton.setCancelable(false);
                    customDialogOneButton.show();
                    mEdtEmail.requestFocus();
                    break;
            }
        }

    }

    @Override
    public void validateSuccess(int code, String message, String name, String writing, String email, String phone, String signuptime) {
        if(code==115){
            mEdtName.setText(name);
            mEdtComment.setText(writing);
            mEdtEmail.setText(email);
            phone = phone.replace("-","");
            mEdtPhone.setText(phone);
        }
    }

    @Override
    public void validateFailure(int code, String message) {
        System.out.println("마이페이지 수정: " + message);
        msg = "서버가 응답하지 않습니다.";
        customDialogOneButton = new CustomDialogOneButton(getContext(),msg);
        customDialogOneButton.setCancelable(false);
        customDialogOneButton.show();
    }

    @Override
    public void onBack() {
        MypageActivity activity = (MypageActivity)getActivity();
        activity.setOnBackPressedListener(null);
        activity.replaceFragment(MypageMainFragment.newInstance());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ((MypageActivity)context).setOnBackPressedListener(this);
    }
}
