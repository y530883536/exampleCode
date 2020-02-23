package com.zero.config.dataSource;

public enum DbTypeEnum {
    toToSixDataSource("toToSixDataSource"),
    eightSixDataSource("eightSixDataSource");

    private String value;

    DbTypeEnum(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
