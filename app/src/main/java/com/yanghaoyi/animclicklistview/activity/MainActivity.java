package com.yanghaoyi.animclicklistview.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.yanghaoyi.animclicklistview.R;
import com.yanghaoyi.animclicklistview.adapter.PoiListAdapter;
import com.yanghaoyi.animclicklistview.model.PoiModel;
import com.yanghaoyi.animclicklistview.util.DividerItemDecoration;
import com.yanghaoyi.animclicklistview.util.ScreenUtil;

import java.util.List;

/**
 * @author : YangHaoYi on 2018/9/28.
 *         Email  :  yang.haoyi@qq.com
 *         Description :
 *         Change : YangHaoYi on 2018/9/28.
 *         Version : V 1.0
 */
public class MainActivity extends AppCompatActivity {

    private TextView tvToPoi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        initView();
        initData();
        initEvent();
    }

    private void initView(){
        tvToPoi = findViewById(R.id.tv_to_poi);
    }

    private void initData(){

    }

    private void initEvent(){
        tvToPoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,PoiListActivity.class);
                startActivity(intent);
                overridePendingTransition(0,0);
            }
        });
    }



}
