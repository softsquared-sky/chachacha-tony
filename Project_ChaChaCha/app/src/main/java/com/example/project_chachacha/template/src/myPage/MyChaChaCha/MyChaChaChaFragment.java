package com.example.project_chachacha.template.src.myPage.MyChaChaCha;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project_chachacha.R;
import com.example.project_chachacha.template.src.CustomDialogOneButton;
import com.example.project_chachacha.template.src.myPage.MyChaChaCha.Interfaces.MyChaChaChaView;
import com.example.project_chachacha.template.src.myPage.MyChaChaCha.models.MyChaChaChaResponse;
import com.example.project_chachacha.template.src.myPage.MyChaChaCha.models.MyChaChaChaResult;

import java.util.ArrayList;
import java.util.List;

import static com.example.project_chachacha.template.src.ApplicationClass.USERID;

public class MyChaChaChaFragment extends Fragment implements MyChaChaChaView {

    private RecyclerView recyclerView;
    private MyChaChaChaListAdapter adapter;
    private ArrayList<MyChaChaChaItemData> arrayList;
    private GridLayoutManager gridLayoutManager;

    private String mStrMessage;

    private CustomDialogOneButton mCustomDialogOneButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootview = (ViewGroup)inflater.inflate(R.layout.fragment_my_cha_cha_cha, container, false);

        arrayList = new ArrayList<>();

        recyclerView = rootview.findViewById(R.id.myChaChaCha_rv_list);
        adapter = new MyChaChaChaListAdapter(getContext(), arrayList);

        gridLayoutManager = new GridLayoutManager(getContext(), 2);


        recyclerView.setLayoutManager(gridLayoutManager);

        recyclerView.setAdapter(adapter);

        final MyChaChaChaService myChaChaChaService = new MyChaChaChaService(this);
        myChaChaChaService.getMyChaChaCha(USERID);

        // Inflate the layout for this fragment
        return rootview;
    }


    @Override
    public void validateSuccess(int code, List<MyChaChaChaResult> list) {
        final int Success = 224;
        final int InvalidToken = 201;
        final int InvalidUserId = 399;
        if(code == Success){
            for(int i=0; i<list.size(); i++){
                MyChaChaChaItemData myChaChaChaItemData = new MyChaChaChaItemData(list.get(i).getChanum(), list.get(i).getStorenum(),list.get(i).getImageurl(), list.get(i).getStorename());
                arrayList.add(myChaChaChaItemData);
            }
            adapter.notifyDataSetChanged();
        }
        else{
            switch (code){
                case InvalidToken:
                    mStrMessage = "유효하지 않은 토큰입니다.\n다시 로그인 해주세요.";
                    break;
                case InvalidUserId:
                    mStrMessage = "유효하지 않은 userId입니다.";
                    break;
            }
            mCustomDialogOneButton = new CustomDialogOneButton(getContext(), mStrMessage);
            mCustomDialogOneButton.setCancelable(false);
            mCustomDialogOneButton.show();
        }
    }

    @Override
    public void validateSuccessDelete(int code) {

    }

    @Override
    public void validateFailure(String message) {
        mCustomDialogOneButton = new CustomDialogOneButton(getContext(), message);
        mCustomDialogOneButton.setCancelable(false);
        mCustomDialogOneButton.show();
    }
}
