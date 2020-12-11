package GraphQLPOC.control.resolvers;

import GraphQLPOC.dto.CreateProduct;
import GraphQLPOC.dto.ProductDetail;
import GraphQLPOC.services.ProductService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductMutationResolver implements GraphQLMutationResolver {

    @Autowired
    ProductService productService;

    public ProductDetail createProduct(CreateProduct data){

        ProductDetail productDetail = productService.createProduct(data);

        return productDetail;
    }
}
