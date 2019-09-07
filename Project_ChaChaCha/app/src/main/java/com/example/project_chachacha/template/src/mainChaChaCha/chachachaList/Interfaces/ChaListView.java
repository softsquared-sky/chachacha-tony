package com.example.project_chachacha.template.src.mainChaChaCha.chachachaList.Interfaces;

import com.example.project_chachacha.template.src.mainChaChaCha.chachachaList.models.ChaListResult;

import java.util.List;

public interface ChaListView {

    void validateSuccess(int code, List<ChaListResult> results);

    void validateFailure(String msg);
}
