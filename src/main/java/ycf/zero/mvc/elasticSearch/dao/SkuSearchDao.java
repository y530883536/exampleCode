package ycf.zero.mvc.elasticSearch.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import ycf.zero.mvc.elasticSearch.model.Sku;

public interface SkuSearchDao extends ElasticsearchRepository<Sku,Long> {
}
