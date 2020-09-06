package com.m6code.leaderboard.services;

import com.m6code.leaderboard.data.Learner;
import com.m6code.leaderboard.data.SkillQ;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {

    @GET("api/hours")
    Call<ArrayList<Learner>> getTopLearners();

    @GET("api/skilliq")
    Call<ArrayList<SkillQ>> getTopSkillIQScores();

}
