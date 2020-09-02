package com.m6code.leaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.m6code.leaderboard.data.LearningData;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private final ArrayList<LearningData> mLearningData;
    private final Context mContext;
    private final LayoutInflater mLayoutInflater;

    public RecyclerAdapter(Context context, ArrayList<LearningData> learningData) {
        mLearningData = learningData;
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

        LearningData learningData = mLearningData.get(position);
        holder.mLearnerName.setText(learningData.getName());
        holder.mLearnerDetails.setText(learningData.getHours() + " learning hours, " + learningData.getCountry()); // Todo: replace " learning hours, " with "mContext.getString(R.string.learning_hours_string)"
        holder.mCurrentPosition = position;
    }

    @Override
    public int getItemCount() {
        return mLearningData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // Implement your custom views here
        public final TextView mLearnerName;
        public final TextView mLearnerDetails;
        public int mCurrentPosition;

        public ViewHolder(View itemView) {
            super(itemView);
            mLearnerName = itemView.findViewById(R.id.tv_name);
            mLearnerDetails = itemView.findViewById(R.id.tv_learning_details);
        }

    }
}
