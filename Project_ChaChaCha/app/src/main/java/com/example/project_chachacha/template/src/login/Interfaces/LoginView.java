package com.example.project_chachacha.template.src.login.Interfaces;

public interface LoginView {

    void validateSuccess(int code, String message, String jwt);

    void validateFailure(int code, String message);
}
