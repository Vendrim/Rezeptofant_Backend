package rezeptofant.backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Java Class that will represent any ingredient, we can think of.
 */
@Getter
@Setter
@Entity
@Table(name = "ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "vegetarian")
    private boolean vegetarian;

    @Column(name = "lactose_tolerant")
    private boolean lactoseTolerant;

    @Column(name = "vegan")
    private boolean vegan;

    @Column(name = "gluten_free")
    private boolean glutenFree;

    public Ingredient updateValuesFromOtherIngredient(Ingredient ingredient) {
        setGlutenFree(ingredient.isGlutenFree());
        setLactoseTolerant(ingredient.isLactoseTolerant());
        setVegan(ingredient.isVegan());
        setVegetarian(ingredient.isVegetarian());
        return this;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(ToStringStyle.JSON_STYLE) //
                .appendSuper(super.toString()) //
                .append("id", id) //
                .append("vegetarian", vegetarian) //
                .append("lactoseTolerant", lactoseTolerant) //
                .append("vegan", vegan) //
                .append("glutenFree", glutenFree) //
                .toString();
    }
}
