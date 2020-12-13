package GraphQLPOC.services;

import GraphQLPOC.dao.ComponentRepository;
import GraphQLPOC.dao.ProductRepository;
import GraphQLPOC.dto.ComponentDetail;
import GraphQLPOC.dto.CreateComponent;
import GraphQLPOC.dto.CreateProduct;
import GraphQLPOC.dto.ProductDetail;
import GraphQLPOC.entity.Component;
import GraphQLPOC.entity.Product;
import GraphQLPOC.exceptions.ComponentNotFoundException;
import GraphQLPOC.exceptions.ProductNotFoundException;
import GraphQLPOC.mappers.ComponentDetailMapper;
import GraphQLPOC.mappers.ComponentMapper;
import GraphQLPOC.mappers.ProductDetailMapper;
import GraphQLPOC.mappers.ProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ComponentRepository componentRepository;

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

    @Override
    @Transactional
    public ComponentDetail createComponent(CreateComponent createComponent) throws ProductNotFoundException{

        Optional<Product> productOptional = productRepository.findById(createComponent.getProduct());
        if(productOptional.isPresent() == false){
            throw new ProductNotFoundException("Product Id " + createComponent.getProduct() + " is invalid");
        }
        Product product = productOptional.get();
        Component component = ComponentMapper.map(createComponent, product);
        component = componentRepository.save(component);
        List<Component> currentComponents = product.getComponents();
        currentComponents.add(component);
        product.setComponents(currentComponents);

        productRepository.save(product);
        ComponentDetail componentDetail = ComponentDetailMapper.map(component);
        return componentDetail;
    }

    @Override
    @Transactional
    public List<ComponentDetail> getAllComponents(long product) throws ProductNotFoundException {

        Optional<Product> productOptional = productRepository.findById(product);
        if(productOptional.isPresent() == false){
            throw new ProductNotFoundException("Product Id " + product + " is invalid");
        }
        log.debug("Product " + product + " found");
        Product product1 = productOptional.get();

        List<ComponentDetail> componentDetails = product1.getComponents()
                .stream()
                .map(ComponentDetailMapper::map)
                .collect(Collectors.toList());

        log.debug("Number of components " + componentDetails.size());
        return componentDetails;
    }

    @Override
    public ProductDetail getProduct(long component) throws ComponentNotFoundException {
        Optional<Component> componentOptional = componentRepository.findById(component);
        if(componentOptional.isPresent() == false){
            throw new ComponentNotFoundException("Invalid Id " + component);
        }
        Component component1 = componentOptional.get();

        Product product = component1.getProduct();
        ProductDetail productDetail = ProductDetailMapper.map(product);

        return productDetail;
    }
}
