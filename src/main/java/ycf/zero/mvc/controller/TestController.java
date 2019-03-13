package ycf.zero.mvc.controller;


import com.alibaba.fastjson.JSONObject;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.document.DocumentField;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.engine.Engine;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ycf.zero.mvc.elasticSearch.ESConfig;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
public class TestController {

    @Autowired
    private RestHighLevelClient client;

    @Autowired
    private ESConfig esConfig;

    @GetMapping("/esIndex")
    public String esIndex() throws Exception{
        //写操作
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("user", "ycf");
        jsonMap.put("postDate", new Date());
        jsonMap.put("info", "what");
        //type一般都设置为doc，ES对这个貌似有优化
        IndexRequest indexRequest = new IndexRequest("posts", "doc", "9")
                .source(jsonMap);
        IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
        return "写操作";
    }

    @RequestMapping("/esGet")
    public String esGet() throws Exception{
        GetRequest getRequest = new GetRequest("posts");
        GetResponse response = client.get(getRequest, RequestOptions.DEFAULT);
        Map<String, DocumentField> fields = response.getFields();
        for (Map.Entry<String, DocumentField> map : fields.entrySet()) {
            System.out.println(map.getKey() + ":" + map.getValue());
        }
        //这部分代码是获取返回值字符串的
        /*String str = new String(response.getSourceAsBytes());
        Map<String, Object> source = response.getSource();
        JSONObject object1 = JSONObject.parseObject(str);
        JSONObject object2 = JSONObject.parseObject((String)object1.get("message"));*/
        return "普通读";
    }

    @RequestMapping("esSearch")
    public String esSearch() throws Exception{
        SearchRequest searchRequest = new SearchRequest();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //搜索条件可以直接用QueryBuilders这个工具类直接创建
        //searchSourceBuilder.query(QueryBuilders.termQuery("user", "ycf"));
        //searchSourceBuilder.query(QueryBuilders.termQuery("user", "ycf"));
        //也可以自己用构造函数创建
        //MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("message", "test1");
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        //WildcardQueryBuilder wBuilder1 = QueryBuilders.wildcardQuery("message", "*");
        WildcardQueryBuilder wBuilder2 = QueryBuilders.wildcardQuery("info", "*wh*");
        //WildcardQueryBuilder wBuilder3 = QueryBuilders.wildcardQuery("message", "*2019-03-11*");
        //boolQueryBuilder.must(wBuilder1);
        boolQueryBuilder.must(wBuilder2);
        //boolQueryBuilder.must(wBuilder3);
        searchSourceBuilder.from(0);
        searchSourceBuilder.size(5);
        searchSourceBuilder.query(boolQueryBuilder);
        searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        SearchResponse searchResponse = client.search(searchRequest.source(searchSourceBuilder), RequestOptions.DEFAULT);
        SearchHits hits = searchResponse.getHits();
        System.out.println(hits.getTotalHits());
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }
        return "搜索操作";
    }
}
