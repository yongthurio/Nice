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

/*import com.yeung.pauleetech.nice.MainPageLayout.Fragment.RollviewpagerImt.NetImageActivity;*/


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private LinearLayout home;
    private LinearLayout recommend;
    private LinearLayout discovery;
    private LinearLayout me;
    private TextView textView_home;
    private TextView textView_recommend;
    private TextView textView_discovery;
    private TextView textView_me;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        replaceFragment(new HomeFragment());
        home=(LinearLayout)findViewById(R.id.apphome);
        recommend =(LinearLayout)findViewById(R.id.shoppingcart);
        discovery=(LinearLayout)findViewById(R.id.discovery);
        me=(LinearLayout)findViewById(R.id.me);
        textView_home=(TextView)findViewById(R.id.text_home);
        textView_recommend =(TextView)findViewById(R.id.text_recommend);
        textView_discovery=(TextView)findViewById(R.id.text_discovery);
        textView_me=(TextView)findViewById(R.id.text_me);

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
        //FragmentTransaction是对Fragment进行添加，替换，移除等操作的。在使用add(),replace(),remove()时可以动态的给每一个Fragment添加一个标签，
        // 下次方便FragmentManager通过tag标签进行查找。最后记得ft.commit();。。。。。
        transaction.replace(R.id.top_layout,fragment);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);  //toolbar干什么的？
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

    /*public void loop(View view){      //在主活动中可以直接这样写？函数名==控件名绑定监听器？在布局中写上onClick="函数名"
        Intent i = new Intent(this,LoopActivity.class);
        startActivity(i);
    }*/

    /*public void netImage(View view){
        Intent i = new Intent(this,NetImageActivity.class);
        startActivity(i);
    }*/
}
