package com.example.project_chachacha.template.src.myPage.MyChaChaCha.Interfaces;

import com.example.project_chachacha.template.src.myPage.MyChaChaCha.models.MyChaChaChaResult;

import java.util.List;

public interface MyChaChaChaView {

    void validateSuccess(int code, List<MyChaChaChaResult> list);

    void validateSuccessDelete(int code);

    void validateFailure(String message);

}
