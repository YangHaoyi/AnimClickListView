package com.yanghaoyi.animclicklistview.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : YangHaoYi on 2018/9/28.
 *         Email  :  yang.haoyi@qq.com
 *         Description :
 *         Change : YangHaoYi on 2018/9/28.
 *         Version : V 1.0
 */
public class ParkingModel {


    public List<String> getParkingData(){
        List<String> list = new ArrayList<>();
        list.add("停车场A");
        list.add("停车场B");
        list.add("停车场C");
        list.add("停车场D");
        return list;
    }

}
