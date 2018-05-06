package com.yeung.pauleetech.nice.MeLayout;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yeung.pauleetech.nice.R;

public class MeFragement extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //inflate()的作用就是将一个用xml定义的布局文件查找出来，注意与findViewById()的区别，
        // inflate是加载一个布局文件，而findViewById则是从布局文件中查找一个控件。
        View view = inflater.inflate(R.layout.fragement_me, container, false);
        return view;
    }
}
