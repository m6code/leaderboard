package com.m6code.leaderboard.data;

import com.m6code.leaderboard.data.LearningData;

import java.util.ArrayList;

public class LearningDummyData {

    private ArrayList<com.m6code.leaderboard.data.LearningData> mDataList = new ArrayList<>();

    public ArrayList<com.m6code.leaderboard.data.LearningData> getDataList() {
        return mDataList;
    }

    public void initData() {
        LearningData l1 = new LearningData("Kojo Funds", "67", "Libya", "https://res.cloudinary.com/mikeattara/image/upload/v1596700848/Top-learner.png");
        LearningData l2 = new LearningData("Johnny Drille", "89", "Nigeria", "https://res.cloudinary.com/mikeattara/image/upload/v1596700848/Top-learner.png");
        LearningData l3 = new LearningData("Teacher Kanye", "47", "Ghana", "https://res.cloudinary.com/mikeattara/image/upload/v1596700848/Top-learner.png");
        LearningData l4 = new LearningData("Jim Lawson", "334", "Kenya", "https://res.cloudinary.com/mikeattara/image/upload/v1596700848/Top-learner.png");
        LearningData l5 = new LearningData("Brown Black", "90", "S Africa", "https://res.cloudinary.com/mikeattara/image/upload/v1596700848/Top-learner.png");
        LearningData l6 = new LearningData("Funke AkinLala", "56", "Nigeria", "https://res.cloudinary.com/mikeattara/image/upload/v1596700848/Top-learner.png");
        LearningData l7 = new LearningData("Girlee Ranking", "56", "Ghana", "https://res.cloudinary.com/mikeattara/image/upload/v1596700848/Top-learner.png");
        LearningData l8 = new LearningData("Adams Vjay", "34", "India", "https://res.cloudinary.com/mikeattara/image/upload/v1596700848/Top-learner.png");
        LearningData l9 = new LearningData("Demain Marley", "67", "Africa Republica", "https://res.cloudinary.com/mikeattara/image/upload/v1596700848/Top-learner.png");

        mDataList.add(l1);
        mDataList.add(l2);
        mDataList.add(l3);
        mDataList.add(l4);
        mDataList.add(l5);
        mDataList.add(l6);
        mDataList.add(l7);
        mDataList.add(l8);
        mDataList.add(l9);

    }
}
