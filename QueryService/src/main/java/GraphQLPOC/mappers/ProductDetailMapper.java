package GraphQLPOC.mappers;

import GraphQLPOC.dto.ProductDetail;
import GraphQLPOC.entity.Product;

public class ProductDetailMapper {
    public static ProductDetail map(Product product){
        ProductDetail productDetail = new ProductDetail();
        productDetail.setId(product.getId());
        productDetail.setName(product.getName());
        productDetail.setDescription(product.getDescription());
        return productDetail;
    }
}
