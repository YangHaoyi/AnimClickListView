package com.yanghaoyi.animclicklistview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

import com.yanghaoyi.animclicklistview.R;
import com.yanghaoyi.animclicklistview.adapter.ParkingAdapter;
import com.yanghaoyi.animclicklistview.adapter.PoiListAdapter;
import com.yanghaoyi.animclicklistview.model.ParkingModel;
import com.yanghaoyi.animclicklistview.model.PoiModel;
import com.yanghaoyi.animclicklistview.model.data.ChargeStation;
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
public class PoiListActivity extends AppCompatActivity {

    private static final int ANIM_TIME = 500;
    private static final int START_HEIGHT = 50;
    private static final int EXPAND_HEIGHT = 200;

    private FrameLayout fmTitle;
    private TextView tvTitle;
    private RecyclerView rvPoiList;
    private RecyclerView rvParkingList;
    private ImageView ivBack;

    private List<ChargeStation> list;
    private List<String> parkingList;
    private boolean isExpand;
    private int startValue;
    private int detailValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticity_poi_list);
        init();
    }

    private void init(){
        initView();
        initData();
        initRecyclerView();
        initEvent();
    }

    private void initView(){
        rvPoiList = findViewById(R.id.rv_poi_list);
        rvParkingList = findViewById(R.id.rv_parking_list);
        fmTitle = findViewById(R.id.fm_title);
        tvTitle = findViewById(R.id.tv_title);
        ivBack = findViewById(R.id.iv_back);
    }

    private void initData(){
        list = new PoiModel(this).getPoiData();
        parkingList = new ParkingModel().getParkingData();
    }

    private void initEvent(){
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeTitle();
            }
        });
    }

    private void initRecyclerView(){
        //设置RecyclerView布局模式
        rvPoiList.setLayoutManager(new LinearLayoutManager(this,LinearLayout.VERTICAL,false));
        PoiListAdapter adapter = new PoiListAdapter(list);
        rvPoiList.setAdapter(adapter);
        rvPoiList.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
        adapter.setOnItemClickListener(new PoiListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, String name) {
                expandTitleAnim(name);
            }
        });

        rvParkingList.setLayoutManager(new LinearLayoutManager(this,LinearLayout.VERTICAL,false));
        ParkingAdapter parkingAdapter = new ParkingAdapter(parkingList);
        rvParkingList.setAdapter(parkingAdapter);
        rvParkingList.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
    }

    private void expandTitleAnim(String name){
        if(isExpand){
            return;
        }
        isExpand = true;
        startAnim();
        tvTitle.setText(name);
    }

    private void closeTitle(){
        if(!isExpand){
            finish();
            overridePendingTransition(0,0);
            return;
        }
        rvParkingList.setVisibility(View.GONE);
        rvPoiList.setVisibility(View.VISIBLE);
        isExpand = false;
        tvTitle.setText(getResources().getString(R.string.poi_title));
        startAnim();
    }

    private void startAnim(){
        if(!isExpand){
             startValue = ScreenUtil.dip2px(this, EXPAND_HEIGHT);
             detailValue =ScreenUtil.dip2px(this,START_HEIGHT) - ScreenUtil.dip2px(this, EXPAND_HEIGHT);
        }else {
             startValue = ScreenUtil.dip2px(this, START_HEIGHT);
             detailValue = ScreenUtil.dip2px(this, EXPAND_HEIGHT);
        }
        Animation animation = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                ViewGroup.LayoutParams params = fmTitle.getLayoutParams();
                params.height = (int) (startValue + detailValue * interpolatedTime);
                fmTitle.setLayoutParams(params);
            }

        };
        animation.setDuration(ANIM_TIME);
        fmTitle.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                //no use
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if(isExpand){
                    rvParkingList.setVisibility(View.VISIBLE);
                    rvPoiList.setVisibility(View.GONE);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                //no use
            }
        });
    }


}
