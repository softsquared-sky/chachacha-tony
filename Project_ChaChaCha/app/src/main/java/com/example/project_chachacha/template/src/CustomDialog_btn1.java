package com.example.project_chachacha.template.src;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.project_chachacha.R;

public class CustomDialog_btn1 extends Dialog {
    private Context context;

    private TextView mbtn;
    private TextView msg;
    String tmp;

    public CustomDialog_btn1(Context context, String s) {
        super(context);
        this.context = context;
        this.tmp = s;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog_btn1);

        msg = findViewById(R.id.message);
        msg.setText(tmp);

        mbtn = findViewById(R.id.btn);
        mbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }
}
