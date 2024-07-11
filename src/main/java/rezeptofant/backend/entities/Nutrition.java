package rezeptofant.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Getter
@Setter
@Table(name = "nutrition")
public class Nutrition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "macro_nutrient_id")
    private Long macroNutritionId;

    @Column(name = "extra_info_id")
    private Long extraInfoId;

    @Column(name = "vitamin_info_id")
    private Long vitaminInfoId;

    @Column(name = "micro_nutrient_info_id")
    private Long microNutrientInfoId;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE) //
                .appendSuper(super.toString()) //
                .append("id", id) //
                .append("macroNutritionId", macroNutritionId) //
                .append("extraInfoId", extraInfoId) //
                .append("vitaminInfoId", vitaminInfoId) //
                .append("microNutrientInfoId", microNutrientInfoId) //
                .toString();
    }
}
