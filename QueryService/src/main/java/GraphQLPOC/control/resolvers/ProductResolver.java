package GraphQLPOC.control.resolvers;

import GraphQLPOC.dto.ComponentDetail;
import GraphQLPOC.dto.ProductDetail;
import GraphQLPOC.exceptions.ProductNotFoundException;
import GraphQLPOC.services.ProductService;
import com.coxautodev.graphql.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@Slf4j
public class ProductResolver implements GraphQLResolver<ProductDetail> {

    @Autowired
    ProductService productService;

    public List<ComponentDetail> components(ProductDetail product){
        log.debug("Searching components for " + product.getId());
        List<ComponentDetail> componentDetails = null;
        try {
            componentDetails = productService.getAllComponents(product.getId());
        } catch (ProductNotFoundException e) {
            log.error("No components found for the product");
            return Collections.emptyList();
        }

        log.debug("Found " + componentDetails.size());
        return componentDetails;
    }
}
