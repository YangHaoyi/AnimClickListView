package com.yanghaoyi.animclicklistview.model;

import android.content.Context;
import android.content.res.AssetManager;

import com.google.gson.Gson;
import com.yanghaoyi.animclicklistview.model.data.ChargeData;
import com.yanghaoyi.animclicklistview.model.data.ChargeStation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : YangHaoYi on 2018/9/28.
 *         Email  :  yang.haoyi@qq.com
 *         Description :
 *         Change : YangHaoYi on 2018/9/28.
 *         Version : V 1.0
 */
public class PoiModel {

    private static final String FILEDIR = "data/";
    private static final String FILENAME = FILEDIR + "charge_station.json";
    private Context context;

    public PoiModel(Context context) {
        this.context = context;
    }

    public List<ChargeStation> getPoiData(){
        Gson gson = new Gson();
        ChargeData chargeData = gson.fromJson(getJson(context), ChargeData.class);
        return chargeData.getChargeStations();
    }

    private String getJson(Context context) {
        //将json数据变成字符串
        StringBuilder stringBuilder = new StringBuilder();
        try {
            //获取assets资源管理器
            AssetManager assetManager = context.getAssets();
            //通过管理器打开文件并读取
            BufferedReader bf = new BufferedReader(new InputStreamReader(
                    assetManager.open(FILENAME)));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
