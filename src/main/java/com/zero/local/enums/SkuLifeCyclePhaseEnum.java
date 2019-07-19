package com.zero.local.enums;

import java.util.ArrayList;
import java.util.List;

public enum SkuLifeCyclePhaseEnum {
    NEW("New", "草稿"),
    WAITING("Waiting", "待上架"),
    NORMAL("Normal", "正常"),
    CLEARANCE("Clearance", "清仓"),
    PENDING("Pending", "暂停"),
    HOLIDAY("Holiday", "休假"),
    REDUCTION("Reduction", "甩卖"),
    STOP("Stop", "停产"),
    ARCHIVED("Archived", "存档"),
    ABNORMAL("Abnormal", "异常");

    private String code;
    private String name;

    private SkuLifeCyclePhaseEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCode(){
        return code;
    }

    //不允许刊登的状态code
    public static List<String> notAllowSaleStatusCode(){
        List<String> codeList = new ArrayList<>();
        codeList.add(NEW.getCode());
        codeList.add(PENDING.getCode());
        codeList.add(HOLIDAY.getCode());
        codeList.add(STOP.getCode());
        codeList.add(ARCHIVED.getCode());
        codeList.add(ABNORMAL.getCode());
        return codeList;
    }

    //不允许刊登的状态name
    public static List<String> notAllowSaleStatusName(){
        List<String> nameList = new ArrayList<>();
        for (String code : notAllowSaleStatusCode()) {
            nameList.add(build(code));
        }
        return nameList;
    }

    public static String build(String code) {
        SkuLifeCyclePhaseEnum[] values = values();
        for (SkuLifeCyclePhaseEnum type : values) {
            if (type.code.equals(code)) {
                return type.name;
            }
        }
        return null;
    }
}
