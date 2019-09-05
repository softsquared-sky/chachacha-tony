package com.example.project_chachacha.template.src;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.project_chachacha.R;

public class CustomDialogTwoButton extends Dialog {

    private Context mContext;
    private TextView mTvContent;
    private TextView mTvYes;
    private TextView mTvNo;

    private View.OnClickListener mLeftClickListener;

    private String mStrText;

    public CustomDialogTwoButton(Context context, String content, View.OnClickListener leftListener) {
        super(context);
        this.mContext = context;
        this.mStrText = content;
        this.mLeftClickListener = leftListener;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog_two_button);

        mTvContent = findViewById(R.id.customdialogTwoButton_tv_message);
        mTvContent.setText(mStrText);

        mTvYes = findViewById(R.id.btn_yes);
        mTvYes.setOnClickListener(mLeftClickListener);

        mTvNo = findViewById(R.id.btn_no);
        mTvNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }
}
