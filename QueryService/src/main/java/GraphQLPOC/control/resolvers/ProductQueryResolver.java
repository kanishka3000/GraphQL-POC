package GraphQLPOC.control.resolvers;

import GraphQLPOC.dto.ProductDetail;
import GraphQLPOC.services.ProductService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductQueryResolver implements GraphQLQueryResolver {

    @Autowired
    ProductService productService;

    public List<ProductDetail> products(){

        List<ProductDetail> products = productService.getAllProducts();
        return products;
    }
}
