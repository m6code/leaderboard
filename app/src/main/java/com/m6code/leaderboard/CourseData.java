package com.m6code.leaderboard;

import java.util.ArrayList;

public class CourseData {

    private ArrayList<Course> mDataList = new ArrayList<>();

    public ArrayList<Course> getDataList() {
        return mDataList;
    }

    public void initData() {
        Course c1 = new Course("Title One", "This be the details of one");
        Course c2 = new Course("Title Two", "This is the second course");
        Course c3 = new Course("Title Three", "This is the Third course details");
        Course c4 = new Course("Title Four", "This be the details of four");
        Course c5 = new Course("Title Five", "This is the second course five five five five five ");
        Course c6 = new Course("Title Six", "This is the Third course details six six six six six six six");
        Course c7 = new Course("Title Seven", "This be seventh details of eight eight eight eight eight");
        Course c8 = new Course("Title Eight", "This is eighth second course eight e ihgt eihgt eihgth");
        Course c9 = new Course("Title Nine", "This is the ninth course details nine nine nine nine");

        mDataList.add(c1);
        mDataList.add(c2);
        mDataList.add(c3);
        mDataList.add(c4);
        mDataList.add(c5);
        mDataList.add(c6);
        mDataList.add(c7);
        mDataList.add(c8);
        mDataList.add(c9);

    }
}
