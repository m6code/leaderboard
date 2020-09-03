package com.m6code.leaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.m6code.leaderboard.data.SkillData;

import java.util.ArrayList;

public class SkillFragRecyclerAdapter extends RecyclerView.Adapter<SkillFragRecyclerAdapter.ViewHolder> {

    private final ArrayList<SkillData> mSkillData;
    private final Context mContext;
    private final LayoutInflater mLayoutInflater;

    public SkillFragRecyclerAdapter(Context context, ArrayList<SkillData> skillData) {
        mSkillData = skillData;
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

        SkillData skillData = mSkillData.get(position);
        holder.mLearnerBadge.setImageResource(R.drawable.skill_iq_trimmed);
        holder.mLearnerName.setText(skillData.getName());
        holder.mLearnerDetails.setText(String.format("%s%s%s", skillData.getScore(), mContext.getString(R.string.skill_iq_score), skillData.getCountry())); //  replace " skill IQ score, " with "mContext.getString(R.string.skill_iq_score)" works also
        holder.mCurrentPosition = position;
    }

    @Override
    public int getItemCount() {
        return mSkillData.size();
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
