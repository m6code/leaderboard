package com.m6code.leaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private final ArrayList<Course> mCourses;
    private final Context mContext;
    private final LayoutInflater mLayoutInflater;

    public RecyclerAdapter(Context context, ArrayList<Course> courses) {
        mCourses = courses;
        mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Course course = mCourses.get(position);
        holder.mCourseTitle.setText(course.getTitle());
        holder.mCourseDetails.setText(course.getDetails());
        holder.mCurrentPosition = position;
    }

    @Override
    public int getItemCount() {
        return mCourses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // Implement your custom views here
        public final TextView mCourseTitle;
        public final TextView mCourseDetails;
        public int mCurrentPosition;

        public ViewHolder(View itemView) {
            super(itemView);
            mCourseTitle = itemView.findViewById(R.id.tv_title);
            mCourseDetails = itemView.findViewById(R.id.tv_details);
        }

    }
}
