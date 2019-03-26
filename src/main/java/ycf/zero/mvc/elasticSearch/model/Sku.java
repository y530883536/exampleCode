package ycf.zero.mvc.elasticSearch.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Date;

@Document(indexName = "skus",type = "sku")
@Getter
@Setter
public class Sku implements Serializable {
    private Long id;
    private String productArea;
    private String product_area;
    private String name;
    private Integer price;
    private Date createTime;
    private Date updateTime;
}
