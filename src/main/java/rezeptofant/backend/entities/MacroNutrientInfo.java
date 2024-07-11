package rezeptofant.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Getter
@Setter
@Table(name = "macro_nutrient_info")
public class MacroNutrientInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "calories")
    private Long calories;

    @Column(name = "protein")
    private Long protein;

    @Column(name = "carbs")
    private Long carbs;

    @Column(name = "fat")
    private Long fat;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE) //
                .appendSuper(super.toString()) //
                .append("id", id) //
                .append("calories", calories) //
                .append("protein", protein) //
                .append("carbs", carbs) //
                .append("fat", fat) //
                .toString();
    }
}
