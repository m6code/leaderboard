package com.m6code.leaderboard;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.m6code.leaderboard.data.LearningData;
import com.m6code.leaderboard.data.SkillData;
import com.m6code.leaderboard.services.ApiServiceBuilder;
import com.m6code.leaderboard.services.ApiServices;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ApiServices apiServices = ApiServiceBuilder.buildApiService(ApiServices.class);
//        Call<ArrayList<LearningData>> callLearners = apiServices.getTopLearners();
//        Call<ArrayList<SkillData>> callSkills = apiServices.getTopSkillIQScores();
//
//        callLearners.enqueue(new Callback<ArrayList<LearningData>>() {
//            @Override
//            public void onResponse(Call<ArrayList<LearningData>> call, Response<ArrayList<LearningData>> response) {
//                Log.i("learners response", response.body().toString());
//            }
//
//            @Override
//            public void onFailure(Call<List<LearningData>> call, Throwable t) {
//                Log.e("fectch learners error", "Failed to get learners");
//            }
//        });
//
//        callSkills.enqueue(new Callback<ArrayList<SkillData>>() {
//            @Override
//            public void onResponse(Call<ArrayList<SkillData>> call, Response<ArrayList<SkillData>> response) {
//                Log.i("skills response", response.body().toString());
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<SkillData>> call, Throwable t) {
//                Log.e("fectch skill error", "Failed to get skills");
//            }
//        });



        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        Button launchSubmitForm = findViewById(R.id.btn_submit);

        launchSubmitForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Show toast here
                // Snackbar.make(view, "Launch Submit Form", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                startActivity(new Intent(MainActivity.this, SubmitActivity.class));
            }
        });

    }

}