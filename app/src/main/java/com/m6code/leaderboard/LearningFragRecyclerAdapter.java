package com.m6code.leaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.m6code.leaderboard.data.Learner;

import java.util.ArrayList;

public class LearningFragRecyclerAdapter extends RecyclerView.Adapter<LearningFragRecyclerAdapter.ViewHolder> {

    private final ArrayList<Learner> mLearningData;
    private final Context mContext;
    private final LayoutInflater mLayoutInflater;

    public LearningFragRecyclerAdapter(Context context, ArrayList<Learner> learningData) {
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

        Learner learner = mLearningData.get(position);
        holder.mLearnerName.setText(learner.getName());
        holder.mLearnerDetails.setText(learner.getHours() + " learning hours, " + learner.getCountry()); // Todo: replace " learning hours, " with "mContext.getString(R.string.learning_hours_string)"
        holder.mCurrentPosition = position;

        // Load images from API into imageView with glide
        Glide.with(mContext)
                .load(learner.getBadgeUrl())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.image_placeholder)
                .into(holder.mLearnerBadge);
    }

    @Override
    public int getItemCount() {
        return mLearningData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // Implement your custom views here
        public final TextView mLearnerName;
        public final TextView mLearnerDetails;
        public final ImageView mLearnerBadge;
        public int mCurrentPosition;

        public ViewHolder(View itemView) {
            super(itemView);
            mLearnerName = itemView.findViewById(R.id.tv_name);
            mLearnerDetails = itemView.findViewById(R.id.tv_learning_details);
            mLearnerBadge = itemView.findViewById(R.id.imageView_badge);
        }

    }
}
