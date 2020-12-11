package GraphQLPOC.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = Product.TABLE)
@SequenceGenerator(name = "productseq", sequenceName = "productseq", initialValue = 1, allocationSize = 1)
public class Product {
    public static final String TABLE = "Product";
    public static final String FIELD_ID = "id";
    public static final String FIELD_NAME = "name";
    public static final String FIELD_DESCRIPTION = "description";

    @Id
    @GeneratedValue(generator = "productseq")
    @Column(name = FIELD_ID)
    long id;

    @Column(name = FIELD_NAME)
    String name;

    @Column(name = FIELD_DESCRIPTION)
    String description;
}
