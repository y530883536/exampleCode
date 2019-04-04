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

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer price;

    @TableField("product_area")
    private String productArea;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;

    private String code;

    private static final long serialVersionUID = 1L;
}