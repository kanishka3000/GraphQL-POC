package GraphQLPOC.services;

import GraphQLPOC.dto.CreateProduct;
import GraphQLPOC.dto.ProductDetail;

import java.util.List;

public interface ProductService {
    List<ProductDetail> getAllProducts();
    ProductDetail createProduct(CreateProduct createProduct);
}
