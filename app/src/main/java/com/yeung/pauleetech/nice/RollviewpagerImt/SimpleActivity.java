package com.yeung.pauleetech.nice.RollviewpagerImt;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.yeung.pauleetech.nice.R;


public class SimpleActivity extends AppCompatActivity {
    private RollPagerView mViewPager;     //生成一个图片轮播器的对象

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        mViewPager = (RollPagerView) findViewById(R.id.view_pager);
        mViewPager.setAdapter(new ImageNormalAdapter());
    }

    private class ImageNormalAdapter extends StaticPagerAdapter {
        int[] imgs = new int[]{
                R.drawable.img1,
                R.drawable.img2,
                R.drawable.img3,
                R.drawable.img4,
                R.drawable.img5,
        };

        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);  //决定了图片在View上显示时的样子，如进行何种比例的缩放，及显示图片的整体还是部分，等等。
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            //LayoutParams主要设置的是子view在父类布局的参数
            view.setImageResource(imgs[position]);
            return view;
        }


        @Override
        public int getCount() {
            return imgs.length;
        }
    }
}
