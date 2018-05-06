package com.yeung.pauleetech.nice;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yeung.pauleetech.nice.MainPageLayout.Fragment.HomeFragment;
import com.yeung.pauleetech.nice.MeLayout.MeFragement;
import com.yeung.pauleetech.nice.ShoppingCartPageLayout.ShoppingCartFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
/*import com.yeung.pauleetech.nice.RollviewpagerImt.NetImageActivity;*/


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.apphome)
    LinearLayout home;
    @BindView(R.id.recommend)
    LinearLayout recommend;
    @BindView(R.id.discovery)
    LinearLayout discovery;
    @BindView(R.id.me)
    LinearLayout me;
    @BindView(R.id.text_home)
    TextView textView_home;
    @BindView(R.id.text_recommend)
    TextView textView_recommend;
    @BindView(R.id.text_discovery)
    TextView textView_discovery;
    @BindView(R.id.text_me)
    TextView textView_me;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        replaceFragment(new HomeFragment());
        ButterKnife.bind(this);

        textView_home.setTextColor(Color.GREEN);
        home.setOnClickListener(this);
        recommend.setOnClickListener(this);
        discovery.setOnClickListener(this);
        me.setOnClickListener(this);
       /* Intent LAintent=new Intent(this,LoopActivity.class);
        startActivity(LAintent);*/
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.top_layout,fragment);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.apphome:
                replaceFragment(new HomeFragment());
                textView_home.setTextColor(Color.GREEN);
                textView_recommend.setTextColor(Color.BLACK);
                textView_discovery.setTextColor(Color.BLACK);
                textView_me.setTextColor(Color.BLACK);
                break;
            case R.id.discovery:
                replaceFragment(new HomeFragment());
                textView_home.setTextColor(Color.BLACK);
                textView_recommend.setTextColor(Color.BLACK);
                textView_discovery.setTextColor(Color.GREEN);
                textView_me.setTextColor(Color.BLACK);
                break;
            case R.id.shoppingcart:
                replaceFragment(new ShoppingCartFragment());
                textView_home.setTextColor(Color.BLACK);
                textView_recommend.setTextColor(Color.GREEN);
                textView_discovery.setTextColor(Color.BLACK);
                textView_me.setTextColor(Color.BLACK);
                break;
            case R.id.me:
                replaceFragment(new MeFragement());
                textView_home.setTextColor(Color.BLACK);
                textView_recommend.setTextColor(Color.BLACK);
                textView_discovery.setTextColor(Color.BLACK);
                textView_me.setTextColor(Color.GREEN);
                break;
        }
    }

    /*public void simple(View view){       //在主活动中可以直接这样写？函数名==控件名绑定监听器？在布局中写上onClick="函数名"
        Intent i = new Intent(this,SimpleActivity.class);
        startActivity(i);
    }*/

    /*public void loop(View view){
        Intent i = new Intent(this,LoopActivity.class);
        startActivity(i);
    }*/

    /*public void netImage(View view){
        Intent i = new Intent(this,NetImageActivity.class);
        startActivity(i);
    }*/


}
