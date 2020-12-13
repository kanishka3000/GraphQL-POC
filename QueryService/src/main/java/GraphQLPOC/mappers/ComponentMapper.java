package GraphQLPOC.mappers;

import GraphQLPOC.dto.CreateComponent;
import GraphQLPOC.entity.Component;
import GraphQLPOC.entity.Product;

public class ComponentMapper {
    public static Component map(CreateComponent createComponent, Product product){
        Component component = new Component();
        component.setName(createComponent.getName());
        component.setDescription(createComponent.getDescription());
        component.setProduct(product);
        return component;
    }
}
