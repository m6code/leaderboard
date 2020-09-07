package com.m6code.leaderboard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
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
import android.widget.TextView;
import android.widget.Toast;

public class SubmitActivity extends AppCompatActivity {

    private Dialog mDialog;

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
                createSubmitDialogWindow();
            }
        });
    }

    public void createSubmitDialogWindow(){

        mDialog = new Dialog(this);
        mDialog.setContentView(R.layout.dialog_window_submit);

        // Cancel imageButton
        ImageButton closeIBtn = mDialog.findViewById(R.id.cancel_imageButton);
        // Yes Button
        Button continueBtn = mDialog.findViewById(R.id.confirm_submit_button);
        mDialog.setCanceledOnTouchOutside(false);
        mDialog.show();


        closeIBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDialog.cancel();
            }
        });

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: Submit form
                mDialog.dismiss();
                // todo: show success message dialog
                    // todo : create dialog
                mDialog = new Dialog(SubmitActivity.this);
                mDialog.setContentView(R.layout.dialog_window_response);
                ImageView responseImg = mDialog.findViewById(R.id.response_imageView);
                TextView responseTV = mDialog.findViewById(R.id.response_textView);
                    // todo : populate with appropraite content
                responseImg.setImageResource(R.drawable.ic_baseline_check_circle_24);
                responseTV.setText(getString(R.string.submission_success));
                mDialog.show();
                Toast.makeText(getApplicationContext(),"Success submission", Toast.LENGTH_SHORT).show();
            }
        });

        continueBtn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mDialog.dismiss();
                // TODO: show failure message dialog
                mDialog = new Dialog(SubmitActivity.this);
                mDialog.setContentView(R.layout.dialog_window_response);
                ImageView responseImg = mDialog.findViewById(R.id.response_imageView);
                TextView responseTV = mDialog.findViewById(R.id.response_textView);
                // todo : populate with appropraite content
                responseImg.setImageResource(R.drawable.ic_baseline_warning_24);
                responseTV.setText(getString(R.string.submission_failure));
                mDialog.show();
                Toast.makeText(getApplicationContext(),"Success failure", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }
}