package com.example.project_chachacha.template.src.mypage.Myreview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_chachacha.R;
import com.example.project_chachacha.template.src.mypage.MypageActivity;
import com.example.project_chachacha.template.src.mypage.MypageMain.MypageMainFragment;
import com.example.project_chachacha.template.src.mypage.Myreview.Interfaces.MyreviewView;
import com.example.project_chachacha.template.src.mypage.Myreview.models.ResultItem;

import java.util.ArrayList;
import java.util.List;

import static com.example.project_chachacha.template.src.ApplicationClass.USERID;


public class MyreviewFragment extends Fragment implements MyreviewView {

    private ArrayList<MyreviewItemData> arrayList;
    private MyreviewListAdapter adapter;

    public static MyreviewFragment newInstance(){
        return new MyreviewFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_myreview, container, false);

        ImageView mIvBack = rootView.findViewById(R.id.myreview_iv_back);
        mIvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MypageActivity)getActivity()).replaceFragment(MypageMainFragment.newInstance());
            }
        });

        final MyreviewService myreviewService = new MyreviewService(this);
        myreviewService.getUserReview(USERID);

        RecyclerView recyclerView = rootView.findViewById(R.id.myreview_rv_reviewList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        arrayList = new ArrayList<>();

        adapter = new MyreviewListAdapter(getActivity(), arrayList); // 생성에 context필요할수도?

        recyclerView.setAdapter(adapter);
        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void validateSuccess(int code, String message, List<ResultItem> resultItems) {
        if(code==202){
            List<ResultItem> result = resultItems;
            for(int i=0; i<result.size(); i++){
                arrayList.add(new MyreviewItemData(R.drawable.ic_launcher_foreground,result.get(i).getStorename(),result.get(i).getStar(), result.get(i).getAddress(), result.get(i).getText()));
            }
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void validateFailure(int code, String message) {
        System.out.println(code + " " + message);
    }
}
