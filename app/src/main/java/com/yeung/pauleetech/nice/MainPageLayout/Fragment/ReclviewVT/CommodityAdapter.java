package com.yeung.pauleetech.nice.MainPageLayout.Fragment.ReclviewVT;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yeung.pauleetech.nice.R;

import java.util.List;

public class CommodityAdapter extends RecyclerView.Adapter<CommodityAdapter.ViewHolder>{
    private List<Commodity> mCommodityList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView commodityImage;
        TextView commodityName;

        public ViewHolder(View view){
            super(view);
            commodityImage=(ImageView)view.findViewById(R.id.commodityImage);
            commodityName=(TextView) view.findViewById(R.id.commodityName);
        }
    }

    public CommodityAdapter( List<Commodity> commodityList){
        mCommodityList=commodityList;
    }

    @Override
    public CommodityAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.commodity_item,parent,false);
        CommodityAdapter.ViewHolder holder=new CommodityAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(CommodityAdapter.ViewHolder holder, int position) {
        Commodity commodity=mCommodityList.get(position);
        holder.commodityImage.setImageResource(commodity.getImageId());
        holder.commodityName.setText(commodity.getName());
    }

    @Override
    public int getItemCount() {
        return mCommodityList.size();
    }
}
