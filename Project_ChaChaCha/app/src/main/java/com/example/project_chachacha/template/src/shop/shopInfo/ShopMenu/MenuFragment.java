package com.example.project_chachacha.template.src.shop.shopInfo.ShopMenu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.project_chachacha.R;
import com.example.project_chachacha.template.src.CustomDialogOneButton;
import com.example.project_chachacha.template.src.shop.shopInfo.ShopMenu.Interfaces.MenuView;
import com.example.project_chachacha.template.src.shop.shopInfo.ShopMenu.models.MenuResult;
import com.example.project_chachacha.template.src.shop.shopInfo.ShopMenu.models.food;

import java.util.ArrayList;
import java.util.List;

public class MenuFragment extends Fragment implements MenuView {

    private RecyclerView foodRecyclerView;
    private ArrayList<MenuItemData> foodArrayList;
    private MenuListAdapter foodAdapter;

    private RecyclerView drinkRecyclerView;
    private ArrayList<MenuItemData> drinkArrayList;
    private MenuListAdapter drinkAdapter;

    private TextView mTvFood;
    private TextView mTvDrink;

    private String message;

    private CustomDialogOneButton customDialogOneButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootview = (ViewGroup)inflater.inflate(R.layout.fragment_menu, container, false);

        mTvFood = rootview.findViewById(R.id.shopMenu_tv_food);
        mTvDrink = rootview.findViewById(R.id.shopMenu_tv_drink);

        mTvFood.setVisibility(View.VISIBLE);
        mTvDrink.setVisibility(View.VISIBLE);

        foodRecyclerView = rootview.findViewById(R.id.shopMenu_rv_foodList);
        foodRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        foodArrayList = new ArrayList<>();
        foodAdapter = new MenuListAdapter(getActivity(), foodArrayList);
        foodRecyclerView.setAdapter(foodAdapter);

        drinkRecyclerView = rootview.findViewById(R.id.shopMenu_rv_drinkList);
        drinkRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        drinkArrayList = new ArrayList<>();
        drinkAdapter = new MenuListAdapter(getActivity(), drinkArrayList);
        drinkRecyclerView.setAdapter(drinkAdapter);

        final MenuService menuService = new MenuService(this);
        menuService.getShopMenu(8); // storeNum 받아서 처리
        // Inflate the layout for this fragment
        return rootview;
    }


    @Override
    public void validateSuccess(int code, MenuResult menuResult) {
        final int Success = 211;
        final int InvalidToken = 201;
        final int storeNumFormError = 212;
        final int InvalidStoreNum = 499;
        if(code == Success){
            List<food> foodList = menuResult.getFoodList();
            List<food> drinkList = menuResult.getDrinkList();
            if(foodList.size()==0){
                mTvFood.setVisibility(View.GONE);
            }
            else{
                mTvFood.setText("안주류");
                for(int k =0; k<20; k++){
                    for(int i=0; i<foodList.size(); i++){
                        MenuItemData menuItemData = new MenuItemData(foodList.get(i).getMenuname(),foodList.get(i).getMenuprice());
                        foodArrayList.add(menuItemData);
                    }
                }
                foodAdapter.notifyDataSetChanged();
            }

            if(drinkList.size()==0){
                mTvDrink.setVisibility(View.GONE);
            }
            else{
                mTvDrink.setText("주류");
                for(int k=0; k<5; k++){
                    for(int i=0; i<drinkList.size(); i++){
                        MenuItemData menuItemData = new MenuItemData(drinkList.get(i).getMenuname(), drinkList.get(i).getMenuprice());
                        drinkArrayList.add(menuItemData);
                    }
                }
                drinkAdapter.notifyDataSetChanged();
            }
        }
        else{
            switch (code){
                case InvalidToken:
                    message="로그인이 만료되었습니다.\n다시 로그인해주세요.";
                    break;
                case storeNumFormError:
                    message="storeNum형식이 올바르지 않습니다.";
                    break;
                case InvalidStoreNum:
                    message="유효하지 않은 storeNum입니다.";
                    break;
            }
            customDialogOneButton = new CustomDialogOneButton(getContext(),message);
            customDialogOneButton.setCancelable(true);
            customDialogOneButton.show();
        }
    }

    @Override
    public void validateFailure(String message) {
        System.out.println("MenuFragment: " + message);
    }
}
