package rezeptofant.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Getter
@Setter
@Table(name = "vitamin_info")
public class VitaminInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "vitamin_A")
    private Float vitaminA;

    @Column(name = "vitamin_B2")
    private Float vitaminB2;

    @Column(name = "vitamin_B3")
    private Float vitaminB3;

    @Column(name = "vitamin_B5")
    private Float vitaminB5;

    @Column(name = "vitamin_B6")
    private Float vitaminB6;

    @Column(name = "vitamin_B12")
    private Float vitaminB12;

    @Column(name = "vitamin_D")
    private Float vitaminD;

    @Column(name = "vitamin_E")
    private Float vitaminE;

    @Column(name = "vitamin_K")
    private Float vitaminK;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE) //
                .appendSuper(super.toString()) //
                .append("id", id) //
                .append("vitaminA", vitaminA) //
                .append("vitaminB2", vitaminB2) //
                .append("vitaminB3", vitaminB3) //
                .append("vitaminB5", vitaminB5) //
                .append("vitaminB6", vitaminB6) //
                .append("vitaminB12", vitaminB12) //
                .append("vitaminD", vitaminD) //
                .append("vitaminE", vitaminE) //
                .append("vitaminK", vitaminK) //
                .toString();
    }
}
