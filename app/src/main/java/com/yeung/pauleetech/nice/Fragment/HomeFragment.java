package com.yeung.pauleetech.nice.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;
import com.yeung.pauleetech.nice.R;
import com.yeung.pauleetech.nice.ReclviewHR.Mission;
import com.yeung.pauleetech.nice.ReclviewHR.MissionAdapter;
import com.yeung.pauleetech.nice.ReclviewVT.Commodity;
import com.yeung.pauleetech.nice.ReclviewVT.CommodityAdapter;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    private View view;
    private RollPagerView mViewPager;
    private List<Mission> missionList=new ArrayList<>();
    private List<Commodity> commodityList=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_home,container,false);
        onCreateItem();
        return view;
    }

    public void onCreateItem() {
        mViewPager = (RollPagerView) view.findViewById(R.id.view_pager);
        mViewPager.setAdapter(new ImageLoopAdapter(mViewPager));

        //*   对ReclviewHR的操作  *//*
        initMission();
        RecyclerView recyclerView=(RecyclerView) view.findViewById(R.id.recycler_view_hr);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());  //new一个线性布局管理器
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        MissionAdapter adapter=new MissionAdapter(missionList);
        recyclerView.setAdapter(adapter);

        //*   对ReclviewVT的操作  *//*
        initCommodity();
        RecyclerView recyclerView1=(RecyclerView) view.findViewById(R.id.recycler_view_vt);
        StaggeredGridLayoutManager sglayoutmanager=new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL);
        recyclerView1.setLayoutManager(sglayoutmanager);
        CommodityAdapter adapter1=new CommodityAdapter(commodityList);
        recyclerView1.setAdapter(adapter1);
    }

    private class ImageLoopAdapter extends LoopPagerAdapter {
        int[] imgs = new int[]{
                R.drawable.img1,
                R.drawable.img2,
                R.drawable.img3,
                R.drawable.img4,
                R.drawable.img5,
        };

        public ImageLoopAdapter(RollPagerView viewPager) {
            super(viewPager);
        }

        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            view.setImageResource(imgs[position]);
            return view;
        }

        @Override
        public int getRealCount() {
            return imgs.length;
        }
    }

    private void initMission(){
        Mission register=new Mission("签到",R.drawable.register);
        missionList.add(register);
        Mission coupon=new Mission("优惠券",R.drawable.coupon);
        missionList.add(coupon);
        Mission msn1=new Mission("msn1",R.drawable.find2);
        missionList.add(msn1);
        Mission msn2=new Mission("签到",R.drawable.contact);
        missionList.add(msn2);

    }

    private void initCommodity(){
        for(int i=0;i<10;i++){
            Commodity co1=new Commodity("硫酸铵",R.drawable.fertilizer1);
            commodityList.add(co1);
            Commodity co2=new Commodity("复合肥",R.drawable.fertilizer2);
            commodityList.add(co2);
            Commodity co3=new Commodity("沃博特",R.drawable.fertilizer4);
            commodityList.add(co3);
            Commodity co4=new Commodity("金沃地",R.drawable.register);
            commodityList.add(co4);
        }


    }
}
