package rezeptofant.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Getter
@Setter
@Table(name = "nutrient_extra_info")
public class NutrientExtraInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fiber")
    private Long fiber;

    @Column(name = "sugar")
    private Long sugar;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE) //
                .appendSuper(super.toString()) //
                .append("id", id) //
                .append("fiber", fiber) //
                .append("sugar", sugar) //
                .toString();
    }
}
