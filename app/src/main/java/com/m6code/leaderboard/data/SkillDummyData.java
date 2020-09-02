package com.m6code.leaderboard.data;

import java.util.ArrayList;

public class SkillDummyData {

    private ArrayList<SkillData> mDataList = new ArrayList<>();

    public ArrayList<SkillData> getDataList() {
        return mDataList;
    }


    public void initSkillData(){
        SkillData s1 = new SkillData("Reja Blunky", "197", "Ghana", "https://res.cloudinary.com/mikeattara/image/upload/v1596700835/skill-IQ-trimmed.png");
        SkillData s2 = new SkillData("John Lega", "180", "Nigeria", "https://res.cloudinary.com/mikeattara/image/upload/v1596700835/skill-IQ-trimmed.png");
        SkillData s3 = new SkillData("Bujus Banty", "227", "Sierra Lone", "https://res.cloudinary.com/mikeattara/image/upload/v1596700835/skill-IQ-trimmed.png");
        SkillData s4 = new SkillData("Dennis Blanky", "200", "South Africa", "https://res.cloudinary.com/mikeattara/image/upload/v1596700835/skill-IQ-trimmed.png");
        SkillData s5 = new SkillData("Ola Meji Meji", "240", "NIgeria", "https://res.cloudinary.com/mikeattara/image/upload/v1596700835/skill-IQ-trimmed.png");

        mDataList.add(s1);
        mDataList.add(s2);
        mDataList.add(s3);
        mDataList.add(s4);
        mDataList.add(s5);
        mDataList.add(s1);
        mDataList.add(s2);
        mDataList.add(s4);
        mDataList.add(s1);
        mDataList.add(s3);
        mDataList.add(s1);



    }
}
