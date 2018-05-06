package com.yeung.pauleetech.nice.MainPageLayout.Fragment.ReclviewHR;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yeung.pauleetech.nice.R;

import java.util.List;

public class MissionAdapter extends RecyclerView.Adapter<MissionAdapter.ViewHolder>{
    private List<Mission> mMissionList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView missionImage;
        TextView missionName;

        public ViewHolder(View view){
            super(view);
            missionImage=(ImageView)view.findViewById(R.id.missionImage);
            missionName=(TextView) view.findViewById(R.id.missionName);
        }
    }

    public MissionAdapter( List<Mission> missionList){
        mMissionList=missionList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.mission_item,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Mission mission=mMissionList.get(position);
        holder.missionImage.setImageResource(mission.getImageId());
        holder.missionName.setText(mission.getName());
    }

    @Override
    public int getItemCount() {
        return mMissionList.size();
    }
}
