package com.lakala.pressuretest.vo;

import lombok.Data;
import lombok.ToString;

/**
 * Created with IntelliJ IDEA.
 * User: dingo
 * Date: 18-8-31
 * Time: 下午4:13
 * Description: mpos kafka message
 */
@Data
@ToString
public class MposTransVo {
    private String createTime;
    private String tradeDate;
    private String sid;
    private String sysref;
    private String termid;
    private String busId;
    private String userId;
    private String posemc;
    private String createDate;
    private int retryTimes;//组装重试次数
}