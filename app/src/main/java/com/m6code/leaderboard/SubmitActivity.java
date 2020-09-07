package com.m6code.leaderboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;

public class SubmitActivity extends AppCompatActivity {

    private ConstraintLayout mSubmitPopUpWindow;
    private ConstraintLayout mResponsePopUpWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        ImageButton backButton = findViewById(R.id.back_imageButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button submitButton = findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Todo: Create popup window to confirm
                createSubmitPopUpWindow();
            }
        });

        mResponsePopUpWindow = findViewById(R.id.response_popup_ConstraintLayout);


    }

    public void createSubmitPopUpWindow(){
        LayoutInflater layoutInflater = (LayoutInflater) SubmitActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View submitPopUp = layoutInflater.inflate(R.layout.popup_window_submit,null);

        // Cancel imageButton
        ImageButton closeIBtn = submitPopUp.findViewById(R.id.cancel_imageButton);
        // Yes Button
        Button continueBtn = submitPopUp.findViewById(R.id.confirm_submit_button);

        mSubmitPopUpWindow = submitPopUp.findViewById(R.id.submit_popup_ConstraintLayout);

        PopupWindow confirmSubmitPopUpWindow = new PopupWindow(submitPopUp, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        confirmSubmitPopUpWindow.showAtLocation(mSubmitPopUpWindow, Gravity.CENTER, 0, 0);

        closeIBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmSubmitPopUpWindow.dismiss();
            }
        });

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: Submit form
                // todo: show success message dialog
                Toast.makeText(getApplicationContext(),"Success submission", Toast.LENGTH_SHORT).show();
            }
        });

        continueBtn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                // TODO: show failure message dialog
                Toast.makeText(getApplicationContext(),"Success failure", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }
}