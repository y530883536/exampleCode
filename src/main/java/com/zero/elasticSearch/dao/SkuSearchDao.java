package com.zero.elasticSearch.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import com.zero.elasticSearch.model.Sku;

public interface SkuSearchDao extends ElasticsearchRepository<Sku,Long> {
}
