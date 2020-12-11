package GraphQLPOC.config;

import GraphQLPOC.services.ProductService;
import GraphQLPOC.services.ProductServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public ProductService productService(){
        return new ProductServiceImpl();
    }
}
