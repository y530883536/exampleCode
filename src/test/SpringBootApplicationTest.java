import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.index.query.WildcardQueryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ycf.zero.mvc.SpringBootYcfApplication;
import ycf.zero.mvc.elasticSearch.dao.SkuSearchDao;
import ycf.zero.mvc.elasticSearch.model.Sku;

import java.util.Iterator;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootYcfApplication.class)
public class SpringBootApplicationTest {

    @Autowired
    private SkuSearchDao skuSearchDao;

    @Test
    public void testSearch(){
        /*BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        WildcardQueryBuilder wqb = QueryBuilders.wildcardQuery("name", "*cf*");
        boolQueryBuilder.must(wqb);
        RangeQueryBuilder rqb = new RangeQueryBuilder("price");
        rqb.gte(20);
        boolQueryBuilder.must(rqb);
        Iterable<Sku> searchResult = skuSearchDao.search(boolQueryBuilder);
        Iterator<Sku> iterator = searchResult.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().getName());
        }*/
        Iterable<Sku> all = skuSearchDao.findAll();
        Iterator<Sku> iterator = all.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().getName());
        }
    }
}
