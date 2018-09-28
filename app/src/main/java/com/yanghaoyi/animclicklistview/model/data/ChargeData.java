package com.yanghaoyi.animclicklistview.model.data;

import java.util.List;

/**
 * @author : YangHaoYi on 2018/9/28.
 *         Email  :  yang.haoyi@qq.com
 *         Description :
 *         Change : YangHaoYi on 2018/9/28.
 *         Version : V 1.0
 */
public class ChargeData {

    private int code;
    private String description;
    private long lastUpdateTime;

    private List<ChargeStation> chargeStation;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public List<ChargeStation> getChargeStations() {
        return chargeStation;
    }

    public void setChargeStations(List<ChargeStation> chargeStations) {
        this.chargeStation = chargeStations;
    }
}
