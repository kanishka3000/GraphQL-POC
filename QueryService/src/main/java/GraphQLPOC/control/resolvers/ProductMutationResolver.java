package GraphQLPOC.control.resolvers;

import GraphQLPOC.dto.ComponentDetail;
import GraphQLPOC.dto.CreateComponent;
import GraphQLPOC.dto.CreateProduct;
import GraphQLPOC.dto.ProductDetail;
import GraphQLPOC.exceptions.ProductNotFoundException;
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

    public ComponentDetail createComponent(CreateComponent data) throws ProductNotFoundException {
        ComponentDetail componentDetail = productService.createComponent(data);

        return componentDetail;
    }
}
