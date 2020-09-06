package com.m6code.leaderboard.services;

import com.m6code.leaderboard.data.LearningData;
import com.m6code.leaderboard.data.SkillData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {

    @GET("api/hours")
    Call<LearningData> getTopLearners();

    @GET("api/skilliq")
    Call<SkillData> getTopSkillIQScores();

}
