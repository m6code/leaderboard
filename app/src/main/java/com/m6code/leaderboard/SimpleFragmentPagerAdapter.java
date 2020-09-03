package com.m6code.leaderboard;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context mContext; // A variable that holds the name of the current tab

    /**
     * A simple constructor for the viewpager
     *
     * @param context         the current tab on which the viewpager is
     * @param fragmentManager return the appropriate fragment to the viewpager
     */
    public SimpleFragmentPagerAdapter(Context context, FragmentManager fragmentManager) {
        super(fragmentManager);
        mContext = context;
    }

    /**
     * Get the current position and sets the appropriate fragment
     *
     * @param position the current position
     * @return the appropriate fragment
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new LearningFragment();
        } else
            return new SkillFragment();
    }

    /**
     * get the number of fragment to be returned
     *
     * @return the numbers of fragments
     */
    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.learning_fragment_text);
//            return "Learning Leaders";
        } else
            return mContext.getString(R.string.skill_fragment_text);
//        return "Skill IQ Leaders";
    }

}
