package ycf.zero.elasticSearch.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import ycf.zero.elasticSearch.model.Sku;

public interface SkuSearchDao extends ElasticsearchRepository<Sku,Long> {
}
