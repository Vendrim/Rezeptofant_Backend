package entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "calories", nullable = false)
    private Long calories;

    @Column(name = "proteins", nullable = false)
    private Long proteins;

    @Column(name = "fats", nullable = false)
    private Long fats;

    @Column(name = "carbs", nullable = false)
    private Long carbs;

    @Column(name = "vegetarian")
    private boolean vegetarian;

    @Column(name = "lactose_tolerant")
    private boolean lactoseTolerant;

    @Column(name = "vegan")
    private boolean vegan;

    @Column(name = "gluten_free")
    private boolean glutenFree;

}
