package GraphQLPOC.control.resolvers;

import GraphQLPOC.dto.ComponentDetail;
import GraphQLPOC.dto.ProductDetail;
import GraphQLPOC.exceptions.ComponentNotFoundException;
import GraphQLPOC.services.ProductService;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComponentResolver implements GraphQLResolver<ComponentDetail> {

    @Autowired
    ProductService productService;

    public ProductDetail product(ComponentDetail component) throws ComponentNotFoundException {
        ProductDetail productDetail = productService.getProduct(component.getId());

        return productDetail;
    }
}
