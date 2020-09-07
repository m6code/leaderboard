package com.m6code.leaderboard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.m6code.leaderboard.services.ApiFormSubmitService;
import com.m6code.leaderboard.services.ApiServiceBuilder;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmitActivity extends AppCompatActivity {

    private static final String TAG = "SubmitProjectActivity";

    private Dialog mDialog;
    private EditText mFirstNameEditText;
    private EditText mLastNameEditText;
    private EditText mEmailEditText;
    private EditText mGithubLinkEditText;
    private String mFirstName;
    private String mLastName;
    private String mEmail;
    private String mGhLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        // Get EditText Views
        mFirstNameEditText = findViewById(R.id.editTextTextFirstName);
        mLastNameEditText = findViewById(R.id.editTextTextLastName);
        mEmailEditText = findViewById(R.id.editTextTextEmailAddress);
        mGithubLinkEditText = findViewById(R.id.editTextTextProjectLink);
        getFormData();

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
                //Todo: Validate form data before creating popup
                if (isValidFormData()) {
                    // Create dialog to confirm submit
                    createSubmitConfirmationDialog();
                }
            }
        });


    }

    public void createSubmitConfirmationDialog() {
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
                // Submit Form
                ApiFormSubmitService submitService = ApiServiceBuilder.buildApiService(ApiFormSubmitService.class);
                Call<Void> submitFormData = submitService.submitForm(
                        "https://docs.google.com/forms/d/e/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse",
                        mFirstName,
                        mLastName,
                        mEmail,
                        mGhLink
                );

                submitFormData.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(@NotNull Call<Void> call, @NotNull Response<Void> response) {
                        // Calls method to create and show success message dialog
                        createResponseDialog(R.drawable.ic_baseline_check_circle_24, R.string.submission_success);

                        if (response.isSuccessful()) {
                            clearFormEntry();
                            //Log.e(TAG, "post-onResponse: " + response.message() + "\n\n" + response.body() + "\n\n" + response.errorBody());
                            Toast.makeText(SubmitActivity.this, "Success " + response.message(), Toast.LENGTH_LONG).show();

                        }
                        else{
                            //createResponseDialog(R.drawable.ic_baseline_warning_24, R.string.submission_failure);
                            Toast.makeText(SubmitActivity.this, "Response Error" + response.errorBody(), Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<Void> call, @NotNull Throwable t) {
                        // Calls method to create and show failure message dialog
                        createResponseDialog(R.drawable.ic_baseline_warning_24, R.string.submission_failure);
                        Toast.makeText(SubmitActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

    }

    public void createResponseDialog(int responseImage, int responseText) {
        mDialog.dismiss();

        mDialog = new Dialog(SubmitActivity.this);
        mDialog.setContentView(R.layout.dialog_window_response);
        ImageView responseImg = mDialog.findViewById(R.id.response_imageView);
        TextView responseTV = mDialog.findViewById(R.id.response_textView);

        //populate with appropriate content base on response message
        responseImg.setImageResource(responseImage);
        responseTV.setText(getString(responseText));
        mDialog.show();
    }

    public void clearFormEntry() {
        mFirstNameEditText.setText("");
        mLastNameEditText.setText("");
        mEmailEditText.setText("");
        mGithubLinkEditText.setText("");
    }

    public boolean isValidFormData() {
        getFormData();

        boolean isValid = false;

        if (mFirstName.trim().isEmpty()) {
            mFirstNameEditText.requestFocus();
            mFirstNameEditText.setError("First Name Required!");
        } else if (mLastName.trim().isEmpty()) {
            mLastNameEditText.requestFocus();
            mLastNameEditText.setError("Last Name Required!");
        } else if (mEmail.trim().isEmpty()) {
            mEmailEditText.requestFocus();
            mEmailEditText.setError("Email Required!");
        } else if (mGhLink.trim().isEmpty()) {
            mGithubLinkEditText.requestFocus();
            mGithubLinkEditText.setError("Project Link Required!");
        } else {
            isValid = true;
        }

        return isValid;

    }

    private void getFormData() {
        mFirstName = mFirstNameEditText.getText().toString();
        mLastName = mLastNameEditText.getText().toString();
        mEmail = mEmailEditText.getText().toString();
        mGhLink = mGithubLinkEditText.getText().toString();
    }
}