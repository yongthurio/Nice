package com.yeung.pauleetech.nice.MainPageLayout.Fragment;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;
import com.yeung.pauleetech.nice.R;
import com.yeung.pauleetech.nice.MainPageLayout.Fragment.ReclviewHR.Mission;
import com.yeung.pauleetech.nice.MainPageLayout.Fragment.ReclviewHR.MissionAdapter;
import com.yeung.pauleetech.nice.MainPageLayout.Fragment.ReclviewVT.Commodity;
import com.yeung.pauleetech.nice.MainPageLayout.Fragment.ReclviewVT.CommodityAdapter;
import com.yeung.pauleetech.nice.WebActivity;
import com.yeung.pauleetech.nice.ZXingActivity;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;


public class HomeFragment extends Fragment implements View.OnClickListener {
    private View view;
    private RollPagerView mViewPager;
    private List<Mission> missionList=new ArrayList<>();
    private List<Commodity> commodityList=new ArrayList<>();

    private ImageView title_image;
    private TextView searchText;
    private TextView search_text;
    private int REQUEST_CODE_SCAN = 111;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_home,container,false);
        onCreateItem();
        return view;
    }

    public void onCreateItem() {
        title_image=(ImageView)view.findViewById(R.id.title_image);
        searchText =(TextView) view.findViewById(R.id.search_text);
        search_text =(TextView) view.findViewById(R.id.title_text);
        mViewPager = (RollPagerView) view.findViewById(R.id.view_pager);
        mViewPager.setAdapter(new ImageLoopAdapter(mViewPager));
        ZXingLibrary.initDisplayOpinion(getContext());
        //*   对ReclviewHR的操作  *//*
        initMission();
        RecyclerView recyclerView=(RecyclerView) view.findViewById(R.id.recycler_view_hr);

        title_image.setOnClickListener(this);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());  //new一个线性布局管理器
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        MissionAdapter adapter=new MissionAdapter(missionList);
        recyclerView.setAdapter(adapter);

        //*   对ReclviewVT的操作  *//*
        initCommodity();
        RecyclerView recyclerView1=(RecyclerView) view.findViewById(R.id.recycler_view_vt);
        StaggeredGridLayoutManager sglayoutmanager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        recyclerView1.setLayoutManager(sglayoutmanager);
        CommodityAdapter adapter1=new CommodityAdapter(commodityList);
        recyclerView1.setAdapter(adapter1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_image:
                /*if(ContextCompat.checkSelfPermission(v.getContext(), Manifest.permission.CAMERA)!=
                        PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(getActivity(),new String[]{"android.Manifest.permission.CAMERA"},1);
                }else{
                    Intent intent = new Intent(getContext(), CaptureActivity.class);
                    startActivity(intent);
                }*/
                Intent intent = new Intent(getActivity(), ZXingActivity.class);
                //startActivity(intent);
                startActivityForResult(intent, REQUEST_CODE_SCAN);
                /*AndPermission.with(this)
                        .permission(Permission.CAMERA, Permission.READ_EXTERNAL_STORAGE)
                        .onGranted(new Action() {
                            @Override
                            public void onAction(List<String> permissions) {
                                Intent intent = new Intent(getContext(), com.yzq.zxinglibrary.android.CaptureActivity.class);

                                *//*ZxingConfig是配置类  可以设置是否显示底部布局，闪光灯，相册，是否播放提示音  震动等动能
                                 * 也可以不传这个参数
                                 * 不传的话  默认都为默认不震动  其他都为true
                                 * *//*

                                ZxingConfig config = new ZxingConfig();
                                config.setPlayBeep(true);
                                config.setShake(true);
                                intent.putExtra(Constant.INTENT_ZXING_CONFIG, config);

                                startActivityForResult(intent, REQUEST_CODE_SCAN);
                            }
                        })
                        .onDenied(new Action() {
                            @Override
                            public void onAction(List<String> permissions) {
                                Uri packageURI = Uri.parse("package:" + getContext().getPackageName());
                                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, packageURI);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                                startActivity(intent);

                                Toast.makeText(getActivity(), "没有权限无法扫描呦", Toast.LENGTH_LONG).show();
                            }
                        }).start();*/
                default: break;
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_SCAN) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(getActivity(), "解析结果:" + result, Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(getActivity(),WebActivity.class);
                    intent.putExtra("url",result);
                    startActivity(intent);
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(getActivity(), "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
           /* case 1:
                if(grantResults.length>1 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Intent intent = new Intent(getContext(), com.yzq.zxinglibrary.android.CaptureActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getActivity(), "you denied the permission", Toast.LENGTH_SHORT).show();
                }
                break;*/
            default: break;
        }
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
