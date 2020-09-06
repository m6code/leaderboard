package com.m6code.leaderboard.data;

import java.util.ArrayList;

public class SkillData {

    private ArrayList<SkillQ> mDataList = new ArrayList<>();

    public ArrayList<SkillQ> getDataList() {
        return mDataList;
    }


    public void initSkillData(){
        SkillQ s1 = new SkillQ("Reja Blunky", "197", "Ghana", "https://res.cloudinary.com/mikeattara/image/upload/v1596700835/skill-IQ-trimmed.png");
        SkillQ s2 = new SkillQ("John Lega", "180", "Nigeria", "https://res.cloudinary.com/mikeattara/image/upload/v1596700835/skill-IQ-trimmed.png");
        SkillQ s3 = new SkillQ("Bujus Banty", "227", "Sierra Lone", "https://res.cloudinary.com/mikeattara/image/upload/v1596700835/skill-IQ-trimmed.png");
        SkillQ s4 = new SkillQ("Dennis Blanky", "200", "South Africa", "https://res.cloudinary.com/mikeattara/image/upload/v1596700835/skill-IQ-trimmed.png");
        SkillQ s5 = new SkillQ("Ola Meji Meji", "240", "NIgeria", "https://res.cloudinary.com/mikeattara/image/upload/v1596700835/skill-IQ-trimmed.png");

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
