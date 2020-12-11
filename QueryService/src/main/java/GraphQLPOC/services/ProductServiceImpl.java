package GraphQLPOC.services;

import GraphQLPOC.dao.ProductRepository;
import GraphQLPOC.dto.CreateProduct;
import GraphQLPOC.dto.ProductDetail;
import GraphQLPOC.entity.Product;
import GraphQLPOC.mappers.ProductDetailMapper;
import GraphQLPOC.mappers.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<ProductDetail> getAllProducts() {

        List<Product> products = productRepository.findAll();
        List<ProductDetail> productDetailList = products
                .stream()
                .map(ProductDetailMapper::map)
                .collect(Collectors.toList());
        return productDetailList;
    }

    @Override
    public ProductDetail createProduct(CreateProduct createProduct) {
        Product product = ProductMapper.map(createProduct);
        product = productRepository.save(product);

        ProductDetail productDetail = ProductDetailMapper.map(product);

        return productDetail;
    }
}
