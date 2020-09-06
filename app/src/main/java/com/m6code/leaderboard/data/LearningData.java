package com.m6code.leaderboard.data;

import java.util.ArrayList;

public class LearningData {

    private ArrayList<Learner> mDataList = new ArrayList<>();

    public ArrayList<Learner> getDataList() {
        return mDataList;
    }

    public void initData() {
        Learner l1 = new Learner("Kojo Funds", "67", "Libya", "https://res.cloudinary.com/mikeattara/image/upload/v1596700848/Top-learner.png");
        Learner l2 = new Learner("Johnny Drille", "89", "Nigeria", "https://res.cloudinary.com/mikeattara/image/upload/v1596700848/Top-learner.png");
        Learner l3 = new Learner("Teacher Kanye", "47", "Ghana", "https://res.cloudinary.com/mikeattara/image/upload/v1596700848/Top-learner.png");
        Learner l4 = new Learner("Jim Lawson", "334", "Kenya", "https://res.cloudinary.com/mikeattara/image/upload/v1596700848/Top-learner.png");
        Learner l5 = new Learner("Brown Black", "90", "S Africa", "https://res.cloudinary.com/mikeattara/image/upload/v1596700848/Top-learner.png");
        Learner l6 = new Learner("Funke AkinLala", "56", "Nigeria", "https://res.cloudinary.com/mikeattara/image/upload/v1596700848/Top-learner.png");
        Learner l7 = new Learner("Girlee Ranking", "56", "Ghana", "https://res.cloudinary.com/mikeattara/image/upload/v1596700848/Top-learner.png");
        Learner l8 = new Learner("Adams Vjay", "34", "India", "https://res.cloudinary.com/mikeattara/image/upload/v1596700848/Top-learner.png");
        Learner l9 = new Learner("Demain Marley", "67", "Africa Republica", "https://res.cloudinary.com/mikeattara/image/upload/v1596700848/Top-learner.png");

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
