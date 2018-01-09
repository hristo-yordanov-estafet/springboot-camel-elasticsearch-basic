package example.service;

import java.io.IOException;

import org.apache.camel.Body;
import org.apache.camel.Header;
import org.elasticsearch.action.index.IndexRequest;

public class ElasticSearchService {
	
	public IndexRequest add(@Body String product,
            @Header("indexname") String indexname,
            @Header("indextype") String indextype,
            @Header("id") String id) throws IOException {

		System.out.println("**************:" + product);
		IndexRequest req = new IndexRequest(indexname, indextype, id);
		req.source(product);
		return req;
	}

}
