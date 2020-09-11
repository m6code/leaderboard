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
import com.m6code.leaderboard.data.SkillQ;

import java.util.ArrayList;

public class SkillFragRecyclerAdapter extends RecyclerView.Adapter<SkillFragRecyclerAdapter.ViewHolder> {

    private final ArrayList<SkillQ> mSkillData;
    private final Context mContext;
    private final LayoutInflater mLayoutInflater;

    public SkillFragRecyclerAdapter(Context context, ArrayList<SkillQ> skillData) {
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

        SkillQ skillQ = mSkillData.get(position);
        holder.mLearnerName.setText(skillQ.getName());
        holder.mLearnerDetails.setText(String.format("%s%s%s", skillQ.getScore(), mContext.getString(R.string.skill_iq_score), skillQ.getCountry())); //  replace " skill IQ score, " with "mContext.getString(R.string.skill_iq_score)" works also

        // Load images from API into imageView with glide
        Glide.with(mContext)
                .load(skillQ.getBadgeUrl())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.image_placeholder)
                .into(holder.mLearnerBadge);

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
