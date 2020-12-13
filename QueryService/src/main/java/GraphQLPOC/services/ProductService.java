package GraphQLPOC.services;

import GraphQLPOC.dto.ComponentDetail;
import GraphQLPOC.dto.CreateComponent;
import GraphQLPOC.dto.CreateProduct;
import GraphQLPOC.dto.ProductDetail;
import GraphQLPOC.exceptions.ComponentNotFoundException;
import GraphQLPOC.exceptions.ProductNotFoundException;

import java.util.List;

public interface ProductService {
    List<ProductDetail> getAllProducts();
    ProductDetail createProduct(CreateProduct createProduct);
    ComponentDetail createComponent(CreateComponent createComponent) throws ProductNotFoundException;
    List<ComponentDetail> getAllComponents(long product) throws ProductNotFoundException;
    ProductDetail getProduct(long component) throws ComponentNotFoundException;
}
