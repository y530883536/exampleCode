package ycf.zero.controller;

import org.elasticsearch.index.query.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ycf.zero.elasticSearch.dao.SkuSearchDao;
import ycf.zero.elasticSearch.model.Sku;

@RestController
public class EsController {

    @Autowired
    private SkuSearchDao skuSearchDao;

    /*@GetMapping("/esSearch")
    public String esSearch(SkuEsSearchCriteria criteria, int pageSize, int startIndex){
        Pageable pageable = PageRequest.of(startIndex-1,pageSize);
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        //ElasticSearch所有字段名都是小写，且对字段名大小写敏感
        if (CollectionUtils.isNotEmpty(criteria.getArticleNumbers())) {
            boolQueryBuilder.must(QueryBuilders.termsQuery("article_number.keyword",criteria.getArticleNumbers()));
        } else if (StringUtils.isNotEmpty(criteria.getArticleNumber())) {
            if (criteria.getArticleNumber().endsWith("%")) {
                boolQueryBuilder.must(QueryBuilders.wildcardQuery("article_number.keyword","*"+criteria.getArticleNumber()+"*"));
            } else {
                boolQueryBuilder.must(QueryBuilders.termQuery("article_number.keyword",criteria.getArticleNumber()));
            }
        }
        if (StringUtils.isNotEmpty(criteria.getSkuStockStatus())) {
            boolQueryBuilder.must(QueryBuilders.termQuery("skustockstatus.keyword",criteria.getSkuStockStatus()));
        }
        if (StringUtils.isNotEmpty(criteria.getVendorArticleNumber())) {
            boolQueryBuilder.must(QueryBuilders.termQuery("vendorarticlenumber.keyword",criteria.getVendorArticleNumber()));
        }
        if (StringUtils.isNotEmpty(criteria.getProductArticleNumber())) {
            boolQueryBuilder.must(QueryBuilders.termQuery("productarticlenumber.keyword",criteria.getProductArticleNumber()));
        }
        if (StringUtils.isNotEmpty(criteria.getName())) {
            boolQueryBuilder.must(QueryBuilders.wildcardQuery("name.keyword","*"+criteria.getName()+"*"));
        }
        if (StringUtils.isNotEmpty(criteria.getProductManagerNo())) {
            boolQueryBuilder.must(QueryBuilders.termQuery("productmanagerno.keyword",criteria.getProductManagerNo()));
        }
        if (CollectionUtils.isNotEmpty(criteria.getAssistantProductManagerNos())) {
            List<String> cnList = new ArrayList<>();
            for (String managerNo : criteria.getAssistantProductManagerNos()) {
                String cn = managerNo.replaceAll("F", "");
                cnList.add(cn);
            }
            boolQueryBuilder.must(QueryBuilders.termsQuery("assistantproductmanagerno.keyword",cnList));
        } else if (StringUtils.isNotEmpty(criteria.getAssistantProductManagerNo())) {
            boolQueryBuilder.must(QueryBuilders.termQuery("assistantproductmanagerno.keyword",criteria.getAssistantProductManagerNo()));
        }
        if (StringUtils.isNotEmpty(criteria.getSaleManagerNo())) {
            boolQueryBuilder.must(QueryBuilders.termQuery("salemanagerno.keyword",criteria.getSaleManagerNo()));
        }
        //todo 这里要替换掉
        //User currentUser = AppContext.getContextData().getCurrentUser();
        User currentUser = new User();
        if (CollectionUtils.isNotEmpty(criteria.getSkuLifeCyclePhases())) {
            boolQueryBuilder.must(QueryBuilders.termsQuery("skulifecyclephase.keyword",criteria.getSkuLifeCyclePhases()));
        } else if (StringUtils.isNotEmpty(criteria.getSkuLifeCyclePhase())) {
            boolQueryBuilder.must(QueryBuilders.termQuery("skulifecyclephase.keyword",criteria.getSkuLifeCyclePhase()));
        } else if (currentUser.getIsSaleManager() && !currentUser.isAmazon() && !currentUser.isWish()) {
            *//*String queryExpression = "sku.skulifecyclephase not in ('"
                    + SkuLifeCyclePhases.getPhase(SkuLifeCyclePhases.PHASE_NEW)[0] + "','"
                    + SkuLifeCyclePhases.getPhase(SkuLifeCyclePhases.PHASE_WAITING)[0] + "')";*//*
            //todo 这里要替换掉
        }

        //todo 这里要替换掉
        if (StringUtils.isNotEmpty(criteria.getCollocationPackingMaterialIds())) {
            *//*List<String> collocationPackingMaterialIdList = criteria.getCollocationPackingMaterialIdList();
            String queryExpression = "(";
            for (int k = 0; k < collocationPackingMaterialIdList.size(); k++) {
                if (k == 0) {
                    queryExpression = queryExpression + "sku.collocationPackingMaterialIds like '%"
                            + collocationPackingMaterialIdList.get(k) + "%'";
                } else {
                    queryExpression = queryExpression + " or sku.collocationPackingMaterialIds like '%"
                            + collocationPackingMaterialIdList.get(k) + "%'";
                }
            }
            queryExpression = queryExpression + ")";
            String queryExpression = "sku.collocationPackingMaterialIds like
            '%" + criteria.getCollocationPackingMaterialIds() + "%'";
            queryExpressions.add(queryExpression);*//*
        }

        return "aaa";
    }*/

    @GetMapping("/testSearch")
    public String testSearch(){
        Pageable pageable = PageRequest.of(0,10);
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

        /*List<Integer> priceList = new ArrayList<>();
        priceList.add(100);
        priceList.add(120);
        priceList.add(130);
        priceList.add(330);
        priceList.add(90);
        boolQueryBuilder.must(QueryBuilders.termsQuery("price",priceList));*/

        /*List<String> areaList = new ArrayList<>();
        areaList.add("china");
        areaList.add("usa");
        boolQueryBuilder.mustNot(QueryBuilders.termsQuery("product_area",areaList));*/

        //boolQueryBuilder.must(QueryBuilders.termQuery("code","ISO-9009"));

        boolQueryBuilder.mustNot(QueryBuilders.termQuery("product_area.keyword","China"));

        Page<Sku> skuPage = skuSearchDao.search(boolQueryBuilder, pageable);
        StringBuilder sb = new StringBuilder();
        for (Sku sku : skuPage.getContent()) {
            sb.append(sku.getId()+":"+sku.getName()+"<br>");
        }
        return sb.toString();
    }

    public void code(){
        /*WildcardQueryBuilder wqb = QueryBuilders.wildcardQuery("name.keyword", "*黑色*");
        boolQueryBuilder.must(wqb);
        Page<Sku> skuPage = skuSearchDao.search(boolQueryBuilder, pageable);
        List<Sku> skuList = skuPage.getContent();
        StringBuilder sb = new StringBuilder();
        for (Sku sku : skuList) {
            sb.append(sku.getId()+":"+sku.getName()+"<br>");
        }*/

        /*Iterable<Sku> search = skuSearchDao.search(boolQueryBuilder);
        Iterator<Sku> iterator = search.iterator();
        while(iterator.hasNext()) {
            Sku sku = iterator.next();
            System.out.println(sku.getName()+sku.getId());
        }*/
    }

}
