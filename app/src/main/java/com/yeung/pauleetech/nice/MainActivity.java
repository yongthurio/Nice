package com.yeung.pauleetech.nice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.yeung.pauleetech.nice.ReclviewHR.Mission;
import com.yeung.pauleetech.nice.ReclviewHR.MissionAdapter;
import com.yeung.pauleetech.nice.RollviewpagerImt.LoopActivity;
/*import com.yeung.pauleetech.nice.RollviewpagerImt.NetImageActivity;*/
import com.yeung.pauleetech.nice.RollviewpagerImt.SimpleActivity;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent LAintent=new Intent(this,LoopActivity.class);
        startActivity(LAintent);
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
