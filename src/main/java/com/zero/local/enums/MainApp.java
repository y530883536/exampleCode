package com.zero.local.enums;

import org.apache.commons.collections4.CollectionUtils;

public class MainApp {
    public static void main(String[] args) {
        System.out.println(SaleChannelEnum.CHANNEL_AMAZON);
        System.out.println(SaleChannelEnum.CHANNEL_AMAZON.getName());
        System.out.println(SkuLifeCyclePhaseEnum.notAllowSaleStatusCode().contains("New"));
        System.out.println(SkuLifeCyclePhaseEnum.notAllowSaleStatusCode().contains("new"));
        System.out.println(SkuLifeCyclePhaseEnum.notAllowSaleStatusCode().toString());
        System.out.println(SkuLifeCyclePhaseEnum.notAllowSaleStatusName().toString());
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.toString().length());
    }
}
