package com.example.project_chachacha.template.src.myPage.MyPageMain.Interfaces;

public interface MypageMainView {
    void validateSuccess(int code, String message, String name, String writing, String email, String phone, String signuptime);

    void validateFailure(int code, String message);
}
