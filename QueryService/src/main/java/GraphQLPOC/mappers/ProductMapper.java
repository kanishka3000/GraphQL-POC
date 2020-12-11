package GraphQLPOC.mappers;

import GraphQLPOC.dto.CreateProduct;
import GraphQLPOC.dto.ProductDetail;
import GraphQLPOC.entity.Product;

public class ProductMapper {
    public static Product map(CreateProduct createProduct){
        Product product = new Product();
        product.setName(createProduct.getName());
        product.setDescription(createProduct.getDescription());
        return product;
    }
}
