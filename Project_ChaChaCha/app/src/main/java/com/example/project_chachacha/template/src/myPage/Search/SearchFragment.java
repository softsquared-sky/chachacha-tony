package com.example.project_chachacha.template.src.myPage.Search;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project_chachacha.R;
import com.example.project_chachacha.template.src.CustomDialogOneButton;
import com.example.project_chachacha.template.src.mainChaChaCha.chachachaList.ChaChaChaListAdapter;
import com.example.project_chachacha.template.src.mainChaChaCha.chachachaList.ChaChaChaListItemData;
import com.example.project_chachacha.template.src.myPage.Search.Interfaces.SearchView;
import com.example.project_chachacha.template.src.myPage.Search.models.SearchResult;
import com.example.project_chachacha.template.src.myPage.StoreShop.StoreShopItemData;

import java.util.ArrayList;
import java.util.List;


public class SearchFragment extends Fragment implements SearchView {

    private final int size = 10;
    private int page = 0;

    private String mStrSearchStore;

    private ArrayList<ChaChaChaListItemData> arrayList; // 변경하거나 storenum 추가시키거나
    private ChaChaChaListAdapter adapter;

    private EditText mEdtSearch;

    private CustomDialogOneButton mCustomDialogOneButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_search, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.search_rv_list);
        arrayList = new ArrayList<>();
        adapter = new ChaChaChaListAdapter(getContext(), arrayList);

        recyclerView.setAdapter(adapter);

        final SearchService searchService = new SearchService(this);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int lastVisiblePosition = ((LinearLayoutManager)recyclerView.getLayoutManager()).findLastCompletelyVisibleItemPosition();
                int itemTotalCount = recyclerView.getAdapter().getItemCount();

                int temp = lastVisiblePosition + 1;

                System.out.println(itemTotalCount + " " + temp);

                if(itemTotalCount%10==0 && itemTotalCount!=0){
                    if(lastVisiblePosition+1 == itemTotalCount){
                        page = page+size;
                        searchService.getSearch(mStrSearchStore, page, size);
                    }
                }
            }
        });


        mEdtSearch = rootView.findViewById(R.id.search_edt_find);
        mEdtSearch.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
        mEdtSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_SEARCH || keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    page = 0;
                    arrayList.clear();
                    adapter.notifyDataSetChanged();
                    mStrSearchStore = mEdtSearch.getText().toString();
                    searchService.getSearch(mStrSearchStore, page, size);
                    InputMethodManager imm = (InputMethodManager) getContext().getSystemService(getContext().INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(mEdtSearch.getWindowToken(),0);
                    return true;
                }
                return false;
            }
        });

        ImageView ivSearch = rootView.findViewById(R.id.search_iv_find);
        ivSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                page = 0;
                arrayList.clear();
                adapter.notifyDataSetChanged();
                mStrSearchStore = mEdtSearch.getText().toString();
                searchService.getSearch(mStrSearchStore, page, size);
                InputMethodManager imm = (InputMethodManager) getContext().getSystemService(getContext().INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(mEdtSearch.getWindowToken(),0);
            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onResume() {
        mEdtSearch.setText("");
        super.onResume();
    }

    @Override
    public void validateSuccess(int code, List<SearchResult> result) {
        final int Success = 213;
        final int InvalidToken = 201;
        final int storeNameError = 214;
        final int pageNumError = 280;
        final int sizeNumError = 279;
        if(code == Success){
            System.out.println("반복");
            System.out.println(arrayList.size());
            for(int i=0; i<result.size(); i++){
                arrayList.add(new ChaChaChaListItemData(result.get(i).getStorename(),result.get(i).getMode(),result.get(i).getStorewriting(),result.get(i).getImageurl(),result.get(i).getStorenum()));
            }
            adapter.notifyDataSetChanged();

            System.out.println("사이즈는: " +result.size() + " " + arrayList.size());
            if(result.size()==0){
                if(arrayList.size()==0){
                    CustomDialogOneButton customDialogOneButton = new CustomDialogOneButton(getContext(), "검색결과가 없습니다.");
                    customDialogOneButton.setCancelable(false);
                    customDialogOneButton.show();
                    mEdtSearch.setText("");
                }
            }
        }
    }

    @Override
    public void validateFailure(String msg) {
        mCustomDialogOneButton = new CustomDialogOneButton(getContext(), msg);
    }
}
