package rezeptofant.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Getter
@Setter
@Table(name = "ingredient_amount")
public class IngredientAmount {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ingredient_id")
    private Long ingredientId;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "is_metric")
    private boolean isMetric;

    @Column(name = "is_fluid")
    private boolean isFluid;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE) //
                .appendSuper(super.toString()) //
                .append("id", id) //
                .append("ingredientId", ingredientId) //
                .append("amount", amount) //
                .append("isMetric", isMetric) //
                .append("isFluid", isFluid) //
                .toString();
    }
}
