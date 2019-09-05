package com.example.project_chachacha.template.src.myPage.StoreShop;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.project_chachacha.R;
import com.example.project_chachacha.template.src.myPage.MypageActivity;
import com.example.project_chachacha.template.src.myPage.MyPageMain.MypageMainFragment;
import com.example.project_chachacha.template.src.myPage.StoreShop.Intenfaces.StoreShopView;
import com.example.project_chachacha.template.src.myPage.StoreShop.models.ResultStoreShop;

import java.util.ArrayList;
import java.util.List;

import static com.example.project_chachacha.template.src.ApplicationClass.USERID;


public class StoreShopFragment extends Fragment implements StoreShopView {

    private RecyclerView recyclerView;
    private StoreShopListAdapter adapter;
    private ArrayList<StoreShopItemData> arrayList;

    private ImageView mIvBack;

    public static StoreShopFragment newInstance() {
        return new StoreShopFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_store_shop, container, false);

        final StoreShopService storeShopService = new StoreShopService(this);
        storeShopService.getBookMark(USERID);

        mIvBack = rootView.findViewById(R.id.storeShop_iv_back);
        mIvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MypageActivity) getActivity()).replaceFragment(MypageMainFragment.newInstance());
            }
        });

        recyclerView = rootView.findViewById(R.id.storeShop_rv_list);
        arrayList = new ArrayList<>();

        adapter = new StoreShopListAdapter(getContext(), arrayList);

        recyclerView.setAdapter(adapter);
        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void validateSuccess(int code, String message, List<ResultStoreShop> resultItems) {
        if (code == 204) {
            List<ResultStoreShop> results = resultItems;
            for (int i = 0; i < results.size(); i++) {
                arrayList.add(new StoreShopItemData(results.get(i).getStorename(), results.get(i).getMode(), results.get(i).getStorewriting(), results.get(i).getImageurl()));
            }
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void validateFailure(int code, String message) {

    }
}
