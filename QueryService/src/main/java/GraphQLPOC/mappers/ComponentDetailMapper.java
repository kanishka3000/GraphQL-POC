package GraphQLPOC.mappers;

import GraphQLPOC.dto.ComponentDetail;
import GraphQLPOC.entity.Component;

public class ComponentDetailMapper {
    public static ComponentDetail map(Component component){
        ComponentDetail componentDetail = new ComponentDetail();
        componentDetail.setId(component.getId());
        componentDetail.setName(component.getName());
        componentDetail.setDescription(component.getDescription());
        return componentDetail;
    }
}
