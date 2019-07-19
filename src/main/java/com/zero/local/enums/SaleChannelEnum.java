package com.zero.local.enums;

public enum SaleChannelEnum {
    CHANNEL_EBAY("Ebay"),
    CHANNEL_AMAZON("Amazon"),
    CHANNEL_SMT("SMT"),
    CHANNEL_WISH("Wish"),
    CHANNEL_JOOM("Joom");

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    SaleChannelEnum(String name){
        this.name = name;
    }
}
