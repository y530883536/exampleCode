package com.zero.toToSix.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer price;

    private String productArea;

    private Date createTime;

    private Date updateTime;

    private String code;

    @TableField("testnumber")
    private Integer testNumber;

    private Integer companyId;

    //表示这个字段在当前表里不存在
    @TableField(exist = false)
    private String address;

}