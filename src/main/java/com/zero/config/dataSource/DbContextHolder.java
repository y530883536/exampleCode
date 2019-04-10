package com.zero.config.dataSource;

public class DbContextHolder {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static void setDbType(DbTypeEnum dbTypeEnum){
        contextHolder.set(dbTypeEnum.getValue());
    }

    public static String getDbType(){
        return contextHolder.get();
    }
}
