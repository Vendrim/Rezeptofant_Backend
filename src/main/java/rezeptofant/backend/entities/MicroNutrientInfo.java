package rezeptofant.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Getter
@Setter
@Table(name = "micro_nutrient_info")
public class MicroNutrientInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "biotin")
    private Float biotin;

    @Column(name = "calcium")
    private Float calcium;

    @Column(name = "copper")
    private Float copper;

    @Column(name = "iron")
    private Float iron;

    @Column(name = "phosphorus")
    private Float phosphorus;

    @Column(name = "potassium")
    private Float potassium;

    @Column(name = "magnesium")
    private Float magnesium;

    @Column(name = "selenium")
    private Float selenium;

    @Column(name = "zinc")
    private Float zinc;


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE) //
                .appendSuper(super.toString()) //
                .append("id", id) //
                .append("biotin", biotin) //
                .append("calcium", calcium) //
                .append("copper", copper) //
                .append("iron", iron) //
                .append("phosphorus", phosphorus) //
                .append("potassium", potassium) //
                .append("magnesium", magnesium) //
                .append("selenium", selenium) //
                .append("zinc", zinc) //
                .toString();
    }
}
